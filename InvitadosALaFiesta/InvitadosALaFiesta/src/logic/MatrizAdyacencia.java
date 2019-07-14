package logic;

public class MatrizAdyacencia {
	private boolean[][] matrizAdyacencia;
	private static boolean valorInfinito;
	
	public MatrizAdyacencia(int tam,boolean infinito) {
		this.matrizAdyacencia = new boolean[tam][tam];
		valorInfinito=infinito;
	}

	public boolean[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public void setMatrizAdyacencia(boolean[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}

	public static boolean getValorInfinito() {
		return valorInfinito;
	}

	public static void setValorInfinito(boolean valorInfinito) {
		MatrizAdyacencia.valorInfinito = valorInfinito;
	}
	
	public void addValue(int fila, int columna, boolean valor) {
		//System.out.println("Agrego valor a la matriz "+fila+" "+columna+ " "+valor);
		if(fila!=columna) {
			matrizAdyacencia[fila][columna]=matrizAdyacencia[columna][fila]=valor;
			//mostrarMatriz(matrizAdyacencia);.
			}
	}
	
	public boolean getValue(int fila, int columna) {
		//System.out.println(" "+fila+ " "+columna+" "+" el valor es "+(matrizAdyacencia[fila][columna]));
		return matrizAdyacencia[fila][columna];
	}
	
	public static void inicializarMatrizConInfinito(boolean[][] mat) {
		//System.out.println("Hola");
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++)
				mat[i][j]=valorInfinito;
		}
	}
	
	public static void mostrarMatriz(boolean[][] mat) {
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++)
				System.out.print(" "+mat[i][j]);
			System.out.println();
		}
	}
}
