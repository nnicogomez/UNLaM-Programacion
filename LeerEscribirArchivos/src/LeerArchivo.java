import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Locale;

public class LeerArchivo
{

	public static void main(String[] args) throws FileNotFoundException {
	
		String miPath = "C:/Users/laboratorios/Desktop/workspace/LeerEscribirArchivos/src/"; 
		Scanner sc = new Scanner(new File(miPath+"datos.in"));
		sc.useLocale(Locale.ENGLISH);
		double [] vec = new double[sc.nextInt()]; //crea un vector de capacidad igual al proximo int que levanta
		// vector para almacenar la lectura
		
		for (int i = 0; i < vec.length ; i++) {
			vec[i] =sc.nextInt(); //como sabe que empieza el otro numero? Todos los caracteres de separacion los reconoce.
			System.out.println( vec[i]);
		}
		
		sc.close();//Cierra el archivo
	}

}

