package OLS.Pages.AuthPage;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import OLS.Common.CommonActions;


import static OLS.Common.Config.MAIN_URL;


public class AuthPage extends CommonActions
{
    WebDriver driver;
    public AuthPage (WebDriver driver)
    {
        this.driver=driver;
    }


    public void getLoginPage()
    {
        driver.get(MAIN_URL);
        try
        {
            CommonActions.closeCookiesModal(driver);
        }
        catch(TimeoutException e)
        {
            e.getStackTrace();
        }
    }



}
