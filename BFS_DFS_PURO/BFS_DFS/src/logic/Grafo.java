package logic;

import java.util.ArrayList;
import java.util.Arrays;

public class Grafo {
	private MatrizAdyacencia aristas;
	private Nodo[] nodos;
	
	public Grafo(int cantNodos, int valorInfinito) {
		nodos = new Nodo[cantNodos];//Define el tamaño del vector de nodos
		aristas = new MatrizAdyacencia(cantNodos);
		aristas.setValorInfinito(valorInfinito);//Setea el infinito
		//Ya inicializa la matriz
	}
	
	public void addNodo(Nodo n) {
		nodos[n.getIndice()]=n;
	}
	
	public Nodo getNodo(int indice) {
		return nodos[indice];
	}
	
	public int getCantidadNodos() {
		return nodos.length;
	}
	
	public ArrayList<Nodo> getAdyacentes(Nodo n) {
		ArrayList<Nodo> adyacentes = new ArrayList<Nodo>();
		for(Nodo posibleAdyacente : nodos)
			if(aristas.getValue(n.getIndice(), posibleAdyacente.getIndice()) != aristas.getValorInfinito())
				adyacentes.add(posibleAdyacente);
		return adyacentes;
	}
	
	public void addArista(Arista a) {
		aristas.addValue(a.getNodoIzq().getIndice(), a.getNodoDer().getIndice(), a.getCosto());
	}
	
	public Arista getArista(Nodo nodoInicial, Nodo nodoFinal) {
		int distancia =  aristas.getValue(nodoInicial.getIndice(), nodoFinal.getIndice());
		if(distancia == aristas.getValorInfinito())
			return null;
		return new Arista(nodoInicial,nodoFinal,aristas.getValue(nodoInicial.getIndice(), nodoFinal.getIndice()));
	}
	
	public MatrizAdyacencia getAristas() {
		return aristas;
	}

	public void setAristas(MatrizAdyacencia aristas) {
		this.aristas = aristas;
	}

	public Nodo[] getNodos() {
		return nodos;
	}

	public void setNodos(Nodo[] nodos) {
		this.nodos = nodos;
	}

	public void mostrarGrafo() {
		MatrizAdyacencia.mostrarMatriz(aristas.getMatriz());
	}
	
}
