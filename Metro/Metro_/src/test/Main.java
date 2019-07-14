package test;

import java.io.FileNotFoundException;

import files.Entrada;
import logica.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Entrada e = new Entrada ("grafo.in");
		e.leerGrafo();
		Grafo g = new Grafo(e.getCantNodos());
		e.cargarEnGrafo(g);

		g.ejecutar(g.getNodo(new Nodo(0)));
	}
}