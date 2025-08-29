package OLS.Pages.ClientRolePages;

import OLS.Pages.BasePage.WebElementHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

import static OLS.Common.CommonActions.*;
import static OLS.Common.Config.*;
import static OLS.Pages.BasePage.BasePageClass.checkEmploymentTypeToSubjectType;
import static OLS.Pages.BasePage.TestContext.*;
import static OLS.Pages.BasePage.WebElementHelper.WaitUntilElementWillNotBePresentOnPage;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Step21PageClass
{
    WebDriver driver;
    Actions action;
    public Step21PageClass (WebDriver driver, Actions action)
    {
        this.driver=driver;
        this.action=action;
    }

    Select select;

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
    By foNameHeader=By.cssSelector("div.row>div.col-xs-12.col-lg-6.left-column>div:nth-child(3) div.col-xs-12.col-sm-8.col-lg-8>label");


    /**
     * Елементи для заповнення секції адреса
     */
    By yoAdressSelectButton=By.cssSelector("a[data-ng-click='openLegalAddress()'] i.fa.fa-edit.fa-2x.text-muted");
    By postAdressSelectButton=By.cssSelector("a[data-ng-click='openPostAdress()']");
    By adressModalIndexInput=By.cssSelector("input#index");
    By selectAdressByIndexButton=By.cssSelector("input#index~span[data-ng-click]");
    By regionInput=By.cssSelector("button.btn.btn-default.form-control.ui-select-match span.ng-binding.ng-scope");
    By AdressModalSaveButton=By.cssSelector("button[data-translate='order.common.SaveBtn']");
    By yoAdressCheckElement=By.cssSelector("span.m-b-none.ng-binding.ng-scope[data-ng-if='step2Model.Addr.Full']");
    By postAdressCheckElement=By.cssSelector("span.m-b-none.ng-binding.ng-scope[data-ng-if='step2Model.Post.Full']");

    By streetInputAtAddresModal=By.cssSelector("input#street");
    By houseNumberInputAtAddresModal= By.cssSelector("input#building");
    By flatNumberInputAtAddresModal=By.cssSelector("input#flat");
    By modaThatCoveredPostAdressSelectButton=By.cssSelector("div.odal.fade.ng-isolate-scope.ng-animate.in-remove.in-remove-active");





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
                fillYrAddressInfoForRequest(yoAdressSelectButton,
                        adressModalIndexInput,
                        selectAdressByIndexButton,
                        regionInput,
                        AdressModalSaveButton,
                        yoAdressCheckElement,
                        streetInputAtAddresModal,
                        houseNumberInputAtAddresModal,
                        flatNumberInputAtAddresModal);
                fillPostAddressInfoForRequest(postAdressSelectButton,
                        adressModalIndexInput,
                        selectAdressByIndexButton,
                        regionInput,
                        AdressModalSaveButton,
                        postAdressCheckElement,
                        streetInputAtAddresModal,
                        houseNumberInputAtAddresModal,
                        flatNumberInputAtAddresModal,
                        modaThatCoveredPostAdressSelectButton);
                checkYoAndPostAdress(yoAdressCheckElement,
                        postAdressCheckElement);
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
                fillContactInfoForReqest(emailInput,
                        TEST_ORG_EMAIL,
                        phoneNumberInput,
                        TEST_ORG_PHONE_NUMBER);
                fillYrAddressInfoForRequest(yoAdressSelectButton,
                        adressModalIndexInput,
                        selectAdressByIndexButton,
                        regionInput,
                        AdressModalSaveButton,
                        yoAdressCheckElement,
                        streetInputAtAddresModal,
                        houseNumberInputAtAddresModal,
                        flatNumberInputAtAddresModal);
                fillPostAddressInfoForRequest(postAdressSelectButton,
                        adressModalIndexInput,
                        selectAdressByIndexButton,
                        regionInput,
                        AdressModalSaveButton,
                        postAdressCheckElement,
                        streetInputAtAddresModal,
                        houseNumberInputAtAddresModal,
                        flatNumberInputAtAddresModal,
                        modaThatCoveredPostAdressSelectButton);
                checkYoAndPostAdress(yoAdressCheckElement,
                        postAdressCheckElement);
                fillCompanyInfoSectionForRequest (edrpouCodeHeaderFop,
                        foNameHeader);
                break;

            case 3:

                fillTypeOfCompanyActivityForRequest (employmentTypeDropDownList,
                        numberOfEmploymentTypeSeparatUnit,
                        edrpouOfMainOrgCode);
                fillContactInfoForReqest(emailInput,
                        TEST_ORG_EMAIL,
                        phoneNumberInput,
                        TEST_ORG_PHONE_NUMBER);
                fillYrAddressInfoForRequest(yoAdressSelectButton,
                        adressModalIndexInput,
                        selectAdressByIndexButton,
                        regionInput,
                        AdressModalSaveButton,
                        yoAdressCheckElement,
                        streetInputAtAddresModal,
                        houseNumberInputAtAddresModal,
                        flatNumberInputAtAddresModal);
                fillPostAddressInfoForRequest(postAdressSelectButton,
                        adressModalIndexInput,
                        selectAdressByIndexButton,
                        regionInput,
                        AdressModalSaveButton,
                        postAdressCheckElement,
                        streetInputAtAddresModal,
                        houseNumberInputAtAddresModal,
                        flatNumberInputAtAddresModal,
                        modaThatCoveredPostAdressSelectButton);
                checkYoAndPostAdress(yoAdressCheckElement,
                        postAdressCheckElement);
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
                !compareTextAtElementWithEtalon(driver, edrpouCodeHeader, TEST_ORG_EDRPOU) ||
                        !compareTextAtElementWithEtalon(driver, orgNameHeader, TEST_ORG_NAME))
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
        WebElement element=WebElementHelper.WaitUntilElementWillBePresentOnPage5(driver, employmentTypeDropDownList);
        select=new Select(element);
        switch(EMPLOYMENT_TYPE)
        {
            case 1:
                select.selectByValue(chooseCompActivityForRequest());
                break;
            case 2:
                select.selectByValue(chooseCompActivityForRequest());
                WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver,numberOfEmploymentTypeSeparatUnit).sendKeys(NUMBER_OF_SEPARATED_UNIY);
                WebElementHelper.WaitUntilElementWillBeClickableOnPage(driver,edrpouOfMainOrgCode).sendKeys(EDRPOU_OF_MAIN_COMPANY);
                break;
            case 3:
                select.selectByValue(chooseCompActivityForRequest());
                break;
            case 4:
                select.selectByValue(chooseCompActivityForRequest());
                break;
            case 5:
                select.selectByValue(chooseCompActivityForRequest());
                break;
            case 6:
                select.selectByValue(chooseCompActivityForRequest());
                break;
            case 7:
                select.selectByValue(chooseCompActivityForRequest());
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
     * Заповнення секції Юридична адресса
     */
    public void fillYrAddressInfoForRequest(By yoAdressSelectButton,
                                            By adressModalIndexInput,
                                            By selectAdressByIndexButton,
                                            By regionInput,
                                            By AdressModalSaveButton,
                                            By yoAdressCheckElement,
                                            By streetInputAtAddresModal,
                                            By houseNumberInputAtAddresModal,
                                            By flatNumberInputAtAddresModal)
    {
        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, yoAdressSelectButton).click();
        WebElement element=WebElementHelper.WaitUntilElementWillBeClickable10(driver, adressModalIndexInput);
        element.click();
        element.clear();
        clearOldDataFromAdressModalOnStep2(streetInputAtAddresModal, houseNumberInputAtAddresModal, flatNumberInputAtAddresModal);
        element.sendKeys(YO_COMPANY_INDEX);
        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, selectAdressByIndexButton).click();
        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, regionInput);
        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, AdressModalSaveButton).click();
        WebElementHelper.WaitUntilElementWillBePresentOnPage5(driver,yoAdressCheckElement);

    }

    /**
     * Заповнення секції Поштова адресса
     */
    public void fillPostAddressInfoForRequest(By postAdressSelectButton,
                                              By adressModalIndexInput,
                                              By selectAdressByIndexButton,
                                              By regionInput,
                                              By AdressModalSaveButton,
                                              By postAdressCheckElement,
                                              By streetInputAtAddresModal,
                                              By houseNumberInputAtAddresModal,
                                              By flatNumberInputAtAddresModal,
                                              By modaThatCoveredPostAdressSelectButton)
    {
      try
      {
          WaitUntilElementWillNotBePresentOnPage(driver, modaThatCoveredPostAdressSelectButton);
      }
      catch (TimeoutException e)
      {
          logger.error("Модальне вікно перекриває кнопку вибору Поштової адреси");
      }
        WebElementHelper.WaitUntilElementWillBeClickable10(driver, postAdressSelectButton).click();
        WebElement element=WebElementHelper.WaitUntilElementWillBeClickable10(driver, adressModalIndexInput);
        element.click();
        element.clear();
        clearOldDataFromAdressModalOnStep2(streetInputAtAddresModal, houseNumberInputAtAddresModal, flatNumberInputAtAddresModal);
        element.sendKeys(IndexForPostAdtessInput);
        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, selectAdressByIndexButton).click();
        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, regionInput);
        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, AdressModalSaveButton).click();
        WebElementHelper.WaitUntilElementWillBePresentOnPage5(driver,postAdressCheckElement);

    }

    /**
     * Перевірка результатів заповнення Юридичної та Поштової адреси
     */
    public  void checkYoAndPostAdress(By yoAdressCheckElement,
                                      By postAdressCheckElement)
    {
        try
        {
            Thread.sleep(1000);
            Assertions.assertEquals((YO_COMPANY_INDEX+", "+YO_COMPANY_CITY), driver.findElement(yoAdressCheckElement).getText());
            Assertions.assertEquals(fullPoatAdress, driver.findElement(postAdressCheckElement).getText());
            logger.info("Значення юридичної та поштової адреси відповідають введених даних");
        }
        catch( InterruptedException e)
        {
            e.getStackTrace();
        }
    }

    public void clearOldDataFromAdressModalOnStep2( By streetInputAtAddresModal,
                                                    By houseNumberInputAtAddresModal,
                                                    By flatNumberInputAtAddresModal)
    {
        try
            {
                WebElement element=WebElementHelper.WaitUntilElementWillBeClickableOnPage5(driver, streetInputAtAddresModal);
                element.click();
                element.clear();

                element=WebElementHelper.WaitUntilElementWillBeClickableOnPage5(driver, houseNumberInputAtAddresModal);
                element.click();
                element.clear();

                element=WebElementHelper.WaitUntilElementWillBeClickableOnPage5(driver, flatNumberInputAtAddresModal);
                element.click();
                element.clear();
            }
        catch(TimeoutException e)
        {
            logger.error("Помилка при заповнеені даних про адресу");
        }

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
                    select=new Select(WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, taxSystDropDownList));
                    select.selectByValue(chooseTaxSystForRequest());
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
                    select=new Select(WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, taxSystDropDownList));
                    select.selectByValue(chooseTaxSystForRequest());
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
    private String chooseTaxSystForRequest()
    {
        switch(ID_OF_TAX_SYST)
        {
            case 0:
                return "0";
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "0";
            case 11:
                return "1";
            case 12:
                return "2";
            case 13:
                return "3";
            default:
                logger.error("Тип системи оподаткування не відповідає значенню з довідника");
                throw new UnsupportedOperationException("Тип системи оподаткування не відповідає значенню з довідника");
        }
    }

    /**
     * Визначення виду зайнятості
     */
    private String chooseCompActivityForRequest()
    {
        switch(EMPLOYMENT_TYPE)
        {
            case 1:
                return "0";
            case 2:
                return "1";
            case 3:
                return "0";
            case 4:
                return "1";
            case 5:
                return "2";
            case 6:
                return "3";
            case 7:
                return "4";
            default:
                logger.error("Тип виду зайнятості не відповідає значенню з довідника");
                throw new UnsupportedOperationException("Тип виду зайнятості не відповідає значенню з довідника");
        }
    }


}
