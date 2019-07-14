package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Grafo {
	private int[][] matrizAdyacencia;
	private Nodo[] nodos;
	private static int infinito = Integer.MAX_VALUE;
	private int cantNodos;
	
	public Grafo(String path) throws FileNotFoundException {
		System.out.println(leerGrafo(path));
	}
	
	public String leerGrafo(String p) throws FileNotFoundException {
		Scanner sc = new Scanner (new File(p));
		sc.useLocale(Locale.ENGLISH);
		cantNodos = sc.nextInt();
		matrizAdyacencia = new int[cantNodos][cantNodos];
		nodos = new Nodo[cantNodos];
		inicializarMatriz(matrizAdyacencia);
		for(int i =0; i<cantNodos; i++) {
			addNodo(new Nodo(i));
			for ( int j=0; j<cantNodos; j++) {
				int aux1 = sc.nextInt();
				if(aux1!=0)
					addArista(new Arista(new Nodo(i),new Nodo(j), aux1));
			}
		}
		mostrarMatriz(matrizAdyacencia);
		return "Fin de lectura de archivo";
	}
	
	public static void mostrarMatriz(int[][] mat) {
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				System.out.print(" "+mat[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void inicializarMatriz(int[][] mat) {
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				mat[i][j]=infinito;
			}
		}
	}
	
	public void addArista(Arista a) {
		if(a.getNodoDer().getIndice()  != a.getNodoIzq().getIndice())
			matrizAdyacencia[a.getNodoIzq().getIndice()][a.getNodoDer().getIndice()] = a.getCosto();
		else
			System.out.println("No se agrego la arista debido a que poseen los mismos indices");
	}
	
	public Arista getArista(int fila, int columna) {
		if(fila==columna)
			return null;
		else
			return new Arista(new Nodo(fila), new Nodo(columna), matrizAdyacencia[fila][columna]);
	}
	
	public boolean hayArista(int fila, int columna) {
		if(fila==columna)
			return false;
		if(matrizAdyacencia[fila][columna]==infinito)
			return false;
		if(matrizAdyacencia[columna][fila]==infinito)
			return false;
		return true;
	}
	
	public void addNodo(Nodo n) {
		nodos[n.getIndice()] = n;
	}
	
	public Nodo getNodo(int i) {
		return nodos[i];
	}
	
	public Nodo[] getNodos() {
		return nodos;
	}
	
	public int getCantNodos() {
		return nodos.length;
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
		Grafo.infinito = infinito;
	}

	public void setNodos(Nodo[] nodos) {
		this.nodos = nodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public ArrayList<Nodo> getAdyacentes(Nodo n){
		System.out.println("[getAdyacentes]Los adyacentes al nodo "+(n.getIndice()+1)+"son: ");
		ArrayList<Nodo> lista = new ArrayList<Nodo>();
		for(int i=0; i<matrizAdyacencia.length;i++)
			if(matrizAdyacencia[n.getIndice()][i]!=infinito) {
				lista.add(new Nodo(i));
				System.out.println(" "+(i+1));
			}
		return lista;
	}

	@Override
	public String toString() {
		mostrarMatriz(matrizAdyacencia);
		return "nodos=" + Arrays.toString(nodos)
				+ "]";
	}
}
