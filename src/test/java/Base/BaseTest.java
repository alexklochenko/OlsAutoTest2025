package Base;

import OLS.Pages.AuthPage.AuthPage;
import OLS.Pages.BasePage.BasePageClass;
import OLS.Pages.MainPage.HomePageClass;
import OLS.Pages.Step11Page.Step11PageClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import OLS.Common.*;

import static OLS.Common.Config.NEED_TO_CLOSE_BROWSER_AFTER_TEST;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest
{
    WebDriver driver=CommonActions.createDriver();
    public BasePageClass basePage=new BasePageClass(driver);
    public AuthPage authPage=new AuthPage(driver);
    public HomePageClass homePage =new HomePageClass(driver);
    public Step11PageClass step11Page = new Step11PageClass(driver);

    @AfterAll
    public void closeBrowser()
    {
        if (NEED_TO_CLOSE_BROWSER_AFTER_TEST)
        {
            driver.close();
        }
    }


}
