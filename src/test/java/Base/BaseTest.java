package Base;

import OLS.Pages.AuthPage.AuthPage;
import OLS.Pages.BasePage.BasePageClass;
import OLS.Common.UserActions;
import OLS.Pages.ClientRolePages.ChooseTypeOfLicensingPage;
import OLS.Pages.ClientRolePages.Step21PageClass;
import OLS.Pages.ClientRolePages.Step31PageClass;
import OLS.Pages.MainPage.HomePageClass;
import OLS.Pages.ClientRolePages.Step11PageClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.suite.api.Select;
import org.openqa.selenium.WebDriver;
import OLS.Common.*;
import org.openqa.selenium.interactions.Actions;

import static OLS.Common.Config.NEED_TO_CLOSE_BROWSER_AFTER_TEST;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest
{
    WebDriver driver= DriverHelper.createDriver();
    Actions action=new Actions(driver);
    Select select;

    public AuthPage authPage=new AuthPage(driver);
    public BasePageClass basePage=new BasePageClass(driver,action);
    public UserActions commonActionsAfterAuth=new UserActions(driver);
    public ChooseTypeOfLicensingPage chooseTypeOfLicensingPage=new ChooseTypeOfLicensingPage(driver);
    public Step11PageClass step11Page = new Step11PageClass(driver,action);
    public Step21PageClass step21Page = new Step21PageClass(driver,action);
    public Step31PageClass step31Page = new Step31PageClass(driver,action);
    public HomePageClass homePage =new HomePageClass(driver);


    @AfterAll
    public void closeBrowser()
    {
        if (NEED_TO_CLOSE_BROWSER_AFTER_TEST)
        {
            driver.close();
            driver.quit();
        }
    }


}
