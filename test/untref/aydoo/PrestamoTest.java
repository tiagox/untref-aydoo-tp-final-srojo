package untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PrestamoTest {

	@Test
	public void unPrestamoDeberiaPoderParsearUnaLineaDelCsv() {
		Prestamo prestamo = new Prestamo();
		String bicicletaId = "403";
		Recorrido recorrido = new Recorrido("6", "3");
		int tiempoUso = 7;

		try {
			prestamo.parse("1036;403;2010-12-30 19:39:03;6;DERECHO;2010-12-30 19:46:03;3;RETIRO;7");
		} catch (RegistroInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (RegistroHeaderException e) {
			// do nothing
		}

		Assert.assertEquals(bicicletaId, prestamo.getBicicletaId());
		Assert.assertEquals(recorrido, prestamo.getRecorrido());
		Assert.assertEquals(tiempoUso, prestamo.getTiempoUso());
	}

	@Test(expected = RegistroInvalidoException.class)
	public void unPrestamoDeberiaIdentificarUnRegistroInvalidoAlQueLeFaltanCampos()
			throws RegistroInvalidoException, RegistroHeaderException {
		Prestamo prestamo = new Prestamo();

		prestamo.parse("1036;403;2010-12-30 19:39:03;6;DERECHO;2010-12-30 19:46:03;3;RETIRO;");
	}

	@Test(expected = RegistroInvalidoException.class)
	public void unPrestamoDeberiaIdentificarUnRegistroInvalidoPorErrorDeFormato()
			throws RegistroInvalidoException, RegistroHeaderException {
		Prestamo prestamo = new Prestamo();

		prestamo.parse("1036;403;2010-12-30 19:39:03;6;DERECHO;2010-12-30 19:46:03;3;RETIRO;error");
	}

	@Test(expected = RegistroInvalidoException.class)
	public void unPrestamoDeberiaIdentificarUnRegistroInvalidoPorFaltaDeBicicletaId()
			throws RegistroInvalidoException, RegistroHeaderException {
		Prestamo prestamo = new Prestamo();

		prestamo.parse("1036;;2010-12-30 19:39:03;6;DERECHO;2010-12-30 19:46:03;3;RETIRO;7");
	}

	@Test(expected = RegistroInvalidoException.class)
	public void unPrestamoDeberiaIdentificarUnRegistroInvalidoPorFaltaDeOrigenId()
			throws RegistroInvalidoException, RegistroHeaderException {
		Prestamo prestamo = new Prestamo();

		prestamo.parse("1036;403;2010-12-30 19:39:03;;DERECHO;2010-12-30 19:46:03;3;RETIRO;7");
	}

	@Test(expected = RegistroInvalidoException.class)
	public void unPrestamoDeberiaIdentificarUnRegistroInvalidoPorFaltaDeDestinoId()
			throws RegistroInvalidoException, RegistroHeaderException {
		Prestamo prestamo = new Prestamo();

		prestamo.parse("1036;403;2010-12-30 19:39:03;6;DERECHO;2010-12-30 19:46:03;;RETIRO;7");
	}

	@Test(expected = RegistroHeaderException.class)
	public void unPrestamoDeberiaIdentificarElRegistroQueRepresentaElHEaderDelArchivo()
			throws RegistroInvalidoException, RegistroHeaderException {
		Prestamo prestamo = new Prestamo();
		String header = "usuarioid;bicicletaid;origenfecha;origenestacionid;origennombre;destinofecha;destinoestacionid;destinonombre;tiempouso";

		prestamo.parse(header);
	}

}
