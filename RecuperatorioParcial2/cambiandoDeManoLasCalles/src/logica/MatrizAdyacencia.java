package logica;

public class MatrizAdyacencia {
	private int[][] matrizAdyacencia;
	private static int infinito = Integer.MAX_VALUE;
	
	public MatrizAdyacencia(int cant) {
		matrizAdyacencia = new int [cant][cant];
		inicializarMatriz(matrizAdyacencia);
	}

	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public void setMatrizAdyacencia(int[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}

	
	public void addValue(int f, int c, int valor) {
		if(f!=c)
			matrizAdyacencia[f][c]=valor;
	}
	
	public int  getValue(int f, int c) {
			return matrizAdyacencia[f][c];
	}
	
	public static void inicializarMatriz(int [][] mat) {
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				mat[i][j]=infinito;
			}
		}
	}
	
	public static void mostrarMatriz(int [][] mat) {
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				System.out.print(" "+mat[i][j]);
			}
			System.out.println();
		}
	}

	public static int getInfinito() {
		return infinito;
	}

	public static void setInfinito(int infinito) {
		MatrizAdyacencia.infinito = infinito;
	}
	
	
}
