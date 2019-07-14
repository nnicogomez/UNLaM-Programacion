package test;

import java.io.FileNotFoundException;

import files.Entrada;
import logic.Grafo;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Entrada e = new Entrada("grafo.in");
		e.leerGrafo();
		Grafo g = new Grafo(e.getCantNodos() );
		e.cargarGrafo(g);
		g.calcularConDjkistra(e.getNodoInicial(), e.getNodoFinal());
	}

}
