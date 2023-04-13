package beans;

import java.util.ArrayList;
import java.util.List;

public class ListaBarcos {
	
	List<Barco> lista;
	
	public ListaBarcos() {
		lista = new ArrayList<Barco>();
	}
		
	public void crearBarcos() {
		
		lista.add(new Acorazado());
		lista.add(new Submarino());
		lista.add(new Submarino());

		
	}

	public List<Barco> getLista() {
		return lista;
	}

	public void setLista(List<Barco> lista) {
		this.lista = lista;
	}
	
}
