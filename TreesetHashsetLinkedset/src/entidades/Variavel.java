package entidades;

public class Variavel implements Comparable<Variavel>{
	int size;

	public Variavel(int s) {
		size = s;
	}

	public String toString() {
		return size + "";
	}

	@Override
	public int compareTo(Variavel o) {
	        return size - o.size;
	}
}