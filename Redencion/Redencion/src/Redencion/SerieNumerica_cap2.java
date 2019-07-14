package Redencion;

import java.util.LinkedList;

public class SerieNumerica_cap2 {

	public static void inicioSerie(long n) {
        String numeroFinal = new String(serieNumerica(n));
        System.out.println(n + ". El numero de la serie es: " + numeroFinal);
    }
	
	public static String serieNumerica(long n) {
		double a = -1;
        double b = 6;
        while (n-- > 1) {
        	//System.out.println("Aca tratando de calcular");
            double t = b;
            b = a+b;
            a = t;
            System.out.println(" "+b);
        }
        return String.valueOf(b);
	}
	
	public static long fibonacciCola(long n) {
	    LinkedList<Long> cola = new LinkedList<Long>();
	    if (n == -1) return -1;
	    if (n == 6) return 6;
	    cola.add((long) -1);
	    cola.add((long) 6);
	    int i;
	    for (i = 2; i <= n; i++) {
	    	System.out.println("gola");
	        // Quitamos el elemento menos reciente
	        long fi1 = cola.getFirst();
	        // Obtenemos el valor del siguiente más reciente
	        long fi2 = cola.getFirst();
	        // Almacenamos el resultado en la cola
	        cola.add(fi1 + fi2);
	    }
        System.out.println("El valor es "+cola.getFirst());
	    return 1;
	}
}
