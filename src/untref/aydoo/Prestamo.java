package untref.aydoo;

public class Prestamo {

	private String bicicletaId;
	private Recorrido recorrido;
	private int tiempoUso;
	private final int FIELD_COUNT = 9;

	public void parse(String rawLine) throws RegistroInvalidoException {
		String[] fields = rawLine.split(";");
		
		if (fields.length != FIELD_COUNT) {
			throw new RegistroInvalidoException("Registro inválido: " + rawLine);
		}
		
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
