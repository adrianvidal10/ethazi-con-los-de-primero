package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;

import controlador.Koordinatzailea;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.time.chrono.MinguoChronology;
import java.awt.event.ActionEvent;

public class LegediaPantaila extends JFrame {

	private JPanel contentPane;
	JButton btnJarraitu;
	JCheckBox chckbxOinarriakOnartu;
	private Koordinatzailea micoordinador;
	JTextArea txtpnDatuenTratamendua;
	JScrollPane scrollBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LegediaPantaila frame = new LegediaPantaila();
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
	public LegediaPantaila() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		chckbxOinarriakOnartu = new JCheckBox("Oinarriak onartu");
		chckbxOinarriakOnartu.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				if (chckbxOinarriakOnartu.isSelected()) {
					btnJarraitu.setEnabled(true);
				} else {
					btnJarraitu.setEnabled(false);
				}
			}
		});
		chckbxOinarriakOnartu.setBounds(35, 318, 172, 23);
		contentPane.add(chckbxOinarriakOnartu);

		txtpnDatuenTratamendua = new JTextArea();
		txtpnDatuenTratamendua.setEditable(false);
		txtpnDatuenTratamendua.setWrapStyleWord(true);
		txtpnDatuenTratamendua.setLineWrap(true);
		txtpnDatuenTratamendua.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpnDatuenTratamendua.setText(
				"1. Datuen Tratamendua \r\n\r\nErabiltzailea haren datuak guri fidatzen dizkigun momentuan, gure formularioak erabilita, Bidai-On S.L. baimentzen du tratamendu automatikoa bere datuekin bere eskaintzak zerbitzuak kudeatzeko. Bidai-On S.L. erabiltzaileak sartutako datuak fitxero batean sartuko ditu, fitxero hau segurtasun arau guztiak izango ditu eta gaur egungo Datuen Segurtasunaren legea jarraituko du. Bidai-On S.L., ez du informazio hori zabalduko erabiltzaileak espresuki adostu ez badu,  baina, erabiltzaileak eskatu duen zerbitzu bat eskaini ahal izateko izan ezik. Erabiltzaileak eskubidea izango du sartzeko, zuzentzeko, indargabetzeko eta oposiziora eramateko Bidai-On-neri idatziz zuzenduta.\r\n\r\n\r\n2. Legislazio Juridikoa Aplikagarria.\r\n\r\nGeneralki, erabiltzaileen erlazioak, deribatuak programa honek prestatzen dituen zerbitzuekin, menderatuta daude espainako Legislazio Juridikoarekin. Erabiltzaileak une guztian kontzienteak dira adierazitako guztiarekin programa honetan, eskubide osoz adostu dutena.\r\n");
		txtpnDatuenTratamendua.setBounds(380, 1, 5009, 289);
		contentPane.add(txtpnDatuenTratamendua);

		scrollBar = new JScrollPane(txtpnDatuenTratamendua);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollBar.setBounds(21, 25, 459, 270);
		contentPane.add(scrollBar);

		btnJarraitu = new JButton("Jarraitu");
		btnJarraitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				micoordinador.mostrarVentanaOrdainketa();
				micoordinador.bezeroDatuakUpdate();
				//System.out.println(micoordinador.getReserva());
			}
		});
		btnJarraitu.setEnabled(false);

		btnJarraitu.setBounds(373, 345, 89, 23);
		contentPane.add(btnJarraitu);

	}
	public void setcoordinador(Koordinatzailea micoordinador) {
		this.micoordinador = micoordinador;
	}
}
