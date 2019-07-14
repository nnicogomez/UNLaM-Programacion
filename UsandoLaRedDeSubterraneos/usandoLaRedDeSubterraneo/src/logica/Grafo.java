package logica;

import java.io.FileWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Grafo {
	private MatrizAdyacencia matrizAdyacencia;
	private Nodo[] nodos;
	private int cantNodos;
	private ArrayList<Arista> puentes;
	private Nodo nodoInicial;
	private Nodo nodoFinal;

	public Grafo(int cantNodos) {
		this.cantNodos = cantNodos;
		matrizAdyacencia = new MatrizAdyacencia(cantNodos, cantNodos);
		nodos = new Nodo[cantNodos];
		new ArrayList<Arista>();
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
		if(a.getNodoIzq().getIndex()!=a.getNodoDer().getIndex())
			matrizAdyacencia.addValue(a.getNodoIzq().getIndex(),a.getNodoDer().getIndex(), a.getCosto());
	}

	public Arista getArista(int i, int j) {
		if(matrizAdyacencia.getValue(i, j)==Integer.MAX_VALUE)
			return null;
		return new Arista(getNodo(new Nodo(i)),getNodo(new Nodo(j)),matrizAdyacencia.getValue(i, j));
	}
	
	public boolean hayArista(int f, int c) {
		if(matrizAdyacencia.getValue(f, c)==Integer.MAX_VALUE)
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

	public  void obtener(Nodo ni, Nodo nf) throws IOException{
		nodoInicial=ni;
		nodoFinal=nf;
		int[] distancia  = new int[cantNodos];
		boolean[] visitado  = new boolean[cantNodos];
		ArrayList<Nodo> nodos = new ArrayList<Nodo>();
		for(int i=0; i<cantNodos; i++){
			distancia[i] = Integer.MAX_VALUE;
			visitado[i] = false;
			nodos.add(getNodo(new Nodo(i)));
		}
		
		distancia[nodoInicial.getIndex()] = 0;
		
		Nodo[] encolados = new Nodo[cantNodos];
		PriorityQueue<Nodo> cola = new PriorityQueue<>();
		nodoInicial.setPredecesor(new Nodo(-1));
		nodoInicial.setLineas(getNodo(new Nodo(nodoInicial.getIndex())).getLineas());
		nodoInicial.setDistancia(0);
		cola.add(nodoInicial);
		encolados[nodoInicial.getIndex()]=nodoInicial;
		
			while(!cola.isEmpty()){
				Nodo nodoActual = cola.poll();
				visitado[nodoActual.getIndex()] = true;
				for(int ady = 0; ady <cantNodos; ady++){
					if(nodoActual.getIndex() != ady) {
						if(hayArista(nodoActual.getIndex(),ady)) {
							Arista a = getArista(nodoActual.getIndex(), ady);
								int dist = a.getCosto()+nodoActual.getDistancia();
								if(!visitado[ady] && dist <distancia[ady]) {
									distancia[ady] = dist;
									Nodo nodoInsertar = new Nodo(ady);
									nodoInsertar.setDistancia(dist);
									nodoInsertar.setPredecesor(nodoActual);
									nodoInsertar.setLineas(getNodo(new Nodo(ady)).getLineas());
									if(cola.contains(nodoInsertar)) {
										cola.remove(nodoInsertar);
									}
									cola.add(nodoInsertar);
									encolados[nodoInsertar.getIndex()]=nodoInsertar;
								}
						}
					}
				}
			}
			System.out.println("Distancias desde la estacion inicial: "+(nodoInicial.getIndex()+1));
			for(int i=0;i<distancia.length;i++)
					System.out.println("Estacion: "+(i+1)+". Distancia: "+distancia[i]);
			
			for(int i=0;i<encolados.length;i++) {
				System.out.println("\nLinea "+((encolados[i].getIndex())+1)+" con predecesor "+((encolados[i].getPredesceor().getIndex())+1));
				System.out.print("Las lineas de la estacion "+(encolados[i].getIndex()+1)+" son");
				for(int j=0;j<encolados[i].getLineas().size();j++) {
					System.out.print(" "+(encolados[i].getLineas().get(j)));
				}
			}
			int band=0;
			Nodo act = encolados[nodoFinal.getIndex()];
			String lineaActual=new String("-1");
			ArrayList<String> caminoRealizado = new ArrayList<String>();
			while(act.getPredesceor().getIndex()!=-1) {
				for(int i=0;i<act.getLineas().size();i++) {
					if(!act.getLineas().get(i).equals(lineaActual))
						lineaActual=act.getLineas().get(i);
						band=0;
					for(int j=0;j<act.getPredesceor().getLineas().size();j++)
						if(lineaActual.equals(act.getPredesceor().getLineas().get(j))) {
							band=1;
							caminoRealizado.add(new String(lineaActual));
						}
						if(band==1)
							act=act.getPredesceor();
					}
				}
			grabarEnArchivo("grafo.out",caminoRealizado);
	}

	private void grabarEnArchivo(String string, ArrayList<String> caminoRealizado) throws IOException {
		PrintWriter p = new PrintWriter(new FileWriter(string));
		p.println(caminoRealizado.size());
		System.out.print("\n*********\nTotal de lineas: "+caminoRealizado.size()+". Camino: ");
		for(int i=0;i<caminoRealizado.size();i++) {
			p.print(caminoRealizado.get(i)+" ");
			System.out.print(caminoRealizado.get(i)+" ");
		}
		p.close();
	}
}
