
public class Motocicleta extends Vehiculo{
	
	@SuppressWarnings("unused")
	private Persona acompa�ante;

	public Motocicleta(Persona chof, double km, Persona per) {
		super(chof,km);
		acompa�ante=per;
		// TODO Auto-generated constructor stub
	}
	
	public Motocicleta(Persona chof) {
		super(chof);
		acompa�ante= null;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void agregarPasajero(Persona pasajero) {
		if(this.acompa�ante!=null) {
			this.acompa�ante=pasajero;
		}else {
				System.out.println("La motocicleta con chofer "+this.chofer.getNombre() +"ya posee acompa�ante");
			}
		}
		// TODO Auto-generated method stub

	@Override
	public void cambiarChofer(Persona nuevoChofer) {
		// TODO Auto-generated method stub
		if(this.acompa�ante==null) {
			this.chofer=nuevoChofer;
		}else {
				System.out.println("La motocicleta tiene acompa�ante");
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
