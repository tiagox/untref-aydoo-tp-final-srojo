package untref.aydoo.files;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.files.ZipExtractor;

public class ZipExtractorTest {

	private static final String INPUT_FILE = "resourcesTests/test.zip";
	private static final String OUTPUT_DIR = "resourcesTests/test";

	@After
	public void tearDown() throws Exception {
		File carpetaSalida = new File(OUTPUT_DIR);
		if (carpetaSalida.exists()) {
			for (File archivo : carpetaSalida.listFiles()) {
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
