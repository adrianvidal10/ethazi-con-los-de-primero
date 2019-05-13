package vista;

//A
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.ws.soap.Addressing;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import controlador.Koordinatzailea;
import controlador.Reserva;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.MinguoChronology;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JCheckBox;

public class ErreserbaEgin extends JFrame {

	private JPanel contentPane;
	private Koordinatzailea micoordinador;
	private double prezioa, dirua;
	private int tarifa;
	JDateChooser dateChooser, dateChooser_1;
	// Date erreserbaHasiera, erreserbaAmaiera;
	DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

	JLabel lblHasieraData, lblAmaieraData, lblErreserbaEgin, lblOstatuarenIzena, lblPrezioTotala, lblOheMota,
			lblOstatuarenIzenaErakutsi, lblGelaKant, lblPrezioTotErakutsi;

	JButton btnAtzera, btnOrdainketaBurutu, btnBalidatu;

	Date gaur = new Date();
	Date erreserbaHasiera = new Date();
	Date erreserbaAmaiera = new Date();
	private JLabel lblDisponibilidad;
	private JSpinner spinnerGelaKant;
	private JRadioButton rbs3;
	private JRadioButton rbs1;
	private JRadioButton rbs2;
	private JRadioButton rbb1;
	private JRadioButton rbb2;
	private JRadioButton rbb3;
	private JRadioButton rbu1;
	private JRadioButton rbu2;
	private JRadioButton rbu3;
	ButtonGroup lehenTaldea, bigarrenTaldea, hirugarrenTaldea;
	private Reserva reserva = new Reserva();
	
