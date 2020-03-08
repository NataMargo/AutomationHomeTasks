package page_object_model_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class TestDropDownMenu extends BeforeTesting {
    private static final String BASE_URL = "https://formy-project.herokuapp.com/";
    private static final String BASE_XPATH = "//div/div/a";

    @BeforeMethod
    public void openPage() {
        driver.get("https://formy-project.herokuapp.com/dropdown");
        DropDownPage dropDownPage = new DropDownPage(driver);
        dropDownPage.dropDownMenuClick();
    }

    @AfterMethod
    public void navigateBack() {
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DataProvider
    public static Object[][] getDropDownItem() {
        return new Object[][]{
                {BASE_URL + "autocomplete", BASE_XPATH+"[1]"},
                {BASE_URL + "buttons", BASE_XPATH+"[2]"},
                {BASE_URL + "checkbox", BASE_XPATH+"[3]"},
                {BASE_URL + "datepicker", BASE_XPATH+"[4]"},
                {BASE_URL + "dragdrop", BASE_XPATH+"[5]"},
                {BASE_URL + "enabled", BASE_XPATH+"[7]"},
                {BASE_URL + "fileupload", BASE_XPATH+"[8]"},
                {BASE_URL + "filedownload", BASE_XPATH+"[9]"},
                {BASE_URL + "keypress", BASE_XPATH+"[10]"},
                {BASE_URL + "modal", BASE_XPATH+"[11]"},
                {BASE_URL + "scroll", BASE_XPATH+"[12]"},
                {BASE_URL + "radiobutton", BASE_XPATH+"[13]"},
                {BASE_URL + "switch-window", BASE_XPATH+"[14]"},
                {BASE_URL + "form", BASE_XPATH+"[15]"}
        };
    }

    @Test(dataProvider = "getDropDownItem")
    public void checkDropDownMenu(String expectedUrl, String dropDownItemXpath) {
        WebElement dropDownItem = driver.findElement(By.xpath(dropDownItemXpath));
        dropDownItem.click();
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedUrl, "Link is not correct. Actual result is: " + actualResult + " Expected: " + expectedUrl);
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void clickDropDownButton() {
        DropDownPage.dropDownButton.click();
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, BASE_URL + "dropdown", "Link is not correct. Actual result is: " + actualResult + " Expected: " + BASE_URL + "dropdown");


    }

}
