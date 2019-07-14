package logic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Grafo {
	private MatrizAdyacencia matrizAdyacencia;
	private Nodo[] nodos;
	private int cantNodos;
	private int cantAristas;
	private int minimoCosto;
	private Nodo nodoInicial;
	private Nodo nodoFinal;
	private static final int INFINITO = MatrizAdyacencia.valorInfinito;
	ArrayList<Arista> aristasCien;
	
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

	public ArrayList<Arista> getAristasCien() {
		return aristasCien;
	}

	public void setAristasCien(ArrayList<Arista> aristasCien) {
		this.aristasCien = aristasCien;
	}

	public static int getInfinito() {
		return INFINITO;
	}

	public Grafo(int cantNodos) {
		this.cantNodos = cantNodos;
		minimoCosto = 0;
		matrizAdyacencia = new MatrizAdyacencia(cantNodos);
		nodos = new Nodo[cantNodos];
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
		if(matrizAdyacencia.getValue(i, j)==Integer.MAX_VALUE || matrizAdyacencia.getValue(i, j)==0)
			return null;
		return new Arista(new Nodo(i),new Nodo(j),matrizAdyacencia.getValue(i, j));
	}
	
	public boolean hayArista(int f, int c) {
		if(matrizAdyacencia.getValue(f, c)==Integer.MAX_VALUE || matrizAdyacencia.getValue(f, c)==0)
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

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public int getMinimoCosto() {
		return minimoCosto;
	}

	public void setMinimoCosto(int minimoCosto) {
		this.minimoCosto = minimoCosto;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}

	public void resolver(Nodo ni, Nodo nf) throws IOException {
		nodoInicial=ni;
		nodoFinal=nf;
		
		System.out.println("[NODO INICIAL] Indice: "+(nodoInicial.getIndex()+1)+" (X: "+nodoInicial.getX()+", Y: "+nodoInicial.getY()+")");
		System.out.println("[NODO FINAL] Indice: "+(nodoFinal.getIndex()+1)+" (X: "+nodoFinal.getX()+", Y: "+nodoFinal.getY()+")");
		
		int minimo=Integer.MAX_VALUE;
		int band=0;
		int[] distancia  = new int[cantNodos];
		boolean[] visitado  = new boolean[cantNodos];
		Nodo[] encolados = new Nodo[cantNodos];
		ArrayList<Nodo> camino= new ArrayList<Nodo>();
		PriorityQueue<Nodo> cola = new PriorityQueue<>();
		System.out.println("CANTIDAD DE ARISTAS A PROBAR: "+aristasCien.size());
		
		for(int m=0;m<aristasCien.size()+1;m++) {
			
			if(band!=0)
				addArista(new Arista(aristasCien.get(m-1).getNodoIzq(), aristasCien.get(m-1).getNodoDer(),1));
			
			distancia  = new int[cantNodos];
			visitado  = new boolean[cantNodos];
			ArrayList<Nodo> nodos = new ArrayList<Nodo>();
			
			for(int i=0; i<cantNodos; i++){
				distancia[i] = Integer.MAX_VALUE;
				visitado[i] = false;
				nodos.add(getNodo(new Nodo(i)));
			}
			
			distancia[nodoInicial.getIndex()] = 0;
			nodoInicial.setDistancia(0);
			encolados = new Nodo[cantNodos];
			cola = new PriorityQueue<>();
			nodoInicial.setPredecesor(new Nodo(-1));
			cola.add(nodoInicial);
			encolados[nodoInicial.getIndex()]=nodoInicial;
			
			while(!cola.isEmpty()){
				Nodo nodoActual = cola.poll();
				visitado[nodoActual.getIndex()] = true;
				for(int ady = 0; ady <cantNodos; ady++){
					if(nodoActual.getIndex() != ady) {
						if(hayArista(nodoActual.getIndex(),ady)) {
							Arista a = getArista(nodoActual.getIndex(), new Nodo(ady).getIndex());
								int dist = a.getCosto()+nodoActual.getDistancia();
								if(!visitado[ady] && dist <distancia[ady]) {
									distancia[ady] = dist;
									Nodo nodoInsertar = new Nodo(ady);
									nodoInsertar.setDistancia(dist);
									nodoInsertar.setPredecesor(nodoActual);
									nodoInsertar.setX(getNodo(new Nodo(ady)).getX());
									nodoInsertar.setY(getNodo(new Nodo(ady)).getY());
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

			if(minimo>distancia[nodoFinal.getIndex()]) {
				int i=nodoFinal.getIndex();
				minimo=distancia[nodoFinal.getIndex()];
				camino = new ArrayList<Nodo>();
				if(encolados[i]!=null) {
					camino.add(encolados[encolados[i].getIndex()]);
					while(encolados[i].getPredecesor().getIndex()!=-1) {
						camino.add(encolados[encolados[i].getPredecesor().getIndex()]);
						i=encolados[i].getPredecesor().getIndex();
					}
				}
			}
			if(band!=0)
				addArista(new Arista(aristasCien.get(m-1).getNodoIzq(), aristasCien.get(m-1).getNodoDer(),Integer.MAX_VALUE));
			band=1;
		}
		
		for(int i=0;i<camino.size();i++) {
			encolados[camino.get(i).getIndex()]=camino.get(i);
		}
		
		PrintWriter p = new PrintWriter (new FileWriter("grafo.out"));
		Stack<Nodo> pila = new Stack<Nodo>();
		grabarArchivo(encolados, distancia, p, pila);
	}

	private void grabarArchivo(Nodo[] encolados, int[] distancia, PrintWriter p, Stack<Nodo> pila) {
		int i=nodoFinal.getIndex();
		pila.add(nodoFinal);
		if(encolados[i]!=null) {
			System.out.println("HAY CAMINO: ");
			System.out.print((encolados[nodoFinal.getIndex()].getIndex()+1)+" ");
			while(encolados[i].getPredecesor().getIndex()!=-1) {
				System.out.print((encolados[i].getPredecesor().getIndex()+1)+" ");
				pila.add(encolados[encolados[i].getPredecesor().getIndex()]);
				i=encolados[i].getPredecesor().getIndex();
			}
			System.out.println("TAMAÑO DE CAMNIO: "+distancia[nodoFinal.getIndex()]);
			int tamp=pila.size();
			for(int k=0;k<tamp;k++) {
				Nodo n = pila.pop();
				p.println(n.getX()+" "+n.getY());
			}
		}
		else { p.print("NO EXISTE CAMINO");System.out.println("NO EXISTE CAMINO");}
		p.close();
	}
}