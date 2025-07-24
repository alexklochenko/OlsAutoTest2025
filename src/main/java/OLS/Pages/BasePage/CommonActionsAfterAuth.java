package OLS.Pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static OLS.Pages.BasePage.WebElementHelper.*;

public class CommonActionsAfterAuth
{
     By clickOnDropDownList=By.cssSelector("li.dropdown.ng-scope");
     By chooseClientRoleFromDropDownList=By.xpath("//li[@ng-repeat='role in app.user.UserRoles']//a[text()='Клієнт']");
     By ShoppingCartButton=By.cssSelector("a.btn.cart-link[data-ui-sref='app.cart']:not([style='margin-right: 50px;'])");

    public void changeUserRole(WebDriver driver)
    {
        try
        {
            WebElement element= WaitUntilElementWillBePresentOnPage10(driver, clickOnDropDownList);
            element.click();
            FindAndClickByLocatorByXpath(driver, chooseClientRoleFromDropDownList);
            WaitUntilElementWillBePresentOnPage10(driver, ShoppingCartButton);
        }
        catch(TimeoutException e)
        {
            e.getStackTrace();
            System.out.println("Role dropDown is not exist. Only one role at this cabinet");
        }
    }

}
