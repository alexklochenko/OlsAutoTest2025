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
    static By snoutPassForKey=By.cssSelector("input#PKeyPassword");
    static By roleDropDownToggle=By.cssSelector("a.dropdown-toggle.ng-binding:not([ng-style])");
    static By clientRoleAtDropDownToggle=By.cssSelector("li.dropdown.ng-scope.open>ul.dropdown-menu.animated.fadeInRight>li:last-child");


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

    /**
     * Отримати авторизаційні кукі
     */
    public String authCookie()
    {
        Cookie cookie=driver.manage().getCookieNamed(KEY_NAME_OF_AUTH_COOKIE);
        return authCookieValue= cookie.getValue();
    }

    /**
     * Заміна авторизаційної ролі на роль Клієнт
     */
    public void changeRoleOnClient()
    {
        try
        {
            WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, roleDropDownToggle).click();
            FindAndClickByLocator(driver, clientRoleAtDropDownToggle);
        }
        catch(TimeoutException e)
        {
            throw new TimeoutException("test");
        }
    }


}
