package OLS.Pages.ClientRolePages;

import OLS.Pages.BasePage.WebElementHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

import static OLS.Common.CommonActions.*;
import static OLS.Common.Config.*;
import static OLS.Pages.BasePage.BasePageClass.checkEmploymentTypeToSubjectType;
import static OLS.Pages.BasePage.TestContext.priceOfLicOnInReqest;
import static OLS.Pages.BasePage.WebElementHelper.*;

import org.openqa.selenium.interactions.Actions;

public class Step21PageClass
{
    WebDriver driver;
    Actions action;
    public Step21PageClass (WebDriver driver, Actions action)
    {
        this.driver=driver;
        this.action=action;
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
    By taxSystDropDownList=By.cssSelector("select#step2Model_TaxSystem");
    By chooseTaxSystForRequest=By.cssSelector("select#step2Model_TaxSystem option[value='"+ID_OF_TAX_SYST+"']");
    //By chooseTaxSystForRequest=By.cssSelector("select#step2Model_TaxSystem option[value='1']");
    By inpInput=By.cssSelector("input#step2Model_IPN");
    By emailInput=By.cssSelector("input#step2Model_EMail");
    By phoneNumberInput=By.cssSelector("input#step2Model_Phone");
    By employmentTypeDropDownList=By.cssSelector("select#step2Model_OccupType");
    By numberOfEmploymentTypeSeparatUnit=By.cssSelector("input#step2Model_Filiya");
    By edrpouOfMainOrgCode=By.cssSelector("input#step2Model_Filiya");
    By edrpouCodeHeaderYo=By.cssSelector("div.row>div.col-xs-12.col-lg-6.left-column>div:nth-child(1) div.col-xs-12.col-sm-8.col-lg-8>label");
    By edrpouCodeHeaderFop=By.cssSelector("div.row>div.col-xs-12.col-lg-6.left-column>div:nth-child(2) div.col-xs-12.col-sm-8.col-lg-8>label");
    By orgNameHeader=By.cssSelector("div.row>div.col-xs-12.col-lg-6.left-column>div:nth-child(4) div.col-xs-12.col-sm-8.col-lg-8>label");


    /**
     * Види зайнятосты
     */
    By employmentTypeYo=By.cssSelector("select#step2Model_OccupType option[value='0']");
    By employmentTypeSeparatUnit=By.cssSelector("select#step2Model_OccupType option[value='1']");
    By employmentTypeFop=By.cssSelector("select#step2Model_OccupType option[value='0']");
    By employmentTypeNotary=By.cssSelector("select#step2Model_OccupType option[value='1']");
    By employmentTypeNotaryArbitrationManager=By.cssSelector("select#step2Model_OccupType option[value='2']");
    By employmentTypeNotaryLawer=By.cssSelector("select#step2Model_OccupType option[value='3']");
    By employmentTypePravateExecutor=By.cssSelector("select#step2Model_OccupType option[value='4]");

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

        switch(ORG_SUBJECT_TYPE_FOR_REQEST)
        {
            case 1:
                fillCompanyInfoSectionForRequest (edrpouCodeHeaderYo,
                        orgNameHeader);
                fillTypeOfCompanyActivityForRequest (employmentTypeDropDownList,
                        employmentTypeYo,
                        employmentTypeSeparatUnit,
                        numberOfEmploymentTypeSeparatUnit,
                        edrpouOfMainOrgCode);
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
                fillRequisitesInfoForRequest (ibanInput,
                        TEST_ORG_IBAN);
                fillCompanyInfoSectionForRequest (edrpouCodeHeaderYo,
                        orgNameHeader);
                break;

            case 2:

            case 3:
                fillCompanyInfoSectionForRequest (edrpouCodeHeaderFop,
                        orgNameHeader);
                fillTypeOfCompanyActivityForRequest (employmentTypeDropDownList,
                        employmentTypeYo,
                        employmentTypeSeparatUnit,
                        numberOfEmploymentTypeSeparatUnit,
                        edrpouOfMainOrgCode);
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
                fillRequisitesInfoForRequest (ibanInput,
                        TEST_ORG_IBAN);
                fillCompanyInfoSectionForRequest (edrpouCodeHeaderFop,
                        orgNameHeader);
                break;

            default :
                logger.error("Wrong type of Org Subject in Config file");
                throw new UnsupportedOperationException("Wrong type of Org Subject in Config file");
        }

        chechPriceOnStep2();
    }

