package ChiragHW;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class SmokeStepdefs extends Hooks{

    HomePage homePage;

    @Given("^User is on Home Page$")
    public void userIsOnTheHomePage() {
        driver.get(AutomationConstants.URL);
    }

    @Then("^Following buttons as \"([^\"]*)\"\"([^\"]*)\" should be present on homepage$")
    public void followingButtonAsShouldBePresent(String ButtonID, String ButtonName) throws Throwable {

    //    homePage.checkButtonPresent(ButtonID);

        boolean isTheTextPresent = driver.getPageSource().contains(ButtonID);
        assertTrue(isTheTextPresent);
        System.out.println("'"+ButtonName+"'" + " is present.");
    }

    @And("^User should able to click each button \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\" individually$")
    public void userShouldAbleToClickEachButtonIndividually(String ButtonID, String ButtonName, String ClickMessage) throws Throwable {
    driver.findElement(By.partialLinkText(ButtonID)).click();
   //Thread.sleep(3000);
    Boolean IsPageDisplay = driver.getPageSource().contains(ClickMessage);
    assertTrue(IsPageDisplay);
    System.out.println("'"+ ButtonName + "'" + " page is displayed correctly.");
    driver.navigate().back();
    }
}
