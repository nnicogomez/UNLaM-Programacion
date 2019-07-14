package logica;

public class Nodo implements Comparable<Nodo>{
	private int index;
	private String nombre;
	private int distancia;
	private Nodo predecesor;
	
	public Nodo(int index) {
		this.index = index;
		this.nombre = Integer.toString(index);
		distancia = Integer.MAX_VALUE;
	}
	
	public Nodo(int index, int d) {
		this.index = index;
		this.nombre = Integer.toString(index);
		distancia =d;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public Nodo getPredecesor() {
		return predecesor;
	}

	public void setPredecesor(Nodo predecesor) {
		this.predecesor = predecesor;
	}

	@Override
	public int compareTo(Nodo o) {
		return this.distancia-o.distancia;
	}

	@Override
	public String toString() {
		return "Nodo: " + (index+1);
	}
}
