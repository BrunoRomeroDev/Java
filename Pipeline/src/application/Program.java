package application;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {
		
		float fator =  0.3048f;
		List<Integer> list = Arrays.asList(42,32,10);
		Stream<Object> st1 = list.stream().map(x -> x * fator);
		
		System.out.println("Valores em P�s");
		System.out.println(Arrays.toString(list.toArray()));
		
		List<Object> newList = list.stream()
		.filter(x -> x % 2 == 0)
		.map(x -> x * fator)
		.collect(Collectors.toList());
		System.out.println("Lista dos valore convertidos em metros utilizando Pipeline \n"+ Arrays.toString(newList.toArray()));
		
	}

}
