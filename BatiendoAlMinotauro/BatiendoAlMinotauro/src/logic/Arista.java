package logic;

public class Arista implements Comparable<Arista>{
	private Nodo nodoIzq;
	private Nodo nodoDer;
	private int costo;
	
	public Arista(Nodo ni,Nodo nd, int cost) {
		nodoIzq=ni;
		nodoDer=nd;
		costo=cost;
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
	public int compareTo(Arista o) {
		return this.costo-o.costo;
	}

	@Override
	public String toString() {
		return "Nodo Izq. " + nodoIzq + ", Nodo Der." + nodoDer + ", costo=" + costo;
	}

	
	
}
