package colecciones;

import java.util.ArrayList;

import fichas.*;

/**
 * Esta clase nos define el Tablero donde se va a realizar la partida. Esta
 * compuesta por una matriz de dos dimensiones de la clase Celda con un tamaÃ±o
 * de 8x8, una lista con las fichas blancas y otra con las fichas negras, el
 * propio Rey blanco y Rey negro.
 * 
 * @author Enrique Vte. Sancho Caballer
 * @version 1.0
 */

public class Tablero {

	private Celda[][] t;
	private ArrayList<Ficha> blancas;
	private ArrayList<Ficha> negras;
	private Ficha reyNegro;
	private Ficha reyBlanco;

	/**
	 * Constructor de la clase Tablero.
	 */

	public Tablero() {
		t = new Celda[8][8];
		for (int fil = 0; fil < t.length; fil++)
			for (int col = 0; col < t.length; col++)
				t[fil][col] = new Celda();
		blancas = new ArrayList<Ficha>();
		negras = new ArrayList<Ficha>();
		rellenarTablero();
		addFichasLista();
	}

	/**
	 * MÃ©todo que nos aÃ±ade todas las fichas en el tablero a la lista
	 * correspondiente a su Color.
	 */

	public void addFichasLista() {

		for (int fila = 6; fila < t.length; fila++) {
			for (int col = 0; col < t[0].length; col++) {
				t[fila][col].getFicha().calcularMovimientosPosibles();
				blancas.add(t[fila][col].getFicha());
			}
		}

		for (int fila = 1; fila >= 0; fila--) {
			for (int col = 0; col < t[0].length; col++) {
				t[fila][col].getFicha().calcularMovimientosPosibles();
				negras.add(t[fila][col].getFicha());
			}
		}
	}

	/**
	 * MÃ©todo que nos aÃ±ade una Ficha a su lista correspondiente dependiendo del
	 * color.
	 * 
	 * @param f Nos indica la Ficha que va a ser aÃ±adida a su correspondiente lista.
	 */

	public void añadirLista(Ficha f) {
		if (f.color().compareToIgnoreCase("blanco") == 0) {
			blancas.add(f);
		} else {
			negras.add(f);
		}
	}

	/**
	 * MÃ©todo que nos elimina una Ficha de la lista correspondiente dependiendo del
	 * color.
	 * 
	 * @param f Nos indica la Ficha que va a ser eliminada de su correspondientre
	 *          lista.
	 */

	public void eliminarLista(Ficha f) {
		if (f.color().compareToIgnoreCase("blanco") == 0) {
			blancas.remove(f);
		} else {
			negras.remove(f);
		}
	}

	/**
	 * MÃ©todo que nos permite aÃ±adir una Ficha en la Celda indicada por la
	 * Coordenada.
	 * 
	 * @param f Nos indica la ficha que va a ser aÃ±adida en la Celda
	 *          correspondiente.
	 * @param c Nos indica la Coordenada de la Celda en la cual aÃ±adir la Ficha.
	 */

	public void setFicha(Ficha f, Coordenada c) {
		t[c.getFila()][c.getCol()].setFicha(f);
	}

	/**
	 * MÃ©todo que nos devuelve la Ficha que hay en la Coordenada indicada.
	 * 
	 * @param c Nos indica la Coordenada de la Celda de la cual queremos obtener la
	 *          Ficha.
	 * @return Nos devuelve la Ficha de la celda seleccionada con la Coordenada
	 *         indicada.
	 */

	public Ficha getFicha(Coordenada c) {
		return t[c.getFila()][c.getCol()].getFicha();
	}

	/**
	 * MÃ©todo que nos indica si el Rey blanco esta en la lista de las fichas
	 * blancas.
	 * 
	 * @return Nos devuelve True o False si el Rey esta en la lista o no.
	 */

	public boolean hayReyBlanco() {
		boolean hayRey = false;
		for (Ficha f : blancas) {
			if (f.forma() == Ficha.Shape.White_King) {
				hayRey = true;
			}
		}

		return hayRey;
	}

	/**
	 * MÃ©todo que nos indica si el Rey negro esta en la lista de las fichas negras.
	 * 
	 * @return Nos devuelte True o False si el Rey esta en la lista o no.
	 */

