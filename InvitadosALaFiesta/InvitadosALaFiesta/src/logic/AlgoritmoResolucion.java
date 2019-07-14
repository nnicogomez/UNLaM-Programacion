package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class AlgoritmoResolucion {

	private static int cantColores;

	private static int colorear(Grafo g) {
		int color=1;   
		int columna;
		int cantidadDeNodosEntrada =g.getNodos().length;
		g.getNodos()[0].setColor(color);
		System.out.println("Pintando "+(0+1)+" con color "+color );
		ArrayList<Integer> colores = new ArrayList<Integer>();
		colores.add(0, color);
		//System.out.println("Setie color "+color +" a nodo"+g.getNodos()[0].getIndice()+" nodos leng"+cantidadDeNodosEntrada);
		for (int nodoAcolorear = 1; nodoAcolorear < cantidadDeNodosEntrada; nodoAcolorear++)
		{
			g.getNodos()[nodoAcolorear].setColor(color);
			System.out.println("Pintando "+(nodoAcolorear+1)+" con color "+color );
			columna = 0;
			colores.add(nodoAcolorear, color);
			//System.out.println("Setie color "+color +" a nodo"+g.getNodos()[nodoAcolorear].getIndice()+" nodos leng"+cantidadDeNodosEntrada);
			
			while ( columna < cantidadDeNodosEntrada){
				//VERIFICO SI ES ADYACENTE Y SI EL COLOR EN EL QUE ESTOY ACTUALMENTE PARADO ES EL MISMO DE SER ASI DEBERIA CAMBIARLO
				if(	g.getAristas().getValue(g.getNodos()[nodoAcolorear].getIndice(), g.getNodos()[columna].getIndice())  && //ES ADYACENTE AL PIVOT
						g.getNodos()[nodoAcolorear].getColor() == g.getNodos()[columna].getColor()//EL ADYACENTE ES DEL MISMO COLOR
				){
					color++;
					if(color > cantColores) //CREE UN NUEVO COLOR
						cantColores = color; 
					else
						columna= -1;
					g.getNodos()[nodoAcolorear].setColor(color);
					System.out.println("Pintando "+(nodoAcolorear+1)+" con color "+color );
					colores.add(nodoAcolorear, color);
				}
				columna++;
			}
			color = 1;
		}
		System.out.println("colores finales:");
		for(int i=0;i<g.getCantidadNodos();i++)
			System.out.println("Nodo "+(g.getNodo(i).getIndice()+1)+", color "+g.getNodo(i).getColor());
		
		return cantColores;
	}

	public static int colorearSecuencialmente(Grafo g){
		return colorear(g);
	}
}
