public class Circulo extends Figura{
	private double radio;
	private double superficie;
	
	public Circulo(String color, int r){
		super(color);//Si no estuviese el super, dejaria la variable Cantidad de lados, osea la variable que inicializa el constructor del padre, vacia
		//no va a dar error, pero no la va a iniciar.
		this.radio=r;
		this.superficie=Math.PI + radio*radio;
	}
	
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	@SuppressWarnings("unused")
	@Override
	public double calcularArea(){
		this.setSuperficie(Math.PI + radio*radio);
		return this.superficie;
	}

	@Override
	public double getArea() {
		return superficie;
	}

	@Override
	public char getID() {
		// TODO Auto-generated method stub
		return 'r';
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
