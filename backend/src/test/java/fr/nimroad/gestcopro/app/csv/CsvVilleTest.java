package fr.nimroad.gestcopro.app.csv;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.nimroad.gestcopro.app.util.CSVFileHelper;
import fr.nimroad.gestcopro.app.util.CsvFile;
import fr.nimroad.gestcopro.app.util.CsvTabFile;

public class CsvVilleTest {
	private final static String FILE_NAME = "src/test/resources/comsimp2015.txt";
	private static File FILE;
	
	@BeforeClass
	public static void beforeClass(){
		FILE = CSVFileHelper.INSTANCE.getResource(FILE_NAME);
	}
	
	@Test
	public void testFile(){
		final CsvFile csvFile = new CsvTabFile(FILE);
		final File file = csvFile.getFile();
		
		Assert.assertEquals(file, CsvVilleTest.FILE);
	}

	@Test
	public void testCsvFile(){
		final int nombreLigne = 36659;
		
		final CsvTabFile csvFileCommune = new CsvTabFile(CsvVilleTest.FILE);
		final List<String> lines = csvFileCommune.getLines();
		Assert.assertEquals(nombreLigne, lines.size());
	}
	
	@Test
	public void testData(){
		final int nombreLigne = 36659;
		final int nombreColonnes = 12;
		
		final CsvFile csvFile = new CsvTabFile(FILE);
		final List<String[]> data = csvFile.getData();
		
		Assert.assertEquals(nombreLigne, data.size());
		
		for(String[] oneData : data){
			Assert.assertEquals(nombreColonnes, oneData.length);
		}
	}
}
