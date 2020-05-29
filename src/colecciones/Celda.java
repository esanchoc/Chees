package colecciones;

import fichas.Ficha;

/**
 * Esta clase nos permite alamcena Fichas dentro de la propia clase tablero.
 * 
 * @author Enrique Vte. Sancho Caballer
 * @version 1.0
 */

public class Celda {

	private Ficha f;
	
	/**
	 * Contructor por defecto de la clase Celda.
	 */

	public Celda() {
		this.f = null;
	}
	
	/**
	 * Constructor de la clase Celda
	 * @param f Nos indica la Ficha que vamos a asignar a la propia celda.
	 */

	public Celda(Ficha f) {
		this.f = f;
	}
	
	/**
	 * Método que nos asigna una Ficha dentro de una Celda.
	 * @param f Nos indica la Ficha que vamos a asignar a la propia Celda.
	 */

	public void setFicha(Ficha f) {
		this.f = f;
	}
	
	/**
	 * Método que nos indica si esa Celda contiene una Ficha o no.
	 * @return Nos devuelve True o False dependiendo si hay una Ficha o no.
	 */

	public boolean hayFicha() {
		if (f == null)
			return false;
		else
			return true;
	}
	
	/**
	 * Método que nos devuelve la Ficha de la propia Celda.
	 * @return Nos devuelve una Ficha almacenada en la propia Celda.
	 */

	public Ficha getFicha() {
		return f;
	}
	
	/**
	 * @Override Método sobreescrito para modificar la visualización del contenido de la Celda.
	 * Método que nos permitre imprimir el contenido de la Celda.
	 * @return Nos devuelve la Forma de la Ficha si hay una Ficha, en su defecto nos devuelve un String con un espacio.
	 */

	public String toString() {
		String salida = "";

		if (hayFicha())
			return salida += f.toString();
		else
			return salida += " ";
	}
}
