package logic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
	
	public Nodo buscarProblemasDevolverRaiz() {
		int[][] mat = new int[getNodos().length][getNodos().length];
		mat= getAristas().getMatriz().clone();
		Nodo posibleRaiz = new Nodo(-1);
		ArrayList<Nodo> desconectados= new ArrayList<Nodo>();
		ArrayList<Nodo> masDeUnaArista= new ArrayList<Nodo>();
		int cont=0,band=0;
		int cantRecibidos=0;
		for(int i=0;i<mat.length;i++) {
			band=0;
			cantRecibidos=0;
			for(int j=0;j<mat[i].length;j++) {
				if(mat[j][i]!=Integer.MAX_VALUE) {
					band=1;
					cantRecibidos++;
				}
			}
			if(band==0) {
				cont++;
				posibleRaiz = new Nodo(i);
				desconectados.add(new Nodo(i));
			}
			if(cantRecibidos>1) {
				System.out.println("Nodo que recibe mas de una arista: "+(i+1));
				masDeUnaArista.add(new Nodo(i));
			}
		}
		if(desconectados.size()>1) {
			System.out.println("No es arbol ya que no cumple regla 1");
			System.out.print("No se encuentra raiz. Involucrados: ");
			for(int i=0;i<desconectados.size();i++)
				System.out.print((desconectados.get(i).getIndice()+1)+" ");
			return null;
		}
		if(masDeUnaArista.size()>0) {
			System.out.println("No es arbol ya que no cumple regla 2");
			System.out.print("Involucrados: ");
			for(int i=0;i<masDeUnaArista.size();i++)
				System.out.print((masDeUnaArista.get(i).getIndice()+1)+" ");
			return null;
		}
		if(posibleRaiz.getIndice()==-1) {
			System.out.println("No es arbol ya que no cumple regla 1");
			return null;
		}
		return posibleRaiz;
	}
	
	public boolean EsArbol() throws IOException {
		int[][] mat = new int[getNodos().length][getNodos().length];
		mat= getAristas().getMatriz().clone();
		Nodo posibleRaiz = new Nodo(-1);
		ArrayList<Nodo> desconectados= new ArrayList<Nodo>();
		ArrayList<Nodo> masDeUnaArista= new ArrayList<Nodo>();
		int cont=0,band=0;
		int cantRecibidos=0;
		boolean ret=true;
		PrintWriter p = new PrintWriter(new FileWriter("grafo.out"));
		
		for(int i=0;i<mat.length;i++) {
			band=0;
			cantRecibidos=0;
			for(int j=0;j<mat[i].length;j++) {
				if(mat[j][i]!=Integer.MAX_VALUE) {
					band=1;
					cantRecibidos++;
				}
			}
			if(band==0) {
				cont++;
				posibleRaiz = new Nodo(i);
				desconectados.add(new Nodo(i));
			}
			if(cantRecibidos>1) {
				masDeUnaArista.add(new Nodo(i));
			}
		}
		
		if(desconectados.size()>1 || masDeUnaArista.size()>0 || posibleRaiz.getIndice()==-1)
			p.println("NO");
		
		if(posibleRaiz.getIndice()==-1) {
			p.print((posibleRaiz.getIndice()+1)+" ");
			System.out.println("No es arbol ya que no cumple regla 1");
			ret = false;
			p.println(" ");
		}
		if(desconectados.size()>1) {
			System.out.println("No es arbol ya que no cumple regla 1");
			System.out.print("No se encuentra raiz. Involucrados: ");
			for(int i=0;i<desconectados.size();i++) {
				System.out.print((desconectados.get(i).getIndice()+1)+" ");
				p.print((desconectados.get(i).getIndice()+1)+" ");
			}
			ret=false;
		}
		else
			p.print(0);
		p.println(" ");
		if(masDeUnaArista.size()>0) {
			System.out.println("No es arbol ya que no cumple regla 2");
			System.out.print("Involucrados: ");
			for(int i=0;i<masDeUnaArista.size();i++) {
				System.out.print((masDeUnaArista.get(i).getIndice()+1)+" ");
				p.print((masDeUnaArista.get(i).getIndice()+1)+" ");
			}
			ret = false;;
		}
		else
			p.print(0);
		
		Nodo raiz = posibleRaiz;
		boolean[] visitados = new boolean[getNodos().length]; 
		Queue<Nodo> cola = new LinkedList<Nodo>();
		
		for(int i=0;i<getNodos().length;i++) {
			visitados[i]=false;
		}
		int contad=0;
		cola.add(raiz);
		if(raiz.getIndice()!=-1) {
			cola.add(raiz);
			visitados[raiz.getIndice()]=true;
		}
		else {
			p.close();
			return false;
		}
		ArrayList<Nodo> nodosExcluidos = new ArrayList<Nodo>();
		while(!cola.isEmpty()) {
			Nodo n = cola.poll();
			for(Nodo x : getAdyacentes(n)) {
				if(visitados[x.getIndice()]==false) {
					cola.add(x);
					contad++;
					visitados[x.getIndice()]=true;
				}
			}
		}
		System.out.println("Cant nodos: "+getNodos().length+". Cant recorridos desde raiz: "+(contad+1));
		if(contad+1!=getNodos().length)
			ret = false;
			for(int i=0;i<visitados.length;i++) {
				if(visitados[i]==false){
					System.out.println("nodos no visitados: "+visitados[i]);
					p.print(visitados[i]+" ");
				}
			}
			p.close();
		return ret;
	}
	
}
