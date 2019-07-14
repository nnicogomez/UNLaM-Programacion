
public abstract class Vehiculo {
	protected Persona chofer;
	protected double kilometros;
	
	public Vehiculo(Persona per, double km) {
		chofer=per;
		kilometros=km;
	}
	
	public Vehiculo() {
		chofer=null;
		kilometros=0;
	}
	
	public Vehiculo(Persona per) {
		chofer=per;
		kilometros=0;
	}
	
	public abstract void agregarPasajero(Persona pasajero);
	public abstract void cambiarChofer(Persona nuevoChofer);
	public abstract void asignarChofer(Persona chofer);
	
}
