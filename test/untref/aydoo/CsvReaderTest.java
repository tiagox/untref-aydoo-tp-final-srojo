package untref.aydoo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CsvReaderTest {

	private final static String INPUT_FILE = "testResources/recorridos.csv";

	@Test
	public void test() {
		CsvReader csvReader = new CsvReader(INPUT_FILE);

		List<String> registers = csvReader.getRegisters();

		List<String> registersExpected = new ArrayList<String>();
		registersExpected
				.add("1036;403;2010-12-30 19:39:03;6;DERECHO;2010-12-30 19:46:03;3;RETIRO;7");
		registersExpected
				.add("2722;443;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;13");
		registersExpected
				.add("1585;393;2010-12-30 19:10:21;7;PLAZA ROMA;2010-12-30 19:17:44;3;RETIRO;7");
		
		Assert.assertEquals(registersExpected, registers);
	}
}
