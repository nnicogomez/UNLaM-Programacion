package logic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Grafo {
	private int cantNodos;
	private Nodo[] nodos;
	private MatrizAdyacencia matrizAdyacencia;
	private ArrayList<Arista> arbol;
	private int padres[];
	private int minimoCosto;


	public Grafo(int c) {
		cantNodos=c;
		matrizAdyacencia = new MatrizAdyacencia(c);
		nodos = new Nodo[c];
		padres = new int[c];
		arbol = new ArrayList<Arista>();
		inicializarPadres();
		minimoCosto=0;
	}
	
	public void addNodo(Nodo n) {
		nodos[n.getIndice()]=n;
	}
	public Nodo getNodo(int i) {
		return nodos[i];
	}
	
	public void addArista(Arista a) {
		matrizAdyacencia.addValue(a.getNodoIzq().getIndice(), a.getNodoDer().getIndice(), a.getCosto());
		
	}
	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
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

	public ArrayList<Arista> getArbol() {
		return arbol;
	}

	public void setArbol(ArrayList<Arista> arbol) {
		this.arbol = arbol;
	}

	public int[] getPadres() {
		return padres;
	}

	public void setPadres(int[] padres) {
		this.padres = padres;
	}

	public int getMinimoCosto() {
		return minimoCosto;
	}

	public void setMinimoCosto(int minimoCosto) {
		this.minimoCosto = minimoCosto;
	}

	public Arista getArista(Nodo i, Nodo j) {
		if(matrizAdyacencia.getValue(i.getIndice(), j.getIndice())==Integer.MAX_VALUE) {
			return null;
		}
		return new Arista(i,j,matrizAdyacencia.getValue(i.getIndice(), j.getIndice()));
	}
	public boolean hayArista(Nodo i, Nodo j) {
		if(matrizAdyacencia.getValue(i.getIndice(), j.getIndice())==Integer.MAX_VALUE) {
			return false;
		}
		return true;
	}

	private void inicializarPadres() {
		for(int i=0;i<cantNodos;i++) {
			padres[i]=i;
		}
	}
	
	public void obtenerCaminoKruskal() {
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		for(int i=0;i<cantNodos;i++) {
			for(int j=0;j<cantNodos;j++) {
				if(hayArista(getNodo(i),getNodo(j))){
					aristas.add(getArista(getNodo(i),getNodo(j)));
				}
			}
		}
		
		Collections.sort(aristas);
		for( Arista a : aristas) {
			int n1 = a.getNodoIzq().getIndice();
			int n2 = a.getNodoDer().getIndice();
			int c=a.getCosto();
			if(find(n1) != find(n2)) {
				union(n1,n2);
				arbol.add(a);
				minimoCosto+=c;
			}
		}
		System.out.println("Minimo costo: "+minimoCosto);
		for( Arista a : arbol) {
			System.out.println(a);
			
		grabarArchivo(minimoCosto,arbol,"Grafo.out");
		}
	}

	private void grabarArchivo(int minimoCosto2, ArrayList<Arista> arbol2, String pat) {
		PrintWriter p=null;
		try {
			p = new PrintWriter(new FileWriter(pat));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.println(arbol2.size());
		for( Arista a : arbol)
			p.println((a.getNodoIzq().getIndice()+1)+" "+(a.getNodoDer().getIndice()+1)+" "+a.getCosto());
		p.close();
	}

	public int find(int indice) {
		return padres[indice]==indice? indice:find(padres[indice]);
	}
	public void union(int i, int j) {
		padres[find(i)] = padres[find(j)];
	}
}