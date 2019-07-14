import java.io.IOException;
import Redencion.*;

public class Acertijos {

	public static void main(String[] args) throws IOException {
		System.out.println("***Inicio del capitulo 1***");
		CirculosConcentricos_cap1 enigma = new CirculosConcentricos_cap1();
		enigma.leerCirculos("CirculosConcentricos.in");
		System.out.println(enigma.buscarVampiros());
		System.out.println("***Fin del capitulo 1***");
		System.out.println("\n\n");
		System.out.println("***Inicio del capitulo 2***");
		//SerieNumerica_cap2.inicioSerie(enigma.getVampiro());
		SerieNumerica_cap2.fibonacciCola(enigma.getVampiro());
	}

}
