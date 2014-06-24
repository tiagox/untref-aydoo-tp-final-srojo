package untref.aydoo.runtime;

import org.junit.Assert;
import org.junit.Test;

public class DaemonRunnerTest {

	@Test
	public void queExiste() {
		DaemonRunner runner = new DaemonRunner("");
		
		Assert.assertNotNull(runner);
	}

}
