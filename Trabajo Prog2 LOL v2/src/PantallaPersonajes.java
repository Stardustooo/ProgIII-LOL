import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Color;



public class PantallaPersonajes extends JFrame {

	
	private JFrame frame;
	private PantallaPrincipal ventana;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public PantallaPersonajes(PantallaPrincipal frame) {
		this.ventana=frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 35, 129, 111);
		contentPane.add(label);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(22, 171, 117, 279);
		contentPane.add(textPane);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(561, 71, 17, 210);
		contentPane.add(scrollBar);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(180, 71, 398, 210);
		contentPane.add(textPane_1);
		
		JLabel lblQ = new JLabel("q");
		lblQ.setForeground(Color.WHITE);
		lblQ.setBounds(171, 322, 46, 14);
		contentPane.add(lblQ);
		
		JLabel lblW = new JLabel("w");
		lblW.setForeground(Color.WHITE);
		lblW.setBounds(258, 322, 46, 14);
		contentPane.add(lblW);
		
		JLabel lblE = new JLabel("e");
		lblE.setForeground(Color.WHITE);
		lblE.setBounds(332, 322, 46, 14);
		contentPane.add(lblE);
		
		JLabel lblR = new JLabel("r");
		lblR.setForeground(Color.WHITE);
		lblR.setBounds(435, 322, 46, 14);
		contentPane.add(lblR);
		
		JLabel lblP = new JLabel("p");
		lblP.setForeground(Color.WHITE);
		lblP.setBounds(532, 322, 46, 14);
		contentPane.add(lblP);
		
		JLabel lblDatosDelCampeon = new JLabel("Datos del Campeon");
		lblDatosDelCampeon.setForeground(Color.WHITE);
		lblDatosDelCampeon.setBounds(33, 146, 119, 14);
		contentPane.add(lblDatosDelCampeon);
		
		JLabel lblHistoria = new JLabel("Historia");
		lblHistoria.setForeground(Color.WHITE);
		lblHistoria.setBounds(348, 35, 70, 25);
		contentPane.add(lblHistoria);
		
		JLabel lblHabilidades = new JLabel("Habilidades");
		lblHabilidades.setForeground(Color.WHITE);
		lblHabilidades.setBounds(332, 292, 70, 14);
		contentPane.add(lblHabilidades);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getFrame().setVisible(true);
				PantallaPersonajes.this.dispose();

			}
		});
		btnVolver.setBounds(540, 438, 89, 23);
		contentPane.add(btnVolver);
		
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 629, 461);
		contentPane.add(label_1);
		
		ImageIcon imageIcon = new ImageIcon("personajes.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(629, 461,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		label_1.setIcon(imageIcon);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
