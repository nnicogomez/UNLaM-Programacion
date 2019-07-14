
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {4,35,23,42,6};
		int t=10;//A lo sumo ese numero
		int k=3;//Cantidad de veces	
		
		Ejercicio1 ej = new Ejercicio1();
		
		if(ej.calcularSubconjunto(n, t, k)==true) {
			System.out.println("OK");
			}
			else {
				System.out.println("no ok");
			}
		
	}

}
