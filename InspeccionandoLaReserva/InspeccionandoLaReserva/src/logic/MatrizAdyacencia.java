package logic;

public class MatrizAdyacencia {
	private boolean[][] matriz;//Si fuese no ponderada, le ponemos boolean
	private static boolean valorInfinito=false;
	
	public MatrizAdyacencia(int tam) {
		matriz = new boolean[tam][tam];
		inicializarMatrizEnInfinito(matriz);
	}
	
	public void addValue(int fila, int columna, boolean valor) {
		//De nuevo, si fuese boolean, se cambia aca tambien...
		//Podria no recibir el valor, total, es boolean.
		if(fila!=columna)
			matriz[fila][columna]=valor;//ES DIGRAFO.
	}
	
	public boolean getValue(int fila, int columna) {//Si fuese boolean, devuelvo boolean
		return fila==columna?valorInfinito : matriz[fila][columna];
	}
	
	public static void inicializarMatrizEnInfinito(boolean[][] matriz) {
		for(int i=0;i<matriz.length;i++)
			for(int j=0;j<matriz[i].length;j++)
				matriz[i][j]=valorInfinito;
	}
	
	public static void mostrarMatriz(boolean[][] bs) {
		System.out.println("****MATRIZ****");
		for(int i=0;i<bs.length;i++) {
			for(int j=0;j<bs[i].length;j++)
				System.out.print(" "+bs[i][j]);
		System.out.println();	
		}
		System.out.println("****MATRIZ****");
	}


	public boolean[][] getMatriz() {
		return matriz;
	}
	public void setMatriz(boolean[][] matriz) {
		this.matriz = matriz;
	}
	public boolean getValorInfinito() {
		return valorInfinito;
	}
	public void setValorInfinito(boolean vi) {
		valorInfinito = vi;
	}
}