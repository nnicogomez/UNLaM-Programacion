
public class Motocicleta extends Vehiculo{
	
	@SuppressWarnings("unused")
	private Persona acompañante;

	public Motocicleta(Persona chof, double km, Persona per) {
		super(chof,km);
		acompañante=per;
		// TODO Auto-generated constructor stub
	}
	
	public Motocicleta(Persona chof) {
		super(chof);
		acompañante= null;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void agregarPasajero(Persona pasajero) {
		if(this.acompañante!=null) {
			this.acompañante=pasajero;
		}else {
				System.out.println("La motocicleta con chofer "+this.chofer.getNombre() +"ya posee acompañante");
			}
		}
		// TODO Auto-generated method stub

	@Override
	public void cambiarChofer(Persona nuevoChofer) {
		// TODO Auto-generated method stub
		if(this.acompañante==null) {
			this.chofer=nuevoChofer;
		}else {
				System.out.println("La motocicleta tiene acompañante");
			}
		}

	@Override
	public void asignarChofer(Persona chofer) {
		if(this.chofer==null) {
			this.chofer=chofer;
		} else {
				System.out.println("Ya posee chofer");
			}
		}
		// TODO Auto-generated method stub
	}
