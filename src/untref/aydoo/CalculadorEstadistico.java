package untref.aydoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CalculadorEstadistico {

	private int contadorDeRegistros = 0;
	private Map<String, Integer> contadorPorBicicleta = new HashMap<String, Integer>();
	private Map<Recorrido, Integer> contadorPorRecorrido = new HashMap<Recorrido, Integer>();
	private long acumuladorDeTiempos = 0L;

	public void addPrestamo(Prestamo prestamo) {
		updateContadorPorBicicleta(prestamo);
		updateContadorPorRecorrido(prestamo);
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

	private void updateContadorPorRecorrido(Prestamo prestamo) {
		Integer cantidadUsos;
		if ((cantidadUsos = contadorPorRecorrido.get(prestamo.getRecorrido())) != null) {
			contadorPorRecorrido.put(prestamo.getRecorrido(), cantidadUsos + 1);
		} else {
			contadorPorRecorrido.put(prestamo.getRecorrido(), 1);
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

	public List<Recorrido> getRecorridosMasUsados() {
		Integer maximo = contadorPorBicicleta.entrySet().iterator().next()
				.getValue();
		List<Recorrido> recorridos = new ArrayList<Recorrido>();
		for (Entry<Recorrido, Integer> entry : contadorPorRecorrido.entrySet()) {
			System.out.println(entry.getValue());
			if (entry.getValue() == maximo) {
				recorridos.add(entry.getKey());
			} else if (entry.getValue() > maximo) {
				maximo = entry.getValue();
				recorridos = new ArrayList<Recorrido>();
				recorridos.add(entry.getKey());
			}
		}
		return recorridos;
	}

	public int getTiempoPromedioUso() {
		return (int) acumuladorDeTiempos / contadorDeRegistros;
	}

}
