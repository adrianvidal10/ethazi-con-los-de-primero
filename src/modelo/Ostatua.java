package modelo;

public class Ostatua {
	protected int kod;
	protected String izena;
	protected String herria;
	protected double tarifa;
	protected int ostGelaKode;
	protected int erreserbaKopurua;
	protected int ostAltzariKod;
	protected String gosaria;
	protected boolean wifi;
	protected boolean igerileku;
	protected boolean spa;
	protected boolean parkin;
	protected boolean aire_girotua;
	protected boolean jatetxe;
	protected boolean taberna;
	protected boolean gimnasioa;
	protected String ostMota;
	
	public Ostatua() {
	}
	
	public Ostatua(int kod, String izena, String herria, double tarifa, int ostGelaKode, int erreserbaKopurua,
			int ostAltzariKod, String gosaria, boolean wifi, boolean igerileku, boolean spa, boolean parkin,
			boolean aire_girotua, boolean jatetxe, boolean taberna, boolean gimnasioa, String ostMota) {
		this.kod = kod;
		this.izena = izena;
		this.herria = herria;
		this.tarifa = tarifa;
		this.ostGelaKode = ostGelaKode;
		this.erreserbaKopurua = erreserbaKopurua;
		this.ostAltzariKod = ostAltzariKod;
		this.gosaria = gosaria;
		this.wifi = wifi;
		this.igerileku = igerileku;
		this.spa = spa;
		this.parkin = parkin;
		this.aire_girotua = aire_girotua;
		this.jatetxe = jatetxe;
		this.taberna = taberna;
		this.gimnasioa = gimnasioa;
		this.ostMota = ostMota;
	}

	public int getKod() {
		return kod;
	}

	public String getIzena() {
		return izena;
	}

	public String getHerria() {
		return herria;
	}

	public double getTarifa() {
		return tarifa;
	}

	public int getOstGelaKode() {
		return ostGelaKode;
	}

	public int getErreserbaKopurua() {
		return erreserbaKopurua;
	}

	public int getOstAltzariKod() {
		return ostAltzariKod;
	}

	public String getGosaria() {
		return gosaria;
	}

	public boolean isWifi() {
		return wifi;
	}

	public boolean isIgerileku() {
		return igerileku;
	}

	public boolean isSpa() {
		return spa;
	}

	public boolean isParkin() {
		return parkin;
	}

	public boolean isAire_girotua() {
		return aire_girotua;
	}

	public boolean isJatetxe() {
		return jatetxe;
	}

	public boolean isTaberna() {
		return taberna;
	}

	public boolean isGimnasioa() {
		return gimnasioa;
	}

	public String getOstMota() {
		return ostMota;
	}

	public void setKod(int kod) {
		this.kod = kod;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public void setHerria(String herria) {
		this.herria = herria;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public void setOstGelaKode(int ostGelaKode) {
		this.ostGelaKode = ostGelaKode;
	}

	public void setErreserbaKopurua(int erreserbaKopurua) {
		this.erreserbaKopurua = erreserbaKopurua;
	}

	public void setOstAltzariKod(int ostAltzariKod) {
		this.ostAltzariKod = ostAltzariKod;
	}

	public void setGosaria(String gosaria) {
		this.gosaria = gosaria;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public void setIgerileku(boolean igerileku) {
		this.igerileku = igerileku;
	}

	public void setSpa(boolean spa) {
		this.spa = spa;
	}

	public void setParkin(boolean parkin) {
		this.parkin = parkin;
	}

	public void setAire_girotua(boolean aire_girotua) {
		this.aire_girotua = aire_girotua;
	}

	public void setJatetxe(boolean jatetxe) {
		this.jatetxe = jatetxe;
	}

	public void setTaberna(boolean taberna) {
		this.taberna = taberna;
	}

	public void setGimnasioa(boolean gimnasioa) {
		this.gimnasioa = gimnasioa;
	}

	public void setOstMota(String ostMota) {
		this.ostMota = ostMota;
	}

	
	
	
	
}
