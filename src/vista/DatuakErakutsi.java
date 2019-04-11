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
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Scrollbar;
import javax.swing.ListSelectionModel;

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

		panel = new JPanel();
		panel.setBounds(0, 85, 435, 184);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

	}

	private void taulaBete(ArrayList<Hotela> hotelZerrenda) {
		
		List<String[]> filas = loadtable(hotelZerrenda);

		TableModel tableModel =  new DefaultTableModel(filas.toArray(new Object[][] {}),
				getColumns().toArray()) {		
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(tableModel);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		

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
