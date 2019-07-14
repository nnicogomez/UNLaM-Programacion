package logica;

public class MatrizAdyacencia {
	private int[][] matrizAdyacencia;
	private int ordenMatriz;
	
	public MatrizAdyacencia(int cant) {
		matrizAdyacencia = new int [cant][cant];
		ordenMatriz = cant;
		inicializarMatriz(matrizAdyacencia);
	}

	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public void setMatrizAdyacencia(int[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}

	public int getOrdenMatriz() {
		return ordenMatriz;
	}

	public void setOrdenMatriz(int ordenMatriz) {
		this.ordenMatriz = ordenMatriz;
	}
	
	public void addValue(int f, int c, int valor) {
		if(f!=c)
			matrizAdyacencia[f][c]=matrizAdyacencia[c][f]=valor;
	}
	
	public int  getValue(int f, int c) {
			return matrizAdyacencia[f][c];
	}
	
	public static void inicializarMatriz(int [][] mat) {
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				mat[i][j]=Integer.MAX_VALUE;//REPRESENTACION INFINITO
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
}
