package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostModalWindow extends BasePage{

    public PostModalWindow(WebDriver driver) {
        super(driver);
    }

    By likePostButton = By.xpath("//div[@class='modal-content']//i[@class='like far fa-heart fa-2x']");
    By dislikePostButton = By.xpath("//div[@class='modal-content']//i[@class='ml-4 far fa-thumbs-down fa-2x']");
    By lockUnlockPostButton = By.xpath("//i[@class='fas fa-unlock ng-star-inserted']");
    By deletePostButton = By.xpath("//label[@class='delete-ask']");
    By userPostNavigationProfile = By.xpath("//div[@class='modal-content']//a[@class='post-user']");
    By commentField = By.xpath("//input[@placeholder='Comment here']");
    By followUserButton = By.xpath("//button[@class='btn btn-primary ng-star-inserted']");

    public void clickLikePostButton(){
        driver.findElement(likePostButton).click();
    }
    public void clickDislikePostButton(){
        driver.findElement(dislikePostButton).click();
    }
    public void clickLockUnlockPostButton(){
        driver.findElement(lockUnlockPostButton).click();
    }
    public void clickDeletePostButton(){
        driver.findElement(deletePostButton).click();
    }
    public void clickUserOfPostNavigationToProfile(){
        driver.findElement(userPostNavigationProfile).click();
    }

    public void setComment(String comment) {
        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys(comment);
    }
}
