package files;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import logic.Arista;
import logic.Grafo;
import logic.MatrizAdyacencia;
import logic.Nodo;

public class Entrada {
	private String path;
	private boolean[][] mat;
	private int cantNodos;
	private int cantAristas;
	
	public Entrada(String p) {
		this.path=p;
	}
	
	public String procesarArchivo() throws FileNotFoundException {
		Scanner sc = new Scanner (new File(path));
		sc.useLocale(Locale.ENGLISH);
		cantNodos = sc.nextInt();
		cantAristas = sc.nextInt();
		mat = new boolean[cantNodos][cantNodos];
		MatrizAdyacencia.inicializarMatrizConInfinito(mat);
		for(int i=0;i<cantAristas;i++) {
			int aux1=sc.nextInt()-1;
			int aux2=sc.nextInt()-1;
			mat[aux1][aux2]=mat[aux2][aux1]=true;//Tarde en descubrir que no habia puesto la simetria como 4 horas.
		}
		MatrizAdyacencia.mostrarMatriz(mat);
		return "CargaCompleta";
	}
	
	public String cargarGrafo(Grafo g) {
		for(int i=0;i<g.getAristas().getMatrizAdyacencia().length;i++) {
			g.addNodo(new Nodo(i));
			for(int j=0;j<g.getAristas().getMatrizAdyacencia()[i].length;j++) {
				g.addArista(new Arista(new Nodo(i),new Nodo (j),mat[i][j]));
			}
		}
		//MatrizAdyacencia.mostrarMatriz(g.getAristas().getMatrizAdyacencia());
		return "Carga completa";
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean[][] getMat() {
		return mat;
	}

	public void setMat(boolean[][] mat) {
		this.mat = mat;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}
	
	public boolean getValor(int fila, int columna) {
		return mat[fila][columna];
	}
}
