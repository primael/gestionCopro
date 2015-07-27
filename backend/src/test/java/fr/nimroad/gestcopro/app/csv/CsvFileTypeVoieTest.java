package fr.nimroad.gestcopro.app.csv;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.nimroad.gestcopro.app.util.CSVFileHelper;
import fr.nimroad.gestcopro.app.util.CsvDataFile;
import fr.nimroad.gestcopro.app.util.CsvFile;

public class CsvFileTypeVoieTest {

	private final static String FILE_NAME = "src/test/resources/typeVoie.csv";
	private static File FILE;
	
	@BeforeClass
	public static void beforeClass(){
		FILE = CSVFileHelper.INSTANCE.getResource(FILE_NAME);
	}
	
	@Test
	public void testFile(){
		final CsvFile csvFile = new CsvDataFile(FILE);
		final File file = csvFile.getFile();
		
		Assert.assertEquals(file, CsvFileTypeVoieTest.FILE);
	}

	@Test
	public void testCsvFile(){
		final int nombreLigne = 43;
		
		final CsvDataFile csvFileCommune = new CsvDataFile(CsvFileTypeVoieTest.FILE);
		final List<String> lines = csvFileCommune.getLines();
		Assert.assertEquals(nombreLigne, lines.size());
	}
	
	@Test
	public void testData(){
		final int nombreLigne = 43;
		final int nombreColonnes = 2;
		
		final CsvFile csvFile = new CsvDataFile(FILE);
		final List<String[]> data = csvFile.getData();
		
		Assert.assertEquals(nombreLigne, data.size());
		
		for(String[] oneData : data){
			Assert.assertEquals(nombreColonnes, oneData.length);
		}
	}
}
