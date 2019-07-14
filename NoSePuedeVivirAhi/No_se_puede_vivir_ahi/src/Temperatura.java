
public class Temperatura {
	private int maximo;
	private int minimo;
	
	public int getMaximo() {
		return maximo;
	}
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	public int getMinimo() {
		return minimo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	@Override
	public String toString() {
		return "Temperatura [maximo=" + maximo + ", minimo=" + minimo + "]";
	}
	
}
