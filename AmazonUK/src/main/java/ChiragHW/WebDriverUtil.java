package ChiragHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sriramangajala on 08/11/16.
 */
public class WebDriverUtil {


    public static boolean isTextPresent(String text) {
        try {
            return BrowserFactory.getDriver().findElement(By.tagName("body")).getText().contains(text);
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static boolean waitForText(String text) {
        int timeCounter=0;
        while(!isTextPresent(text)&&AutomationConstants.MAX_TIMEOUTS>timeCounter)
        {
            try {
                System.out.print("Waiting for 1 sec");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeCounter++;
        }
        return isTextPresent(text);
    }

    public static void waitForElementToBeClickable(By by) {
        System.out.println("Waiting for element to be clickable " + by);
        WebDriverWait webDriverWait = new WebDriverWait(BrowserFactory.getDriver(), AutomationConstants.MAX_TIMEOUTS);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));

    }

    public static void waitForElementToBeClickableAndClick(By by) {
        waitForElementToBeClickable(by);
        BrowserFactory.getDriver().findElement(by).click();
    }

    public static void sleep(int i) {
        try {
            Thread.sleep(i*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void mouseHover(WebElement webElement)
    {
        Actions action = new Actions(BrowserFactory.getDriver());
      //  action.moveToElement(webElement).perform();
        action.moveToElement(webElement).click().perform();

    }

    public static void gotoViewCourses(String courseName)
    {
        for(WebElement element:BrowserFactory.getDriver().findElements(By.className("skill_section")))
        {
            if(element.getText().contains(courseName))
            {

                BrowserFactory.getDriver().get(element.findElement(By.tagName("a")).getAttribute("href"));
                return;
            }
        }
    }

    public static void selectByLinkText(By by){
        BrowserFactory.getDriver().findElement(by).click();
    }
}
