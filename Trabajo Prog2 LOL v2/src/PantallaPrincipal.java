import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class PantallaPrincipal {

	private JFrame frame;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal window = new PantallaPrincipal();
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
	public PantallaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		search = new JTextField("Introducir busqueda...");
		search.setBackground(new Color(255, 255, 255));
		search.setToolTipText("");
		search.setBounds(426, 323, 189, 25);
		frame.getContentPane().add(search);
		search.setColumns(10);
		
		JButton champs = new JButton("Campeón");
		champs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaPersonajes V2= new PantallaPersonajes(PantallaPrincipal.this);
	    		V2.setVisible(true);
				frame.setVisible(false);
			}
		});
		champs.setBounds(523, 349, 92, 25);
		frame.getContentPane().add(champs);
		
		JLabel logo = new JLabel("");
		logo.setBounds(374, 170, 300, 100);
		frame.getContentPane().add(logo);
		
		ImageIcon imageIcon = new ImageIcon("Foto.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(300, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		logo.setIcon(imageIcon);
	    
		//label.setIcon(new ImageIcon("C:\\Users\\johnd\\Desktop\\fbh\\Foto.png"));
	    
	    JButton players = new JButton("Jugador");
	    players.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		PantallaInvocadores V2= new PantallaInvocadores(PantallaPrincipal.this);
	    		V2.setVisible(true);
				frame.setVisible(false);
	    	}
	    });
	    players.setBounds(426, 349, 98, 25);
	    frame.getContentPane().add(players);
	    
	    JButton opt = new JButton("OPT");
	    opt.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    opt.setBounds(998, 659, 66, 23);
	    frame.getContentPane().add(opt);
	    
	    JLabel riftback = new JLabel("");
	    riftback.setBounds(0, 0, 1064, 682);
	    frame.getContentPane().add(riftback);
	    
	    ImageIcon imageIcon2 = new ImageIcon("sum.jpg"); // load the image to a imageIcon
		Image image2 = imageIcon2.getImage(); // transform it 
		Image newimg2 = image2.getScaledInstance(1064, 682,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon2 = new ImageIcon(newimg2);
		riftback.setIcon(imageIcon2);
	    
	    
	    search.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                search.setText("");
            }
        });
		
		
	}

	public JFrame getFrame() {
		return frame;
	}
}