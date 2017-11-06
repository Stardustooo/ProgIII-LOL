import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;

public class PantalaPrincipal {

	private JFrame frame;
	private JTextField textField;
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
		
		textField = new JTextField("Nombre invocador");
		textField.setBounds(26, 91, 139, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
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

		Imagen Imagen = new Imagen();
		panel.add(Imagen);
		panel.repaint();
		
		
	}
}
