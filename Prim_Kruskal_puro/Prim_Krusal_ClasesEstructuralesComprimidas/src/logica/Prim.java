package logica;

import java.util.ArrayList;
import java.util.Collections;

public class Prim {
	private ArrayList<Arista> arbol;
	private int[] padres;
	private ArrayList<Integer> nodosConectados;
	private ArrayList<Integer> nodosNoConectados;
	private int minimoCosto;
	private static final int INFINITO = Integer.MAX_VALUE;
	private int cantNodos;
	private int[][] matriz;
	private Grafo g;
	
	public Prim(Grafo g) {
		this.g = g;
		cantNodos = g.getCantNodos();
		new ArrayList<Arista>();
		this.arbol = new ArrayList<Arista>();
		this.padres = new int[cantNodos];
		this.inicializarPadres();
		this.minimoCosto = 0;
		this.nodosNoConectados = new ArrayList<Integer>();
		this.nodosConectados = new ArrayList<Integer>();
		matriz = new int [cantNodos][cantNodos];
		matriz = g.getMatrizAdyacencia().clone();
		System.out.println("DATOS: ");
		System.out.println("CANTIDAD DE NODOS: "+g.getCantNodos());
		System.out.println("MATRIZ ADYACENCIA: ");
		Grafo.mostrarMatriz(matriz);
		System.out.println("NODOS RECORRIDOS: VACIA ");
	}

	public void ejecutar(Nodo nodoIn){
		for (int i = 0; i < cantNodos; i++)
			nodosNoConectados.add(i);

		int indiceNodoInicial = nodoIn.getIndice();//Indice del nodo inicial
		nodosConectados.add(indiceNodoInicial);//coloco el inicial como "conectado"
		nodosNoConectados.remove(nodosNoConectados.indexOf(indiceNodoInicial));
		int indiceI;
		int indiceJ;
		int nodoCreceRama = 0;
		int nodoMasCercano = 0;
		
		while (arbol.size() < cantNodos - 1) {
			int distancia = INFINITO;
			for (int nodoActual : nodosConectados) {
					for (int nodo : nodosNoConectados) {
						if (nodoActual < nodo) {
							indiceI = nodoActual;
							indiceJ = nodo;
						} else {
							indiceJ = nodoActual;
							indiceI = nodo;
						}
	
						if (g.hayArista(indiceI,indiceJ))
							if (distancia == INFINITO || g.getArista(indiceI, indiceJ).getCosto() < distancia)
								if (find(nodoActual) != find(nodo)) {
									distancia = g.getArista(indiceI, indiceJ).getCosto();
									nodoMasCercano = nodo;
									nodoCreceRama = nodoActual;
								}
					}
			}
			union(nodoCreceRama, nodoMasCercano);
			if (nodoCreceRama < nodoMasCercano)
				arbol.add(new Arista(new Nodo(nodoCreceRama), new Nodo(nodoMasCercano), distancia)); 
			else 
				arbol.add(new Arista(new Nodo(nodoMasCercano), new Nodo(nodoCreceRama), distancia));
			
			minimoCosto += distancia;
			nodosNoConectados.remove(this.nodosNoConectados.indexOf(nodoMasCercano));
			nodosConectados.add(nodoMasCercano);
		}
		
		System.out.println("PRIM:");
		System.out.println("Costo del Árbol Abarcador Mínimo: " + minimoCosto);
		System.out.println("Cantidad de Ramas del Árbol: " + arbol.size());
		System.out.println("Lista de Ramas:");
		for (Arista rama : arbol) {
			System.out.println(rama.getNodoIzq() + " " + rama.getNodoDer());
		}
	}

	public void inicializarPadres() {
		System.out.println("Tamaño de padre: "+padres.length);
		for (int i = 0; i < padres.length; i++) {
			this.padres[i] = i;
			System.out.println("Padre: "+this.padres[i]);
		}
	}

	public int find(int nodo) {
		System.out.println("Buscando find de "+nodo);
		return this.padres[nodo] == nodo ? nodo : find(this.padres[nodo]);
	}

	public void union(int nodo1, int nodo2) {
		this.padres[find(nodo1)] = this.padres[find(nodo2)];
	}
	
}