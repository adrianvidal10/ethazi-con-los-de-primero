package vista;

//A
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.ws.soap.Addressing;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import controlador.Koordinatzailea;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.MinguoChronology;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ErreserbaEgin extends JFrame {

	private JPanel contentPane;
	private Koordinatzailea micoordinador;
	private double prezioa;
	private int tarifa;
	JDateChooser dateChooser, dateChooser_1;
	//Date erreserbaHasiera, erreserbaAmaiera;
	DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

	JLabel lblHasieraData, lblAmaieraData, lblErreserbaEgin, lblOstatuarenIzena, lblPrezioTotala, lblOheMota,
			lblOstatuarenIzenaErakutsi, lblGelaMota, lblPrezioTotErakutsi;

	JButton btnAtzera, btnOrdainketaBurutu, btnBalidatu;
	JComboBox cbxOheMota, cbxGelaMota;

	Date gaur = new Date();
	Date erreserbaHasiera  = new Date();
	Date  erreserbaAmaiera  = new Date() ;
	private JLabel lblDisponibilidad;

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

		btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(10, 11, 80, 23);
		contentPane.add(btnAtzera);

		lblErreserbaEgin = new JLabel("Erreserba egin");
		lblErreserbaEgin.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblErreserbaEgin.setBounds(144, 11, 143, 29);
		contentPane.add(lblErreserbaEgin);

		lblOstatuarenIzena = new JLabel("Izena:");
		lblOstatuarenIzena.setBounds(25, 80, 47, 14);
		contentPane.add(lblOstatuarenIzena);

		lblOheMota = new JLabel("Ohe mota:");
		lblOheMota.setBounds(25, 158, 65, 14);
		contentPane.add(lblOheMota);

		lblOstatuarenIzenaErakutsi = new JLabel("New label");
		lblOstatuarenIzenaErakutsi.setBounds(67, 80, 111, 14);
		contentPane.add(lblOstatuarenIzenaErakutsi);

		lblGelaMota = new JLabel("Gela mota:");
		lblGelaMota.setBounds(25, 122, 65, 14);
		contentPane.add(lblGelaMota);

		cbxGelaMota = new JComboBox();
		cbxGelaMota.setBounds(100, 155, 92, 20);
		contentPane.add(cbxGelaMota);

		cbxOheMota = new JComboBox();
		cbxOheMota.setBounds(100, 119, 92, 20);
		contentPane.add(cbxOheMota);

		btnOrdainketaBurutu = new JButton("Ordainketa burutu");
		btnOrdainketaBurutu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				micoordinador.mostrarVentanaOrdainketa();
			}
		});
		btnOrdainketaBurutu.setBounds(276, 224, 132, 23);
		contentPane.add(btnOrdainketaBurutu);

		lblPrezioTotala = new JLabel("Prezio totala:");
		lblPrezioTotala.setBounds(28, 228, 92, 14);
		contentPane.add(lblPrezioTotala);
		
		
		lblPrezioTotErakutsi = new JLabel("");
		lblPrezioTotErakutsi.setBounds(119, 228, 73, 14);
		contentPane.add(lblPrezioTotErakutsi);

		dateChooser = new JDateChooser();
		dateChooser.setMinSelectableDate(gaur);
		dateChooser.setBounds(301, 80, 106, 20);
		contentPane.add(dateChooser);

		dateChooser_1 = new JDateChooser();
		

		 dateChooser_1.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ai ke pasar elñ presioaaaaaa
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
		lblAmaieraData.setBounds(219, 122, 75, 14);
		contentPane.add(lblAmaieraData);

		lblDisponibilidad = new JLabel("New label");
		lblDisponibilidad.setBounds(219, 188, 165, 14);

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
		contentPane.add(lblPrezioTotErakutsi);
		btnBalidatu = new JButton("Balidatu");
		btnBalidatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				
				setPrezioa(25.50);
				boolean jarraitu = comprobatuDataHutsik();
				if (jarraitu==false){
					System.out.println("Sartu ondo datuak data");
				}
				else{
					
					try {
						
						erreserbaHasiera = new SimpleDateFormat("yyyy/MM/dd").parse(df.format(dateChooser.getDate()));
						erreserbaAmaiera = new SimpleDateFormat("yyyy/MM/dd").parse(df.format(dateChooser_1.getDate()));
						System.out.println(erreserbaAmaiera);
						System.out.println(erreserbaHasiera);
						
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
				
					//erreserbaAmaiera = dateChooser_1.getDate();
					setTarifa(micoordinador.tarifaMotaBidali(erreserbaHasiera, erreserbaAmaiera));
					//setTarifa(tarifaMotaBidali(erreserbaHasiera, erreserbaAmaiera));
					double dirua = tarifaKalkulatu(prezioa, tarifa);
					
					lblPrezioTotErakutsi.setText(Double.toString(dirua));
				}			
			}
		});
		btnBalidatu.setBounds(335, 154, 73, 23);
		contentPane.add(btnBalidatu);

	}

	/*public int tarifaMotaBidali(Date data1, Date data2) {
		return micoordinador.tarifaMotaBidali(data1, data2);
	}*/
	
	public double tarifaKalkulatu (double prezioa, int tarifa){
		double emaitza = 0;
		if (tarifa == 0){
			emaitza = prezioa;
		}
		else{
			emaitza = prezioa*(tarifa/100);
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
	
	public boolean comprobatuDataHutsik(){
		boolean emaitza = false;
		if (erreserbaAmaiera != null) {
			btnBalidatu.setEnabled(true);	
		}
		else{
			emaitza = true;
		}
		
		return emaitza;
	}
}
