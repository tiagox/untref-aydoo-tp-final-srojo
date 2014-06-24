package untref.aydoo.cli;

import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.cli.ArgsParser;
import untref.aydoo.exceptions.ArgumentsException;
import untref.aydoo.runtime.RuntimeMode;

public class ArgsParserTest {

	@Test
	public void dadoUnArrayDeArgsDeberiaPoderIdentificarSiDeberaCorrerComoDaemon()
			throws ArgumentsException {
		String path = "resourcesTests/testExists";
		String[] args = { "-d", path };

		ArgsParser argsParser = new ArgsParser(args);

		Assert.assertEquals(RuntimeMode.DAEMON, argsParser.getRuntimeMode());
		Assert.assertEquals(path, argsParser.getDirectoryPath());
	}

	@Test
	public void dadoUnArrayDeArgsDeberiaPoderIdentificarSiDeberaCorrerComoOnDemand()
			throws ArgumentsException {
		String path = "resourcesTests/testExists";
		String[] args = { path };

		ArgsParser argsParser = new ArgsParser(args);

		Assert.assertEquals(RuntimeMode.ONDEMAND, argsParser.getRuntimeMode());
		Assert.assertEquals(path, argsParser.getDirectoryPath());
	}

	@Test(expected = ArgumentsException.class)
	public void dadoUnArrayVacioDeberiaLanzarUnaExcepcion()
			throws ArgumentsException {
		String[] args = {};

		new ArgsParser(args);
	}

	@Test(expected = ArgumentsException.class)
	public void dadoUnArrayConUnArchivosEnLugarDeDirectorioDeberiaLanzarUnaExcepcion()
			throws ArgumentsException {
		String path = "resourcesTests/testExists/algo.zip";
		String[] args = { path };

		new ArgsParser(args);
	}

	@Test(expected = ArgumentsException.class)
	public void dadoUnArrayConUnDirectorioInexistenteDeberiaLanzarUnaExcepcion()
			throws ArgumentsException {
		String path = "resourcesTests/testNonExists";
		String[] args = { path };

		new ArgsParser(args);
	}

}
