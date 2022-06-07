package ED;

public class main {

	public static void main(String[] args) {
		
		ListaDuplamenteLigada ldl1 = new ListaDuplamenteLigada();
		ldl1.adicionar(43);
		ldl1.adicionar(54);
		ldl1.adicionar(65);
		ldl1.adicionar(12);
		ldl1.adicionar(11);
		ldl1.remover(54);
		ldl1.exibir();
		ldl1.exibir(11);
	}

}
