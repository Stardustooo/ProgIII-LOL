import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInvocadores extends JFrame {

	

	private JFrame frame;
	private PantallaPrincipal ventana;
	private JPanel contentPane;
	/**
	 * Create the application.
	 */
	public PantallaInvocadores(PantallaPrincipal frame) {
		this.ventana=frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(277, 118, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombreDeInvocador = new JLabel("Nombre de Invocador");
		lblNombreDeInvocador.setBounds(33, 188, 46, 14);
		contentPane.add(lblNombreDeInvocador);
		
		JLabel lblLiga = new JLabel("Liga");
		lblLiga.setBounds(33, 225, 46, 14);
		contentPane.add(lblLiga);
		
		JList list = new JList();
		list.setBounds(33, 436, 99, -150);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(265, 404, 276, -202);
		contentPane.add(list_1);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getFrame().setVisible(true);
				PantallaInvocadores.this.dispose();
			}
		});
		btnVolver.setBounds(540, 438, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 629, 461);
		contentPane.add(label);
		

		ImageIcon imageIcon = new ImageIcon("invocadores.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(629, 461,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		label.setIcon(imageIcon);
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
