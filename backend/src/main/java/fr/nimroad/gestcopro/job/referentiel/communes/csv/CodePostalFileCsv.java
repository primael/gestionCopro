package fr.nimroad.gestcopro.job.referentiel.communes.csv;

import java.io.File;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import fr.nimroad.gestcopro.app.util.CSVFileHelper;
import fr.nimroad.gestcopro.app.util.CsvDataFile;
import fr.nimroad.gestcopro.app.util.CsvFile;

public class CodePostalFileCsv {
	
	private File file;
	
	public CodePostalFileCsv(String nomFile) {
		this.file = CSVFileHelper.INSTANCE.getFileSystem(nomFile);
	}
	
	public SortedMap<String, VilleCodePostal> compute(){
		
		final CsvFile csvFile = new CsvDataFile(file);
		final List<String[]> data = csvFile.getData();
		
		SortedMap<String, VilleCodePostal> villesCodePostal = new TreeMap<String, VilleCodePostal>();
		
		for(String[] oneData : data){
			String codeInsee = oneData[0];
			VilleCodePostal villeCodePostal = new VilleCodePostal();
			villeCodePostal.setCodeInsee(codeInsee);
			villeCodePostal.setCodePostal(oneData[2]);
			villeCodePostal.setNom(oneData[1]);
			
			villesCodePostal.put(codeInsee, villeCodePostal);
		}
		
		return villesCodePostal;
	}
}
