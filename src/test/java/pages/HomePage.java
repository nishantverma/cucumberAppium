package pages;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class HomePage extends BasePage {

    @FindBy(id = "text_gopay_balance")
    private WebElement goPayBalance;


    public HomePage(AndroidDriver driver) throws MalformedURLException {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void verifyGoPayBalance() throws MalformedURLException {
        waitForElement(goPayBalance);
        Assert.assertTrue(!goPayBalance.getText().isEmpty());
    }
}
