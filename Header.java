
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.sql.SQLException;

public class Header extends JPanel {

    public Header(){
        setBackground(Color.orange);
        this.setLayout(new GridLayout(2, 1));
        JLabel title = new JLabel("Character List from Scraping", SwingConstants.CENTER);
        Font font = new Font("Courier New", Font.BOLD, 25);
        title.setForeground(Color.RED);
        title.setFont(font);

        JButton btn_scrap = new JButton("Scrap Button");
        btn_scrap.setFont(new Font("Arial", Font.PLAIN, 40));
        btn_scrap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Scrap.main_scrap();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    Scrap.detail_scrap();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        
        this.add(title);
        this.add(btn_scrap);
    }
    @Override
    public void update(Graphics g){
        paint(g);
    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(0,0,getWidth(),getHeight());
    }
    @Override
    public Dimension getPreferredSize(){return new Dimension(1200, 150);}
    @Override
    public Dimension getMinimumSize(){return getPreferredSize();}
    @Override
    public Dimension getMaximumSize(){return getPreferredSize();}
}
