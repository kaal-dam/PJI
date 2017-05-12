package csvManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVManager {

	protected final File dropins = new File("data/data.csv");
	private final char DEFAULT_SEPARATOR = ',';
	private final char END_LINE = '\n';

	public CSVManager() {
		try {
			dropins.createNewFile();
			BufferedReader br;
			br = new BufferedReader(new FileReader(dropins));
			if (br.readLine() == null) {
				List <String> l = new ArrayList<>();
				l.add("code_shape");
				l.add("code_color");
				l.add("code_value");
				l.add("code_police");
				l.add("nbTrun");
				l.add("rules_left");
				write(l);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}     

	}

	public void write(List<String>l){
		StringBuilder sb = new StringBuilder();
		boolean firstEntry = true;
		try {
			FileWriter fw = new FileWriter(dropins,true);
			for (String string : l) {
				if(!firstEntry){
					sb.append(DEFAULT_SEPARATOR);
				}
				sb.append(followCVSformat(string));
				firstEntry = false;
			}
			sb.append(END_LINE);	
			fw.write(sb.toString());
			fw.flush();
			fw.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

	private String followCVSformat(String value) {

		String result = value;
		if (result.contains("\"")) {
			result = result.replace("\"", "\"\"");
		}
		return result;

	}

}
