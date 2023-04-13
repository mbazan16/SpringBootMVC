package beans;

public class Submarino extends Barco {
	
	private Casilla[] posicion;
	private String marcador;
	
	public Submarino() {
		this.posicion = new Casilla[4];
		this.marcador="S";
	}
	
	public String getMarcador() {
		return marcador;
	}

	public void setMarcador(String marcador) {
		this.marcador = marcador;
	}

	public String toString() {
		return " submarino (4 casillas) ";
	}

	public Casilla[] getPosicion() {
		return posicion;
	}

	public void setPosicion(Casilla[] posicion) {
		this.posicion = posicion;
	}
	

}
