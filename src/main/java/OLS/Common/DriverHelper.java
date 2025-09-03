package OLS.Common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.HashMap;

import static OLS.Common.Config.DRIVER_INDEX;


public class DriverHelper extends ElementHelper
{
    /**
     * Підключення логера
     */
    public static final Logger logger = LoggerFactory.getLogger(DriverHelper.class);

    /**
     * Вибір типу браузера
     */
    public static WebDriver createDriver()
    {
        WebDriver driver=null;

        switch(DRIVER_INDEX)
        {
            case 1:
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--incognito");
                options.addArguments("user-data-dir=" + System.getProperty("user.dir") + "/tempProfile");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-save-password-bubble");
                options.addArguments("--disable-features=PasswordLeakDetection,PasswordManagerOnboarding,PasswordProtection,SafetyCheck");

                HashMap<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);

                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver=new ChromeDriver(options);
                break;
            case 2:
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver=new FirefoxDriver();
                break;
            default:
                Assertions.fail("Unsupported driver type: " + DRIVER_INDEX);
        }

        driver.manage().window().setSize(new Dimension (1920, 980));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }

    /**
     * Перевірка наявності елемента в масиві
     */
    public static boolean isElementInArray (int[] array, int id )
    {
        for(int i=0; i<array.length; i++)
        {
            if (array[i]==id)
            {
                return true;
            }
        }
        return false;
    }

}
