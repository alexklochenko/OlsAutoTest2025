package OLS.Pages.MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Assertions;

import static OLS.Common.Config.MAIN_URL;
import static OLS.Pages.BasePage.WebElementHelper.WaitUntilElementWillBePresentOnPage;

public class SalesPageClass
{
    WebDriver driver;
    public SalesPageClass(WebDriver driver)
    {
        this.driver=driver;
    }


    By headerTitle= By.cssSelector("h1[style='text-align: center; margin-bottom: 25px;']");
    By landlinePhoneNumber= By.cssSelector("a[href='tel:+380442061378']");
    By lifelinePhoneNumber= By.cssSelector("a[href='tel:+380637997868']");
    By vodafonePhoneNumber= By.cssSelector("a[href='tel:+380665224038']");
    By kyivstarPhoneNumber= By.cssSelector("a[href='tel:+38 068 073 91 70']");
    By emailFooter= By.cssSelector("a[href='mailto:help@am-soft.ua']");
    By linkToToutubeFooter= By.cssSelector("a[href='https://www.youtube.com/playlist?list=PLv2RJ-mKv4O-aM2ez5KHLf7-cV4CLSyTq']");


    public void openAndCheckHeaderOnSalesPage()
    {
        driver.get(MAIN_URL+"info/sale");
        WebElement element=WaitUntilElementWillBePresentOnPage(driver, headerTitle);
        String headerSalesPageText=element.getText();
        Assertions.assertEquals("Акції", headerSalesPageText);
    }

    public void openAndCheckLandlinePhoneNumber()
    {
        WebElement element=WaitUntilElementWillBePresentOnPage(driver, landlinePhoneNumber);
        String landlinePhoneNumberText=element.getText();
        Assertions.assertEquals("+38 044 206 13 78", landlinePhoneNumberText);

    }

    public void openAndCheckLifelinePhoneNumber()
    {
        WebElement element=WaitUntilElementWillBePresentOnPage(driver, lifelinePhoneNumber);
        String lfelinePhoneNumberText=element.getText();
        Assertions.assertEquals("+38 063 799 78 68", lfelinePhoneNumberText);
    }

    public void openAndCheckVodafonePhoneNumber()
    {
        WebElement element=WaitUntilElementWillBePresentOnPage(driver, vodafonePhoneNumber);
        String vodafonePhoneNumberText=element.getText();
        Assertions.assertEquals("+38 066 522 40 38", vodafonePhoneNumberText);
    }

    public void openAndCheckKyivstarPhoneNumber()
    {
        WebElement element=WaitUntilElementWillBePresentOnPage(driver, kyivstarPhoneNumber);
        String kyivstarPhoneNumberText=element.getText();
        Assertions.assertEquals("+38 068 073 91 70", kyivstarPhoneNumberText);
    }

    public void openAndCheckEmailFooter()
    {
        WebElement element=WaitUntilElementWillBePresentOnPage(driver, emailFooter);
        String EmailFooterText=element.getText();
        Assertions.assertEquals("help@am-soft.ua", EmailFooterText);
    }

    public void openAndCheckLinkToYoutubeFooter()
    {
        WebElement element=WaitUntilElementWillBePresentOnPage(driver, linkToToutubeFooter);
        String linkToToutubeText=element.getAttribute("href");
        Assertions.assertEquals("https://www.youtube.com/playlist?list=PLv2RJ-mKv4O-aM2ez5KHLf7-cV4CLSyTq", linkToToutubeText);
    }




}
