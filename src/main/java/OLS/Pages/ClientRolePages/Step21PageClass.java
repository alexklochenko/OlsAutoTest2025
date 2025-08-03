package OLS.Pages.ClientRolePages;

import OLS.Pages.BasePage.BasePageClass;
import OLS.Pages.BasePage.WebElementHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

import static OLS.Common.CommonActions.logger;
import static OLS.Common.Config.*;
import static OLS.Pages.BasePage.BasePageClass.getTextFromElement;
import static OLS.Pages.BasePage.TestContext.priceOfLicOnInReqest;
import static OLS.Pages.BasePage.WebElementHelper.ClearAndSeendKeys;
import static OLS.Pages.BasePage.WebElementHelper.gatTextFromElement;

import OLS.Pages.BasePage.BasePageClass.*;
import org.openqa.selenium.interactions.Actions;

public class Step21PageClass extends BasePageClass
{
    WebDriver driver;
    Actions action;
    public Step21PageClass (WebDriver driver, Actions action)
    {
        super(driver, action);
    }

    /**
     * Кнопки навігації з кроку 1
     */
    By goToStep2Button=By.cssSelector("button.btn.btn-success.btn-next.ng-binding");

    /**
     * Загальні елементи на кроці 2
     */
    By priceAtHeaderOnStep2=By.cssSelector("span.price-text.text-teal-dk.ng-binding");
    By textOnStep2=By.cssSelector("h2.m-n.font-thin.h2.text-black.ng-scope");


    /**
     * Елементи до заповнення
     */
    By ibanInput=By.cssSelector("input#step2Model_Account");
    By bossJobTitleInput=By.cssSelector("input#step2Model_Head_Position");
    By bossDrfoInput=By.cssSelector("input#step2Model_Head_DRFO");
    By bossPibInput=By.cssSelector("input#step2Model_Head_FIO");
    By taxSystDropDownList=By.cssSelector("input#step2Model_TaxSystem");
    By chooseTaxSystForRequest=By.cssSelector("select#step2Model_TaxSystem option[value='"+ID_OF_TAX_SYST+"']");
    By emailInput=By.cssSelector("input#step2Model_EMail");
    By phoneNumberInput=By.cssSelector("input#step2Model_Phone");
    By inpInput=By.cssSelector("input#step2Model_IPN");

    public void determinateTypeOfFillingDependendingOnSubjectTypeForStep2 ()
    {
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, goToStep2Button).click();
        logger.info("----End of 1-t Step----");
        logger.info("----Start of 2-d Step----");

        try
        {
            WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, textOnStep2);
        }
        catch(TimeoutException e)
        {
            logger.error("Контрольний елемент не відображається на сторінці Крок2");
            throw new TimeoutException("Контрольний елемент не відображається на сторінці Крок2");
        }

        chechPriceOnStep2();

        switch(ORG_SUBJECT_TYPE_FOR_REQEST)
        {
            case 1:

                fillContactInfoForReqest(emailInput,
                        TEST_ORG_EMAIL,
                        phoneNumberInput,
                        TEST_ORG_PHONE_NUMBER);
                fillTaxSystemInfoForRequest(taxSystDropDownList,
                        chooseTaxSystForRequest,
                        inpInput,
                        TEST_ORG_IPN);
                fillManagerInfoForRequest(bossJobTitleInput,
                        TEST_ORG_BOSS_JOB_TITLE,
                        bossDrfoInput,
                        TEST_ORG_BOSS_DRFO,
                        bossPibInput,
                        TEST_ORG_BOSS_PIB);
                fillRequisitesInfoForRequest (ibanInput, TEST_ORG_IBAN);

            case 2:

            case 3:

            default :
                logger.error("Wrong type of Org Subject in Config file");
                throw new UnsupportedOperationException("Wrong type of Org Subject in Config file");

        }
    }

    /**
     * Перевірка вартості ліцензії на кроці 2 (в хедері)
     */
    protected void chechPriceOnStep2()
    {
        String valueFromHeader=getTextFromElement (driver, priceAtHeaderOnStep2);
        logger.info("Вартіст ліцензії, що вказана на кроці Степ_2 - "+valueFromHeader+" грн");
        Assertions.assertEquals(priceOfLicOnInReqest,
                valueFromHeader,
                "Вартість ліцензії на кроці 2 не відповідає очікуваному реазультату");

    }


    /**
     * Заповнення секції про Реквізити (ІБАН)
     */
    public void fillCompanyInfoSectionForRequest (String SubjectTypeName,
                                              By orgNameInput,
                                              By orgSubjectType,
                                              By orgEdrpou)
    {
//    WebElement element=WebElementHelper.FindAndClickByLocator(driver,orgNameInput);
//    element.clear();

    }
    public void fillTypeOfCompanyActivityForRequest (String SubjectTypeName,
                                                  By orgNameInput,
                                                  By orgSubjectType,
                                                  By orgEdrpou)
    {
//    WebElement element=WebElementHelper.FindAndClickByLocator(driver,orgNameInput);
//    element.clear();

    }

    /**
     * Заповнення секції телефона та адреса
     */
    public void fillContactInfoForReqest(By emailInput,
                                         String TEST_ORG_EMAIL,
                                         By phoneNumberInput,
                                         String TEST_ORG_PHONE_NUMBER)
    {
        ClearAndSeendKeys(driver, emailInput, TEST_ORG_EMAIL);
        ClearAndSeendKeys(driver, phoneNumberInput, TEST_ORG_PHONE_NUMBER);

    }

    /**
     * Заповнення секції адресса
     */
    public void fillYrAddressInfoForRequest(String SubjectTypeName,
                                         By orgNameInput,
                                         By orgSubjectType,
                                         By orgEdrpou)
    {

    }
    public void fillPostAddressInfoForRequest(String SubjectTypeName,
                                            By orgNameInput,
                                            By orgSubjectType,
                                            By orgEdrpou)
    {

    }

    /**
     * Заповнення секції система оподаткування
     */
    public void fillTaxSystemInfoForRequest (By taxSystDropDownList,
                                             By chooseTaxSystForRequest,
                                             By inpInput,
                                             String TEST_ORG_IPN)
    {
        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, taxSystDropDownList).click();
        WebElementHelper.FindAndClickByLocator(driver, chooseTaxSystForRequest);
        action.sendKeys(Keys.ENTER).perform();
        action.moveToElement(driver.findElement(inpInput)).click().sendKeys(TEST_ORG_IPN).perform();
    }

    /**
     * Заповнення секції про керівника
     */
    public void fillManagerInfoForRequest (By bossJobTitleInput,
                                           String TEST_ORG_BOSS_JOB_TITLE,
                                           By bossDrfoInput,
                                           String TEST_ORG_BOSS_DRFO,
                                           By bossPibInput,
                                           String TEST_ORG_BOSS_PIB)
    {
        ClearAndSeendKeys(driver, bossJobTitleInput, TEST_ORG_BOSS_JOB_TITLE);
        ClearAndSeendKeys(driver, bossDrfoInput, TEST_ORG_BOSS_DRFO);
        ClearAndSeendKeys(driver, bossPibInput, TEST_ORG_BOSS_PIB);
    }

    /**
     * Заповнення секції про Реквізити (ІБАН)
     */
    public void fillRequisitesInfoForRequest (By ibanInput, String TEST_ORG_IBAN)
    {
        ClearAndSeendKeys(driver,ibanInput, TEST_ORG_IBAN);
    }


}
