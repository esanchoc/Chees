package fichas;

import colecciones.*;

/**
 * Esta clase extiende de Ficha y nos defina la forma y los movimientos de la
 * Torre.
 * 
 * @author Enrique Vte. Sancho Caballer
 * @version 1.0
 */

public class Torre extends Ficha {
	
	/**
	 * Constructor de la clase Reina.
	 * 
	 * @param forma Nos indica la forma que va a tener el ficha junto con su color.
	 * @param t     Nos indica el tablero en el cual se esta realizando la partida.
	 * @param pos     Nos indica la Coordenada en la que se encuentra la ficha.
	 */

	public Torre(Shape forma, Tablero t, Coordenada pos) {
		super(forma, t, pos);
	}
	
	/**
	 * Método implementado de la clase Ficha que nos indica si el movimiento es
	 * posible el movimiento a la Coordenada indicada.
	 * 
	 * @param c Nos indica la Coordenada a la que se desea mover la ficha.
	 * @return Nos devuelve si ha sido posible el movimiento de la ficha con True o
	 *         False.
	 */

	public boolean movimiento(Coordenada c) {
		boolean posible = false;

		calcularMovimientosPosibles();

		if (movimientosPosibles.contains(c)) {
			t.matar(c);
			mover(c);
			calcularMovimientosPosibles();
			posible = true;
		}
		return posible;
	}
	
	/**
	 * Método implementado de la clase Ficha que nos calcula los posibles
	 * movimientos sobre la posición en la que se encuentra la ficha.
	 */

	public void calcularMovimientosPosibles() {

		Coordenada c = pos;

		movimientosPosibles.clear();

		c = c.moverBajo();

		while (t.estaTablero(c) && !t.hayFicha(c)) {
			movimientosPosibles.add(c);
			c = c.moverBajo();
		}

		if (t.estaTablero(c) && t.getFicha(c).color().compareToIgnoreCase(color()) != 0) {
			movimientosPosibles.add(c);
		}

		c = pos;

		c = c.moverArriba();

		while (t.estaTablero(c) && !t.hayFicha(c)) {
			movimientosPosibles.add(c);
			c = c.moverArriba();
		}

		if (t.estaTablero(c) && t.getFicha(c).color().compareToIgnoreCase(color()) != 0) {
			movimientosPosibles.add(c);
		}

		c = pos;

		c = c.moverDerecha();

		while (t.estaTablero(c) && !t.hayFicha(c)) {
			movimientosPosibles.add(c);
			c = c.moverDerecha();
		}

		if (t.estaTablero(c) && t.getFicha(c).color().compareToIgnoreCase(color()) != 0) {
			movimientosPosibles.add(c);
		}

		c = pos;

		c.moverIzquierda();

		while (t.estaTablero(c) && !t.hayFicha(c)) {
			movimientosPosibles.add(c);
			c.moverIzquierda();
		}

		if (t.estaTablero(c) && t.getFicha(c).color().compareToIgnoreCase(color()) != 0) {
			movimientosPosibles.add(c);
		}
	}
}