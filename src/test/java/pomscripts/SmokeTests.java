package pomscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SmokeTests extends BaseTest {

    @Test(priority = 1)
    public void registerAlreadyCreatedUser(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.clickRegisterButton();
        signUpPage.registerUser();
        WebElement toastMessage = driver.findElement(By.id("toast-container"));
        Assert.assertEquals(toastMessage.getText(), "Username taken");
    }

    @Test(priority = 2)
    public void loginTest(){
        driver.get("http://training.skillo-bg.com/");
        defaultPage.clickLoginButton();
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(defaultPageAfterLogin.getNewPostLink()));
        Assert.assertEquals(defaultPageAfterLogin.getMyProfile().getText(), "Profile");
        Assert.assertTrue(defaultPageAfterLogin.getLogOutIcon().isDisplayed());
    }

    @Test(priority = 3)
    public void likePost(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(defaultPageAfterLogin.getNewPostLink()));
        defaultPageAfterLogin.openPost();
        wait.until(ExpectedConditions.visibilityOf(postModalWindow.postModal()));
        postModalWindow.clickLikePostButton();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='like far fa-heart fa-2x liked']")).isDisplayed());
        postModalWindow.clickUnlikePostButton();
    }

    @Test(priority = 4)
    public void dislikePost(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(defaultPageAfterLogin.getNewPostLink()));
        defaultPageAfterLogin.openPost();
        wait.until(ExpectedConditions.visibilityOf(postModalWindow.getDislikePostButton()));
        postModalWindow.clickDislikePostButton();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='toast-success ngx-toastr ng-trigger ng-trigger-flyInOut']")).getText(), "Post disliked");
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='ml-4 far fa-thumbs-down fa-2x liked']")).isDisplayed());
    }

    @Test(priority = 5)
    public void followUnfollowUser() throws InterruptedException {
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(defaultPageAfterLogin.getNewPostLink()));
        defaultPageAfterLogin.openPost();
        postModalWindow.clickFollowUser();
        Thread.sleep(1000);
        Assert.assertEquals(postModalWindow.followUserButton().getText(), "Unfollow");
        postModalWindow.clickFollowUser();
        Thread.sleep(1000);
        Assert.assertEquals(postModalWindow.followUserButton().getText(), "Follow");
    }

    @Test(priority = 6)
    public void usersProfile(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(defaultPageAfterLogin.getNewPostLink()));
        defaultPage.clickOnUsersLink();

        Assert.assertTrue(usersProfilePage.userName().isDisplayed());
        Assert.assertTrue(usersProfilePage.profilePicture().isDisplayed());
        Assert.assertTrue(usersProfilePage.allPostsButton().isDisplayed());
        Assert.assertTrue(usersProfilePage.followButton().isDisplayed());
        Assert.assertTrue(usersProfilePage.followingButton().isDisplayed());
        Assert.assertTrue(usersProfilePage.followersButton().isDisplayed());
        Assert.assertTrue(usersProfilePage.privatePostsButton().isDisplayed());
        Assert.assertTrue(usersProfilePage.publicPostsButton().isDisplayed());
    }

    @Test(priority = 7)
    public void myProfile() {
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(defaultPageAfterLogin.getNewPostLink()));
        defaultPageAfterLogin.clickProfileLink();
        Assert.assertTrue(myProfilePage.getEditProfileButton().isDisplayed());
        Assert.assertTrue(myProfilePage.getFollowingButton().isDisplayed());
        Assert.assertTrue(myProfilePage.getAllPostsButton().isDisplayed());
        Assert.assertTrue(myProfilePage.getProfilePicture().isDisplayed());
        Assert.assertTrue(myProfilePage.getFollowersButton().isDisplayed());
        Assert.assertTrue(myProfilePage.getPrivatePostsButton().isDisplayed());
        Assert.assertTrue(myProfilePage.getPublicPostsButton().isDisplayed());
    }

    @Test(priority = 8)
    public void followersModal(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(defaultPageAfterLogin.getNewPostLink()));
        defaultPageAfterLogin.clickProfileLink();
        myProfilePage.openFollowersModal();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='container followers-modal-container']"))));
        WebElement header = driver.findElement(By.xpath("//div[@class='col-12 modal-header']"));
        Assert.assertEquals(header.getText(), "Followers");
    }

    @Test(priority = 9)
    public void followingsModal(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(defaultPageAfterLogin.getNewPostLink()));
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
        wait.until(ExpectedConditions.visibilityOf(defaultPageAfterLogin.getNewPostLink()));
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

//    @Test(priority = 11)
//    public void makePostsPrivate() throws InterruptedException {
//        driver.get("http://training.skillo-bg.com/users/login");
//        loginModal.login();
//        wait.until(ExpectedConditions.visibilityOf(defaultPageAfterLogin.getNewPostLink()));
//        defaultPageAfterLogin.clickProfileLink();
//        Thread.sleep(3000);
//        js.executeScript("window.scrollBy(0,2000)");
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='gallery-item']"))));
//        List<WebElement> publicPictures = driver.findElements(By.xpath("//div[@class='gallery-item']"));
//
//        for (int i = 1; i <= publicPictures.size(); i++) {
//            myProfilePage.openPostModal();
//            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='post-modal-container']"))));
//            postModalWindow.clickLockPostButton();
//            actions.sendKeys(Keys.ESCAPE).perform();
//            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='col-12 ng-star-inserted']//div[@class='container']"))));
//        }
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='posts-not-found-container ng-star-inserted']"))));
//        WebElement newPostElement = driver.findElement(By.xpath("//div[@class='posts-not-found-container ng-star-inserted']//a[@href='/posts/create']"));
//        Assert.assertEquals(newPostElement.getText(), "New post");
//    }
//
//    @Test(priority = 11)
//    public void makePostsPublic(){
//        driver.get("http://training.skillo-bg.com/users/login");
//        loginModal.login();
//        wait.until(ExpectedConditions.visibilityOf(defaultPageAfterLogin.getNewPostLink()));
//        defaultPageAfterLogin.clickProfileLink();
//        myProfilePage.clickPrivatePostsButton();
//        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();;
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='gallery-item']"))));
//        List<WebElement> privatePictures = driver.findElements(By.xpath("//div[@class='gallery-item']"));
//
//        for (int i = 1; i <= privatePictures.size(); i++) {
//            myProfilePage.openPostModal();
//            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='post-modal-container']"))));
//            postModalWindow.clickUnlockPostButton();
//            actions.sendKeys(Keys.ESCAPE).perform();
//            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='col-12 ng-star-inserted']//div[@class='container']"))));
//        }
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='posts-not-found-container ng-star-inserted']"))));
//        WebElement newPostElement = driver.findElement(By.xpath("//div[@class='posts-not-found-container']"));
//        Assert.assertEquals(newPostElement.getText(), "New post");
//    }

    @Test(priority = 11)
    public void logOut() throws InterruptedException {
        driver.get("http://training.skillo-bg.com/");
        defaultPage.clickLoginButton();
        loginModal.enterUsername("Dimana.ivanova");
        loginModal.enterPassword("Dimana.97");
        loginModal.clickSignIn();
        List<WebElement> logOutButton = driver.findElements(By.id("nav-link-new-post"));
        List<WebElement> newPostButton = driver.findElements(By.xpath("//i[@class='fas fa-sign-out-alt fa-lg']"));

        wait.until(ExpectedConditions.visibilityOf(defaultPageAfterLogin.getNewPostLink()));
        defaultPageAfterLogin.clickLogOutIcon();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://training.skillo-bg.com/users/login" );
    }
}
