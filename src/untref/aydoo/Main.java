package untref.aydoo;

import java.io.File;

import org.apache.log4j.Logger;

public class Main {

	private static Logger logger = Logger.getLogger("log");

	public static void main(String[] args) {
		if (args.length == 0) {
			logger.fatal("Debe especificar la ruta del directorio fuente.");
			return;
		}

		File inputDir = new File(args[0]);

		if (!inputDir.exists()) {
			logger.fatal("La ruta proporcionada no existe.");
			return;
		}
		if (!inputDir.isDirectory()) {
			logger.fatal("La ruta proporcionada no corresponde a un directorio.");
			return;
		}

		new OnDemandRunner(inputDir.getAbsolutePath());
	}

}
