package logica;

public class Nodo {
	private int indice;
	private String nombre;
	private int valor; //Solo para Djkistra y PRIM
	// Para esto tambien hay que implementar el comparable y hacer la comparacion
	//private int grado; //Solo para coloreo
	public Nodo(int indice) {
		this.indice = indice;
		this.nombre = Integer.toString(indice);
		this.valor = Integer.MAX_VALUE;
	}
	
	public Nodo(int indice, int valor) {
		this.indice = indice;
		this.nombre = Integer.toString(indice);
		this.valor = valor;
	}
	
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Nodo [indice=" + indice + ", nombre=" + nombre + "]";
	}
}
