package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginModal extends BasePage{

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    By userNameField = By.id("defaultLoginFormUsername");
    By passwordField = By.id("defaultLoginFormPassword");
    By signInButton = By.id("sign-in-button");
    By registerButton = By.xpath("//a[@href='/users/register']");

    public void enterUsername(String username){
        driver.findElement(userNameField).clear();
        driver.findElement(userNameField).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignIn(){
        driver.findElement(signInButton).click();
    }

    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

    public void login(){
        driver.findElement(userNameField).clear();
        driver.findElement(userNameField).sendKeys("dimana.ivanova");
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys("Dimana.97");
        driver.findElement(signInButton).click();
    }
}
