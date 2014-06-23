package untref.aydoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ProcessorTest {

	private static final String CSV_TO_PROCESS = "resourcesTests/dirToProcess/recorridos1.csv";

	@Test
	public void test() {
		Processor processor = new Processor();
		CalculadorEstadistico calculador = new CalculadorEstadistico();

		List<String> bicicletasMasUsadasEsperadas = new ArrayList<String>();
		bicicletasMasUsadasEsperadas.add("403");
		List<String> bicicletasMenosUsadasEsperadas = new ArrayList<String>();
		bicicletasMenosUsadasEsperadas.add("429");
		bicicletasMenosUsadasEsperadas.add("370");
		Collections.sort(bicicletasMenosUsadasEsperadas);
		List<Recorrido> recorridosMasUsadosEsperados = new ArrayList<Recorrido>();
		recorridosMasUsadosEsperados.add(new Recorrido("7", "3"));
		int tiempoPromedioEsperado = 10;

		processor.processCsv(CSV_TO_PROCESS, calculador);

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