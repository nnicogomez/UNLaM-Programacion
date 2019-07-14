public class Dibujo{
	private int cantidadDeFiguras;
	private Figura[] figuras;
	private int cantidadPomos;
	private int cantActual;
	
	static private double pomoPorSuperficie=5;
	
	public Dibujo (int cantFig){
		this.cantidadDeFiguras=cantFig;
		this.cantActual=0;
	}
	
	@SuppressWarnings("unused")
	private void añadirFiguraADibujo(Figura fig) {
		figuras[cantActual] = fig;//como definir el tamaño del vector??
		cantActual++;
	}
	
	public void calcularPomos() {
		int i;
		double sumaPintura=0;
		for(i=0;i<figuras.length;i++) {
			System.out.println("Llegue. Figura con lado: " + this.figuras[i].getID() + this.figuras[i].calcularArea());
			sumaPintura = this.figuras[i].calcularArea();
		}
		
		int cantPomos = (int) Math.ceil(sumaPintura/Dibujo.pomoPorSuperficie);
		this.cantidadPomos=cantPomos;
	}
	
	public void pintarFigura(Figura fig, String color) {
		System.out.println("La figura se pinto de color"+color);
	}
	
	public int getCantidadPomos() {
		return cantidadPomos;
	}
	public void setCantidadPomos(int cantidadPomos) {
		this.cantidadPomos = cantidadPomos;
	}
	public int getCantidadDeFiguras() {
		return cantidadDeFiguras;
	}
	public void setCantidadDeFiguras(int cantidadDeFiguras) {
		this.cantidadDeFiguras = cantidadDeFiguras;
	}
	public Figura[] getFiguras() {
		return figuras;
	}
	public void setFiguras(Figura[] figuras) {
		this.figuras = figuras;
	}

}
