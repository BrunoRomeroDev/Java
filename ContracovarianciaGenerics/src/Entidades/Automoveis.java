package Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Automoveis {
	
	private String placa;
	private Integer cc;
	private String chassi;
	public Integer getCc() {
		return cc;
	}
	public void setCc(Integer cc) {
		this.cc = cc;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(placa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automoveis other = (Automoveis) obj;
		return Objects.equals(placa, other.placa);
	}
	public Automoveis(Integer cc, String chassi,String placa) {
		super();
		this.cc = cc;
		this.chassi = chassi;
		this.placa = placa;
	}
	
	public Automoveis() {
		
	}
	@Override
	public String toString() {
		return "Automoveis [placa=" + placa + ", cc=" + cc + ", chassi=" + chassi + "]";
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public  List<Automoveis> convert(List<? extends Automoveis> list){
		List<Automoveis> la = new ArrayList<>();
		
		List<? super Automoveis> ls = new ArrayList<>();
		for (Automoveis auto : list) {
			la.add((Automoveis) list);
		}
		return la;
		
	}
	
	
}
