package logic;

public class MatrizAdyacencia {
	private int[][] matriz;//Si fuese no ponderada, le ponemos boolean
	static int valorInfinito=Integer.MAX_VALUE;
	private int cantidadNodos;
	
	public MatrizAdyacencia(int tam) {
		matriz = new int[tam][tam];
		inicializarMatriz(matriz);
		cantidadNodos = tam;
	}
	
	public void addValue(int fila, int columna, Integer valor) {
		//De nuevo, si fuese boolean, se cambia aca tambien...
		//Podria no recibir el valor, total, es boolean.
		if(fila!=columna)
			matriz[fila][columna]=valor;//ES DIGRAFO.
	}
	
	public void addValue(int fila, int columna, int valor) {
		//De nuevo, si fuese boolean, se cambia aca tambien...
		//Podria no recibir el valor, total, es boolean.
		if(fila!=columna)
			matriz[fila][columna]=matriz[columna][fila]=valor;//ES DIGRAFO.
	}
	
	public Integer getValue(int fila, int columna) {//Si fuese boolean, devuelvo boolean
		return fila==columna?valorInfinito : matriz[fila][columna];
	}
	
	public static void inicializarMatriz(int[][] matrizIntermedia) {
		for(int i=0;i<matrizIntermedia.length;i++)
			for(int j=0;j<matrizIntermedia[i].length;j++)
				matrizIntermedia[i][j]=valorInfinito;
	}
	
	public static void mostrarMatriz(int[][] bs) {
		System.out.println("****MATRIZ****");
		for(int i=0;i<bs.length;i++) {
			for(int j=0;j<bs[i].length;j++)
				System.out.print(" "+bs[i][j]);
		System.out.println();	
		}
		System.out.println("****MATRIZ****");
	}


	public int[][] getMatriz() {
		return matriz;
	}
	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}
	public Integer getValorInfinito() {
		return valorInfinito;
	}
	public void setValorInfinito(Integer vi) {
		valorInfinito = vi;
	}

	public int getCantidadNodos() {
		return cantidadNodos;
	}

	public void setCantidadNodos(int cantidadNodos) {
		this.cantidadNodos = cantidadNodos;
	}
	
	
}