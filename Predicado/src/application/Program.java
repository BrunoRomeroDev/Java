package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Predicate;

import entities.Product;
import util.ProductPredicate;

public class Program {
	
	private static boolean result ;
	public static void main(String args[]){
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Tv",110.00));
		list.add(new Product("Mouse",50.0));
		list.add(new Product("Tablet",150.0));
		list.add(new Product("Hd Cable",80.90));
		
		
				
		//-------Implementação de interface----
		list.removeIf(new ProductPredicate());
		
		//-------Referencia par ao Metodo static-------
		
		list.removeIf(Product::staticProductPredicate);
		
		//-------Referencia par ao Metodo Não-static-------
		
		list.removeIf(Product::nonStaticProductPredicate);
		
		//--------Expressão lambda Declarada--------------
		
		Predicate<Product> pred = p -> p.getPrice() >= 100.0;
		list.removeIf(pred);
		
		//-------Expressão Lambda Declarado inline------
				list.removeIf(p -> p.getPrice()>= 100.0);
				
				
		for (Product p : list) {

			System.out.println(p);
			
			
		}
		
				
		
	}

}
