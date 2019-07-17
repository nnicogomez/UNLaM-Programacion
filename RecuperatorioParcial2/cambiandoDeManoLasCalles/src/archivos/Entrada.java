package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

import logica.Arista;
import logica.Grafo;
import logica.MatrizAdyacencia;
import logica.Nodo;

public class Entrada {
	private int[][] intermediaCompleta;
	private HashMap<Integer,Arista> calles;
	private String path;
	private int cantNodos;
	private Nodo inicial;
	private Nodo dfinal;
	private int cantCalles;
	
	public Entrada(String p) {
		this.path=p;
		calles = new HashMap<Integer,Arista>();
	}
	
	public void leerArchivo() throws FileNotFoundException {
		Scanner sc = new Scanner ( new File (path));
		sc.useLocale(Locale.ENGLISH);
		cantNodos = sc.nextInt();
		intermediaCompleta = new int[cantNodos][cantNodos];
		MatrizAdyacencia.inicializarMatriz(intermediaCompleta);
		inicial = new Nodo(sc.nextInt()-1);
		dfinal = new Nodo(sc.nextInt()-1);
		cantCalles = sc.nextInt();
		for(int i=0;i<cantCalles;i++) {
			int aux1= sc.nextInt()-1;
			int aux2= sc.nextInt()-1;
			int valor= sc.nextInt();
			intermediaCompleta[aux1][aux2]=intermediaCompleta[aux2][aux1]=valor;
			calles.put(i, new Arista(new Nodo(aux1),new Nodo(aux2),valor));
		}
		
	}
	
	public void cargarGrafo(Grafo g) {
		
		g.setCalles(calles);
		for(int i=0;i<cantNodos;i++) {
			g.addNodo(new Nodo(i));
			for(int j=0;j<cantNodos;j++)
				g.addAristaCompleta(new Arista(new Nodo(i),new Nodo(j),intermediaCompleta[i][j]));
		}
	}

	public int[][] getIntermediaCompleta() {
		return intermediaCompleta;
	}

	public void setIntermediaCompleta(int[][] intermediaCompleta) {
		this.intermediaCompleta = intermediaCompleta;
	}

	public HashMap<Integer, Arista> getCalles() {
		return calles;
	}

	public void setCalles(HashMap<Integer, Arista> calles) {
		this.calles = calles;
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

	public Nodo getInicial() {
		return inicial;
	}

	public void setInicial(Nodo inicial) {
		this.inicial = inicial;
	}

	public Nodo getDfinal() {
		return dfinal;
	}

	public void setDfinal(Nodo dfinal) {
		this.dfinal = dfinal;
	}

	public int getCantCalles() {
		return cantCalles;
	}

	public void setCantCalles(int cantCalles) {
		this.cantCalles = cantCalles;
	}
}
