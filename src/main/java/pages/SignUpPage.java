package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input[@name='username']")
    WebElement usernameField;

    @FindBy(xpath="//input[@formcontrolname='email']")
    WebElement emailField;

    @FindBy(xpath="//input[@name='password']")
    WebElement passwordField;

    @FindBy(xpath="//input[@formcontrolname='confirmPassword']")
    WebElement confirmPasswordField;

    @FindBy(id="sign-in-button")
    WebElement signUpButton;

    public void inputUserName(){
        usernameField.sendKeys("Dimana.1");
    }

    public void inputEmail(){
        emailField.sendKeys("Dimana.1@abv.bg");
    }

    public void inputPassword(){
        passwordField.sendKeys("Dimana.1");
    }

    public void inputConfirmPassword(){
        confirmPasswordField.sendKeys("Dimana.1");
    }

    public void clickSignUp(){
        signUpButton.click();
    }

    public void registerUser(){
        inputUserName();
        inputPassword();
        inputEmail();
        inputPassword();
        inputConfirmPassword();
        clickSignUp();
    }
}
