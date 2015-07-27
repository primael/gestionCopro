package fr.nimroad.gestcopro.app.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import fr.nimroad.gestcopro.app.util.CSVFileHelper;

public class CsvTabFile implements CsvFile {

	public final static char SEPARATOR = '\t';
	@Getter
	private File file;
	@Getter
	private List<String> lines;
	@Getter
	private List<String[]> data;
	
	public CsvTabFile(File file) {
		this.file = file;
		this.init();
	}
	
	private void init(){
		this.lines = CSVFileHelper.INSTANCE.readFile(file);
		
		data = new ArrayList<String[]>(lines.size());
		String separator = new Character(SEPARATOR).toString();
		
		for(String line : lines){
			String[] oneData = line.split(separator);
			data.add(oneData);
		}
		
	}
}
