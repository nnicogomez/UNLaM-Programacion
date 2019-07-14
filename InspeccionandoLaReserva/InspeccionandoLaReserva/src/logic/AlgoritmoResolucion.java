package logic;

import java.util.*;

public class AlgoritmoResolucion {
		public static void recorrer(Grafo g, Nodo nodoInicial, Nodo nodoFinal){
			boolean[] visitado = new boolean[g.getCantidadNodos()];
			Queue<Nodo> cola = new LinkedList<Nodo>();
			int[] usados = new int[g.getCantidadNodos()];
			
			Arrays.fill(usados, 0);
			visitado[nodoInicial.getIndice()] = true;
			cola.add(nodoInicial);
			System.out.println("Recorriendo "+nodoInicial.toString());
			usados[nodoInicial.getIndice()]=1;
			
			while(!cola.isEmpty()){
				Nodo n = cola.poll();
				for(Nodo ady : g.getAdyacentes(n)) {
					usados[ady.getIndice()]+=usados[n.getIndice()];
					if(!visitado[ady.getIndice()]){
					cola.add(ady);	
					System.out.println("Recorriendo "+ady.toString());
					visitado[ady.getIndice()] = true;
					}
				}
			}
			System.out.println("Suma "+usados[g.getCantidadNodos()-1]);
			//Se asume que el ultimo nodo es el destino final...
		}
}
