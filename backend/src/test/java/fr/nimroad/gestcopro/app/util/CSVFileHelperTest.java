package fr.nimroad.gestcopro.app.util;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class CSVFileHelperTest {

	private final static String FILE_NAME = "src/test/resources/codePostaux.csv";
	
	@Test
	public void testGetResource(){
		final String fileName = FILE_NAME;
		
		final File file = CSVFileHelper.INSTANCE.getResource(fileName);
		
		Assert.assertTrue(file.exists());
	}
	
	@Test
	public void testReadFile(){
		final String fileName = FILE_NAME;
		
		final int nombreLigne = 39806;
		
		final File file = CSVFileHelper.INSTANCE.getResource(fileName);
		List<String> lines = CSVFileHelper.INSTANCE.readFile(file);
		
		Assert.assertEquals(nombreLigne, lines.size());
	}
}
