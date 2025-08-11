package OLS.Pages.ClientRolePages;

import OLS.Pages.BasePage.WebElementHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static OLS.Common.CommonActions.logger;
import static OLS.Pages.BasePage.WebElementHelper.compareTextAtElementWithEtalon;
import static OLS.Pages.BasePage.WebElementHelper.gatTextFromElement;

public class Step31PageClass
{
    WebDriver driver;
    Actions action;

    public Step31PageClass (WebDriver driver, Actions action)
    {
        this.driver=driver;
        this.action=action;
    }

    /**
     * Продовжити створення замовленняя. Перехід з кроку 2 на крок 3
     */
    By goToStep3Button= By.cssSelector("button.btn.btn-success.btn-next.ng-binding");

    /**
     * Контрольний елемент при переході на крок 3
     */
    By textOnStep3 =By.cssSelector("h2[data-translate='order.step3.Step32ViewWaitForDocsTitle']");

    /**
     * Елементи до заповнення
     */
    By PaymentAfterSignDocModal=By.cssSelector("div.modal-content");
    By textAtSignDocModal=By.cssSelector("div.bootbox-body");






    public void determinateTypeOfFillingDependendingOnSubjectTypeForStep3 ()
    {
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, goToStep3Button).click();
        logger.info("----End of 2-t Step----");
        logger.info("----Start of 3-d Step----");

        try
        {
            WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, textOnStep3);
            if(compareTextAtElementWithEtalon(driver,textOnStep3, "Крок 3: Формування документів"))
            {
                logger.info("Контрольний елемент відображається на сторінці Крок3");
            }
            else
            {
                throw new TimeoutException();
            }

        }
        catch(TimeoutException e)
        {
            logger.error("Контрольний елемент не відображається на сторінці Крок3");
            throw new TimeoutException("Контрольний елемент не відображається на сторінці Крок3");
        }

        WebElementHelper.WaitUntilElementWillBePresentOnPage1260(driver,PaymentAfterSignDocModal);
        Assertions.assertEquals(gatTextFromElement(driver, textAtSignDocModal), "Оплачуйте послугу після підписання електронних документів.");





    }
}
