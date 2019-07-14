package logic;

public class MatrizAdyacencia {
	private int[][] matriz;//Si fuese no ponderada, le ponemos boolean
	private static int valorInfinito=Integer.MAX_VALUE;
	
	public MatrizAdyacencia(int tam) {
		matriz = new int[tam][tam];
		inicializarMatrizEnInfinito(matriz);
	}
	
	public void addValue(int fila, int columna, int valor) {
		//De nuevo, si fuese boolean, se cambia aca tambien...
		//Podria no recibir el valor, total, es boolean.
		if(fila!=columna)
			matriz[fila][columna]=valor;
		else
			System.out.println("La fila coincide con la columna. No se pudo añadir valor");
	}
	
	public int getValue(int fila, int columna) {//Si fuese boolean, devuelvo boolean
		return fila==columna?valorInfinito : matriz[fila][columna];
	}
	
	public static void inicializarMatrizEnInfinito(int [][] matriz) {
		for(int i=0;i<matriz.length;i++)
			for(int j=0;j<matriz[i].length;j++)
				matriz[i][j]=Integer.MAX_VALUE;
	}
	
	public static void mostrarMatriz(int[][] matriz) {
		System.out.println("****MATRIZ****");
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++)
				System.out.print(" "+matriz[i][j]);
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
