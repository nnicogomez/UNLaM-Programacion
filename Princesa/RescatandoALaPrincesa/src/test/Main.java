package test;

import java.io.FileNotFoundException;

import files.Entrada;
import logic.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Entrada e = new Entrada("grafo.in");
		e.leerGrafo();
		Grafo g = new Grafo(e.getCantNodos(),e.getCantDragones(),new Nodo(e.getNodoReina()),new Nodo(e.getNodoPrincipe()));
		e.cargarEnGrafo(g);
		AlgoritmoResolucion.solucionar(g);
		System.out.println("hola");
	}

}
