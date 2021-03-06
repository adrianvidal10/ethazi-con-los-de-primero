package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.Kontsultak;
import controlador.Koordinatzailea;
import modelo.Hotela;
import modelo.Ostatua;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Scrollbar;
import javax.swing.ListSelectionModel;
import com.toedter.calendar.JDateChooser;
import java.awt.Checkbox;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;

public class DatuakErakutsi extends JFrame {
	private Koordinatzailea micoordinador;
	private static JTextField txbxHerria;
	private JButton btnBilatu, btnAtzera, btnOrdainketa;
	private JLabel lblHerria, lblOstatuMota, lblIzarKopurua;
	static String herriaBilatu;
	private JPanel contentPane, panel;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	JCheckBox chbxPreziozOrdenatu, chckbxParkina, chckbxwifi, chckbxSpa, chckbxIgerilekua, chckbxAireGirotua,
			chckbxJatetxe, chckbxTaberna, chckbxGimnasioa;
	private JCheckBox chckbxParkina_1;
	JSeparator separator, separator_1, separator_2;
	JComboBox cbxOstatuMota;
	JSpinner spnIzarKop;

	/**
	 * Create the panel.
	 */
	public DatuakErakutsi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);

		contentPane.setLayout(null);

		txbxHerria = new JTextField();
		txbxHerria.setBounds(76, 68, 398, 20);
		getContentPane().add(txbxHerria);
		txbxHerria.setColumns(10);

		lblHerria = new JLabel("Herria:");
		lblHerria.setBounds(31, 71, 46, 14);
		getContentPane().add(lblHerria);

		btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(24, 11, 82, 23);

		btnBilatu = new JButton("Bilatu");
		btnBilatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// bilatu botoia sakatzean herriaren eta ostatu motan dauden baloreak hartzen
				// ditu
				// eta taula betetzeko metodoa deituko du
				// taula eskatutako datuekin bete dadin

				// ArrayList<Ostatua> ostatuZerrenda = new ArrayList<Ostatua>();
				String herria = "";
				String ostatumota = "";
				try {
					herria = txbxHerria.getText();
				} catch (Exception e) {
					herria = "";
				}
				try {
					ostatumota = (String) cbxOstatuMota.getSelectedItem();
				} catch (Exception e) {
					ostatumota = "";
				}
				/*
				 * ostatuZerrenda = micoordinador.bidaliOstatuSelect(herria, ostatumota);
				 * 
				 * taulaBete(ostatuZerrenda);
				 */
				taulaBete(micoordinador.bidaliOstatuSelect(herria, ostatumota));
			}
		});
		btnBilatu.setBounds(443, 169, 89, 23);
		getContentPane().add(btnBilatu);

		btnOrdainketa = new JButton("Ordainketa");
		btnOrdainketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ordainketa pantaila erakutsi
				micoordinador.mostrarVentanaLogin();
			}

		});
		btnOrdainketa.setBounds(407, 441, 125, 23);
		contentPane.add(btnOrdainketa);

		panel = new JPanel();
		panel.setBounds(20, 246, 514, 184);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		chbxPreziozOrdenatu = new JCheckBox("Prezioz ordenatu");
		chbxPreziozOrdenatu.setEnabled(false);
		chbxPreziozOrdenatu.setBounds(246, 108, 130, 29);
		contentPane.add(chbxPreziozOrdenatu);

		separator = new JSeparator();
		separator.setBounds(24, 99, 508, 2);
		contentPane.add(separator);

		separator_1 = new JSeparator();
		separator_1.setBounds(24, 148, 508, 2);
		contentPane.add(separator_1);

		lblOstatuMota = new JLabel("Ostatu mota: ");
		lblOstatuMota.setBounds(30, 120, 82, 14);
		contentPane.add(lblOstatuMota);

		cbxOstatuMota = new JComboBox();
		// cbxOstatuMota.addItem();
		cbxOstatuMota.setBounds(115, 117, 112, 20);
		// komboboxa betetzeko emtodoari deitu
		sartuKomboOstMota();
		contentPane.add(cbxOstatuMota);

		// hauek soilik erabilgarriak hotelak bilatzerakoan
		spnIzarKop = new JSpinner();
		spnIzarKop.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spnIzarKop.setEnabled(false);
		spnIzarKop.setBounds(463, 108, 29, 29);
		contentPane.add(spnIzarKop);

		lblIzarKopurua = new JLabel("Izar kopurua:");
		lblIzarKopurua.setBounds(382, 115, 75, 14);
		contentPane.add(lblIzarKopurua);

		// hauek soilik erabilgarriak apartamentuak bilatzerakoan
		chckbxParkina = new JCheckBox("Parkina");
		chckbxParkina.setEnabled(false);
		chckbxParkina.setBounds(309, 140, 67, 23);

		chckbxParkina_1 = new JCheckBox("Parkina");
		chckbxParkina_1.setEnabled(false);
		chckbxParkina_1.setBounds(325, 183, 97, 23);

		contentPane.add(chckbxParkina_1);

		chckbxwifi = new JCheckBox("Wifi");
		chckbxwifi.setEnabled(false);
		chckbxwifi.setBounds(58, 157, 65, 23);
		contentPane.add(chckbxwifi);

		chckbxSpa = new JCheckBox("Spa");
		chckbxSpa.setEnabled(false);
		chckbxSpa.setBounds(58, 183, 65, 23);
		contentPane.add(chckbxSpa);

		chckbxIgerilekua = new JCheckBox("Igerilekua");
		chckbxIgerilekua.setEnabled(false);
		chckbxIgerilekua.setBounds(125, 157, 97, 23);
		contentPane.add(chckbxIgerilekua);

		chckbxAireGirotua = new JCheckBox("Aire girotua");
		chckbxAireGirotua.setEnabled(false);
		chckbxAireGirotua.setBounds(125, 183, 97, 23);
		contentPane.add(chckbxAireGirotua);

		chckbxJatetxe = new JCheckBox("Jatetxe");
		chckbxJatetxe.setEnabled(false);
		chckbxJatetxe.setBounds(228, 157, 89, 23);
		contentPane.add(chckbxJatetxe);

		chckbxTaberna = new JCheckBox("Taberna");
		chckbxTaberna.setEnabled(false);
		chckbxTaberna.setBounds(228, 183, 97, 23);
		contentPane.add(chckbxTaberna);

		chckbxGimnasioa = new JCheckBox("Gimnasioa");
		chckbxGimnasioa.setEnabled(false);
		chckbxGimnasioa.setBounds(325, 157, 97, 23);
		contentPane.add(chckbxGimnasioa);

		separator_2 = new JSeparator();
		separator_2.setBounds(24, 213, 508, 2);
		contentPane.add(separator_2);
		
		JLabel lblBidaion = new JLabel("BidaiOn");
		lblBidaion.setFont(new Font("Lucida Handwriting", Font.BOLD, 32));
		lblBidaion.setBounds(189, 24, 185, 33);
		contentPane.add(lblBidaion);

	}

	public void taulaBete(ArrayList<Ostatua> hotelZerrenda) {

		List<String[]> filas = loadtable(hotelZerrenda);

		TableModel tableModel = new DefaultTableModel(filas.toArray(new Object[][] {}), getColumns().toArray()) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(tableModel);
		/*
		 * for (int i = 0; i < table.getRowCount(); i++) { table.remove(i); }
		 */
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setAutoscrolls(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				final int row = table.rowAtPoint(new Point(e.getX(), e.getY()));
				table.setRowSelectionInterval(row, row);
				int row2 = table.rowAtPoint(e.getPoint());
				String prezioa = table.getValueAt(row2, 2).toString();
				String izena = table.getValueAt(row2, 0).toString();
				String Plazak = table.getValueAt(row2, 5).toString();

				micoordinador.erreserbarenPrezioa(Double.parseDouble(prezioa));
				micoordinador.setOstatuarenPrezioa(Double.parseDouble(prezioa));
				micoordinador.OstatuIzenajarri(izena);
				micoordinador.setOstatuPLazaKant(Integer.parseInt(Plazak));
			}
		});

		panel.add(new JScrollPane(table), BorderLayout.CENTER);
		panel.add(table.getTableHeader(), BorderLayout.NORTH);

		panel.setVisible(true);
		panel.setBounds(20, 246, 514, 184);
	}

	private List<String> getColumns() {
		// taulak izango dituen zutabeak arraylit batean gorde
		List<String> columnas = new ArrayList<String>();
		columnas.add("Izena");
		columnas.add("Herria");
		columnas.add("Tarifa");
		columnas.add("Gosaria");
		columnas.add("Ostatu Mota");
		columnas.add("PLaza Kantitate");
		return columnas;
	}

	private void sartuKomboOstMota() {
		cbxOstatuMota.addItem("---Guztiak---");
		cbxOstatuMota.addItem("Hotela");
		cbxOstatuMota.addItem("Etxea");
		cbxOstatuMota.addItem("Apartamentua");
	}

	public List<String[]> loadtable(ArrayList<Ostatua> hotelZerrenda) {

		// metodo honek egindako bilaketaren kontsultaren emaitza jasotzen du parametroz
		// eta honekin taula betetzen du

		List<String[]> filas = new ArrayList<String[]>();
		Ostatua hotel = new Ostatua();
		for (int i = 0; i < hotelZerrenda.size(); i++) {
			hotel = hotelZerrenda.get(i);

			/*
			 * filas.add(new String[] { hotel.getIzena(),
			 * Integer.toString(hotel.getIzarrak()), hotel.getHerria(),
			 * String.valueOf(hotel.getPrezioa()) });
			 */

			filas.add(new String[] { hotel.getIzena(), hotel.getHerria(), String.valueOf(hotel.getTarifa()), 
					hotel.getGosaria(), hotel.getOstMota(), String.valueOf(hotel.getPlazaKant()) });

		}
		System.out.println(hotelZerrenda.size());
		return filas;
	}

	public void setcoordinador(Koordinatzailea micoordinador) {
		this.micoordinador = micoordinador;
	}

	public static String hartuDatuak() {
		return txbxHerria.getText();
	}
}