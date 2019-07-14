package logica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Grafo {
	private MatrizAdyacencia matrizAdyacencia;
	private Nodo nodoInicial;
	private HashMap<Integer,Integer> horarios;
	private Nodo[] nodos;
	private int cantNodos;
	
	public Grafo(int cant) {
		cantNodos = cant;
		matrizAdyacencia = new MatrizAdyacencia(cant);
		nodos = new Nodo[cant];
		horarios = new HashMap<Integer,Integer>();
	}
	
	public void addNodo(Nodo n) {
		nodos[n.getIndex()]=n;
	}
	
	public Nodo getNodo(Nodo nodo) {
		return nodos[nodo.getIndex()];
	}
	
	public void addArista(Arista a) {
		if(a.getNodoIzq().getIndex()!=a.getNodoDer().getIndex())
			matrizAdyacencia.addValue(a.getNodoIzq().getIndex(), a.getNodoDer().getIndex(), a.getCosto());
	}
	
	public Arista getArista(int f, int c) {
		return matrizAdyacencia.getValue(f, c) == Integer.MAX_VALUE ? null:new Arista(getNodo(new Nodo(f)),getNodo(new Nodo(c)),matrizAdyacencia.getValue(f, c));
	}
	
	public boolean hayArista(int f, int c) {
		return matrizAdyacencia.getValue(f, c) == Integer.MAX_VALUE ? false:true;
	}

	public MatrizAdyacencia getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public void setMatrizAdyacencia(MatrizAdyacencia matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}

	public Nodo getNodoInicial() {
		return nodoInicial;
	}

	public void setNodoInicial(Nodo nodoInicial) {
		this.nodoInicial = nodoInicial;
	}

	public HashMap<Integer, Integer> getHorarios() {
		return horarios;
	}

	public void setHorarios(HashMap<Integer, Integer> horarios) {
		this.horarios = horarios;
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
	
	public void obtenerInicial() {
		ArrayList<Nodo> iniciales = new ArrayList<Nodo>();
		boolean[] visitado = new boolean[cantNodos];
		int[] distancias = new int[cantNodos];
		ArrayList<Nodo> nodos = new ArrayList<Nodo>();
		PriorityQueue<Nodo> cola = new PriorityQueue<Nodo>();
		Nodo[] encolados = new Nodo[cantNodos];
		
		/*for(Integer x : horarios.keySet()) {
			System.out.println("PC: "+x+", HORARIO: "+horarios.get(x));
		}*/
		for(int m=0;m<cantNodos;m++) {
			//System.out.println("Iterando");
			
			Nodo ni= new Nodo(m);
			distancias = new int[cantNodos];
			visitado = new boolean[cantNodos];
			nodos = new ArrayList<Nodo>();
			
			for(int i=0;i<cantNodos;i++) {
				visitado[i]=false;
				distancias[i]=Integer.MAX_VALUE;
				nodos.add(getNodo(new Nodo(i)));
			}
			
			cola = new PriorityQueue<Nodo>();
			encolados = new Nodo[cantNodos];
			
			ni.setDistancia(0);
			ni.setPredecesor(new Nodo(-1));
			cola.add(ni);
			encolados[ni.getIndex()]=ni;
			distancias[ni.getIndex()]=0;
			
			while(!cola.isEmpty()) {
				Nodo actual = cola.poll();
				visitado[actual.getIndex()]=true;
				for(int ady=0;ady<cantNodos;ady++) {
					if(hayArista(actual.getIndex(),ady)) {
						Arista a = new Arista(actual,getNodo(new Nodo(ady)),getArista(actual.getIndex(),ady).getCosto());
						int dist= actual.getDistancia()+a.getCosto();
						if(!visitado[ady] && dist<distancias[ady]) {
							distancias[ady]=dist;
							Nodo nodoInsertar = new Nodo(ady);
							nodoInsertar.setPredecesor(actual);
							nodoInsertar.setDistancia(dist);
							if(!cola.contains(nodoInsertar))
								cola.remove(nodoInsertar);
							cola.add(nodoInsertar);
							encolados[nodoInsertar.getIndex()]=nodoInsertar;
						}
					}
				}
			}
			//System.out.println("Con nodo inicial: "+ni.getIndex());
			int cont=0;
			for(Integer x : horarios.keySet())
				if(distancias[x]==horarios.get(x))
					cont++;
			if(cont==horarios.size()) {
				iniciales.add(ni);
				
			}
		}
		grabarArchivo(iniciales);
	}

	private void grabarArchivo(ArrayList<Nodo> iniciales) {
		PrintWriter p=null;
		try {
			p = new PrintWriter(new FileWriter("gusanos.out"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("POSIBLES INICIOS: ");
		for(int i=0;i<iniciales.size();i++) {
			System.out.println((iniciales.get(i).getIndex()+1)+" ");
			p.print((iniciales.get(i).getIndex()+1)+" ");
		}
		if(iniciales.size()==0)
			System.out.println("NO SE PUEDE ENCONTRAR INICIO");
		p.close();
	}
}
