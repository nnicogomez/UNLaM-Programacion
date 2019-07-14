import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Cuestionario {
	private int cantPreguntas;
	private int cantEquipos;
	private char[][] respuestas;
	private String pathIn;
	private String pathOut;
	
	public Cuestionario(String p){
		pathIn = p;
		Scanner sc = null;
		try {
			sc = new Scanner(new File(pathIn));
		} catch (FileNotFoundException e) {
			System.out.println("Problemas para leer el archivo");
			e.printStackTrace();
		}
		sc.useLocale(Locale.ENGLISH);
		cantPreguntas=sc.nextInt();
		cantEquipos = sc.nextInt();
		respuestas = new char[cantEquipos][cantPreguntas];
		System.out.println("tamaño del vector "+respuestas.length);
		for(int i=0;i<cantEquipos;i++) {
			respuestas[i]=sc.next().toCharArray();
		}
		sc.close();
	}
	public int getCantPreguntas() {
		return cantPreguntas;
	}
	public void setCantPreguntas(int cantPreguntas) {
		this.cantPreguntas = cantPreguntas;
	}
	public int getCantEquipos() {
		return cantEquipos;
	}
	public void setCantEquipos(int cantEquipos) {
		this.cantEquipos = cantEquipos;
	}
	public char[][] getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(char[][] respuestas) {
		this.respuestas = respuestas;
	}
	
	public void calculoPrincipal() {
		int i,j,cont=0;
		int[] vectorPuntaje;
		
		vectorPuntaje = new int[cantEquipos];
		for(int k=0;k<vectorPuntaje.length;k++)vectorPuntaje[k]=0;//Inicializo vector
		System.out.println("Cantidad de equipos: "+cantEquipos);
		System.out.println("Cantidad de preguntas: "+cantPreguntas);
		int maximoCombinaciones=0;
		int equiposParticipantes=0;
		
		for(i=0;i<cantEquipos;i++) {
			for(j=i;j<cantEquipos;j++) {
				if(respuestas[i][0]==respuestas[j][i]);
			}
		}
		
	}
	
	
	
	public void escribirArchivo() {
		PrintWriter p = null;
		try {
			p = new PrintWriter(new FileWriter(pathOut));
		} catch (IOException e) {
			System.out.println("Problema al leer el archivo "+pathOut);
			e.printStackTrace();
		}
	}
}
