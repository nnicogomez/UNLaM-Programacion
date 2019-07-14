package Interfaces;

public interface Cola {
	/*offer(dato) // acola un dato en la cola.
	poll() // desacola el dato de la cola.
	peek() // devuelva el dato pr ́oximo a desacolarse, pero no lo desacola.
	isEmpty( )// verificar si la cola esta o no vac ́ıa.
	empty( )//vaciar la cola*/
	public int tam =0;
	
	public void offer(int d);
	public int poll();
	public int peek();
	public boolean isEmpty();
	public void empty();
}
