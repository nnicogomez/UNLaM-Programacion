package logic;

public class Nodo {
	private String nombre;
	private int indice;
	private int grado;
	private int color;
	
	public Nodo(int i) {
		this.indice=i;
		this.grado=0;
		this.nombre=Integer.toString(i);
		this.color=-1;
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
	public void incrementarGrado() {
		this.grado++;
	}
	public void disminuirGrado() {
		this.grado--;
	}
	public void reiniciarGrado() {
		this.grado=0;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Nodo " + nombre + ", indice=" + indice+ ", color=" + color;
	}
	
	
}
