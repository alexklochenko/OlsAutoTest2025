package OLS.Common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

import static OLS.Common.Config.MAIN_URL;
import static OLS.Common.Config.DRIVER_INDEX;


public class CommonActions extends WebElementHelper
{
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

    public static void getUrl(WebDriver driver)
    {
        driver.get(MAIN_URL);
    }


    /**
     * Закрити модальне вікно прийняти Кукі
     */

    static By closeCookiesButton=By.cssSelector("div.popup__btns>button.popup__btn");
    public static void closeCookiesModal(WebDriver driver)
    {
            WebElement element=WaitUntilElementWillBePresentOnPage(driver, closeCookiesButton);
            element.click();
    }







}
