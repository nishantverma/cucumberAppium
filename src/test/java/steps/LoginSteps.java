package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LoginPage;

import static steps.StartingSteps.driver;

public class LoginSteps {

    @Given("^I am on the Go-Jek app log in page$")
    public void iAmOnTheGoJekAppLogInPage() throws Throwable {
        System.out.println("hello world");
    }

    @When("^I log in with \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iLogInWithAndPasswordAs(String emailId, String passWord) throws Throwable {
        new LoginPage(driver).login(emailId,passWord);
    }

    @Then("^I should be able to see Go-Pay Balance$")
    public void iShouldBeAbleToSeeGoPayBalance() throws Throwable {
        new HomePage(driver).verifyGoPayBalance();
    }

}
