package untref.aydoo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

	private String inputFile;

	public CsvReader(String inputFile) {
		this.inputFile = inputFile;
	}

	public List<String> getRegisters() {
		List<String> registers = new ArrayList<String>();
		String line;
		try {
			InputStream fis = new FileInputStream(inputFile);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			
			while ((line = br.readLine()) != null) {
				registers.add(line);
			}

			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return registers;
	}

}
