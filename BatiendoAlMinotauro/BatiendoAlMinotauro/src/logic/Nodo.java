package logic;

public class Nodo {
	private int indice;
	private String nombre;
	
	public Nodo(int n) {
		indice=n;
		nombre=new String(Integer.toString(n));
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
		return "Nodo: " + (indice+1);
	}
	
	
}
