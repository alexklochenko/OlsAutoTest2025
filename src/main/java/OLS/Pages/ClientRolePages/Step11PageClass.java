package OLS.Pages.ClientRolePages;

import OLS.Common.ElementHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static OLS.Common.DriverHelper.logger;
import static OLS.Common.Config.*;
import static OLS.Common.ElementHelper.getValueFromText;
import static OLS.Common.TestData.priceOfLicOnInReqest;
import static OLS.Common.ElementHelper.getTextFromElement;

public class Step11PageClass
{
    WebDriver driver;
    Actions action;
    public Step11PageClass(WebDriver driver, Actions action)
    {
        this.driver=driver;
        this.action=action;
    }

    /**
     * Контрольні елементи на кроці1
     */
    By textOnStep1=By.cssSelector("div.col-sm-12.col-xs-12>h2");

    /**
     * Локатори з блоку Кліент
     */
    By orgNameInput=By.cssSelector("input#orderCreateModel_OrgName");
    By foNameInput=By.cssSelector("input#orderCreateModel_FIO");
    By orgSubjectType=By.cssSelector("div.col-xs-12.no-padder div.col-xs-12.col-md-10.no-padder>div>div:nth-child(1) label.control-label.ng-binding");
    By orgEdrpouFop=By.cssSelector("div.col-xs-12.no-padder>div.col-xs-12.col-sm-6.col-lg-2.p-l-0:nth-child(3) label.control-label.ng-binding");
    By orgEdrpouYo=By.cssSelector("div.col-xs-12.no-padder div.col-xs-12.col-md-10.no-padder>div>div:nth-child(5) label.control-label.ng-binding");

    /**
     * Локатори з блоку Послуги
     */
    By licDateStartInput=By.cssSelector("input#orderCreateModel_Nomenclatures_0_StartDate");
    By addNewLicButton=By.cssSelector("input[value='Додати модулі']");
    By LicPriceAtFootor=By.cssSelector("div.text-right.m-t-xs.ng-binding");
    By licTransactionCountStartInput =By.cssSelector("input#orderCreateModel_Nomenclatures_0_MaoDocsCount");


    public void determinateTypeOfFillingDependendingOnSubjectTypeForStep1 ()
    {
        try
        {
            ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, textOnStep1);
        }
        catch(TimeoutException e)
        {
            logger.error("Контрольний елемент не відображається на сторінці Крок1");
            throw new TimeoutException("Контрольний елемент не відображається на сторінці Крок1");
        }

        switch (ORG_SUBJECT_TYPE_FOR_REQEST)
        {
            case 1:
                String TypeOfSubjectName = "Юридична особа";
//                fillHeaderForYoReqest(TypeOfSubjectName);
                fillHeaderForReqest( TypeOfSubjectName,orgNameInput, orgSubjectType, orgEdrpouYo);
                fillFooterForRequest(LICENSE_ID_USING_IN_REQEST);
                break;
            case 2:
                TypeOfSubjectName = "Фізична особа";
//                fillHeaderForFoReqest(TypeOfSubjectName);
                fillHeaderForReqest( TypeOfSubjectName,foNameInput, orgSubjectType, orgEdrpouFop);
                fillFooterForRequest(LICENSE_ID_USING_IN_REQEST);
                break;

            case 3:
                TypeOfSubjectName = "Фізична особа-підприємець";
//                fillHeaderForFopReqest(TypeOfSubjectName);
                fillHeaderForReqest( TypeOfSubjectName,orgNameInput, orgSubjectType, orgEdrpouFop);
                fillFooterForRequest(LICENSE_ID_USING_IN_REQEST);

                break;

            default :
                logger.error("Wrong type of Org Subject in Config file");
                throw new UnsupportedOperationException("Wrong type of Org Subject in Config file");
        }
    }

    public void fillHeaderForReqest(String SubjectTypeName,
                                    By orgNameInput,
                                    By orgSubjectType,
                                    By orgEdrpou)
    {
        WebElement element= ElementHelper.WaitUntilElementWillBePresentOnPage5(driver,orgNameInput);
        element.clear();
        element.sendKeys(TEST_ORG_NAME);
        ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, orgSubjectType);
        Assertions.assertEquals(SubjectTypeName, getTextFromElement(driver,orgSubjectType));
        ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, orgEdrpou);
        Assertions.assertEquals(TEST_ORG_EDRPOU, getTextFromElement(driver,orgEdrpou));
    }

    public void fillFooterForRequest  (int  licensingType)
    {
        if (licensingType != 9 && licensingType != 12)
        {
            WebElement element= ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, licDateStartInput);
            element.clear();

            String currentDate=LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            element.sendKeys(currentDate);

            String valueFromText=getValueFromText(driver, LicPriceAtFootor, "До сплати:", "грн");
            Assertions.assertEquals(PRICE_OF_CHOOSEN_LICENSE, valueFromText);
            priceOfLicOnInReqest=valueFromText;
            logger.info("Вартіст ліцензії, що вказана на кроці Степ_1 - "+valueFromText+" грн");

            element=driver.findElement(addNewLicButton);
            Assertions.assertTrue(element.isDisplayed());
        }
        else
        {
            WebElement element= ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, licTransactionCountStartInput);
            element.clear();
            element.sendKeys(String.valueOf(COUNT_FOR_TRNSACTIONS_IN_REQEST));

            if(LICENSE_ID_USING_IN_REQEST==12)
            {
                String valueFromText=getValueFromText(driver, LicPriceAtFootor, "До сплати:", "грн");
                String totalStr = String.format("%.2f", COST_ONE_TRANSACTION_IN_MAO*COUNT_FOR_TRNSACTIONS_IN_REQEST);
                totalStr = totalStr.replace(",", ".");
                Assertions.assertEquals(totalStr, valueFromText);
                priceOfLicOnInReqest=valueFromText;
                logger.info("Вартіст ліцензії, що вказана на кроці Степ_1 - "+valueFromText+" грн");
            }
            if(LICENSE_ID_USING_IN_REQEST==9)
            {
                String valueFromText=getValueFromText(driver, LicPriceAtFootor, "До сплати:", "грн");
                String totalStr = String.format("%.2f", COST_ONE_TRANSACTION_IN_AZ*COUNT_FOR_TRNSACTIONS_IN_REQEST);
                totalStr = totalStr.replace(",", ".");
                Assertions.assertEquals(totalStr, valueFromText);
                priceOfLicOnInReqest=valueFromText;
                logger.info("Вартіст ліцензії, що вказана на кроці Степ_1 - "+valueFromText+" грн");
            }

            element=driver.findElement(addNewLicButton);
            Assertions.assertTrue(element.isDisplayed());
        }

    }

}
