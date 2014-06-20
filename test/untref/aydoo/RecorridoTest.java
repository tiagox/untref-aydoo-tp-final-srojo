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
