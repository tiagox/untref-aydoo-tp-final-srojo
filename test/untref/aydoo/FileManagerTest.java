package untref.aydoo;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class FileManagerTest {

	private static final String INPUT_DIR = "resourcesTests/dirWithZips";

	@After
	public void tearDown() throws Exception {
		File dir = new File(INPUT_DIR);
		for (File eachDir : dir.listFiles()) {
			if (eachDir.exists() && eachDir.isDirectory()) {
				for (File file : eachDir.listFiles()) {
					file.delete();
				}
				eachDir.delete();
			}
		}
	}

	@Test
	public void test() {
		FileManager fileManager = new FileManager();

		int cantidadArchivosEsperados = 5;

		List<String> csvList = fileManager.prepareFiles(INPUT_DIR);

		Assert.assertEquals(cantidadArchivosEsperados, csvList.size());

		File file;
		for (String csvPath : csvList) {
			file = new File(csvPath);
			Assert.assertTrue(file.exists());
			Assert.assertTrue(file.getName().toLowerCase().endsWith(".csv"));
		}
	}

}
