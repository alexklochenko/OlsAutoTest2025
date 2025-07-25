package OLS.Pages.BasePage;

import org.openqa.selenium.*;

import static OLS.Common.Config.KEY_NAME_OF_AUTH_COOKIE;
import static OLS.Common.Config.MAIN_URL;

public class BasePageClass extends WebElementHelper
{
    WebDriver driver;
    public static String authCookieValue=null;
    public BasePageClass(WebDriver driver)
    {
        this.driver=driver;
    }


    static By closeCookiesButton=By.cssSelector("div.popup__btns>button.popup__btn");



    /**
     * Виклкик URL
     * @param driver
     */
    public static void getUrl(WebDriver driver)
    {
        driver.get(MAIN_URL);
    }


    /**
     * Закрити модальне вікно прийняти Кукі
     */
    public static void closeCookiesModal(WebDriver driver)
    {
        WebElement element= WaitUntilElementWillBePresentOnPage10(driver, closeCookiesButton);
        element.click();
    }




}
