package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Kontsultak;
import controlador.Koordinatzailea;
import modelo.Hotela;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.TextArea;

public class DatuakErakutsi extends JFrame {
	private Koordinatzailea micoordinador;
	private static JTextField txbxHerria;
	private JButton btnBilatu, btnAtzera;
	private JLabel lblHerria;
	private JTextArea erakutsiEmaitza;
	private JPanel panel;
	static String herriaBilatu;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public DatuakErakutsi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);

		contentPane.setLayout(null);

		txbxHerria = new JTextField();
		txbxHerria.setBounds(103, 60, 195, 20);
		getContentPane().add(txbxHerria);
		txbxHerria.setColumns(10);

		lblHerria = new JLabel("Herria:");
		lblHerria.setBounds(29, 63, 46, 14);
		getContentPane().add(lblHerria);

		btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(24, 11, 82, 23);
		//getContentPane().add(btnAtzera);

		panel = new JPanel();
		panel.setBounds(0, 96, 435, 166);
		getContentPane().add(panel);
		panel.setLayout(null);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(418, 0, 17, 166);
		panel.add(scrollBar);

		erakutsiEmaitza = new JTextArea();
		erakutsiEmaitza.setBounds(12, 0, 396, 166);
		panel.add(erakutsiEmaitza);

		btnBilatu = new JButton("Bilatu");
		btnBilatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> emaitzak = new ArrayList<String>();
				try {
					emaitzak = micoordinador.bidaliSelectHotelak(getherriaBilatu());
					taulaBete(emaitzak);
				}catch(Exception e) {
					System.out.println("Ez dago hotelik herri honetan.");
				}

			}
		});
		btnBilatu.setBounds(346, 59, 89, 23);
		getContentPane().add(btnBilatu);

		JButton btnOrdainketa = new JButton("Ordainketa");
		btnOrdainketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ordainketa
				micoordinador.mostrarVentanaOrdainketa();
			}

		});
		btnOrdainketa.setBounds(333, 273, 102, 23);
		contentPane.add(btnOrdainketa);

	}

	private void taulaBete(ArrayList<String> hotelZerrenda) {
		Iterator<String> it = hotelZerrenda.iterator();
		if (erakutsiEmaitza == null) {
			while (it.hasNext()) {
				this.erakutsiEmaitza.append(it.next());
			}
		} else {
			this.erakutsiEmaitza.setText(it.next());
			while (it.hasNext()) {
				this.erakutsiEmaitza.append(it.next());
			}
		}

	}

	public void setcoordinador(Koordinatzailea micoordinador) {
		this.micoordinador = micoordinador;
	}

	public static String getherriaBilatu() {
		return txbxHerria.getText();
	}
}
