package vista;

//
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controlador.Koordinatzailea;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class ErregistruPantaila extends JFrame {
	/**
	 * LOGUEATU Jframe-aren bariableak dira.
	 */
	private JButton btnKonprobatuParametroak;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private Koordinatzailea micoordinador;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_6;
	private JButton btnLogin;
	private String izena;
	private String data;
	private JLabel lblNewLabel_9;
	private JLabel lblErregistratu;
	private JTextField textField_3;
	private JLabel lblBiAbizena;
	private JTextField textField_4;
	private JLabel lblNewLabel;
	private JLabel lblIzena;
	private JLabel lblAbizena, lblAbizenaBi, lblNewLabel_1, lblNickname, lblPasahitza;

	/**
	 * LOGUEATU Jframe-aren kodea da.
	 */
	public ErregistruPantaila() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Nan:");
		lblNewLabel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(78, 128, 58, 20);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Source Sans Pro Black", Font.ITALIC, 13));

		textField.setBounds(131, 128, 254, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblIzena = new JLabel("Izena:");
		lblIzena.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 15));
		lblIzena.setBounds(64, 221, 58, 17);
		contentPane.add(lblIzena);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Source Sans Pro Black", Font.BOLD | Font.ITALIC, 13));
		izena = textField_1.getText();
		textField_1.setColumns(10);
		textField_1.setBounds(131, 220, 254, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(131, 276, 254, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(131, 336, 254, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		lblAbizena = new JLabel("Lehen Abizena:");
		lblAbizena.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 15));
		lblAbizena.setBounds(11, 277, 116, 20);
		contentPane.add(lblAbizena);

		lblAbizenaBi = new JLabel("Bigarren Abizena:");
		lblAbizenaBi.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 15));
		lblAbizenaBi.setBounds(10, 337, 136, 19);
		contentPane.add(lblAbizenaBi);

		lblNewLabel_1 = new JLabel("Pasahitza:");
		lblNewLabel_1.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(36, 393, 81, 17);
		contentPane.add(lblNewLabel_1);

		lblNickname = new JLabel("Nickname:");
		lblNickname.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNickname.setBounds(50, 185, 86, 14);
		contentPane.add(lblNickname);

		lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 15));
		lblPasahitza.setBounds(36, 442, 81, 17);
		contentPane.add(lblPasahitza);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Source Sans Pro Black", Font.BOLD, 15));
		btnLogin.setEnabled(false);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * Bezeroa bezeroa = new Bezeroa(textField.getText() +
				 * textField_5.getText().toUpperCase(), textField_1.getText(),
				 * textField_2.getText(), data, textField_3.getText().toUpperCase(),
				 * getMD5(passwordField.getText()));
				 */
				// Bezeroa.txertatuBezeroa(bezeroa);
				micoordinador.mostrarVentanaLogin();

			}
		});
		btnLogin.setBounds(398, 495, 89, 23);
		contentPane.add(btnLogin);

		JButton btnKonprobatuParametroak = new JButton("Konprobatu \r\n\r\n");
		btnKonprobatuParametroak.setFont(new Font("Dialog", Font.BOLD, 15));
		btnKonprobatuParametroak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				micoordinador.balidatuInsert(textField.getText(), textField_5.getText(), textField_1.getText(),
						textField_2.getText(), textField_3.getText(), passwordField.getText(),
						passwordField_1.getText(), textField_4.getText());
			}
		});
		btnKonprobatuParametroak.setBounds(212, 495, 131, 23);
		contentPane.add(btnKonprobatuParametroak);

		JLabel lblLetra = new JLabel("Letra:");
		lblLetra.setBounds(397, 130, 63, 17);
		contentPane.add(lblLetra);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Source Sans Pro Black", Font.ITALIC, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(472, 128, 35, 20);
		contentPane.add(textField_5);

		lblBiAbizena = new JLabel("");
		lblBiAbizena.setBounds(131, 367, 254, 14);
		contentPane.add(lblBiAbizena);

		lblNewLabel_2 = new JLabel("");

		lblNewLabel_2.setBounds(131, 153, 254, 20);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(397, 153, 110, 14);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(131, 251, 254, 14);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(150, 307, 190, 14);
		contentPane.add(lblNewLabel_5);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Source Sans Pro Black", Font.BOLD, 13));
		passwordField.setBounds(125, 392, 254, 20);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Source Sans Pro Black", Font.BOLD, 13));
		passwordField_1.setBounds(125, 440, 254, 20);
		contentPane.add(passwordField_1);

		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(125, 415, 254, 14);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(114, 470, 329, 14);
		contentPane.add(lblNewLabel_9);

		lblErregistratu = new JLabel("ERREGISTRATU");
		lblErregistratu.setFont(new Font("Source Sans Pro Black", Font.BOLD | Font.ITALIC, 40));
		lblErregistratu.setBounds(157, 26, 304, 79);
		contentPane.add(lblErregistratu);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				micoordinador.logueatzekoBotoiak();
			}
		});
		btnAtzera.setFont(new Font("Dialog", Font.BOLD, 15));
		btnAtzera.setBounds(97, 497, 89, 23);
		contentPane.add(btnAtzera);

		textField_4 = new JTextField();
		textField_4.setBounds(131, 184, 254, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}

	/**
	 * Nan-a bidaltzen du return baten bidez. Nan-a Arraylist baten konposatutua
	 * dago.
	 * 
	 * @return
	 */
	public ArrayList<String> balidatudni() {
		ArrayList<String> nan = new ArrayList<>();
		nan.add(textField.getText());
		nan.add(textField_5.getText());
		return nan;
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
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @param katea
	 */
	public void erakutsiErrorea(String katea) {
		lblNewLabel_2.setText(katea);
	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @param katea
	 */
	public void erakutsiErrorea2(String katea) {
		lblNewLabel_3.setText(katea);
	}

	/**
	 * TetxField-en informazioa hartu eta return baten bidez bidaltzen du.
	 * 
	 * @return
	 */
	public String balidatuIzena() {
		izena = textField_1.getText();
		return izena;
	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @param katea
	 */
	public void erakutsiErrorea3(String katea) {
		lblNewLabel_4.setText(katea);
	}

	/**
	 * TetxField-en informazioa hartu eta return baten bidez bidaltzen du.
	 * 
	 * @return
	 */
	public String balidatuAbizena() {
		String abizena = textField_2.getText();
		return abizena;
	}

	public String balidatuAbizenaBi() {
		String abizena = textField_3.getText();
		return abizena;
	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @param katea
	 */
	public void erakutsiErrorea4(String katea) {
		lblNewLabel_5.setText(katea);
	}

	public void erakutsiErrorea6(String katea) {
		lblBiAbizena.setText(katea);
	}

	/**
	 * Pasahitza bidaltzen du return baten bidez. Pasahitza Arraylist baten
	 * konposatutua dago.
	 * 
	 * @return
	 */
	public ArrayList<String> balidatuPasahitza() {
		String passwd1 = "";
		String passwd2 = "";
		ArrayList<String> pasahitzak = new ArrayList<String>();
		passwd1 = passwordField.getText();
		passwd2 = passwordField_1.getText();
		pasahitzak.add(passwd1);
		pasahitzak.add(passwd2);
		return pasahitzak;

	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @param katea
	 */
	public void erakutsiErrorea5(String katea) {
		lblNewLabel_6.setText(katea);
	}

	/**
	 * Login egiteko botoia pantailaratzen du, horrela erabilgarria egiteko.
	 */
	public void erakutsiBotoia() {
		btnLogin.setEnabled(true);
	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @param katea
	 */
	public void balidatuLogina(String textua) {
		lblNewLabel_9.setText(textua);
	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @param katea
	 */
	public void youshouldpass() {
		btnLogin.setEnabled(true);
	}

	public String getNick() {
		return textField_4.getText();
	}

	/**
	 * String bat hartzen du eta katea MD5-ekin enkriptatzen du.
	 * 
	 * @param input
	 * @return
	 */
	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