    /**
     * Перевірка вартості ліцензії на кроці 2 (в хедері)
     */
    public void chechPriceOnStep2()
    {
        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, priceAtHeaderOnStep2);
        String valueFromHeader=getTextFromElementWithNbsp (driver, priceAtHeaderOnStep2);
        String numericValue = valueFromHeader.replaceAll("[^0-9]", "");
        logger.info("Вартість ліцензії, вказана на кроці Step_2 - "+numericValue+" грн");
        Assertions.assertEquals(priceOfLicOnInReqest,
                numericValue,
                "Вартість ліцензії на кроці 2 не відповідає очікуваному реазультату");
    }

    /**
     * Перевірка секції про організацію
     */
    public void fillCompanyInfoSectionForRequest (By edrpouCodeHeader,
                                                  By orgNameHeader)
    {
        if (
        !checkTextEqualsToEtalon(driver, edrpouCodeHeader, TEST_ORG_EDRPOU) ||
        !checkTextEqualsToEtalon(driver, orgNameHeader, TEST_ORG_NAME))
        {
            logger.error("Код ЕДРПОУ/ Назва оранізації на кроці 2 не відповідають очікуваному результату");
            throw new UnsupportedOperationException("Код ЕДРПОУ/ Назва оранізації на кроці 2 не відповідають очікуваному результату");
        }
        else
        {
            logger.info("Код ЄДРПОУ та назва організації відповідають значенням, зазначеним у конфігурації");
        }
    }

    /**
     * Заповнення даних про Вид занятості
     */
    public void fillTypeOfCompanyActivityForRequest (By employmentTypeDropDownList,
                                                     By employmentTypeYo,
                                                     By employmentTypeSeparatUnit,
                                                     By numberOfEmploymentTypeSeparatUnit,
                                                     By edrpouOfMainOrgCode)
    {
        checkEmploymentTypeToSubjectType();
        WebElementHelper.WaitUntilElementWillBePresentOnPage5(driver, employmentTypeDropDownList);
        WebElementHelper.WaitUntilElementWillBeClickableOnPage(driver,employmentTypeDropDownList).click();
        switch(EMPLOYMENT_TYPE)
        {
            case 1:
                WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, employmentTypeYo).click();
                action.sendKeys(Keys.ENTER);
                break;
            case 2:
                WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, employmentTypeSeparatUnit).click();
                action.sendKeys(Keys.ENTER);
                WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver,numberOfEmploymentTypeSeparatUnit).sendKeys(NUMBER_OF_SEPARATED_UNIY);
                WebElementHelper.WaitUntilElementWillBeClickableOnPage(driver,edrpouOfMainOrgCode).sendKeys(EDRPOU_OF_MAIN_COMPANY);
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, employmentTypeSeparatUnit).click();
                action.sendKeys(Keys.ENTER);
                break;

        }
        logger.info("Значення виду зайнятості встановлено успішно");
    }

    /**
     * Заповнення секції телефона та адреса
     */
    public void fillContactInfoForReqest(By emailInput,
                                         String TEST_ORG_EMAIL,
                                         By phoneNumberInput,
                                         String TEST_ORG_PHONE_NUMBER)
    {
        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, emailInput);
        ClearAndSeendKeys(driver, emailInput, TEST_ORG_EMAIL);
        ClearAndSeendKeys(driver, phoneNumberInput, TEST_ORG_PHONE_NUMBER);
        logger.info("Дані для параметрів телефону та поштової адреси успішно збережено");
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
        if(ORG_SUBJECT_TYPE_FOR_REQEST==1)
        {
            if(isElementInArray(ARRAY_OF_TAX_SYSTEM_FOR_YO, ID_OF_TAX_SYST))
            {
                WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, taxSystDropDownList).click();
                WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, chooseTaxSystForRequest).click();
                action.sendKeys(Keys.ESCAPE).perform();
                WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, inpInput);
                action.moveToElement(driver.findElement(inpInput))
                        .click()
                        .keyDown(Keys.CONTROL)
                        .sendKeys("A")
                        .keyUp(Keys.CONTROL)
                        .sendKeys(Keys.DELETE)
                        .sendKeys(TEST_ORG_IPN)
                        .perform();
                logger.info("Систему оподаткування успішно обрано");
            }

        }

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
        logger.info("Дані про керівника успішно збережено");
    }

    /**
     * Заповнення секції про Реквізити (ІБАН)
     */
    public void fillRequisitesInfoForRequest (By ibanInput, String TEST_ORG_IBAN)
    {
        ClearAndSeendKeys(driver,ibanInput, TEST_ORG_IBAN);
        logger.info("Дані про IBAN успішно збережено");
    }


}
