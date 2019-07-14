package test;

import java.io.FileNotFoundException;

import ios.Entrada;
import logic.Grafo;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Entrada e = new Entrada("grafo.in");
		e.leerArchivo();
		Grafo g = new Grafo(e.getCantNodos());
		e.cargarGrafo(g);
		g.obtenerCaminoKruskal();
	}

}
