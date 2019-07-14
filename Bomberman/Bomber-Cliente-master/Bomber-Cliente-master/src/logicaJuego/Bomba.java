package logicaJuego;

import java.io.Serializable;

public class Bomba extends Entidad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rango;
	private int tiempoDeEjecucion;
	private boolean explotada;

	public Bomba(int x, int y) {
		super(x, y);
		this.rango = 3;
		this.tiempoDeEjecucion = 3;
		this.explotada=false;
	}

		public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public int getTiempoDeEjecucion() {
		return tiempoDeEjecucion;
	}

	public void setTiempoDeEjecucion(int tiempoDeEjecucion) {
		this.tiempoDeEjecucion = tiempoDeEjecucion;
	}

	@Override
	public String toString() {
		return "Bomba";
	}

	@Override
	public boolean esBloque() {
		return false;
	}

	@Override
	public boolean esBomberman() {
		return false;
	}

	@Override
	public boolean esBomba() {
		return true;
	}
	
	public boolean isExplotada() {
		return explotada;
	}

	public void setExplotada(boolean explotada) {
		this.explotada = explotada;
	}
}