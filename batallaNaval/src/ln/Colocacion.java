package ln;

import java.util.Scanner;

import beans.Acorazado;
import beans.Barco;
import beans.Casilla;
import beans.ListaBarcos;
import beans.Submarino;
import beans.TableroBarcos;
import coordenadas.ListaLetras;

public class Colocacion {
	
	public static Casilla selectCasillaDesde(Scanner sc) {
		
		sc.nextLine();
		
		System.out.println("Coordenadas casilla inicio (letra) :");
		String letra = sc.nextLine();
		
		
		
		System.out.println("Coordenadas casilla inicio (numero) :");
		int numero = sc.nextInt();
		
		Casilla casillaInicio = new Casilla(letra,numero);
		
		return casillaInicio;
		
	}
	
	public static Casilla selectCasillaHasta(Scanner sc) {
		
		sc.nextLine();
		
		System.out.println("Coordenadas casilla fin (letra) :");
		String letra = sc.nextLine();
		System.out.println("Coordenadas casilla fin (numero) :");
		int numero = sc.nextInt();
		
		Casilla casillaFin = new Casilla(letra,numero);
		return casillaFin;
		
	}
	
	public static Barco seleccionarBarco(Scanner sc, ListaBarcos lista) {
		Barco barco;
		
		System.out.println("Selecciona un barco a colocar (por numero): ");
		
		for(Barco nave:lista.getLista()) {
			System.out.print(lista.getLista().indexOf(nave) +" - ");
			System.out.println(nave);
		}
		
		int numeroBarco=sc.nextInt();
		barco = lista.getLista().get(numeroBarco);
		
//		switch(numeroBarco) {
//		
//		case 1:
//			barco=lista.getLista().get(numeroBarco);
//			break;
//		case 2:
//			barco=new Submarino();
//			break;
//		default:
//			barco=new Acorazado();		
//		}		
		return barco;
	}
	
	public static void colocarBarco(Scanner sc, ListaBarcos lista) {
		
		Barco barco = seleccionarBarco(sc,lista);
		Casilla casillaDesde = selectCasillaDesde(sc);
		Casilla casillaHasta = selectCasillaHasta(sc);
		
		//colocar (que sera asignar ciertas casillas a las casillas de ese barco)
		
		
		if(casillaDesde.getLetra().equals(casillaHasta.getLetra())) {
			colocarEnVertical(barco,casillaDesde);
		}
		else if(casillaDesde.getNumero()==(casillaHasta.getNumero())) {
			colocarEnHorizontal(barco,casillaDesde,casillaHasta);
		}
		quitarBarcoDeLista(lista.getLista().indexOf(barco),lista);
		
	
	}
	
	public static void colocarEnVertical(Barco barco, Casilla casillaDesde) {
		
		Casilla[] aux = new Casilla[barco.getPosicion().length];
		
		for (int i=0; i<barco.getPosicion().length; i++) {
			
			aux[i]=new Casilla(casillaDesde.getLetra(), casillaDesde.getNumero()+i);
			
		}
		
		barco.setPosicion(aux);
		

	}
	
	public static void colocarEnHorizontal(Barco barco, Casilla casillaDesde, Casilla casillaHasta) {
		
		Casilla[] aux = new Casilla[barco.getPosicion().length];
		String letra = casillaDesde.getLetra();
		int posicionDeLaLetra = ListaLetras.letras.indexOf(letra);
		
		//este for va recorriendo la lista de letras
		for (int i=posicionDeLaLetra; i<ListaLetras.letras.indexOf(letra)+barco.getPosicion().length; i++) {
			
			aux[i-posicionDeLaLetra]=new Casilla(ListaLetras.letras.substring(i, i+1), casillaDesde.getNumero());
			
		}
		barco.setPosicion(aux);
		
		for (int i=0; i<barco.getPosicion().length; i++) {
			System.out.print(barco.getPosicion()[i] +" ");
		}
		
	}

	public static void quitarBarcoDeLista(int numeroBarco, ListaBarcos lista) {		
		 lista.getLista().remove(numeroBarco);
	}
	
	public static void marcarBarcoEnTablero(Barco barco, TableroBarcos tableroBarcos) {
		Casilla[][] tableroAux = tableroBarcos.getTableroBarcos();
		for (int i=0; i<barco.getPosicion().length; i++) {
			
			String letra = barco.getPosicion()[i].getLetra();
			int numero = barco.getPosicion()[i].getNumero();
			
			tableroAux[numero][ListaLetras.letras.indexOf(letra)].setMarcador(barco.getMarcador());
			
			tableroBarcos.setTableroBarcos(tableroAux);
		}
		
	}

	
	
	
	
	
	
	//----------------------Para desarrollo ------------------------------//
	
	public static void autoRellenar(ListaBarcos lista) {
		
		autoColocar (autoBarco(lista,0),autoSelect("a",1));
		autoColocar (autoBarco(lista,1),autoSelect("c",1));
		autoColocar (autoBarco(lista,2),autoSelect("e",1));
			
	}
	
	public static Casilla autoSelect(String letra, int numero) {
		Casilla casillaInicio = new Casilla(letra,numero);		
		return casillaInicio;
		
	}

	public static Barco autoBarco(ListaBarcos lista, int numeroBarco) {
		
		return lista.getLista().get(numeroBarco);
		
	}
	
	public static void autoColocar(Barco barco, Casilla casilla) {
		colocarEnVertical(barco, casilla);
		
	}
	
	
}
