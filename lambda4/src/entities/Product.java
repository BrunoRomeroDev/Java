package entities;

import java.util.Comparator;

public class Product implements Comparator<Product>, Comparable<Product>{

	private String name;
	private Double price;
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String nonStaticUpperCaseName() {
		return name.toUpperCase();
	}
	
	public static String staticUpperCaseName(Product p) {
		return p.getName().toUpperCase();
	}
	
	@Override
	public String toString() {
		return name + ", " + String.format("%.2f", price);
	}

	@Override
	public int compare(Product o1, Product o2) {
		
		return o1.getPrice() >= o2.getPrice()?1:2;
	}

	@Override
	public int compareTo(Product o) {
		
		return this.getName().compareTo(o.getName());
	}
}
