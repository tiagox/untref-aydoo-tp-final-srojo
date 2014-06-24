package untref.aydoo.runtime;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import untref.aydoo.domain.StatsCalculator;
import untref.aydoo.files.FileManager;

public class OnDemandRunner extends Runner {

	public OnDemandRunner(String inputDir) {
		super(inputDir);
		
		logger.info("Ejecutandose en modo 'on demand'.");
	}

	public void doIt() {
		FileManager manager = new FileManager();
		StatsCalculator calculador = new StatsCalculator();
		List<Thread> threads = new ArrayList<Thread>();
		String yamlPath = inputDir + File.separator + "output.yml";

		List<String> zipList = manager.getFilesByExtension(inputDir, "zip");
		
		logger.info("Se encontraron " + zipList.size() + " archivos en formato 'zip'.");
		
		String dirToProcess = manager.prepareFiles(inputDir, zipList);

		for (String csvFile : manager.getFilesByExtension(dirToProcess, "csv")) {
			Processor processor = new Processor(calculador, csvFile);
			Thread thread = new Thread(processor);
			threads.add(thread);
			thread.start();
		}

		joinAllThreads(threads);
		
		calculador.exportYaml(yamlPath);
		
		logger.info("Se ha generado el archivo '" + yamlPath + "'");

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

}
