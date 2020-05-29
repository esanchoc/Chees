package principal;

import java.util.*;
import colecciones.*;
import fichas.*;
import fichas.Ficha.Color;

/**
 * Esto es el fichero principal del juego.
 * @author Enrique Vte. Sancho Caballer
 * @version 1.0
 */

public class Chess {
	
	/**
	 * El juego esta compuesto por un Tablero, un contador de turnos y el nombre de los jugadores 1 y 2.
	 */

	private static Tablero t;
	private static Color turno;
	private static String j1;
	private static String j2;

	public static void main(String[] args) {
		
		t = new Tablero();
		turno = Ficha.Color.Blanco;
		
		introduccion();
		limpiarPantalla();

		do {
			
			System.out.println(t);
			
			System.out.println(t.marcador(j1,j2));
			
			switch (turno) {
			
			case Blanco:
				
				turnoBlancas();
			
				break;
				
			case Negro:
				
				turnoNegras();
				
				break;		
			}
				
			cambiarTurno();
			
		}while(t.hayReyBlanco() && t.hayReyNegro());
		
		limpiarPantalla();
		
		System.out.println(t);
		
		System.out.println(t.marcador(j1,j2));
		
		marcadorFinal();
		
	}
	
	/**
	 * En este método muestra el inicio de bienvenida al juego y pide el nombre del Jugador 1 y Jugadore 2.
	 */

	public static void introduccion() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\t"+"Bienvenidos al ajedrez!");
		System.out.println("Por favor, introduce el nombre del jugador con fichas blancas:");
		j1 = sc.nextLine();
		System.out.println("Por favor, introduce el nombre del jugador con fichas negras:");
		j2 = sc.nextLine();

	}
	
	/**
	 * En este método gestiona el turno de las fichas blancas. Primero pide la Coordenada de una ficha para mover, una vez seccionada una Ficha correcta
	 * volveria a pedir una nueva Coordenada donde mover la Ficha, también se comprueba que la Coordenada sea correcta. 
	 */

	public static void turnoBlancas() {

		Ficha f;
		Coordenada posActual;
		Coordenada posNueva;
		boolean movida = false;
		
		System.out.println("Es tel turno de blancas, por favor, selecciona una ficha:");

		do {

			posActual = introducirCoordenada();

			if (t.hayFicha(posActual)) {

				do {
					
					f = t.getFicha(posActual);
					
					if (t.hayFicha(posActual) && f.color().compareToIgnoreCase("blanco") == 0) {

						do {
							System.out.println("\n" + "Introduce la nueva coordenda:");
							posNueva = introducirCoordenada();

							if (t.getFicha(posActual).movimiento(posNueva)) {
								
								movida = true;
								
							} else {
								
								System.out.println("Esta coordenada no es posible, por favor, selecciona otra posible");
								
							}

						} while (!movida);
						
					} else {
						
						if(!t.hayFicha(posActual)) {
							System.out.println("No hay una ficha, por favor, selecciona una casilla que si tenga ficha.");
							posActual = introducirCoordenada();
							
						} else {
							System.out.println("Esta ficha no es de tu color, por favor, elige una ficha de tu color.");
							posActual = introducirCoordenada();
						}
					}

				} while (f.color().compareToIgnoreCase("blanco") != 0 && !movida);

			} else {
				
				System.out.println("No hay una ficha, por favor, selecciona una casilla que si tenga ficha.");
				
			}

		} while (!t.hayFicha(posActual) && !movida);
	}
	
	/**
	 * En este método gestiona el turno de las fichas negras. Primero pide la Coordenada de una ficha para mover, una vez seccionada una Ficha correcta
	 * volveria a pedir una nueva Coordenada donde mover la Ficha, también se comprueba que la Coordenada sea correcta. 
	 */

	public static void turnoNegras() {

		Ficha f;
		Coordenada posActual;
		Coordenada posNueva;
		boolean movida = false;
		
		System.out.println("Es tel turno de negras, por favor, selecciona una ficha:");

		do {

			posActual = introducirCoordenada();

			if (t.hayFicha(posActual)) {

				do {
					
					f = t.getFicha(posActual);
					
					if (t.hayFicha(posActual) && f.color().compareToIgnoreCase("negro") == 0) {

						do {

							System.out.println("\n" + "Introduce la nueva coordenda:");
							posNueva = introducirCoordenada();

							if (t.getFicha(posActual).movimiento(posNueva)) {
								
								movida = true;
								
							} else {
								
								System.out.println("Esta coordenada no es posible, por favor, selecciona otra posible");
								
							}

						} while (!movida);
						
					} else {
						
						if(!t.hayFicha(posActual)) {
							System.out.println("No hay una ficha, por favor, selecciona una casilla que si tenga ficha.");
							posActual = introducirCoordenada();
							
						} else {
							System.out.println("Esta ficha no es de tu color, por favor, elige una ficha de tu color.");
							posActual = introducirCoordenada();
						}
					}

				} while (f.color().compareToIgnoreCase("negro") != 0 && !movida);

			} else {
				
				System.out.println("No hay una ficha, por favor, selecciona una casilla que si tenga ficha.");
				
			}

		} while (!t.hayFicha(posActual) && !movida);
	}
	
	/**
	 * Método el cual nos devuelve una Coordenada formulada de forma correcta.
	 * @return Nos devuelve una Coordenada bien formulada con su correspondiente fila y columna.
	 */

	public static Coordenada introducirCoordenada() {
		Scanner sc = new Scanner(System.in);
		String posicion;
		Coordenada c;
		char col;
		int fila;

		do {

			posicion = sc.nextLine();
			posicion = posicion.toLowerCase();

			if (posicion.length() == 2) {

				col = posicion.charAt(0);
				fila = posicion.charAt(1) - '1';
				c = new Coordenada(fila, col - 'a');
				
			} else {
				
				c = new Coordenada(99, 99);
				
			}

			if (!t.estaTablero(c)) {
				
				System.out.println("Coordenada incorrecta, vuelve a introducir la coordenada. FORMATO[A1]");
				
			}

		} while (posicion.length() != 2 || !t.estaTablero(c));

		return c;

	}
	
	/**
	 * Este método nos indica quien ha sido el ganador de la partida.
	 */
	
	public static void marcadorFinal() {
		
		if(!t.hayReyNegro()) {
			System.out.println(j1+" es el ganador, enhorabuena!");
		}
		
		if(!t.hayReyBlanco()) {
			System.out.println(j2+" es el ganador, enhorabuena!");
		}
		
	}
	
	/**
	 * Este método gestiona el cambio de turno.
	 */

	public static void cambiarTurno() {

		if (turno.name().compareToIgnoreCase("blanco") == 0) {
			turno = Ficha.Color.Negro;
		} else {
			turno = Ficha.Color.Blanco;
		}
	}
	
	/**
	 * Este método nos limpia la pantalla
	 */
	
	public static void limpiarPantalla() {
		
		for(int i = 0  ; i < 100 ; i++) {
			System.out.println();
		}
	}
}
