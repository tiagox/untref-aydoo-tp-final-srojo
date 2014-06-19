package untref.aydoo;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class Descompresor {

	public String extraer(String archivoZip) {
		String carpetaSalida = getNombreCarpetaDesdeArchivo(archivoZip);

		try {
			ZipFile zipFile = new ZipFile(archivoZip);
			zipFile.extractAll(carpetaSalida);
		} catch (ZipException e) {
			e.printStackTrace();
		}

		return carpetaSalida;
	}

	private String getNombreCarpetaDesdeArchivo(String archivoZip) {
		return archivoZip.substring(0, archivoZip.lastIndexOf('.'));
	}

}
