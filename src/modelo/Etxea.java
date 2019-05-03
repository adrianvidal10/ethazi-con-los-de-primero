package modelo;

public class Etxea extends Ostatua {
	protected double mKarratuTot;
	protected int komun_kop;

	public Etxea() {
	}

	public Etxea(int kod, String izena, String herria, double tarifa, int ostGelaKode, int erreserbaKopurua,
			int ostAltzariKod, String gosaria, boolean wifi, boolean igerileku, boolean spa, boolean parkin,
			boolean aire_girotua, boolean jatetxe, boolean taberna, boolean gimnasioa, String ostMota,
			double mKarratuTot, int komun_kop) {
		super(kod, izena, herria, tarifa, ostGelaKode, erreserbaKopurua, ostAltzariKod, gosaria, wifi, igerileku, spa,
				parkin, aire_girotua, jatetxe, taberna, gimnasioa, ostMota);
		this.mKarratuTot = mKarratuTot;
		this.komun_kop = komun_kop;
	}

	public double getmKarratuTot() {
		return mKarratuTot;
	}

	public int getKomun_kop() {
		return komun_kop;
	}

	public void setmKarratuTot(double mKarratuTot) {
		this.mKarratuTot = mKarratuTot;
	}

	public void setKomun_kop(int komun_kop) {
		this.komun_kop = komun_kop;
	}

}