	public boolean hayReyNegro() {

		boolean hayRey = false;
		for (Ficha f : negras) {
			if (f.forma() == Ficha.Shape.Black_King) {
				hayRey = true;
			}
		}

		return hayRey;
	}

	/**
	 * MÃ©todo que nos indica si hay una Ficha en la Celda correspondiente a la
	 * Coordenada indicada.
	 * 
	 * @param c Nos indica la Coordenada en la cual seleccionar la Celda.
	 * @return Nos devuelve True o False si hay una Ficha en la Celda seleccionada o
	 *         no.
	 */

	public boolean hayFicha(Coordenada c) {
		boolean hayFicha;

		if (t[c.getFila()][c.getCol()].getFicha() != null)
			hayFicha = true;
		else
			hayFicha = false;

		return hayFicha;
	}

	/**
	 * MÃ©todo que nos indica si el Rey del Color indicado esta en Jaque o no.
	 * 
	 * @param color Nos incica el color del Rey al que queremos comprobar.
	 * @return Nos devuelte True o False si el Rey indicado esta en Jaque o no.
	 */

	public boolean hayJaque(String color) {

		if (color.compareToIgnoreCase("blanco") == 0) {
			return jaqueBlanco();
		} else {
			return jaqueNegro();
		}

	}

	/**
	 * MÃ©todo que comprueba si el Rey negro estÃ¡ en Jaque.
	 * 
	 * @return Nos devuelve True o False si el Rey esta en Jaque o no.
	 */

	private boolean jaqueNegro() {
		ArrayList<Coordenada> movimientos = new ArrayList<Coordenada>();

		for (Ficha f : blancas) {
			movimientos.addAll(f.obtenerMovimientosPosibles());
		}

		return movimientos.contains(reyNegro.getPos());
	}

	/**
	 * MÃ©todo que comprueba si el Rey blanco estÃ¡ en Jaque.
	 * 
	 * @return Nos devuelve True o False si el Rey esta en Jaque o no.
	 */

	private boolean jaqueBlanco() {
		ArrayList<Coordenada> movimientos = new ArrayList<Coordenada>();

		for (Ficha f : negras) {
			movimientos.addAll(f.obtenerMovimientosPosibles());
		}

		return movimientos.contains(reyBlanco.getPos());
	}

	/**
	 * MÃ©todo que nos rellena el tablero con las fichas en su posiciÃ³n inicial.
	 */

	public void rellenarTablero() {
		t[0][0].setFicha(new Torre(Ficha.Shape.Black_Tower, this, new Coordenada(0, 0)));
		t[0][7].setFicha(new Torre(Ficha.Shape.Black_Tower, this, new Coordenada(0, 7)));
		t[0][1].setFicha(new Caballo(Ficha.Shape.Black_Horse, this, new Coordenada(0, 1)));
		t[0][6].setFicha(new Caballo(Ficha.Shape.Black_Horse, this, new Coordenada(0, 6)));
		t[0][2].setFicha(new Alfil(Ficha.Shape.Black_Alfil, this, new Coordenada(0, 2)));
		t[0][5].setFicha(new Alfil(Ficha.Shape.Black_Alfil, this, new Coordenada(0, 5)));
		t[0][3].setFicha(new Reina(Ficha.Shape.Black_Queen, this, new Coordenada(0, 3)));
		reyNegro = new Rey(Ficha.Shape.Black_King, this, new Coordenada(0, 4));
		t[0][4].setFicha(reyNegro);

		for (int pos = 0; pos < t[0].length; pos++) {
			t[1][pos].setFicha(new Peon(Ficha.Shape.Black_Peon, this, new Coordenada(1, pos)));
		}

		for (int pos = 0; pos < t[0].length; pos++) {
			t[6][pos].setFicha(new Peon(Ficha.Shape.White_Peon, this, new Coordenada(6, pos)));
		}

		t[7][0].setFicha(new Torre(Ficha.Shape.White_Tower, this, new Coordenada(7, 0)));
		t[7][7].setFicha(new Torre(Ficha.Shape.White_Tower, this, new Coordenada(7, 7)));
		t[7][1].setFicha(new Caballo(Ficha.Shape.White_Horse, this, new Coordenada(7, 1)));
		t[7][6].setFicha(new Caballo(Ficha.Shape.White_Horse, this, new Coordenada(7, 6)));
		t[7][2].setFicha(new Alfil(Ficha.Shape.White_Alfil, this, new Coordenada(7, 2)));
		t[7][5].setFicha(new Alfil(Ficha.Shape.White_Alfil, this, new Coordenada(7, 5)));
		t[7][3].setFicha(new Reina(Ficha.Shape.White_Queen, this, new Coordenada(7, 3)));
		reyBlanco = new Rey(Ficha.Shape.White_King, this, new Coordenada(7, 4));
		t[7][4].setFicha(reyBlanco);
	}

