package fichas;

import colecciones.*;

/**
 * Esta clase extiende de Ficha y nos define la forma y los movimientos del Caballo.
 * @author Enrique Vte. Sancho Caballer
 * @version 1.0
 */

public class Caballo extends Ficha {
	
	/**
	 * Contructor de la clase Caballo
	 * @param forma Nos indica la forma que va a tener el ficha junto con su color.
	 * @param t Nos indica el tablero en el cual se esta realizando la partida.
	 * @param pos Nos indica la Coordenada en la que se encuentra la ficha.
	 */

	public Caballo(Shape forma, Tablero t, Coordenada pos) {
		super(forma, t, pos);
	}
	
	/**
	 * Método implementado de la clase Ficha que nos indica si el movimiento es posible el movimiento a la Coordenada indicada.
	 * @param c Nos indica la Coordenada a la que se desea mover la ficha.
	 * @return Nos devuelve si ha sido posible el movimiento de la ficha con True o False.
	 */

	public boolean movimiento(Coordenada c) {
		boolean posible = false;

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
		Coordenada aux;

		movimientosPosibles.clear();

		c = c.moverBajo();
		c = c.moverBajo();

		if (t.estaTablero(c)) {

			aux = c.moverIzquierda();

			if (t.estaTablero(aux)) {
				if (!t.hayFicha(aux)
						|| (t.hayFicha(aux) && t.getFicha(aux).color().compareToIgnoreCase(color()) != 0)) {
					movimientosPosibles.add(aux);
				}
			}

			aux = c.moverDerecha();

			if (t.estaTablero(aux)) {
				if (!t.hayFicha(aux)
						|| (t.hayFicha(aux) && t.getFicha(aux).color().compareToIgnoreCase(color()) != 0)) {
					movimientosPosibles.add(aux);
				}
			}
		}

		c = pos;
		c = c.moverArriba();
		c = c.moverArriba();

		if (t.estaTablero(c)) {

			aux = c.moverDerecha();

			if (t.estaTablero(aux)) {
				if (!t.hayFicha(aux)
						|| (t.hayFicha(aux) && t.getFicha(aux).color().compareToIgnoreCase(color()) != 0)) {
					movimientosPosibles.add(aux);
				}
			}

			aux = c.moverIzquierda();

			if (t.estaTablero(aux)) {
				if (!t.hayFicha(aux)
						|| (t.hayFicha(aux) && t.getFicha(aux).color().compareToIgnoreCase(color()) != 0)) {
					movimientosPosibles.add(aux);
				}
			}
		}

		c = pos;
		c = c.moverIzquierda();
		c = c.moverIzquierda();

		if (t.estaTablero(c)) {

			aux = c.moverBajo();

			if (t.estaTablero(aux)) {
				if (!t.hayFicha(aux)
						|| (t.hayFicha(aux) && t.getFicha(aux).color().compareToIgnoreCase(color()) != 0)) {
					movimientosPosibles.add(aux);
				}
			}

			aux = c.moverArriba();

			if (t.estaTablero(aux)) {
				if (!t.hayFicha(aux)
						|| (t.hayFicha(aux) && t.getFicha(aux).color().compareToIgnoreCase(color()) != 0)) {
					movimientosPosibles.add(aux);
				}
			}
		}

		c = pos;
		c = c.moverDerecha();
		c = c.moverDerecha();

		if (t.estaTablero(c)) {

			aux = c.moverBajo();

			if (t.estaTablero(aux)) {
				if (!t.hayFicha(aux)
						|| (t.hayFicha(aux) && t.getFicha(aux).color().compareToIgnoreCase(color()) != 0)) {
					movimientosPosibles.add(aux);
				}
			}

			aux = c.moverArriba();

			if (t.estaTablero(aux)) {
				if (!t.hayFicha(aux)
						|| (t.hayFicha(aux) && t.getFicha(aux).color().compareToIgnoreCase(color()) != 0)) {
					movimientosPosibles.add(aux);
				}
			}
		}

	}
}