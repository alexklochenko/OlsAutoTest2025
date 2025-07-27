package OLS.Pages.AuthPage;

import OLS.Common.CommonActions;
import OLS.Pages.BasePage.BasePageClass;
import OLS.Pages.BasePage.WebElementHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

import static OLS.Common.Config.*;
import static OLS.Pages.BasePage.BasePageClass.getUrl;
import static OLS.Pages.BasePage.WindowsHelper.PressEsc;


public class AuthPage extends CommonActions
{
    WebDriver driver;
    public AuthPage (WebDriver driver)
    {
        this.driver=driver;
    }



    By enterButtonToAuthPage=By.cssSelector("div.btn-group");
    By chooseFileTypeOfKeyToAuth=By.cssSelector("div.btn-group.open ul.dropdown-menu>li:nth-child(1)");
    By inputPassTpKey=By.cssSelector("input#PKeyPassword");
    By chooseFileButton=By.cssSelector("label#lPKeyFileInput");
    By chooseKNDPDropDownList=By.cssSelector("select#CAsServersSelect");
    By chooseKNDPFromList=By.cssSelector("select#CAsServersSelect>option[data-index-id='"+ID_OF_KNDP+"']");
    By checkboxToSaveLogAndPass=By.cssSelector("label.i-checks");
    By checkboxCheck=By.cssSelector("input#cbNeedSaveKeyAndPwd");
    By enterBuuton=By.cssSelector("button#btnLogon");
    By orgNameAtSideBar=By.cssSelector("strong.font-bold.text-lt.ng-binding");

    public void getLoginPage()
    {
        getUrl(driver);

        try
        {
            BasePageClass.closeCookiesModal(driver);
        }
        catch(TimeoutException e)
        {
            e.getStackTrace();
        }

        WebElement element= WaitUntilElementWillBePresentOnPage10(driver, enterButtonToAuthPage);
        element.click();

        element= WaitUntilElementWillBePresentOnPage10(driver, chooseFileTypeOfKeyToAuth);
        element.click();

        try
        {
            WaitUntilElementWillBeClickableOnPage(driver, inputPassTpKey);
        }
        catch(TimeoutException  e)
        {
            e.getStackTrace();
            return;
        }

    }

    public void needToSaveLoginAndPassOnSession()
    {
        FindAndClickByLocator(driver, checkboxToSaveLogAndPass);

    }
    public void loginUsingFileKey()
    {
        WebElementHelper.WaitUntilElementWillBeClickableOnPage(driver,inputPassTpKey);

        WebElementHelper.FindAndClickByLocator(driver,chooseFileButton);
        try
        {
            OLS.Pages.BasePage.WindowsHelper.ChooseFileFromPC(WAY_TO_PASS);
        }
        catch(AWTException e)
        {
            e.getStackTrace();
        }


        WebElement element=WebElementHelper.WaitUntilElementWillBeClickableOnPage(driver,inputPassTpKey);
        element.sendKeys(PSSS_TO_KEY);

        FindAndClickByLocator(driver, chooseKNDPDropDownList);
        FindAndClickByLocator(driver, chooseKNDPFromList);

        try
        {
            PressEsc();
        }
        catch(AWTException e)
        {
            String errorMessage = "Error during choosing KNEDP from drop-down list";
            throw new RuntimeException(errorMessage, e);
        }

        FindAndClickByLocator(driver, checkboxToSaveLogAndPass);
        element =driver.findElement(checkboxCheck);
        Assertions.assertTrue(element.isSelected());



        FindAndClickByLocator(driver, enterBuuton);

        WebElementHelper.WaitUntilElementWillBePresentOnPage90(driver, orgNameAtSideBar);
        Assertions.assertEquals(TEST_ORG_NAME,gatTextFromElement(driver,orgNameAtSideBar));
    }


}
