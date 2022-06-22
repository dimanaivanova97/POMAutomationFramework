package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewPostPage extends BasePage{

    public NewPostPage(WebDriver driver) {
        super(driver);
    }

    By browseForPictureButton = By.xpath("//button[@class='browse btn btn-primary input-lg']");
    By submitButton = By.id("create-post");
    By privatePublicToggle = By.xpath("//label[@for='customSwitch2']");
    By captionField = By.xpath("//input[@name='caption']");

    public void clickBrowseButton(){
        driver.findElement(browseForPictureButton);
    }
    public void clickSubmitButton(){
        driver.findElement(submitButton);
    }
    public void clickPrivatePublicToggle(){
        driver.findElement(privatePublicToggle);
    }
    public void enterPostCaption(String caption){
        driver.findElement(captionField).clear();
        driver.findElement(captionField).sendKeys(caption);
    }
}
