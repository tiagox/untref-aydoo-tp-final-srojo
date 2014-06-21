package untref.aydoo;

public class Recorrido {

	private String origen;
	private String destino;

	public Recorrido(String origen, String destino) {
		this.origen = origen;
		this.destino = destino;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recorrido other = (Recorrido) obj;
		if (!destino.equals(other.destino))
			return false;
		if (!origen.equals(other.origen))
			return false;
		return true;
	}

}
