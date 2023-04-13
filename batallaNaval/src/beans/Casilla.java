package beans;

public class Casilla {
	
	private String letra;
	private int numero;
	private int impacto;//0(nada), 1(impacto en agua), 2(impacto en barco)
	private String marcador;
	
	
	public Casilla(String letra, int numero) {
		this.letra=letra;
		this.numero=numero;
		this.impacto=0;
	}
	public Casilla() {
		
		this.impacto=0;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public int getImpacto() {
		return impacto;
	}

	public void setImpacto(int impacto) {
		this.impacto = impacto;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	
	
	public String getMarcador() {
		return marcador;
	}

	public void setMarcador(String marcador) {
		this.marcador = marcador;
	}

	public String toString() {
		
		String representacion=" |_|";
		
		if (this.impacto==0) {representacion = " |_|";}
		else if (this.impacto==1) {representacion = " |O|";}
		else if (this.impacto==2) {representacion = " |X|";}
		
		if (marcador!=null) {representacion = " |" +marcador +"|";}
		
		return representacion;
		
	}
	
}
