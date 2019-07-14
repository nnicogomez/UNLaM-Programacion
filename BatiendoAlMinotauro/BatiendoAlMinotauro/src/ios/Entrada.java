package ios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import logic.Arista;
import logic.Grafo;
import logic.MatrizAdyacencia;
import logic.Nodo;

public class Entrada {
	private String path;
	private int cantNodos;
	private int[][] intermedia;
	
	public Entrada(String p) {
		path=p;
	}
	
	public void leerArchivo() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		
		cantNodos = sc.nextInt();
		intermedia = new int [cantNodos][cantNodos];
		for(int i=0;i<cantNodos;i++) {
			for(int j=0;j<cantNodos;j++) {
				intermedia[i][j]=sc.nextInt();
			}
		}
	}
	
	public void cargarGrafo(Grafo g) {
		for(int i=0;i<intermedia.length;i++) {
			g.addNodo(new Nodo(i));
			for(int j=0;j<intermedia[i].length;j++) {
				g.addArista(new Arista(new Nodo(i), new Nodo(j),intermedia[i][j]));
			}
		}
	MatrizAdyacencia.mostrarMatriz(g.getMatrizAdyacencia().getMatrizAdyacencia());
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public int[][] getIntermedia() {
		return intermedia;
	}

	public void setIntermedia(int[][] intermedia) {
		this.intermedia = intermedia;
	}
	
}
