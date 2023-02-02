package entidades;

public class Cao extends Animal {
	
	String raca;
	Integer patas;
	public Cao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cao(String raca, Integer patas) {
		super();
		this.raca = raca;
		this.patas = patas;
	}
	@Override
	public String toString() {
		return "Cao [raca=" + raca + ", patas=" + patas + "]";
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public Integer getPatas() {
		return patas;
	}
	public void setPatas(Integer patas) {
		this.patas = patas;
	}
	
	

}
