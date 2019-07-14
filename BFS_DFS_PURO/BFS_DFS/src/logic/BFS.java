package logic;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public static void recorrer(Grafo g, Nodo nodoInicial){
		
		boolean[] visitado = new boolean[g.getCantidadNodos()];
		Queue<Nodo> cola = new LinkedList<Nodo>();
		
		visitado[nodoInicial.getIndice()] = true;
		cola.add(nodoInicial);
		System.out.println(nodoInicial.toString());
		while(!cola.isEmpty()){
			Nodo n = cola.poll();
			for(Nodo ady : g.getAdyacentes(n)){
				if(visitado[ady.getIndice()] == false){
					cola.add(ady);	
					System.out.println(ady.toString());
					visitado[ady.getIndice()] = true;
				}
			}
		}
	}
}
