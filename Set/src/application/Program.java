package application;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		Set<String>  a = new HashSet<>();
		Set<String> b = new HashSet<>();
		Set<Integer> c = new HashSet<>();
		
		System.out.print("QUANTOS ALUNOS NO CURSO A? ");
		int na = sc.nextInt();
		for (int i=0; i<na; i++) {
			String nome = sc.next();
			a.add(nome);
		}

		System.out.print("QUAis materias para o curso A? ");
		int nb = sc.nextInt();
		for (int i=0; i<nb; i++) {
			String materia = sc.next();
			b.add(materia);
		}

				
		Set<String> total = new HashSet<>(a);
		total.addAll(b);
		
		for (String p : total) {

			System.out.println(p);
			
			
		}
		System.out.println("Total students: " );

		sc.close();
	}
}