package logic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Grafo {
	private Nodo[] nodos;
	private MatrizAdyacencia matrizAdyacencia;
	private MatrizAdyacencia matrizAdyacenciaCompleta;
	private int cantNodos;
	private Nodo nodoInicial;
	private Nodo nodoFinal;
	private HashMap<Integer,Arista> calles;
	
	public Grafo(int cant) {
		cantNodos=cant;
		matrizAdyacencia = new MatrizAdyacencia(cantNodos,cantNodos);
		matrizAdyacenciaCompleta = new MatrizAdyacencia(cantNodos,cantNodos);
		nodos = new Nodo[cantNodos];
		calles = new HashMap<Integer,Arista>();
	}

	public HashMap<Integer, Arista> getCalles() {
		return calles;
	}

	public void setCalles(HashMap<Integer, Arista> calles) {
		this.calles = calles;
	}

	public Nodo[] getNodos() {
		return nodos;
	}

	public void setNodos(Nodo[] nodos) {
		this.nodos = nodos;
	}

	public MatrizAdyacencia getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public void setMatrizAdyacencia(MatrizAdyacencia matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}
	
	public void addNodo(Nodo n) {
		nodos[n.getIndex()]=n;
	}
	
	public Nodo getNodo(int i) {
		return nodos[i];
	}
	
	public void addArista(Arista a) {
		matrizAdyacencia.addValue(a.getNodoIzq().getIndex(), a.getNodoDer().getIndex(), a.getCosto());
	}
	public void addAristaCompleta(Arista a) {
		matrizAdyacenciaCompleta.addValue(a.getNodoIzq().getIndex(), a.getNodoDer().getIndex(), a.getCosto());
		matrizAdyacenciaCompleta.addValue(a.getNodoDer().getIndex(), a.getNodoIzq().getIndex(), a.getCosto());
	}
	
	public Arista getArista(int f, int c) {
		return new Arista(getNodo(f),getNodo(c),matrizAdyacencia.getValue(f, c));
	}
	
	public boolean hayArista(int f, int c) {
		return matrizAdyacencia.getValue(f, c) == Integer.MAX_VALUE ? false : true;
	}
	
	public Arista getAristaCompleta(int f, int c) {
		return new Arista(getNodo(f),getNodo(c),matrizAdyacenciaCompleta.getValue(f, c));
	}
	
	public boolean hayAristaCompleta(int f, int c) {
		return matrizAdyacenciaCompleta.getValue(f, c) == Integer.MAX_VALUE ? false : true;
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

	public MatrizAdyacencia getMatrizAdyacenciaCompleta() {
		return matrizAdyacenciaCompleta;
	}

	public void setMatrizAdyacenciaCompleta(MatrizAdyacencia matrizAdyacenciaCompleta) {
		this.matrizAdyacenciaCompleta = matrizAdyacenciaCompleta;
	}

	public void calcularConDjkistra(Nodo ni, Nodo nf) {
		nodoInicial = ni;
		nodoFinal = nf;
		boolean[] visitado = new boolean[cantNodos];
		int[] distancias = new int[cantNodos];
		ArrayList<Nodo> nodos = new ArrayList<Nodo>();
		
		for(int i=0;i<cantNodos;i++) {
			visitado[i]=false;
			distancias[i]=Integer.MAX_VALUE;
			nodos.add(this.getNodo(i));
		}
		
		PriorityQueue<Nodo> cola = new PriorityQueue<Nodo>();
		Nodo[] encolados = new Nodo[cantNodos];
		nodoInicial.setDistancia(0);
		nodoInicial.setPredecesor(new Nodo(-1));
		distancias[nodoInicial.getIndex()]=0;
		cola.add(nodoInicial);
		encolados[nodoInicial.getIndex()]=nodoInicial;
		
		while(!cola.isEmpty()) {
			Nodo n = cola.poll();
			visitado[n.getIndex()]=true;
			for(int ady=0;ady<cantNodos;ady++) {
				if(n.getIndex() != ady) {
					if(hayAristaCompleta(n.getIndex(),ady)){
						Arista a = new Arista(n,nodos.get(ady),getAristaCompleta(n.getIndex(),ady).getCosto());
						int dist = n.getDistancia()+getAristaCompleta(n.getIndex(),ady).getCosto();
						if(!visitado[ady] && dist<distancias[ady]) {
							distancias[ady]=dist;
							Nodo nodoInsertar = new Nodo(ady);
							nodoInsertar.setDistancia(dist);
							nodoInsertar.setPredecesor(n);
							if(cola.contains(nodoInsertar))
								cola.remove(nodoInsertar);
							cola.add(nodoInsertar);
							encolados[nodoInsertar.getIndex()]=nodoInsertar;
						}
					}
				}
			}
		}

		ArrayList<Arista> nuevas = new ArrayList<Arista>();
		Nodo actual = encolados[nodoFinal.getIndex()];
		while(actual.getPredecesor().getIndex()!=-1) {
			if(!hayArista(actual.getPredecesor().getIndex(),actual.getIndex()))
				nuevas.add(getAristaCompleta(actual.getIndex(),actual.getPredecesor().getIndex()));
			actual=actual.getPredecesor();
		}
		
		
		buscarSolucion(distancias, nuevas);
	}

	private void buscarSolucion(int[] distancias, ArrayList<Arista> nuevas) {
		PrintWriter p=null;
		try {
			p = new PrintWriter(new FileWriter("grafo.out"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.println(distancias[nodoFinal.getIndex()]);
		System.out.println("DISTANCIA: "+distancias[nodoFinal.getIndex()]);
		for(int i=0;i<nuevas.size();i++) {
			for(Integer x : calles.keySet()) {
				if(calles.get(x).getNodoDer().getIndex()==nuevas.get(i).getNodoDer().getIndex() &&
						calles.get(x).getNodoIzq().getIndex()==nuevas.get(i).getNodoIzq().getIndex()) {
					System.out.println("Calle a modificar: "+(x));
					p.print(x+" ");
				}
			}	
		}
		p.close();
	}
}
