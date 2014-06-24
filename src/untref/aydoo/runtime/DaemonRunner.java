package untref.aydoo.runtime;

import java.io.File;
import java.util.List;

import untref.aydoo.files.FileManager;

public class DaemonRunner extends Runner {

	private File inProcessDir;
	private FileManager manager;

	public DaemonRunner(String inputDir) {
		super(inputDir);
		this.manager = new FileManager();

		logger.info("Ejecutandose en modo 'daemon'.");
	}

	public void doIt() {
		List<String> zipList;

		inProcessDir = manager.createSubDir(inputDir, "inprocess");

		while (true) {
			zipList = manager.getFilesByExtension(inputDir, "zip");

			for (String zipFilePath : zipList) {
				prepareThread(zipFilePath);
			}

			waitASecond();
		}
	}

	private void prepareThread(String zipFilePath) {
		File zipFile = new File(zipFilePath);
		File newZipFile = manager.moveFileTo(zipFile, inProcessDir);
		
		logger.info("Se lanza un nuevo hilo para procesar el archivo: '" + zipFile.getAbsolutePath() + "'");
		
		DaemonThread daemonThread = new DaemonThread(inputDir, newZipFile.getAbsolutePath());
		Thread thread = new Thread(daemonThread);
		thread.start();
	}

	private void waitASecond() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			logger.error(e.getMessage());
		}
	}

}
