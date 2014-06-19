package untref.aydoo;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class DescrompresorTest {

	private static final String ARCHIVO_ENTRADA = "testResources/test.zip";
	private static final String CARPETA_SALIDA = "testResources/test";

	@After
	public void tearDown() throws Exception {
		File carpetaSalida = new File(CARPETA_SALIDA);

		if (carpetaSalida.exists()) {
			File[] archivos = carpetaSalida.listFiles();
			for (File archivo : archivos) {
				archivo.delete();
			}
			carpetaSalida.delete();
		}
	}

	@Test
	public void descomprimirUnArchivoDeberiaCrearUnaCarpetaConElMismoNombreDelArchivo() {
		Descompresor descompresor = new Descompresor();

		String pathCarpetaSalida = descompresor.extraer(ARCHIVO_ENTRADA);

		File carpetaSalida = new File(CARPETA_SALIDA);
		
		Assert.assertEquals(CARPETA_SALIDA, pathCarpetaSalida);
		Assert.assertTrue(carpetaSalida.exists());
		
	}

}
