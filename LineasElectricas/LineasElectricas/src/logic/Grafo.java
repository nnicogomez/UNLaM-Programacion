package logic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import logic.*;

public class Grafo {
	private MatrizAdyacencia matrizAdyacencia;
	private Nodo[] nodos;
	private ArrayList<Nodo> nodosIniciales;
	private ArrayList<Arista> arbol;
	private int[] padres;
	private ArrayList<Arista> aristas;
	private int cantNodos;
	private int minimoCosto;
	private int costoFinal;
	private ArrayList<Arista> arbolFinal;
	
	public Grafo(int cantNodos, int valorInfinito) {
		this.cantNodos=cantNodos;
		nodos = new Nodo[cantNodos];//Define el tamaño del vector de nodos
		matrizAdyacencia = new MatrizAdyacencia(cantNodos);
		arbol = new ArrayList<Arista>();
		aristas = new ArrayList<Arista>();
		padres = new int[cantNodos];
		inicializarPadres();
		minimoCosto = 0;
		nodosIniciales = new ArrayList<Nodo>();
		costoFinal = Integer.MAX_VALUE;
		arbolFinal = new ArrayList<Arista>();
	}
	
	public void addNodo(Nodo n) {
		nodos[n.getIndice()]=n;
	}
	
	public Nodo getNodo(int indice) {
		return nodos[indice];
	}
	
	public int getCantidadNodos() {
		//System.out.println("Cantidad nodos: "+nodos.length);
		return nodos.length;
	}
	
	public void addArista(Arista a) {
		matrizAdyacencia.addValue(a.getNodoIzq().getIndice(), a.getNodoDer().getIndice(), a.getCosto());
	}
	
	public Arista getArista(Nodo nodoInicial, Nodo nodoFinal) {
		int distancia =  matrizAdyacencia.getValue(nodoInicial.getIndice(), nodoFinal.getIndice());
		if(distancia == matrizAdyacencia.getValorInfinito())
			return null;
		return new Arista(nodoInicial,nodoFinal,matrizAdyacencia.getValue(nodoInicial.getIndice(), nodoFinal.getIndice()));
	}
	
	public MatrizAdyacencia getAristas() {
		return matrizAdyacencia;
	}

	public void setAristas(MatrizAdyacencia aristas) {
		this.matrizAdyacencia = aristas;
	}

	public Nodo[] getNodos() {
		return nodos;
	}

	public void setNodos(Nodo[] nodos) {
		this.nodos = nodos;
	}

	public void ejecutar() throws IOException{
		
		for(int k=0;k<nodosIniciales.size();k++) {//HAGO LA ITERACION POR CADA NODO INICIAL
		//INICIALIZO LAS VARIABLES PARA QUE NO QUEDEN CON DATOS ANTIGUOS
		this.arbol = new ArrayList<Arista>();
		this.aristas = new ArrayList<Arista>();
		this.inicializarPadres();
		minimoCosto=0;	
		Nodo nodoact=nodosIniciales.get(k);
		int indiceI, indiceJ;
		int nodo1;
		int nodo2;
		int peso;
		
		for (int i = 0; i < this.cantNodos; i++)
			for (int j = i + 1; j < this.cantNodos; j++) {
				indiceI=i;
				indiceJ=j;
				if (hayArista(indiceI,indiceJ))
					aristas.add(new Arista(new Nodo(i), new Nodo( j) ,getArista(new Nodo(indiceI), new Nodo(indiceJ)).getCosto()));
		}
		
		Collections.sort(this.aristas);
		for (Arista a : aristas) {
			if(!buscarArista(a,nodoact)) {//SI LA ARISTA NO TIENE UNA CENTRAL (QUE NO SEA EN LA QUE YA ESTOY), AVANZO
			nodo1 = a.getNodoIzq().getIndice();
			nodo2 = a.getNodoDer().getIndice();
			peso = a.getCosto();
				if (find(nodo1) != find(nodo2)) {
					union(nodo1, nodo2);
					this.arbol.add(a);
					this.minimoCosto += peso;
				}
			}
		}
		if(costoFinal>minimoCosto) {//ME GUARDO EL CAMINO, SI ES MENOR QUE EL ANTERIOR
			arbolFinal = new ArrayList<Arista>();
			for(int i=0;i<arbol.size();i++)
				arbolFinal.add(arbol.get(i));
			costoFinal = minimoCosto;
		}
	}
		System.out.println("FINAL");
		System.out.println("Costo del Árbol Abarcador Mínimo: " + costoFinal);
		System.out.println("Cantidad de Ramas del Árbol: " + arbolFinal.size());
		System.out.println("Lista de Ramas:");
		for (Arista rama : arbolFinal)
			System.out.println(rama.getNodoIzq().getIndice() + " " + rama.getNodoDer().getIndice());
		grabarArchivo("grafo.out");
	}
	
	private void grabarArchivo(String path) throws IOException {
		PrintWriter p = new PrintWriter(new FileWriter(path));
		p.println(costoFinal);
		Stack<Arista> pila = new Stack<Arista>();
		for (Arista rama : arbolFinal)
			pila.add(rama);
		int aux = pila.size();
		for(int i=0;i<aux;i++) {
			Arista rama = pila.pop();
			p.println(((rama.getNodoIzq().getIndice()+1) + " " + (rama.getNodoDer().getIndice()+1)));
		}
		p.close();
		
	}

	private boolean buscarArista(Arista a, Nodo nact) {
		for(int i=0;i<nodosIniciales.size();i++) {
			//REVISO SIEMPRE Y CUANDO NO TOQUE EL NODO ACTUAL EN EL QUE ESTOY PARADO...
			if(nact.getIndice()!=nodosIniciales.get(i).getIndice()) {
				//SI LA ARISTA TIENE EN DERECHA AL NODO ACTUAL, Y EN IZQUIERDA A ALGUN OTRO NODO INICIAL(NODOS CON CENTRALES), NO SE DEBE PROCESAR 
				if(nact.getIndice()==a.getNodoDer().getIndice() && a.getNodoIzq().getIndice()==nodosIniciales.get(i).getIndice())
					return true;
				//SI LA ARISTA TIENE EN IZQUIERDA AL NODO ACTUAL, Y EN DERECHA A ALGUN OTRO NODO INICIAL(NODOS CON CENTRALES), NO SE DEBE PROCESAR 
				if(nact.getIndice()==a.getNodoIzq().getIndice() && a.getNodoDer().getIndice()==nodosIniciales.get(i).getIndice())
					return true;
				//SI LA ARISTA TIENE EN IZQUIERDA O DERECHA ALGUN NODO INICIAL
				if(a.getNodoIzq().getIndice()==nodosIniciales.get(i).getIndice() || a.getNodoDer().getIndice()==nodosIniciales.get(i).getIndice())
					return true;
				}
			}
		return false;
	}

	private boolean hayArista(int indiceI, int indiceJ) {
		return matrizAdyacencia.getValue(indiceI, indiceJ)!=Integer.MAX_VALUE?true:false;
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

	public MatrizAdyacencia getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public void setMatrizAdyacencia(MatrizAdyacencia matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}

	public ArrayList<Nodo> getNodosIniciales() {
		return nodosIniciales;
	}

	public void setNodosIniciales(ArrayList<Nodo> nodosIniciales) {
		this.nodosIniciales = nodosIniciales;
	}

	public void addNodosIniciales(Nodo nodosI) {
		this.nodosIniciales.add(nodosI);
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

	public void setAristas(ArrayList<Arista> aristas) {
		this.aristas = aristas;
	}
	
	
}