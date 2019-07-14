package logic;

public class Arista {
	private Nodo nodoIzq;
	private Nodo nodoDer;
	private boolean valor;
	
	public Arista(Nodo ni,Nodo nd, boolean v) {
		nodoIzq = ni;
		nodoDer = nd;
		this.valor = v;
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

	public boolean getValor() {
		return valor;
	}

	public void setValor(boolean valor) {
		this.valor = valor;
	}
	
}
