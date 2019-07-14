package test;

import java.io.FileNotFoundException;

import logica.Grafo;
import logica.Kruskal;
import logica.Nodo;
import logica.Prim;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Grafo g = new Grafo ("grafo.in");
		Prim p = new Prim(g);
		//p.ejecutar(new Nodo (0));
		Kruskal k = new Kruskal(g);
		//k.ejecutar();
	}

}
