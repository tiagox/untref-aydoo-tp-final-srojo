package untref.aydoo;

import java.io.File;

public class ArgsParser {

	private RuntimeMode runtimeMode;
	private String directoryPath;

	public ArgsParser(String[] args) throws ArgumentsException {
		if (args.length == 0) {
			throw new ArgumentsException("Debe especificar la ruta del directorio fuente.");
		}
		
		runtimeMode = (args[0].equals("-d")) ? RuntimeMode.DAEMON
				: RuntimeMode.ONDEMAND;
		directoryPath = (args[0].equals("-d")) ? args[1] : args[0];
		
		checkDirectory();
	}

	private void checkDirectory() throws ArgumentsException {
		File inputDir = new File(directoryPath);
		
		if (!inputDir.exists()) {
			throw new ArgumentsException("La ruta proporcionada no existe.");
		}
		if (!inputDir.isDirectory()) {
			throw new ArgumentsException("La ruta proporcionada no corresponde a un directorio.");
		}
	}

	public RuntimeMode getRuntimeMode() {
		return runtimeMode;
	}

	public String getDirectoryPath() {
		return directoryPath;
	}

}
