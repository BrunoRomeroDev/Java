package Serializar;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Entidades.Produto;

public class Serializar {

		
	public static void serializar(Produto prod) {
		Path path = Paths.get("pasta/produto.ser");
		try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))){
			oos.writeObject(prod);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object deserializar() {
		Path path = Paths.get("pasta/produto.ser");
		Produto prod = null;
		try(ObjectInputStream ois = new  ObjectInputStream(Files.newInputStream(path))){
			 prod = (Produto) ois.readObject();
			
		}catch (IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return prod;
		
	}
	
	
}
