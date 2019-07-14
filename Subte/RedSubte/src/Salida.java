import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Salida {
	private String path;
	
	public Salida(String p) {
		path = new String(p);
	}
	public String grabarArchivo(ArrayList<Integer> s) {
		PrintWriter p=null;
		try {
			p = new PrintWriter(new FileWriter(path));
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
			e.printStackTrace();
		}
		p.println(s.size());
		for(int i = 0;i<s.size();i++) {
			p.println(" "+s.get(i));
		}
		return new String("La combinacion que se debe realizar es"+s.toString());
	}
}
