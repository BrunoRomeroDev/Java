package application;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;

public class program {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Function<Integer,Integer> functionumero;
		BiFunction<Double,Double,Double> Doublenumero;
		
		functionumero =(m)->m/10;
		System.out.print("Recebe um argumento e devolve um resultado.\nResult Function: \n "+functionumero.apply(100));
		
		Doublenumero = (a,b) -> a/b;
		System.out.println("\nResultado do Bifunction.\n Result: \n"+Doublenumero.apply(50.0,2.0));
		
		
		System.out.println("\nResult: \n"+functionumero.apply(10)
		.divideUnsigned(functionumero.apply(10),2));
		
	
		DoubleToIntFunction truncate = a -> (int) a;
		
		System.out.println("\n Resultado da func Funcional DoubleToIntFunction: \n"+truncate.applyAsInt(23.56));
		
		DoubleToLongFunction l = a -> (long) a;
		
		System.out.println("\n Resultado da func Funcional DoubleToIntFunction: \n"+l.applyAsLong(1239.34));
		
		
		IntFunction<Integer> result = (x) -> x+x;
		
		System.out.println("\n Resultado funçã IntFunction: \n"+result.apply(32));
		
		BinaryOperator<Integer> comp = (x,y)-> x.compareTo(y);
		
		System.out.println("\n Resultado de BinaryOperator<t>: \n"+comp.apply(180,30));
		
		 Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		 
		 System.out.println("\n Referencia ao metodo, math,binary operator  \n");

	        Integer resultado = math(Arrays.asList(numbers), 0, (a, b) -> a + b);

	        System.out.println(resultado); // 55

	        Integer result2 = math(Arrays.asList(numbers), 0, Integer::sum);

	        System.out.println(result2); // 55
	        
	        // Binary operator defined to divide
	        // factorial of two numbers
	        
	        System.out.println("\n Resultado de BinaryOperator<t> para calculo de fatorial: \n");
	        IntBinaryOperator binaryOperator = (x, y) ->
	        {
	            int fact1 = 1;
	            for (int i = 2; i <= x; i++) {
	                fact1 *= i;
	            }
	            int fact2 = 1;
	            for (int i = 2; i <= y; i++) {
	                fact2 *= i;
	            }
	            return fact1 / fact2;
	        };
	  
	        System.out.println("5! divided by 7! = "
	                           + binaryOperator.applyAsInt(5, 7));
	        System.out.println("7! divided by 5! = "
	                           + binaryOperator.applyAsInt(7, 5));
	    
	        // Create the first list
	        List<Integer> lista = new ArrayList<Integer>();
	        lista.add(2);
	        lista.add(1);
	        lista.add(3);
	 
	        // Create the second list
	        List<Integer> listb = new ArrayList<Integer>();
	        listb.add(2);
	        listb.add(1);
	        listb.add(2);
	 
	        System.out.println("\n Resultado de BiConsumer \n");
		BiConsumer<List<Integer>,List<Integer>> equalsteste = (list1,list2) ->
		{
			if(list1.size() != list2.size()) {
				System.out.println("False");
			}else {
				for(int i =0; i<list1.size();i++)
					if(list1.get(i) != list2.get(i)){
						System.out.println("False");
												
					}
				System.out.println("True");
			}
		};
		
		equalsteste.accept(lista, listb);
		
	
		System.out.println("\n Resultado de Biconsumer com andThen \n");
        // BiConsumer to print 2 lists
        BiConsumer<List<Integer>, List<Integer> > disp = (list1, list2) ->
        {
            list1.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
            list2.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
        };
 
        // Using addThen() method
        equalsteste.andThen(disp).accept(lista, listb);
        
        BiConsumer<Integer,Double> numeros = (x,y) ->
        {
        	System.out.println("multiplicacao"+x*y);
        };
        
        numeros.accept(10,42.34);
        
        System.out.println("\n Resultado de BooleanSupplier  \n");
        Integer n= 12;
        BooleanSupplier sup = () -> n % 2 != 0 ? false : true;
        
        // Get the boolean value
        // Using getAsBoolean() method
        System.out.println(sup.getAsBoolean());
        
        System.out.println("\n Resultado de Consumer<T>  \n");
        
        Consumer<String> nomex = (s) -> System.out.println("\n Resultado de Consumer\n"+s);
        nomex.accept("Texto a ser mostrado");
        
        System.out.println("\n Resultado de Supplier\n");
        IntSupplier nomeMes = () -> Calendar.getInstance().get(Calendar.MONTH)+1;
        
        System.out.println(nomeMes.getAsInt());
        
        IntPredicate potDois = (n1) -> (Math.log(n1) / Math.log(2)) % 2 ==0;
        IntPredicate cemOuMenos = (n2) -> n2 <= 100;
        
        System.out.println("potdois(10)"+potDois.test(10));
        System.out.println("potdois(1024)"+potDois.test(1024));
        System.out.println("cemouMenos(10)"+cemOuMenos.test(10));
        System.out.println("cemouMenos(1024)"+cemOuMenos.test(1024));
	}
	    public static <T> T math(List<T> list, T init, BinaryOperator<T> accumulator) {
	        T result = init;
	        for (T t : list) {
	            result = accumulator.apply(result, t);
	        }
	        return result;
	    }

	}


