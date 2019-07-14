import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// esto es un ejemplo minimo para  grabar sus datos en un archivo  de texto
public class escribirArchivo {

	public static void main(String[] args)	throws IOException {
		
		String miPath = "C:/Users/laboratorios/Desktop/workspace/LeerEscribirArchivos/src/";
		
		PrintWriter salida = new PrintWriter(new FileWriter(miPath+"salida.out"));  //  preparo el arch de salida Abre el archivo y permite escribirle
	     //Si el archivo no existe, lo crea.
		
	    int z=50;
	    String s="dni:";
	    salida.print(s);      
		salida.println(" "+z); 
		salida.close(); //esto escribe : dni: 50

	}

}

