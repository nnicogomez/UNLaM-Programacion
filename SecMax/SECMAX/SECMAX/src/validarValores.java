import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class validarValores {

		public static void main(String[] args)	throws IOException {
			
			String miPath = "C:\\Users\\nicol\\Desktop\\Clase2 PA\\SECMAX\\SECMAX\\src\\"; 
			Scanner archivo = new Scanner(new File(miPath+"SECMAX.in"));
			archivo.useLocale(Locale.ENGLISH);
			int [] vec = new int[archivo.nextInt()];
			
			for (int i = 0; i < vec.length ; i++) {
				vec[i] =archivo.nextInt();
				System.out.println( "Numeros iniciales " + vec[i]);
			}
			
			archivo.close();
			
		//VALIDAR LOS VALORES Y GUARDAR EN VECTOR	
			int [] vectorsalida = new int[vec.length];
			for (int i = 0; i < vec.length ; i++) {
				if(vec[i]%2!=0 && vec[i]%3!=0 && vec[i]%5!=0){
					vectorsalida[i]=vec[i];
				}
				System.out.println( "Numeros a guardar en vector 2 " + vec[i]);
			}
			
			
			miPath = "C:\\Users\\nicol\\Desktop\\Clase2 PA\\SECMAX\\SECMAX\\src\\";
			PrintWriter salida = new PrintWriter(new FileWriter(miPath+"SECMAX.out"));
			salida.println("Numeros: \n");
			for (int i = 0; i < vec.length ; i++) {
				if(vectorsalida[i]!=0){
					salida.println(vectorsalida[i]);
					salida.println("\n");
				}				
				System.out.println( "Numeros FINALES " + vectorsalida[i]);
			} 
			salida.close(); 

		}

}
