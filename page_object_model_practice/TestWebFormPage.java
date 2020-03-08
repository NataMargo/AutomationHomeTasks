package page_object_model_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestWebFormPage extends BeforeTesting {
    private final String SUBMIT_PAGE_EXPECTED = "https://formy-project.herokuapp.com/thanks";
    private final String WEB_FORM_EXPECTED = "https://formy-project.herokuapp.com/form";

    @Test
    // по цьому тесту є питання!
    // Якщо вручну його проходити, то перехід відбувається на сторінку з заголовком "Thanks for submitting your form",
    // тобто начебто користувач таки відправивши порожню форму таки зареєструвався
    public void sendEmptyWebForm() {
        driver.get("https://formy-project.herokuapp.com/form");
        WebFormPage webFormPage = new WebFormPage(driver);
        SubmitPage submitPage = webFormPage.submit();
        Assert.assertEquals(SUBMIT_PAGE_EXPECTED, driver.getCurrentUrl(), "Submit form is not initialized");
        Assert.assertEquals( submitPage.confirmationHeader(),"Complete Web Form");
    }

    @Test
    public void sendFullValidWebForm() {
        driver.get("https://formy-project.herokuapp.com/form");
        WebFormPage webFormPage = new WebFormPage(driver);
        Assert.assertEquals(WEB_FORM_EXPECTED, driver.getCurrentUrl(), "Web form page is not initialized");

        webFormPage.enterFirstName("Adam");
        webFormPage.enterLastName("Smith");
        webFormPage.enterJob("engineer");
        webFormPage.enterEducation("high");
        webFormPage.enterGender("male");
        webFormPage.enterExperience(19);
        webFormPage.setdate("03/05/2020");
        SubmitPage submitPage = webFormPage.submit();

        Assert.assertEquals(driver.getCurrentUrl(), SUBMIT_PAGE_EXPECTED, "Submit form is not initialized" + " expected: " + SUBMIT_PAGE_EXPECTED);
        driver.navigate().refresh();
        Assert.assertEquals(submitPage.confirmationHeader(), "Thanks for submitting your form");

    }
}
