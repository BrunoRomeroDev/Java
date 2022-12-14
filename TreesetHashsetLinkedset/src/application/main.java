package application;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import entidades.Variavel;

public class main {

	public static void main(String[] args) {
		
		System.out.println("\n------------HashSet------------\n");
		
		HashSet<Variavel> hset = new HashSet<Variavel>();
		hset.add(new Variavel(2));
		hset.add(new Variavel(1));
		hset.add(new Variavel(3));
		hset.add(new Variavel(5));
		hset.add(new Variavel(45));
		hset.add(new Variavel(65));
		hset.add(new Variavel(9));
		hset.add(new Variavel(44));
		
		Iterator<Variavel> iterator0 = hset.iterator();
		while (iterator0.hasNext()) {
			System.out.print(iterator0.next() + " ");
		}
		
		System.out.println("\n------------TreeSet------------\n");
		
		TreeSet<Variavel> tset = new TreeSet<Variavel>();
		tset.add(new Variavel(2));
		tset.add(new Variavel(1));
		tset.add(new Variavel(3));
		tset.add(new Variavel(12));
		tset.add(new Variavel(32));
		tset.add(new Variavel(11));
		tset.add(new Variavel(9));
		tset.add(new Variavel(89));
		tset.add(new Variavel(123));

		Iterator<Variavel> iterator = tset.iterator();

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	
		System.out.println("\n------------LinkedHashSet------------\n");
		
		LinkedHashSet<Variavel> lset = new LinkedHashSet<Variavel>();
		lset.add(new Variavel(2));
		lset.add(new Variavel(1));
		lset.add(new Variavel(3));
		lset.add(new Variavel(5));
		lset.add(new Variavel(4));
		
		Iterator<Variavel> iterator2 = lset.iterator();
		while (iterator2.hasNext()) {
			System.out.print(iterator2.next() + " ");
		}

	}

}
