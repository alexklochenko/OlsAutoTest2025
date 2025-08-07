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

    /**
     * Локатори для системи оподаткування
     */
    By TaxSystForRequestYo_0=By.cssSelector("select#step2Model_TaxSystem option[value='0']");
    By TaxSystForRequestYo_1=By.cssSelector("select#step2Model_TaxSystem option[value='1']");
    By TaxSystForRequestYo_2=By.cssSelector("select#step2Model_TaxSystem option[value='2']");
    By TaxSystForRequestYo_3=By.cssSelector("select#step2Model_TaxSystem option[value='3']");
    By TaxSystForRequestYo_4=By.cssSelector("select#step2Model_TaxSystem option[value='4']");
    By TaxSystForRequestYo_5=By.cssSelector("select#step2Model_TaxSystem option[value='5']");
    By TaxSystForRequestYo_6=By.cssSelector("select#step2Model_TaxSystem option[value='6']");
    By TaxSystForRequestYo_7=By.cssSelector("select#step2Model_TaxSystem option[value='7']");
    By TaxSystForRequestYo_8=By.cssSelector("select#step2Model_TaxSystem option[value='8']");
    By TaxSystForRequestYo_9=By.cssSelector("select#step2Model_TaxSystem option[value='9']");
    By TaxSystForRequestFop_0=By.cssSelector("select#step2Model_TaxSystem option[value='0']");
    By TaxSystForRequestFop_1=By.cssSelector("select#step2Model_TaxSystem option[value='1']");
    By TaxSystForRequestFop_2=By.cssSelector("select#step2Model_TaxSystem option[value='2']");
    By TaxSystForRequestFop_3=By.cssSelector("select#step2Model_TaxSystem option[value='3']");




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
                fillTypeOfCompanyActivityForRequest (employmentTypeDropDownList,
                        numberOfEmploymentTypeSeparatUnit,
                        edrpouOfMainOrgCode);
                fillContactInfoForReqest(emailInput,
                        TEST_ORG_EMAIL,
                        phoneNumberInput,
                        TEST_ORG_PHONE_NUMBER);
                fillTaxSystemInfoForRequest(taxSystDropDownList,
                        inpInput);
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

                fillTypeOfCompanyActivityForRequest (employmentTypeDropDownList,
                        numberOfEmploymentTypeSeparatUnit,
                        edrpouOfMainOrgCode);
                fillContactInfoForReqest(emailInput,
                        TEST_ORG_EMAIL,
                        phoneNumberInput,
                        TEST_ORG_PHONE_NUMBER);
                fillTaxSystemInfoForRequest(taxSystDropDownList,
                        inpInput);
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
        String numericValue = valueFromHeader.replaceAll("[^0-9.,]", "");
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
        WebElementHelper.WaitUntilElementWillBeClickableOnPage5(driver, edrpouCodeHeader);
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
                break;
            case 3:
                WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, employmentTypeFop).click();
                action.sendKeys(Keys.ENTER);
                break;
            case 4:
                WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, employmentTypeNotary).click();
                action.sendKeys(Keys.ENTER);
                break;
            case 5:
                WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, employmentTypeNotaryArbitrationManager).click();
                action.sendKeys(Keys.ENTER);
                break;
            case 6:
                WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, employmentTypeNotaryLawer).click();
                action.sendKeys(Keys.ENTER);
                break;
            case 7:
                WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, employmentTypePravateExecutor).click();
                action.sendKeys(Keys.ENTER);
                break;

            default:
                logger.error("Вид зайнятості вказано невірно. Відсутні співпадіння з довідником");
                throw new UnsupportedOperationException("Вид зайнятості вказано невірно. Відсутні співпадіння з довідником");

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
                                             By inpInput)
    {
        switch (ORG_SUBJECT_TYPE_FOR_REQEST)
        {
            case 1:
                if(isElementInArray(ARRAY_OF_TAX_SYSTEM_FOR_YO, ID_OF_TAX_SYST))
                {
                    WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, taxSystDropDownList).click();
                    WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, chooseTaxSystForRequest()).click();
                    action.sendKeys(Keys.ENTER).perform();
                    if (ID_OF_TAX_SYST==1 || ID_OF_TAX_SYST==3 || ID_OF_TAX_SYST==5 || ID_OF_TAX_SYST==7 || ID_OF_TAX_SYST==9)
                    {
                        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, inpInput);
                        action.moveToElement(driver.findElement(inpInput))
                                .click()
                                .keyDown(Keys.CONTROL)
                                .sendKeys("A")
                                .keyUp(Keys.CONTROL)
                                .sendKeys(Keys.DELETE)
                                .sendKeys(TEST_ORG_IPN)
                                .perform();
                    }
                    else
                    {
                        logger.info("Систему оподаткування успішно обрано");
                    }
                }
                else
                {
                    logger.error("Обрана система оподаткування не відповідає значенню з довідника або не відповідає типу субєкту");
                    throw new UnsupportedOperationException("Обрана система оподаткування не відповідає значенню з довідника або не відповідає типу субєкту");
                }
                break;

            case 2:
                break;

            case 3:
                if(isElementInArray(ARRAY_OF_TAX_SYSTEM_FOR_FOP, ID_OF_TAX_SYST))
                {
                    WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, taxSystDropDownList).click();
                    WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, chooseTaxSystForRequest()).click();
                    action.sendKeys(Keys.ESCAPE).perform();
                    if (ID_OF_TAX_SYST==11 || ID_OF_TAX_SYST==13)
                    {
                        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, inpInput);
                        action.moveToElement(driver.findElement(inpInput))
                                .click()
                                .keyDown(Keys.CONTROL)
                                .sendKeys("A")
                                .keyUp(Keys.CONTROL)
                                .sendKeys(Keys.DELETE)
                                .sendKeys(TEST_ORG_IPN)
                                .perform();
                    }
                    else
                    {
                        logger.info("Систему оподаткування успішно обрано");
                    }
                }
                else
                {
                    logger.error("Обрана система оподаткування не відповідає значенню з довідника або не відповідає типу субєкту");
                    throw new UnsupportedOperationException("Обрана система оподаткування не відповідає значенню з довідника або не відповідає типу субєкту");
                }
                break;

            default:
                logger.error("Тип субекта не відповідає значенню з довідника");
                throw new UnsupportedOperationException("Тип субекта не відповідає значенню з довідника");
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

    /**
     * Метод для компарації ід системи одподаткування по відношенню до локатора
     */

    private By chooseTaxSystForRequest()
    {
        switch(ID_OF_TAX_SYST)
        {
            case 0:
                return TaxSystForRequestYo_0;
            case 1:
                return TaxSystForRequestYo_1;
            case 2:
                return TaxSystForRequestYo_2;
            case 3:
                return TaxSystForRequestYo_3;
            case 4:
                return TaxSystForRequestYo_4;
            case 5:
                return TaxSystForRequestYo_5;
            case 6:
                return TaxSystForRequestYo_6;
            case 7:
                return TaxSystForRequestYo_7;
            case 8:
                return TaxSystForRequestYo_8;
            case 9:
                return TaxSystForRequestYo_9;
            case 10:
                return TaxSystForRequestFop_0;
            case 11:
                return TaxSystForRequestFop_1;
            case 12:
                return TaxSystForRequestFop_2;
            case 13:
                return TaxSystForRequestFop_3;
            default:
                logger.error("Тип системи оподаткування не відповідає значенню з довідника");
                throw new UnsupportedOperationException("Тип системи оподаткування не відповідає значенню з довідника");
        }
    }




}
