package logicaJuego;

import java.io.Serializable;
import javax.swing.ImageIcon;


import logicaJuego.Entidad;


public class Bomberman extends Entidad implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private ImageIcon bomberman;
	
	private boolean vivo;
	private double velocidad;
	private int puntos;
	private int cantMuertes;
	private int cantBombasMax;
	private int cantBombas;
	private int posX;
	private int posY;
	private float posGrafX;
	private float posGrafY;
	private int contMovimientos;

	private double velX;
	private double velY;

	private int rango;
	private boolean buffoBomba;
	private boolean buffoVelocidad;
	private boolean buffoRango;
	private String nombre;
	private int puntaje;

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public Bomberman(int x, int y, String nombre) {
		super(x, y);
		this.vivo = true;
		this.velocidad = 2;
		this.puntos = 0;
		this.cantMuertes = 0;
		this.cantBombas = 1;
		this.cantBombasMax= 1;
		this.posX = x;
		this.posY = y;
		this.posGrafX = 40 * x;
		this.posGrafY = 40 * y;
		this.contMovimientos = 0;

		this.rango=1;
		buffoBomba=false;
		buffoVelocidad=false;
		buffoRango=false;
		this.nombre=nombre;
		this.puntaje=0;
		
		bomberman = new ImageIcon("./src/imagenes/1-down.png");
	}

	public void actualizacionGrafica(Mapa test) {
		
			
	}

	public ImageIcon move(String dir) {
		return null;
	}

	public void moverse(Moverse mov, Mapa mapa) {

	}



	public void muere(Mapa mapa) {
	
	}

	public void revivir(Mapa mapa) {

	}

	public Bomba ponerBomba(Mapa mapa) {
		return null;
	}

	public float getPosGrafX() {
		return posGrafX;
	}

	public void setPosGrafX(float posGrafX) {
		this.posGrafX = posGrafX;
	}

	public float getPosGrafY() {
		return posGrafY;
	}

	public void setPosGrafY(float posGrafY) {
		this.posGrafY = posGrafY;
	}

	public boolean isVivo() {
		return vivo;
	}

	@Override
	public String toString() {
		return "Bomberman";
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getCantMuertes() {
		return cantMuertes;
	}

	public void setCantMuertes(int cantMuertes) {
		this.cantMuertes = cantMuertes;
	}

	public int getCantBombas() {
		return cantBombas;
	}
	public void setCantBombas(int cantBombas) {
		this.cantBombas = cantBombas;
	}

	public void incrementarUnaBomba() {
		this.cantBombas +=1;
	}
	public void decrementarUnaBomba() {
		this.cantBombas -=1;
	}

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	@Override
	public boolean esBloque() {
		return false;
	}

	@Override
	public boolean esBomberman() {
		return true;
	}

	@Override
	public boolean esBomba() {
		return false;
	}

	public int getContMovimientos() {
		return contMovimientos;
	}

	public void setContMovimientos(int contMovimientos) {
		this.contMovimientos = contMovimientos;
	}

	public ImageIcon getBomberman() {
		return bomberman;
	}

	public void setBomberman(ImageIcon bomberman) {
		this.bomberman = bomberman;
	}

	public boolean isBuffoBomba() {
		return buffoBomba;
	}

	public void setBuffoBomba(boolean buffoBomba) {
		this.buffoBomba = buffoBomba;
	}

	public boolean isBuffoVelocidad() {
		return buffoVelocidad;
	}

	public void setBuffoVelocidad(boolean buffoVelocidad) {
		this.buffoVelocidad = buffoVelocidad;
	}

	public boolean isBuffoRango() {
		return buffoRango;
	}

	public void setBuffoRango(boolean buffoRango) {
		this.buffoRango = buffoRango;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantBombasMax() {
		return cantBombasMax;
	}

	public void setCantBombasMax(int cantBombasMax) {
		this.cantBombasMax = cantBombasMax;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje() {
		this.puntaje +=1;
	}

	
	
}
