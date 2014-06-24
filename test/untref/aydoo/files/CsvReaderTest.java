package untref.aydoo.files;

import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.files.CsvReader;

public class CsvReaderTest {

	private final static String INPUT_FILE = "resourcesTests/recorridos.csv";

	@Test
	public void leerUnaLineaDeveriaDevolverSoloUnaLinea() {
		CsvReader csvReader = new CsvReader(INPUT_FILE);
		String expectedLine = "1036;403;2010-12-30 19:39:03;6;DERECHO;2010-12-30 19:46:03;3;RETIRO;7";

		String line = csvReader.readLine();

		Assert.assertEquals(expectedLine, line);
	}

	@Test
	public void leerDosVecesUnaLineaDeveriaDevolverLaSegundaLinea() {
		CsvReader csvReader = new CsvReader(INPUT_FILE);
		String expectedLine = "2722;443;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;13";

		String line = csvReader.readLine();
		line = csvReader.readLine();

		Assert.assertEquals(expectedLine, line);
	}

	@Test
	public void leerMasAllaDeLaUltimaLineaDeberiaDevolverNull() {
		CsvReader csvReader = new CsvReader(INPUT_FILE);

		String line = csvReader.readLine();
		line = csvReader.readLine();
		line = csvReader.readLine();
		line = csvReader.readLine();

		Assert.assertNull(line);
	}

}
