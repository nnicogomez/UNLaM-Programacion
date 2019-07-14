package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import logic.*;

public class Entrada {
	private String path;
	ArrayList<Nodo> nodos;
	ArrayList<Arista> aristas;
	ArrayList<Arista> aristasCien;
	private Nodo nodoInicial;
	private Nodo nodoFinal;
	private int cantAristas;
	private int cantNodos;
	
	public Entrada(String ps) {
		path=ps;
	}
	
	public void leerArchivo() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		nodos = new ArrayList<Nodo>();
		aristas = new ArrayList<Arista>();
		aristasCien = new ArrayList<Arista>();
		int j=0;
		while(sc.hasNextInt()) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			Nodo n=new Nodo(x,y,j);
			for(Nodo k: this.nodos) {
				if(n.esAdyacente(k)) {
					aristas.add(new Arista(n,k,1));
					cantAristas++;
				}
				if(n.calcularDistancia(k)<100 && n.calcularDistancia(k)>50) {
				//System.out.println("Los nodos "+n.getIndex() + " y "+k.getIndex()+" con distancia "+n.calcularDistancia(k));
				aristasCien.add(new Arista(n,k,2));
				}
			}
			nodos.add(n);
			j++;
		}
		cantNodos = nodos.size();
		nodoInicial = nodos.get(0);
		nodoFinal = nodos.get(5);//ACA PONER EL NODO FINAL, -1...
		sc.close();
	}
	/*
	 * Se cargan temporalmente las aristas y nodos en variables de "Entrada"
	 * En "cargar grafo" se van a cargar al grafo...
	 */
	
	
	public void cargarGrafo(Grafo g) {
		g.setAristasCien(aristasCien);
		for(int i =0;i<aristas.size();i++)
			g.addArista(aristas.get(i));
		for(int i =0;i<cantNodos;i++)
			g.addNodo(nodos.get(i));
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public ArrayList<Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(ArrayList<Nodo> nodos) {
		this.nodos = nodos;
	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public void setAristas(ArrayList<Arista> aristas) {
		this.aristas = aristas;
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

	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ArrayList<Arista> getAristasCien() {
		return aristasCien;
	}

	public void setAristasCien(ArrayList<Arista> aristasCien) {
		this.aristasCien = aristasCien;
	}
}
