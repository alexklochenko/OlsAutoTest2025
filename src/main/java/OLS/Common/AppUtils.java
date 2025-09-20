package OLS.Common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static OLS.Common.DriverHelper.logger;

public class AppUtils
{
    /**
     * Перевірка наявності елемента в масиві
     */
    public static boolean isElementInArray (int[] array, int id )
    {
        for(int i=0; i<array.length; i++)
        {
            if (array[i]==id)
            {
                return true;
            }
        }
        return false;
    }

    public static void verifySlotIsSign (WebDriver driver, By slotHeader, String expectedText)
    {
        String headerText=ElementHelper.getTextFromElement (driver, slotHeader);
        Assertions.assertEquals(expectedText,headerText);
        logger.info("Підпис успішно накладено");

    }

}
