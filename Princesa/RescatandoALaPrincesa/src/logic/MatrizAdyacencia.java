package logic;

public class MatrizAdyacencia {
	private int[][] matriz;
	private static int valorInfinito=Integer.MAX_VALUE;
	
	public MatrizAdyacencia(int tam, int tam2) {
		matriz = new int[tam][tam2];
		inicializarMatrizEnInfinito(matriz);
	}
	
	public void addValue(int fila, int columna, int valor) {
		if(fila!=columna)
			matriz[fila][columna]=matriz[fila][columna]=valor;
	}
	
	public int getValue(int fila, int columna) {
		return fila==columna?valorInfinito : matriz[fila][columna];
	}
	
	public static void inicializarMatrizEnInfinito(int[][] matriz) {
		for(int i=0;i<matriz.length;i++)
			for(int j=0;j<matriz[i].length;j++)
				matriz[i][j]=Integer.MAX_VALUE;
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
	public int getValorInfinito() {
		return valorInfinito;
	}
	public void setValorInfinito(int vi) {
		valorInfinito = vi;
	}
}