import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class buscarHostiles {
	private int[][]  p;
	private Scanner archivo;

	public buscarHostiles() throws FileNotFoundException {
		int minimo=0,maximo=0;
		int aux;
		archivo = new Scanner(new File("clima.in"));
		archivo.useLocale(Locale.ENGLISH);
		int registros= archivo.nextInt();
		p= new int[registros][2];
		for(int j=0; j<registros; j++) {
			int limite= archivo.nextInt();
			for(int i=0; i<limite*2; i++) {
				aux=archivo.nextInt();
				if(i==0)minimo=aux;
				else if(i%2==0)
						if(minimo>aux)minimo=aux;
						else if(i==1)maximo=aux;
							else if(i%2!=0)
								 if(maximo<aux)maximo=aux;
			}
			p[j][0]=minimo;
			p[j][1]=maximo;
		}
	}
	
	public void compararTemp() {
		int[][] mat = new int[p.length][2];
		for(int k=0;k<mat.length;k++)for(int m=0;m<mat[k].length;m++)mat[k][m]=0;
		for(int i=0;i<p.length;i++)
			for(int j=1;j<p.length;j++)
				if((p[i][0]<p[j][0]) && (p[i][1]>p[j][1]))mat[i][0]=1;
				else if(((p[i][0]<p[j][0]) && (p[i][1]<p[j][1])) || ((p[i][0]>p[j][0]) && (p[i][1]>p[j][1])))mat[j][1]++;
					 else if((p[i][0]>p[j][0]) && (p[i][1]<p[j][1]))mat[j][0]=1;
		
		for(int l=0;l<mat.length;l++) {
			if(mat[l][0]==1)
				System.out.println("Lugares hostiles: "+(l+1)+"\nLugares sin comparar: "+mat[l][1]);
		}	
	}
	
	
	/*
	Casos de prueba: 
	1. Caso de fatiga - no creo que lo pase por la complejidad (n^2)
	2. que pasa si todos son hostiles.
	3. que pasa si ninguno es hostil.
	4. solo un hostil que se comparo contra todos.
	5. muchos hostiles todos comparados entre si.
*/}
