package controlador;

public class Reserva {
	String hotelIzena = "hotel1";
	String nork = "pepito";
	double prezioa = 0;
	String erreserbaHasiera = "";
	String erreserbaAmaiera = "";
	
	public String getHotelIzena() {
		
		return hotelIzena;
	}

	public String getNork() {
		
		return nork;
	}

	public double getPrezioa() {
		
		return prezioa;
	}

	public void setHotelIzena(String hotelIzena) {
		this.hotelIzena = hotelIzena;
	}

	public void setNork(String nork) {
		this.nork = nork;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public String getErreserbaHasiera() {
		return erreserbaHasiera;
	}

	public String getErreserbaAmaiera() {
		return erreserbaAmaiera;
	}

	public void setErreserbaHasiera(String erreserbaHasiera) {
		this.erreserbaHasiera = erreserbaHasiera;
	}

	public void setErreserbaAmaiera(String erreserbaAmaiera) {
		this.erreserbaAmaiera = erreserbaAmaiera;
	}
	
	public Reserva() {
		
	}

}
