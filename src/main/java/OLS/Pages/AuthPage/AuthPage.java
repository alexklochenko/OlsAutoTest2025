package OLS.Pages.AuthPage;

import OLS.Common.CommonActions;
import OLS.Pages.BasePage.BasePageClass;
import OLS.Pages.BasePage.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

import static OLS.Common.Config.*;
import static OLS.Pages.BasePage.BasePageClass.getUrl;
import static OLS.Pages.BasePage.WindowsHelper.ChooseFileFromPC;




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
    By chooseFileButton=By.cssSelector("span.group-span-filestyle.input-group-btn");
    By chooseKNDPDropDownList=By.cssSelector("select#CAsServersSelect");
    By chooseKNDPFromList=By.cssSelector("select#CAsServersSelect>option[data-index-id='"+ID_OF_KNDP+"']");
    By checkboxToSaveLogAndPass=By.cssSelector("div.checkbox.text-left input#cbNeedSaveKeyAndPwd");

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

        WebElement element=WaitUntilElementWillBePresentOnPage(driver, enterButtonToAuthPage);
        element.click();

        element=WaitUntilElementWillBePresentOnPage(driver, chooseFileTypeOfKeyToAuth);
        element.click();

        try
        {
            WaitUntilElementWillBeClickableOnPage(driver, inputPassTpKey);
            System.out.println("Check succes");
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
        WebElement element=WebElementHelper.WaitUntilElementWillBeClickableOnPage(driver,inputPassTpKey);
        element.sendKeys(PSSS_TO_KEY);

        FindAndClickByLocator(driver,chooseFileButton);
        try
        {
            OLS.Pages.BasePage.WindowsHelper.ChooseFileFromPC(WAY_TO_PASS);
        }
        catch(AWTException e)
        {
            e.getStackTrace();
        }

        FindAndClickByLocator(driver, chooseKNDPDropDownList);
        FindAndClickByLocator(driver, chooseKNDPFromList);

    }





}
