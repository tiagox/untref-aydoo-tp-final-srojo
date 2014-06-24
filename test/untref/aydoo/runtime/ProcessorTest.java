package untref.aydoo.runtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.domain.Recorrido;
import untref.aydoo.domain.StatsCalculator;
import untref.aydoo.runtime.Processor;

public class ProcessorTest {

	private static final String CSV_TO_PROCESS = "resourcesTests/dirToProcess/recorridos1.csv";

	@Test
	public void testIntegracionProcessor() {
		StatsCalculator calculador = new StatsCalculator();
		Processor processor = new Processor(calculador, CSV_TO_PROCESS);

		List<String> bicicletasMasUsadasEsperadas = new ArrayList<String>();
		bicicletasMasUsadasEsperadas.add("403");
		List<String> bicicletasMenosUsadasEsperadas = new ArrayList<String>();
		bicicletasMenosUsadasEsperadas.add("429");
		bicicletasMenosUsadasEsperadas.add("370");
		Collections.sort(bicicletasMenosUsadasEsperadas);
		List<Recorrido> recorridosMasUsadosEsperados = new ArrayList<Recorrido>();
		recorridosMasUsadosEsperados.add(new Recorrido("7", "3"));
		int tiempoPromedioEsperado = 10;

		processor.run();

		Assert.assertEquals(bicicletasMasUsadasEsperadas,
				calculador.getBicicletasMasUsadas());

		List<String> bicicletasMenosUsadas = calculador
				.getBicicletasMenosUsadas();
		Collections.sort(bicicletasMenosUsadas);

		Assert.assertEquals(bicicletasMenosUsadasEsperadas,
				bicicletasMenosUsadas);
		Assert.assertEquals(recorridosMasUsadosEsperados,
				calculador.getRecorridosMasUsados());
		Assert.assertEquals(tiempoPromedioEsperado,
				calculador.getTiempoPromedioUso());
	}

}
