
public class Luchador {
	//NO USAR VARIABLES GLOBALES
	public Double peso;
	public Double altura;
	
	
	public Luchador(Double peso, Double altura) {
		this.peso = peso;
		this.altura = altura;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public Double getAltura() {
		return altura;
	}


	public void setAltura(Double altura) {
		this.altura = altura;
	}
	
	public boolean domina(Luchador l) {
		if(this.altura > l.altura && this.peso > l.peso)
			return true;
		if(this.altura > l.altura && this.peso == l.peso)
			return true;
		if(this.altura == l.altura && this.peso > l.peso)
			return true;
		
		return false;
	}


	@Override
	public String toString() {
		return "Luchador [peso=" + peso + ", altura=" + altura + "]";
	}
	
}
