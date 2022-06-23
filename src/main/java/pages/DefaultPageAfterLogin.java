package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**The page that is opened after the User logged in */

public class DefaultPageAfterLogin extends BasePage{

    public DefaultPageAfterLogin(WebDriver driver) {
        super(driver);
    }

    By newPostLink = By.id("nav-link-new-post");
    By logOutIcon = By.xpath("//i [@class='fas fa-sign-out-alt fa-lg']");
    By openPost = By.xpath("//div[@class='post-feed-img']//img[1]");
    By myProfile = By.id("nav-link-profile");

    public void clickNewPostLink(){
        driver.findElement(newPostLink).click();
    }
    public void clickLogOutIcon() {
        driver.findElement(logOutIcon).click();
    }
    public void openPost(){
        driver.findElement(openPost).click();
    }

    public void clickProfileLink(){
        driver.findElement(myProfile).click();
    }
}

