package ChiragHW;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;

    public static WebDriver getDriver()
    {
        return driver;
    }


    @BeforeClass
    public static  void openBrowser()
    {
        System.out.println("starting the browser");
       // System.setProperty("webdriver.gecko.driver", "geckodriver");
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        driver = new ChromeDriver();
       // driver.get("https://www.amazon.co.uk");//open
        driver.get("https://www.google.co.uk/?gws_rd=ssl");
        //FOR SET TIME OUT
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
    }

    @AfterClass
    public static void closeBrowser()
    {
        System.out.println("I am in closing");
        driver.quit();
    }
}
