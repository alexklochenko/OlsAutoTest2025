package OLS.Pages.BasePage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static OLS.Pages.BasePage.WebElementHelper.*;
import static OLS.Common.CommonActions.logger;

public class CommonActionsAfterAuth
{
    WebDriver driver;

    public CommonActionsAfterAuth (WebDriver driver)
    {
        this.driver=driver;
    }

     By clickOnDropDownList=By.cssSelector("li.dropdown.ng-scope");
//     By chooseClientRoleFromDropDownList=By.xpath("//li[@ng-repeat='role in app.user.UserRoles']//a[text()='Клієнт']");
     By chooseClientRoleFromDropDownList=By.cssSelector("li.dropdown.ng-scope.open li[ng-repeat='role in app.user.UserRoles']:last-child");
     By ShoppingCartButton=By.cssSelector("a.btn.cart-link[data-ui-sref='app.cart']:not([style='margin-right: 50px;'])");
     By WarningModatToSignPrimaryDoc=By.cssSelector("div.modal-content");
     By RefusalAtWarningModatToSignPrimaryDoc=By.cssSelector("button.btn.btn.btn-danger.ng-binding");
    By WarningModatToPresentRequestWithPayment=By.cssSelector("div.modal-content");
    By TextAtWarningModatRequestWithPayment=By.cssSelector("div.modal-content");
    By XButtonAtWarningModatRequestWithPayment=By.cssSelector("button.bootbox-close-button.close");


    /**
     * Заміна авторизаційної ролі на роль Клієнт
     */
    public void changeUserRole()
    {
        try
        {
            WaitUntilElementWillBePresentOnPage10(driver, clickOnDropDownList).click();
            WaitUntilElementWillBeClickableOnPage5(driver, chooseClientRoleFromDropDownList);
            FindAndClickByLocator(driver, chooseClientRoleFromDropDownList);
            WaitUntilElementWillBePresentOnPage2(driver, ShoppingCartButton);
        }
        catch(TimeoutException e)
        {
            logger.warn("Role dropDown is not exist. Only one role at this cabinet");
        }
    }

    /**
     * Перевірка наявності модального вікна підписання первинних документів відсутнє
     */

    public boolean closeSignPrimaryDocModal ()
    {
        boolean isModalPresent=false;
        try
        {
            WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, WarningModatToSignPrimaryDoc);
            WebElementHelper.FindAndClickByLocator(driver,RefusalAtWarningModatToSignPrimaryDoc );
            isModalPresent=true;
        }
        catch(TimeoutException e)
        {
            logger.warn("The modal window for signing primary documents is missing.");
        }
        return isModalPresent;
    }

    /**
     * Перевірка та закриття модально вікна у ролі ВПР про наявність опачених замовлень які ще не надійши до АРС
     */
    public void closeModalInfoForPaymentRequestRoleVpr()
    {
        try
        {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, WarningModatToPresentRequestWithPayment);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            WebElement element=driver.findElement(TextAtWarningModatRequestWithPayment);
            Assertions.assertTrue(element.isDisplayed());
            WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver,XButtonAtWarningModatRequestWithPayment).click();
        }
        catch(TimeoutException e)
        {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            logger.info("There is no requests with payment at VPR cabinet");
        }

    }

}
