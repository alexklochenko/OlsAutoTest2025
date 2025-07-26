package OLS.Pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static OLS.Pages.BasePage.WebElementHelper.*;

public class CommonActionsAfterAuth
{
    WebDriver driver;

    public CommonActionsAfterAuth (WebDriver driver)
    {
        this.driver=driver;
    }

     By clickOnDropDownList=By.cssSelector("li.dropdown.ng-scope");
//     By chooseClientRoleFromDropDownList=By.xpath("//li[@ng-repeat='role in app.user.UserRoles']//a[text()='Клієнт']");
     By chooseClientRoleFromDropDownList=By.cssSelector("li.dropdown.ng-scope.open li[ng-repeat='role in app.user.UserRoles']:nth-of-type(4)");
     By ShoppingCartButton=By.cssSelector("a.btn.cart-link[data-ui-sref='app.cart']:not([style='margin-right: 50px;'])");
     By WarningModatToSignPrimaryDoc=By.cssSelector("div.modal-content");
     By RefusalAtWarningModatToSignPrimaryDoc=By.cssSelector("button.btn.btn.btn-danger.ng-binding");


    /**
     * Заміна авторизаційної ролі на роль Клієнт
     */
    public void changeUserRole()
    {
        try
        {
            WebElement element= WaitUntilElementWillBePresentOnPage10(driver, clickOnDropDownList);
            element.click();
            WaitUntilElementWillBeClickableOnPage(driver, chooseClientRoleFromDropDownList);

            FindAndClickByLocator(driver, chooseClientRoleFromDropDownList);
            closeSignPrimaryDocModal(driver);
            WaitUntilElementWillBePresentOnPage10(driver, ShoppingCartButton);
        }
        catch(TimeoutException e)
        {
            e.getStackTrace();
            System.out.println("Role dropDown is not exist. Only one role at this cabinet");
        }
    }

    /**
     * Перевірка наявності модального вікна підписання первинних документів відсутнє
     */

    public boolean closeSignPrimaryDocModal (WebDriver driver)
    {
        boolean isModalPresent=false;
        try
        {
            WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, WarningModatToSignPrimaryDoc);
            WebElementHelper.FindAndClickByLocator(driver,RefusalAtWarningModatToSignPrimaryDoc );
            isModalPresent=true;
        }
        catch(TimeoutException e)
        {
            throw new TimeoutException("The modal window for signing primary documents is missing.");
        }
        return isModalPresent;
    }

}
