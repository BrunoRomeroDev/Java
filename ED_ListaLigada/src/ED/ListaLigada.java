package ED;

import javax.swing.JOptionPane;

public class ListaLigada
{
	private No primeiro, ultimo;
	private int nroNos;
	
	ListaLigada ()
	{
		primeiro = null;
		ultimo = null;
		nroNos = 0;
	}
	
	public boolean isVazia() {
		return (primeiro == null && ultimo == null);
	}
	
	public void addInicio(Object o) {
		nroNos++;
		No novoNo = new No(o);
		if (isVazia())
			ultimo = novoNo;
		else
			novoNo.prox = primeiro;
		primeiro = novoNo;
	}
	
	public void addFinal(Object o)	{
		nroNos++;
		No novoNo = new No(o);
		if (isVazia())
			primeiro = novoNo;
		else
			ultimo.setProx(novoNo);
		ultimo = novoNo;
	}
	
	public int getNroNos() {
		return nroNos;
	}
	

	public void addMeio(Object o, int posicao)	{
		nroNos++;
		No novoNo = new No(o);
		if(posicao <= 1) {
			addInicio(novoNo);
			return;
		}
		if (posicao > nroNos) { 
			throw new IllegalStateException("Posição invalida");
		
		}
		No noTemp = primeiro.getProx();
		for(int posAux=1;posAux<posicao;posAux++)
			noTemp = noTemp.getProx();
		novoNo.setProx((noTemp.getProx()).getProx())  ;
		noTemp.setProx(novoNo) ;
	}
	
	public void Remover(Object elemento)
	{
		No noTemp = primeiro;
		No noAnt = null;
		
		if (primeiro.elemento.equals(elemento))	{
			primeiro = primeiro.getProx();
			nroNos--;
		}
		else {
			while (noTemp !=null && !noTemp.elemento.equals(elemento)) {
				noAnt = noTemp;
				noTemp = noTemp.getProx();
			}
			if(noTemp != null) {
				noAnt.prox = noTemp.getProx();
				nroNos--;
			}
			if(noTemp == ultimo) {
				ultimo = noAnt;
			}
		}
	}
	
	public Object BuscarElemento (Object elemento)
	{
		int i = 1;
		No noTemp = primeiro;
		
		while (noTemp !=null) {
			if(noTemp.elemento.equals(elemento)) {
				return noTemp.toString();
			}
			i = i +1;
			noTemp = noTemp.getProx();
		}
		return null;
	}

	@Override
	public String toString() {
		return "ListaLigada [primeiro=" + primeiro + ", ultimo=" + ultimo + ", nroNos=" + nroNos + "]";
	}
	
	public String mostrar() {
        if(isVazia()) return "Lista vazia\n"; 
        String str = "Lista Encadeada: ";
        for (No nodo = primeiro; nodo != null; nodo = nodo.prox)
            str+= " "+ nodo.elemento + " "+ nodo.prox;
        return str + "\n";
		
	}
}