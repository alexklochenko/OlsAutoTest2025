package OLS.Pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementHelper
{

    /**
     * Wait Methods
     * */
    public static WebElement WaitUntilElementWillBePresentOnPage(WebDriver driver, By locator)
    {
        WebElement element=(new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public static WebElement WaitUntilElementWillBeClickableOnPage(WebDriver driver, By locator)
    {
        WebElement element=(new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    /**
     * Actions Methods
     */
    public static WebElement FindAndClickByLocator(WebDriver driver, By locator)
    {
        WebElement element =driver.findElement(locator);
        element.click();
        return element;
    }

    public static WebElement FindAndClickByLocatorByXpath(WebDriver driver, By locator)
    {
        WebElement element =driver.findElement(locator);
        element.click();
        return element;
    }


    /**
     * Check meth
     */

    public static void checkActivateCheckbox(WebDriver driver, By locator)
    {
        (new WebDriverWait (driver, Duration.ofSeconds(5))).until(ExpectedConditions.elementToBeSelected(locator));
    }


}
