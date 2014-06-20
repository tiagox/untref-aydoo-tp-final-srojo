package untref.aydoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CalculadorEstadistico {

	Map<String, Integer> contadorPorBicicleta = new HashMap<String, Integer>();

	public void addPrestamo(Prestamo prestamo) {
		updateContadorPorBicicleta(prestamo);
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

}
