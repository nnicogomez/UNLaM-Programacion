package hilosDelJuego;


import interfazDelJuego.JPanelGrafico;
import interfazDelJuego.JVentanaGrafica;

public class Repintar extends Thread {
	private int fps;
	private JVentanaGrafica pane;
	private JPanelGrafico ventana;
	private boolean flag;

	public Repintar(JVentanaGrafica panel, JPanelGrafico contentPane) {
		this.pane = panel;
		ventana = contentPane;
		fps=0;
		flag=true;
	}

	public void run() {
		long timer=System.currentTimeMillis();
       
        while (flag==true) {

                fps++;
                if(System.currentTimeMillis()-timer >=1000) {
                    pane.setTitle("Bomberman || fps: "+fps + " || Players: " + ventana.getPlayers().size());
                    timer=System.currentTimeMillis();
                    fps=0;
                }
                
                this.pane.repaint();
                
                try {
                    Thread.sleep(14);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

	public void finalizarHilo() {
		flag=false;
	}

	
}
