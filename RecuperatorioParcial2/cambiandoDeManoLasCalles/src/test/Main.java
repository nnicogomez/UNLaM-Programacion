package test;

import java.io.FileNotFoundException;

import archivos.Entrada;
import logica.Grafo;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Entrada e = new Entrada("cambio.in");
		e.leerArchivo();
		Grafo g = new Grafo (e.getCantNodos());
		e.cargarGrafo(g);
		g.resolverConDijkstra(e.getInicial(), e.getDfinal());
	}

}
