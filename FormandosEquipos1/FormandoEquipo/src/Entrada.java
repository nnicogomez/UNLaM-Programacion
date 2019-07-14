import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Entrada {
	private int participantes;
	private int preguntas;
	private ArrayList<String> lista;
	
	public Entrada(String path) {
		lista = new ArrayList<String>();
		Scanner sc=null;
		try {
			sc = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el archivo ");
		}
		sc.useLocale(Locale.ENGLISH);
		this.preguntas=sc.nextInt();System.out.println("Preguntas: "+preguntas);
		this.participantes=sc.nextInt();System.out.println("participanteS: "+participantes);
		for(int i=0;i<participantes;i++)lista.add(sc.next());
		sc.close();
	}

	public int getParticipantes() {
		return participantes;
	}

	public void setParticipantes(int participantes) {
		this.participantes = participantes;
	}

	public int getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(int preguntas) {
		this.preguntas = preguntas;
	}

	public ArrayList<String> getLista() {
		return lista;
	}

	public void setLista(ArrayList<String> lista) {
		this.lista = lista;
	}
	
	
}
