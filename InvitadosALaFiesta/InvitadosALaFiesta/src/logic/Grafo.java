package logic;

import java.util.ArrayList;

public class Grafo {
	private MatrizAdyacencia aristas;
	private Nodo[] nodos;
	
	public Grafo(int cantNodos) {
		aristas = new MatrizAdyacencia(cantNodos,false);
		nodos = new Nodo[cantNodos];
	}
	
	public void addArista(Arista a) {
		aristas.addValue(a.getNodoIzq().getIndice(), a.getNodoDer().getIndice(), a.getValor());
		a.getNodoDer().incrementarGrado();
		a.getNodoIzq().incrementarGrado();
	}
	public Arista getArista(Nodo n1, Nodo n2) {
		boolean conexion = aristas.getValue(n1.getIndice(), n2.getIndice());
		if(conexion == MatrizAdyacencia.getValorInfinito())
			return null;
		return new Arista(n1,n2, aristas.getValue(n1.getIndice(), n2.getIndice()));
	}
	
	public ArrayList<Nodo> getAdyacentes(Nodo n){
		ArrayList<Nodo> adyacentes = new ArrayList<Nodo>();
		for(Nodo posibleAdyacente : nodos)
			if(aristas.getValue(n.getIndice(), posibleAdyacente.getIndice()) != MatrizAdyacencia.getValorInfinito())
				adyacentes.add(posibleAdyacente);
		return adyacentes;
	}
	
	public void addNodo(Nodo n) {
		nodos[n.getIndice()]=n;
	}
	public Nodo getNodo(int pos) {
		return nodos[pos];
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
	public int getCantidadNodos() {
		return aristas.getMatrizAdyacencia().length;
	}
	
	public void calcularInvitados() {
		int colorMax=0;
		System.out.print("La maxima cantidad de invitados posibles es");
		int max=0,cont=0;
		for(int i=0;i<nodos.length;i++) {
			cont=1;
			for(int j=i+1;j<nodos.length;j++) {
				if(nodos[i].getColor()==nodos[j].getColor())
					cont++;
			}
			if(max<cont) {
				max=cont;
				colorMax=nodos[i].getColor();
			}
		}
		System.out.println(" "+max+" combinacion maxima: ");
		ArrayList<Integer> colores = new ArrayList<Integer>();
		for(int i=0;i<nodos.length;i++) {
				if(nodos[i].getColor()==colorMax)
					System.out.println(""+(nodos[i].getIndice()+1));
		}
	}
	
	
}
