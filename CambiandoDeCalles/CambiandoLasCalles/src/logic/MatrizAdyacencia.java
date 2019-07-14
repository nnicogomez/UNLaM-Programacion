package logic;

public class MatrizAdyacencia {
	private int[][] matrizAdyacencia;
	
	private int tam;
	
	public MatrizAdyacencia(int tam1, int tam2) {
		matrizAdyacencia = new int[tam1][tam2];
		inicializarMatriz(matrizAdyacencia);
		tam=tam1;
	}

	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public void setMatrizAdyacencia(int[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}
	
	public void addValue(int f, int c, int costo) {
		if(f!=c) {
			matrizAdyacencia[f][c]=costo;
		}
	}
	public int getValue(int f, int c) {
		return f==c?Integer.MAX_VALUE:matrizAdyacencia[f][c];
	}
	
	public static void inicializarMatriz(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				m[i][j]=Integer.MAX_VALUE;
			}
		}
	}
	
	public static void mostrarMatriz(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				System.out.print(" "+m[i][j]);
			}
			System.out.println();
		}
	}
	
}
