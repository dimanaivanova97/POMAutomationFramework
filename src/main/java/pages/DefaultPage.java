package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**The page that is opened after the URL is hit */
public class DefaultPage extends BasePage{

    public DefaultPage(WebDriver driver) {
        super(driver);
    }

    By loginButton = By.id("nav-link-login");

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    By siteLogo = By.id("homeIcon");

    public void clickSiteLogo() {
        driver.findElement(siteLogo).click();
    }

    By homeLink = By.id("nav-link-home");

    public void clickHomeLink() {
        driver.findElement(homeLink).click();
    }
}
