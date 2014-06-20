package untref.aydoo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CalculadorEstadisticoTest {

	@Test
	public void elCalculadorDebeSaberCualEsLaBicicletaMasUsada() {
		Prestamo prestamo = new Prestamo();
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
		
		List<String> bicicletasMasUsada = new ArrayList<String>();
		bicicletasMasUsada.add("442");
		bicicletasMasUsada.add("443");
		
		Assert.assertEquals(bicicletasMasUsada,
				calculador.getBicicletasMasUsada());
	}

}
