package test;

import java.io.FileNotFoundException;

import files.Entrada;
import logic.AlgoritmoResolucion;
import logic.Arista;
import logic.Grafo;
import logic.MatrizAdyacencia;
import logic.Nodo;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Entrada a = new Entrada("grafo.in");
		a.procesarArchivo();
		Grafo g = new Grafo(a.getCantNodos());
		a.cargarGrafo(g);
		AlgoritmoResolucion.colorearSecuencialmente(g);
		g.calcularInvitados();
	}

}
