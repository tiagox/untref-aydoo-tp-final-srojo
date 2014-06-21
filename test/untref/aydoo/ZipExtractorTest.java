package untref.aydoo;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class ZipExtractorTest {

	private static final String INPUT_FILE = "testResources/test.zip";
	private static final String OUTPUT_DIR = "testResources/test";

	@After
	public void tearDown() throws Exception {
		File carpetaSalida = new File(OUTPUT_DIR);

		if (carpetaSalida.exists()) {
			File[] archivos = carpetaSalida.listFiles();
			for (File archivo : archivos) {
				archivo.delete();
			}
			carpetaSalida.delete();
		}
	}

	@Test
	public void extraerUnZipDeberiaCrearUnaCarpetaConTodosLosArchivosComprimidos() {
		ZipExtractor descompresor = new ZipExtractor();

		List<String> fileList = descompresor.extract(INPUT_FILE, OUTPUT_DIR);

		File outputDir = new File(OUTPUT_DIR);
		Assert.assertTrue(outputDir.exists());

		Assert.assertEquals(4, fileList.size());
	}

}
