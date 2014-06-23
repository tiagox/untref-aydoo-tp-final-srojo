package untref.aydoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class DirManagerTest {

	private static final String TEST_DIR_EXISTS = "resourcesTests/testExists";
	private static final String CSV_EXT = "CSV";
	private static final String TEST_DIR_NOT_EXISTS = "resourcesTests/testNotExists";

	@Test
	public void dadoUnDirectorioYUnaExtensionDeberiaDevolverLaListaDeArchivosValidos() {
		DirManager monitor = new DirManager();

		List<String> files = monitor.getFilesByExtension(TEST_DIR_EXISTS,
				CSV_EXT);
		Collections.sort(files);

		List<String> filesExpected = new ArrayList<String>();
		filesExpected.add("resourcesTests/testExists/recorridos1.csv");
		filesExpected.add("resourcesTests/testExists/recorridos2.csv");
		filesExpected.add("resourcesTests/testExists/recorridos3.csv");
		filesExpected.add("resourcesTests/testExists/recorridos4.csv");
		Collections.sort(filesExpected);

		Assert.assertEquals(filesExpected, files);
	}

	@Test
	public void dadoUnDirectorioYUnaExtensionDeberiaDevolverUnaListaVaciaSiNoHayArchivosDeDichaExtension() {
		DirManager monitor = new DirManager();

		List<String> files = monitor
				.getFilesByExtension(TEST_DIR_EXISTS, "pdf");

		List<String> filesExpected = new ArrayList<String>();

		Assert.assertEquals(filesExpected, files);
	}

	@Test
	public void dadoUnDirectorioInexistenteDeberiaDevolverNull() {
		DirManager monitor = new DirManager();

		List<String> files = monitor.getFilesByExtension(TEST_DIR_NOT_EXISTS,
				CSV_EXT);

		Assert.assertNull(files);
	}

}
