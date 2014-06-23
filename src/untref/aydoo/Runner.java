package untref.aydoo;

import org.apache.log4j.Logger;

public abstract class Runner {

	protected Logger logger = Logger.getLogger("log");
	protected String inputDir;

	public Runner(String inputDir) {
		this.inputDir = inputDir;
	}

	public abstract void doIt();

	public static Runner getRunner(RuntimeMode mode, String directory) {
		if (mode == RuntimeMode.DAEMON) {
			return new DaemonRunner(directory);
		} else {
			return new OnDemandRunner(directory);
		}
	}

}