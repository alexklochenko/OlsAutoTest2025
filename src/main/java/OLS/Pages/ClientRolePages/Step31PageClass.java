package OLS.Pages.ClientRolePages;

import OLS.Common.ElementHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static OLS.Common.Config.*;
import static OLS.Common.DriverHelper.logger;
import static OLS.Common.TestData.authCookieValue;
import static OLS.Common.ElementHelper.compareTextAtElementWithEtalon;
import static OLS.Common.ElementHelper.getTextFromElement;
import static OLS.Common.UserActions.singlDocSign;

public class Step31PageClass
{
    WebDriver driver;
    Actions action;

    public Step31PageClass (WebDriver driver, Actions action)
    {
        this.driver=driver;
        this.action=action;
    }

    /**
     * Продовжити створення замовленняя. Перехід з кроку 2 на крок 3
     */
    By goToStep3Button= By.cssSelector("button.btn.btn-success.btn-next.ng-binding");

    /**
     * Контрольний елемент при переході на крок 3
     */
    By textOnStep3 =By.cssSelector("h2[data-translate='order.step3.Step32ViewWaitForDocsTitle']");
    By priceAtHeaderOnStep3 =By.cssSelector("div.block-price.text-right.no-padder span");

    /**
     * Елементи до заповнення
     */
    By PaymentAfterSignDocModal=By.cssSelector("div.modal-content");
    By textAtSignDocModal=By.cssSelector("div.bootbox-body");
    By confirmButtonPaymentAfterSignDocModal=By.cssSelector("div.modal-footer button");

    /**
     * Робота з прівсами
     */
    By singlSignPrivsButton=By.cssSelector("a.doc-btn.ng-scope");
    By SignPrivsButtonAtViewModal=By.cssSelector("div.sign-box.sign-ns-r.view-cert-not-allowed span.btn.btn-sm.btn-success.btn-sign-doc.ng-scope");
    By signButtonAtSinglSignModal=By.cssSelector("button#btnSignData");

    /**
     * Підписаня документа
     */
    By signButton=By.cssSelector("button#btnSignData");
    By typeOfKnedpButton=By.cssSelector("select#CAsServersSelect");
    By ChooseTypeOfKnedp=By.cssSelector("select#CAsServersSelect option[data-index-id='"+ID_OF_KNDP+"']");
    By inputPassToKey=By.cssSelector("input#PKeyPassword");




    public void determinateTypeOfFillingDependendingOnSubjectTypeForStep3 ()
    {
        boolean tmp=false;
        if (tmp)
        {
            ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, goToStep3Button).click();
            logger.info("----End of 2-t Step----");
            logger.info("----Start of 3-d Step----");

            try
            {
                ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, textOnStep3);
                if(compareTextAtElementWithEtalon(driver,textOnStep3, "Крок 3: Формування документів"))
                {
                    logger.info("Контрольний елемент відображається на сторінці Крок3");
                }
                else
                {
                    throw new TimeoutException();
                }

            }
            catch(TimeoutException e)
            {
                logger.error("Контрольний елемент не відображається на сторінці Крок3");
                throw new TimeoutException("Контрольний елемент не відображається на сторінці Крок3");
            }
        }

        ElementHelper.WaitUntilElementWillBePresentOnPage1260(driver,PaymentAfterSignDocModal);
        Assertions.assertEquals(getTextFromElement(driver, textAtSignDocModal), "Оплачуйте послугу після підписання електронних документів.");

        ElementHelper.WaitUntilElementWillBePresentOnPage2(driver, confirmButtonPaymentAfterSignDocModal).click();
        ElementHelper.WaitUntilElementWillBePresentOnPage2(driver, singlSignPrivsButton). click();
        ElementHelper.WaitUntilElementWillBeClickableOnPage5(driver, SignPrivsButtonAtViewModal).click();
        ElementHelper.WaitUntilElementWillBeClickableOnPage5(driver,signButtonAtSinglSignModal);

        singlDocSign (driver,
                signButton,
                typeOfKnedpButton,
                ChooseTypeOfKnedp,
                PSSS_TO_KEY,
                inputPassToKey,
                WAY_TO_PASS);








        chechPriceOnStep3();
    }

    public void chechPriceOnStep3()
    {
        String priceVaueFromheader= ElementHelper.WaitUntilElementWillBePresentOnPage2(driver, priceAtHeaderOnStep3).getText();
        logger.info("Ціна в замовленні, що вказана на кроці 3 - "+priceVaueFromheader);
        priceVaueFromheader=priceVaueFromheader.replace(" грн", "");
        Assertions.assertEquals((PRICE_OF_CHOOSEN_LICENSE),priceVaueFromheader, "Ціна у хедері не відповідає очікуваному результату" );

    }

    public void testForTest()
    {
        authCookieValue="A12727473D31D141CCBB80524D01B5D4DD91642C26ABFEF73D77108B9044ECB30D934A3AD94BD753755E576D28C9FAE9F16093137E603A5AD0DBC5A2D9746882018C2E5BD9F137D8CF7E0F6B34A747A71084F1160BCFF07E8602C9EF13CB005C1B25CB75467CEDFC296EF63E87988C2BFC2703511F2028FFFB9FD5CAFE3061460620748BD292487773D1FA5FCD5BDCA0F789BF1603C9FBCA355371EEA99691AAFFA78F8E1A88D3BAD3B019EC412E4910BE913102C1C3D1FC987385822A8B84C07F1DF0AE483A8504E9854CD0EBB239328F1918AA56CE793333BA1C205E2F596C";
        driver.get(MAIN_URL);
        driver.manage().addCookie(new Cookie("__AUTH_COOKIE_OLS", authCookieValue));
        driver.manage().addCookie(new Cookie("CookiesAccepted", "true"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem('CookiesAccepted', 'true');");
        driver.get("https://ols-test.am-soft.ua/ols.test/home/order#/app/step33/edit/208006/0");
    }




}
