
/*Dado un conjunto de N números cualesquiera, un número T y un entero K, 
 * ¿cuán rápido puede usted determinar si existe un subconjunto de K elementos cuya suma es, a lo sumo, T?*/
public class Ejercicio1 {
	public int i;
	public int n;
	public int k;
	
	public boolean calcularSubconjunto(int[] nvector, int tfinal, int kelementos){
		int i, tmp, j,acum=0;;
		
		for (i = 0; i < nvector.length; i++) {
	        for (j = 0; j < nvector.length-i-1; j++) {
	            if(nvector[j] > nvector[j+1]){
	                tmp = nvector[j+1];
	                nvector[j+1] = nvector[j];
	                nvector[j] = tmp;
	            }
	        }
	    }
        for(j=0;j<kelementos;j++) {
        	acum+=nvector[j];
        	if(acum>tfinal)
            	return false;
        }
        return true;
	}
}
