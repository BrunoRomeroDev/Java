package pricnipal;

import java.util.regex.Pattern;

public class Principal {

	public static void main(String[] args) {
		

		System.out.println(Pattern.matches(".s", "as"));//true (2nd char is s)  
		System.out.println(Pattern.matches(".s", "mk"));//false (2nd char is not s)  
		System.out.println(Pattern.matches(".s", "mst"));//false (has more than 2 char)  
		System.out.println(Pattern.matches(".s", "amms"));//false (has more than 2 char)  
		System.out.println(Pattern.matches("..s", "mas"));//true (3rd char is s) 
		System.out.println("----------------------------------------");
		
		
		//[ abc ]	a, b ou c ( classe simples )
		//[ ^ abc ]	Qualquer caractere, exceto a, b ou c ( negação )
		//[ a-zA-Z ]	a a a z ou A a Z, inclusive ( intervalo )
		//[ a-d [ m-p ] ]	a a d ou m a p: [ a-dm-p ] ( união )
		//[ a-z && [ def ] ]	d, e ou f ( interseção )
		//[ a-z && [ ^ bc ] ]	a a a z, exceto bec: [ ad-z ] ( subtração )
		//[ a-z && [ ^ m-p ] ]	a a a z, e não m a p: [ a-lq-z ] ( subtração )
		
		
		System.out.println(Pattern.matches("[amn]", "abcmern"));//false (não a ou m ou n)  
		System.out.println(Pattern.matches("[amn]", "a"));//true (entre a ou m ou n)  
		System.out.println(Pattern.matches("[amn]", "ammmna"));//false (m e a vem mais de uma vez)
		System.out.println("----------------------------------------");
		
		//X?	X ocorre uma vez ou não ocorre
		//X+	X ocorre uma vez ou mais
		//X*	X ocorre zero ou mais vezes
		//X{n}	X ocorre n vezes apenas
		//X{n,}	X ocorre n ou mais vezes
		//X{y,z}	X ocorre pelo menos y vezes, mas menos que z vezes
		
		System.out.println ("? quantificador ....");  
		System.out.println ( Pattern.matches ("[ amn ]?", "uma") );//true ( a ou m ou n vem uma vez )  
		System.out.println ( Pattern.matches ("[ amn ]?", "aaa") );//false ( a vem mais de uma vez )  
		System.out.println ( Pattern.matches ("[ amn ]?", "aammmnn") );//false ( a me n vem mais de uma vez )  
		System.out.println ( Pattern.matches ("[ amn ]?", "aazzta") );//false ( a vem mais de uma vez )  
		System.out.println ( Pattern.matches ("[ amn ]?", "sou") );//falso ( a ou m ou n deve vir uma vez )  
		System.out.println("----------------------------------------");
		
		System.out.println ("Quantificador "+ "....");  
		System.out.println ( Pattern.matches ("[ amn ] +", "uma") );//true ( a ou m ou n uma ou mais vezes )  
		System.out.println ( Pattern.matches ("[ amn ] +", "aaa") );//true ( a vem mais de uma vez )  
		System.out.println ( Pattern.matches ("[ amn ] +", "aammmnn") );//true ( a ou m ou n vem mais de uma vez )  
		System.out.println ( Pattern.matches ("[ amn ] +", "aazzta") );//false ( z e t não correspondem ao padrão )  
		System.out.println("----------------------------------------");
		
		System.out.println ("* quantificador ....");  
		System.out.println ( Pattern.matches ("[ amn ]*", "ammmna") );//true ( a ou m ou n pode vir zero ou mais vezes )
		
		//		.	Qualquer caractere ( pode ou não corresponder ao terminador )
		//		\d	Quaisquer dígitos, com menos de [ 0-9 ]
		//		\D	Qualquer não dígito, abreviação de [ ^ 0-9 ]
		//		\s	Qualquer caractere de espaço em branco, abreviação de [ \ t \ n \ x0B \ f \ r ]
		//		\S	Qualquer caractere que não seja do espaço em branco, abreviação de [ ^ \ s ]
		//		\w	Qualquer caractere de palavra, abreviação de [ a-zA-Z_0-9 ]
		//		\W	Qualquer caractere sem palavra, abreviação de [ ^ \ w ]
		//		\b	Um limite de palavras
		//		\B	Um limite sem palavras
		
		System.out.println ("metacaracteres d...."); // d significa dígito  
		System.out.println ( Pattern.matches ("\\d", "abc") );//falso ( não dígito )  
		System.out.println ( Pattern.matches ("\\d", "1") );//verdadeiro ( dígito e vem uma vez )  
		System.out.println ( Pattern.matches ("\\d", "4443") );//falso ( dígito, mas vem mais de uma vez )  
		System.out.println ( Pattern.matches ("\\d", "323abc") );//falso ( dígito e carvão )  
		System.out.println("----------------------------------------");
		
		System.out.println ("metacaracteres D...."); // D significa não-dígito    
		System.out.println ( Pattern.matches ("\\D", "abc") );//falso ( não dígito, mas vem mais de uma vez )  
		System.out.println ( Pattern.matches ("\\D", "1") );//falso ( dígito )  
		System.out.println ( Pattern.matches ("\\D", "4443") );//falso ( dígito )  
		System.out.println ( Pattern.matches ("\\D", "323abc") );//falso ( dígito e carvão )  
		System.out.println ( Pattern.matches ("\\D", "m") );//true ( não dígito e vem uma vez )  
		System.out.println("----------------------------------------");
		
		System.out.println ("metacaracteres D com quantificador....");  
		System.out.println ( Pattern.matches ("\\D*", "mak") );//true ( não dígito e pode vir 0 ou mais vezes )  
	}

}
