package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv LG",10.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet POSITIVO", 350.50));
		list.add(new Product("HD Case", 80.90));
		list.add(new Product("HD Case KIMGSTON", 120.88));
		list.add(new Product("Tablet SAMSUNG", 350.50));
		
		
		System.out.println("----------Lista em maiusculo------------------");
		List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		names.forEach(System.out::println);
		
		System.out.println("-----------Filtro de itens com a letra T-----------------");
		List<Product> po = list.stream()
				.filter(a -> a.getName().charAt(0) == 'T')
				.collect(Collectors.toList());
		po.forEach(System.out::println);

		System.out.println("----------Ordena por preço------------------");
		//po.sort((a,b) -> a.getPrice() >= b.getPrice()?1:2);
		list.sort((a,b) -> a.getPrice().compareTo(b.getPrice()));
		list.forEach(System.out::println);
		
		System.out.println("------------Ordem inversa----------------");
		Collections.sort( list, Collections.reverseOrder());
		list.forEach(System.out::println);
		
		System.out.println("-----------Ordena por name(definido no comparable da classe)-----------------");		
		Collections.sort( list);		
		list.forEach(System.out::println);	
		
		System.out.println("-----------Ordem inversa(segundo metodo)-----------------");		
		list.sort(Collections.reverseOrder());
		list.forEach(System.out::println);
		
		System.out.println("-----------Tamanho da lista-----------------");		
		System.out.println(list.spliterator().getExactSizeIfKnown());
		
		System.out.println("-----------Filtra produtos com preço maior a R$60,00-----------------");	
		list.removeIf((a) -> a.getPrice() <= 60.00);
		list.forEach(System.out::println);
		
		System.out.println("-----------Soma os valores -----------------");		
		System.out.println((list.stream().mapToDouble(Product::getPrice).sum()));
		System.out.println((list.stream().mapToDouble(p ->p.getPrice()).sum()));
		
		System.out.println("-----------Soma os valores -----------------");
		list.stream()
		.filter(x -> x.getName() == "HD Case")
		.findFirst()
		.orElse(null);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
