package pomscripts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTests extends BaseTest {

    @Test(priority = 1)
    public void registerTest(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.clickRegisterButton();
        signUpPage.registerUser();
    }

    @Test(priority = 2)
    public void loginTest(){
        driver.get("http://training.skillo-bg.com/");
        defaultPage.clickLoginButton();
        loginModal.enterUsername("Dimana.ivanova");
        loginModal.enterPassword("Dimana.97");
        loginModal.clickSignIn();
    }

    @Test(priority = 3)
    public void likePost(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nav-link-new-post"))));
        defaultPageAfterLogin.openPost();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[@class='like far fa-heart fa-2x']"))));
        postModalWindow.clickLikePostButton();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='like far fa-heart fa-2x liked']")).isDisplayed());
    }

    @Test(priority = 4)
    public void dislikePost(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nav-link-new-post"))));
        defaultPageAfterLogin.openPost();
        postModalWindow.clickDislikePostButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[@class='ml-4 far fa-thumbs-down fa-2x liked']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='toast-success ngx-toastr ng-trigger ng-trigger-flyInOut']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='ml-4 far fa-thumbs-down fa-2x liked']")).isDisplayed());
    }

    @Test(priority = 5)
    public void followUser(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nav-link-new-post"))));
        defaultPageAfterLogin.openPost();
        postModalWindow.clickFollowUser();
        WebElement followButton = driver.findElement(By.xpath("//div[@class='modal-content']//button[contains(text(), 'Unfollow')]"));
        Assert.assertTrue(followButton.isDisplayed());
    }

    @Test(priority = 6)
    public void navigateToUsersProfile(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nav-link-new-post"))));
        defaultPage.clickOnUsersLink();
        WebElement profilePicture = driver.findElement(By.xpath("//img[@class='profile-image-source']"));
        WebElement userName = driver.findElement(By.xpath("//div[@class='col-12 col-lg-6 profile-user-settings']"));
        Assert.assertTrue(profilePicture.isDisplayed());
        Assert.assertTrue(userName.isDisplayed());
    }

    @Test(priority = 7)
    public void navigateToMyProfile(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nav-link-new-post"))));
        defaultPageAfterLogin.clickProfileLink();
        WebElement profilePicture = driver.findElement(By.xpath("//img[@class='profile-image-source']"));
        WebElement userName = driver.findElement(By.xpath("//div[@class='col-12 col-lg-6 profile-user-settings']"));
        Assert.assertTrue(profilePicture.isDisplayed());
        Assert.assertTrue(userName.isDisplayed());
    }

    @Test(priority = 8)
    public void followersModal(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nav-link-new-post"))));
        defaultPageAfterLogin.clickProfileLink();
        myProfilePage.openFollowersModal();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='container followers-modal-container']"))));
        WebElement header = driver.findElement(By.xpath("//div[@class='col-12 modal-header']"));
        WebElement list = driver.findElement(By.xpath("//div[@class='row user-list-container']//div[@class='col-12']"));
        Assert.assertEquals(header.getText(), "Followers");
    }

    @Test(priority = 9)
    public void followingsModal(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nav-link-new-post"))));
        defaultPageAfterLogin.clickProfileLink();
        myProfilePage.openFollowingModal();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='container followers-modal-container']"))));
        WebElement header = driver.findElement(By.xpath("//div[@class='col-12 modal-header']"));
        WebElement list = driver.findElement(By.xpath("//div[@class='row user-list-container']//div[@class='col-12']"));
        Assert.assertEquals(header.getText(), "Following");
    }

    @Test(priority = 10)
    public void modifyProfileInfo(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nav-link-new-post"))));
        defaultPageAfterLogin.clickProfileLink();
        myProfilePage.clickEditProfileButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='container profile-edit-container']"))));
        WebElement header = driver.findElement(By.xpath("//div[@class='col-md-12 form-header']"));
        WebElement publicInfoField = driver.findElement(By.xpath("//textarea[@formcontrolname='publicInfo']"));
        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
        Assert.assertEquals(header.getText(), "Modify Your Profile");
        publicInfoField.click();
        publicInfoField.clear();
        publicInfoField.sendKeys("Learning automation.");
        saveButton.click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='container profile-edit-container']"))));
        WebElement publicInfo = driver.findElement(By.xpath("//div[@class='col-12']//p"));
        Assert.assertEquals(publicInfo.getText(), "Dimana.ivanova  Learning automation. \uD83D\uDCF7✈️\uD83C\uDFD5️");
    }

    @Test(priority = 11)
    public void logOut(){
        driver.get("http://training.skillo-bg.com/");
        defaultPage.clickLoginButton();
        loginModal.enterUsername("Dimana.ivanova");
        loginModal.enterPassword("Dimana.97");
        loginModal.clickSignIn();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nav-link-new-post"))));
        defaultPageAfterLogin.clickLogOutIcon();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://training.skillo-bg.com/users/login" );
    }
}
