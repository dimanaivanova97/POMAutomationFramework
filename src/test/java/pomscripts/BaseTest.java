package pomscripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.Screenshot;
import org.testng.ITestResult;

import java.time.Duration;


public class BaseTest {
    WebDriver driver;

    WebDriverWait wait;
    DefaultPage defaultPage;
    LoginModal loginModal;
    DefaultPageAfterLogin defaultPageAfterLogin;
    SignUpPage signUpPage;
    PostModalWindow postModalWindow;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        defaultPage = new DefaultPage(driver);
        loginModal = new LoginModal(driver);
        defaultPageAfterLogin = new DefaultPageAfterLogin(driver);
        signUpPage = new SignUpPage(driver);
        postModalWindow = new PostModalWindow(driver);
    }

    @AfterTest
    public void tearDown(ITestResult result){
        if (!result.isSuccess()){
            Screenshot.capture(driver, "screenshots", result.getName());
        }
        driver.close();
    }
}
