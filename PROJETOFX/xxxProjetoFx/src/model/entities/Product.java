package model.entities;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cod;
	private String descr;
	private String tipo;
	private String descest;
	
	public Product() {
	}

	public Product(String cod, String descr,String tipo,String descest) {
		this.cod = cod;
		this.descr = descr;
		this.tipo = tipo;
		this.descest = descest;
	}

	

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescest() {
		return descest;
	}

	public void setDescest(String descest) {
		this.descest = descest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		return result;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [cod=" + cod + ", descr=" + descr + ", tipo=" + tipo + ", descest=" + descest + "]";
	}
}
