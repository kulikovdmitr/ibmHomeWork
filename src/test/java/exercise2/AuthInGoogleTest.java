package secondExercise;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * https://stackoverflow.com/questions/53039551/selenium-webdriver-modifying-navigator-webdriver-flag-to-prevent-selenium-detec
 */

public class AuthInGoogleTest extends SeleniumConfiguration {

    final String GOOGLE_LOGIN = "dmtrmsc";
    final String GOOGLE_PASSWORD = "@googleAccountPassword!";

    @Test
    public void authInGoogleTest() throws IOException {

        GoogleAuthPageObject authGooglePage = new GoogleAuthPageObject(driver, new WebDriverWait(driver, Duration.ofSeconds(3)));

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        //Act
        driver.get("https://accounts.google.com");
        driver.switchTo().window(tabs.get(0));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        authGooglePage.loginInput(GOOGLE_LOGIN);

        authGooglePage.nextButtonClick();

        authGooglePage.passwordInput(GOOGLE_PASSWORD);

        authGooglePage.passwordNextButtonClick();

        //Assert
    }
}