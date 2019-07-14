public class Cuadrado extends Figura{
	
	private double lado;
	private double area;
	
	public Cuadrado(String color, double l){
		super(color);//SIEMPRE LA PRIMER LINEA TIENEQUE SER LA INVOCACION AL PADRE.+++_
		this.lado=l;
		this.area=this.lado*this.lado;
	}
	
	public double getLado() {
		return lado;
	}
	public void setLado(double lado) {
		this.lado = lado;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	@SuppressWarnings("unused")
	@Override
	
	public double calcularArea(){
		this.setArea(this.lado*this.lado);
		return this.area;
	}

	@Override
	public char getID() {
		return 'c';
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
