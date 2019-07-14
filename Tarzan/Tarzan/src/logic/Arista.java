package logic;

public class Arista {
	private Nodo nodoIzq;
	private Nodo nodoDer;
	private int costo;
	
	public Arista(Nodo nodoIzq, Nodo nodoDer, int costo) {
		super();
		this.nodoIzq = nodoIzq;
		this.nodoDer = nodoDer;
		this.costo = costo;
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
	
}

