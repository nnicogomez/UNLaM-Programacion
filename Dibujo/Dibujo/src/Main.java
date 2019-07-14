
public class Main {

	public static void main(String[] args) {
		Dibujo dibujo = new Dibujo(4);
		Figura fig[] = new Figura[4];
		
		fig[0]= new Cuadrado("azul", 2);//area 4
		fig[1]= new Cuadrado("rojo", 4);// area 16
		fig[2]= new Circulo("verde",1);// area 4.14
		fig[3]= new Circulo("amarillo", 5);// area 28.14
		dibujo.setFiguras(fig);//total 46
		
		
		if(fig[3].equals(fig[2])) {
			System.out.println("La figura 3 y 4 son iguales");
		}
		else {
			System.out.println("La figura 3 y 4 no son iguales");	
		}
		dibujo.calcularPomos();
		int cant= dibujo.getCantidadPomos();
		
		System.out.println("Cantidad de pomos: " + cant);
	}
}
