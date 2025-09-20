package OLS.Pages.ClientRolePages;

import OLS.Common.ElementHelper;
import OLS.Common.UserActions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static OLS.Common.AppUtils.verifySlotIsSign;
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
    By signSignButton=By.cssSelector("button#btnSignData");
    By typeOfKnedpButton=By.cssSelector("select#CAsServersSelect");
    By ChooseTypeOfKnedp=By.cssSelector("select#CAsServersSelect>option[data-index-id='"+ID_OF_KNDP+"']");
    By chooseFileButton=By.cssSelector("span.group-span-filestyle.input-group-btn");
    By inputPassToKey=By.cssSelector("input#PKeyPassword");
    By needToSignWithStampModal=By.cssSelector("div.modal-content>div.modal-header.ng-scope");
    By needToSignWithStampModalOkButton=By.cssSelector("button.btn.btn-danger.ng-binding");
    By needToSignWithStampModalCancelButton=By.cssSelector("div.modal-footer.ng-scope>button.btn.btn-default.ng-binding");
    By signStampButton=By.cssSelector("span.btn.btn-sm.btn-success.btn-sign-doc.ng-scope");
    By headerOfSinedSSignSlot=By.cssSelector("div[data-ng-if='documentModel.State !== 1']>div:nth-of-type(2) span.btn.btn-sm.btn-success.btn-status.signed.ng-binding.ng-scope");
    By headerOfSinedSStampSlot=By.cssSelector("div[data-ng-if='documentModel.State !== 1']>div:nth-of-type(3) span.btn.btn-sm.btn-success.btn-status.signed.ng-binding.ng-scope");





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

            switch (SIGN_MODE)
            {
                case 1:
                    ElementHelper.WaitUntilElementWillBePresentOnPage2(driver, singlSignPrivsButton). click();
                    ElementHelper.WaitUntilElementWillBeClickableOnPage5(driver, SignPrivsButtonAtViewModal).click();
                    ElementHelper.WaitUntilElementWillBeClickableOnPage5(driver,signButtonAtSinglSignModal);

                    singlDocSign (driver,
                            signSignButton,
                            typeOfKnedpButton,
                            ChooseTypeOfKnedp,
                            chooseFileButton,
                            WAY_TO_SIGN_KEY,
                            inputPassToKey,
                            KEY_PASSWORD);

                    verifySlotIsSign(driver,headerOfSinedSSignSlot,"Підписано");

                    try
                    {
                        ElementHelper.WaitUntilElementWillBePresentOnPage90(driver,needToSignWithStampModal);
                        if (NEED_TO_SIGN_WITH_STAMP)
                        {
                            ElementHelper.WaitUntilElementWillBeClickable10(driver, needToSignWithStampModalCancelButton).click();
                            singlDocSign (driver,
                                    signStampButton,
                                    typeOfKnedpButton,
                                    ChooseTypeOfKnedp,
                                    chooseFileButton,
                                    WAY_TO_STAMP_KEY,
                                    inputPassToKey,
                                    KEY_PASSWORD);

                            verifySlotIsSign(driver,headerOfSinedSStampSlot,"Підписано");

                        }
                        else
                        {
                            ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, needToSignWithStampModalOkButton).click();
                        }
                    }
                    catch (TimeoutException e)
                    {
                        logger.info("Документ не потребує підписання печаткою");
                    }
                    break;

                case 2:




            }











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
        authCookieValue="D19079CD3EA4C551D8B5556113EAB389D12EA2E793ED17784DDBB05ABF0089EC0FB22DF1EB2AE4400E3CA84806F71CC3076E12D7B406378C81620464E376394F41CB80B2784CFB7990E1B844ABEEC9E372E91CC1C2F75350D5D80BD2F9EE1C4F1563F3AC3D7748F4342F327A71FB2F4FE0409F9D53D28DEFFA247DDBDE1760FD24D8B48B206392566C2AD2B62C5B877531416BB7EC73A607D7E27F449A4D266CC38E419ABE5024C979C596F7A4B0E51F623E907FA93F1BCF5DF5910C9DB07B00D06B970EA21E04F9494582D8CD801928402060B1CBF8E1697CC2A88E8F838A30";
        driver.get(MAIN_URL);
        driver.manage().addCookie(new Cookie("__AUTH_COOKIE_OLS", authCookieValue));
        driver.manage().addCookie(new Cookie("CookiesAccepted", "true"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem('CookiesAccepted', 'true');");
        UserActions test=new UserActions(driver);

        driver.get("https://ols-test.am-soft.ua/ols.test/home/order#/app/step33/edit/207975/0");
        test.changeUserRole();
        driver.get("https://ols-test.am-soft.ua/ols.test/home/order#/app/step33/edit/207976/0");
        driver.navigate().refresh();
    }




}
