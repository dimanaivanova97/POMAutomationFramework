package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsersProfilePage extends BasePage{

    public UsersProfilePage(WebDriver driver) {
        super(driver);
    }

    By allPostsButton = By.xpath("//label[@class='btn-all btn btn-primary disabled']");
    By publicPostsButton = By.xpath("//label[@class='btn-public btn btn-primary']");
    By privatePostsButton = By.xpath("//label[@class='btn-private btn btn-primary disabled']");
    By editProfileButton = By.xpath("//i[@class='fas fa-user-edit ng-star-inserted']");
    By uploadImageButton = By.id("upload-img");
    By followersButton = By.id("followers");
    By followingButton = By.id("following");
    By followButton = By.xpath("//button[@class='btn btn-primary profile-edit-btn ng-star-inserted']");
    By profilePicture = By.xpath("//img[@class='profile-image-source']");
    By userName = By.xpath("//div[@class='col-12 col-lg-6 profile-user-settings']");

    public void clickAllPostsButton(){
        driver.findElement(allPostsButton).click();
    }
    public void clickPublicPostsButton(){
        driver.findElement(publicPostsButton).click();
    }
    public void clickPrivatePostsButton(){
        driver.findElement(privatePostsButton).click();
    }
    public void clickEditProfileButton(){
        driver.findElement(editProfileButton).click();
    }
    public void clickUploadImageButton(){
        driver.findElement(uploadImageButton).click();
    }
    public void openFollowersModal(){
        driver.findElement(followersButton).click();
    }
    public void openFollowingModal(){
        driver.findElement(followingButton).click();
    }
    public void followUser(){
        driver.findElement(followButton).click();
    }

    public WebElement allPostsButton() {
        return driver.findElement(allPostsButton);
    }

    public WebElement publicPostsButton() {
        return driver.findElement(privatePostsButton);
    }

    public WebElement privatePostsButton() {
        return driver.findElement(privatePostsButton);
    }

    public WebElement followersButton() {
        return driver.findElement(followersButton);
    }

    public WebElement followingButton() {
        return driver.findElement(followingButton);
    }

    public WebElement followButton() {
        return driver.findElement(followButton);
    }

    public WebElement profilePicture() {
        return driver.findElement(profilePicture);
    }

    public WebElement userName() {
        return driver.findElement(userName);
    }

}
