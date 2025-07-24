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
        System.out.println( basePage.authCookie());;
    }

}
