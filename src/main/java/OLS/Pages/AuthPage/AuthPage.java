package OLS.Pages.AuthPage;

import OLS.Pages.BasePage.BasePage;
import OLS.Pages.BasePage.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import OLS.Common.CommonActions;


import static OLS.Common.Config.MAIN_URL;
import static OLS.Common.Config.PSSS_TO_KEY;
import static OLS.Pages.BasePage.BasePage.getUrl;


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
    public void getLoginPage()
    {
        getUrl(driver);

        try
        {
            BasePage.closeCookiesModal(driver);
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

    public void loginUsingFileKey()
    {
        WebElement element=WebElementHelper.WaitUntilElementWillBeClickableOnPage(driver,inputPassTpKey);
        element.sendKeys(PSSS_TO_KEY);

        FindAndClickByLocator(driver,chooseFileButton);



    }





}
