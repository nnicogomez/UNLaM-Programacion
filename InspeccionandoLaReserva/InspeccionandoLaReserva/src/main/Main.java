package main;

import java.io.FileNotFoundException;

import files.Entrada;
import logic.AlgoritmoResolucion;
import logic.Grafo;
import logic.Nodo;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Entrada e = new Entrada ( "grafo.in");
		e.leerGrafo();
		Grafo g = new Grafo(e.getCantNodos(),false);
		e.cargarEnGrafo(g);
		AlgoritmoResolucion.recorrer(g,new Nodo(0),new Nodo(9));
	}

}
