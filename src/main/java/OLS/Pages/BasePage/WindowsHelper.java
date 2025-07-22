package OLS.Pages.BasePage;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class WindowsHelper
{

    public static void ChooseFileFromPC(String WayToPKey) throws AWTException
    {
        Robot robot = new Robot();
        robot.delay(2000);
        StringSelection stringSelection = new StringSelection(WayToPKey);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
    }

}
