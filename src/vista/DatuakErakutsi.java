package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import controlador.Kontsultak;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DatuakErakutsi extends JPanel {
	private JTextField txbxHerria;
	private JButton btnBilatu, btnAtzera;
	private JLabel lblHerria, label;
	private JPanel panel;
	private JScrollBar scrollBar;
	static String herriaBilatu;

	/**
	 * Create the panel.
	 */
	public DatuakErakutsi() {
		setLayout(null);

		btnBilatu = new JButton("Bilatu");
		btnBilatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				herriaBilatu = txbxHerria.getText();
				
				label.setText(getIzena());
			}
		});
		btnBilatu.setBounds(346, 59, 89, 23);
		add(btnBilatu);

		txbxHerria = new JTextField();
		txbxHerria.setBounds(103, 60, 195, 20);
		add(txbxHerria);
		txbxHerria.setColumns(10);

		lblHerria = new JLabel("Herria:");
		lblHerria.setBounds(29, 63, 46, 14);
		add(lblHerria);

		btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(24, 11, 65, 23);
		add(btnAtzera);

		panel = new JPanel();
		panel.setBounds(10, 96, 430, 193);
		add(panel);
		panel.setLayout(null);

		scrollBar = new JScrollBar();
		scrollBar.setBounds(413, 0, 17, 193);
		panel.add(scrollBar);
		
		label = new JLabel("");
		label.setBounds(10, 11, 46, 14);
		panel.add(label);

	}

	public static String getherriaBilatu() {
		return herriaBilatu;
	}
}
