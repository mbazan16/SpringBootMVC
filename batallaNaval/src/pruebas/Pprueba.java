package pruebas;

import java.util.Scanner;

import beans.*;
import coordenadas.ListaLetras;
import ln.*;

public class Pprueba {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		TableroDisparos tableroDisparos = new TableroDisparos();
		TableroBarcos tableroBarcos = new TableroBarcos();
		
		
	ListaBarcos listaPlayer1 = new ListaBarcos();
		listaPlayer1.crearBarcos();
		
		Colocacion.autoRellenar(listaPlayer1);
		
		for(Barco barco:listaPlayer1.getLista()) {
			Colocacion.marcarBarcoEnTablero(barco,tableroBarcos);
		}
		
		Turno esteTurno = new Turno();
	
		
		
//		while (true) {
//			
//			esteTurno.disparar(sc, listaPlayer1, tableroDisparos);
//			System.out.println(tableroBarcos);
//		}
		
		Turno.dispararSalva(listaPlayer1, tableroDisparos);
		System.out.println(tableroDisparos);
		System.out.println(tableroBarcos);
		
		

		
		
		

	}

}
