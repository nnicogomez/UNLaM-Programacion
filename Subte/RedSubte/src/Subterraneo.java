import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Subterraneo {
	private int origen;
	private int destino;
	private int estaciones;
	private int redes;
	private int[] redSubterranea;
	private Queue<Integer> lineasATomar;
	
	public Subterraneo(int o, int d, int e, int r, int[] red) {
		this.origen=o;
		this.destino=d;
		this.estaciones=e;
		this.redes=r;
		this.redSubterranea=red;
		this.lineasATomar=new LinkedList<Integer>();
	}
	
	private void mostrarDatos() {
		System.out.println("\nOrigen: "+origen);
		System.out.println("Destino: "+destino);
		System.out.println("Cantidad de estaciones: "+estaciones+". Cantidad de redes: "+redes);
		System.out.println("________________________________________________________________");
	}
	public void combinaciones() {
		mostrarDatos();
		int i,j,k;
		Queue<Integer> estOr = new LinkedList<Integer>();
		Queue<Integer> estDest = new LinkedList<Integer>();
		
		for(i=origen;i<redSubterranea.length;i=i+estaciones+1) {
			System.out.println("Mirando si en "+i+" hay un "+origen);
			if(redSubterranea[i]==1) {
				estOr.add(i);
				System.out.println("Encontre un "+origen);
				System.out.println("Acolando la posicion "+i);
				}
		}
		for(i=destino;i<redSubterranea.length;i=i+estaciones+1) {
			System.out.println("Mirando si en "+i+" hay un "+destino);
			if(redSubterranea[i]==1) {
				estDest.add(i);
				System.out.println("Encontre un "+destino);
				System.out.println("Acolando la posicion "+i);
			}
		}
		int actual=0,limInf=0,limSup=estaciones+1;
		boolean band=false;
		while(estOr.isEmpty()==false && band==false) {
			limSup=estaciones+1;
			actual=estOr.poll();
			while(actual>limSup && limSup<=redSubterranea.length)limSup+=estaciones+1;
			limInf=limSup-estaciones-1;
			System.out.println("Si la posicion desacolada es "+actual+". El valor del limite superior es "+limSup+". El limite inferior es "+limInf);
			System.out.println("_________________________________________");
			if(redSubterranea[limInf+destino]==1) {
				System.out.println("Encontre al destino en la misma linea.");
				int aux=(limInf+1)/estaciones+1;
				lineasATomar.add(aux);
				System.out.println("La linea a tomar es la numero "+aux);
				band=true;
			}
			else {
				int camada=estDest.size(),cont=0;
				int limSupDest=0,limInfDest=0,actualDest=0;
				while(cont<camada) {
					actualDest=estDest.poll();
					estDest.add(actualDest);
					System.out.println("La cantidad de posiciones destino acoladas es "+camada);
					System.out.println("Cont es "+cont);
					while(actualDest>limSupDest && limSupDest<=redSubterranea.length)limSupDest+=estaciones+1;
					limInfDest=limSupDest-estaciones-1;
					System.out.println("Si la posicion desacolada es "+actualDest+". El valor del limite superior es "+limSupDest+". El limite inferior es "+limInfDest);
					System.out.println("_________________________________________");
					int c1=limInf,c2=limInfDest;
					while(c1<limSup && band==false) {
						if(redSubterranea[c1]==redSubterranea[c2] && redSubterranea[c1]==1 && redSubterranea[c2]==1) {
							band=true;
							System.out.println("El destino y el origen tienen una estacion en comun.");
							int aux1=(limInf+1)/estaciones+1;
							int aux2=(limInfDest+1)/estaciones+1;
							lineasATomar.add(aux1);
							lineasATomar.add(aux2);
							System.out.println("Las lineas a tomar son "+aux1+" y "+aux2);
							band=true;
						}
						c1++;
						c2++;
						cont++;
					}
				}
				if(band==false) {
					actualDest=estDest.poll();
					System.out.println("No se que hacer");
				}
			}
			
			
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Entrada e = new Entrada("red.in");
		Subterraneo s = new Subterraneo(e.getOrigen(),e.getDestino(),e.getEstaciones(),e.getRedes(),e.getRedSubterranea());
		s.combinaciones();
	}
	
}
