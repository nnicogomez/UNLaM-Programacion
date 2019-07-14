package logic;

import java.util.ArrayList;

public class Nodo implements Comparable<Nodo>{
	private int index;
	private int x;
	private int y;
	private int distancia;
	private String nombre;
	private Nodo predecesor;//Este contiene el predecesor al nodo.

	public Nodo(int index){
		this.index = index;
		distancia = Integer.MAX_VALUE;
		nombre = new String(Integer.toString(index));
	}
	
	public Nodo(int i, int j,int valor){
		this.index = valor;
		distancia = valor;
		x=i;
		y=j;
		nombre = new String(Integer.toString(index));
	}
	
	public Nodo(int index, int costo){
		this.index = index;
		distancia = costo;
		nombre = new String(Integer.toString(index));
	}
	
	public Nodo(int index, String nombre) {
		this.index = index;
		distancia = Integer.MAX_VALUE;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setIndex(int value){
		this.index = value;
	}
	
	public int getIndex(){
		return this.index;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	@Override
	public int compareTo(Nodo nodo) {
		if(this.distancia > nodo.distancia){
			return 1;
		}
		else if(this.distancia < nodo.distancia){
			return -1;
		}
		return 0;
	}
	@Override
	public String toString() {
		return "Nodo: "+(this.getIndex()+1);
	}
	
	public double calcularDistancia(Nodo n) {
		double primer=Math.pow((n.x-this.x), 2);
		double segundo=Math.pow((n.y-this.y), 2);
		double resultado=Math.sqrt(primer+segundo);
		//System.out.println("Resultado "+resultado);
		return resultado;
	}
	public boolean esAdyacente(Nodo n ) {
		return this.calcularDistancia(n)<50;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Nodo getPredecesor() {
		return predecesor;
	}

	public void setPredecesor(Nodo predecesor) {
		this.predecesor = predecesor;
	}

	public boolean esAdyacenteEntreCien(Nodo k) {
		//System.out.println("Nodo "+k.getIndex()+" y "+this.getIndex());
		 if(this.calcularDistancia(k)<100 && this.calcularDistancia(k)>50)
			 return true;
		 return false;
	}
	
}