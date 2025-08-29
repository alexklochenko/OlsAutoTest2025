package OLS.Pages.ClientRolePages;

import OLS.Pages.BasePage.WebElementHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static OLS.Common.CommonActions.logger;
import static OLS.Common.Config.MAIN_URL;
import static OLS.Common.Config.PRICE_OF_CHOOSEN_LICENSE;
import static OLS.Pages.BasePage.TestContext.authCookieValue;
import static OLS.Pages.BasePage.WebElementHelper.compareTextAtElementWithEtalon;
import static OLS.Pages.BasePage.WebElementHelper.gatTextFromElement;

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




    boolean tmp=false;
    public void determinateTypeOfFillingDependendingOnSubjectTypeForStep3 ()
    {

        if (tmp)
        {
            WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, goToStep3Button).click();
            logger.info("----End of 2-t Step----");
            logger.info("----Start of 3-d Step----");

            try
            {
                WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, textOnStep3);
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


        WebElementHelper.WaitUntilElementWillBePresentOnPage1260(driver,PaymentAfterSignDocModal);
        Assertions.assertEquals(gatTextFromElement(driver, textAtSignDocModal), "Оплачуйте послугу після підписання електронних документів.");

        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, confirmButtonPaymentAfterSignDocModal).click();
        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, singlSignPrivsButton). click();
        WebElementHelper.WaitUntilElementWillBeClickableOnPage5(driver, SignPrivsButtonAtViewModal).click();
        WebElementHelper.WaitUntilElementWillBeClickableOnPage5(driver,signButtonAtSinglSignModal);

//        singlDocSign (signButton,
//                typeOfKnedpButton,
//                ChooseTypeOfKnedp,
//                pathToKeyFile,
//                inputPassToKey,
//                passToKey)







        chechPriceOnStep3();




    }

    public void chechPriceOnStep3()
    {
        String priceVaueFromheader= WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, priceAtHeaderOnStep3).getText();
        logger.info("Ціна в замовленні, що вказана на кроці 3 - "+priceVaueFromheader);
        priceVaueFromheader=priceVaueFromheader.replace(" грн", "");
        Assertions.assertEquals((PRICE_OF_CHOOSEN_LICENSE),priceVaueFromheader, "Ціна у хедері не відповідає очікуваному результату" );

    }






    public void testForTest()
    {
        authCookieValue="37715964D098507DF0AE412EFEAE83F0F6BC683CE530122432BE0BBB6169D586729E7F239C7DBFF6C9DBCA8D4101816390394B0E6EAB034B276E245E14C9B2A408A59E3A43E1F6563A65E1B033132231EAC3631762FB596214F0EEE4A53DBCFC1076F8120C117CCA10F44851EEDCA060E872D5978EB544B838F0AB83E11C1EDB4FBFC8412ED2D27380F213060C02383075659D3742F92A01BF39AE4D086E0741A7B4C95289A37C192EF3C86FC1C17232E45FBF1F4A742522C6DF6329D2D3501169CB50DB1D33F28389C5EC1D4E3330820EAAFF97ED4FA18E7FA89A78F4895E92";
        driver.get(MAIN_URL);
        driver.manage().addCookie(new Cookie("__AUTH_COOKIE_OLS", authCookieValue));
        driver.manage().addCookie(new Cookie("CookiesAccepted", "true"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem('CookiesAccepted', 'true');");
        driver.get("https://ols-test.am-soft.ua/ols.test/home/order#/app/step33/edit/207957/0");

    }




}
