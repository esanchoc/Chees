package fichas;

/**
 * Esta clase define el objeto Ficha, la cual es abstracta y nos define una forma y color exacto de la ficha para que no se puedan crear fichas con otra forma y color.
 * @author Enrique Vte. Sancho Caballer
 * @version 1.0
 */

import java.util.ArrayList;

import colecciones.*;

public abstract class Ficha {

	/**
	 * Enum Nos indentifica las únicas formas posibles para la clase Ficha.
	 */

	public static enum Shape {
		Black_King("\u2654", Color.Negro), Black_Queen("\u2655", Color.Negro), Black_Horse("\u2658", Color.Negro),
		Black_Tower("\u2656", Color.Negro), Black_Alfil("\u2657", Color.Negro), Black_Peon("\u2659", Color.Negro),

		White_King("\u265A", Color.Blanco), White_Queen("\u265B", Color.Blanco), White_Horse("\u265E", Color.Blanco),
		White_Tower("\u265C", Color.Blanco), White_Alfil("\u265D", Color.Blanco), White_Peon("\u265F", Color.Blanco);

		private String forma;
		private Color color;

		/**
		 * 
		 * @param forma Nos indica la forma que va a tener la ficha.
		 * @param color Nos indica el color que va a tener la ficha.
		 */
		Shape(String forma, Color color) {
			this.forma = forma;
			this.color = color;
		}

		/**
		 * @return La forma que tiene una ficha.
		 */

		public String toString() {
			return forma;
		}
	}

	/**
	 * Enum que nos indica los únicos colores que pueden tener una ficha.
	 */

	public static enum Color {
		Blanco, Negro;
	}

	/**
	 * forma Nos indica la forma.
	 */

	protected Shape forma;
	protected Tablero t;
	protected Coordenada pos;
	protected ArrayList<Coordenada> movimientosPosibles;

	/**
	 * Contructor de la clase ficha.
	 * 
	 * @param forma Nos indica la forma que va a tener el ficha junto con su color.
	 * @param t     Nos indica el tablero en el cual se esta realizando la partida.
	 * @param c     Nos indica la Coordenada en la que se encuentra la ficha.
	 */

	public Ficha(Shape forma, Tablero t, Coordenada c) {
		this.forma = forma;
		this.t = t;
		pos = c;
		movimientosPosibles = new ArrayList<Coordenada>();
	}

	/**
	 * Método que nos indica si el movimiento es posible o no.
	 * 
	 * @param c Nos indica la coordenada a la que nos queremos mover.
	 * @return Si ha sido posible realizar el movimiento o no.
	 */

	public abstract boolean movimiento(Coordenada c);

	/**
	 * Método que nos calcula los moviminetos posibles para la coordenada en la que
	 * se encuentra.
	 */

	public abstract void calcularMovimientosPosibles();

	/**
	 * Método que realiza el moviento de la ficha a la coordenada pasada.
	 * 
	 * @param c Nos indica la coordenada a la que nos queremos mover.
	 */

	public void mover(Coordenada c) {
		t.setFicha(this, c);
		t.setFicha(null, pos);
		pos = c;
	}

	/**
	 * @Override Método sobreescrito para mostrar la forma de la ficha.
	 * @return Nos devuelve el String con la forma de la ficha.
	 */

	public String toString() {
		return forma.toString();
	}

	/**
	 * Método que nos indica el color de la propia ficha.
	 * 
	 * @return Nos devuelve el nombre del color.
	 */

	public String color() {
		return forma.color.name();
	}

	/**
	 * Método que nos indica la forma de la ficha.
	 * 
	 * @return Nos devuelve la forma.
	 */

	public Shape forma() {
		return forma;
	}

	/**
	 * Método que establece la coordenada pasada por parametro como la coordenada en
	 * la que se encuentra la ficha.
	 * 
	 * @param pos Nos indica la coordenada que le vamos a dar a la propia ficha.
	 */

	public void setPos(Coordenada pos) {
		this.pos = pos;
	}

	/**
	 * Método que nos devuelve la coordenada en la que se encuentra la ficha dentro
	 * del tablero.
	 * 
	 * @return Nos devuelve la coordenada de la propia ficha.
	 */

	public Coordenada getPos() {
		return pos;
	}

	/**
	 * Método que nos devuelve la lista de los movimientos posibles.
	 * 
	 * @return Nos devuelve la lista de movimientos posibles de la propia ficha.
	 */

	public ArrayList<Coordenada> obtenerMovimientosPosibles() {
		return movimientosPosibles;
	}

	/**
	 * Método que nos muestra la lista de los movimientos posibles, principalmente
	 * utilizado para el desarrollo de la App.
	 * 
	 * @return Nos devuelve un String con la lista de movimientos posibles.
	 */

	public String movimientosPosibles() {
		String lista = "";

		for (Coordenada c : movimientosPosibles) {
			lista += c + " ";
		}

		return lista;
	}
}
