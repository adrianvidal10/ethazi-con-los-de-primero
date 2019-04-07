package modelo;

public class SQLException extends Exception{

	public SQLException() {
		super("Errorea Datu Basearekin konektatzerakoan.");
	}
	
	public String getMessege() {
		return "Ez da aurkitu, 'ClassPath'-a.";
	}
}
