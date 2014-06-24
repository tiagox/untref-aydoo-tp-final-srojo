package untref.aydoo.files;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class CsvReader {

	private Logger logger = Logger.getLogger("log");
	private BufferedReader reader;

	public CsvReader(String inputFile) {
		openFile(inputFile);
	}

	private void openFile(String inputFile) {
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(inputFile)));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
	}

	public String readLine() {
		String line = null;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return line;
	}

	@Override
	protected void finalize() throws Throwable {
		reader.close();
		super.finalize();
	}

}
