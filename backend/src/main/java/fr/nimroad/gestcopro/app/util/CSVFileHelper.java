package fr.nimroad.gestcopro.app.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import lombok.Cleanup;
import lombok.SneakyThrows;

public enum CSVFileHelper {

	INSTANCE;

	public String getResourcePath(String fileName) {
		final File f = new File("");
		final String dossierPath = f.getAbsolutePath() + File.separator + fileName;
		return dossierPath;
	}

	public File getResource(String fileName) {
		final String completeFileName = getResourcePath(fileName);
		File file = new File(completeFileName);
		return file;
	}

	public File getFileSystem(String fileName){
		return new File(fileName);
	}
	
	@SneakyThrows
	public List<String> readFile(File file) {

		List<String> result = new ArrayList<String>();

		@Cleanup FileReader fr = new FileReader(file);
		@Cleanup BufferedReader br = new BufferedReader(fr);

		for (String line = br.readLine(); line != null; line = br.readLine()) {
			result.add(line);
		}

		return result;
	}
}
