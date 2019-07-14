package logica;

public class Nodo {
	private int index;
	private String nombre;
	
	public Nodo(int index) {
		this.index=index;
		nombre = new String(Integer.toString(index));
	}
	
	public Nodo(int index, String n) {
		this.index=index;
		nombre = new String(n);
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

	@Override
	public String toString() {
		return " " + (index+1);
	}
	
	
	
}
