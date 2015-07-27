package fr.nimroad.gestcopro.job.referentiel.communes.csv;

import java.io.File;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import fr.nimroad.gestcopro.app.util.CSVFileHelper;
import fr.nimroad.gestcopro.app.util.CsvDataFile;
import fr.nimroad.gestcopro.app.util.CsvFile;

public class ArrondissementFileCsv {

	private File file;
	
	public ArrondissementFileCsv(String nomFile) {
		this.file = CSVFileHelper.INSTANCE.getFileSystem(nomFile);
	}
	
	public SortedMap<String, VilleArrondissement> compute(){
		
		final CsvFile csvFile = new CsvDataFile(file);
		final List<String[]> data = csvFile.getData();
		
		SortedMap<String, VilleArrondissement> villesArrondissement = new TreeMap<String, VilleArrondissement>();
		
		for(String[] oneData : data){
			String codeInsee = oneData[0];
			VilleArrondissement villeArrondissement = new VilleArrondissement();
			villeArrondissement.setCodeInsee(codeInsee);
			villeArrondissement.setCodeInseeMere(oneData[2]);
			villeArrondissement.setNom(oneData[1]);
			
			villesArrondissement.put(codeInsee, villeArrondissement);
		}
		
		return villesArrondissement;
	}
}
