package untref.aydoo;

public class Prestamo {

	private String bicicletaId;
	private Recorrido recorrido;
	private int tiempoUso;
	private static final int FIELD_COUNT = 9;
	/*
	 * Indices de encabezados de CSV de recorridos.
	 * 
	 * 0:usuarioId, 1:bicicletaId, 2:origenFecha, 3:origenEstacionId,
	 * 4:origenNombre, 5: destinoFecha, 6: destinoEstacionId, 7: destinoNombre,
	 * 8:tiempoUso
	 */
	private static final int BICICLETA_ID_INDEX_COLUMN = 1;
	private static final String BICICLETA_ID_HEADER_NAME = "bicicletaid";
	private static final int RECORRIDO_ORIGEN_INDEX_COLUMN = 3;
	private static final String RECORRIDO_ORIGEN_HEADER_NAME = "origenestacionid";
	private static final int RECORRIDO_DESTINO_INDEX_COLUMN = 6;
	private static final String RECORRIDO_DESTINO_HEADER_NAME = "destinoestacionid";
	private static final int TIEMPO_USO_INDEX_COLUMN = 8;
	private static final String TIEMPO_USO_HEADER_NAME = "tiempouso";

	public void parse(String rawLine) throws RegistroInvalidoException,
			RegistroHeaderException {
		String[] fields = rawLine.split(";");

		if (isInvalid(fields)) {
			throw new RegistroInvalidoException("Registro inválido: " + rawLine);
		}

		if (isHeader(fields)) {
			throw new RegistroHeaderException();
		}

		try {
			saveFields(fields);
		} catch (Exception e) {
			throw new RegistroInvalidoException("Registro inválido: " + rawLine);
		}
	}

	private boolean isInvalid(String[] fields) {
		return (fields.length != FIELD_COUNT
				|| fields[BICICLETA_ID_INDEX_COLUMN].isEmpty()
				|| fields[RECORRIDO_ORIGEN_INDEX_COLUMN].isEmpty()
				|| fields[RECORRIDO_DESTINO_INDEX_COLUMN].isEmpty());
	}

	private boolean isHeader(String[] fields) {
		return (fields[BICICLETA_ID_INDEX_COLUMN].toLowerCase().equals(BICICLETA_ID_HEADER_NAME)
				&& fields[RECORRIDO_ORIGEN_INDEX_COLUMN].toLowerCase().equals(RECORRIDO_ORIGEN_HEADER_NAME)
				&& fields[RECORRIDO_DESTINO_INDEX_COLUMN].toLowerCase().equals(RECORRIDO_DESTINO_HEADER_NAME)
				&& fields[TIEMPO_USO_INDEX_COLUMN].toLowerCase().equals(TIEMPO_USO_HEADER_NAME));
	}

	private void saveFields(String[] fields) {
		bicicletaId = fields[BICICLETA_ID_INDEX_COLUMN];
		recorrido = new Recorrido(fields[RECORRIDO_ORIGEN_INDEX_COLUMN],
				fields[RECORRIDO_DESTINO_INDEX_COLUMN]);
		tiempoUso = Integer.parseInt(fields[TIEMPO_USO_INDEX_COLUMN]);
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

	@Override
	public String toString() {
		return "[bicicletaId=" + bicicletaId + ", recorrido=" + recorrido
				+ ", tiempoUso=" + tiempoUso + "]";
	}

}
