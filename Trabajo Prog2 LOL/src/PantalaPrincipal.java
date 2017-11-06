import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.DropMode;

public class PantalaPrincipal {

	private JFrame frame;
	private JTextField txtNombreInvocador;
	private JTextField txtServer;
	private JTextField textField_1;
	private JButton btnBuscar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantalaPrincipal window = new PantalaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantalaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtNombreInvocador = new JTextField("Nombre invocador");
		txtNombreInvocador.setBackground(new Color(255, 255, 255));
		txtNombreInvocador.setToolTipText("");
		txtNombreInvocador.setBounds(26, 91, 139, 20);
		frame.getContentPane().add(txtNombreInvocador);
		txtNombreInvocador.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(164, 90, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		txtServer = new JTextField("Server");
		
		txtServer.setBounds(36, 131, 86, 20);
		frame.getContentPane().add(txtServer);
		txtServer.setColumns(10);
		
		textField_1 = new JTextField("Nombre de campeon");
		textField_1.setBounds(26, 188, 139, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.setBounds(164, 187, 89, 23);
		frame.getContentPane().add(btnBuscar_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(164, 39, 10, 10);
		frame.getContentPane().add(panel);
		
		//ImageIcon imageIcon = new ImageIcon(); // load the image to a imageIcon
		//Image image = imageIcon.getImage(); // transform it 
		//Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		//imageIcon = new ImageIcon(newimg);
		//panel.setIcon(imageIcon);
	    
		
		
		
	}
}
