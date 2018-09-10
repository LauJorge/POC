package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://github.com/")
public class HomePage extends PageObject {
    private String url = "";

    private By welcomenMessageLocator = By.id("js-pjax-container");
    private By btnStartAProjectLocator = By.xpath("//*[@id=\"js-pjax-container\"]/div[1]/div/div/a[2]\n");
    private WebElement welcomeMessage;
    private WebElement btnStartAProject;

    public HomePage(WebDriver driver) {
        super(driver);
        welcomeMessage = find(welcomenMessageLocator);
        btnStartAProject = find(btnStartAProjectLocator);
    }

    public CreateRepoPage goToNewRepoPage() {
        btnStartAProject.click();
        return new CreateRepoPage(getDriver());
    }

    public boolean isAtHomePage() {
        return welcomeMessage.isDisplayed();
    }

}
