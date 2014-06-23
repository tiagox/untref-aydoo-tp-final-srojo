package untref.aydoo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class OnDemandRunner {

	Logger logger = Logger.getLogger("log");

	public OnDemandRunner(String inputDir) {
		logger.setLevel(Level.ALL);

		FileManager manager = new FileManager();
		StatsCalculator calculador = new StatsCalculator();
		List<Thread> threads = new ArrayList<Thread>();
		String yamlPath = inputDir + File.separator + "output.yml";

		for (String csvFile : manager.prepareFiles(inputDir)) {
			Processor processor = new Processor(calculador, csvFile);
			Thread thread = new Thread(processor);
			threads.add(thread);
			thread.start();
		}

		joinAllThreads(threads);
		
		calculador.exportYaml(yamlPath);
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
