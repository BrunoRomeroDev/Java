package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
		List<Double> myDoubles = Arrays.asList(3.14, 6.28);
		List<Object> myObjs = new ArrayList<Object>();
		copy(myInts, myObjs);
		printList(myObjs);
		copy(myDoubles, myObjs);
		printList(myObjs);
	}
	/* Covariancia - Quando utilizamos <? extends Numbers> estamos indicando que a
	 *  variavel  passada como paramero podera sera de qualquer 
	 *  tipo(generic ?) e de qualquer SUBCLASSE . 
	 *  Não permite que seja inserido itens pois pode ser de qualquer tipo.
	 *  
	 *  
	 *  ContraVariancia - Quando utilizamos <? super Numbers> estamos indicando que a 
	 *  variavel passada como paramero podera ser do tipo Numbers ou da sua super. classe.
	 *  Desta forma admite inserção porque poderá ser valores aceitos pelas classes */
	
	public static void copy(List<? extends Number> source, List<? super Number> destiny) {
		for (Number number : source) {
			destiny.add(number);
		}
	}

	public static void printList(List<?> list) {
		for (Object obj : list) {
			System.out.print(obj + " ");
		}
		System.out.println();
	}
}
