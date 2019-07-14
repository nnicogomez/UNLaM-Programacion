package logic;

public class Nodo implements Comparable<Nodo>{
	private int index;
	private String nombre;
	private Nodo predecesor;
	private int distancia;
	
	public Nodo(int i) {
		index=i;
		distancia=Integer.MAX_VALUE;
		nombre=Integer.toString(i);
	}
	public Nodo(int i,int d) {
		index=i;
		distancia=d;
		nombre=Integer.toString(i);
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
	public Nodo getPredecesor() {
		return predecesor;
	}
	public void setPredecesor(Nodo predecesor) {
		this.predecesor = predecesor;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	@Override
	public int compareTo(Nodo arg0) {
		return this.distancia-arg0.distancia;
	}
	@Override
	public String toString() {
		return "Indice: " + index + ", predecesor=" + predecesor + ", distancia=" + distancia;
	}
}
