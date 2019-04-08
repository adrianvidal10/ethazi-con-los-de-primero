package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class ErreserbaEgin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErreserbaEgin frame = new ErreserbaEgin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ErreserbaEgin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(10, 11, 65, 23);
		contentPane.add(btnAtzera);
		
		JLabel lblErreserbaEgin = new JLabel("Erreserba egin");
		lblErreserbaEgin.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblErreserbaEgin.setBounds(144, 11, 143, 29);
		contentPane.add(lblErreserbaEgin);
		
		JLabel lblOstatuarenIzena = new JLabel("Izena:");
		lblOstatuarenIzena.setBounds(28, 70, 47, 14);
		contentPane.add(lblOstatuarenIzena);
		
		JLabel lblOheMota = new JLabel("Ohe mota:");
		lblOheMota.setBounds(28, 150, 65, 14);
		contentPane.add(lblOheMota);
		
		JLabel lblOstatuarenIzenaErakutsi = new JLabel("New label");
		lblOstatuarenIzenaErakutsi.setBounds(70, 70, 111, 14);
		contentPane.add(lblOstatuarenIzenaErakutsi);
		
		JLabel lblGelaMota = new JLabel("Gela mota:");
		lblGelaMota.setBounds(28, 108, 65, 14);
		contentPane.add(lblGelaMota);
		
		JComboBox cbxGelaMota = new JComboBox();
		cbxGelaMota.setBounds(89, 144, 92, 20);
		contentPane.add(cbxGelaMota);
		
		JComboBox cbxOheMota = new JComboBox();
		cbxOheMota.setBounds(89, 105, 92, 20);
		contentPane.add(cbxOheMota);
		
		JButton btnOrdainketaBurutu = new JButton("Ordainketa burutu");
		btnOrdainketaBurutu.setBounds(276, 224, 132, 23);
		contentPane.add(btnOrdainketaBurutu);
		
		JLabel lblPrezioTotala = new JLabel("Prezio totala:");
		lblPrezioTotala.setBounds(28, 228, 70, 14);
		contentPane.add(lblPrezioTotala);
		
		JLabel lblPrezioTotErakutsi = new JLabel("New label");
		lblPrezioTotErakutsi.setBounds(108, 228, 73, 14);
		contentPane.add(lblPrezioTotErakutsi);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(313, 58, 95, 20);
		contentPane.add(dateChooser);
	}
}
