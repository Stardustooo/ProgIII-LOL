
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.net.URL;

public class Body extends JPanel{
    public ArrayList<String>[] getHome(){
        ArrayList<String> result[] = new ArrayList[3];
        for (int i = 0; i < 3; i++){
            result[i] = new ArrayList<String>();
        }
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/character_scrap","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from characters");
            while(rs.next()){
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                result[0].add(Integer.toString(rs.getInt(1)));
                result[1].add(rs.getString(2));
                result[2].add(rs.getString(3));
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }
    public ArrayList<String>[] getDetails(){
        ArrayList<String> res[] = new ArrayList[38];
        for (int i = 0; i < 38; i++){
            res[i] = new ArrayList<String>();
        }
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/character_scrap","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from character_details");
            while(rs.next()){
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                res[0].add(Integer.toString(rs.getInt(1)));
                for (int j = 1; j < 38; j++){
                    res[j].add(rs.getString(j+1));
                }
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return res;
    }
    public void showDetails(ArrayList<String>[] data, int id){
        JDialog jDialog = new JDialog();
        jDialog.setSize(new Dimension(1200, 1000));

        JPanel mainPanel = new JPanel();
        jDialog.setContentPane(mainPanel);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        leftPanel.setPreferredSize(new Dimension(300, 900));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Main Information"));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JPanel leftsub1 = new JPanel();
        leftsub1.setPreferredSize(new Dimension(300, 100));
        leftsub1.setLayout(new BoxLayout(leftsub1, BoxLayout.X_AXIS));
        JPanel leftsub1_sub = new JPanel();
        leftsub1_sub.setLayout(new GridLayout(5,1));
        JLabel main_name = new JLabel(data[2].get(id));
        Font font1 = new Font("Courier New", Font.BOLD, 20);
        main_name.setFont(font1);
        leftsub1_sub.add(main_name);
        leftsub1_sub.add(new JLabel(data[3].get(id)));

        String main_url = data[1].get(id);
        URL url = null;
        try {
            url = new URL(main_url);
            BufferedImage myPicture = ImageIO.read(url);
            ImageIcon image = new ImageIcon(myPicture);
            JLabel img_label = new JLabel("", image, JLabel.CENTER);
            leftsub1.add(img_label);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        leftsub1.add(leftsub1_sub);

        JPanel leftsub2 = new JPanel();
        leftsub2.setPreferredSize(new Dimension(300, 800));
        leftsub2.setLayout(new GridLayout(20, 1));
        leftsub2.add(new JLabel("Health: "+data[4].get(id)));
        leftsub2.add(new JLabel("Attack Damage: "+data[5].get(id)));
        leftsub2.add(new JLabel("Attack Speed: "+data[6].get(id)));
        leftsub2.add(new JLabel("Movement: "+data[7].get(id)));
        leftsub2.add(new JLabel("Health Regen: "+data[8].get(id)));
        leftsub2.add(new JLabel("Armor: "+data[9].get(id)));
        leftsub2.add(new JLabel("Magic: "+data[10].get(id)));
        leftPanel.add(leftsub1);
        leftPanel.add(leftsub2);

        rightPanel.setPreferredSize(new Dimension(850, 900));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Abilities"));
        rightPanel.setLayout(new GridLayout(5, 1));

        JPanel right_p = new JPanel();
        JPanel right_q = new JPanel();
        JPanel right_w = new JPanel();
        JPanel right_e = new JPanel();
        JPanel right_r = new JPanel();
        right_p.setLayout(new BoxLayout(right_p, BoxLayout.Y_AXIS));
        right_q.setLayout(new BoxLayout(right_q, BoxLayout.Y_AXIS));
        right_w.setLayout(new BoxLayout(right_w, BoxLayout.Y_AXIS));
        right_e.setLayout(new BoxLayout(right_e, BoxLayout.Y_AXIS));
        right_r.setLayout(new BoxLayout(right_r, BoxLayout.Y_AXIS));

        JPanel right_p_img = new JPanel();
        right_p_img.setPreferredSize(new Dimension(850, 30));
        right_p_img.setLayout(new BoxLayout(right_p_img, BoxLayout.X_AXIS));
        JPanel right_p_img_panel = new JPanel();
        right_p_img_panel.setPreferredSize(new Dimension(50, 30));
        String right_p_img_url = data[11].get(id);
        URL right_p_url = null;
        try {
            right_p_url = new URL(right_p_img_url);
            BufferedImage myPicture_p = ImageIO.read(right_p_url);
            ImageIcon image_p = new ImageIcon(myPicture_p);
            JLabel img_label_p = new JLabel("", image_p, JLabel.CENTER);
            right_p_img_panel.add(img_label_p);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        JPanel right_p_img_title = new JPanel();
        right_p_img_title.setLayout(new GridLayout(3, 1));
        JLabel right_p_img_title_label = new JLabel(data[12].get(id));
        Font font_p = new Font("Courier New", Font.BOLD, 20);
        right_p_img_title_label.setFont(font_p);
        right_p_img_title.add(right_p_img_title_label);

        right_p_img.add(right_p_img_panel);
        right_p_img.add(right_p_img_title);
        JPanel right_p_descrtion = new JPanel();
        right_p_descrtion.setSize(new Dimension(800, right_p.getHeight() - 30));
        right_p_descrtion.add(new JLabel(data[13].get(id)));
        right_p.add(right_p_img);
        right_p.add(right_p_descrtion);

        JPanel right_q_img = new JPanel();
        right_q_img.setPreferredSize(new Dimension(850, 30));
        right_q_img.setLayout(new BoxLayout(right_q_img, BoxLayout.X_AXIS));
        JPanel right_q_img_panel = new JPanel();
        right_q_img_panel.setPreferredSize(new Dimension(50, 30));
        String right_q_img_url = data[14].get(id);
        URL right_q_url = null;
        try {
            right_q_url = new URL(right_q_img_url);
            BufferedImage myPicture_q = ImageIO.read(right_q_url);
            ImageIcon image_q = new ImageIcon(myPicture_q);
            JLabel img_label_q = new JLabel("", image_q, JLabel.CENTER);
            right_q_img_panel.add(img_label_q);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        JPanel right_q_img_title = new JPanel();
        right_q_img_title.setLayout(new GridLayout(3, 1));
        JLabel right_q_img_title_label = new JLabel(data[15].get(id));
        Font font_q = new Font("Courier New", Font.BOLD, 20);
        right_q_img_title_label.setFont(font_q);
        JLabel right_q_img_title_cost = new JLabel("Cost: " + data[16].get(id));
        JLabel right_q_img_title_range = new JLabel("Range: " + data[17].get(id));
        right_q_img_title.add(right_q_img_title_label);
        right_q_img_title.add(right_q_img_title_cost);
        right_q_img_title.add(right_q_img_title_range);
        right_q_img.add(right_q_img_panel);
        right_q_img.add(right_q_img_title);
        JPanel right_q_descrtion = new JPanel();
        right_q_descrtion.setSize(new Dimension(800, right_q.getHeight() - 30));
        right_q_descrtion.setLayout(new GridLayout(2,1));
        right_q_descrtion.add(new JLabel(data[18].get(id)));
        right_q_descrtion.add(new JLabel(data[19].get(id)));
        right_q.add(right_q_img);
        right_q.add(right_q_descrtion);

        JPanel right_w_img = new JPanel();
        right_w_img.setPreferredSize(new Dimension(850, 30));
        right_w_img.setLayout(new BoxLayout(right_w_img, BoxLayout.X_AXIS));
        JPanel right_w_img_panel = new JPanel();
        right_w_img_panel.setPreferredSize(new Dimension(50, 30));
        String right_w_img_url = data[20].get(id);
        URL right_w_url = null;
        try {
            right_w_url = new URL(right_w_img_url);
            BufferedImage myPicture_w = ImageIO.read(right_w_url);
            ImageIcon image_w = new ImageIcon(myPicture_w);
            JLabel img_label_w = new JLabel("", image_w, JLabel.CENTER);
            right_w_img_panel.add(img_label_w);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        JPanel right_w_img_title = new JPanel();
        right_w_img_title.setLayout(new GridLayout(3, 1));
        JLabel right_w_img_title_label = new JLabel(data[21].get(id));
        Font font_w = new Font("Courier New", Font.BOLD, 20);
        right_w_img_title_label.setFont(font_w);
        JLabel right_w_img_title_cost = new JLabel("Cost: " + data[22].get(id));
        JLabel right_w_img_title_range = new JLabel("Range: " + data[23].get(id));
        right_w_img_title.add(right_w_img_title_label);
        right_w_img_title.add(right_w_img_title_cost);
        right_w_img_title.add(right_w_img_title_range);
        right_w_img.add(right_w_img_panel);
        right_w_img.add(right_w_img_title);
        JPanel right_w_descrtion = new JPanel();
        right_w_descrtion.setSize(new Dimension(800, right_w.getHeight() - 30));
        right_w_descrtion.setLayout(new GridLayout(2, 1));
        right_w_descrtion.add(new JLabel(data[24].get(id)));
        right_w_descrtion.add(new JLabel(data[25].get(id)));
        right_w.add(right_w_img);
        right_w.add(right_w_descrtion);

        JPanel right_e_img = new JPanel();
        right_e_img.setPreferredSize(new Dimension(850, 30));
        right_e_img.setLayout(new BoxLayout(right_e_img, BoxLayout.X_AXIS));
        JPanel right_e_img_panel = new JPanel();
        right_e_img_panel.setPreferredSize(new Dimension(50, 30));
        String right_e_img_url = data[26].get(id);
        URL right_e_url = null;
        try {
            right_e_url = new URL(right_e_img_url);
            BufferedImage myPicture_e = ImageIO.read(right_e_url);
            ImageIcon image_e = new ImageIcon(myPicture_e);
            JLabel img_label_e = new JLabel("", image_e, JLabel.CENTER);
            right_e_img_panel.add(img_label_e);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        JPanel right_e_img_title = new JPanel();
        right_e_img_title.setLayout(new GridLayout(3, 1));
        JLabel right_e_img_title_label = new JLabel(data[27].get(id));
        Font font_e = new Font("Courier New", Font.BOLD, 20);
        right_e_img_title_label.setFont(font_e);
        JLabel right_e_img_title_cost = new JLabel("Cost: " + data[28].get(id));
        JLabel right_e_img_title_range = new JLabel("Range: " + data[29].get(id));
        right_e_img_title.add(right_e_img_title_label);
        right_e_img_title.add(right_e_img_title_cost);
        right_e_img_title.add(right_e_img_title_range);
        right_e_img.add(right_e_img_panel);
        right_e_img.add(right_e_img_title);
        JPanel right_e_descrtion = new JPanel();
        right_e_descrtion.setSize(new Dimension(800, right_e.getHeight() - 30));
        right_e_descrtion.setLayout(new GridLayout(2, 1));
        right_e_descrtion.add(new JLabel(data[30].get(id)));
        right_e_descrtion.add(new JLabel(data[31].get(id)));
        right_e.add(right_e_img);
        right_e.add(right_e_descrtion);

        JPanel right_r_img = new JPanel();
        right_r_img.setPreferredSize(new Dimension(850, 30));
        right_r_img.setLayout(new BoxLayout(right_r_img, BoxLayout.X_AXIS));
        JPanel right_r_img_panel = new JPanel();
        right_q_img_panel.setPreferredSize(new Dimension(50, 30));
        String right_r_img_url = data[32].get(id);
        URL right_r_url = null;
        try {
            right_r_url = new URL(right_r_img_url);
            BufferedImage myPicture_r = ImageIO.read(right_r_url);
            ImageIcon image_r = new ImageIcon(myPicture_r);
            JLabel img_label_r = new JLabel("", image_r, JLabel.CENTER);
            right_r_img_panel.add(img_label_r);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        JPanel right_r_img_title = new JPanel();
        right_r_img_title.setLayout(new GridLayout(3, 1));
        JLabel right_r_img_title_label = new JLabel(data[33].get(id));
        Font font_r = new Font("Courier New", Font.BOLD, 20);
        right_r_img_title_label.setFont(font_r);
        JLabel right_r_img_title_cost = new JLabel("Cost: " + data[34].get(id));
        JLabel right_r_img_title_range = new JLabel("Range: " + data[35].get(id));
        right_r_img_title.add(right_r_img_title_label);
        right_r_img_title.add(right_r_img_title_cost);
        right_r_img_title.add(right_r_img_title_range);
        right_r_img.add(right_r_img_panel);
        right_r_img.add(right_r_img_title);
        JPanel right_r_descrtion = new JPanel();
        right_r_descrtion.setSize(new Dimension(800, right_r.getHeight() - 30));
        right_r_descrtion.setLayout(new GridLayout(2, 1));
        right_r_descrtion.add(new JLabel(data[36].get(id)));
        right_r_descrtion.add(new JLabel(data[37].get(id)));
        right_r.add(right_r_img);
        right_r.add(right_r_descrtion);


        rightPanel.add(right_p);
        rightPanel.add(right_q);
        rightPanel.add(right_w);
        rightPanel.add(right_e);
        rightPanel.add(right_r);

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        jDialog.pack();
        jDialog.setVisible(true);
    }
    public static int getSelection(JOptionPane optionPane) {
        int returnValue = JOptionPane.CLOSED_OPTION;

        Object selectedValue = optionPane.getValue();
        if (selectedValue != null) {
            Object options[] = optionPane.getOptions();
            if (options == null) {
                if (selectedValue instanceof Integer) {
                    returnValue = ((Integer) selectedValue).intValue();
                }
            } else {
                for (int i = 0, n = options.length; i < n; i++) {
                    if (options[i].equals(selectedValue)) {
                        returnValue = i;
                        break; // out of for loop
                    }
                }
            }
        }
        return returnValue;
    }
    public Body(){
        ArrayList<String> data1[] = this.getHome();
        ArrayList<String> data2[] = this.getDetails();
        int parent_items = data1[0].size();
        int parent_grid_y = (int)Math.ceil(parent_items/9);
        JPanel viewPanel = new JPanel();
        GridLayout parent_grid = new GridLayout(parent_grid_y, 9, 10, 10);
        viewPanel.setLayout(parent_grid);
        JPanel jPanel[] = new JPanel[parent_items];
        for (int i = 0; i < parent_items; i++){
            try {
                final int id = i;
                String main_url = data1[2].get(i);
                String main_name = data1[1].get(i);
                URL url = new URL(main_url);
                BufferedImage myPicture = ImageIO.read(url);
                ImageIcon image = new ImageIcon(myPicture);
                image.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                JLabel label1 = new JLabel("", image, JLabel.CENTER);
                JLabel label2 = new JLabel(main_name);
                label1.setPreferredSize(new Dimension(100,100));
                jPanel[i] = new JPanel();
                jPanel[i].add(label1);
                jPanel[i].add(label2);
                jPanel[i].setPreferredSize(new Dimension(100,130));
                jPanel[i].setBackground(Color.white);
                viewPanel.add(jPanel[i]);
                jPanel[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                jPanel[i].addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
//                        super.mouseClicked(e);
                        showDetails(data2, id);

                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JScrollPane scrollPane = new JScrollPane(viewPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(1150, 810));
        add(scrollPane, BorderLayout.CENTER);
//        ImageIcon image1 = new ImageIcon("images/Viktor.png");
////        image1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//        JLabel label1 = new JLabel("Hello", image1, JLabel.CENTER);
//        label1.setForeground(Color.red);
//        label1.setPreferredSize(new Dimension(200, 200));
//        this.add(label1);

    }
    @Override
    public void update(Graphics g){
        paint(g);
    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.lightGray);
        g.fillRect(0,0,getWidth(),getHeight());

//        setBounds(0, 0, 1000, 1000);
    }
    @Override
    public Dimension getPreferredSize(){return new Dimension(1200, 850);}
    @Override
    public Dimension getMinimumSize(){return getPreferredSize();}
    @Override
    public Dimension getMaximumSize(){return getPreferredSize();}
}