package logica;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
	private ArrayList<Arista> arbol;
	private int[] padres;
	private ArrayList<Arista> aristas;
	private int minimoCosto;
	private int cantNodos;
	private int[][] matriz;
	private Grafo g;
	
	
	public Kruskal(Grafo g) {
		this.g = g;
		cantNodos = g.getCantNodos();
		new ArrayList<Arista>();
		this.arbol = new ArrayList<Arista>();
		this.aristas = new ArrayList<Arista>();
		this.padres = new int[cantNodos];
		this.inicializarPadres();
		this.minimoCosto = 0;
		matriz = new int [cantNodos][cantNodos];
		matriz = g.getMatrizAdyacencia().clone();
		System.out.println("DATOS: ");
		System.out.println("CANTIDAD DE NODOS: "+g.getCantNodos());
		System.out.println("MATRIZ ADYACENCIA: ");
		Grafo.mostrarMatriz(matriz);
		System.out.println("NODOS RECORRIDOS: VACIA ");
	}
	
	public void ejecutar(){
		int indiceI, indiceJ;
		int nodo1;
		int nodo2;
		int peso;
		
		for (int i = 0; i < this.cantNodos; i++)
			for (int j = i + 1; j < this.cantNodos; j++) {
				indiceI=i;
				indiceJ=j;
				if (g.hayArista(indiceI,indiceJ))
					aristas.add(new Arista(new Nodo(i), new Nodo( j) ,g.getArista(indiceI, indiceJ).getCosto()));
		}
		
		Collections.sort(this.aristas);
		for (Arista a : aristas) {
			nodo1 = a.getNodoIzq().getIndice();
			nodo2 = a.getNodoDer().getIndice();
			peso = a.getCosto();
			
			if (find(nodo1) != find(nodo2)) {
				union(nodo1, nodo2);
				this.arbol.add(a);
				this.minimoCosto += peso;
			}
		}
		System.out.println("KRUSKAL:");
		System.out.println("Costo del Árbol Abarcador Mínimo: " + this.minimoCosto);
		System.out.println("Cantidad de Ramas del Árbol: " + this.arbol.size());
		System.out.println("Lista de Ramas:");
		for (Arista rama : arbol)
			System.out.println(rama.getNodoIzq().getIndice() + " " + rama.getNodoDer().getIndice());

	}
	
	public void inicializarPadres() {
		for (int i = 0; i < padres.length; i++) {
			this.padres[i] = i;
		}
	}
	
	public int find(int nodo) {
		return this.padres[nodo] == nodo ? nodo : find(this.padres[nodo]);
	}
	
	public void union(int nodo1, int nodo2) {
		this.padres[find(nodo1)] = this.padres[find(nodo2)];
	}
}
