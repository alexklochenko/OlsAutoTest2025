package MainPageTest;

import Base.BaseTest;
import org.junit.jupiter.api.Test;

public class MainPageTest extends BaseTest
{
    @Test
            public void checkSalesPage()
    {
        salesPage.openAndCheckHeaderOnSalesPage();
        salesPage.openAndCheckLandlinePhoneNumber();
        salesPage.openAndCheckLifelinePhoneNumber();
        salesPage.openAndCheckVodafonePhoneNumber();
        salesPage.openAndCheckKyivstarPhoneNumber();
        salesPage.openAndCheckEmailFooter();
        salesPage.openAndCheckLinkToYoutubeFooter();
    }


}
