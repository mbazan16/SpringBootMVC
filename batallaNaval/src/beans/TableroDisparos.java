package beans;

import coordenadas.ListaLetras;

public class TableroDisparos {
	private Casilla[][] tableroDisparos;
	
	public TableroDisparos() {
		this.tableroDisparos = new Casilla[10][10];
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
				fila=fila+tableroDisparos[i][j];							
			}
			matriz = matriz +"\n\n" +fila;
		}
		String tablero = letras  +matriz;
		return tablero;
	}
	
	
	public Casilla[][] getTableroDisparos() {
		return tableroDisparos;
	}

	public void setTableroDisparos(Casilla[][] tableroDisparos) {
		this.tableroDisparos = tableroDisparos;
	}

	
	//------------para desarrollo ---------------------//
	
	public void rellenarTablero() {
		Casilla aux;
		String letra;
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				letra = ListaLetras.letras.substring(i,i+1);
				aux = new Casilla(letra,i);
				this.tableroDisparos[i][j]=aux;
				
			}
		}
		
	}

}
