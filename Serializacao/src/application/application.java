package application;

import Entidades.Produto;
import Serializar.Serializar;

public class application {

	public static void main(String[] args) {
	int[] arrayint = null;
	arrayint = new int[3];
	arrayint[0] = 12;
	arrayint[1] = 13;
	arrayint[2] = 32;
	System.out.println(arrayint[0]+" "+arrayint[1]+" "+arrayint[2]);
	
	for(int i = 0;i < 3;i++ ) {
		System.out.println(arrayint[i]);
	}
	
	Produto prod = new Produto("UXXTR", "MESA DE ESCRITORIO",123);
	
	Serializar.serializar(prod);
	
	Produto prodes = (Produto) Serializar.deserializar();
	
	System.out.println(prodes);
	
	
	

	}

}
