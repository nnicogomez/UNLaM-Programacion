package logic;

public class Arista implements Comparable<Arista>{
	private Nodo nodoIzq;
	private Nodo nodoDer;
	private int costo;
	
	public Arista(Nodo ni, Nodo nd, int costo) {
		nodoIzq=ni;
		nodoDer=nd;
		this.costo=costo;
	}
	
	public Arista(Nodo ni, Nodo nd) {
		nodoIzq=ni;
		nodoDer=nd;
		this.costo=Integer.MAX_VALUE;
	}
	
	public Nodo getNodoIzq() {
		return nodoIzq;
	}
	public void setNodoIzq(Nodo nodoIzq) {
		this.nodoIzq = nodoIzq;
	}
	public Nodo getNodoDer() {
		return nodoDer;
	}
	public void setNodoDer(Nodo nodoDer) {
		this.nodoDer = nodoDer;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}

	@Override
	public int compareTo(Arista arg0) {
		return this.costo-arg0.costo;
	}
	
	
}