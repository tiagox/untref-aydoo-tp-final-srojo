package untref.aydoo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

public class StatsCalculator {

	Logger logger = Logger.getLogger("log");

	private int contadorDeRegistros = 0;
	private Map<String, Integer> contadorPorBicicleta = new HashMap<String, Integer>();
	private Map<Recorrido, Integer> contadorPorRecorrido = new HashMap<Recorrido, Integer>();
	private long acumuladorDeTiempos = 0L;

	public synchronized void addPrestamo(Prestamo prestamo) {
		updateContadorPorBicicleta(prestamo);
		updateContadorPorRecorrido(prestamo);
		updateAcumuladorDeTiempos(prestamo);

		contadorDeRegistros++;
	}

	private void updateContadorPorBicicleta(Prestamo prestamo) {
		Integer cantidadUsos = contadorPorBicicleta.get(prestamo
				.getBicicletaId());
		if (cantidadUsos != null) {
			contadorPorBicicleta.put(prestamo.getBicicletaId(),
					cantidadUsos + 1);
		} else {
			contadorPorBicicleta.put(prestamo.getBicicletaId(), 1);
		}
	}

	private void updateContadorPorRecorrido(Prestamo prestamo) {
		Integer cantidadUsos = contadorPorRecorrido
				.get(prestamo.getRecorrido());
		if (cantidadUsos != null) {
			contadorPorRecorrido.put(prestamo.getRecorrido(), cantidadUsos + 1);
		} else {
			contadorPorRecorrido.put(prestamo.getRecorrido(), 1);
		}
	}

	private void updateAcumuladorDeTiempos(Prestamo prestamo) {
		acumuladorDeTiempos += prestamo.getTiempoUso();
	}

	public List<String> getBicicletasMasUsadas() {
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
		Collections.sort(bicicletas);
		return bicicletas;
	}

	public List<String> getBicicletasMenosUsadas() {
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
		Collections.sort(bicicletas);
		return bicicletas;
	}

	public List<Recorrido> getRecorridosMasUsados() {
		Integer maximo = contadorPorBicicleta.entrySet().iterator().next()
				.getValue();
		List<Recorrido> recorridos = new ArrayList<Recorrido>();
		for (Entry<Recorrido, Integer> entry : contadorPorRecorrido.entrySet()) {
			if (entry.getValue() == maximo) {
				recorridos.add(entry.getKey());
			} else if (entry.getValue() > maximo) {
				maximo = entry.getValue();
				recorridos = new ArrayList<Recorrido>();
				recorridos.add(entry.getKey());
			}
		}
		Collections.sort(recorridos);
		return recorridos;
	}

	public int getTiempoPromedioUso() {
		return (int) acumuladorDeTiempos / contadorDeRegistros;
	}

	public void exportYaml(String yamlPath) {
		File file = new File(yamlPath);
		if (file.exists()) {
			file.delete();
		}
		try {
			file.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					file.getAbsolutePath()));
			writer.write(this.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "--- # estadisticas de uso de bicicletas" + "\n"
				+ "bicicleta-utilizada-mas-veces: " + getBicicletasMasUsadas()
				+ "\n" + "bicicleta-utilizada-menos-veces: "
				+ getBicicletasMenosUsadas() + "\n"
				+ "recorrido-mas-veces-realizado: " + getRecorridosMasUsados()
				+ "\n" + "tiempo-promedio-de-uso: " + getTiempoPromedioUso();
	}

}
