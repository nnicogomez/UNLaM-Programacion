package logic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Set;

public class AlgoritmoResolucion {
	
	private static int cantidadNodos;
	private static int[] vectorPrecedencia;
	private static int[] vectorValores;
	private static Hashtable<Integer, Integer> vMenosS = new Hashtable<Integer, Integer>();
	
	public static void solucionar(Grafo g) throws FileNotFoundException {
		
		vectorValores = new int[g.getCantidadNodos()];
		vectorPrecedencia = new int[g.getCantidadNodos()];
		int i = 0;
		int menorValor = Integer.MAX_VALUE;
		int menorKey = 0;
		int valorAux;
	
		while (i < g.getCantidadNodos()) {
			vectorValores[i] = g.getAristas().getMatriz()[g.getNodoReina().getIndice()][i];
			vectorPrecedencia[i] = (g.getNodoReina().getIndice());
			System.out.println("Vector de valores: pos "+i+" valor: "+g.getAristas().getMatriz()[g.getNodoReina().getIndice()][i]);
			System.out.println("Vector de presedencia: pos "+i+" valor: "+(g.getNodoReina().getIndice()));
			vMenosS.put(i, g.getAristas().getMatriz()[g.getNodoReina().getIndice()][i]);
			vMenosS.remove(g.getAristas().getMatriz()[g.getNodoReina().getIndice()][i]);
			i++;
		}
		
		System.out.println("SALI");
		while (vMenosS.size() != 0) {
			Set<Integer> keys = vMenosS.keySet();
			for (Integer key : keys) {
				if (menorValor >= vMenosS.get(key)) {
					menorValor = vMenosS.get(key);
					menorKey = key;
					System.out.println("menor key "+menorKey);
				}
				System.out.println("SAD");
			}
			System.out.println("sss");
	
			for (int cantVectorValores = 0; cantVectorValores < vectorValores.length; cantVectorValores++) {
				if (cantVectorValores != (g.getNodoReina().getIndice()) && cantVectorValores != menorKey
						&& (g.getNodoReina().getIndice()) != menorKey) {
					valorAux = g.getAristas().getMatriz()[menorKey][cantVectorValores] + vectorValores[menorKey];
					if (valorAux <= vectorValores[cantVectorValores]) {
						vectorValores[cantVectorValores] = valorAux;
						vectorPrecedencia[cantVectorValores] = menorKey;
						vMenosS.put(cantVectorValores, valorAux);
					}
				}
			}
			menorValor = 100001;
			System.out.println("Nodo eliminado: " + menorKey);
			vMenosS.remove(menorKey);
		}
		guardarResultado(g);
	}
	
	public static void guardarResultado(Grafo g) throws FileNotFoundException {

		PrintWriter pw = new PrintWriter("salida.txt");

		boolean interceptado = false;
		int valorPrincipe = vectorValores[g.getNodoPrincipe().getIndice()];
		if (valorPrincipe == 100000)
			pw.println("NO HAY CAMINO");

		for (int j = 0; j < g.getNodosDragon().size(); j++) {
			if (vectorValores[g.getNodosDragon().get(j)] <= valorPrincipe)
				interceptado = true;
		}

		if (interceptado) {
			pw.print("INTERCEPTADO");
			System.out.println("interceptado");
		} else {
			// Enhorabuena!!

			int inicial = (g.getNodoPrincipe().getIndice());
			pw.print(inicial + 1);

			while ((g.getNodoReina().getIndice()) != vectorPrecedencia[inicial]) {
				inicial = vectorPrecedencia[inicial];
				pw.println('\t');
				pw.println(inicial + 1);
			}
			pw.println('\t');
			pw.println(vectorPrecedencia[inicial] + 1);

		}
		pw.close();
	}
}
