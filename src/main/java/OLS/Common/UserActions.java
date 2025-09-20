package OLS.Common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.time.Duration;

import static OLS.Common.ElementHelper.*;
import static OLS.Common.DriverHelper.logger;
import static OLS.Common.WindowsHelper.ChooseFileFromPC;
import static OLS.Common.WindowsHelper.PressEsc;

public class UserActions
{
    WebDriver driver;

    public UserActions(WebDriver driver)
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
            ElementHelper.WaitUntilElementWillBePresentOnPage2(driver, WarningModatToSignPrimaryDoc);
            ElementHelper.FindAndClickByLocator(driver,RefusalAtWarningModatToSignPrimaryDoc );
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
            ElementHelper.WaitUntilElementWillBePresentOnPage2(driver, WarningModatToPresentRequestWithPayment);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            WebElement element=driver.findElement(TextAtWarningModatRequestWithPayment);
            Assertions.assertTrue(element.isDisplayed());
            ElementHelper.WaitUntilElementWillBePresentOnPage2(driver,XButtonAtWarningModatRequestWithPayment).click();
        }
        catch(TimeoutException e)
        {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            logger.info("There is no requests with payment at VPR cabinet");
        }

    }

    /**
     * Підписання документа. Точкове
     */

    public static void singlDocSign (WebDriver driver,
                                     By signButton,
                                     By typeOfKnedpButton,
                                     By ChooseTypeOfKnedp,
                                     By chooseFileButton,
                                     String pathToKeyFile,
                                     By inputPassToKey,
                                     String  passToKey)
    {
        ElementHelper.WaitUntilElementWillBePresentOnPage2(driver, signButton);
        FindAndClickByLocator(driver, typeOfKnedpButton);
        FindAndClickByLocator(driver, ChooseTypeOfKnedp);
        try
        {
            PressEsc();
        }
        catch(AWTException e)
        {
            String errorMessage = "Error during choosing KNEDP from drop-down list";
            throw new RuntimeException(errorMessage, e);
        }







        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

        ElementHelper.WaitUntilElementWillBePresentOnPage2(driver, chooseFileButton).click();
        try
        {
        ChooseFileFromPC(pathToKeyFile);
        }
        catch(AWTException e)
        {
            logger.error("Помилка. Ключ відсутній у зазначеній директорії");
        }

        ElementHelper.WaitUntilElementWillBePresentOnPage2(driver, inputPassToKey).sendKeys(passToKey);
        ElementHelper.WaitUntilElementWillBeClickableOnPage5(driver, signButton).click();
    }


}
