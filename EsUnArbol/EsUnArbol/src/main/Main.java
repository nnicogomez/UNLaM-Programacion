package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import files.*;
import logic.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Entrada e = new Entrada("grafo.in");
		e.leerGrafo();
		Grafo g = new Grafo(e.getCantNodos(),Integer.MAX_VALUE);
		e.cargarEnGrafo(g);
		g.EsArbol();
		}

}
