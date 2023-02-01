package Entidades;

import EnumEntidades.TipoMoto;

public class Moto extends Automoveis {
	
	private TipoMoto tm;
	private String modelo;
	public TipoMoto getTm() {
		return tm;
	}
	public void setTm(TipoMoto tm) {
		this.tm = tm;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	
	@Override
	public String toString() {
		return "Moto [tm=" + tm + ", modelo=" + modelo + ", getPlaca()=" + getPlaca() + "]";
	}
	public Moto(TipoMoto tm, String modelo) {
		super();
		this.tm = tm;
		this.modelo = modelo;
	}
	
	public Moto() {
		
	}

}
