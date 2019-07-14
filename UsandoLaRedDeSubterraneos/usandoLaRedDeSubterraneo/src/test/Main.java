package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import in.Entrada;
import logica.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Entrada e = new Entrada("grafo.in");
		e.leerGrafo();
		Grafo g = new Grafo(e.getCantAristas());
		e.cargarEnGrafo(g);
		g.obtener(e.getNodoInicial(), e.getNodoFinal());
	}

}
