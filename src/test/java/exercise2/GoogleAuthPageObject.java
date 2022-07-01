package secondExercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleAuthPageObject extends  SeleniumConfiguration{
    public WebDriver driver;
    public WebDriverWait wait;

    public GoogleAuthPageObject(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    /**
     * Objects
     */
    @FindBy(id = "identifierId")
    private WebElement identifierIdInputLocator;

    @FindBy(id = "identifierNext")
    private WebElement nextButtonLocator;

    @FindBy(id = "password")
    private WebElement passwordInputLocator;

    @FindBy(id = "passwordNext")
    private WebElement passwordNextButtonLocator;

    /**
     * Actions
     */
    public void loginInput(String userLogin) {
        wait.until(ExpectedConditions.visibilityOf(identifierIdInputLocator));
        identifierIdInputLocator.sendKeys(userLogin);
    }

    public void nextButtonClick() {
        nextButtonLocator.click();
    }

    public void passwordInput(String userPassword) {
        wait.until(ExpectedConditions.visibilityOf(passwordInputLocator));
        passwordInputLocator.sendKeys(userPassword);
    }

    public void passwordNextButtonClick() {
        passwordNextButtonLocator.click();
    }
}