	/**
	 * MÃ©todo que nos indica si una Coordenada esta dentro de las Coordenadas que
	 * tiene el tablero.
	 * 
	 * @param c Nos indica la Coordenada que vamos a comprobar si esta o no.
	 * @return Nos devuelte True o False dependiendo si esta dentro del Tablero o
	 *         no,
	 */

	public boolean estaTablero(Coordenada c) {

		if ((c.getFila() >= 0 && c.getFila() <= 7) && (c.getCol() >= 0 && c.getCol() <= 7)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * MÃ©todo que se encarga de gestionar las muertes de las Fichas en la Coordenada
	 * indicada.
	 * 
	 * @param c Nos indica la Coordenada de la Celda de la cual queremos matar la
	 *          Ficha que contiene.
	 */

	public void matar(Coordenada c) {

		if (hayFicha(c)) {

			Ficha f = getFicha(c);

			if (f.color().compareToIgnoreCase("blanco") == 0) {
				blancas.remove(f);
			} else {
				negras.remove(f);
			}
		}
	}

	/**
	 * MÃ©todo que nos muestra el marcador de los Jugadores 1 y 2.
	 * 
	 * @param j1 Nos indica el nombre del Jugador 1.
	 * @param j2 Nos indica el nombre del Jugador 2.
	 * @return Nos devuelve un String del marcador con el nombre de Jugador 1 y
	 *         Jugador 2, y su cantidad de fichas restante.
	 */

	public String marcador(String j1, String j2) {
		String marcador = "";

		int Black_King = 0, Black_Queen = 0, Black_Tower = 0, Black_Horse = 0, Black_Bishop = 0, Black_Pawn = 0;
		int White_King = 0, White_Queen = 0, White_Tower = 0, White_Horse = 0, White_Bishop = 0, White_Pawn = 0;

		for (Ficha f : negras) {
			if (f.forma() == Ficha.Shape.Black_King) {
				Black_King++;
			}
			if (f.forma() == Ficha.Shape.Black_Queen) {
				Black_Queen++;
			}
			if (f.forma() == Ficha.Shape.Black_Tower) {
				Black_Tower++;
			}
			if (f.forma() == Ficha.Shape.Black_Horse) {
				Black_Horse++;
			}
			if (f.forma() == Ficha.Shape.Black_Alfil) {
				Black_Bishop++;
			}
			if (f.forma() == Ficha.Shape.Black_Peon) {
				Black_Pawn++;
			}
		}

		for (Ficha f : blancas) {
			if (f.forma() == Ficha.Shape.White_King) {
				White_King++;
			}
			if (f.forma() == Ficha.Shape.White_Queen) {
				White_Queen++;
			}
			if (f.forma() == Ficha.Shape.White_Tower) {
				White_Tower++;
			}
			if (f.forma() == Ficha.Shape.White_Horse) {
				White_Horse++;
			}
			if (f.forma() == Ficha.Shape.White_Alfil) {
				White_Bishop++;
			}
			if (f.forma() == Ficha.Shape.White_Peon) {
				White_Pawn++;
			}
		}

		if (hayJaque("blanco")) {

			marcador += "        Negras: " + j2 + "                      Blancas: " + j1 + "          " + "\n";
			marcador += "  â•”â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•—          â•”â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•— " + "\n";
			marcador += "  â•‘ " + "\u2654" + " â”‚ " + "\u2655" + " â”‚ " + "\u2658" + " â”‚ " + "\u2656" + " â”‚ " + "\u2657"
					+ " â”‚ " + "\u2659" + " â•‘          â•‘ " + "\u001B[31m" + "\u265A" + "\001B[0m" + " â”‚ " + "\u265B"
					+ " â”‚ " + "\u265E" + " â”‚ " + "\u265C" + " â”‚ " + "\u265D" + " â”‚ " + "\u265F" + " â•‘ " + "\n";
			marcador += "  â•Ÿâ”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â•¢          â•Ÿâ”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â•¢ " + "\n";
			marcador += "  â•‘ " + Black_King + " â”‚ " + Black_Queen + " â”‚ " + Black_Horse + " â”‚ " + Black_Tower + " â”‚ "
					+ Black_Bishop + " â”‚ " + Black_Pawn + " â•‘          â•‘ " + White_King + " â”‚ " + White_Queen + " â”‚ "
					+ White_Horse + " â”‚ " + White_Tower + " â”‚ " + White_Bishop + " â”‚ " + White_Pawn + " â•‘ " + "\n";
			marcador += "  â•šâ•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•�          â•šâ•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•� " + "\n";

			marcador += "\n" + "Jaque!" + "\n";

		} else if (hayJaque("negro")) {

			marcador += "        Negras: " + j2 + "                      Blancas: " + j1 + "          " + "\n";
			marcador += "  â•”â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•—          â•”â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•— " + "\n";
			marcador += "  â•‘ " + "\u001B[31m" + "\u2654" + "\u001B[0m" + " â”‚ " + "\u2655" + " â”‚ " + "\u2658" + " â”‚ "
					+ "\u2656" + " â”‚ " + "\u2657" + " â”‚ " + "\u2659" + " â•‘          â•‘ " + "\u265A" + " â”‚ " + "\u265B"
					+ " â”‚ " + "\u265E" + " â”‚ " + "\u265C" + " â”‚ " + "\u265D" + " â”‚ " + "\u265F" + " â•‘ " + "\n";
			marcador += "  â•Ÿâ”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â•¢          â•Ÿâ”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â•¢ " + "\n";
			marcador += "  â•‘ " + Black_King + " â”‚ " + Black_Queen + " â”‚ " + Black_Horse + " â”‚ " + Black_Tower + " â”‚ "
					+ Black_Bishop + " â”‚ " + Black_Pawn + " â•‘          â•‘ " + White_King + " â”‚ " + White_Queen + " â”‚ "
					+ White_Horse + " â”‚ " + White_Tower + " â”‚ " + White_Bishop + " â”‚ " + White_Pawn + " â•‘ " + "\n";
			marcador += "  â•šâ•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•�          â•šâ•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•� " + "\n";

			marcador += "\n" + "\t" + "\t" + "Jaque!" + "\n";

		} else {

			marcador += "        Negras: " + j2 + "                      Blancas: " + j1 + "          " + "\n";
			marcador += "  â•”â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•—          â•”â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•— " + "\n";
			marcador += "  â•‘ " + "\u2654" + " â”‚ " + "\u2655" + " â”‚ " + "\u2658" + " â”‚ " + "\u2656" + " â”‚ " + "\u2657"
					+ " â”‚ " + "\u2659" + " â•‘          â•‘ " + "\u265A" + " â”‚ " + "\u265B" + " â”‚ " + "\u265E" + " â”‚ "
					+ "\u265C" + " â”‚ " + "\u265D" + " â”‚ " + "\u265F" + " â•‘ " + "\n";
			marcador += "  â•Ÿâ”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â•¢          â•Ÿâ”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â•¢ " + "\n";
			marcador += "  â•‘ " + Black_King + " â”‚ " + Black_Queen + " â”‚ " + Black_Horse + " â”‚ " + Black_Tower + " â”‚ "
					+ Black_Bishop + " â”‚ " + Black_Pawn + " â•‘          â•‘ " + White_King + " â”‚ " + White_Queen + " â”‚ "
					+ White_Horse + " â”‚ " + White_Tower + " â”‚ " + White_Bishop + " â”‚ " + White_Pawn + " â•‘ " + "\n";
			marcador += "  â•šâ•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•�          â•šâ•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•� " + "\n";

		}

		return marcador;
	}

	/**
	 * @Override MÃ©todo sobreescrito para definir la imagen del Tablero.
	 * 
	 * @return Nos devuelve un String con el Tablero dibujado.
	 */

	public String toString() {
		String salida = "";

		salida += "\t" + "\t" + "    A   B   C   D   E   F   G   H  " + "\n";
		salida += "\t" + "\t" + "  â•”â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•¤â•�â•�â•�â•—" + "\n";
		salida += "\t" + "\t" + "1 â•‘ " + t[0][0] + " â”‚ " + t[0][1] + " â”‚ " + t[0][2] + " â”‚ " + t[0][3] + " â”‚ " + t[0][4]
				+ " â”‚ " + t[0][5] + " â”‚ " + t[0][6] + " â”‚ " + t[0][7] + " â•‘" + "\n";
		salida += "\t" + "\t" + "  â•Ÿâ”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â•¢" + "\n";
		salida += "\t" + "\t" + "2 â•‘ " + t[1][0] + " â”‚ " + t[1][1] + " â”‚ " + t[1][2] + " â”‚ " + t[1][3] + " â”‚ " + t[1][4]
				+ " â”‚ " + t[1][5] + " â”‚ " + t[1][6] + " â”‚ " + t[1][7] + " â•‘" + "\n";
		salida += "\t" + "\t" + "  â•Ÿâ”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â•¢" + "\n";
		salida += "\t" + "\t" + "3 â•‘ " + t[2][0] + " â”‚ " + t[2][1] + " â”‚ " + t[2][2] + " â”‚ " + t[2][3] + " â”‚ " + t[2][4]
				+ " â”‚ " + t[2][5] + " â”‚ " + t[2][6] + " â”‚ " + t[2][7] + " â•‘" + "\n";
		salida += "\t" + "\t" + "  â•Ÿâ”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â•¢" + "\n";
		salida += "\t" + "\t" + "4 â•‘ " + t[3][0] + " â”‚ " + t[3][1] + " â”‚ " + t[3][2] + " â”‚ " + t[3][3] + " â”‚ " + t[3][4]
				+ " â”‚ " + t[3][5] + " â”‚ " + t[3][6] + " â”‚ " + t[3][7] + " â•‘" + "\n";
		salida += "\t" + "\t" + "  â•Ÿâ”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â•¢" + "\n";
		salida += "\t" + "\t" + "5 â•‘ " + t[4][0] + " â”‚ " + t[4][1] + " â”‚ " + t[4][2] + " â”‚ " + t[4][3] + " â”‚ " + t[4][4]
				+ " â”‚ " + t[4][5] + " â”‚ " + t[4][6] + " â”‚ " + t[4][7] + " â•‘" + "\n";
		salida += "\t" + "\t" + "  â•Ÿâ”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â•¢" + "\n";
		salida += "\t" + "\t" + "6 â•‘ " + t[5][0] + " â”‚ " + t[5][1] + " â”‚ " + t[5][2] + " â”‚ " + t[5][3] + " â”‚ " + t[5][4]
				+ " â”‚ " + t[5][5] + " â”‚ " + t[5][6] + " â”‚ " + t[5][7] + " â•‘" + "\n";
		salida += "\t" + "\t" + "  â•Ÿâ”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â•¢" + "\n";
		salida += "\t" + "\t" + "7 â•‘ " + t[6][0] + " â”‚ " + t[6][1] + " â”‚ " + t[6][2] + " â”‚ " + t[6][3] + " â”‚ " + t[6][4]
				+ " â”‚ " + t[6][5] + " â”‚ " + t[6][6] + " â”‚ " + t[6][7] + " â•‘" + "\n";
		salida += "\t" + "\t" + "  â•Ÿâ”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â”¼â”€â”€â”€â•¢" + "\n";
		salida += "\t" + "\t" + "8 â•‘ " + t[7][0] + " â”‚ " + t[7][1] + " â”‚ " + t[7][2] + " â”‚ " + t[7][3] + " â”‚ " + t[7][4]
				+ " â”‚ " + t[7][5] + " â”‚ " + t[7][6] + " â”‚ " + t[7][7] + " â•‘" + "\n";
		salida += "\t" + "\t" + "  â•šâ•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•§â•�â•�â•�â•�" + "\n";

		return salida;
	}

}
