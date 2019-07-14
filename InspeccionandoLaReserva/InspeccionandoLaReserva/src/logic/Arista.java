package logic;

public class Arista {
	private Nodo nodoIzq;
	private Nodo nodoDer;
	private boolean costo;
	
	public Arista(Nodo ni, Nodo nd, boolean costo) {
		nodoIzq=ni;
		nodoDer=nd;
		this.costo=costo;
	}
	
	public Arista(Nodo ni, Nodo nd) {
		nodoIzq=ni;
		nodoDer=nd;
		this.costo=false;
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
	public boolean getCosto() {
		return costo;
	}
	public void setCosto(boolean costo) {
		this.costo = costo;
	}
	
	
}