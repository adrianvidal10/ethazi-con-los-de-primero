package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controlador.Koordinatzailea;

public class LoginPantaila extends JFrame {
	private JPanel contentPane;
	private Koordinatzailea micoordinador;
	private JPasswordField passwordField;
	private JTextField textField;
	private boolean youshouldnotpass;
	private String pasahitza;
	private String Nan;

	public LoginPantaila() {
		getContentPane().setBackground(UIManager.getColor("Button.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		getContentPane().setLayout(null);
		// Login textua.
		JLabel lbllogin = new JLabel("LOGIN");
		lbllogin.setFont(new Font("Arial Black", Font.PLAIN, 70));
		lbllogin.setBounds(157, 25, 248, 92);
		getContentPane().add(lbllogin);

		// PASAHITZAREN LETRAK ETA TEXTFIELD
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 30));
		lblPasahitza.setBounds(90, 210, 150, 32);
		getContentPane().add(lblPasahitza);
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Source Sans Pro Black", Font.ITALIC, 30));
		passwordField.setBounds(252, 210, 229, 32);
		getContentPane().add(passwordField);

		// ERABILTZAILEAREN LETRAK ETA TEXTFIEL
		JLabel lblErabiltzaile = new JLabel("Erabiltzaile:");
		lblErabiltzaile.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 30));
		lblErabiltzaile.setBounds(63, 155, 167, 26);
		getContentPane().add(lblErabiltzaile);

		textField = new JTextField();
		textField.setFont(new Font("Source Sans Pro Semibold", Font.ITALIC, 30));
		textField.setBounds(252, 152, 229, 32);
		getContentPane().add(textField);
		textField.setColumns(10);

		// SARTU BOTOIAREN KODEA
		JButton btnSartu = new JButton("SARTU");
		btnSartu.setFont(new Font("Source Sans Pro Semibold", Font.ITALIC, 15));
		btnSartu.setBounds(83, 282, 176, 32);
		getContentPane().add(btnSartu);

		JButton btnLogueatu = new JButton("LOGUEATU");
		btnLogueatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/// micoordinador.erakutsiLOGUEATU();
			}
		});
		btnLogueatu.setFont(new Font("Source Code Pro Black", Font.BOLD, 15));
		btnLogueatu.setBounds(309, 281, 176, 32);
		getContentPane().add(btnLogueatu);
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// botoiaren kodea
				System.out.println("LOGIN BOTOIA");
				micoordinador.mostrarVentanaOrdainketa();
				// logindatuak();
				// youshouldnotpass = Main.ateraErabiltzailea(Nan, pasahitza);
				/*if (youshouldnotpass == true) {
					// micoordinador.erakutsinirelerroak();

				}
				System.out.println(youshouldnotpass);*/
			}
		});
	}
	
	/**
	 * Eremuan jartzen diren datuak hartu eta bariableetan esertzen ditu.
	 */
	private void logindatuak() {
		pasahitza = new String(passwordField.getPassword());
		Nan = new String(textField.getText());
		System.out.println("pasahitza: " + pasahitza);
		System.out.println("erabiltzaile: " + Nan);
	}

	/**
	 * Koordinatzailearen setterra da, hau da eraldatzeko. Dena ondo koordinatzeko.
	 * 
	 * @param micoordinador
	 */
	public void setcoordinador(Koordinatzailea micoordinador) {
		this.micoordinador = micoordinador;
	}

	/**
	 * Return baten bide NaN-a bidaltzen du.
	 * @return
	 */
	public String bidaliNan() {
		return Nan;

	}
}
