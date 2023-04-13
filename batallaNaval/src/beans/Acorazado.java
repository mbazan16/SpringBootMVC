package beans;

public class Acorazado extends Barco{
	
	private Casilla[] posicion;
	private String marcador;
	
	public Acorazado() {
		this.posicion = new Casilla[5];
		this.marcador="A";
	}

	public Casilla[] getPosicion() {
		return posicion;
	}

	public void setPosicion(Casilla[] posicion) {
		this.posicion = posicion;
	}
	
	public String toString() {
		return " acorazado (5 casillas) ";
	}

	public String getMarcador() {
		return marcador;
	}

	public void setMarcador(String marcador) {
		this.marcador = marcador;
	}
	
}
