package aplication;

import java.util.Objects;

public class Carros implements Comparable<Carros> {
	private String name;
	private String modelo;
	private Integer ano;
	private boolean status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ano, modelo, name, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carros other = (Carros) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(modelo, other.modelo)
				&& Objects.equals(name, other.name) && status == other.status;
	}
	public Carros(String name, String modelo, Integer ano, boolean status) {
		super();
		this.name = name;
		this.modelo = modelo;
		this.ano = ano;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Carros [name=" + name + ", modelo=" + modelo + ", ano=" + ano + ", status=" + status + "]";
	}
	
	public Carros() {
		
	}
	@Override
	public int compareTo(Carros c) {
		
		return this.ano.compareTo(c.ano);
	}

	

}
