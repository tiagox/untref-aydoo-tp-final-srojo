package untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class RunnerTest {

	@Test
	public void siElModoEsDaemonElRunnerTambien() {
		RuntimeMode mode = RuntimeMode.DAEMON;
		String directory = "resourcesTests";

		Runner daemondRunner = Runner.getRunner(mode, directory);

		Assert.assertTrue(daemondRunner instanceof DaemonRunner);
	}

	@Test
	public void siElModoEsOnDemandElRunnerTambien() {
		RuntimeMode mode = RuntimeMode.ONDEMAND;
		String directory = "resourcesTests";

		Runner onDemandRunner = Runner.getRunner(mode, directory);

		Assert.assertTrue(onDemandRunner instanceof OnDemandRunner);
	}

}
