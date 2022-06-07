package ED;

class No
{
	Object elemento;
	No prox;
	
	No (Object elem){
		elemento = elem;
		prox = null;
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		return "No [elemento=" + elemento + ", prox=" + prox + "]";
	}
	
}