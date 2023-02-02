package entidades;

import java.util.Objects;

public class PastorAlemao extends Cao {
	
	private String nome;
	private Integer tamanho;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getTamanho() {
		return tamanho;
	}
	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nome, tamanho);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PastorAlemao other = (PastorAlemao) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(tamanho, other.tamanho);
	}
	@Override
	public String toString() {
		return "PastorAlemao [nome=" + nome + ", tamanho=" + tamanho + "]";
	}
	public PastorAlemao(String nome, Integer tamanho) {
		super();
		this.nome = nome;
		this.tamanho = tamanho;
	}
	
	

}
