package logic;

public class Nodo {
	private String nombre;
	private int indice;
	private int grado;
	private int distancia;
	
	public Nodo(int indice,String nombre) {
		this.indice = indice;
		this.nombre = nombre;
		this.grado = 0;
		this.distancia=Integer.MAX_VALUE;
	}
	
	public Nodo(int indice) {
		this.indice = indice;
		this.nombre = new String ("Sin nombre");
		this.grado = 0;
		this.distancia=Integer.MAX_VALUE;
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

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
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
	
	public int compareTo(Nodo n) {
		if(n.distancia>this.distancia)
			return -1;
		if(n.distancia<this.distancia)
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return "Nodo: " + nombre + ", indice=" + indice;
	}
	
}
