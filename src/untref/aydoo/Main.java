package untref.aydoo;

import org.apache.log4j.Logger;

public class Main {

	private static Logger logger = Logger.getLogger("log");

	public static void main(String[] args) {
		try {
			ArgsParser arguments = new ArgsParser(args);
			
			Runner.getRunner(arguments.getRuntimeMode(), arguments.getDirectoryPath()).doIt();
		} catch (ArgumentsException e) {
			logger.fatal(e.getMessage());
		}

	}

}
