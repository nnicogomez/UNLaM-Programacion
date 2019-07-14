package logic;

public class MatrizAdyacencia {
	private int[][] matrizAdyacencia;
	private int ordenMatriz;
	
	public MatrizAdyacencia(int c) {
		matrizAdyacencia = new int[c][c];
		inicializarMatriz(matrizAdyacencia);
		ordenMatriz=c;
	}
	
	public void addValue(int f, int c,int v) {
		if(f!=c)
			matrizAdyacencia[f][c]=matrizAdyacencia[c][f]=v;
	}
	
	public int getValue(int f, int c) {
		return matrizAdyacencia[f][c];
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
	
	public static void mostrarMatriz(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				System.out.print(" "+m[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void inicializarMatriz(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				m[i][j]=Integer.MAX_VALUE;
			}
		}
	}
}
