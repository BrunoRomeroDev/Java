package entities;

public class quadrado extends forma {
	
		@Override
	public String toString() {
		return "quadrado [area=" + area + ", lado=" + lado + ", base=" + base + ", arestas=" + arestas + ", color="
				+ color + "]";
	}
		double area;
		double lado;
		double base;

	

	public quadrado(int arestas, String color, double lado, double base) {
			super(arestas, color);
			
			this.lado = lado;
			this.base = base;
		}

	

		public double getArea() {
			return area;
		}
@Override
		public void setArea() {
			this.area = this.lado * this.base;
		}


		

}
