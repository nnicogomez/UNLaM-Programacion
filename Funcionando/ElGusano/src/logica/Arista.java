package logica;

public class Arista {
	private Nodo nodoIzq;
	private Nodo nodoDer;
	private int costo;
	
	public Arista(Nodo ni, Nodo nd, int c) {
		nodoIzq = ni;
		nodoDer = nd;
		costo = c;
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
	public String toString() {
		return "[Arista] Izquierdo: " + nodoIzq + ", derecho: " + nodoDer + ", costo: " + costo;
	}
	
	
}
