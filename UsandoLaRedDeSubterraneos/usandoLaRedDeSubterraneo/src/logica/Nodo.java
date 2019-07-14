package logica;

import java.util.ArrayList;

public class Nodo implements Comparable<Nodo>{
	private int index;
	private String nombre;
	private ArrayList<String> lineas;
	private Nodo predecesor;
	private int distancia;
	
	public ArrayList<String> getLineas() {
		return lineas;
	}

	public void setLineas(ArrayList<String> lineas) {
		this.lineas = lineas;
	}

	public Nodo(int index) {
		this.index=index;
		nombre = new String(Integer.toString(index));
		lineas = new ArrayList<String>();
		distancia = Integer.MAX_VALUE;
	}
	
	public Nodo(int index, String n) {
		this.index=index;
		nombre = new String(n);
		lineas = new ArrayList<String>();
		distancia = Integer.MAX_VALUE;
	}

	public void addLinea(String l) {
		lineas.add(l);
	}
	
	public Nodo getPredesceor() {
		return predecesor;
	}

	public void setPredecesor(Nodo predecesor) {
		this.predecesor = predecesor;
	}

	public void getLinea(int i) {
		lineas.get(i);
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

	@Override
	public int compareTo(Nodo arg) {
		return this.distancia-arg.getDistancia();
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int i) {
		distancia = i;
		
	}
	public void mostrarLineas() {
		System.out.print("\nEstacion: "+(this.getIndex())+". Lineas:");
		for(int i=0;i<this.lineas.size();i++) {
			System.out.print(" "+(this.lineas.get(i)));
		}
	}
}
