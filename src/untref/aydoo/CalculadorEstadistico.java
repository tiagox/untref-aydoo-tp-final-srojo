package untref.aydoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CalculadorEstadistico {

	private int contadorDeRegistros = 0;
	private long acumuladorDeTiempos = 0L;
	private Map<String, Integer> contadorPorBicicleta = new HashMap<String, Integer>();

	public void addPrestamo(Prestamo prestamo) {
		updateContadorPorBicicleta(prestamo);
		updateAcumuladorDeTiempos(prestamo);
		
		contadorDeRegistros++;
	}

	private void updateContadorPorBicicleta(Prestamo prestamo) {
		Integer cantidadUsos;
		if ((cantidadUsos = contadorPorBicicleta.get(prestamo.getBicicletaId())) != null) {
			contadorPorBicicleta.put(prestamo.getBicicletaId(),
					cantidadUsos + 1);
		} else {
			contadorPorBicicleta.put(prestamo.getBicicletaId(), 1);
		}
	}

	private void updateAcumuladorDeTiempos(Prestamo prestamo) {
		acumuladorDeTiempos += prestamo.getTiempoUso();
	}

	public List<String> getBicicletasMasUsada() {
		Integer maximo = contadorPorBicicleta.entrySet().iterator().next()
				.getValue();
		List<String> bicicletas = new ArrayList<String>();
		for (Entry<String, Integer> entry : contadorPorBicicleta.entrySet()) {
			if (entry.getValue() == maximo) {
				bicicletas.add(entry.getKey());
			} else if (entry.getValue() > maximo) {
				maximo = entry.getValue();
				bicicletas = new ArrayList<String>();
				bicicletas.add(entry.getKey());
			}
		}
		return bicicletas;
	}

	public List<String> getBicicletasMenosUsada() {
		Integer minimo = contadorPorBicicleta.entrySet().iterator().next()
				.getValue();
		List<String> bicicletas = new ArrayList<String>();
		for (Entry<String, Integer> entry : contadorPorBicicleta.entrySet()) {
			if (entry.getValue() == minimo) {
				bicicletas.add(entry.getKey());
			} else if (entry.getValue() < minimo) {
				minimo = entry.getValue();
				bicicletas = new ArrayList<String>();
				bicicletas.add(entry.getKey());
			}
		}
		return bicicletas;
	}

	public int getTiempoPromedioUso() {
		return (int) acumuladorDeTiempos / contadorDeRegistros;
	}

}
