package page_object_model_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebFormPage extends PageObject {

    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "job-title")
    private WebElement job;

    @FindBy(id = "radio-button-1")
    private WebElement education1;
    @FindBy(id = "radio-button-2")
    private WebElement education2;
    @FindBy(id = "radio-button-3")
    private WebElement education3;

    @FindBy(id = "checkbox-1")
    private WebElement male;
    @FindBy(id = "checkbox-2")
    private WebElement female;
    @FindBy(id = "checkbox-3")
    private WebElement sexNA;

    @FindBy(id = "select-menu")
    private WebElement selectMenu;
    @FindBy(xpath = "//select/option[1]")
    private WebElement opt1;
    @FindBy(xpath = "//select/option[2]")
    private WebElement opt2;
    @FindBy(xpath = "//select/option[3]")
    private WebElement opt3;
    @FindBy(xpath = "//select/option[4]")
    private WebElement opt4;
    @FindBy(xpath = "//select/option[0]")
    private WebElement opt0;

    @FindBy(id = "datepicker")
    private WebElement date;

    @FindBy(xpath = "//a[contains(@role,'button')]")
    private WebElement submit;

    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public void enterJob(String job) {
        this.job.clear();
        this.job.sendKeys(job);
    }

    void enterGender(String m) {
        if (m.equals("male")) {
            this.male.click();
        } else if (m.equals("female")) {
            this.female.click();
        } else {
            this.sexNA.click();
        }
    }


    public void enterEducation(String ed) {
        if (ed.equals("high")) {
            this.education1.click();
        } else if (ed.equals("college")) {
            this.education2.click();
        } else {
            this.education3.click();
        }
    }


    public void enterExperience(int a) {
        this.selectMenu.click();
        if (a <= 1) {
            this.opt1.isSelected();
        } else if (a <= 4 || a > 1) {
            this.opt2.click();
        } else if (a <= 9 || a > 4) {
            this.opt3.click();
        } else if (a >= 10) {
            this.opt4.click();
        } else {
            this.opt0.click();
        }

    }

    public void setdate(String date) {
        this.date.clear();
        this.date.sendKeys(date);
    }

    public SubmitPage submit() {
        submit.click();
        return new SubmitPage(driver);
    }
}
