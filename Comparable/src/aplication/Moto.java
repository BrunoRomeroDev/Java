package aplication;

import java.util.Objects;

public class Moto {
	
	private String name;
	private Integer ano;
	private String modelo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ano, modelo, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moto other = (Moto) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(modelo, other.modelo)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Moto [name=" + name + ", ano=" + ano + ", modelo=" + modelo + "]";
	}
	public Moto(String name, Integer ano, String modelo) {
		super();
		this.name = name;
		this.ano = ano;
		this.modelo = modelo;
	}
	
	

}
