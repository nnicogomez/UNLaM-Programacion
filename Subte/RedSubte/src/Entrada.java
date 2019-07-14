import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Entrada {
	private int redes;
	private int estaciones;
	private int[] redSubterranea;
	private int origen;
	private int destino;
	private String path;
	
	public Entrada(String p) {
		path = new String(p);
		int j=0;
		Scanner sc=null;
		try {
			sc = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			System.out.println("Error en la lectura del archivo");			
			e.printStackTrace();
		}
		sc.useLocale(Locale.ENGLISH);
		this.redes=sc.nextInt();
		this.estaciones=sc.nextInt();
		redSubterranea=new int[(redes*estaciones)+redes];
		inicializarVector(estaciones);
		for(int i=0;i<this.redes;i++) {
			int aux2=sc.nextInt();
			for(j=0;j<aux2;j++) {
				int aux = sc.nextInt();
				redSubterranea[(i+aux+estaciones*(i))]=1;
			}
		}
		this.origen=sc.nextInt();
		System.out.println("Origen "+origen);
		this.destino=sc.nextInt();
		System.out.println("Destino "+destino);
		mostrarVector();
	}
	
	private void inicializarVector(int est) {
		for(int i=0;i<redSubterranea.length;i++)
			redSubterranea[i]=0;
		redSubterranea[0]=-1;
		int j=0;
		for(j=est+1;j<redSubterranea.length;j+=est+1)redSubterranea[j]=-1;
	}

	public int getRedes() {
		return redes;
	}

	public void setRedes(int redes) {
		this.redes = redes;
	}

	public int getEstaciones() {
		return estaciones;
	}
	
	private void mostrarVector() {
		System.out.println("Tamaño de vector "+redSubterranea.length);
		for(int i=0;i<redSubterranea.length;i++)
			System.out.print(" "+redSubterranea[i]);
	}
	

	public void setEstaciones(int estaciones) {
		this.estaciones = estaciones;
	}

	public int[] getRedSubterranea() {
		return redSubterranea;
	}

	public void setRedSubterranea(int[] redSubterranea) {
		this.redSubterranea = redSubterranea;
	}

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
