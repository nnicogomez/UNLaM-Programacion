package Redencion;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CirculosConcentricos_cap1 {
	private int[][] circulos;
	private long vampiro;
	
	public CirculosConcentricos_cap1() {
		circulos = new int[6][10];
		vampiro = 0;
	}
	
	public void leerCirculos(String p) {
		Scanner sc=null;
		try {
			sc = new Scanner ( new File(p));
		} catch (FileNotFoundException e) {
			System.out.println("error al leer el archivo");
			e.printStackTrace();
		}
		sc.useLocale(Locale.ENGLISH);
		int aux =0;
		for(int i=0;i<6;i++) {
			for(int j=0;j<10;j++) {
				aux = sc.nextInt();
				if(aux<=9 && aux>=0)circulos[i][j]=aux;
				else {
					System.out.println("Matriz invalida");
					break;
				}
			}
		}	
		System.out.println("Si pasamos los circulos a matriz nos queda...");
		for(int i=0;i<6;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(" "+circulos[i][j]);
			}
			System.out.println("");
		}
	sc.close();
	}

	public String buscarVampiros() {
		Integer[] num1 = new Integer[3];
		Integer[] num2 = new Integer[3];
		for(int i=0; i< 10;i++) {
			num1[0] = new Integer(circulos[0][i]);
			for(int j=0; j< 10;j++) {
				num1[1] = new Integer(circulos[1][j]);
				for(int k=0; k< 10;k++) {
					num1[2] = new Integer(circulos[2][k]);
					for(int l=0; l< 10;l++) {
						num2[0] = new Integer(circulos[3][l]);
						for(int m=0; m< 10;m++) {
							num2[1] = new Integer(circulos[4][m]);
							for(int n=0; n< 10;n++) {
								num2[2] = new Integer(circulos[5][n]);
								Integer potencialVampiro = new Integer(Integer.valueOf(new String(new String (Integer.toString(num1[0]))+new String (Integer.toString(num1[1]))+new String (Integer.toString(num1[2])))+new String(new String (Integer.toString(num2[0]))+new String (Integer.toString(num2[1]))+new String (Integer.toString(num2[2])))));
						            for(long colmillo1 = 2; colmillo1 <= Math.sqrt(potencialVampiro) + 1; colmillo1++)
						                if(potencialVampiro % colmillo1 == 0){
						                    long colmillo2 = potencialVampiro / colmillo1;
						                    if(Vampiro.buscarVampiro(potencialVampiro, colmillo1, colmillo2) && colmillo1 <= colmillo2)
						                    	if((i+j+k+l+m+n)<=10)return new String("Vampiro "+ potencialVampiro + ".\nColmillos " + colmillo1 + ", " + colmillo2 + ".\nLas posiciones donde se encontraron los numeros: "+(i+1)+", "+(j+1)+", "+(k+1)+", "+(l+1)+", "+(m+1)+", "+(n+1));this.vampiro=potencialVampiro;
						                }
							}
						}
					}
				}
			}
		}
		return "No hay vampiros";
	}

	public int[][] getCirculos() {
		return circulos;
	}

	public void setCirculos(int[][] circulos) {
		this.circulos = circulos;
	}

	public long getVampiro() {
		return vampiro;
	}

	public void setVampiro(long vampiro) {
		this.vampiro = vampiro;
	}
	
}
