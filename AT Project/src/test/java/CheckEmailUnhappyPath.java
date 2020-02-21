import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckEmailUnhappyPath {
    @DataProvider(name = "getInvalidEmail")
    public static Object[][] getEmails() {
        return new Object[][]{
                {"Test12345678901234567@123.net"},
                {"Te@dot.net"},
                {" @123.com"},
                {"hh@123.com"},
                {" "},
                {""},
                {"@java.com"},
                {"Test@123.COM"},
                {"Test@123.comnet"},
                {"тррор@ukt.net"},
                {"1@ukr.net"},
                {"Test@n_e.com"},
                {"Test@TEST.n23"},
                {"Test@n.net"},
                {"Test@net.n"},
                {"Test@netene.com"},
                {"Test@1.com"},
                {"Test123.net"},
                {"admin@gmailcom"},
                {"T st@TEST.net"},
                {"Test@T n.net"},
                {"Test@TEST.n t"},
                {"123@ukr.n"},
                {"nataukr.net"}};
    }

    @Test(dataProvider = "getInvalidEmail")
    public void checkIncorrectEmail(String email) {
        boolean actualResult = Email.isEmailCorrect(email);
        Assert.assertFalse(actualResult, email + " - is a correct email!");
    }
}
