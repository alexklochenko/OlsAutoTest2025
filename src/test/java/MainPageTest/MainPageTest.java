package MainPageTest;

import Base.BaseTest;
import org.junit.jupiter.api.Test;

public class MainPageTest extends BaseTest
{
    @Test
            public void checkSalesPage()
    {
        homePage.openAndCheckHeaderOnSalesPage();
        homePage.openAndCheckLandlinePhoneNumber();
        homePage.openAndCheckLifelinePhoneNumber();
        homePage.openAndCheckVodafonePhoneNumber();
        homePage.openAndCheckKyivstarPhoneNumber();
        homePage.openAndCheckEmailFooter();
        homePage.openAndCheckLinkToYoutubeFooter();
    }


}
