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
		}

		Assert.assertEquals(bicicletaId, prestamo.getBicicletaId());
		Assert.assertEquals(recorrido, prestamo.getRecorrido());
		Assert.assertEquals(tiempoUso, prestamo.getTiempoUso());
	}

	@Test(expected = RegistroInvalidoException.class)
	public void unPrestamoDeberiaIdentificarUnRegistroInvalidoAlQueLeFaltanCampos() throws RegistroInvalidoException {
		Prestamo prestamo = new Prestamo();

		prestamo.parse("1036;403;2010-12-30 19:39:03;6;DERECHO;2010-12-30 19:46:03;3;RETIRO;");
	}

}
