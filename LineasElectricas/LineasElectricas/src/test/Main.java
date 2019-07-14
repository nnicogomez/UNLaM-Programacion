package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import files.Entrada;
import logic.Grafo;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Entrada e = new Entrada("Grafo.in");
		e.leerGrafo();
		Grafo g = new Grafo(e.getCantNodos(),Integer.MAX_VALUE);
		e.cargarEnGrafo(g);
		g.ejecutar();
	}

}
