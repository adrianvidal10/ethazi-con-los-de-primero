package modelo;
//
public class Hotela {
	private Konexioa kon = new Konexioa();
	private String izena, herria;
	private int kodigoa, izarrak;
	private double prezioa;

	public Hotela(String izena, String herria, int kodigoa, int izarrak, int prezioa) {
		super();
		this.izena = izena;
		this.herria = herria;
		this.kodigoa = kodigoa;
		this.izarrak = izarrak;
		this.prezioa = prezioa;
	}

	public Hotela() {
	}
	
	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getHerria() {
		return herria;
	}

	public void setHerria(String herria) {
		this.herria = herria;
	}

	public int getKodigoa() {
		return kodigoa;
	}

	public void setKodigoa(int kodigoa) {
		this.kodigoa = kodigoa;
	}

	public int getIzarrak() {
		return izarrak;
	}

	public void setIzarrak(int izarrak) {
		this.izarrak = izarrak;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	@Override
	public String toString() {
		return "Hotela " + kodigoa + "Izena: " + izena + ", herria=" + herria + ", izarrak=" + izarrak + ", prezioa="
				+ prezioa;
	}
	
	

}
