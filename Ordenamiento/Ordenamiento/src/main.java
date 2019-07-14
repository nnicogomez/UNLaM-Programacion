public class main {

	public static void main(String[] args) {
		
		System.out.println("SELECCION");
		Arreglo array = new Arreglo(6);
		array.agregar(9);
		array.agregar(19);
		array.agregar(6);
		array.agregar(5);
		array.agregar(0);
		array.agregar(8);
		array.seleccion();
		array.mostrarVector();
		
		System.out.println("BURBUJEO");
		Arreglo array2 = new Arreglo(6);
		array2.agregar(9);
		array2.agregar(19);
		array2.agregar(6);
		array2.agregar(5);
		array2.agregar(0);
		array2.agregar(8);
		array2.burbujeo();
		array2.mostrarVector();
		
		System.out.println("INSERCION");
		Arreglo array3 = new Arreglo(6);
		array3.agregar(19);
		array3.agregar(19);
		array3.agregar(65);
		array3.agregar(15);
		array3.agregar(0);
		array3.agregar(8);
		array3.insercion();
		array3.mostrarVector();
		
		System.out.println("SHELL");
		Arreglo array4 = new Arreglo(6);
		array4.agregar(93);
		array4.agregar(19);
		array4.agregar(6);
		array4.agregar(53);
		array4.agregar(0);
		array4.agregar(85);
		array4.shell();
		array4.mostrarVector();
		
		System.out.println("QUICKSORT");
		Arreglo array5 = new Arreglo(6);
		array5.agregar(93);
		array5.agregar(19);
		array5.agregar(62);
		array5.agregar(532);
		array5.agregar(022);
		array5.agregar(8352);
		array5.quicksort(0, 5);
		array5.mostrarVector();
		}
	
	

	}
