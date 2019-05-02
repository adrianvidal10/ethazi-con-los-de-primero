package modelo;

public class Hotel extends Ostatua {

	private int izarrak;

	public int getIzarrak() {
		return izarrak;
	}

	public void setIzarrak(int izarrak) {
		this.izarrak = izarrak;
	}

	public Hotel(int kod, String izena, String herria, double tarifa, int ostGelaKode, int erreserbaKopurua,
			int ostAltzariKod, String gosaria, boolean wifi, boolean igerileku, boolean spa, boolean parkin,
			boolean aire_girotua, boolean jatetxe, boolean taberna, boolean gimnasioa, String ostMota, int izarrak) {
		super(kod, izena, herria, tarifa, ostGelaKode, erreserbaKopurua, ostAltzariKod, gosaria, wifi, igerileku, spa,
				parkin, aire_girotua, jatetxe, taberna, gimnasioa, ostMota);
		this.izarrak = izarrak;
	}

	public Hotel() {

	}

}
