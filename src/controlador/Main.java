package controlador;
//A
import vista.*;

public class Main {

	// Atributuak :
	private LoginPantaila PantailaLogin;
	private Ordainketa PantailaOrdainketa;
	private Koordinatzailea micoordinador;
	private DatuakErakutsi PantailaDatuakErakutsi;
	private ErregistruPantaila PantailaErregistru;
	public static void main(String[] args) {
		//Modelo.BD konek = new Modelo.BD();
		Main miprincipal = new Main();
		miprincipal.iniciar();
		Kontsultak kon = new Kontsultak();	
	}

	private void iniciar() {
		
		PantailaLogin = new LoginPantaila();
		PantailaOrdainketa=new Ordainketa();
		PantailaDatuakErakutsi  = new DatuakErakutsi();
		PantailaErregistru  = new ErregistruPantaila();
		micoordinador= new Koordinatzailea();
		
		/*Se establecen las relaciones entre clases*/
		PantailaLogin.setcoordinador(micoordinador);
		PantailaOrdainketa.setcoordinador(micoordinador);
		PantailaDatuakErakutsi.setcoordinador(micoordinador);
		PantailaErregistru.setcoordinador(micoordinador);
		/*Se establecen relaciones con la clase coordinador*/
		micoordinador.setMiVentanaRegistro(PantailaLogin);
		micoordinador.setordainketa(PantailaOrdainketa);
		micoordinador.setDatuakErakutsi(PantailaDatuakErakutsi);
		micoordinador.setPantailaErregistru(PantailaErregistru);
		PantailaLogin.setVisible(true);
	}
	
	
	
	/*//Logineko pantailako datuak kudeatzen duen metodoa da hau
	public static boolean ateraErabiltzailea(String nan,String pasahitza) {
		boolean erabakia=false;
		
		ArrayList<Bezeroa> arraybezer= new ArrayList<Bezeroa>();
		arraybezer=Bezeroa.ateraErabiltzaileak();
		pasahitza=ateraMD5(pasahitza);
		for(Bezeroa p : arraybezer) {
			if (p.getDni().equals(nan) && p.getPasahitza().equals(pasahitza)) {
				erabakia=true;
				
			}
		}
		return(erabakia);
		
	}*/




}
