package OLS.Common;

import OLS.Pages.BasePage.WebElementHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static OLS.Common.Config.MAIN_URL;
import static OLS.Common.Config.DRIVER_INDEX;


public class CommonActions extends WebElementHelper
{
    /**
     * Підключення логера
     */
    public static final Logger logger = LoggerFactory.getLogger(CommonActions.class);

    /**
     * Вибір типу браузера
     */
    public static WebDriver createDriver()
    {
        WebDriver driver=null;

        switch(DRIVER_INDEX)
        {
            case 1:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver=new ChromeDriver();
                break;
            case 2:
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver=new FirefoxDriver();
                break;
            default:
                Assertions.fail("Unsupported driver type: " + DRIVER_INDEX);
        }

        driver.manage().window().setSize(new Dimension (1800, 950));
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
