package fr.nimroad.gestcopro.job.referentiel.communes.csv;

import java.io.File;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import fr.nimroad.gestcopro.app.util.CSVFileHelper;
import fr.nimroad.gestcopro.app.util.CsvFile;
import fr.nimroad.gestcopro.app.util.CsvTabFile;

public class InseeFileCsv {

	private File file;
	
	public InseeFileCsv(String nomFile) {
		this.file = CSVFileHelper.INSTANCE.getFileSystem(nomFile);
	}
	
	public SortedMap<String, VilleInsee> compute(){
		
		final CsvFile csvFile = new CsvTabFile(file);
		final List<String[]> data = csvFile.getData();
		
		SortedMap<String, VilleInsee> villesInsee = new TreeMap<String, VilleInsee>();
		
		for(String[] oneData : data){
			String codeInsee = oneData[3] + oneData[4];
			VilleInsee villeInsee = new VilleInsee();
			villeInsee.setArticle(oneData[10]);
			villeInsee.setArticleMajuscule(oneData[8]);
			villeInsee.setCodeInsee(codeInsee);
			villeInsee.setNom(oneData[11]);
			villeInsee.setNomMajuscule(oneData[9]);
			
			villesInsee.put(codeInsee, villeInsee);
		}
		
		return villesInsee;
	}
}
