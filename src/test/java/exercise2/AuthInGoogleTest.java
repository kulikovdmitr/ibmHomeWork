package exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AuthInGoogleTest extends SeleniumConfiguration {

    final String GOOGLE_LOGIN = "dmtrmsc";
    final String GOOGLE_PASSWORD = "@googleAccountPassword!";
    final String SEARCH_QUERY = "merative+application";

    @Test
    public void authInGoogleTest() throws IOException {

        GoogleAuthPageObject authGooglePage = new GoogleAuthPageObject(driver, new WebDriverWait(driver, Duration.ofSeconds(3)));

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        //Precondition
        driver.get("https://accounts.google.com");
        driver.switchTo().window(tabs.get(0));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        authGooglePage.loginInput(GOOGLE_LOGIN);

        authGooglePage.nextButtonClick();

        authGooglePage.passwordInput(GOOGLE_PASSWORD);

        authGooglePage.passwordNextButtonClick();

        //Act
        driver.get("https://www.google.com/search?q=" + SEARCH_QUERY);

//        String s = t.getCssValue("color");
//        String c = Color.fromString(s).asHex();
//
//        System.out.println(c);
//        System.out.println(t.getText());

        WebElement element = driver.findElement(By.cssSelector("#search h3"));

        List<WebElement> myList= element.findElements(By.cssSelector("#search h3"));
        //Assert
    }
}