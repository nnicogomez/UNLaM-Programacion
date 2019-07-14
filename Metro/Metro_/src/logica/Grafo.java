package logica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Grafo {
	private MatrizAdyacencia matrizAdyacencia;
	private Nodo[] nodos;
	private int cantNodos;
	private ArrayList<Arista> arbol;
	private int[] padres;
	private ArrayList<Integer> nodosConectados;
	private ArrayList<Integer> nodosNoConectados;
	private ArrayList<Arista> puentes;
	private int minimoCosto;
	private static final int INFINITO = -1;
	private Grafo g;

	public Grafo(int cantNodos) {
		this.cantNodos = cantNodos;
		matrizAdyacencia = new MatrizAdyacencia(cantNodos, cantNodos);
		nodos = new Nodo[cantNodos];
		new ArrayList<Arista>();
		this.arbol = new ArrayList<Arista>();
		this.padres = new int[cantNodos];
		this.inicializarPadres();
		this.minimoCosto = 0;
		this.nodosNoConectados = new ArrayList<Integer>();
		this.nodosConectados = new ArrayList<Integer>();
		puentes = new ArrayList<Arista>();
	}
	
	public void addNodo(Nodo n) {
		nodos[n.getIndex()] = n;
	}
	
	public Nodo getNodo(Nodo n) {
		return nodos[n.getIndex()];
	}
	
	public int getCantidadNodos() {
		return nodos.length;
	}
	
	public void addArista(Arista a) {
		matrizAdyacencia.addValue(a.getNodoIzq().getIndex(),a.getNodoDer().getIndex(), a.getCosto());
	}

	public Arista getArista(int i, int j) {
		if(matrizAdyacencia.getValue(i, j)==MatrizAdyacencia.getInfinito() || matrizAdyacencia.getValue(i, j)==0)
			return null;
		return new Arista(new Nodo(i),new Nodo(j),matrizAdyacencia.getValue(i, j));
	}
	
	public boolean hayArista(int f, int c) {
		if(matrizAdyacencia.getValue(f, c)==-1 || matrizAdyacencia.getValue(f, c)==0)
			return false;

		return true;
	}

	public MatrizAdyacencia getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public void setMatrizAdyacencia(MatrizAdyacencia matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}

	public Nodo[] getNodos() {
		return nodos;
	}

	public void setNodos(Nodo[] nodos) {
		this.nodos = nodos;
	}
	
	public void setPuente(Arista a) {
		matrizAdyacencia.addValue(a.getNodoIzq().getIndex(),a.getNodoDer().getIndex(), 2);
		if(!puentes.contains(a))
			puentes.add(a);
	}
	
	public void setTunel(Arista a) {
		matrizAdyacencia.addValue(a.getNodoIzq().getIndex(),a.getNodoDer().getIndex(), 1);
	}
	
	public void ejecutar(Nodo nodoIn) throws Exception{
		for (int i = 0; i < cantNodos; i++)
			nodosNoConectados.add(i);

		int indiceNodoInicial = nodoIn.getIndex();//Indice del nodo inicial
		nodosConectados.add(indiceNodoInicial);//coloco el inicial como "conectado"
		nodosNoConectados.remove(nodosNoConectados.indexOf(indiceNodoInicial));
		int indiceI=0;
		int indiceJ=0;
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

						if (hayArista(indiceI,indiceJ))
							if (distancia == INFINITO || getArista(indiceI, indiceJ).getCosto() < distancia)
								if (find(nodoActual) != find(nodo)) {
									distancia = getArista(indiceI, indiceJ).getCosto();
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

		int cantPuentes=0;
		for (Arista rama : arbol) {
			for(int i=0;i<puentes.size();i++) {
				if(rama.getNodoDer().getIndex()==puentes.get(i).getNodoDer().getIndex() &&
				   rama.getNodoIzq().getIndex()==puentes.get(i).getNodoIzq().getIndex() &&
				   rama.getCosto()==puentes.get(i).getCosto())
					cantPuentes++;
			}
		}
		System.out.println("Cantidad de puentes usados: "+cantPuentes);
		grabarArchivo(cantPuentes);
	}
	
	private void grabarArchivo(int cantPuentes) throws IOException {
		PrintWriter p = new PrintWriter(new FileWriter("grafo.out"));
		p.print(cantPuentes);
		p.close();
		
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
