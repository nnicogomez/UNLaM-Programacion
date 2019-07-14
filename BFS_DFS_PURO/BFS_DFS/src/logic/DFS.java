package logic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {
	public static void recorrer(Grafo g, Nodo nodoInicial){
		
		boolean[] visitado = new boolean[g.getCantidadNodos()];
		Stack<Nodo> pila = new Stack<Nodo>();
		
		for(int i =0; i<visitado.length;i++)
			visitado[i]=false;
		
		visitado[nodoInicial.getIndice()] = true;
		pila.push(nodoInicial);
		
		while(!pila.isEmpty()){
			Nodo n = pila.pop();
			System.out.println(n.toString());
			for(Nodo ady : g.getAdyacentes(n)){
				if(visitado[ady.getIndice()] == false){
					pila.push(ady);
					visitado[ady.getIndice()] = true;
				}
			}
		}
	}
}