package fichas;

/**
 * Esta clase define el objeto Coordenada, el cual nos ayuda a la colocación del
 * objeto Ficha dentro de la clase Tablero.
 * 
 * @author Enrique Vte. Sancho Caballer
 * @version 1.0
 */
public class Coordenada {

	private int fila;
	private int col;

	/**
	 * Constructor de la clase Coordenada.
	 * 
	 * @param fila Nos índica la fila de la Coordenada.
	 * @param col  Nos índica la columna de la Coordenada
	 */

	public Coordenada(int fila, int col) {
		this.fila = fila;
		this.col = col;
	}

	/**
	 * Método que nos devuelve la fila de la propia Coordenada.
	 * 
	 * @return Nos devuelve la fila de la Coordenada.
	 */

	public int getFila() {
		return fila;
	}

	/**
	 * Método que establece la fila en la propia Coordenada.
	 * 
	 * @param fila Nos indica la fila que será asignada a la propia Coordenada.
	 */

	public void setFila(int fila) {
		this.fila = fila;
	}

	/**
	 * Método que nos devuelve la columna de la propia Coordenada.
	 * 
	 * @return Nos devuelve la columna de la Coordenada.
	 */

	public int getCol() {
		return col;
	}

	/**
	 * Método que nos establece la columna en la propia Coordenada.
	 * 
	 * @param col Nos indica la columna que será asignada a la propia Coordenada.
	 */

	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * Método que nos devuelve una nueva Coordenada desplazada una unidad a la
	 * derecha.
	 * 
	 * @return Nos devuelve una nuva Coordenada deplazada a la derecha desde la
	 *         propia Coordenada.
	 */

	public Coordenada moverDerecha() {
		return new Coordenada(fila, col + 1);
	}

	/**
	 * Metodo que nos devuelve una nuva Coordenada desplazada una unidad a la
	 * izquierda.
	 * 
	 * @return Nos devuelve una nueva Coordenada desplazada a la izquierda desde la
	 *         propia Coordenada.
	 */

	public Coordenada moverIzquierda() {
		return new Coordenada(fila, col - 1);
	}

	/**
	 * Método que nos devuelve una nueva Coordenada desplazada una unidad arriba.
	 * 
	 * @return Nos devuelve una nueva Coordenada deplazada arriba desde la propia
	 *         Coordenada.
	 */

	public Coordenada moverArriba() {
		return new Coordenada(fila - 1, col);
	}

	/**
	 * Método que nos devuelve una nueva Coordenada desplazada una unidad bajo.
	 * 
	 * @return Nos devuelve una nueva Coordenada deplazada bajo desde la propia
	 *         Coordenada.
	 */

	public Coordenada moverBajo() {
		return new Coordenada(fila + 1, col);
	}

	/**
	 * Método que nos devuelve una Coordenada desplazada una unidad arriba y una
	 * unidad a la derecha.
	 * 
	 * @return Nos devuelve una nueva Coordenad desplazada arriba y derecha desde la
	 *         propia Coordenada.
	 */

	public Coordenada moverDiagonalArribaDer() {
		return new Coordenada(fila - 1, col + 1);
	}

	/**
	 * Método que nos devuelve una Coordenada desplazada una unidad bajo y una
	 * unidad a la derecha.
	 * 
	 * @return Nos devuelve una nueva Coordenada desplazada bajo y derecha derde la
	 *         propia Coordenada.
	 */

	public Coordenada moverDiagonalBajoDer() {
		return new Coordenada(fila + 1, col + 1);
	}

	/**
	 * Método que nos devuelve una Coordenada desplazada una unidad bajo y una
	 * unidad a la izquierda.
	 * 
	 * @return Nos devuelve una nueva Coordenada deplazada bajo e izquierda desde la
	 *         propia Coordenada.
	 */

	public Coordenada moverDiagonalBajoIzq() {
		return new Coordenada(fila + 1, col - 1);
	}

	/**
	 * Método que nos devuelve una Coordenda desplazada una unidad arriba y una
	 * unidad a la izquierda.
	 * 
	 * @return Nos devuelve una nueva Coordenada desplazada arriba e izquierda desde
	 *         la propia Coordenada.
	 */

	public Coordenada moverDiagonalArribaIzq() {
		return new Coordenada(fila - 1, col - 1);
	}

	/**
	 * @Override Método sobreescrito para el uso del métodos contains de la clase
	 *           ArrayList. Método en el cual especificamos como tiene que ser un
	 *           objeto igual a otro.
	 * @param o Nos indica que le tenemos que pasar un Objeto o.
	 * @return Nos devuelve un True o False, dependiendo de la condición de igualdad
	 *         que hemos definido.
	 * 
	 */

	public boolean equals(Object o) {
		boolean contiene;

		Coordenada c = (Coordenada) o;

		if (fila == c.getFila() && col == c.getCol())
			contiene = true;
		else
			contiene = false;

		return contiene;
	}

	/**
	 * @Override Método sobreescrito para visualizar la Coordenada. Método que nos
	 *           permite ver la propia Coordendad.
	 * @return Nos devuelve un String Con la Fila y la Columna de la Coordenada.
	 */

	public String toString() {
		return "[" + fila + "," + col + "]";
	}
}
