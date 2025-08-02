package OLS.Pages.ClientRolePages;

import OLS.Pages.BasePage.BasePageClass;
import OLS.Pages.BasePage.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static OLS.Common.CommonActions.logger;

public class Step21PageClass
{
    WebDriver  driver;
    public Step21PageClass (WebDriver driver)
    {
     this.driver=driver;
    }

    /**
     * Кнопки навігації
     */
    By goToStep2Button=By.cssSelector("button.btn.btn-success.btn-next.ng-binding");


    public void determinateTypeOfFillingDependendingOnSubjectTypeForStep2 ()
    {
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, goToStep2Button).click();
        logger.info("----Start of 2-nt Step----");
    }

}
