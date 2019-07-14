import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona per1= new Persona("nicolas");
				System.out.println("la persona creada se llama "+ per1.getNombre());
		Persona per2= new Persona("alan");
				System.out.println("la persona creada se llama "+ per2.getNombre());
		Persona per3= new Persona("matias");
				System.out.println("la persona creada se llama "+ per3.getNombre());
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		personas.add(per1);
		personas.add(per2);
		personas.add(per3);
		
		Autobus bondi= new Autobus(per1, 0, personas);
		Motocicleta moto= new Motocicleta(per2, 5, per3);
		
		System.out.println("El chofer del autobus creado es "+bondi.chofer.getNombre());
		System.out.println("El chofer de la moto creada es "+moto.chofer.getNombre());
		
		moto.cambiarChofer(per3);
	}

}
