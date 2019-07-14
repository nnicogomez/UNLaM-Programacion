package in;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

import logica.*;

public class Entrada {
	private String path;
	private int[][] matrizAd;
	private Nodo nodoInicial;
	private Nodo nodoFinal;
	private int cantNodos;
	private int cantAristas;
	private Scanner sc;
	private HashMap<Integer,ArrayList<String>> mapa; 
	ArrayList<String> lineas;
	private int[][] mat;
	public Entrada(String p) {
		this.path = p;
	}
	
	public String leerGrafo() throws FileNotFoundException {
		sc = new Scanner (new File(path));
		sc.useLocale(Locale.ENGLISH);
		cantNodos=sc.nextInt();
		cantAristas=sc.nextInt();
		matrizAd = new int[cantAristas][cantAristas];
		MatrizAdyacencia.inicializarMatriz(matrizAd);
		mat = new int[cantAristas][cantNodos];
		/*
		 * Si los nodos arrancan en cero en el archivo, mejor. Si arrancan en 1, hay que descontar
		 * uno a lo que leemos.
		 */
		mapa = new HashMap<Integer,ArrayList<String>>();
		lineas = new ArrayList<String>();
		for(int i=0;i<cantAristas;i++) {
			mapa.put(i, lineas);
		}
		ArrayList<Integer> colocar = new ArrayList<Integer>();
		for(int i=0;i<cantNodos;i++) {
			int aux2 = sc.nextInt();
			for(int j=0;j<aux2;j++) {
				int aux1=sc.nextInt()-1;
				colocar.add(aux1);
				mat[aux1][i] = 1;
			}
			
			for(int n=0;n<colocar.size();n++) {
				for(int b=n;b<colocar.size();b++) {
					matrizAd[colocar.get(n)][colocar.get(b)]=matrizAd[colocar.get(b)][colocar.get(n)]=1;
				}
			}
			colocar = new ArrayList<Integer>();
		}
		nodoInicial = new Nodo(sc.nextInt()-1);
		nodoFinal = new Nodo(sc.nextInt()-1);
		return "fin de la carga\n";
	}
	
	public Nodo getNodoFinal() {
		return nodoFinal;
	}

	public void setNodoFinal(Nodo nodoFinal) {
		this.nodoFinal = nodoFinal;
	}

	public void cargarEnGrafo(Grafo g) {
		for(int i=0;i<matrizAd.length;i++) {
			g.addNodo(new Nodo(i));
			for(int j=0;j<matrizAd.length;j++) {
				g.addArista(new Arista(new Nodo(i),new Nodo (j),matrizAd[i][j]));
			}
		}
		for(int k=0;k<mat.length;k++) {
			for(int j=0;j<mat[k].length;j++) {
				if(mat[k][j]==1)
					g.getNodo(new Nodo(k)).addLinea((Integer.toString(j+1)));
			}
		}
/*
		System.out.println("LINEAS");
		for(int i=0;i<g.getNodos().length;i++) {
			g.getNodos()[i].mostrarLineas();
		}
		System.out.println("\nFINLINEA")	
		MatrizAdyacencia.mostrarMatriz(g.getMatrizAdyacencia().getMatrizAdyacencia());*/
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