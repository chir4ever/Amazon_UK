package ChiragHW;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class LogInStepdefs extends Hooks {
    @When("^User click on Sign up button$")
    public void userClickOnSignUpButton() throws Throwable {
        driver.get("https://www.amazon.co.uk/ref=ap_frn_logo");
        System.out.println("I am on Homepage");
        driver.findElement(By.xpath("//span[text()='Hello. Sign in']")).click();
       // driver.findElement(By.partialLinkText("Your Account")).click(); ** Doesn't work very well..
        driver.findElement(By.id("createAccountSubmit")).click();
    }

    @And("^Fill up require details as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void fillUpRequireDetailsAs(String Name, String Password, String ReEnterPS) throws Throwable {

        final String randomEmail = randomEmail();
        WebElement email = driver.findElement(By.id("ap_email"));

        // Type the random email to the form
        email.sendKeys(randomEmail);
        Thread.sleep(3000);
        driver.findElement(By.id("ap_customer_name")).sendKeys(Name);
       // driver.findElement(By.id("ap_email")).sendKeys("samp2002@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys(Password);
        driver.findElement(By.id("ap_password_check")).sendKeys(ReEnterPS);
    }

    @And("^click on sign up button$")
    public void clickOnSignUpButton() throws Throwable {
        driver.findElement(By.id("continue")).click();
        Thread.sleep(5000);
    }

    @Then("^User should get \"([^\"]*)\" message after registration$")
    public void userShouldGetMessageAfterRegistration(String Result) throws Throwable {
        boolean isTheTextPresent = driver.getPageSource().contains(Result);
        assertTrue(isTheTextPresent);
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }


    @When("^Use Log In successfully$")
    public void useLogInSuccessfully() throws Throwable {
        driver.findElement(By.xpath("//span[text()='Hello. Sign in']")).click();
        driver.findElement(By.id("ap_email")).sendKeys("samp2005@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("Danial");
        driver.findElement(By.id("signInSubmit")).click();

    }

    @Then("^User should get \"([^\"]*)\" message on the screen$")
    public void userShouldGetMessageOnTheScreen(String WelcomeMessage) throws Throwable {
        Boolean LogInCheck = driver.getPageSource().contains(WelcomeMessage);
        assertTrue(LogInCheck);
        Thread.sleep(3000);
       // driver.findElement(By.id("nav-item-signout")).click();
        //Boolean LogOutCheck = driver.getPageSource().contains("Hello. Sign in");
        //assertTrue(LogInCheck);
        System.out.println("I log in successfully.");
    }

    @When("^User search for items as \"([^\"]*)\"$")
    public void userSearchForItemsAs(String ItemName) throws Throwable {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(ItemName);
        driver.findElement(By.className("nav-input")).click();
        driver.findElement(By.name("s-ref-checkbox-419158031")).click();
        Select SortBy = new Select(driver.findElement(By.id("sort")));
        SortBy.selectByVisibleText("Price: High to Low");
        if (!driver.findElement(By.linkText(ItemName)).isEnabled()) {

        }
    }

    @And("^add them to the shopping list$")
    public void addThemToTheShoppingList() throws Throwable {
        driver.findElement(By.id("add-to-cart-button"));
        Thread.sleep(3000);
    }

    @Then("^Shopping trolley should display correct items as \"([^\"]*)\"$")
    public void shoppingTrolleyShouldDisplayCorrectItemsAs(String ItemName) throws Throwable {
        driver.findElement(By.xpath(".//*[@id='nav-cart-count']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        boolean checkShoppingList = driver.getPageSource().contains(ItemName);
        assertTrue(checkShoppingList);
    }

}