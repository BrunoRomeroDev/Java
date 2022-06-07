package ED;

import java.util.ArrayList;
import java.util.List;

public class ListaDuplamenteLigada {
	
	List<No> alist = new ArrayList<>();

	public ListaDuplamenteLigada() {			

	}	

	public void adicionar(Object obj) {
		if(alist.isEmpty()) {
			alist.add(new No(obj,null,null));
		}else {
			alist.get(alist.size()-1).setNext(obj);
			alist.add(new No(obj,alist.get(alist.size()-1).getNo(),null));
		}

	}
	public void remover(Object obj) {
		boolean rem = false;
		for(int n = 0;n<(alist.size()-1);n++) {
			if(alist.get(n).getNo() == obj) {
				alist.remove(n);
				rem = true;
			}
			if(rem) {
				 alist.get(n-1).setNext(alist.get(n).getNo()); 
				 alist.get(n).setPrev(alist.get(n-1).getNo());
			}
		}
		
	}
	public void exibir() {
		System.out.println("Lista criada com "+alist.size()+". Nó(s) ");
		for(No nos:alist) {
			System.out.println("No " +nos.toString());
		}
	}
	
	public void exibir(Object obj) {
		for(No nos:alist) {
			if(nos.getNo().equals(obj)) {		
				System.out.println("-------------------");
				System.out.println("No " +nos.toString());
			}
		}
	}
}