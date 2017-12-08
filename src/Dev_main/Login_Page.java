package Dev_main;

import org.openqa.selenium.By;

import java.io.IOException;

public class Login_Page extends Test_Base {



    public static void main(String arr[]) throws IOException {
        initialization_prop();
        initialization_browser();
        driver.findElement(By.xpath(prop.getProperty("username_xpath"))).sendKeys(prop.getProperty("username"));
        take_Screenshot();
        driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath(prop.getProperty("Login_xpath"))).click();
        take_Screenshot();
        driver.close();


    }
}
