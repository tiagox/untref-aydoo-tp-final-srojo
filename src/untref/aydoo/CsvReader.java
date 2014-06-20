package untref.aydoo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class CsvReader {

	private BufferedReader reader;

	public CsvReader(String inputFile) {
		openFile(inputFile);
	}

	private void openFile(String inputFile) {
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(inputFile)));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public String readLine() {
		String line = null;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return line;
	}

	@Override
	protected void finalize() throws Throwable {
		reader.close();
		super.finalize();
	}

}
