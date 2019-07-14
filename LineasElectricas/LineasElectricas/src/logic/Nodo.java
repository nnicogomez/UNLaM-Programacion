package logic;

public class Nodo implements Comparable<Nodo>{
	private String nombre;
	private int indice;
	private int distancia;
	
	public Nodo(int indice,String nombre) {
		this.indice = indice;
		this.nombre = nombre;
		this.distancia=Integer.MAX_VALUE;
	}
	
	public Nodo(int indice,String nombre, int distancia) {
		this.indice = indice;
		this.nombre = nombre;
		this.distancia=distancia;
	}
	
	public Nodo(int indice) {
		//System.out.println("Añadiendo indice "+indice);
		this.indice = indice;
		this.nombre = new String (Integer.toString(indice));
		this.distancia=Integer.MAX_VALUE;;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "Nodo: " + nombre + ", indice=" + indice + ", valor: "+ distancia;
	}

	public int compareTo(Nodo arg0) {
		return this.distancia-arg0.distancia;
	}
}
	
