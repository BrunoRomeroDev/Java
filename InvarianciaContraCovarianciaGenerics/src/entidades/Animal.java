package entidades;

import java.util.Objects;

public class Animal {
	
	String nome;
	Integer idade;
	
	public Animal(String nome, Integer idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(nome, other.nome);
	}
	@Override
	public String toString() {
		return "Animal [nome=" + nome + ", idade=" + idade + "]";
	}
	public Animal() {
		super();
	}
	
	

}
