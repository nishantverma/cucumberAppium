package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class StartingSteps extends BaseSteps {

    @Before
    public void initializeAppiumSession() throws MalformedURLException {
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

    @After
    public void killsession()
    {
        driver.quit();
    }
}
