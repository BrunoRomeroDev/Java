package application;

import java.util.Scanner;

import services.PrintService;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PrintService<Integer> ps = new PrintService<>();
		PrintService<String> pc = new PrintService<>();
		
		System.out.print("Quantos Valores? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.print("Insira o "+(i+1)+"° valor ");
			Integer value = sc.nextInt();
			ps.addValue(value);
		}
		
		System.out.print("Quantos Textos ");
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			System.out.print("Insira o "+(i+1)+"° texto ");
			String text = sc.next();
			pc.addValue(text);
		}

		ps.print();
		Integer x = ps.first();
		System.out.println("First: " + x);
		
		pc.print();
		String y = pc.first();
		System.out.println("First: " + y);
		
		sc.close();
	}
}