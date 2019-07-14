import java.util.ArrayList;

public class Torneo {
	ArrayList<Luchador> luchadores= new ArrayList<Luchador>();

	public Torneo(ArrayList<Luchador> luchadores) {
		this.luchadores = luchadores;
	}
	
	public Torneo() {
		this.luchadores = null;
	}

	public ArrayList<Luchador> getLuchadores() {
		return this.luchadores;
	}

	public void setLuchadores(ArrayList<Luchador> luchadores) {
		this.luchadores = luchadores;
	}
	
	public void resolver() {
		int[]  dominados;
		dominados = new int[luchadores.size()];
		int i,j;
		
		for(i=0;i<luchadores.size();i++) {
			for(j=0;j<luchadores.size();j++) {
				if((luchadores.get(i).domina(luchadores.get(j))) == true) {
					dominados[i]+=1;
				}
			}
		}
		
	}
	
}
