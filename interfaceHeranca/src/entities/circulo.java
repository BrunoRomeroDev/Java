package entities;


public class circulo extends forma {
	
		
		double raio;
		double diametro;
		static double  pi = 3.14;

	

	public circulo(int arestas, String color) {
			super(arestas, color);
			
		}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}

	public static double getPi() {
		return pi;
	}

	public static void setPi(double pi) {
		circulo.pi = pi;
	}
	
	

}
