import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Salida {
	private String ganador;
	private double afinidad;
	private String path;
	
	public Salida(String p, String ganador, double afinidad) {
		this.ganador= new String(ganador);
		this.afinidad=afinidad;
		this.path=new String(p);
	}
	public String guardarArchivo() {
		PrintWriter pw=null;
		try {
			pw = new PrintWriter(new FileWriter(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println("Ganador: "+ganador);
		pw.println("Afinidad: "+afinidad);
		pw.close();
		return new String("El ganador fue *"+ganador+"* con "+afinidad+" puntos de afinidad");
	}
	
	
}
