package steps;

import model.User;
import pages.HomePage;
import pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

    LoginPage loginPage;
    HomePage homePage;
    User user;


    @Given("^I sign in as \"([^\"]*)\" has a password \"([^\"]*)\"$")
    public void iSignInAsHasAPassword(String username, String password) throws Throwable {
        user = new User();
        user.setUserName(username);
        user.setPassword(password);
        loginPage.open();
    }

    @When("^I start session$")
    public void iStartSession() throws Throwable {
        homePage = loginPage.login(user);
    }

    @Then("^I should be Home$")
    public void iShouldBeHome() throws Throwable {
        homePage.isAtHomePage();
    }

    @Given("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAnd(String username, String password) throws Throwable {
        user = new User();
        user.setUserName(username);
        user.setPassword(password);
    }

    @When("^I try to login$")
    public void iTryToLogin() throws Throwable {
        loginPage.attemptsFailedLogin(user);
    }

    @Then("^I should be rejected$")
    public void iShouldBeRejected() throws Throwable {
        loginPage.isLoginInvalid();
    }
}
