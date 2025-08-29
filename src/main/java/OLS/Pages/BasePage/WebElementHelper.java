package OLS.Pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public static WebElement WaitUntilElementWillBePresentOnPage1260(WebDriver driver, By locator)
    {
        WebElement element=(new WebDriverWait(driver, Duration.ofSeconds(1260))).until(ExpectedConditions.visibilityOfElementLocated(locator));
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

    public static void WaitUntilElementWillNotBePresentOnPage(WebDriver driver, By locator)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
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


    /**
     * Методи для отримання доп інформації
     *
     */
    public static String gatTextFromElement(WebDriver driver, By locator)
    {
        WebElement element=driver.findElement(locator);
        return element.getText();
    }

    public static String getTextFromElementWithNbsp (WebDriver driver, By locator)
    {
        boolean check=false;
        String texs=null;
        do
        {
            WebElement element= WebElementHelper.WaitUntilElementWillBeClickableOnPage5(driver, locator);
            if(element.getText().equals(" "))
            {
                check=false;
            }
            else
            {
                texs=element.getText();
                check=true;
            }

        }
        while(!check);

        return texs;
    }

    /**
     * отримати текст з елемента

     */
    public static String getValueFromText(WebDriver driver, By locator,  String startText,  String endText)
    {
        String fullText=driver.findElement(locator).getText();
        int startIndex=fullText.indexOf(startText)+startText.length();
        int endIndex=fullText.indexOf(endText, startIndex);
        String ValueFromText=fullText.substring(startIndex, endIndex).trim();
        return ValueFromText;
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

    /**
     * Порівняння тексту з едемента з Еталоном
     */
    public static boolean compareTextAtElementWithEtalon(WebDriver driver, By locator, String etalon)
    {
        return driver.findElement(locator).getText().equals(etalon);
    }


}
