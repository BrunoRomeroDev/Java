package main;

import java.util.ArrayList;
import java.util.List;

import Entidades.Automoveis;
import Entidades.Caminhao;
import Entidades.Carros;
import Entidades.Moto;
import Entidades.Veiculo;
import EnumEntidades.TipoCarros;
import EnumEntidades.TipoMoto;

public class main {

	public static void main(String[] args) {
		
		List l = new ArrayList();
		
		Carros c1 = new Carros();
		c1.setCor("SUV");
		c1.setTc(TipoCarros.SUV);
		c1.setPortas(5);
		c1.setCc(1000);
		c1.setPlaca("ABC 1234");
		
		
		Moto m1 = new Moto();
		m1.setModelo("TENERE");
		m1.setTm(TipoMoto.TRAIL);
		m1.setPlaca("POI 6547");
		
		Caminhao cam1 = new Caminhao();
		cam1.setEixo(3);
		cam1.setTamanho(12.5);
		cam1.setPlaca("IUG 3578");
		
		Automoveis auto1 = new Automoveis();
		auto1.setPlaca("tre 9874");
		// no type savaty
		//não ocorre erro de compilação mas pode ocorrer erro de execução devido a não saber quais são os objetos inseridos.
		
		l.add(c1);
		l.add(cam1);
		l.add(m1);
		
		l.forEach(System.out::println);
		
		
		// Podemos resolver possiveis erros de execução com instanceof usando a função de cast 
		
		
		for(Object a: l) {
			if(a instanceof Carros) {
				((Carros) a).setCor("AZUL");
			}
		}
		
		System.out.println("---------------Carro alterado--------------");
		l.forEach(System.out::println);
		
		// downcast é realizado a conversão da classe em alguma subclasse. Ocorre de forma explicita 
		// possivel erro de execução 
		Object ob1 = new Object();		
		//Integer i =  (Integer) ob1;//ocorre erro
		
		// upcast é realizado a conversão da classe em um super classe. ocorre de forma Implicita
		Integer r = null;
		Object ob2 = new Object();
		ob2 = r;
		
		// type savety
		//para realizar esta logica com type savety usamos generics garantindo que minha lista tera apenas um tipo
		// automoveis aceitara qualquer tipo porem uma vez iniciada a lista inteira será daquele tipo
		//assim garantimos que será atribuido apenas valores daquel tipo especifico
		
		
		List<Carros> lc = new ArrayList<>();
		lc.add(c1);
		lc.forEach(System.out::println);
		
		List<Caminhao> licam = new ArrayList<>();
		licam.add(cam1);
		
		List<Moto> lm = new ArrayList<>();
		lm.add(m1);
		
		// se recebermos uma lista de objetos de varios tipo utilizamos Covariancia List<? extends Automoveis>
		//ou contravariancia List<? super Automoveis> para trabalhar de forma que não há erros.
		//o metodo adicionar recebe uma lista de qualquer subtipo de Automoveis (covariancia) 
		//entretanto a lista covariante nao aceita inserções devido a não saber qual sera o objeto
		//
				
		List<? super Automoveis> lf = new ArrayList<>();
		lf.addAll(lc);
		lf.addAll(licam);
		lf.addAll(lm);
		
		System.out.println("---------------Lista de Automoveis --------------");
		System.out.println(lf);
		
		// Generics define um parametro para a classe conforme na classe Veiculo e pode-se definir qualquer 
		// qualquer tipo para o parametro
		
		Veiculo v = new Veiculo(c1);
		System.out.println("-------------------veiculo via generics-------------------");
		System.out.println(v);
		
		v.setVeiculo(m1);
		System.out.println("-------------------veiculo via generics alterado-------------------");
		System.out.println(v);
	}
	
	public static List<? super Automoveis> adicionar(List<? extends Automoveis> la){
			List<? super Automoveis> lg = new ArrayList<>();
			for(Automoveis auto:la) {
				lg.add(auto);
			}
		return lg;
		
	}

}
