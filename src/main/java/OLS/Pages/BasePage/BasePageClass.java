package OLS.Pages.BasePage;

import OLS.Common.ElementHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static OLS.Common.DriverHelper.isElementInArray;
import static OLS.Common.DriverHelper.logger;
import static OLS.Common.Config.*;
import static OLS.Common.TestData.authCookieValue;


public class BasePageClass extends ElementHelper
{
    WebDriver driver;
    Actions action;

    public BasePageClass(WebDriver driver)
    {
        this.driver=driver;
    }

    public BasePageClass(WebDriver driver, Actions action)
    {
        this.driver=driver;
        this.action=action;
    }



    static By closeCookiesButton=By.cssSelector("div.popup__btns>button.popup__btn");
    By payByMonoButton=By.cssSelector("div.payment_items.ng-scope:nth-of-type(2) button.btn.btn-default.monopay-submit");
    By cardNumberOnMonoPage=By.cssSelector("input[autocomplete='cc-number']");
    By expirationDateOnMonoPage=By.cssSelector("input[autocomplete='cc-exp']");
    By cvvOnMonoPage=By.cssSelector("input[autocomplete='cc-csc']");
    By enterOnMonoPage=By.cssSelector("button#payWithCardButton");
    By confirmOnMonoPage=By.cssSelector("button.main-layout--button.m-button-primary");
    By receiptButtonOnMonoPage=By.cssSelector("p.centered-text.text-bold");
    By BackToSiteButtonOnMonoPage=By.cssSelector("button#back_to_store_btn");
    By checkTextAfterPayment=By.cssSelector("h2.m-n.font-thin.h2.text-black.ng-scope");



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
        logger.info("Авторизаційні кукі - "+authCookieValue);
    }


    /**
     * Оплата Моно Пей
     */
    public void makeAPaymentByMono()
    {
        authCookieValue="ED394DE2853DC5B92E14941AD820BBA4A1E291967DD86664F5DFE9B04E2289F2A8574A5B1E0EA3BC7B81E3FD155508604284EDB9EFBBCE02EFE022B927F787A9DE85D6CA238CBF4749B0DEA60316234DFECEBD86654F3E55E13DAAEEC97D9D5BF10ED63D8D2ED25581DD282C0643B175DABC75BB44E468EE4D1BD553E2F6353A6F78F1BDFC5C55479762A76DAE228F2207306D2F1958A29F5C70C1A8DE23F598C2A0DFA7D3FFAAAA612EC89562200C2429536226501C1C9DBD3E3C25F3B6A2B71FF9F9A2F2C02851835D43C7C23EF52A1A18607FBD5BABB103A8B8E81295FBBB";
        driver.get("https://olstest.am-soft.ua/ols.test");
        closeCookiesModal(driver);
        driver.manage().addCookie(new Cookie(KEY_NAME_OF_AUTH_COOKIE,authCookieValue));
        driver.get("https://olstest.am-soft.ua/ols.test/home/order#/app/step41/view/207528/0");

        ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, payByMonoButton)
                .click();
        ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, cardNumberOnMonoPage)
                .sendKeys("4111 1111 1111 1111");
        ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, expirationDateOnMonoPage)
                .sendKeys("12/2030");
        ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, cvvOnMonoPage)
                .sendKeys("123");
        ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, enterOnMonoPage)
                .click();
        ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, confirmOnMonoPage)
                .click();

        WebElement element=driver.findElement(receiptButtonOnMonoPage);

        Assertions.assertTrue(element.isDisplayed());
        ElementHelper.WaitUntilElementWillBePresentOnPage10(driver,BackToSiteButtonOnMonoPage ).click();

        element= ElementHelper.WaitUntilElementWillBePresentOnPage10(driver,checkTextAfterPayment);
        Assertions.assertEquals("Крок 4: Замовлення очікує обробки Реєстратором", element.getText());

    }


    /**
     * Перевірка відповідності типу ліцензії до типу субекта
     */
    public static void checkLicensingForOrgSubjectType()
    {
        if(ORG_SUBJECT_TYPE_FOR_REQEST==1)
        {
            if (!isElementInArray(LICENSE_IDS_FOR_YO_ONLY, LICENSE_ID_USING_IN_REQEST))
            {
                logger.error("Type of licensing is not supported for used Org subject type");
                throw new UnsupportedOperationException ("Type of licensing is not supported for used Org subject type");
            }
        }

        if(ORG_SUBJECT_TYPE_FOR_REQEST==2 || ORG_SUBJECT_TYPE_FOR_REQEST==3)
        {
            if (!isElementInArray(LICENSE_IDS_FOR_FOP_FO_ONLY, LICENSE_ID_USING_IN_REQEST))
            {
                logger.error("Type of licensing is not supported for used Org subject type");
                throw new UnsupportedOperationException ("Type of licensing is not supported for used Org subject type");
            }
        }
    }

    /**
     * Перевірка відповідності виду зайнятості до типу субєкта
     */
    public static void checkEmploymentTypeToSubjectType()
    {
        if (ORG_SUBJECT_TYPE_FOR_REQEST==1)
        {
            if(!isElementInArray(ARRAY_OF_EMPLOYMENT_TYPE_FOR_YO, EMPLOYMENT_TYPE))
            {
                logger.error("Employment type not supported for chosen type of org subject");
                throw new UnsupportedOperationException("Employment type not supported for chosen type of subject");
            }
        }

        if (ORG_SUBJECT_TYPE_FOR_REQEST==2 || ORG_SUBJECT_TYPE_FOR_REQEST==3)
        {
            if(!isElementInArray(ARRAY_OF_EMPLOYMENT_TYPE_FOR_FOP, EMPLOYMENT_TYPE))
            {
                logger.error("Employment type not supported for chosen type of org subject");
                throw new UnsupportedOperationException("Employment type not supported for chosen type of subject");
            }
        }
    }















}
