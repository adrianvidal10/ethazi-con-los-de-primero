package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;

public class DatuakErakutsi extends JPanel {
	private JTextField txbxHerria;

	/**
	 * Create the panel.
	 */
	public DatuakErakutsi() {
		setLayout(null);
		
		JButton btnBilatu = new JButton("Bilatu");
		btnBilatu.setBounds(346, 59, 89, 23);
		add(btnBilatu);
		
		txbxHerria = new JTextField();
		txbxHerria.setBounds(103, 60, 195, 20);
		add(txbxHerria);
		txbxHerria.setColumns(10);
		
		JLabel lblHerria = new JLabel("Herria:");
		lblHerria.setBounds(29, 63, 46, 14);
		add(lblHerria);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(24, 11, 65, 23);
		add(btnAtzera);
		
		JList listDatuakErakutsi = new JList();
		listDatuakErakutsi.setVisibleRowCount(5);
		listDatuakErakutsi.setBounds(41, 247, 366, -132);
		add(listDatuakErakutsi);
	

	}
}
