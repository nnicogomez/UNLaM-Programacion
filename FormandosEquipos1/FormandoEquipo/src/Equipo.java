import java.util.ArrayList;
import java.util.HashMap;

public class Equipo {

	private int preguntas;
	private int participantes;
	private ArrayList<String> respuestas;
	
	public Equipo(int p, int p2, ArrayList<String> a) {
		this.participantes=p;
		this.preguntas=p2;
		this.respuestas=a;
		this.mostrarLista();
	}
	
	private void mostrarLista() {
		System.out.println(this.respuestas.toString());
	}
	
	private void calcularMayorAfinidad() {
		HashMap<String,Integer> repeticiones = new HashMap<String,Integer>();
		boolean añadido=false;
		boolean sumar=true;
		repeticiones.put(respuestas.get(0).substring(0, 1),1);
		System.out.println("Estoy poniendo en el mapa la key "+respuestas.get(0).substring(0,1)+" con valor 1");
		
		//_________________
		for (int i = 0; i < this.preguntas; i++) {
			for (int j = 0; j < this.participantes; j++) {				
				for (String p:repeticiones.keySet())
					if (p.equals(respuestas.get(j).substring(0,i+1))) {
						if(sumar==false) {
							repeticiones.put(p,repeticiones.get(p)+1);
							System.out.println("Sumando uno a la key "+p+". Ahora el valor es "+repeticiones.get(p));
						}
						sumar=false;
						añadido=true;
					}
					else añadido=false;
				if (añadido==false && repeticiones.containsKey(respuestas.get(j).substring(0, i + 1))==false) {
					System.out.println("Estoy poniendo en el mapa la key "+respuestas.get(j).substring(0, i + 1)+" con valor 1");
					repeticiones.put(respuestas.get(j).substring(0, i + 1),1);
				}
			}
			añadido=false;
		}
		//______________________
		double afinidadMaxima=0, afinidad=0;
		String claveMax=new String();
		for (String p:repeticiones.keySet()) {
				afinidad=repeticiones.get(p)* Math.pow(p.length() ,2 );
			if (afinidad>afinidadMaxima) {
				claveMax=p;
				afinidadMaxima = afinidad;
			}
		}
		Salida s=new Salida("equipo.out",claveMax,afinidadMaxima);
		System.out.println(s.guardarArchivo());
	}
	
	public static void main(String[] args) {
		Entrada e = new Entrada("equipo.in");
		Equipo eq = new Equipo(e.getParticipantes(),e.getPreguntas(),e.getLista());
		eq.calcularMayorAfinidad();
	}
}
