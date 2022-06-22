package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyProfilePage extends BasePage{

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    By allPostsButton = By.xpath("//label[@class='btn-all btn btn-primary active']");
    By publicPostsButton = By.xpath("//label[@class='btn-public btn btn-primary']");
    By privatePostsButton = By.xpath("//label[@class='btn-private btn btn-primary']");
    By editProfileButton = By.xpath("//i[@class='fas fa-user-edit ng-star-inserted']");
    By uploadImageButton = By.id("upload-img");
    By followersButton = By.id("followers");
    By followingButton = By.id("following");

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
}
