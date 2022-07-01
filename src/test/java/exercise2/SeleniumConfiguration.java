package secondExercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverLogLevel;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumConfiguration  {
    WebDriver driver = null;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions =  new ChromeOptions();
        chromeOptions.addArguments("--start-fullscreen");
        chromeOptions.addArguments("--single-process");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--no-sandbox");

        //Trying to hide selenium web driver from detection systems
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--window-size=1280,1024");
        chromeOptions.addArguments("--disable-blink-features");
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        chromeOptions.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36");

        chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        driver = new RemoteWebDriver(new URL("http://localhost:4441/wd/hub"), chromeOptions);
        //For local run   => driver = new ChromeDriver(chromeOptions);

        //driver = new ChromeDriver(chromeOptions);

        chromeOptions.setLogLevel(ChromeDriverLogLevel.DEBUG);
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}
