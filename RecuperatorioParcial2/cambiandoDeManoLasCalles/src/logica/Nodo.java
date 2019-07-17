package logica;

public class Nodo implements Comparable<Nodo>{
	private int index;
	private int distancia;
	private String nombre;
	private Nodo predecesor;
	
	public Nodo(int i) {
		this.index = i;
		this.nombre = new String(Integer.toString(i));
		this.distancia = MatrizAdyacencia.getInfinito();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Nodo getPredecesor() {
		return predecesor;
	}

	public void setPredecesor(Nodo predecesor) {
		this.predecesor = predecesor;
	}

	@Override
	public String toString() {
		return "Indice:" + index;
	}

	@Override
	public int compareTo(Nodo o) {
		return this.distancia-o.distancia;
	}
}
