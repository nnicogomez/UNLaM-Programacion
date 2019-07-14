package files;
	
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.Locale;
	import java.util.Scanner;
	import logica.*;

	public class Entrada {
		private String path;
		private int[][] matrizAd;
		private Nodo nodoInicial;
		private int cantNodos;
		private int cantPuentes;
		private int cantTuneles;
		private Scanner sc;
		private ArrayList<Arista> puentes;
		private ArrayList<Arista> tuneles;
		public Entrada(String p) {
			this.path = p;
		}
		
		public String leerGrafo() throws FileNotFoundException {
			sc = new Scanner (new File(path));
			sc.useLocale(Locale.ENGLISH);
			
			puentes = new ArrayList<Arista>();
			tuneles = new ArrayList<Arista>() ;
			
			cantNodos=sc.nextInt();
			cantTuneles=sc.nextInt();
			cantPuentes=sc.nextInt();
			
			matrizAd = new int[cantNodos][cantNodos];
			MatrizAdyacencia.inicializarMatriz(matrizAd);
			
			for(int i=0;i<cantTuneles;i++) {
				int aux1=sc.nextInt()-1;
				int aux2=sc.nextInt()-1;
				matrizAd[aux1][aux2]=matrizAd[aux2][aux1]=1;//En caso de que sea no ponderado, solamente colocamos un uno o cero
				tuneles.add(new Arista(new Nodo(aux1),new Nodo(aux2),1));
			}
			for(int i=0;i<cantPuentes;i++) {
				int aux1=sc.nextInt()-1;
				int aux2=sc.nextInt()-1;
				matrizAd[aux1][aux2]=matrizAd[aux2][aux1]=2;//En caso de que sea no ponderado, solamente colocamos un uno o cero
				puentes.add(new Arista(new Nodo(aux1),new Nodo(aux2),2));
			}

			return "fin de la carga\n";
		}
		
		public void cargarEnGrafo(Grafo g) {
			for(int i=0;i<puentes.size();i++)
				g.setPuente(puentes.get(i));
			
			for(int i=0;i<g.getMatrizAdyacencia().getMatrizAdyacencia().length;i++) {
				g.addNodo(new Nodo(i));
				for(int j=0;j<g.getMatrizAdyacencia().getMatrizAdyacencia()[i].length;j++) {
					g.addArista(new Arista(new Nodo(i),new Nodo (j),matrizAd[i][j]));
				}
			}
			System.out.println("********************");
			MatrizAdyacencia.mostrarMatriz(g.getMatrizAdyacencia().getMatrizAdyacencia());
			System.out.println("********************");
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

		public Nodo getNodoInicial() {
			return nodoInicial;
		}

		public void setNodoInicial(Nodo nodoInicial) {
			this.nodoInicial = nodoInicial;
		}

		public int getCantNodos() {
			return cantNodos;
		}

		public void setCantNodos(int cantNodos) {
			this.cantNodos = cantNodos;
		}

		public int getCantPuentes() {
			return cantPuentes;
		}

		public void setCantPuentes(int cantPuentes) {
			this.cantPuentes = cantPuentes;
		}

		public int getCantTuneles() {
			return cantTuneles;
		}

		public void setCantTuneles(int cantTuneles) {
			this.cantTuneles = cantTuneles;
		}

		public Scanner getSc() {
			return sc;
		}

		public void setSc(Scanner sc) {
			this.sc = sc;
		}

		public ArrayList<Arista> getPuentes() {
			return puentes;
		}

		public void setPuentes(ArrayList<Arista> puentes) {
			this.puentes = puentes;
		}

		public ArrayList<Arista> getTuneles() {
			return tuneles;
		}

		public void setTuneles(ArrayList<Arista> tuneles) {
			this.tuneles = tuneles;
		}

	
	
}
