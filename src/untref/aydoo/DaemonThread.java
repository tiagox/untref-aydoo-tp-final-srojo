package untref.aydoo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class DaemonThread implements Runnable {

	protected Logger logger = Logger.getLogger("log");
	private String inputDirPath;
	private String zipFilePath;
	private File processedDir;

	public DaemonThread(String inputDirPath, String zipFilePath) {
		this.inputDirPath = inputDirPath;
		this.zipFilePath = zipFilePath;
	}

	@Override
	public void run() {
		FileManager manager = new FileManager();
		StatsCalculator calculador = new StatsCalculator();
		List<Thread> threads = new ArrayList<Thread>();

		processedDir = manager.createSubDir(inputDirPath, "processed");

		List<String> zipList = new ArrayList<String>();
		zipList.add(zipFilePath);

		String dirToProcess = manager.prepareFiles(inputDirPath, zipList);

		for (String csvFile : manager.getFilesByExtension(dirToProcess, "csv")) {
			Processor processor = new Processor(calculador, csvFile);
			Thread thread = new Thread(processor);
			threads.add(thread);
			thread.start();
		}

		joinAllThreads(threads);

		calculador.exportYaml(getYamlFilePath());

		logger.info("Se ha generado el archivo '" + getYamlFilePath() + "'");

		manager.moveFileTo(new File(zipFilePath), processedDir);
		
		manager.clean(dirToProcess);
		
	}

	private void joinAllThreads(List<Thread> threads) {
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
			}
		}
	}

	private String getYamlFilePath() {
		File zipFile = new File(zipFilePath);
		String zipFileName = zipFile.getName().substring(0,
				zipFile.getName().lastIndexOf("."));
		String yamlPath = inputDirPath + File.separator + zipFileName + ".yml";
		return yamlPath;
	}

}
