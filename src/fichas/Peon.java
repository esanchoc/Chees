package fichas;

import colecciones.*;

/**
 * Esta clase extiende de Ficha y nos define la forma y los movimientos del
 * Peon.
 * 
 * @author Enrique Vte. Sancho Caballer
 * @version 1.0
 */

public class Peon extends Ficha {

	/**
	 * Contructor de la clase Peon
	 * 
	 * @param forma Nos indica la forma que va a tener el ficha junto con su color.
	 * @param t     Nos indica el tablero en el cual se esta realizando la partida.
	 * @param pos     Nos indica la Coordenada en la que se encuentra la ficha.
	 */

	public Peon(Shape forma, Tablero t, Coordenada pos) {
		super(forma, t, pos);

	}

	/**
	 * MÃ©todo implementado de la clase Ficha que nos indica si el movimiento es
	 * posible el movimiento a la Coordenada indicada, si llega al final del
	 * tablero, convierte al Peon en una nueva Ficha Reina.
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
			if (color().compareToIgnoreCase("negro") == 0 && pos.getFila() == 7) {
				t.eliminarLista(this);
				t.setFicha(new Reina(Ficha.Shape.Black_Queen, t, pos), pos);
				t.getFicha(pos).calcularMovimientosPosibles();
				t.añadirLista(t.getFicha(pos));

			}
			if (color().compareToIgnoreCase("blanco") == 0 && pos.getFila() == 0) {
				t.eliminarLista(this);
				t.setFicha(new Reina(Ficha.Shape.White_Queen, t, pos), pos);
				t.getFicha(pos).calcularMovimientosPosibles();
				t.añadirLista(t.getFicha(pos));
			}
			calcularMovimientosPosibles();
			posible = true;
		}
		return posible;
	}

	/**
	 * MÃ©todo implementado de la clase Ficha que nos calcula los posibles
	 * movimientos sobre la posiciÃ³n en la que se encuentra la ficha.
	 */

	public void calcularMovimientosPosibles() {

		Coordenada c = pos;

		movimientosPosibles.clear();

		if (color().compareToIgnoreCase("Negro") == 0) {
			if (pos.getFila() == 1) {
				movimientosPosibles.add(new Coordenada(getPos().getFila() + 2, getPos().getCol()));
			}

			c = c.moverBajo();

			if (t.estaTablero(c)) {
				if (!t.hayFicha(c)) {
					movimientosPosibles.add(c);
				}
			}

			c = pos;
			c = c.moverDiagonalBajoDer();

			if (t.estaTablero(c)) {
				if (t.hayFicha(c) && t.getFicha(c).color().compareToIgnoreCase(color()) != 0) {
					movimientosPosibles.add(c);
				}
			}

			c = pos;
			c = c.moverDiagonalBajoIzq();

			if (t.estaTablero(c)) {
				if (t.hayFicha(c) && t.getFicha(c).color().compareToIgnoreCase(color()) != 0) {
					movimientosPosibles.add(c);
				}
			}

		} else {
			if (pos.getFila() == 6) {
				movimientosPosibles.add(new Coordenada(getPos().getFila() - 2, getPos().getCol()));
			}
			c = c.moverArriba();

			if (t.estaTablero(c)) {
				if (!t.hayFicha(c)) {
					movimientosPosibles.add(c);
				}
			}

			c = pos;
			c = c.moverDiagonalArribaIzq();

			if (t.estaTablero(c)) {

				if (t.hayFicha(c) && t.getFicha(c).color().compareToIgnoreCase(color()) != 0) {
					movimientosPosibles.add(c);
				}
			}

			c = pos;
			c = c.moverDiagonalArribaDer();

			if (t.estaTablero(c)) {

				if (t.hayFicha(c) && t.getFicha(c).color().compareToIgnoreCase(color()) != 0) {
					movimientosPosibles.add(c);
				}
			}
		}
	}
}