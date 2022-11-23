package Entidades;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String desc;
	private Integer qtd;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getQtd() {
		return qtd;
	}
	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo, desc, qtd);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(desc, other.desc)
				&& Objects.equals(qtd, other.qtd);
	}
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", desc=" + desc + ", qtd=" + qtd + "]";
	}
	public Produto(String codigo, String desc, Integer qtd) {
		super();
		this.codigo = codigo;
		this.desc = desc;
		this.qtd = qtd;
	}
	
	public Produto() {
		
	}

}
