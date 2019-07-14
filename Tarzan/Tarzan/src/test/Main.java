package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import files.Entrada;
import logic.Grafo;
import logic.MatrizAdyacencia;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Entrada e = new Entrada("Grafo.in");
		e.leerArchivo();
		Grafo g = new Grafo(e.getCantNodos());
		e.cargarGrafo(g);
		MatrizAdyacencia.mostrarMatriz(g.getMatrizAdyacencia().getMatriz());
		g.resolver(e.getNodoInicial(), e.getNodoFinal());
	}

}
