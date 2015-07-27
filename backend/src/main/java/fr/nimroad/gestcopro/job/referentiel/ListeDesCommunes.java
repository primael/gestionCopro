package fr.nimroad.gestcopro.job.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import lombok.extern.log4j.Log4j2;
import fr.nimroad.gestcopro.app.model.dao.CommuneDao;
import fr.nimroad.gestcopro.app.model.entite.Commune;
import fr.nimroad.gestcopro.job.referentiel.communes.csv.ArrondissementFileCsv;
import fr.nimroad.gestcopro.job.referentiel.communes.csv.CodePostalFileCsv;
import fr.nimroad.gestcopro.job.referentiel.communes.csv.InseeFileCsv;
import fr.nimroad.gestcopro.job.referentiel.communes.csv.VilleArrondissement;
import fr.nimroad.gestcopro.job.referentiel.communes.csv.VilleCodePostal;
import fr.nimroad.gestcopro.job.referentiel.communes.csv.VilleInsee;

@Log4j2
public class ListeDesCommunes {
	
	private CommuneDao communeDao = CommuneDao.getInstance();
	
	public void compute(){
		log.info("lancement de la tâche de récupération des communes");
		InseeFileCsv inseeFileCsv = new InseeFileCsv("D:\\Users\\Primael\\Downloads\\comsimp2015.txt");
		//InseeFileCsv inseeFileCsv = new InseeFileCsv("D:\\Users\\Primael\\Downloads\\france2015.txt");
		SortedMap<String, VilleInsee> resultInsee = inseeFileCsv.compute();
		log.debug("nombre de ville insee récupérées: " + resultInsee.size());
		
		CodePostalFileCsv codePostalFileCsv = new CodePostalFileCsv("D:\\Users\\Primael\\Downloads\\code_postaux_v201410.csv");
		SortedMap<String, VilleCodePostal> resultCodePostal = codePostalFileCsv.compute();
		log.debug("nombre de ville codepostal récupérées: " + resultCodePostal.size());
		
		List<Commune> communes = this.computeCommune(resultInsee, resultCodePostal);
		
		for(Commune commune : communes){
			communeDao.save(commune);
		}
		
		log.info("fin de la tâche de récupération des communes");
	}
	
	private List<Commune> computeCommune(SortedMap<String, VilleInsee> listInsee, SortedMap<String, VilleCodePostal> listCodePostal){
	
		List<Commune> communes = new ArrayList<Commune>();
		SortedMap<String, VilleCodePostal> noComputed = new TreeMap<String, VilleCodePostal>();
		
		//Pour chaque ville code postal on cherche son nom
		for(VilleCodePostal villeCodePostal : listCodePostal.values()){
			
			//On cherche la ville Insee lui correspondant
			VilleInsee villeInsee = listInsee.get(villeCodePostal.getCodeInsee());
			
			if(villeInsee!=null){
				Commune commune = new Commune();
				commune.setArticle(villeInsee.getArticle());
				commune.setCodeInsee(villeInsee.getCodeInsee());
				commune.setCodePostal(villeCodePostal.getCodePostal());
				commune.setLibelleRecherche(villeInsee.getNomMajuscule());
				commune.setNom(villeInsee.getNom());
				
				communes.add(commune);
			} else {
				noComputed.put(villeCodePostal.getCodeInsee(), villeCodePostal);
			}
		}
		
		//Pour chaque ville Insee on cherche son code postal
		for(VilleInsee villeInsee : listInsee.values()){
			
			VilleCodePostal villeCodePostal = listCodePostal.get(villeInsee.getCodeInsee());
			
			if(villeCodePostal==null){
				log.error("Ville " + villeInsee + " aucune correspondance trouvée");
			}
		}
		
		List<Commune> communesToAdd = this.nonComputedCommune(noComputed, listInsee);
		
		if(communesToAdd!=null)
			communes.addAll(communesToAdd);
		
		log.info("Le nombre de communes retrouvées est de : " + communes.size());
		
		log.info("Le nombre de communes non intégrées est de : " + noComputed.size());
		
		return communes;
	}
	
	private List<Commune> nonComputedCommune(SortedMap<String, VilleCodePostal> nonComputed, SortedMap<String, VilleInsee> listInsee){
		
		//Gestion des arrondissements
		
		ArrondissementFileCsv arrondissementFileCsv = new ArrondissementFileCsv("D:\\Users\\Primael\\Downloads\\table-appartenance-geo-communes-14.csv");
		SortedMap<String, VilleArrondissement> resultArrondissement = arrondissementFileCsv.compute();
		
		List<Commune> communes = new ArrayList<Commune>();
		
		//Pour chaque ville code postal on cherche son nom
		for(VilleCodePostal villeCodePostal : nonComputed.values()){
			
			//On cherche la ville Arrondissement lui correspondant
			VilleArrondissement villeArrondissement = resultArrondissement.get(villeCodePostal.getCodeInsee());
			
			if(villeArrondissement!=null){
				VilleInsee villeInsee = listInsee.get(villeArrondissement.getCodeInseeMere());
				Commune commune = new Commune();
				commune.setArticle(villeInsee.getArticle());
				commune.setCodeInsee(villeArrondissement.getCodeInsee());
				commune.setCodePostal(villeCodePostal.getCodePostal());
				commune.setLibelleRecherche(villeInsee.getNomMajuscule());
				commune.setNom(villeArrondissement.getNom());
				
				communes.add(commune);
			} 
		}
		return communes;
	}
	
	public static void main(String[] args) {
		new ListeDesCommunes().compute();
	}
}
