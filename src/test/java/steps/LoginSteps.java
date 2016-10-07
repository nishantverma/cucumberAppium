package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginSteps {

    protected AndroidDriver driver;

    @Given("^I am on the Go-Jek app log in page$")
    public void iAmOnTheGoJekAppLogInPage() throws Throwable {

        File appDir = new File("app");
        File app = new File(appDir, "app-staging-release.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //mandatory capabilities
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "Android");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @When("^I log in with \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iLogInWithAndPasswordAs(String emailId, String passWord) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input_email")));
        driver.findElement(By.id("input_email")).sendKeys(emailId);
        driver.findElement(By.id("input_password")).sendKeys(passWord);
        driver.findElement(By.id("button_signin")).click();

    }

    @Then("^I should be able to see Go-Pay Balance$")
    public void iShouldBeAbleToSeeGoPayBalance() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("text_gopay_balance")));
        Assert.assertTrue(!driver.findElement(By.id("text_gopay_balance")).getText().isEmpty());
        driver.quit();
    }

}
