package pomscripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;
import pages.DefaultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DefaultPageAfterLogin;
import pages.LoginModal;

import java.time.Duration;

public class SmokeTests extends BaseTest {

    @Test
    public void createAccount(){
        driver.get("http://training.skillo-bg.com/");
    }

    @Test
    public void loginTest(){
        driver.get("http://training.skillo-bg.com/");
        defaultPage.clickLoginButton();
        loginModal.enterUsername("Dimana.ivanova");
        loginModal.enterPassword("Dimana.97");
        loginModal.clickSignIn();
    }

    @Test
    public void registerTest(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.clickRegisterButton();
        signUpPage.registerUser();
    }

    @Test
    public void likePost(){
        driver.get("http://training.skillo-bg.com/users/login");
        loginModal.login();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nav-link-new-post"))));
        defaultPageAfterLogin.openPost();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[@class='like far fa-heart fa-2x']"))));
        postModalWindow.clickLikePostButton();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='like far fa-heart fa-2x liked']")).isDisplayed());
    }


    @Test
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
