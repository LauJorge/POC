package pages;

import org.openqa.selenium.By;

import model.User;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriver;


@DefaultUrl("https://github.com/login")
public class LoginPage extends PageObject {

    private By logInButtonLocator = By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]");
    private By invalidLoginMessageLocator = By.xpath("//*[@id=\"js-flash-container\"]/div/div");
    private By emailLocator = By.id("login_field");
    private By passwordLocator = By.id("password");

    @WhenPageOpens
    public void waitUntilTitleAppears() {
        element(logInButtonLocator).waitUntilVisible();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(User user) {
        find(emailLocator).sendKeys(user.getUserName());
        find(passwordLocator).sendKeys(user.getPassword());
        find(logInButtonLocator).click();
        HomePage hp = this.switchToPage(HomePage.class);
        return hp;
    }

    public LoginPage attemptsFailedLogin(User user) {
        find(emailLocator).sendKeys(user.getUserName());
        find(passwordLocator).sendKeys(user.getPassword());
        find(logInButtonLocator).click();
        return this;
    }

    public boolean isLoginInvalid() {
        return find(invalidLoginMessageLocator).isDisplayed();
    }



}
