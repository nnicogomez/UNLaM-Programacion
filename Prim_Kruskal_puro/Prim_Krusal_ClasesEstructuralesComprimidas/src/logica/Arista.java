package logica;

public class Arista implements Comparable<Arista>{
	private Nodo nodoIzq;
	private Nodo nodoDer;
	private int costo;
	
	public Arista(Nodo n1, Nodo n2, int v){
		nodoIzq= n1;
		nodoDer = n2;
		costo = v;
	}

	public Arista() {
		nodoIzq = new Nodo(-1);
		nodoDer = new Nodo(-1);
		costo = 0;
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
		return "Arista [nodoIzq=" + nodoIzq + "\nnodoDer=" + nodoDer + "\ncosto=" + costo + "]";
	}

	@Override
	public int compareTo(Arista o) {
		return this.costo-o.costo;
	}
	
}
