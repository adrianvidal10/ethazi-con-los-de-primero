package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class LegediaPantaila extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 507, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxOinarriakOnartu = new JCheckBox("Oinarriak onartu");
		chckbxOinarriakOnartu.setBounds(36, 244, 172, 23);
		contentPane.add(chckbxOinarriakOnartu);
		
		JTextArea LegediaTestuaTxtArea = new JTextArea();
		LegediaTestuaTxtArea.setText("ggggggggg jjjjjjjjjjjjj");
		LegediaTestuaTxtArea.setBounds(36, 32, 422, 137);
		contentPane.add(LegediaTestuaTxtArea);
	}
}