	JLabel Label_Promoa;

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
		setBounds(100, 100, 468, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				micoordinador.mostrarPantailaDatuakErakutsi();

			}
		});
		btnAtzera.setBounds(10, 11, 80, 23);
		contentPane.add(btnAtzera);

		lblErreserbaEgin = new JLabel("Erreserba egin");
		lblErreserbaEgin.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblErreserbaEgin.setBounds(144, 11, 143, 29);
		contentPane.add(lblErreserbaEgin);

		lblOstatuarenIzena = new JLabel("Izena:");
		lblOstatuarenIzena.setBounds(25, 80, 47, 14);
		contentPane.add(lblOstatuarenIzena);

		lblOheMota = new JLabel("Ohe mota(k):");
		lblOheMota.setBounds(25, 173, 80, 14);
		contentPane.add(lblOheMota);

		lblOstatuarenIzenaErakutsi = new JLabel("New label");
		lblOstatuarenIzenaErakutsi.setBounds(67, 80, 142, 14);
		contentPane.add(lblOstatuarenIzenaErakutsi);

		lblGelaKant = new JLabel("Gela kantitatea:");
		lblGelaKant.setBounds(25, 122, 92, 14);
		contentPane.add(lblGelaKant);

		btnOrdainketaBurutu = new JButton("Ordainketa burutu");
		btnOrdainketaBurutu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				micoordinador.mostrarVentanaLegedia();
			}
		});
		btnOrdainketaBurutu.setBounds(276, 324, 132, 23);
		contentPane.add(btnOrdainketaBurutu);

		lblPrezioTotala = new JLabel("Prezio totala:");
		lblPrezioTotala.setBounds(25, 328, 92, 14);
		contentPane.add(lblPrezioTotala);

		dateChooser = new JDateChooser();
		dateChooser.setMinSelectableDate(gaur);
		dateChooser.setBounds(301, 80, 106, 20);
		contentPane.add(dateChooser);

		dateChooser_1 = new JDateChooser();

		dateChooser_1.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ai ke pasar elñ presioaaaaaa
				erreserbaHasiera = dateChooser.getDate();
				dateChooser_1.setMinSelectableDate(erreserbaHasiera);

			}

		});

		erreserbaAmaiera = dateChooser_1.getDate();

		dateChooser_1.setBounds(301, 122, 105, 20);
		contentPane.add(dateChooser_1);

		lblHasieraData = new JLabel("Hasiera data:");
		lblHasieraData.setBounds(219, 80, 82, 14);
		contentPane.add(lblHasieraData);

		lblAmaieraData = new JLabel("Amaiera data:");
		lblAmaieraData.setBounds(212, 122, 82, 14);
		contentPane.add(lblAmaieraData);

		lblDisponibilidad = new JLabel("New label");
		lblDisponibilidad.setBounds(286, 299, 132, 14);

		int cont = 1;

		if (cont == 0) {

			lblDisponibilidad.setText("Ez daude plazarik erreserbak egiteko");
			lblDisponibilidad.setForeground(Color.red);
			btnOrdainketaBurutu.setVisible(false);

		} else {

			lblDisponibilidad.setText("Plazak eskuragarriak");
			lblDisponibilidad.setForeground(Color.green);
			btnOrdainketaBurutu.setVisible(true);
		}

		contentPane.add(lblDisponibilidad);
		lblPrezioTotErakutsi = new JLabel("");
		lblPrezioTotErakutsi.setSize(88, 14);
		lblPrezioTotErakutsi.setLocation(107, 333);
		contentPane.add(lblPrezioTotErakutsi);
		btnBalidatu = new JButton("Balidatu");
		btnBalidatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setPrezioa(25.00);
				boolean jarraitu = comprobatuDataHutsik();
				if (jarraitu == false) {
					System.out.println("Sartu ondo datuak data");
				} else {

					try {

						erreserbaHasiera = new SimpleDateFormat("yyyy/MM/dd").parse(df.format(dateChooser.getDate()));
						erreserbaAmaiera = new SimpleDateFormat("yyyy/MM/dd").parse(df.format(dateChooser_1.getDate()));
						System.out.println(erreserbaAmaiera);
						System.out.println(erreserbaHasiera);
						reserva.setErreserbaHasiera(erreserbaHasiera.toString());
						reserva.setErreserbaAmaiera(erreserbaAmaiera.toString());
						
					} catch (ParseException e1) {
						e1.printStackTrace();
					}

					// erreserbaAmaiera = dateChooser_1.getDate();
					setTarifa(micoordinador.tarifaMotaBidali(erreserbaHasiera, erreserbaAmaiera));
					// setTarifa(tarifaMotaBidali(erreserbaHasiera,
					// erreserbaAmaiera));
					dirua = tarifaKalkulatu(prezioa, tarifa);
					System.out.println(dirua);

					String temp = micoordinador.PantailaLogin.erabiltzailea.toString();
								
					Label_Promoa.setText(micoordinador.bidaliPromoKodigo(temp));
					
					lblPrezioTotErakutsi.setText(Double.toString(dirua) + "€");
				}
			}
		});
		btnBalidatu.setBounds(311, 154, 97, 23);
		contentPane.add(btnBalidatu);

		spinnerGelaKant = new JSpinner();
		spinnerGelaKant.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				int balorea = (int) spinnerGelaKant.getValue();

				switch (balorea) {

				case 1:

					rbs2.setEnabled(false);
					rbb2.setEnabled(false);
					rbu2.setEnabled(false);

					break;

				case 2:
					rbs2.setEnabled(true);
					rbb2.setEnabled(true);
					rbu2.setEnabled(true);
					rbs2.setSelected(true);

					rbs3.setEnabled(false);
					rbb3.setEnabled(false);
					rbu3.setEnabled(false);

					break;

				case 3:

					rbs3.setEnabled(true);
					rbb3.setEnabled(true);
					rbu3.setEnabled(true);
					rbs3.setSelected(true);

				}

			}
		});
		spinnerGelaKant.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spinnerGelaKant.setBounds(127, 119, 37, 20);
		contentPane.add(spinnerGelaKant);

		rbs3 = new JRadioButton("Sinplea");
		rbs3.setEnabled(false);
		rbs3.setBounds(27, 244, 80, 23);
		contentPane.add(rbs3);

		rbs1 = new JRadioButton("Sinplea");
		rbs1.setSelected(true);
		rbs1.setBounds(27, 193, 80, 23);
		contentPane.add(rbs1);

		rbs2 = new JRadioButton("Sinplea");
		rbs2.setEnabled(false);
		rbs2.setBounds(27, 218, 80, 23);
		contentPane.add(rbs2);

		rbb1 = new JRadioButton("Bikoitza");
		rbb1.setBounds(109, 193, 86, 23);
		contentPane.add(rbb1);

		rbb2 = new JRadioButton("Bikoitza");
		rbb2.setEnabled(false);
		rbb2.setBounds(109, 218, 86, 23);
		contentPane.add(rbb2);

		rbb3 = new JRadioButton("Bikoitza");
		rbb3.setEnabled(false);
		rbb3.setBounds(109, 244, 86, 23);
		contentPane.add(rbb3);

		rbu1 = new JRadioButton("Umeentzat");
		rbu1.setBounds(191, 193, 96, 23);
		contentPane.add(rbu1);

		rbu2 = new JRadioButton("Umeentzat");
		rbu2.setEnabled(false);
		rbu2.setBounds(191, 218, 96, 23);
		contentPane.add(rbu2);

		rbu3 = new JRadioButton("Umeentzat");
		rbu3.setEnabled(false);
		rbu3.setBounds(191, 244, 96, 23);
		contentPane.add(rbu3);

		lehenTaldea = new ButtonGroup();
		lehenTaldea.add(rbs1);
		lehenTaldea.add(rbb1);
		lehenTaldea.add(rbu1);

		bigarrenTaldea = new ButtonGroup();
		bigarrenTaldea.add(rbs2);
		bigarrenTaldea.add(rbb2);
		bigarrenTaldea.add(rbu2);

		hirugarrenTaldea = new ButtonGroup();
		hirugarrenTaldea.add(rbs3);
		hirugarrenTaldea.add(rbb3);
		hirugarrenTaldea.add(rbu3);

		JLabel lblNewLabel = new JLabel("Zure kodigoa:");
		lblNewLabel.setBounds(321, 197, 92, 23);
		contentPane.add(lblNewLabel);

		Label_Promoa = new JLabel("");
		Label_Promoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		Label_Promoa.setBounds(331, 222, 77, 14);
		contentPane.add(Label_Promoa);

		JCheckBox chckbxErabiliNahi = new JCheckBox("Erabili nahi?");
		chckbxErabiliNahi.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				if (chckbxErabiliNahi.isSelected()) {
					double dirua2 = dirua - ((dirua * 10 ) /100 );
					lblPrezioTotErakutsi.setText(Double.toString(dirua2) + "€");
				} else {
					lblPrezioTotErakutsi.setText(Double.toString(dirua) + "€");
				}
			}
		});
		chckbxErabiliNahi.setBounds(312, 244, 106, 23);
		contentPane.add(chckbxErabiliNahi);

	}

	/*
	 * public int tarifaMotaBidali(Date data1, Date data2) { return
	 * micoordinador.tarifaMotaBidali(data1, data2); }
	 */

	public double tarifaKalkulatu(double prezioa, int tarifa) {
		double emaitza;
		double temp = 0;
		System.out.println(temp);
		System.out.println(tarifa);
		System.out.println(prezioa);
		double temptarifa= tarifa;
		 temp = temptarifa/100;
		System.out.println("-");
		System.out.println(temp);
		System.out.println(tarifa);
		if (tarifa == 0) {
			emaitza = prezioa;
		} else {
			emaitza = prezioa * temp;
			emaitza = (emaitza + prezioa) * micoordinador.bidaliDataLista().size();
			reserva.setPrezioa(emaitza);
		}

		return emaitza;
	}

	public void setcoordinador(Koordinatzailea micoordinador) {
		this.micoordinador = micoordinador;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	public boolean comprobatuDataHutsik() {
		boolean emaitza = false;
		if (erreserbaAmaiera != null) {
			btnBalidatu.setEnabled(true);
		} else {
			emaitza = true;
		}

		return emaitza;
	}
}
