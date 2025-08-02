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
        commonActionsAfterAuth.closeModalInfoForPaymentRequestRoleVpr();
        commonActionsAfterAuth.changeUserRole();
        commonActionsAfterAuth.closeSignPrimaryDocModal();
        chooseTypeOfLicensingPage.stratNewReqest();
        step11Page.determinateTypeOfFillingDependendingOnSubjectTypeForStep1();
        step21Page.determinateTypeOfFillingDependendingOnSubjectTypeForStep2();
    }
}
