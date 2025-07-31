package OrderFlowTests;

import Base.BaseTest;
import org.junit.jupiter.api.Test;

public class LicenseOrderFlowTest extends BaseTest
{


    @Test
    public void creatAndFinishLicReqest()
    {
        authPage.getLoginPage();
        authPage.loginUsingFileKey();
        basePage.authCookie();
        commonActionsAfterAuth.changeUserRole();
        chooseTypeOfLicensingPage.stratNewReqest();
        step11Page.determinateTypeOfFillingDependendingOnSubjectType();
    }
}
