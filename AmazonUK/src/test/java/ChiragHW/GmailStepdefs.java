package ChiragHW;

import ChiragHW.Hooks;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class GmailStepdefs extends Hooks{
    @Given("^customer is on google homepage$")
    public void customerIsOnGoogleHomepage() throws Throwable {
       driver.findElement(By.id("hplogo")).isDisplayed();
       Thread.sleep(3000);
    }

    @When("^User click on Gmail button from Toolbar$")
    public void userClickOnGmailButtonFromToolbar() throws Throwable {
      driver.findElement(By.partialLinkText("Gmail")).click();
      driver.findElement(By.xpath("html/body/nav/div/a[2]")).click();
      Thread.sleep(3000);
    }

    @And("^Type User name and password$")
    public void typeUserNameAndPassword() throws Throwable {
        driver.findElement(By.id("identifierId")).sendKeys("chirag2104@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='identifierNext']/content")).click();
        driver.findElement(By.name("password")).sendKeys("Chir@2017");
        Thread.sleep(3000);
    }

    @And("^Click Next button$")
    public void clickNextButton() throws Throwable {
        driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
        Thread.sleep(3000);
    }

    @Then("^User can see gmail homepage$")
    public void userCanSeeGmailHomepage() throws Throwable {
        driver.getPageSource().contains("Inbox");
        Thread.sleep(3000);
    }
}
