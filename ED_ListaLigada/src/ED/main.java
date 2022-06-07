package ED;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		
		ListaLigada l1 = new ListaLigada();
		
		l1.addInicio(10);
		l1.addFinal(32);
		l1.addMeio(12,1);//valor maiores que 1  
		l1.addFinal(552);
		l1.addFinal(96);
		JOptionPane.showMessageDialog(null, l1.BuscarElemento(32) );
		JOptionPane.showMessageDialog(null, l1.mostrar() );

	}

}
