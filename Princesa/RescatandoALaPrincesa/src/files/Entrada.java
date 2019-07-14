package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Scanner;

import logic.*;

public class Entrada {
	private String path;
	private int[][] matrizAd;
	private int nodoReina;
	private int nodoPrincipe;
	private int cantDragones;
	private int cantNodos;
	private int cantAristas;
	private Scanner sc;
	private Hashtable<Integer, Integer> vMenosS = new Hashtable<Integer, Integer>();
	ArrayList<Integer> indicesDragon = new ArrayList<Integer>();
	
	public Entrada(String p) {
		this.path = p;
	}
	
	public String leerGrafo() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);

		cantNodos = sc.nextInt();
		cantAristas = sc.nextInt();
		cantDragones = sc.nextInt();
		nodoReina = sc.nextInt()-1;
		nodoPrincipe = sc.nextInt()-1;

		for (int drag = 0; drag < cantDragones; drag++)
			indicesDragon.add(sc.nextInt()-1);

		int tam = 0;
		int x;
		int y;
		int value;

		matrizAd = new int[cantNodos][cantNodos];
		MatrizAdyacencia.inicializarMatrizEnInfinito(matrizAd);
		while (tam < cantAristas) {
			x = sc.nextInt() - 1;
			y = sc.nextInt() - 1;
			value = sc.nextInt();

			matrizAd[x][y] = value;
			matrizAd[y][x] = value;
			tam++;
		}
		sc.close();
		return "fin de la carga\n";
	}
	
	public void cargarEnGrafo(Grafo g) {
		for (int drag = 0; drag < indicesDragon.size(); drag++) {
			g.addNodoDragon(indicesDragon.get(drag));
			System.out.println("Dragones en: "+indicesDragon.get(drag));
		}
		
		for(int i=0;i<g.getAristas().getMatriz().length;i++) {
			g.addNodo(new Nodo(i));
			for(int j=0;j<g.getAristas().getMatriz()[i].length;j++) {
				g.addArista(new Arista(new Nodo(i),new Nodo (j),matrizAd[i][j]));
			}
		}
		
		System.out.println("Nodo princes: "+nodoReina+". Nodo principe: "+nodoPrincipe);
		MatrizAdyacencia.mostrarMatriz(g.getAristas().getMatriz());
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int[][] getMatrizAd() {
		return matrizAd;
	}

	public void setMatrizAd(int[][] matrizAd) {
		this.matrizAd = matrizAd;
	}
	

	public int getNodoReina() {
		return nodoReina;
	}

	public void setNodoReina(int nodoReina) {
		this.nodoReina = nodoReina;
	}

	public int getNodoPrincipe() {
		return nodoPrincipe;
	}

	public void setNodoPrincipe(int nodoPrincipe) {
		this.nodoPrincipe = nodoPrincipe;
	}

	public int getCantDragones() {
		return cantDragones;
	}

	public void setCantDragones(int cantDragones) {
		this.cantDragones = cantDragones;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public Hashtable<Integer, Integer> getvMenosS() {
		return vMenosS;
	}

	public void setvMenosS(Hashtable<Integer, Integer> vMenosS) {
		this.vMenosS = vMenosS;
	}

	public ArrayList<Integer> getIndicesDragon() {
		return indicesDragon;
	}

	public void setIndicesDragon(ArrayList<Integer> indicesDragon) {
		this.indicesDragon = indicesDragon;
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
}