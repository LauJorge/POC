package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://github.com/LauJorge")
public class RepoPage extends PageObject {

    public RepoPage(WebDriver driver) {
        super(driver);
    }

    private By repoNameLocator = By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/div/h1/strong/a");

    public boolean isAtRepoPage() {
        return find(repoNameLocator).isDisplayed();
    }


}
