package aplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class main {

	public static void main(String[] args) {

		Carros car1 = new Carros("Corsa","summer",1985,true);
		Carros car2 = new Carros("Celta","winter",1999,true);
		Carros car3 = new Carros("Porsche","Carrera",2085,true);
		Carros car4 = new Carros("Peugeot","207",2010,true);
		Carros car5 = new Carros("Corsa","summer",1977,true);
		
		Moto moto1 = new Moto("CG",2000,"asd");
		Moto moto2 = new Moto("FAZER",2021,"new");
		Moto moto3 = new Moto("750",2017,"old");
		Moto moto4 = new Moto("suzuki",2001,"1200");
		
		ArrayList<Moto> arrayMoto = new ArrayList<>();
		
		arrayMoto.add(moto1);
		arrayMoto.add(moto2);
		arrayMoto.add(moto3);
		arrayMoto.add(moto4);
		
		
		ArrayList<Carros> arrayCar = new ArrayList<>();
		
		arrayCar.add(car1);
		arrayCar.add(car2);
		arrayCar.add(car3);
		arrayCar.add(car4);
		arrayCar.add(car5);
		
		List<Object> auto = new ArrayList<>();
		
		arrayCar.forEach(c ->{auto.add(c);});
		
		arrayMoto.forEach(m ->{auto.add(m);});
		
		System.out.println(auto);
		
		System.out.println("----Sem ordenação----");
		for(Carros c: arrayCar) {
			System.out.println("Carros: "+c);
		}
		
		Collections.sort (arrayCar);
		System.out.println("----Ordenado por ano----");
		for(Carros c: arrayCar) {
			
			System.out.println("Carros: "+c);
		}
		
		arrayCar.get(0);
		System.out.println("----Ordenado por Modelo----");
		Collections.sort(arrayCar,Comparator.comparing(Carros::getModelo));
		for (Carros c : arrayCar) {

			System.out.println("Carros: " + c);
		}

		
		if(car1.equals(car5)) {
			System.out.println(car1.getName()+"iguail a: "+car5.getName());
		}
		
		arrayCar.forEach(c ->{ System.out.println("Percorrendo: ");
							   System.out.println("Carro: "+c);});
	}
	
	

}
