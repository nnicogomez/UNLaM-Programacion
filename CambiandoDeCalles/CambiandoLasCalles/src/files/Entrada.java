package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

import logic.Arista;
import logic.Grafo;
import logic.MatrizAdyacencia;
import logic.Nodo;

public class Entrada {
	private int[][] matrizIntermedia;
	private int[][] matrizIntermediaCompleta;
	private int cantNodos;
	private String path;
	private Nodo nodoInicial;
	private Nodo nodoFinal;
	private HashMap<Integer,Arista> calles;
	
	public Entrada(String p) {
		path=p;
	}
	
	public void leerGrafo() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		cantNodos = sc.nextInt();
		nodoInicial = new Nodo(sc.nextInt()-1);
		nodoFinal = new Nodo(sc.nextInt()-1);
		matrizIntermedia = new int[cantNodos][cantNodos];
		matrizIntermediaCompleta = new int[cantNodos][cantNodos];
		MatrizAdyacencia.inicializarMatriz(matrizIntermedia);
		MatrizAdyacencia.inicializarMatriz(matrizIntermediaCompleta);
		calles = new HashMap<Integer,Arista>();
		int cantAristas = sc.nextInt();
		for(int i=0;i<cantAristas;i++) {
				int aux1=sc.nextInt()-1;
				int aux2=sc.nextInt()-1;
				int valor = sc.nextInt();
				calles.put(i+1, new Arista(new Nodo(aux1),new Nodo(aux2),valor));
				matrizIntermedia[aux1][aux2]=valor;
				matrizIntermediaCompleta[aux1][aux2]=matrizIntermediaCompleta[aux2][aux1]=valor;
		}
	}
	
	public void cargarGrafo(Grafo g) {
		g.setCalles(calles);
		for(int i=0;i<matrizIntermedia.length;i++) {
			g.addNodo(new Nodo(i));
			for(int j=0;j<matrizIntermedia[i].length;j++) {
				g.addArista(new Arista(new Nodo(i),new Nodo(j),matrizIntermedia[i][j]));
				g.addAristaCompleta(new Arista(new Nodo(i),new Nodo(j),matrizIntermediaCompleta[i][j]));
			}
		}
		/*System.out.println("MATRIZ NORMAL");
		MatrizAdyacencia.mostrarMatriz(g.getMatrizAdyacencia().getMatrizAdyacencia());
		System.out.println("MATRIZ COMPLETA");
		MatrizAdyacencia.mostrarMatriz(g.getMatrizAdyacenciaCompleta().getMatrizAdyacencia());
	*/}

	public int[][] getMatrizIntermedia() {
		return matrizIntermedia;
	}

	public void setMatrizIntermedia(int[][] matrizIntermedia) {
		this.matrizIntermedia = matrizIntermedia;
	}

	public int[][] getMatrizIntermediaCompleta() {
		return matrizIntermediaCompleta;
	}

	public void setMatrizIntermediaCompleta(int[][] matrizIntermediaCompleta) {
		this.matrizIntermediaCompleta = matrizIntermediaCompleta;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Nodo getNodoInicial() {
		return nodoInicial;
	}

	public void setNodoInicial(Nodo nodoInicial) {
		this.nodoInicial = nodoInicial;
	}

	public Nodo getNodoFinal() {
		return nodoFinal;
	}

	public void setNodoFinal(Nodo nodoFinal) {
		this.nodoFinal = nodoFinal;
	}
	
}
