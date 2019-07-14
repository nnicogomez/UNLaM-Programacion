package logic;

public class Nodo {
	private String nombre;
	private int indice;
	private int grado;
	
	public Nodo(int indice,String nombre) {
		this.indice = indice;
		this.nombre = nombre;
		this.grado = 0;
	}
	
	public Nodo(int indice) {
		this.indice = indice;
		this.nombre = new String (Integer.toString(indice));
		this.grado = 0;
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

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}
	
	public void aumentarGrado() {
		this.grado++;
	}
	public void disminuirGrado() {
		this.grado--;
	}
	public void reiniciarGrado() {
		this.grado=0;
	}

	@Override
	public String toString() {
		return "Nodo: " + nombre + ", indice=" + indice;
	}
	
}