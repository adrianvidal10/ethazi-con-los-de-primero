package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Kontsultak;
import controlador.Koordinatzailea;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class DatuakErakutsi extends JFrame {
	private Koordinatzailea micoordinador;
	private static JTextField txbxHerria;
	private JButton btnBilatu, btnAtzera;
	private JLabel lblHerria;
	private JPanel panel;
	static String herriaBilatu;
	private JPanel contentPane;
	private JTable table;

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

		btnBilatu = new JButton("Bilatu");
		btnBilatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Kontsultak ko = new Kontsultak();
				
			}
		});
		contentPane.setLayout(null);
		btnBilatu.setBounds(346, 59, 89, 23);
		getContentPane().add(btnBilatu);

		txbxHerria = new JTextField();
		txbxHerria.setBounds(103, 60, 195, 20);
		getContentPane().add(txbxHerria);
		txbxHerria.setColumns(10);

		lblHerria = new JLabel("Herria:");
		lblHerria.setBounds(29, 63, 46, 14);
		getContentPane().add(lblHerria);

		btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(24, 11, 65, 23);
		getContentPane().add(btnAtzera);

		panel = new JPanel();
		panel.setBounds(0, 96, 435, 166);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(418, 0, 17, 166);
		panel.add(scrollBar);
		
		table = new JTable();
		table.setBounds(0, 165, 425, -164);
		panel.add(table);
		
		JButton btnOrdainketa = new JButton("Ordainketa");
		btnOrdainketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				   micoordinador.mostrarVentanaOrdainketa();
				
				
			}
		});
		btnOrdainketa.setBounds(346, 273, 89, 23);
		contentPane.add(btnOrdainketa);

	}
	public void setcoordinador(Koordinatzailea micoordinador) {
		this.micoordinador = micoordinador;
	}
	
	public static String getherriaBilatu() {
		return  txbxHerria.getText();
	}
}
