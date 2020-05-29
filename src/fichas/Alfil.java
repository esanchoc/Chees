package fichas;

import colecciones.*;

/**
 * Esta clase extiende de Ficha y nos define la forma y los movimientos del
 * Alfil.
 * 
 * @author Enrique Vte. Sancho Caballer
 * @version 1.0
 */

public class Alfil extends Ficha {

	/**
	 * Constructor de la clase Alfil.
	 * 
	 * @param forma Nos indica la forma que va a tener el ficha junto con su color.
	 * @param t     Nos indica el tablero en el cual se esta realizando la partida.
	 * @param pos     Nos indica la Coordenada en la que se encuentra la ficha.
	 */

	public Alfil(Shape forma, Tablero t, Coordenada pos) {
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

		c = c.moverDiagonalBajoDer();

		while (t.estaTablero(c) && !t.hayFicha(c)) {
			movimientosPosibles.add(c);
			c = c.moverDiagonalBajoDer();
		}

		if (t.estaTablero(c) && t.getFicha(c).color().compareToIgnoreCase(color()) != 0) {
			movimientosPosibles.add(c);
		}

		c = pos;
		c = c.moverDiagonalBajoIzq();

		while (t.estaTablero(c) && !t.hayFicha(c)) {
			movimientosPosibles.add(c);
			c = c.moverDiagonalBajoIzq();
		}

		if (t.estaTablero(c) && t.getFicha(c).color().compareToIgnoreCase(color()) != 0) {
			movimientosPosibles.add(c);
		}

		c = pos;
		c = c.moverDiagonalArribaDer();

		while (t.estaTablero(c) && !t.hayFicha(c)) {
			movimientosPosibles.add(c);
			c = c.moverDiagonalArribaDer();
		}

		if (t.estaTablero(c) && t.getFicha(c).color().compareToIgnoreCase(color()) != 0) {
			movimientosPosibles.add(c);
		}

		c = pos;
		c = c.moverDiagonalArribaIzq();

		while (t.estaTablero(c) && !t.hayFicha(c)) {
			movimientosPosibles.add(c);
			c = c.moverDiagonalArribaIzq();
		}

		if (t.estaTablero(c) && t.getFicha(c).color().compareToIgnoreCase(color()) != 0) {
			movimientosPosibles.add(c);
		}
	}
}
