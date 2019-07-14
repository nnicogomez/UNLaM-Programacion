package lectura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

import logica.Arista;
import logica.Grafo;
import logica.MatrizAdyacencia;
import logica.Nodo;

public class Entrada {
	private String path;
	private int[][] intermedia;
	private HashMap<Integer,Integer> horarios;
	private int cantNodos;
	private int cantAristas;
	private ArrayList<Integer> nodos;
	private ArrayList<Arista> aristas;
	private Scanner sc;
	
	public Entrada(String p) {
		path=p;
		nodos = new ArrayList<Integer>();
		horarios = new HashMap<Integer,Integer>();
		aristas = new ArrayList<Arista>();
	}
	
	public void leerArchivo() throws FileNotFoundException {
		sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		
		cantAristas = sc.nextInt();
		for(int i=0;i<cantAristas;i++) {
			int n1=sc.nextInt()-1;
			int value=sc.nextInt();
			int n2=sc.nextInt()-1;
			if(!nodos.contains(n1))
				nodos.add(n1);
			if(!nodos.contains(n2))
				nodos.add(n2);
		aristas.add(new Arista(new Nodo(n1),new Nodo(n2),value));
		}
		
		//System.out.println("Cant de nodos: "+nodos.size());
		intermedia = new int[nodos.size()][nodos.size()];
		MatrizAdyacencia.inicializarMatriz(intermedia);
		cantNodos = nodos.size();

		for( Arista a : aristas) {
			int i=a.getNodoIzq().getIndex();
			int j=a.getNodoDer().getIndex();
			int val=a.getCosto();
			intermedia[i][j]=intermedia[j][i]=val;
		}

		int hor=sc.nextInt();
		for(int i=0;i<hor;i++) {
			int h1=sc.nextInt()-1;
			int h2 = sc.nextInt();
			//System.out.println("PC: "+h1+", HORARIO: "+h2);
			horarios.put(h1, h2);
		}
	}
	
	public void cargarGrafo(Grafo g) {
		g.setHorarios(horarios);
		g.getMatrizAdyacencia().setMatrizAdyacencia(intermedia);
		for(int i=0;i<cantNodos;i++) {
			g.addNodo(new Nodo(i));
		}
		//MatrizAdyacencia.mostrarMatriz(g.getMatrizAdyacencia().getMatrizAdyacencia());
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int[][] getIntermedia() {
		return intermedia;
	}

	public void setIntermedia(int[][] intermedia) {
		this.intermedia = intermedia;
	}

	public HashMap<Integer, Integer> getHorarios() {
		return horarios;
	}

	public void setHorarios(HashMap<Integer, Integer> horarios) {
		this.horarios = horarios;
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

	public ArrayList<Integer> getNodos() {
		return nodos;
	}

	public void setNodos(ArrayList<Integer> nodos) {
		this.nodos = nodos;
	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public void setAristas(ArrayList<Arista> aristas) {
		this.aristas = aristas;
	}
}
