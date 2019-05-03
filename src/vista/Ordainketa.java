package vista;

import java.awt.*;
import javax.swing.JOptionPane;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import controlador.*;

public class Ordainketa extends JFrame {

	private JButton baieztatu_botoia = new JButton("Sartu dirua");
	private JButton ordaindu_Botoia = new JButton("Ordaindu");
	private JButton btnAurrera;
	private String zenbaki1 = "1";
	private String zenbaki2 = "2";
	private String zenbaki3 = "3";
	private String zenbaki4 = "4";
	private String zenbaki5 = "5";
	private String zenbaki6 = "6";
	private String zenbaki7 = "7";
	private String zenbaki8 = "8";
	private String zenbaki9 = "9";
	private String prezioa;
	private String zenbaki0 = "0";
	private String zenbakikoma = ".";
	private String totala = "";
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Koordinatzailea micoordinador;
	private JTextField textField_2;

	public Ordainketa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextPane txtpnDiruaSartuMesedez = new JTextPane();
		txtpnDiruaSartuMesedez.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 11));
		txtpnDiruaSartuMesedez.setBackground(SystemColor.scrollbar);
		txtpnDiruaSartuMesedez.setText("DIRUA SARTU, MESEDEZ");
		txtpnDiruaSartuMesedez.setBounds(167, 11, 126, 20);
		getContentPane().add(txtpnDiruaSartuMesedez);

		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totala += zenbaki1;
				textField_1.setText(totala);
			}
		});

		button.setBackground(SystemColor.scrollbar);
		button.setBounds(106, 88, 73, 23);
		getContentPane().add(button);

		JButton button_1 = new JButton("4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totala += zenbaki4;
				textField_1.setText(totala);
			}
		});

		button_1.setBackground(SystemColor.scrollbar);
		button.setBackground(SystemColor.scrollbar);
		button_1.setBounds(106, 122, 73, 23);
		getContentPane().add(button_1);

		JButton button_2 = new JButton("7");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totala += zenbaki7;
				textField_1.setText(totala);
			}
		});

		button_2.setBackground(SystemColor.scrollbar);
		button.setBackground(SystemColor.scrollbar);
		button_2.setBounds(106, 156, 73, 23);
		getContentPane().add(button_2);

		JButton button_3 = new JButton("8");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totala += zenbaki8;
				textField_1.setText(totala);
			}
		});

		button_3.setBackground(SystemColor.scrollbar);
		button.setBackground(SystemColor.scrollbar);
		button_3.setBounds(189, 156, 73, 23);
		getContentPane().add(button_3);

		JButton button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totala += zenbaki5;
				textField_1.setText(totala);
			}
		});

		button_4.setBackground(SystemColor.scrollbar);
		button.setBackground(SystemColor.scrollbar);
		button_4.setBounds(189, 122, 73, 23);
		getContentPane().add(button_4);

		JButton button_5 = new JButton("2");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totala += zenbaki2;
				textField_1.setText(totala);
			}
		});

		button_5.setBackground(SystemColor.scrollbar);
		button.setBackground(SystemColor.scrollbar);
		button_5.setBounds(189, 88, 73, 23);
		getContentPane().add(button_5);

		JButton button_6 = new JButton("3");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totala += zenbaki3;
				textField_1.setText(totala);
			}
		});

		button_6.setBackground(SystemColor.scrollbar);
		button.setBackground(SystemColor.scrollbar);
		button_6.setBounds(272, 88, 73, 23);
		getContentPane().add(button_6);

		JButton button_7 = new JButton("6");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totala += zenbaki6;
				textField_1.setText(totala);
			}
		});

		button_7.setBackground(SystemColor.scrollbar);
		button.setBackground(SystemColor.scrollbar);
		button_7.setBounds(272, 122, 73, 23);
		getContentPane().add(button_7);

		JButton button_8 = new JButton("9");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totala += zenbaki9;
				textField_1.setText(totala);
			}
		});

		button_8.setBackground(SystemColor.scrollbar);
		button.setBackground(SystemColor.scrollbar);
		button_8.setBounds(272, 156, 73, 23);
		getContentPane().add(button_8);

		JButton button_9 = new JButton("0");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totala += zenbaki0;
				textField_1.setText(totala);
			}
		});

		button_9.setBackground(SystemColor.scrollbar);
		button.setBackground(SystemColor.scrollbar);
		button_9.setBounds(189, 190, 73, 23);
		getContentPane().add(button_9);

		JTextPane txtpnDiruTotala = new JTextPane();
		txtpnDiruTotala.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 11));
		txtpnDiruTotala.setBackground(SystemColor.scrollbar);
		txtpnDiruTotala.setText("Diru totala:");
		txtpnDiruTotala.setBounds(10, 37, 59, 35);
		getContentPane().add(txtpnDiruTotala);

		JTextPane txtpnbezarekin = new JTextPane();
		txtpnbezarekin.setBackground(SystemColor.scrollbar);
		txtpnbezarekin.setText("(BEZ-arekin)");
		txtpnbezarekin.setBounds(10, 69, 66, 23);
		getContentPane().add(txtpnbezarekin);

		JTextPane txtpnZureDirua = new JTextPane();
		txtpnZureDirua.setText("Zure dirua:");
		txtpnZureDirua.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtpnZureDirua.setBackground(SystemColor.scrollbar);
		txtpnZureDirua.setBounds(222, 42, 59, 20);
		getContentPane().add(txtpnZureDirua);

		JButton button_10 = new JButton(",");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totala += zenbakikoma;
			}
		});

		button_10.setBackground(SystemColor.scrollbar);
		button_10.setBounds(272, 190, 73, 23);
		getContentPane().add(button_10);

		JButton button_11 = new JButton("C");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totala += "";
				textField_1.setText("");

			}
		});

		button_11.setBackground(SystemColor.scrollbar);
		button_11.setBounds(106, 190, 73, 23);
		getContentPane().add(button_11);

		baieztatu_botoia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double guztira = 0;
				try {
					guztira = micoordinador.borobilduDirua(Double.parseDouble(totala));
					textField_1.setText(String.valueOf(guztira));
					ordaindu_Botoia.setEnabled(true);
				} catch (Exception e2) {
					e2.getMessage();
					e2.printStackTrace();
				}
				// textField_1.setText(String.valueOf(guztira));
				// ordaindu_Botoia.setEnabled(true);
			}
		});

		// Baieztatu botoia sistema sartzen du dirua.
		baieztatu_botoia.setFont(new Font("Tahoma", Font.PLAIN, 7));

		baieztatu_botoia.setBounds(368, 167, 72, 46);
		getContentPane().add(baieztatu_botoia);

		/*
		 * Ordaindu botoia sakatzean gorde dirua hasieratzen da eta 0 zenbaki positiboa
		 * edo kenketaren balioa ematen du, >=0 bada Joption pane bat aterako da eta
		 * aurrera joateko aukera izango dugu.
		 */

		ordaindu_Botoia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordainketaKudeatu();
				ordaindu_Botoia.setEnabled(false);
				textField_1.setText("");
				totala = "";
			}
		});

		ordaindu_Botoia.setBounds(130, 270, 275, 68);
		getContentPane().add(ordaindu_Botoia);
		ordaindu_Botoia.setEnabled(false);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(79, 37, 100, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(304, 37, 100, 35);
		contentPane.add(textField_1);

		btnAurrera = new JButton("Aurrera");
		btnAurrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.CrearFicheroReserva.sortuFitxeroa();
				JOptionPane.showMessageDialog(null, "Faktura sortuta", "Mensaje Informativo",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnAurrera.setEnabled(false);

		/*
		 * btnAurrera.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { micoordinador.agurPantaila(); } });
		 */

		btnAurrera.setEnabled(false);
		btnAurrera.setBounds(130, 406, 275, 68);
		contentPane.add(btnAurrera);

		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setEnabled(false);
		textField_2.setBounds(106, 227, 267, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				micoordinador.mostrarPantailaDatuakErakutsi();
			}
		});
		btnAtzera.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtzera);
	}

	public void setcoordinador(Koordinatzailea micoordinador) {
		this.micoordinador = micoordinador;
	}

	/**
	 * String bat hartuz TextField-an esertzen du.
	 * 
	 * @param dirua
	 */
	public void bidalidirua(String dirua) {
		textField.setText(dirua);
	}

	public String deuda() {
		return textField.getText();
	}

	/**
	 * String bat hartuz TextField-an esertzen du.
	 * 
	 * @return
	 */
	public String ordaindu() {
		return textField_1.getText();
	}

	/**
	 * Botoia erebilgarri ezina egiten du pantailaratu gabe.
	 */
	public void botoiaDesaktibatu() {
		ordaindu_Botoia.setEnabled(false);
	}

	/**
	 * String bat hartuz TextField-an esertzen du.
	 * 
	 * @param dirua
	 */
	public void setOrdainketa(String dirua) {
		textField.setText(dirua);
	}

	/**
	 * Botoia erebilgarri ezina egiten du pantailaratu gabe.
	 */
	public void botoiaDesaktibatu2() {
		btnAurrera.setEnabled(true);
	}

	/**
	 * Metodo honek sartutako diruaren kenketa egiten du. Gero bidaltzen du return
	 * baten bidez.
	 * 
	 * @param zenbaki1
	 * @param zenbaki2
	 * @return
	 */
	public double kenketa_dirua(double zenbaki1, double zenbaki2) {
		double kenketa = 0.0;
		System.out.println(zenbaki1);
		System.out.println(zenbaki2);
		double kenketa1 = 0.0;
		if (zenbaki1 == zenbaki2) {
			System.out.println("tonto");
			kenketa = 0.0;

		} else {
			kenketa = zenbaki1 - zenbaki2;
			System.out.println(kenketa);
			kenketa1 = micoordinador.borobilduDirua(Math.abs(kenketa));
			System.out.println(kenketa1);

			if (kenketa < 0) {
				kenketa = -kenketa1;
				textField_1.setText(String.valueOf(0.0));

			}

			else if (kenketa > 0) {
				kenketa = kenketa1;
			}

		}
		return kenketa;

	}

	/**
	 * Metodo honek ordainketa prozesuaren kudeaketa egiten du.
	 */
	public void ordainketaKudeatu() {
		String dirua;
		String ordainketa;
		double dirua1;
		double ordainketa1;
		double kenketa;
		dirua = deuda();
		ordainketa = ordaindu();
		dirua1 = Double.parseDouble(dirua);
		ordainketa1 = Double.parseDouble(ordainketa);
		kenketa = kenketa_dirua(dirua1, ordainketa1);

		System.out.println(kenketa);
		if (kenketa == 0.0) {
			btnAurrera.setEnabled(true);
			textField.setText("0.00");

		}
		if (kenketa < 0) {
			textField_2.setText("Itzulerak: " + Math.abs(kenketa));
			btnAurrera.setEnabled(true);
		}
		if (kenketa > 0) {
			kenketa = Math.abs(kenketa);
			textField.setText(String.valueOf(kenketa));
		}

	}

	public void setPrezioa(String prezioa) {
		textField.setText(prezioa);
	}
}
