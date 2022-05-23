package application;

import java.util.Scanner;

import entities.circulo;
import entities.forma;
import entities.quadrado;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a quantidade de arestas da forma :");
		int qa = sc.nextInt();
		
		System.out.println("Digite a cor da forma: ");
		String cor = sc.nextLine();
		sc.nextLine();
		
		switch (qa){
			case 1: 
				forma fc = new circulo(qa,cor);
			break;
			case 2:
				System.out.println("Digite o valor do lado: ");
				double lado = sc.nextInt();
				System.out.println("Digite o valor da base: ");
				double base = sc.nextInt();
				quadrado fq = new quadrado(qa,cor,lado,base);
				fq.setArea();
				System.out.println("Area é :"+fq );
			break;	
		default:
			System.out.println("Não é um forma prevista pra calculo!");
		
		}
		sc.close();

	}

}
