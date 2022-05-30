package ED;

public class Arvore {
	private No root; 

	public Arvore() {
	root = null;  
	}
	public void inserir(long v) {
		No no1 = new No(); 
		no1.setItem(v);
		no1.setDir(null);
		no1.setEsq(null);

		if (root == null) {
			root = no1;
		}
		else  { 
			No atual = root;
			No anterior;
			while(true) {
				anterior = atual;
				if (v <= atual.getItem()) { 
					atual = atual.getEsq() ;
					if (atual == null) {
						anterior.setEsq(no1) ;
						return;
					} 
				} 
				else { 
					atual = atual.getDir();
					if (atual == null) {
						anterior.setDir(no1);
						return;
					}
				} 
			} 
		}

	}

	public No buscar(long chave) {
		if (root == null) return null; 
		No atual = root;  
		while (atual.getItem() != chave) { 
			if(chave < atual.getItem() ) 
				atual = atual.getEsq(); 
			else atual = atual.getDir(); 
			if (atual == null) return null; 
		} 
		return atual; 
	}


	public boolean remover(long v) {
		if (root == null) return false; 

		No atual = root;
		No pai = root;
		boolean filho_esq = true;


		while (atual.getItem() != v) { 
			pai = atual;
			if(v < atual.getItem() ) { 
				atual = atual.getEsq();
				filho_esq = true; 			}
			else { 
				atual = atual.getDir(); 
				filho_esq = false; 
			}
			if (atual == null) return false; 
		} 

		
		if (atual.esq == null && atual.getDir() == null) {
			if (atual == root ) root = null; 
			else if (filho_esq) 
				pai.setEsq(null); 
			else pai.setDir(null); 
		}

		
		else if (atual.getDir() == null) {
			if (atual == root) root = atual.esq; 
			else if (filho_esq) 
				pai.setEsq(atual.getEsq())  ; 
			else pai.setDir(atual.getEsq()) ;
		}

		
		else if (atual.esq == null) {
			if (atual == root) 
				root = atual.getDir(); 
			else if (filho_esq)
				pai.setEsq(atual.getDir())  ; 
			else pai.setDir(atual.getDir()) ; 
		}

		
		else {
			No sucessor = no_sucessor(atual);
			
			if (atual == root) root = sucessor; 
			else if(filho_esq) 
				pai.setEsq(sucessor)  ;
			else pai.setDir(sucessor) ; 
			sucessor.setEsq(atual.getEsq()) ; 
			
		}

		return true;
	}

	
	public No no_sucessor(No apaga) { 
		No paidosucessor = apaga;
		No sucessor = apaga;
		No atual = apaga.getDir(); 

		while (atual != null) { 
			paidosucessor = sucessor;
			sucessor = atual;
			atual = atual.getEsq(); 
		} 
		
		if (sucessor != apaga.getDir()) { 
			paidosucessor.setEsq(sucessor.getDir())  ; 
			

			sucessor.setDir(apaga.getDir()) ; 
			
		}
		return sucessor;
	}

	public void exibir() {

		System.out.print("\n Altura da arvore: " + altura(root));
		System.out.print("\n Quantidade de folhas: " + folhas(root));
		System.out.print("\n Quantidade de Nós: " + contarNos(root));
		if (root != null ) {  
			System.out.print("\n Valor minimo: " + min().item);
			System.out.println("\n Valor maximo: " + max().item);
		}
		
		for(int n = 1;n< contarNos(root);n++ ){
			System.out.println(" Nó " +root.toString() );
			
		}
			
	}


	public int altura(No atual) {
		if(atual == null || (atual.getEsq() == null && atual.getDir() == null))
			return 0;
		else {
			if (altura(atual.getEsq()) > altura(atual.getDir()))
				return ( 1 + altura(atual.getEsq()) );
			else
				return ( 1 + altura(atual.getDir()) );
		}
	}

	public int folhas(No atual) {
		if(atual == null) return 0;
		if(atual.getEsq() == null && atual.getDir() == null) return 1;
		return folhas(atual.getEsq()) + folhas(atual.getDir());
	}

	public int contarNos(No atual) {
		if(atual == null)  return 0;
		else return ( 1 + contarNos(atual.getEsq()) + contarNos(atual.getDir()));
	}

	public No min() {
		No atual = root;
		No anterior = null;
		while (atual != null) {
			anterior = atual;
			atual = atual.getEsq();
		}
		return anterior;
	}

	public No max() {
		No atual = root;
		No anterior = null;
		while (atual != null) {
			anterior = atual;
			atual = atual.getDir();
		}
		return anterior;
	}
}
