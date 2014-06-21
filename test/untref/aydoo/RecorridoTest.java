package untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class RecorridoTest {

	@Test
	public void debeRecibirOrigenYDestinoEnElConstructor() {
		Recorrido recorrido = new Recorrido("DERECHO", "RETIRO");

		Assert.assertNotNull(recorrido);
	}

	@Test
	public void pruebasDeMetodoEqualsAutogenerado() {
		Recorrido recorrido = new Recorrido("DERECHO", "RETIRO");

		Assert.assertTrue(recorrido.equals(recorrido));
		Assert.assertFalse(recorrido.equals(null));
		Assert.assertFalse(recorrido.equals("recorrido"));
	}

	@Test
	public void pruebasDeMetodoCompareToAutogenerado() {
		Recorrido recorrido = new Recorrido("2", "3");

		Assert.assertEquals(0, recorrido.compareTo(new Recorrido("2", "3")));
		Assert.assertEquals(1, recorrido.compareTo(new Recorrido("1", "3")));
		Assert.assertEquals(1, recorrido.compareTo(new Recorrido("2", "2")));
		Assert.assertEquals(-1, recorrido.compareTo(new Recorrido("3", "3")));
		Assert.assertEquals(-1, recorrido.compareTo(new Recorrido("2", "4")));
	}

	@Test
	public void compararDosRecorridosDeberiaDevolverTrueSiTienenIgualOrigenDestino() {
		Recorrido recorrido = new Recorrido("DERECHO", "RETIRO");
		Recorrido otroRecorrido = new Recorrido("DERECHO", "RETIRO");

		Assert.assertTrue(recorrido.equals(otroRecorrido));
	}

	@Test
	public void compararDosRecorridosDeberiaDevolverFalseSiTienenDistintoOrigenDestino() {
		Recorrido recorrido = new Recorrido("DERECHO", "RETIRO");
		Recorrido otroRecorrido = new Recorrido("ADUANA", "RETIRO");

		Assert.assertFalse(recorrido.equals(otroRecorrido));
	}

	@Test
	public void compararDosRecorridosDeberiaDevolverFalseSiTienenInvertidoOrigenDestino() {
		Recorrido recorrido = new Recorrido("DERECHO", "RETIRO");
		Recorrido otroRecorrido = new Recorrido("RETIRO", "DERECHO");

		Assert.assertFalse(recorrido.equals(otroRecorrido));
	}

}
