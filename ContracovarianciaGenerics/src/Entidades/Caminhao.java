package Entidades;

public class Caminhao extends Automoveis {
	
	private Integer eixo;
	private Double tamanho;
	public Integer getEixo() {
		return eixo;
	}
	public void setEixo(Integer eixo) {
		this.eixo = eixo;
	}
	public Double getTamanho() {
		return tamanho;
	}
	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}
	
	
	
	@Override
	public String toString() {
		return "Caminhao [eixo=" + eixo + ", tamanho=" + tamanho + ", getPlaca()=" + getPlaca() + "]";
	}
	public Caminhao(Integer eixo, Double tamanho) {
		super();
		this.eixo = eixo;
		this.tamanho = tamanho;
	}
	
	public Caminhao() {
		
	}

}
