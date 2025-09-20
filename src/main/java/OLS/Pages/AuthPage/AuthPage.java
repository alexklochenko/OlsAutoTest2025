package OLS.Pages.AuthPage;

import OLS.Common.DriverHelper;
import OLS.Common.ElementHelper;
import OLS.Common.WindowsHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

import static OLS.Common.Config.*;
import static OLS.Pages.BasePage.BasePageClass.getUrl;
import static OLS.Pages.BasePage.BasePageClass.closeCookiesModal;
import static OLS.Common.WindowsHelper.PressEsc;


public class AuthPage extends DriverHelper
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
            closeCookiesModal(driver);
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

        }

    }

    public void needToSaveLoginAndPassOnSession()
    {
        FindAndClickByLocator(driver, checkboxToSaveLogAndPass);
        WebElement element= driver.findElement(checkboxCheck);
        Assertions.assertTrue(element.isSelected());

    }
    public void loginUsingFileKey()
    {
        ElementHelper.WaitUntilElementWillBeClickableOnPage(driver,enterBuuton);
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

        // вибір файлового ключа на ПК
        WebElement element= ElementHelper.WaitUntilElementWillBePresentOnPage10(driver,chooseFileButton);
        element.click();
        try
        {
            WindowsHelper.ChooseFileFromPC(WAY_TO_SIGN_KEY);
            Thread.sleep(3000);

        }
        catch(AWTException e)
        {
            e.getStackTrace();
        }
        catch(InterruptedException  e)
        {
            e.getStackTrace();
        }

        // введення пароля
        element= ElementHelper.WaitUntilElementWillBeClickableOnPage(driver,inputPassTpKey);
        element.sendKeys(KEY_PASSWORD);

        // активація чекбокса збереження пароля
        needToSaveLoginAndPassOnSession();

        // вхід у кабінет
        FindAndClickByLocator(driver, enterBuuton);

        // перевірка успішної авторизації
        ElementHelper.WaitUntilElementWillBePresentOnPage90(driver, orgNameAtSideBar);
        Assertions.assertEquals(TEST_ORG_NAME, getTextFromElement(driver,orgNameAtSideBar));
    }


}
