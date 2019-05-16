package vista;

//A
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import javax.xml.ws.soap.Addressing;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import javax.swing.event.ChangeEvent;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class ErreserbaEgin extends JFrame {

	private JPanel contentPane;
	private Koordinatzailea micoordinador;
	private double prezioa, dirua;
	private int tarifa;
	private int ostatuPlazaKant;
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
	private JRadioButton rbs1, rbs4, rbb4, rbu4, rbs5, rbb5, rbu5;
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
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;

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
		setBounds(100, 100, 592, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
				//micoordinador.mostrarPantailaDatuakErakutsi();

			}
		});
		btnAtzera.setBounds(10, 11, 82, 23);
		contentPane.add(btnAtzera);

		lblErreserbaEgin = new JLabel("Erreserba egin");
		lblErreserbaEgin.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblErreserbaEgin.setBounds(211, 11, 143, 29);
		contentPane.add(lblErreserbaEgin);

		lblOstatuarenIzena = new JLabel("Izena:");
		lblOstatuarenIzena.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOstatuarenIzena.setBounds(45, 80, 47, 14);
		contentPane.add(lblOstatuarenIzena);

		lblOheMota = new JLabel("Ohe mota(k):");
		lblOheMota.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOheMota.setBounds(45, 182, 92, 14);
		contentPane.add(lblOheMota);

		lblOstatuarenIzenaErakutsi = new JLabel("");
		lblOstatuarenIzenaErakutsi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOstatuarenIzenaErakutsi.setBounds(98, 80, 153, 14);
		contentPane.add(lblOstatuarenIzenaErakutsi);

		lblGelaKant = new JLabel("Gela kantitatea:");
		lblGelaKant.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGelaKant.setBounds(45, 126, 113, 14);
		contentPane.add(lblGelaKant);

		btnOrdainketaBurutu = new JButton("Ordainketa burutu");
		btnOrdainketaBurutu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOrdainketaBurutu.setEnabled(false);
		btnOrdainketaBurutu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// erreserbako datuak zuzenak direnean ordainketa burutzera joango da
				// erabiltzailea
				micoordinador.setPrezioaErreserbaPantailaOrdainketa();
				micoordinador.mostrarVentanaLegedia();
			}
		});
		btnOrdainketaBurutu.setBounds(356, 407, 168, 23);
		contentPane.add(btnOrdainketaBurutu);

		lblPrezioTotala = new JLabel("Prezio totala:");
		lblPrezioTotala.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrezioTotala.setBounds(25, 411, 92, 14);
		contentPane.add(lblPrezioTotala);

		dateChooser = new JDateChooser();
		dateChooser.setMinSelectableDate(gaur);
		dateChooser.setBounds(408, 95, 106, 20);
		contentPane.add(dateChooser);

		dateChooser_1 = new JDateChooser();

		dateChooser_1.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// metodo honek erreserbaren hasierako data hartzen du
				erreserbaHasiera = dateChooser.getDate();

				// Date-a calendarrera pasatzen du, eta egun bat gehitu
				// holan erreserbak, minimo gau batekoak izango dira
				Calendar c1 = Calendar.getInstance();
				c1.setTime(erreserbaHasiera);
				c1.add(Calendar.DAY_OF_MONTH, 1);

				java.util.Date utilDate = c1.getTime();
				dateChooser_1.setMinSelectableDate(utilDate);

			}

		});

		erreserbaAmaiera = dateChooser_1.getDate();

		dateChooser_1.setBounds(409, 138, 105, 20);
		contentPane.add(dateChooser_1);

		lblHasieraData = new JLabel("Hasiera data:");
		lblHasieraData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHasieraData.setBounds(316, 95, 92, 14);
		contentPane.add(lblHasieraData);

		lblAmaieraData = new JLabel("Amaiera data:");
		lblAmaieraData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAmaieraData.setBounds(310, 138, 98, 14);
		contentPane.add(lblAmaieraData);

		lblDisponibilidad = new JLabel("");
		lblDisponibilidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisponibilidad.setBounds(221, 373, 303, 23);

		contentPane.add(lblDisponibilidad);
		
		lblPrezioTotErakutsi = new JLabel("");
		lblPrezioTotErakutsi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrezioTotErakutsi.setBounds(111, 407, 165, 23);
		
		
		

		
		contentPane.add(lblPrezioTotErakutsi);
		btnBalidatu = new JButton("Balidatu");
		btnBalidatu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBalidatu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnOrdainketaBurutu.setEnabled(true);
				boolean jarraitu = comprobatuDataHutsik();
				if (jarraitu == false) {
					System.out.println("Sartu ondo datuak data");
				} else {
					
					try {
						// balidatu botoia sakatzean, datak aukeratuta daudela bermatuko du
						erreserbaHasiera = new SimpleDateFormat("yyyy/MM/dd").parse(df.format(dateChooser.getDate()));
						erreserbaAmaiera = new SimpleDateFormat("yyyy/MM/dd").parse(df.format(dateChooser_1.getDate()));
						micoordinador.setErreserbaDatak(erreserbaHasiera, erreserbaAmaiera);
						reserva.setErreserbaHasiera(erreserbaHasiera.toString());
						reserva.setErreserbaAmaiera(erreserbaAmaiera.toString());
						
						konprobatuErreserbak();

					} catch (ParseException e1) {
						e1.printStackTrace();
					}

					// behin bi datak gordeta daudenean tarifa mota eskuratzeko metodoari deituko
					// zaio
					// metodo horrek uda, jaieguna edo egun normala denaren arabera tarifa mota
					// ezberdinak itzuliko ditu
					// erreserbaAmaiera = dateChooser_1.getDate();
					setTarifa(micoordinador.tarifaMotaBidali(erreserbaHasiera, erreserbaAmaiera));
					// setTarifa(tarifaMotaBidali(erreserbaHasiera,
					// erreserbaAmaiera));

					prezioa = Double.parseDouble(micoordinador.bidaliOstatuPrezioa());

					// behin tarifa eukiterakoan prezioa kalkulatuko dugu, egun koporua eta
					// tarifaren arabera

					// ondoren, ohe/gela kopuruen arabera gehixago edo gutxixo ordaindu beharko da
					// plus, promo kodigoa erabiltzekotan 10%-ko deskontua egiten da
					dirua = tarifaKalkulatu(prezioa, tarifa);
					String temp = micoordinador.PantailaLogin.erabiltzailea.toString();
					Label_Promoa.setText(micoordinador.bidaliPromoKodigo(temp));
					dirua = tarifarenDiruTotalaKalkulatu(dirua);
					lblPrezioTotErakutsi.setText(Double.toString(dirua) + "€");
					micoordinador.erreserbarenPrezioa(dirua);

				}
			}

		});
		btnBalidatu.setBounds(416, 324, 97, 23);
		contentPane.add(btnBalidatu);

		spinnerGelaKant = new JSpinner();
		spinnerGelaKant.addChangeListener(new ChangeListener() {
			// spinner honen arabera, radio button talde desberdinak sortuko ditu
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
					
					rbs4.setEnabled(false);
					rbb4.setEnabled(false);
					rbu4.setEnabled(false);

					break;
					
				case 4:
					
					rbs4.setEnabled(true);
					rbb4.setEnabled(true);
					rbu4.setEnabled(true);
					rbs4.setSelected(true);
					
					rbs5.setEnabled(false);
					rbb5.setEnabled(false);
					rbu5.setEnabled(false);
					
					
					
					break;
					
				case 5:
					
					rbs5.setEnabled(true);
					rbb5.setEnabled(true);
					rbu5.setEnabled(true);
					
					rbs5.setSelected(true);
					
					
					break;

				}

			}
		});
		spinnerGelaKant.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinnerGelaKant.setBounds(158, 124, 37, 20);
		contentPane.add(spinnerGelaKant);

		rbs3 = new JRadioButton("Sinplea");
		rbs3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbs3.setEnabled(false);
		rbs3.setBounds(57, 269, 80, 23);
		contentPane.add(rbs3);

		rbs1 = new JRadioButton("Sinplea");
		rbs1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbs1.setSelected(true);
		rbs1.setBounds(57, 216, 80, 23);
		contentPane.add(rbs1);

		rbs2 = new JRadioButton("Sinplea");
		rbs2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbs2.setEnabled(false);
		rbs2.setBounds(57, 242, 80, 23);
		contentPane.add(rbs2);

		rbb1 = new JRadioButton("Bikoitza");
		rbb1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbb1.setBounds(139, 216, 86, 23);
		contentPane.add(rbb1);

		rbb2 = new JRadioButton("Bikoitza");
		rbb2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbb2.setEnabled(false);
		rbb2.setBounds(139, 242, 86, 23);
		contentPane.add(rbb2);

		rbb3 = new JRadioButton("Bikoitza");
		rbb3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbb3.setEnabled(false);
		rbb3.setBounds(139, 269, 86, 23);
		contentPane.add(rbb3);

		rbu1 = new JRadioButton("Umeentzat");
		rbu1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbu1.setBounds(221, 216, 96, 23);
		contentPane.add(rbu1);

		rbu2 = new JRadioButton("Umeentzat");
		rbu2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbu2.setEnabled(false);
		rbu2.setBounds(221, 242, 96, 23);
		contentPane.add(rbu2);

		rbu3 = new JRadioButton("Umeentzat");
		rbu3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbu3.setEnabled(false);
		rbu3.setBounds(221, 269, 96, 23);
		contentPane.add(rbu3);

		// radio button taldeak sortu
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
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(437, 218, 92, 23);
		contentPane.add(lblNewLabel);

		Label_Promoa = new JLabel("");
		Label_Promoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		Label_Promoa.setBounds(447, 243, 77, 22);
		contentPane.add(Label_Promoa);

		JCheckBox chckbxErabiliNahi = new JCheckBox("Erabili nahi?");
		chckbxErabiliNahi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxErabiliNahi.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				// promo kodigoa egon eta erabiltzekotan 10%-ko deskontua egingo da
				if (chckbxErabiliNahi.isSelected()) {
					double dirua2 = dirua - ((dirua * 10) / 100);
					lblPrezioTotErakutsi.setText(Double.toString(dirua2) + "€");
					micoordinador.erreserbarenPrezioa(dirua2);
				} else {
					lblPrezioTotErakutsi.setText(Double.toString(dirua) + "€");
					micoordinador.erreserbarenPrezioa(dirua);
				}
			}
		});
		chckbxErabiliNahi.setBounds(423, 270, 106, 23);
		contentPane.add(chckbxErabiliNahi);
		
		rbs4 = new JRadioButton("Sinplea");
		rbs4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbs4.setEnabled(false);
		rbs4.setBounds(57, 299, 80, 23);
		contentPane.add(rbs4);
		
		rbb4 = new JRadioButton("Bikoitza");
		rbb4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbb4.setEnabled(false);
		rbb4.setBounds(139, 299, 86, 23);
		contentPane.add(rbb4);
		
		rbu4 = new JRadioButton("Umeentzat");
		rbu4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbu4.setEnabled(false);
		rbu4.setBounds(221, 299, 96, 23);
		contentPane.add(rbu4);
		
		rbs5 = new JRadioButton("Sinplea");
		rbs5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbs5.setEnabled(false);
		rbs5.setBounds(57, 325, 80, 23);
		contentPane.add(rbs5);
		
		rbu5 = new JRadioButton("Umeentzat");
		rbu5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbu5.setEnabled(false);
		rbu5.setBounds(221, 325, 96, 23);
		contentPane.add(rbu5);
		
		rbb5 = new JRadioButton("Bikoitza");
		rbb5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbb5.setEnabled(false);
		rbb5.setBounds(139, 325, 86, 23);
		contentPane.add(rbb5);
		
	
	}

	/*
	 * public int tarifaMotaBidali(Date data1, Date data2) { return
	 * micoordinador.tarifaMotaBidali(data1, data2); }
	 */

	public double tarifaKalkulatu(double prezioa, int tarifa) {
		// metodo honek tarifa eta prezioa jasotzen ditu
		// eta horiekin egun kantitatea eta motaren arabera prezio desberdinak itzuliko
		// ditu
		double emaitza;
		double temp = 1;
		double temptarifa = tarifa;
		temp = temptarifa / 100;
		if (tarifa == 1) {
			emaitza = prezioa;
		} else {
			emaitza = prezioa * temp;
			emaitza = (emaitza + prezioa) * micoordinador.bidaliDataLista().size();
			reserva.setPrezioa(emaitza);
		}

		return emaitza;
	}

	public double tarifarenDiruTotalaKalkulatu(double dirua) {
		double diruTot = dirua;
		// ohe kopuruaren arabera, diru kantitate bat gehituko zaio
		int balorea = (int) spinnerGelaKant.getValue();
		switch (balorea) {

		case 1:

			break;

		case 2:

			diruTot = diruTot * 2;
			break;

		case 3:

			diruTot = diruTot * 3;
			break;

		}

		return diruTot;
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

	public int getSpinner() {
		return (int) spinnerGelaKant.getValue();
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

	public void ipiniOstatuIzena(String izena) {
		lblOstatuarenIzenaErakutsi.setText(izena);
	}

	// erreserba egiteko plazarik baldin ez badago mezu bat agertuko da
	// Eta baldin badago be, baina plazarik ez badauka ez du utziko erreserba
	// garatzen utziko
	/*public void plazaKantErakutsi(int plazak) {
		int cont = plazak;

		if (cont == 0) {

			lblDisponibilidad.setText("Ez daude plazarik erreserbak egiteko");
			lblDisponibilidad.setForeground(Color.red);
			btnOrdainketaBurutu.setEnabled(false);
			btnBalidatu.setEnabled(false);

		} else {

			lblDisponibilidad.setText("Plazak eskuragarriak");
			lblDisponibilidad.setForeground(Color.green);
			btnOrdainketaBurutu.setEnabled(true);
			btnBalidatu.setEnabled(true);
		}
	}*/
	
	public void setEnableFalseOrdeinketaBurutu() {
		btnOrdainketaBurutu.setEnabled(false);
	}
	
	public void konprobatuErreserbak() {
		this.ostatuPlazaKant = micoordinador.getOstatuPLazaKant();
		System.out.println(this.ostatuPlazaKant);
		ArrayList<Reserva> erreserbaLista = micoordinador.getErreserbaOstatuKodea(micoordinador.getOstatuKod());
		
		for (int i = 0; i < erreserbaLista.size(); i++) {
			try {
				String hasieraData = erreserbaLista.get(i).getErreserbaHasiera();
				Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(hasieraData);
				String amaieraData = erreserbaLista.get(i).getErreserbaAmaiera();
				Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(amaieraData);
				int plazaKant = erreserbaLista.get(i).getGelaKant();
				konprobatuData(date1, date2, plazaKant);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		if (this.ostatuPlazaKant<=0) {
			lblDisponibilidad.setText("Ez daude plazarik erreserbak egiteko");
			lblDisponibilidad.setForeground(Color.red);
			btnOrdainketaBurutu.setEnabled(false);
			btnBalidatu.setEnabled(false);
		}
		else {
			lblDisponibilidad.setText("Plazak eskuragarriak");
			lblDisponibilidad.setForeground(Color.green);
			btnOrdainketaBurutu.setEnabled(true);
			btnBalidatu.setEnabled(true);
		}
		
	}
	
	public void konprobatuData(Date hasieraData, Date amaieraData, int plazaKant) {
		int hasi = this.erreserbaHasiera.compareTo(hasieraData);
		System.out.println(hasi);
		System.out.println("pito");
		int ama = this.erreserbaAmaiera.compareTo(amaieraData);
		System.out.println(ama);
		System.out.println("pito");
		System.out.println("-------");
		System.out.println(ostatuPlazaKant);
		System.out.println("-------");
		
		if (hasi==0 || ama==0) {
			ostatuPlazaKant = ostatuPlazaKant - plazaKant;
			System.out.println(ostatuPlazaKant);
		}	
	}

	public int getOstatuPlazaKant() {
		return ostatuPlazaKant;
	}

	public void setOstatuPlazaKant(int ostatuPlazaKant) {
		this.ostatuPlazaKant = ostatuPlazaKant;
	}
	
	public void reset() {
		micoordinador.reset();
		controlador.Main.main(null);
	}
}
