package logica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Grafo {
	private MatrizAdyacencia matrizAdyacenciaCompleta;
	private Nodo nodoInicial;
	private Nodo nodoFinal;
	private Nodo[] nodos;
	private int cantNodos;
	private HashMap<Integer,Arista> calles;
	
	public Grafo(int cant) {
		cantNodos = cant;
		matrizAdyacenciaCompleta = new MatrizAdyacencia(cant);
		nodos = new Nodo[cant];
		calles = new HashMap<Integer,Arista>();
	}
	
	public HashMap<Integer, Arista> getCalles() {
		return calles;
	}

	public void setCalles(HashMap<Integer, Arista> calles) {
		this.calles = calles;
	}

	public void addNodo(Nodo n) {
		nodos[n.getIndex()]=n;
	}
	
	public Nodo getNodo(Nodo nodo) {
		return nodos[nodo.getIndex()];
	}

	
	public void addAristaCompleta(Arista a) {
		if(a.getNodoIzq().getIndex()!=a.getNodoDer().getIndex()) {
			matrizAdyacenciaCompleta.addValue(a.getNodoIzq().getIndex(), a.getNodoDer().getIndex(), a.getCosto());
			matrizAdyacenciaCompleta.addValue(a.getNodoDer().getIndex(), a.getNodoIzq().getIndex(), a.getCosto());
		}
	}
	
	public Arista getAristaCompleta(int f, int c) {
		return matrizAdyacenciaCompleta.getValue(f, c) == Integer.MAX_VALUE ? null:new Arista(getNodo(new Nodo(f)),getNodo(new Nodo(c)),matrizAdyacenciaCompleta.getValue(f, c));
	}
	
	public boolean hayAristaCompleta(int f, int c) {
		return matrizAdyacenciaCompleta.getValue(f, c) == Integer.MAX_VALUE ? false:true;
	}
	
	public Nodo getNodoInicial() {
		return nodoInicial;
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

	public void setNodoInicial(Nodo nodoInicial) {
		this.nodoInicial = nodoInicial;
	}
	public Nodo[] getNodos() {
		return nodos;
	}

	public void setNodos(Nodo[] nodos) {
		this.nodos = nodos;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}
	
	public void resolverConDijkstra(Nodo ni, Nodo nf) {
		nodoInicial = ni;
		nodoFinal = nf;
		
		boolean[] visitados = new boolean[cantNodos];
		int[] distancias = new int[cantNodos];
		ArrayList<Nodo> nodos = new ArrayList<Nodo>();
		
		for(int i=0;i<cantNodos;i++) {
			visitados[i] = false;
			distancias[i] = MatrizAdyacencia.getInfinito();
			nodos.add(getNodo(new Nodo(i)));
		}

		PriorityQueue<Nodo> cola = new PriorityQueue<Nodo>();
		Nodo[] encolados = new Nodo[cantNodos];
		nodoInicial.setDistancia(0);
		nodoInicial.setPredecesor(new Nodo(-1));
		distancias[nodoInicial.getIndex()]=0;
		cola.add(nodoInicial);
		encolados[nodoInicial.getIndex()]=nodoInicial;
		
		while(!cola.isEmpty()) {
			Nodo actual = cola.poll();
			visitados[actual.getIndex()]=true;
			for(int ady=0;ady<cantNodos;ady++) {
				if(hayAristaCompleta(actual.getIndex(),ady)) {
					Arista a = getAristaCompleta(actual.getIndex(), ady);
					int dist = actual.getDistancia()+a.getCosto();
					if(!visitados[ady] && dist<distancias[ady]) {
						Nodo nodoInsertar = new Nodo(ady);
						nodoInsertar.setDistancia(dist);
						distancias[ady]=dist;
						nodoInsertar.setPredecesor(actual);
						if(cola.contains(nodoInsertar))
							cola.remove(nodoInsertar);
						cola.add(nodoInsertar);
						encolados[nodoInsertar.getIndex()]=nodoInsertar;
					}
				}
			}
		}

		Nodo act = encolados[nodoFinal.getIndex()];
		
		ArrayList<Arista> camino = new ArrayList<Arista>();
		while(act.getPredecesor().getIndex() !=-1) {
			camino.add(getAristaCompleta(act.getPredecesor().getIndex(),act.getIndex()));
			act=act.getPredecesor();
		}
		
		ArrayList<Integer> cambiar = new ArrayList<Integer>();
		
		for(Integer a : calles.keySet())
			for(int i=0;i<camino.size();i++)
				if(calles.get(a).getNodoIzq().getIndex()==camino.get(i).getNodoDer().getIndex() &&
						calles.get(a).getNodoDer().getIndex()==camino.get(i).getNodoIzq().getIndex())
					cambiar.add((a+1));

		grabarEnArchivo(cambiar,distancias,nodoFinal);
		
		
	}

	private void grabarEnArchivo(ArrayList<Integer> cambiar, int[] distancias, Nodo nodoFinal2) {
		PrintWriter p=null;
		try {
			p = new PrintWriter(new FileWriter("cambio.out"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.println(distancias[nodoFinal2.getIndex()]);
		System.out.println(distancias[nodoFinal2.getIndex()]);
		for(int i=0;i<cambiar.size();i++) {
			p.print(cambiar.get(i)+" ");
			System.out.print(cambiar.get(i)+" ");
		}
	p.close();
	}
}