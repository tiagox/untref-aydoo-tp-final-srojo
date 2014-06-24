package untref.aydoo.runtime;

import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.runtime.DaemonRunner;
import untref.aydoo.runtime.OnDemandRunner;
import untref.aydoo.runtime.Runner;
import untref.aydoo.runtime.RuntimeMode;

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
