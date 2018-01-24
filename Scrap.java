
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Scrap {
    public static ArrayList<String>[] main_scrap() throws InterruptedException {
        ArrayList<String> result[] = new ArrayList[3];
        for (int arr = 0; arr < 3; arr++){
            result[arr] = new ArrayList<String>();
        }
        WebDriver driver;
        final String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", dir + "\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://euw.leagueoflegends.com/en/game-info/champions/");
        Thread.sleep(10000);
        List<WebElement> home_list = driver.findElements(By.xpath("//ul[@class='champion-grid grid-list gs-container gs-no-gutter default-7-col content-center']//li"));
        int home_list_size = home_list.size();
        for (int i = 1; i <= home_list_size; i++) {
            WebElement image_ele = driver.findElement(By.xpath("//ul[@class='champion-grid grid-list gs-container gs-no-gutter default-7-col content-center']//li[" + i + "]//div//span//a//img"));
            WebElement name_ele = driver.findElement(By.xpath("//ul[@class='champion-grid grid-list gs-container gs-no-gutter default-7-col content-center']//li[" + i + "]//div//div//a"));
            String img_url = image_ele.getAttribute("src");
            String character_name = name_ele.getText();
            result[0].add(Integer.toString(i));
            result[1].add(character_name);
            result[2].add(img_url);
            System.out.println(Integer.toString(i));
            System.out.println(img_url);
            System.out.println(character_name);
        }
        driver.quit();
        return result;
    }
    public static void detail_scrap() throws InterruptedException, ClassNotFoundException, SQLException {
        WebDriver driver;
        final String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", dir + "\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://euw.leagueoflegends.com/en/game-info/champions/");
        Thread.sleep(10000);
        List<WebElement> home_list = driver.findElements(By.xpath("//ul[@class='champion-grid grid-list gs-container gs-no-gutter default-7-col content-center']//li"));
        int home_list_size = home_list.size();
        for (int i = 115; i <= home_list_size; i++) {
            WebElement image_ele = driver.findElement(By.xpath("//ul[@class='champion-grid grid-list gs-container gs-no-gutter default-7-col content-center']//li[" + i + "]//div//span//a"));
            image_ele.click();
            Thread.sleep(10000);
            WebElement main_img_ele = driver.findElement(By.xpath("//div[@class='default-1-3']//img"));
            String main_img = main_img_ele.getAttribute("src");
            System.out.println(main_img);
            WebElement main_name_ele = driver.findElement(By.xpath("//div[@class='default-2-3']//h3"));
            String main_name = main_name_ele.getText();
            System.out.println(main_name);
            WebElement main_title_ele = driver.findElement(By.xpath("//div[@class='default-2-3']//span"));
            String main_title = main_title_ele.getText();
            System.out.println(main_title);
            List<WebElement> main_pro_list = driver.findElements(By.xpath("//div[@class='default-1-2']//p"));
            int main_pro_list_len = main_pro_list.size();
            System.out.println(main_pro_list_len);
            ArrayList<String> main_description = new ArrayList<>();
            for (int j = 1; j <= main_pro_list_len; j++){
                String main_text = "";
                String main_text1 = "";
                String main_text2 = "";
                if (j < 5){
                    WebElement main_text1_ele = driver.findElement(By.xpath("//div[@class='default-1-2'][1]//p["+j+"]//span//span[@class='dd-auto-set']["+1+"]"));
                    main_text1 = main_text1_ele.getText();
                    if (j != 4){
                        WebElement main_text2_ele = driver.findElement(By.xpath("//div[@class='default-1-2'][1]//p["+j+"]//span//span[@class='dd-auto-set']["+2+"]"));
                        main_text2 = main_text2_ele.getText();
                    }
                }
                else if (j >= 5){
                    WebElement main_text1_ele = driver.findElement(By.xpath("//div[@class='default-1-2'][2]//p["+(j-4)+"]//span//span[@class='dd-auto-set']["+1+"]"));
                    main_text1 = main_text1_ele.getText();
                    WebElement main_text2_ele = driver.findElement(By.xpath("//div[@class='default-1-2'][2]//p["+(j-4)+"]//span//span[@class='dd-auto-set']["+2+"]"));
                    main_text2 = main_text2_ele.getText();
                }
                System.out.println(main_text1 + " : " + main_text2);
                switch (j){
                    case 1:
                        main_text = main_text1 + "(+" + main_text2 + " per level)";
                        break;
                    case 2:
                        main_text = main_text1 + "(+" + main_text2 + " per level)";
                        break;
                    case 3:
                        main_text = main_text1 + "(+" + main_text2 + "% per level)";
                        break;
                    case 4:
                        main_text = main_text1;
                        break;
                    case 5:
                        main_text = main_text1 + "(+" + main_text2 + " per level)";
                        break;
                    case 6:
                        main_text = main_text1 + "(+" + main_text2 + " per level)";
                        break;
                    case 7:
                        main_text = main_text1 + "(+" + main_text2 + " per level)";
                        break;
                }
                main_description.add(main_text);
            }
            System.out.println(main_description);
            // Get Abilities Information
            // PData
            WebElement PIcon_ele = driver.findElement(By.xpath("//div[@id='PIcon']//span//img"));
            String PIcon = PIcon_ele.getAttribute("src");
            System.out.println(PIcon);
            WebElement PName_ele = driver.findElement(By.xpath("//div[@id='PName']//h3"));
            String PName = PName_ele.getText();
            System.out.println(PName);
            WebElement PDescription_ele = driver.findElement(By.xpath("//div[@id='PData']//div//div[@class='default-1-1']//p[1]"));
            String PDescription = PDescription_ele.getText();
            System.out.println(PDescription);
            // QData
            WebElement QIcon_ele = driver.findElement(By.xpath("//div[@id='QIcon']//span//img"));
            String QIcon = QIcon_ele.getAttribute("src");
            System.out.println(QIcon);
            WebElement QName_ele = driver.findElement(By.xpath("//div[@id='QName']//h3"));
            String QName = QName_ele.getText();
            System.out.println(QName);
            WebElement QCost_ele = driver.findElement(By.xpath("//span[@id='QCost']"));
            String QCost = QCost_ele.getText();
            System.out.println(QCost);
            WebElement QRange_ele = driver.findElement(By.xpath("//div[@id='QName']//p//span[@class='dd-auto-set']"));
            String QRange = QRange_ele.getText();
            System.out.println(QRange);
            WebElement QDescription_ele1 = driver.findElement(By.xpath("//div[@id='QData']//div//div[@class='default-1-1']//p[1]"));
            WebElement QDescription_ele2 = driver.findElement(By.xpath("//div[@id='QData']//div//div[@class='default-1-1']//p[2]"));
            String QDescription1 = QDescription_ele1.getText();
            String QDescription2 = QDescription_ele2.getText();
            QDescription2 = QDescription2.replaceAll("<[^>]*>", "");
            System.out.println(QDescription1);
            System.out.println(QDescription2);
            // WData
            WebElement WIcon_ele = driver.findElement(By.xpath("//div[@id='WIcon']//span//img"));
            String WIcon = WIcon_ele.getAttribute("src");
            System.out.println(WIcon);
            WebElement WName_ele = driver.findElement(By.xpath("//div[@id='WName']//h3"));
            String WName = WName_ele.getText();
            System.out.println(WName);
            WebElement WCost_ele = driver.findElement(By.xpath("//span[@id='WCost']"));
            String WCost = WCost_ele.getText();
            System.out.println(WCost);
            WebElement WRange_ele = driver.findElement(By.xpath("//div[@id='WName']//p//span[@class='dd-auto-set']"));
            String WRange = WRange_ele.getText();
            System.out.println(WRange);
            WebElement WDescription_ele1 = driver.findElement(By.xpath("//div[@id='WData']//div//div[@class='default-1-1']//p[1]"));
            WebElement WDescription_ele2 = driver.findElement(By.xpath("//div[@id='WData']//div//div[@class='default-1-1']//p[2]"));
            String WDescription1 = WDescription_ele1.getText();
            String WDescription2 = WDescription_ele2.getText();
            WDescription2 = WDescription2.replaceAll("<[^>]*>", "");
            System.out.println(WDescription1);
            System.out.println(WDescription2);
            // EData
            WebElement EIcon_ele = driver.findElement(By.xpath("//div[@id='EIcon']//span//img"));
            String EIcon = EIcon_ele.getAttribute("src");
            System.out.println(EIcon);
            WebElement EName_ele = driver.findElement(By.xpath("//div[@id='EName']//h3"));
            String EName = EName_ele.getText();
            System.out.println(EName);
            WebElement ECost_ele = driver.findElement(By.xpath("//span[@id='ECost']"));
            String ECost = ECost_ele.getText();
            System.out.println(ECost);
            WebElement ERange_ele = driver.findElement(By.xpath("//div[@id='EName']//p//span[@class='dd-auto-set']"));
            String ERange = ERange_ele.getText();
            System.out.println(ERange);
            WebElement EDescription_ele1 = driver.findElement(By.xpath("//div[@id='EData']//div//div[@class='default-1-1']//p[1]"));
            WebElement EDescription_ele2 = driver.findElement(By.xpath("//div[@id='EData']//div//div[@class='default-1-1']//p[2]"));
            String EDescription1 = EDescription_ele1.getText();
            String EDescription2 = EDescription_ele2.getText();
            EDescription2 = EDescription2.replaceAll("<[^>]*>", "");
            System.out.println(EDescription1);
            System.out.println(EDescription2);
            // RData
            WebElement RIcon_ele = driver.findElement(By.xpath("//div[@id='RIcon']//span//img"));
            String RIcon = RIcon_ele.getAttribute("src");
            System.out.println(RIcon);
            WebElement RName_ele = driver.findElement(By.xpath("//div[@id='RName']//h3"));
            String RName = RName_ele.getText();
            System.out.println(RName);
            WebElement RCost_ele = driver.findElement(By.xpath("//span[@id='RCost']"));
            String RCost = RCost_ele.getText();
            System.out.println(RCost);
            WebElement RRange_ele = driver.findElement(By.xpath("//div[@id='RName']//p//span[@class='dd-auto-set']"));
            String RRange = RRange_ele.getText();
            System.out.println(RRange);
            WebElement RDescription_ele1 = driver.findElement(By.xpath("//div[@id='RData']//div//div[@class='default-1-1']//p[1]"));
            WebElement RDescription_ele2 = driver.findElement(By.xpath("//div[@id='RData']//div//div[@class='default-1-1']//p[2]"));
            String RDescription1 = RDescription_ele1.getText();
            String RDescription2 = RDescription_ele2.getText();
            RDescription2 = RDescription2.replaceAll("<[^>]*>", "");
            System.out.println(RDescription1);
            System.out.println(RDescription2);
            // End reading details
            Thread.sleep(500);
            // Database Update
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/character_scrap","root","");
            //here is database name, root is username and password
            Statement stmt=con.createStatement();
            String sql = "INSERT INTO character_details " + "VALUES ("+i+", \""+main_img+"\", \""+main_name+"\", \""+main_title+"\",";
            sql += " \""+main_description.get(0)+"\", \""+main_description.get(1)+"\", \""+main_description.get(2)+"\", \""+main_description.get(3)+"\",";
            sql += " \""+main_description.get(4)+"\", \""+main_description.get(5)+"\", \""+main_description.get(6)+"\",";
            sql += " \""+PIcon+"\", \""+PName+"\", \""+PDescription+"\",";
            sql += " \""+QIcon+"\", \""+QName+"\", \""+QCost+"\", \""+QRange+"\", \""+QDescription1+"\", \""+QDescription2+"\",";
            sql += " \""+WIcon+"\", \""+WName+"\", \""+WCost+"\", \""+WRange+"\", \""+WDescription1+"\", \""+WDescription2+"\",";
            sql += " \""+EIcon+"\", \""+EName+"\", \""+ECost+"\", \""+ERange+"\", \""+EDescription1+"\", \""+EDescription2+"\",";
            sql += " \""+RIcon+"\", \""+RName+"\", \""+RCost+"\", \""+RRange+"\", \""+RDescription1+"\", \""+RDescription2+"\")";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            con.close();
            Thread.sleep(500);
            // Back Page
            driver.navigate().back();
            Thread.sleep(7000);
        }
        driver.quit();
    }
}
