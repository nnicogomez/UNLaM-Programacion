package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import logic.*;

public class Entrada {
	private String path;
	private boolean[][] matrizAd;
	private Nodo nodoInicial;
	private int cantNodos;
	private int cantAristas;
	private Scanner sc;
	
	public Entrada(String p) {
		this.path = p;
	}
	
	public String leerGrafo() throws FileNotFoundException {
		sc = new Scanner (new File(path));
		sc.useLocale(Locale.ENGLISH);
		cantNodos=sc.nextInt();
		cantAristas=sc.nextInt();
		matrizAd = new boolean[cantNodos][cantNodos];
		MatrizAdyacencia.inicializarMatrizEnInfinito(matrizAd);
		/*
		 * Si los nodos arrancan en cero en el archivo, mejor. Si arrancan en 1, hay que descontar
		 * uno a lo que leemos.
		 */
		for(int i=0;i<cantAristas;i++) {
			matrizAd[sc.nextInt()-1][sc.nextInt()-1]=true;//En caso de que sea no ponderado, solamente colocamos un uno o cero
		}
		nodoInicial = new Nodo(0);
		return "fin de la carga\n";
	}
	
	public void cargarEnGrafo(Grafo g) {
		for(int i=0;i<g.getAristas().getMatriz().length;i++) {
			g.addNodo(new Nodo(i));
			for(int j=0;j<g.getAristas().getMatriz()[i].length;j++) {
				g.addArista(new Arista(new Nodo(i),new Nodo (j),matrizAd[i][j]));
			}
		}
		//g.mostrarGrafo();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean[][] getMatrizAd() {
		return matrizAd;
	}

	public void setMatrizAd(boolean[][] matrizAd) {
		this.matrizAd = matrizAd;
	}

	public Nodo getNodoInicial() {
		return nodoInicial;
	}

	public void setNodoInicial(Nodo nodoInicial) {
		this.nodoInicial = nodoInicial;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}
}