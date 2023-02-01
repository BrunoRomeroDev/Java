package Entidades;

import EnumEntidades.TipoCarros;

public class Carros extends Automoveis {
	
	private String cor;
	private Integer portas;
	private TipoCarros tc;
	
	public String getTipo() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Integer getPortas() {
		return portas;
	}
	public void setPortas(Integer portas) {
		this.portas = portas;
	}
	public TipoCarros getTc() {
		return tc;
	}
	public void setTc(TipoCarros tc) {
		this.tc = tc;
	}
	public Carros() {
		super();
		
	}
	public Carros(String tipo, Integer portas, TipoCarros tc) {
		super();
		this.cor = tipo;
		this.portas = portas;
		this.tc = tc;
	}
	@Override
	public String toString() {
		return "Carros [cor=" + cor + ", portas=" + portas + ", tc=" + tc + ", getPlaca()=" + getPlaca() + "]";
	}

	
	
}
