package testMain;

import java.io.FileNotFoundException;

import lectura.Entrada;
import logica.Grafo;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Entrada e = new Entrada("gusano.in");
		e.leerArchivo();
		Grafo g = new Grafo(e.getCantNodos());
		e.cargarGrafo(g);
		g.obtenerInicial();
	}

}
