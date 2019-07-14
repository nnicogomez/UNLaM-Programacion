import java.util.ArrayList;

public class Autobus extends Vehiculo{

	@SuppressWarnings("unused")
	private int cantPasajeros;
	ArrayList<Persona> personas = new ArrayList<Persona>();
	//Para agregar personas -> personas.add(pepe)
	//para saber si la lista esta vacia -> personas.isempty);
	
	public Autobus(Persona chofer, double km, ArrayList<Persona> pers) {
		super(chofer,km);
		//personas.add(pers.indexOf(o)))
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	private int cantidadPasajeros;
	
	@Override
	public void agregarPasajero(Persona pasaj) {
			this.personas.add(pasaj);
		}
		// TODO Auto-generated method stub

	@Override
	public void cambiarChofer(Persona nuevoChofer) {
		// TODO Auto-generated method stub
		if(personas.isEmpty()) {
			this.chofer=nuevoChofer;
		}else {
				System.out.println("El autobos tiene al menos un acompañante");
			}
		}

	@Override
	public void asignarChofer(Persona cho) {
		// TODO Auto-generated method stub
		if(chofer==null) {
			this.chofer=cho;
		}else {
				System.out.println("El autobos tiene chofer");
			}
	}
}
