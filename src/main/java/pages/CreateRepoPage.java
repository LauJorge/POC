package pages;

import model.User;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

@DefaultUrl("https://github.com/new")
public class CreateRepoPage extends PageObject {

    public CreateRepoPage(WebDriver driver) {
        super(driver);
    }

    private By repoNameLocator = By.id("repository_name");
    private By btnNewRepoLocator = By.xpath("//*[@id=\"new_repository\"]/div[3]/button");
    private By descRepoLocator = By.id("repository_description");
    private By checkReadme = By.id("repository_auto_init");
    Random rand = new Random();

    int  n = rand.nextInt(500) + 1;

    public String getRepoName() {
        return repoName;
    }

    private String repoName = "Repositorio creado con automation, version:" + n;


    public void writeName() {
       find(repoNameLocator).sendKeys(repoName);
    }
    public void createRepoClick(){
        find(btnNewRepoLocator).click();
    }
    public void writeDescription() {

        String repoDescrip = "Descripcion de repositorio creado con automation, version:" + n;

        find(descRepoLocator).sendKeys(repoDescrip);
    }
    public void checkReadme(){
        find(checkReadme).click();
    }

}