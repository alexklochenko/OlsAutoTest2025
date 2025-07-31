package OLS.Pages.ClientRolePages;

import OLS.Pages.BasePage.BasePageClass;
import OLS.Pages.BasePage.TestContext;
import OLS.Pages.BasePage.WebElementHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static OLS.Common.Config.*;
import static OLS.Pages.BasePage.BasePageClass.getValueFromText;
import static OLS.Pages.BasePage.TestContext.priceOfLicOnInReqest;
import static OLS.Pages.BasePage.WebElementHelper.gatTextFromElement;

public class Step11PageClass
{
    WebDriver driver;
    public Step11PageClass(WebDriver driver)
    {
        this.driver=driver;
    }

    /**
     * Контрольні елементи на кроці1
     */
    By textOnStep1=By.cssSelector("div.col-sm-12.col-xs-12>h2");

    /**
     * Локатори з блоку Кліент
     */
    By orgNameInput=By.cssSelector("input#orderCreateModel_OrgName");
    By orgEdrpou=By.cssSelector("div.col-xs-12.no-padder div.col-xs-12.col-md-10.no-padder>div>div:nth-child(5) label.control-label.ng-binding");
    By orgSubjectType=By.cssSelector("div.col-xs-12.no-padder div.col-xs-12.col-md-10.no-padder>div>div:nth-child(1) label.control-label.ng-binding");

    /**
     * Локатори з блоку Послуги
     */
    By licDateStartInput=By.cssSelector("input#orderCreateModel_Nomenclatures_0_StartDate");
    By addNewLicButton=By.cssSelector("input[value='Додати модулі']");
    By LicPriceAtFootor=By.cssSelector("div.text-right.m-t-xs.ng-binding");
    By licTransactionCountStartInput =By.cssSelector("input#orderCreateModel_Nomenclatures_0_MaoDocsCount");


    public void determinateTypeOfFillingDependendingOnSubjectType ()
    {
        if(ORG_SUBJECT_TYPE_FOR_REQEST==1)
        {
            String TypeOfSubjectName="Юридична особа";
            fillHeaderForYoReqest(TypeOfSubjectName);
            fillFooterForYoRequest (LICENSE_ID_USING_IN_REQEST);
        }
//        if(ORG_SUBJECT_TYPE_FOR_REQEST==2)
//        {}
//        if(ORG_SUBJECT_TYPE_FOR_REQEST==3)
//        {}
        else
        {
            throw new UnsupportedOperationException("Wrong type of Org Subject in Config file");
        }
    }

    public void fillHeaderForYoReqest(String SubjectTypeName)
    {
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, textOnStep1);
        WebElement element=WebElementHelper.FindAndClickByLocator(driver,orgNameInput);
        element.clear();
        element.sendKeys(TEST_ORG_NAME);
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, orgSubjectType);
        Assertions.assertEquals(SubjectTypeName, gatTextFromElement(driver,orgSubjectType));
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, orgEdrpou);
        Assertions.assertEquals(TEST_ORG_EDRPOU, gatTextFromElement(driver,orgEdrpou));
    }

    public void fillFooterForYoRequest  (int  licensingType)
    {
        if (licensingType != 9 && licensingType != 12)
        {
            WebElement element=WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, licDateStartInput);
            element.clear();

            String currentDate=LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            element.sendKeys(currentDate);

            String valueFromText=getValueFromText(driver, LicPriceAtFootor, "До сплати:", "грн");
            Assertions.assertEquals(PRICE_OF_CHOOSEN_LICENSE, valueFromText);
            priceOfLicOnInReqest=valueFromText;
            System.out.println(valueFromText);

            element=driver.findElement(addNewLicButton);
            Assertions.assertTrue(element.isDisplayed());
        }
        else
        {
            WebElement element=WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, licTransactionCountStartInput);
            element.clear();
            element.sendKeys(String.valueOf(COUNT_FOR_TRNSACTIONS_IN_REQEST));

            if(LICENSE_ID_USING_IN_REQEST==12)
            {
                String valueFromText=getValueFromText(driver, LicPriceAtFootor, "До сплати:", "грн");
                String totalStr = String.format("%.2f", COST_ONE_TRANSACTION_IN_MAO*COUNT_FOR_TRNSACTIONS_IN_REQEST);
                totalStr = totalStr.replace(",", ".");
                Assertions.assertEquals(totalStr, valueFromText);
                priceOfLicOnInReqest=valueFromText;
                System.out.println(priceOfLicOnInReqest);
            }
            else
            {
                String valueFromText=getValueFromText(driver, LicPriceAtFootor, "До сплати:", "грн");
                Assertions.assertEquals(COST_ONE_TRANSACTION_IN_AZ*COUNT_FOR_TRNSACTIONS_IN_REQEST, valueFromText);
                priceOfLicOnInReqest=valueFromText;
                System.out.println(priceOfLicOnInReqest);
            }

            element=driver.findElement(addNewLicButton);
            Assertions.assertTrue(element.isDisplayed());
        }

    }

}
