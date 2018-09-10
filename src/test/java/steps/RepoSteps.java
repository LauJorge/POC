package steps;

import cucumber.api.PendingException;
import model.User;
import pages.CreateRepoPage;
import pages.HomePage;
import pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.RepoPage;

public class RepoSteps {

    LoginPage loginPage;
    HomePage homePage;
    User user;
    CreateRepoPage createRepo;
    RepoPage rp;

    @Given("^I am logged in Github as \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iAmLoggedInGithubAsAndPassword(String username, String password) throws Throwable {
        user = new User();
        user.setUserName(username);
        user.setPassword(password);
        loginPage.open();

    }
    @And("^I am logged$")
    public void iAmLogged() throws Throwable {
        homePage = loginPage.login(user);
    }
    @When("^I click on the start new repository$")
    public void iClickOnTheStartNewRepository() throws Throwable {
        homePage.goToNewRepoPage();
    }

    @Then("^I should see the Create Repository Page$")
    public void iShouldSeeTheCreateRepositoryPage() throws Throwable {
        createRepo.open();
    }

    @And("^I am on the Create Repository Page$")
    public void iAmOnTheCreateRepositoryPage() throws Throwable {
        createRepo.open();
   }

    @And("^I write as repository name \"([^\"]*)\"$")
    public void iWriteAsRepositoryName(String arg0) throws Throwable {
        createRepo.writeName();
    }

    @When("^I submit the new repository$")
    public void iSubmitTheNewRepository() throws Throwable {
    createRepo.createRepoClick();
    }

    @And("^I write a repostirory description$")
    public void iWriteARepostiroryDescription() throws Throwable {
        createRepo.writeDescription();
    }

    @And("^I select initialize with readme$")
    public void iSelectInitializeWithReadme() throws Throwable {
        createRepo.checkReadme();
    }

    @Then("^I should see my repository created$")
    public void iShouldSeeMyRepositoryCreated() throws Throwable {
        rp.isAtRepoPage();
    }
}

