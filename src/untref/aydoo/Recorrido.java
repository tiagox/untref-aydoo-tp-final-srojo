package untref.aydoo;

public class Recorrido implements Comparable<Recorrido> {

	private String origen;
	private String destino;

	public Recorrido(String origen, String destino) {
		this.origen = origen;
		this.destino = destino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + destino.hashCode();
		result = prime * result + origen.hashCode();
		return result;
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

	@Override
	public int compareTo(Recorrido other) {
		if (origen.compareTo(other.origen) > 0)
			return 1;
		else if (origen.compareTo(other.origen) < 0)
			return -1;
		else if (destino.compareTo(other.destino) > 0)
			return 1;
		else if (destino.compareTo(other.destino) < 0)
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		return "[" + origen + ", " + destino + "]";
	}

}
