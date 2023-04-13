package ln;

import java.util.Scanner;

import beans.*;
import coordenadas.ListaLetras;

public class Turno {
	
	public static void disparar(Scanner sc, ListaBarcos lista,TableroDisparos tableroDisparos) {
		
		Casilla casilla = seleccionarCasilla(sc);
		Boolean impacto = comprobarImpacto(casilla,lista);
		mostrarDisparo(tableroDisparos, casilla, impacto);
		
	}
	public static Casilla seleccionarCasilla(Scanner sc) {
		
		System.out.println("coordenadas del disparo (letra numero) :");
		String letra = sc.next();
		int numero = sc.nextInt();
		
		return new Casilla(letra,numero);
		
	}
	
	public static boolean comprobarImpacto(Casilla casilla, ListaBarcos lista) {
		
		boolean impacto=false;
		
		for(Barco barco : lista.getLista()) {
			
			for(int i=0; i<barco.getPosicion().length; i++) {
				
				if (barco.getPosicion()[i].getLetra().equals(casilla.getLetra())
						&& barco.getPosicion()[i].getNumero()==casilla.getNumero()) {
					
					impacto=true;				
				}				

			}
			
		}
		return impacto;
		
	}
	
	public static void mostrarDisparo(TableroDisparos tableroDisparos, Casilla casilla, boolean impacto) {
		
		int columna = ListaLetras.letras.indexOf(casilla.getLetra());
		int fila = casilla.getNumero()-1;
		
		Casilla[][] aux = tableroDisparos.getTableroDisparos();
		
		
		if (impacto) {aux[fila][columna].setImpacto(1);}
		else if (!impacto) {aux[fila][columna].setImpacto(2);}
		
		
		tableroDisparos.setTableroDisparos(aux);
		
		System.out.println(tableroDisparos);
		
		
	}

//-------------------desarrollo-----------------------//
	
	public static void dispararSalva( ListaBarcos lista, TableroDisparos tableroDisparos) {
		
		Casilla[][] aux = tableroDisparos.getTableroDisparos();
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				
				Casilla casilla = tableroDisparos.getTableroDisparos()[i][j];
				Boolean impacto = comprobarImpacto(casilla,lista);
				
				int columna = ListaLetras.letras.indexOf(casilla.getLetra());
				int fila = casilla.getNumero();
				
				
				
				
				if (impacto) {aux[fila][columna].setImpacto(2);}
				else if (!impacto) {aux[fila][columna].setImpacto(1);}	
				
			}
		}
		tableroDisparos.setTableroDisparos(aux);
		System.out.println(tableroDisparos);
	}

}


