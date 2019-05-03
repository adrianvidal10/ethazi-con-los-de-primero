package modelo;

public class Apartamentua extends Hotel {

	private int solairua;

	public int getSolairua() {
		return solairua;
	}

	public void setSolairua(int solairua) {
		this.solairua = solairua;
	}

	public Apartamentua(int kod, String izena, String herria, double tarifa, int ostGelaKode, int erreserbaKopurua,
			int ostAltzariKod, String gosaria, boolean wifi, boolean igerileku, boolean spa, boolean parkin,
			boolean aire_girotua, boolean jatetxe, boolean taberna, boolean gimnasioa, String ostMota, int izarrak,
			int solairua) {
		super(kod, izena, herria, tarifa, ostGelaKode, erreserbaKopurua, ostAltzariKod, gosaria, wifi, igerileku, spa,
				parkin, aire_girotua, jatetxe, taberna, gimnasioa, ostMota, izarrak);
		this.solairua = solairua;
	}

	public Apartamentua() {
	}

}
