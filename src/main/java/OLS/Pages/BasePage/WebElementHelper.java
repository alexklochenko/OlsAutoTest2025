package OLS.Pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v137.domsnapshot.model.StringIndex;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static OLS.Common.Config.TEST_ORG_BOSS_JOB_TITLE;

public class WebElementHelper
{

    /**
     * Wait Methods
     * */
    public static WebElement WaitUntilElementWillBePresentOnPage2(WebDriver driver, By locator)
    {
        WebElement element=(new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public static WebElement WaitUntilElementWillBePresentOnPage5(WebDriver driver, By locator)
    {
        WebElement element=(new WebDriverWait(driver, Duration.ofSeconds(5))).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }
    public static WebElement WaitUntilElementWillBePresentOnPage10(WebDriver driver, By locator)
    {
        WebElement element=(new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }


    public static WebElement WaitUntilElementWillBePresentOnPage90(WebDriver driver, By locator)
    {
        WebElement element=(new WebDriverWait(driver, Duration.ofSeconds(90))).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public static WebElement WaitUntilElementWillBeClickableOnPage5(WebDriver driver, By locator)
    {
        WebElement element=(new WebDriverWait(driver, Duration.ofSeconds(5))).until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public static WebElement WaitUntilElementWillBeClickableOnPage(WebDriver driver, By locator)
    {
        WebElement element=(new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }


    public static WebElement WaitUntilElementWillBeClickable10(WebDriver driver, By locator)
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

    public static boolean checkDiactivateCheckbox(WebDriver driver, By locator)
    {
        return (new WebDriverWait (driver, Duration.ofSeconds(5))).until(ExpectedConditions.elementSelectionStateToBe(locator, false));
    }


    public static String gatTextFromElement(WebDriver driver, By locator)
    {
        WebElement element=driver.findElement(locator);
        return element.getText();
    }

    /**
     * SendKeys Method
     */

    public static void ClearAndSeendKeys(WebDriver driver, By locator, String value)
    {
        WebElementHelper.WaitUntilElementWillBePresentOnPage2(driver, locator);
        WebElement element= driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(value);
    }


}
