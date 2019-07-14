package Interfaces;

public interface Pila {
	//push( dato ) //apila un dato en el tope de la pila
	//pop( )//desapila el dato apuntado por el tope de la pila
	//peek( )//devuelve el dato apuntado por el tope de la pila, pero no lo desapila.
	//isEmpty( )// verificar si la pila esta o no vac ́ıa.
	//empty( ) //vaciar la pila
	public int tam=0;
	
	public void push(int d);
	public int pop();
	public int peek();
	public boolean isEmpty();
	public void empty();
}
