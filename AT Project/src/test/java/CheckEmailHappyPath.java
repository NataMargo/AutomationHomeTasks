
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CheckEmailHappyPath {
        @DataProvider(name = "getValidEmail")
        public static Object[][] getValidEmail() {
            return new Object[][]{
                    {"Test@123.com"},
                    {"A_b1!@ukr.net"},
                    {"Test@TEST.net"},
                    {"Tet@ukr9.net"},
                    {"Test@TEST.net"},
                    {"Test12345678910qwerQ@Tukr.net"},
                    {"Test@gh.net"},
                    {"Test@test.ne"},
                    {"Test@ddd12.ngnet"}
            };
        }

        @Test(dataProvider = "getValidEmail")
        public void checkCorrectEmail(String email) {
            boolean actualResult = Email.isEmailCorrect(email);
            Assert.assertTrue(actualResult, "This is an incorrect email!");
        }

    }
