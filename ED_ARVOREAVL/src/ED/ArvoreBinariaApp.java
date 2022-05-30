package ED;

import java.util.Scanner;


class ArvoreBinariaApp {
	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		Arvore arv = new Arvore();
		int opcao, qtdEle;
		long x;
		System.out.print("\n Programa Arvore binaria de long");
		do {
			System.out.print("\n***********************************");
			System.out.print("\nEntre com a opcao:");
			System.out.print("\n ----1: Inserir");
			System.out.print("\n ----2: Excluir");
			System.out.print("\n ----3: Pesquisar");
			System.out.print("\n ----4: Exibir");
			System.out.print("\n ----5: Sair do programa");
			System.out.print("\n***********************************");
			System.out.print("\n-> ");
			opcao = le.nextInt();
			switch(opcao) {
			case 1: {
				System.out.print("\n Informe quantos elementos (long) -> ");
				qtdEle = le.nextInt();
				
				for(int i = 0; i < qtdEle; i++) {
					x = le.nextLong();
					arv.inserir(x);
				}
				
				break;
			}
			case 2: {
				System.out.print("\n Informe o valor (long) -> ");
				x = le.nextLong();
				if ( !arv.remover(x) )
					System.out.print("\n Valor nao encontrado!");;
					break;
			}
			case 3: {
				System.out.print("\n Informe o valor (long) -> ");
				x = le.nextLong();
				if( arv.buscar(x) != null )
					System.out.print("\n Valor Encontrado");
				else 
					System.out.print("\n Valor nao encontrado!");
				break;
			}	 
			case 4: {
				arv.exibir();
				break; 
			}
			} 
		} while(opcao != 5);

	}
}