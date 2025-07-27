package AuthPageTests;

import org.junit.jupiter.api.Test;
import Base.BaseTest;

public class AuthPageTest extends BaseTest
{
    @Test
    public void LoginFileKey()
    {
        authPage.getLoginPage();
        authPage.loginUsingFileKey();
        basePage.authCookie();
        commonActionsAfterAuth.changeUserRole();
    }

    @Test
    public void makePaymentByMonoCase()
    {
        basePage.makeAPaymentByMono();
    }

    @Test
    public void justTest()
    {
        basePage.checkLicensingForOrgSubjectType();

    }
}
