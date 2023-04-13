package beans;

import java.util.List;

import coordenadas.ListaLetras;

public class TableroBarcos extends Tablero {
	
	List Barcos;
	Casilla[][] tableroBarcos;
	
	public TableroBarcos() {
		this.tableroBarcos=new Casilla[10][10];
		rellenarTablero();
	}
	
	public String toString() {
		String fila="";
		int numeroFila;
		String matriz="";
		String letras="   .a. .b. .c. .d. .e. .f. .g. .h. .i. .j.";
		
		for(int i=0; i<10; i++) {
			numeroFila = i+1;
			if (numeroFila!=10) {fila=numeroFila +" ";}
			else {fila=numeroFila+"";}
			
			for(int j=0; j<10; j++) {
				fila=fila+tableroBarcos[i][j];							
			}
			matriz = matriz +"\n\n" +fila;
		}
		String tablero = letras  +matriz;
		return tablero;
	}
	
	public void rellenarTablero() {
		Casilla aux;
		String letra;
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				letra = ListaLetras.letras.substring(i,i+1);
				aux = new Casilla(letra,i);
				this.tableroBarcos[i][j]=aux;
				
			}
		}
		
	}
	
	
	public void comprobarBarcos(ListaBarcos listaBarcos) {
		
		
		for(Barco barco:listaBarcos.getLista()) {
			for (int i=0; i<barco.getPosicion().length; i++) {
				
			}
		
		}
	
		
		
	}

	public List getBarcos() {
		return Barcos;
	}

	public void setBarcos(List barcos) {
		Barcos = barcos;
	}

	public Casilla[][] getTableroBarcos() {
		return tableroBarcos;
	}

	public void setTableroBarcos(Casilla[][] tableroBarcos) {
		this.tableroBarcos = tableroBarcos;
	}
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
