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
		
		System.out.println("-----------Filtra HD valores -----------------");
		System.out.println(list.stream()
				.filter(x -> x.getName() == "HD Case")
				.findFirst()
				.orElse(null));
		
		System.out.println("-----------Tudo em maiusculo -----------------");
		List<String> list2 =  list.stream().map(a->Product.staticUpperCaseName(a)).collect(Collectors.toList());
		list2.forEach(System.out::println);
		
		System.out.println("-----------Concatena Strings -----------------");
		String teste = "";
		List<String> stringconcat = new ArrayList<String>();
		
		stringconcat.add(" teste ");
		stringconcat.add(" de ");
		stringconcat.add(" concatenar ");
		stringconcat.add(" Strings ");
		
		System.out.println(stringconcat.stream().map(s -> teste.concat(s)).collect(Collectors.toList())); 
		
		System.out.println("-----------Cria um list através de um Array -----------------");
		String text1 = "Teste";
		String text2 = "De";
		String text3 = "Concat";
		String text4 = "texto";
		
		Double num1 = 12.0;
		Double num2 = 13.0;
		Double num3 = 14.0;
		
		variavel varNum = new variavel();
		
		List<Double> numeros = Arrays.asList(varNum.numerosEncadeados(num1,num2,num3));
		numeros.forEach(x -> System.out.println(x));
		
		int v[] = { 1, 2, 3, 4, 15 };
		List<Integer> lista = Arrays
		    .stream(v)		    
		    .boxed()
		    .collect(Collectors.toList());
		
		lista.forEach(x -> System.out.println(x));
		
		System.out.println(lista);
		
		variavel varText = new variavel();
		
		List<String> s = Arrays.asList(varText.textosEncadeados(text1,text2,text3,text4));
		System.out.println(s);
		
	}
}
