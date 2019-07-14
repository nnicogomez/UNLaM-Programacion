public class Arreglo {
	private int[] vec= new int[6];
	private int posact;
	
	public Arreglo(int tam) {
		for(int i=0; i<tam; i++) {
			//vec[i]=-1;
			System.out.println("HOLA");
		}
	}
	
	public void agregar(int valor) {
		vec[posact]=valor;
		posact++;
	}
	
	public void seleccion() {
		int i, j, aux, limite = vec.length-1;
		for(i=0;i<limite;i++){
            for(j=i+1;j<=limite;j++){
                if(vec[j] < vec[i]) {
                    aux = vec[j];
                    vec[j] = vec[i];
                    vec[i] = aux;
                }
            }
        }
	}

	public void burbujeo() {
		int temp;
        for(int i=1;i < vec.length;i++){
            for (int j=0 ; j < vec.length- 1; j++){
                if (vec[j] > vec[j+1]){
                    temp = vec[j];
                    vec[j] = vec[j+1];
                    vec[j+1] = temp;
                }
            }
        }
	}

	public void insercion() {
		for (int i=1; i < vec.length; i++) {
	         int aux = vec[i];
	         int j;
	         for (j=i-1; j >=0 && vec[j] > aux; j--){
	              vec[j+1] = vec[j];
	          }
	         vec[j+1] = aux;
	      }
	}

	public void shell() {
		for ( int increment = vec.length / 2;increment > 0;
		          increment = (increment == 2 ? 1 : (int) Math.round(increment / 2.2))) {
		        for (int i = increment; i < vec.length; i++) {
		            for (int j = i; j >= increment && vec[j - increment] > vec[j]; j -= increment) {
		                int temp = vec[j];
		                vec[j] = vec[j - increment];
		                vec[j - increment] = temp;
		            }
		        }
		    }
	}
/*
	public void fusion() {
		vec = new int[vec.length];
	    int buf;
	    int from = a;
	    int to = b;
	    int pivot = vec[(from+to)/2];
	    do{
	        while(vec[from] < pivot){
	            from++;
	        }
	        while(vec[to] > pivot){
	            to--;
	        }
	        if(from < = to){
	            buf = vec[from];
	            vec[from] = vec[to];
	            vec[to] = buf;
	            from++; to--;
	        }
	    }while(from < = to);
	    if(a < to){
	        Rapido(vec, a, to);
	    }
	    if(from < b){
	        Rapido(vec, from, b);
	    }
	}
*/
	public void quicksort(int a, int b) {
		vec = new int[vec.length];
	    int buf;
	    int from = a;
	    int to = b;
	    int pivot = vec[(from+to)/2];
	    do{
	        while(vec[from] < pivot){
	            from++;
	        }
	        while(vec[to] > pivot){
	            to--;
	        }
	        if(from <= to){
	            buf = vec[from];
	            vec[from] = vec[to];
	            vec[to] = buf;
	            from++; to--;
	        }
	    }while(from <= to);
	    if(a < to){
	        quicksort(a, to);
	    }
	    if(from < b){
	        quicksort(from, b);
	    }
	}

	public void distroparticular() {

	}

	public void distrogeneral() {

	}
	
	public void mostrarVector(){
		for(int i=0; i<vec.length;i++) {
			System.out.println(" "+vec[i]);
		}
	}
	
}
