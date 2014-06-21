package untref.aydoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CalculadorEstadisticoTest {

	private Prestamo prestamo = new Prestamo();

	@Test
	public void elCalculadorDebeSaberCualSonLasBicicletasMasUsadas()
			throws RegistroInvalidoException {
		CalculadorEstadistico calculador = new CalculadorEstadistico();
		prestamo.parse("2722;443;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;13");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;445;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;14");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;443;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;3");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;442;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;7");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;442;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;14");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;441;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;5");
		calculador.addPrestamo(prestamo);

		List<String> bicicletasEsperadas = new ArrayList<String>();
		bicicletasEsperadas.add("442");
		bicicletasEsperadas.add("443");
		Collections.sort(bicicletasEsperadas);

		List<String> bicicletasMasUsadas = calculador.getBicicletasMasUsada();
		Collections.sort(bicicletasMasUsadas);

		Assert.assertEquals(bicicletasEsperadas, bicicletasMasUsadas);
	}

	@Test
	public void elCalculadorDebeSaberCualesSonLasBicicletasMenosUsadas()
			throws RegistroInvalidoException {
		CalculadorEstadistico calculador = new CalculadorEstadistico();
		prestamo.parse("2722;443;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;13");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;445;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;14");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;443;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;3");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;442;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;7");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;442;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;14");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;441;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;5");
		calculador.addPrestamo(prestamo);

		List<String> bicicletasEsperadas = new ArrayList<String>();
		bicicletasEsperadas.add("441");
		bicicletasEsperadas.add("445");
		Collections.sort(bicicletasEsperadas);

		List<String> bicicletasMenosUsadas = calculador
				.getBicicletasMenosUsada();
		Collections.sort(bicicletasMenosUsadas);

		Assert.assertEquals(bicicletasEsperadas, bicicletasMenosUsadas);
	}

	@Test
	public void debeSaberCalcularElTiempoPromedioDeUso()
			throws RegistroInvalidoException {
		CalculadorEstadistico calculador = new CalculadorEstadistico();
		prestamo.parse("2722;443;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;13");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;445;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;14");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;443;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;3");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;442;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;7");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;442;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;14");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;441;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;5");
		calculador.addPrestamo(prestamo);

		int tiempoPromedioUsoEsperado = 9;

		Assert.assertEquals(tiempoPromedioUsoEsperado,
				calculador.getTiempoPromedioUso());
	}

	@Test
	public void elCalculadorDebeSaberCualesSonLosRecorridosMasUsados()
			throws RegistroInvalidoException {
		CalculadorEstadistico calculador = new CalculadorEstadistico();
		prestamo.parse("2722;443;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;13");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;445;2010-12-30 19:34:16;3;RETIRO;2010-12-30 19:47:03;5;ADUANA;14");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;443;2010-12-30 19:34:16;5;ADUANA;2010-12-30 19:47:03;3;RETIRO;3");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;442;2010-12-30 19:34:16;7;PLAZA ROMA;2010-12-30 19:17:44;3;RETIRO;7");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;442;2010-12-30 19:34:16;3;RETIRO;2010-12-30 19:47:03;5;ADUANA;14");
		calculador.addPrestamo(prestamo);
		prestamo.parse("2722;441;2010-12-30 19:34:16;6;DERECHO;2010-12-30 19:46:03;3;RETIRO;5");
		calculador.addPrestamo(prestamo);

		List<Recorrido> recorridosEsperados = new ArrayList<Recorrido>();
		recorridosEsperados.add(new Recorrido("5", "3"));
		recorridosEsperados.add(new Recorrido("3", "5"));
		Collections.sort(recorridosEsperados);

		List<Recorrido> recorridosMasUsados = calculador
				.getRecorridosMasUsados();
		Collections.sort(recorridosMasUsados);

		Assert.assertEquals(recorridosEsperados, recorridosMasUsados);
	}

}
