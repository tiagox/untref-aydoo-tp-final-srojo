package untref.aydoo;

public class Prestamo {

	private String bicicletaId;
	private Recorrido recorrido;
	private int tiempoUso;

	public void parse(String rawLine) {
		String[] fields = rawLine.split(";");
		
		/*
		 * 0: usuarioId
		 * 1: bicicletaId
		 * 2: origenFecha
		 * 3: origenEstacionId
		 * 4: origenNombre
		 * 5: destinoFecha
		 * 6: destinoEstacionId
		 * 7: destinoNombre
		 * 8: tiempoUso
		 */
		
		bicicletaId = fields[1];
		recorrido = new Recorrido(fields[3], fields[6]);
		tiempoUso = Integer.parseInt(fields[8]);
	}

	public String getBicicletaId() {
		return bicicletaId;
	}

	public Recorrido getRecorrido() {
		return recorrido;
	}

	public int getTiempoUso() {
		return tiempoUso;
	}

}
