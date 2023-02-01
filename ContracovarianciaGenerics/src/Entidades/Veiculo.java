package Entidades;

public class Veiculo<T> {
	
	private T veiculo;
	
	
	public Veiculo(T veiculo) {
		this.veiculo = veiculo;
	}


	@Override
	public String toString() {
		return "Veiculo [veiculo=" + veiculo + "]";
	}


	public T getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(T veiculo) {
		this.veiculo = veiculo;
	}
	
	

}
