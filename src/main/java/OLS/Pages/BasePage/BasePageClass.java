package OLS.Pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static OLS.Common.Config.MAIN_URL;

public class BasePageClass extends WebElementHelper
{
    WebDriver driver;
    public BasePageClass(WebDriver driver)
    {
        this.driver=driver;
    }


    static By closeCookiesButton=By.cssSelector("div.popup__btns>button.popup__btn");
    static By snoutPassForKey=By.cssSelector("input#PKeyPassword");


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
        WebElement element=WaitUntilElementWillBePresentOnPage(driver, closeCookiesButton);
        element.click();
    }

    /**
     * Вибір КНЕДП, вибір фалу ключа, введення паролю на формі зчитування файлового ключа
     */
    public void CheckCryptoAlreadyInit()
    {



    }


}
