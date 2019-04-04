package controlador;

import vista.*;

public class Main {

	// Atributuak:
	private LoginPantaila PantailaLogin;
	private Ordainketa PantailaOrdainketa;
	private Koordinatzailea micoordinador;
	
	public static void main(String[] args) {
		//Modelo.BD konek = new Modelo.BD();
		Main miprincipal = new Main();
		miprincipal.iniciar();
		
		Kontsultak kon = new Kontsultak();
		DatuakErakutsi pantalla = new DatuakErakutsi();
		pantalla.setVisible(true);
		
	}

	private void iniciar() {
		
		PantailaLogin = new LoginPantaila();
		PantailaOrdainketa=new Ordainketa();

		micoordinador= new Koordinatzailea();
		
		/*Se establecen las relaciones entre clases*/
		PantailaLogin.setcoordinador(micoordinador);
		PantailaOrdainketa.setcoordinador(micoordinador);

		/*Se establecen relaciones con la clase coordinador*/
		micoordinador.setMiVentanaRegistro(PantailaLogin);
		micoordinador.setordainketa(PantailaOrdainketa);
	
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
