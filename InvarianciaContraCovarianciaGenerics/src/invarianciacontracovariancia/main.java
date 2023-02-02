package invarianciacontracovariancia;

import java.util.ArrayList;
import java.util.List;

import entidades.Animal;
import entidades.Cao;
import entidades.PastorAlemao;
import entidades.Pug;

public class main {

	public static void main(String[] args) {

		//declaração e instanciação dos objetos. 
		//Objeto Pug implementa dois parametros (generics) que é definido no momento da instaciação
		//Generics são invariantes ou seja não admite casting tala como na declaração
		//List<Integer> i = new ArrayList<String>(); desta forma ocorreria um erro de compilação
		Pug pug1 = new Pug(12, "laulau");
		Pug pug2 = new Pug("xoxo", 34);
		PastorAlemao pa = new PastorAlemao("CHUCHU", 12);

		// type safety : estou tipando a lista dessa forma só aceitara elementos do tipo
		// Cao ou de suas
		// subclasses. É realizado um casting implicito quando inserir subclasses.
		List<Cao> lcao = new ArrayList<>();
		
		//atribuição de objetos diferentes na lista do objeto pai Cao
		lcao.add(pa);
		lcao.add(pug1);
		lcao.add(pug2);

		//recebe um lista de um tipo qualquer de subtipo de cao em seguida atribui um lista de Cao
		List<? extends Cao> cao = new ArrayList<>();
		cao = lcao;
		cao.forEach(System.out::println);
		
		//cria uma classe de Objetos recebendo um lista do tipo Cao
		List<Object> cao2 = new ArrayList<>(lcao);

		processElements(lcao);
		insereElements(cao2);
		System.out.println(cao2);

	}
	// covariancia : List<? extends Animal> nesta caso estamos informando que o
	// metodo processElements
	// recebera uma lista de qualquer tipo que extende animal ou seja subclasses.
	// Não admite inserção de elementos

	public static void processElements(List<? extends Animal> elements) {
		for (Animal a : elements) {
			System.out.println(a);
		}
	}
	
	//  ContraVariancia - Quando utilizamos <? super Numbers> estamos indicando que a 
	//  variavel passada como paramero podera ser do tipo Numbers ou da sua super. classe.
	//  Desta forma admite inser��o porque poder� ser valores aceitos pelas classes 
	// a contravariança admite inserção porque sabemos que se estou recebendo uma lista de algum tipo 
	// de super classe de Animal logo consigo inserir um Animal (respeitando o principio de liskov onde 
	// suas subclasses podem substituir sua super classe sem gerar uma exceção)
	// 
	
	public static List<?> insereElements(List<? super Animal> elements) {
			Animal animal = new Animal("Jorge", 43);
			elements.add(animal);
		return elements;
	}
	

}
