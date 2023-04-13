package ln;

import java.util.Scanner;

import beans.Barco;
import beans.Casilla;
import beans.ListaBarcos;
import coordenadas.ListaLetras;

public class Partida {
	
	public static void main(String[] args) {
		

		//este bloque es para comprobar la colocacion
//		Scanner sc = new Scanner(System.in);
//		int contador =1;
//		
//		//creo una lista de barcos y el jugador tiene que ir colocandolos
//		//mientras la lista no este vacia.
//		
//		ListaBarcos listaPlayer1 = new ListaBarcos();
//		listaPlayer1.crearBarcos();
//						
//		while (listaPlayer1.getLista().size()>0) {
//			Colocacion.colocarBarco(sc,listaPlayer1);
//		}
		
		ListaBarcos listaPlayer1 = new ListaBarcos();
		listaPlayer1.crearBarcos();
		
		Colocacion.autoRellenar(listaPlayer1);

		
		
	}
	
	
	
	public void crearTablero() {
		for (int i=0; i<10; i++) {
			
		}
	}

}
