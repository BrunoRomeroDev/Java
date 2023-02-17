package application;

import java.io.IOException;

import application.Produto.tributos;

public class program {

	

	public static void main(String[] args) throws IOException {
	
		Produto prod = new Produto();
		prod.setId(1);
		prod.setName("KXT100");
		prod.setPreco(100.00);
		prod.desconto();
		//classe interna ou aninhada. Visivel no escopo da classe 
		//Necessário instanciar a classe principal para conseguir instaciar a classe aninhada
		//se for static é possivel instanciar sem a classe principal
		tributos tr = prod.new tributos();
		tr.setCOFINS(0.65);
		tr.setPIS(3.3);
		tr.setIPI(12);
		tr.setICMS(23);
		
		System.out.println(tr);
		System.out.println(prod);
		
		//classe local instaciada apenas dentro de um metodo de algum outra classe
		//visivel apenas no escopo da classe
		tr.calculo(2, 4, 0.54,2.2 );
		System.out.println(tr);
		
		//A classe anonima sobreescreve em tmepo de execução um determinado metodo .
		//equivale a ciar um classe filha que extends a classe pai (Produto) e 
		//insere novos metodos criando uma nova logica apenas pra esse objeto em tmepo de execução;
		//ela é declarada logo após da instaciação da classe. é considerada anonima justamente
		//por nao ter um novo dessa classe que extends a classe pai e sobreescreve a classe filha.
		Produto prod2 = new Produto(2,"KXT200",200.00) {
			public void desconto() {
				 setPreco(this.preco * 0.60);
			}
		};
		prod2.desconto();
		System.out.println(prod2);
		

	}

}
