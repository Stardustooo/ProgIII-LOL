
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends JFrame{

    public static void get_characters() throws InterruptedException, ClassNotFoundException, SQLException {
        ArrayList<String> characters[] = Scrap.main_scrap();
        int characters_len = characters[0].size();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/character_scrap","root","");
        //database name, root is username and password
        Statement stmt=con.createStatement();
        for(int i = 0; i < characters_len; i++){
            String id = characters[0].get(i);
            String name = characters[1].get(i);
//            name = name.replaceAll("'", "\'");
            String url = characters[2].get(i);
//            url = url.replaceAll("'", "\'");
            String sql = "INSERT INTO characters " + "VALUES (" + id + ", \""+name+"\", \""+url+"\")";
            System.out.println(sql);
            stmt.executeUpdate(sql);
        }
        con.close();
    }

    public static void get_details() throws InterruptedException, SQLException, ClassNotFoundException {
        Scrap.detail_scrap();
    }

    Header header = new Header();
    Body body = new Body();
    public static Container mainPane = new JPanel();

    public static double screenWidth;
    public static double screenHeight;
    public Main(){

    }
    public void createUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPane.setBackground(Color.black);
        mainPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPane.add(header, gbc);
        gbc.gridy++;
        mainPane.add(body, gbc);
    }
    public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Main mainFrame = new Main();
        mainFrame.setTitle("Java Swing for Character Scrap");
        mainFrame.setSize(screenSize.width,1000);
        mainFrame.setContentPane(mainPane);
        mainFrame.setVisible(true);
        mainFrame.createUI();
    }
}