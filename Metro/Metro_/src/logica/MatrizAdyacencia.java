package logica;

public class MatrizAdyacencia {
	private int[][] matrizAdyacencia;
	private static int infinito = Integer.MAX_VALUE;
	
	public MatrizAdyacencia(int cant1, int cant2) {
		matrizAdyacencia = new int[cant1][cant2];
	}
	
	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}
	public void setMatrizAdyacencia(int[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}
	public static int getInfinito() {
		return infinito;
	}
	public static void setInfinito(int infinito) {
		MatrizAdyacencia.infinito = infinito;
	}
	
	public void addValue(int fila, int columna, int valor) {
		if(fila!=columna)
			matrizAdyacencia[fila][columna] = valor;
	}
	
	public int getValue(int fila, int columna) {
		return matrizAdyacencia[fila][columna];
	}
	public int getOrdenMatriz() {
		return matrizAdyacencia.length;
	}
	
	public static void inicializarMatriz(int[][] mat) {
		for(int i =0; i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++)
				mat[i][j]=infinito;
		}
	}
	
	public static void mostrarMatriz(int[][] mat) {
		for(int i =0; i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++)
				System.out.print(" "+mat[i][j]);
			System.out.println(" ");
		}
		
	}
}
