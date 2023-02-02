package entidades;

import java.util.Objects;

// passado dois parametros na classe Pug T, R indicando que recebera dois valores de qualquer tipo(genericos)
public class Pug<T,R> extends Cao {
	
	//recebe os valores de qualquer tipo 
	private T value;
	private R rg;

 	@Override
	public String toString() {
		return "Pug [value=" + value + ", rg=" + rg + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(rg);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pug other = (Pug) obj;
		return Objects.equals(rg, other.rg);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public R getRg() {
		return rg;
	}

	public void setRg(R rg) {
		this.rg = rg;
	}

	public Pug(T value, R rg) {
		super();
		this.value = value;
		this.rg = rg;
	}

	
	
}
