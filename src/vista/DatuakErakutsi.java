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
	private JButton btnBilatu, btnAtzera;
	private JLabel lblHerria;
	static String herriaBilatu;
	private JPanel contentPane, panel;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Create the panel.
	 */
	public DatuakErakutsi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);

		contentPane.setLayout(null);

		txbxHerria = new JTextField();
		txbxHerria.setBounds(70, 31, 89, 20);
		getContentPane().add(txbxHerria);
		txbxHerria.setColumns(10);

		lblHerria = new JLabel("Herria:");
		lblHerria.setBounds(31, 34, 46, 14);
		getContentPane().add(lblHerria);

		btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(24, 11, 82, 23);

		btnBilatu = new JButton("Bilatu");
		btnBilatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ArrayList<Hotela> hotelZerrenda = new ArrayList<Hotela>();
					hotelZerrenda = micoordinador.bidaliSelectHotelak(getherriaBilatu());
					taulaBete(hotelZerrenda);
				} catch (Exception e) {
					System.out.println("Ez dago hotelik herri honetan.");
				}

			}
		});
		btnBilatu.setBounds(406, 158, 89, 23);
		getContentPane().add(btnBilatu);

		JButton btnOrdainketa = new JButton("Ordainketa");
		btnOrdainketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ordainketa
				micoordinador.mostrarVentanaOrdainketa();
			}

		});
		btnOrdainketa.setBounds(426, 387, 102, 23);
		contentPane.add(btnOrdainketa);

		panel = new JPanel();
		panel.setBounds(31, 192, 514, 184);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JDateChooser dtChHasieraData = new JDateChooser();
		dtChHasieraData.setBounds(240, 31, 95, 20);
		contentPane.add(dtChHasieraData);
		
		JDateChooser dtChAmaieraData = new JDateChooser();
		dtChAmaieraData.setBounds(416, 31, 95, 20);
		contentPane.add(dtChAmaieraData);
		
		Checkbox chbxPreziozOrdenatu = new Checkbox("Prezioz ordenatu");
		chbxPreziozOrdenatu.setBounds(218, 77, 111, 22);
		contentPane.add(chbxPreziozOrdenatu);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 62, 508, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 105, 508, 2);
		contentPane.add(separator_1);
		
		JLabel lblOstatuMota = new JLabel("Ostatu mota: ");
		lblOstatuMota.setBounds(30, 77, 67, 14);
		contentPane.add(lblOstatuMota);
		
		JComboBox cbxOstatuMota = new JComboBox();
		cbxOstatuMota.setBounds(100, 74, 102, 20);
		contentPane.add(cbxOstatuMota);
		
		JLabel lblHasieraData = new JLabel("Hasiera data:");
		lblHasieraData.setBounds(171, 34, 71, 14);
		contentPane.add(lblHasieraData);
		
		JLabel lblAmaieraData = new JLabel("Amaiera data:");
		lblAmaieraData.setBounds(345, 34, 71, 14);
		contentPane.add(lblAmaieraData);
		
		JSpinner spnIzarKop = new JSpinner();
		spnIzarKop.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spnIzarKop.setEnabled(false);
		spnIzarKop.setBounds(406, 77, 29, 20);
		contentPane.add(spnIzarKop);
		
		JLabel lblIzarKopurua = new JLabel("Izar kopurua:");
		lblIzarKopurua.setBounds(341, 77, 75, 14);
		contentPane.add(lblIzarKopurua);
		
		JCheckBox chckbxParkina = new JCheckBox("Parkina");
		chckbxParkina.setBounds(398, 114, 67, 23);
		contentPane.add(chckbxParkina);

	}

	private void taulaBete(ArrayList<Hotela> hotelZerrenda) {

		List<String[]> filas = loadtable(hotelZerrenda);

		TableModel tableModel = new DefaultTableModel(filas.toArray(new Object[][] {}), getColumns().toArray()) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(tableModel);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				final int row = table.rowAtPoint(new Point(e.getX(), e.getY()));
				table.setRowSelectionInterval(row, row);
				int row2 = table.rowAtPoint(e.getPoint());
				String prezioa = table.getValueAt(row2, 3).toString();
				micoordinador.erreserbarenPrezioa(prezioa);
			}
		});

		panel.add(new JScrollPane(table), BorderLayout.CENTER);
		panel.add(table.getTableHeader(), BorderLayout.NORTH);

		panel.setVisible(true);
		panel.setSize(440, 180);
	}

	private List<String> getColumns() {
		List<String> columnas = new ArrayList<String>();
		columnas.add("Izena");
		columnas.add("Izarrak");
		columnas.add("Herria");
		columnas.add("Prezioa");
		return columnas;
	}

	private List<String[]> loadtable(ArrayList<Hotela> hotelZerrenda) {
		List<String[]> filas = new ArrayList<String[]>();
		Hotela hotel = new Hotela();
		for (int i = 0; i < hotelZerrenda.size(); i++) {
			hotel = hotelZerrenda.get(i);
			filas.add(new String[] { hotel.getIzena(), Integer.toString(hotel.getIzarrak()), hotel.getHerria(),
					String.valueOf(hotel.getPrezioa()) });
		}
		return filas;
	}

	public void setcoordinador(Koordinatzailea micoordinador) {
		this.micoordinador = micoordinador;
	}

	public static String getherriaBilatu() {
		return txbxHerria.getText();
	}
}
