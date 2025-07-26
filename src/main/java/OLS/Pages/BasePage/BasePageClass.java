package OLS.Pages.BasePage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.util.ArrayList;

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

    /**
     * Отримати та зберегти авторизаційні кукі
     */

    public void authCookie()
    {
        Cookie authCookie=driver.manage().getCookieNamed(KEY_NAME_OF_AUTH_COOKIE);
        authCookieValue=authCookie.getValue();
        System.out.println(authCookieValue);
    }

    By payByMonoButton=By.cssSelector("div.payment_items.ng-scope:nth-of-type(2) button.btn.btn-default.monopay-submit");
    By cardNumberOnMonoPage=By.cssSelector("input[autocomplete='cc-number']");
    By expirationDateOnMonoPage=By.cssSelector("input[autocomplete='cc-exp']");
    By cvvOnMonoPage=By.cssSelector("input[autocomplete='cc-csc']");
    By enterOnMonoPage=By.cssSelector("button#payWithCardButton");
    By confirmOnMonoPage=By.cssSelector("button.main-layout--button.m-button-primary");
    By receiptButtonOnMonoPage=By.cssSelector("p.centered-text.text-bold");
    By BackToSiteButtonOnMonoPage=By.cssSelector("button#back_to_store_btn");
    By checkTextAfterPayment=By.cssSelector("h2.m-n.font-thin.h2.text-black.ng-scope");


    public void makeAPaymentByMono()
    {
        authCookieValue="ED394DE2853DC5B92E14941AD820BBA4A1E291967DD86664F5DFE9B04E2289F2A8574A5B1E0EA3BC7B81E3FD155508604284EDB9EFBBCE02EFE022B927F787A9DE85D6CA238CBF4749B0DEA60316234DFECEBD86654F3E55E13DAAEEC97D9D5BF10ED63D8D2ED25581DD282C0643B175DABC75BB44E468EE4D1BD553E2F6353A6F78F1BDFC5C55479762A76DAE228F2207306D2F1958A29F5C70C1A8DE23F598C2A0DFA7D3FFAAAA612EC89562200C2429536226501C1C9DBD3E3C25F3B6A2B71FF9F9A2F2C02851835D43C7C23EF52A1A18607FBD5BABB103A8B8E81295FBBB";
        driver.get("https://olstest.am-soft.ua/ols.test");
        closeCookiesModal(driver);
        driver.manage().addCookie(new Cookie(KEY_NAME_OF_AUTH_COOKIE,authCookieValue));
        driver.get("https://olstest.am-soft.ua/ols.test/home/order#/app/step41/view/207528/0");

        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, payByMonoButton)
                .click();
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, cardNumberOnMonoPage)
                .sendKeys("4111 1111 1111 1111");
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, expirationDateOnMonoPage)
                .sendKeys("12/2030");
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, cvvOnMonoPage)
                .sendKeys("123");
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, enterOnMonoPage)
                .click();
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, confirmOnMonoPage)
                .click();

        WebElement element=driver.findElement(receiptButtonOnMonoPage);

        Assertions.assertTrue(element.isDisplayed());
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver,BackToSiteButtonOnMonoPage ).click();

        element=WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver,checkTextAfterPayment);
        Assertions.assertEquals("Крок 4: Замовлення очікує обробки Реєстратором", element.getText());

    }


    public void checkLicensingForOrgSubjectType()
    {

    }




}
