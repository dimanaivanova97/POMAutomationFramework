package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PostModalWindow extends BasePage{

    public PostModalWindow(WebDriver driver) {
        super(driver);
    }

    By likePostButton = By.xpath("//div[@class='modal-content']//i[@class='like far fa-heart fa-2x']");
    By unlikePostButton = By.xpath("//div[@class='modal-content']//i[@class='like far fa-heart fa-2x liked']");
    By dislikePostButton = By.xpath("//div[@class='modal-content']//i[@class='ml-4 far fa-thumbs-down fa-2x']");
    By lockPostButton = By.xpath("//i[@class='fas fa-unlock ng-star-inserted']");
    By unlockPostButton = By.xpath("//i[@class='fas fa-lock ng-star-inserted']");
    By deletePostButton = By.xpath("//label[@class='delete-ask']");
    By userPostNavigationProfile = By.xpath("//div[@class='modal-content']//a[@class='post-user']");
    By commentField = By.xpath("//input[@placeholder='Comment here']");
    By followUserButton = By.xpath("//div[@class='modal-content']//button[@class='btn btn-primary ng-star-inserted']");
    By modalWindow = By.xpath("//i[@class='like far fa-heart fa-2x']");

    public void clickLikePostButton(){
        driver.findElement(likePostButton).click();
    }
    public void clickDislikePostButton(){
        driver.findElement(dislikePostButton).click();
    }
    public void clickLockPostButton(){
        driver.findElement(lockPostButton).click();
    }
    public void clickUnlockPostButton(){
        driver.findElement(unlockPostButton).click();
    }
    public void clickDeletePostButton(){
        driver.findElement(deletePostButton).click();
    }
    public void clickUserOfPostNavigationToProfile(){
        driver.findElement(userPostNavigationProfile).click();
    }
    public void clickFollowUser() {
        driver.findElement(followUserButton).click();
    }
    public void clickUnlikePostButton() {
        driver.findElement(unlikePostButton).click();
    }

    public void setComment(String comment) {
        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys(comment);
    }

    public WebElement getLikePostButton() {
        return driver.findElement(likePostButton);
    }

    public WebElement getDislikePostButton() {
        return driver.findElement(dislikePostButton);
    }

    public WebElement followUserButton() {
        return driver.findElement(followUserButton);
    }

    public WebElement postModal() {
        return driver.findElement(modalWindow);
    }
}
