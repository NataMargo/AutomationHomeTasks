import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckEmailUnhappyPath {
    public static class DataProviderTest {

        @Test(dataProvider = "getEmail")

        public void CheckIncorrectEmail(String email) {

            Boolean actualResult = Email.isEmailCorrect(email);
            Assert.assertFalse(actualResult, email+" - is a correct email!");
        }

        @DataProvider(name = "getEmail")
            public static Object[][] getEmails() {
            return new Object[][]
                    {
                            {"Test159123456789bnmmmmmmhq@123.net"},
                            {" @123.com"},
                            {"hh@123.com"},
                            {" "},
                            {""},
                            {"@java.com"},
                            {"Test@123.COM"},
                            {"Test@123.comnet"},
                            {"тррор@ukt.net"},
                            {"1@ukr.net"},
                            {"Test@ne.com"},
                            {"Test@netene.com"},
                            {"Test@1.com"},
                            {"Test123.net"},
                            {"admin@gmailcom"},
                            {"123@ukr.n"},
                            {"nataukr.net"}};
        }
    }
}