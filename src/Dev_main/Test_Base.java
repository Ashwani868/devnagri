package Dev_main;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Test_Base {

    public static WebDriver driver;
    public static Properties prop;
    public static File file;

    //Read the property file
    public static void initialization_prop() throws IOException {

        try {
            file = new File(System.getProperty("user.dir") + "/src/Dev_Resource/Config.properties");
            FileInputStream file_read = new FileInputStream(file);
            prop = new Properties();
            prop.load(file_read);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // To initalization the browser
    public static void initialization_browser() {


        String browserName = prop.getProperty("browser");
        if (driver == null)
            driver = new FirefoxDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();


    }

    // To take the screen shot
    public static void take_Screenshot() throws IOException {

    /* File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/home/fourtekit/Desktop/Screenshot"));

        return;*/
        File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filename = new SimpleDateFormat("8/12/2017'.txt'").format(new Date());
        File dest = new File("/home/fourtekit/Desktop/Screenshot/.png");
        FileUtils.copyFile(scr, dest);

    }

}




