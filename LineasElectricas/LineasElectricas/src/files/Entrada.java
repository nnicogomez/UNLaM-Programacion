package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import logic.*;

public class Entrada {
	private String path;
	private int[][] matrizAd;
	private ArrayList<Nodo> nodoInicial;
	private int cantNodos;
	private int cantCentrales;
	private Scanner sc;
	
	public Entrada(String p) {
		this.path = p;
		nodoInicial = new ArrayList<Nodo>();
	}
	
	public void leerGrafo() throws FileNotFoundException {
		sc = new Scanner (new File(path));
		sc.useLocale(Locale.ENGLISH);
		
		cantNodos = sc.nextInt();
		cantCentrales = sc.nextInt();
		matrizAd = new int[cantNodos][cantNodos];
		for(int i=0;i<cantCentrales;i++) {
			nodoInicial.add(new Nodo(sc.nextInt()-1));
		}
		
		for(int i=0;i<cantNodos;i++) {
			for(int j=0;j<cantNodos;j++) {
				matrizAd[i][j]=sc.nextInt();
			}
		}
		
	}
	
	public void cargarEnGrafo(Grafo g) {
		for(int i=0;i<cantCentrales;i++) {
			g.addNodosIniciales(nodoInicial.get(i));
		}
		for(int i=0;i<cantNodos;i++) {
			g.addNodo(new Nodo(i));
			for(int j=0;j<cantNodos;j++) {
				g.addArista(new Arista(new Nodo(i),new Nodo(j),matrizAd[i][j]));
			}
		}
		MatrizAdyacencia.mostrarMatriz(g.getAristas().getMatriz());
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int[][] getMatrizAd() {
		return matrizAd;
	}

	public void setMatrizAd(int[][] matrizAd) {
		this.matrizAd = matrizAd;
	}


	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}
	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public ArrayList<Nodo> getNodoInicial() {
		return nodoInicial;
	}

	public void setNodoInicial(ArrayList<Nodo> nodoInicial) {
		this.nodoInicial = nodoInicial;
	}

	public int getCantCentrales() {
		return cantCentrales;
	}

	public void setCantCentrales(int cantCentrales) {
		this.cantCentrales = cantCentrales;
	}

	
}