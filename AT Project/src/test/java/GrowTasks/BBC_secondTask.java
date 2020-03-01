package GrowTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BBC_secondTask {
    private static final String EXE_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static WebDriver driver = new ChromeDriver();
    private String message100 = "Я чекав тебе з хмари рожево-ніжної,\n" +
            "Із ранкових туманів, з небесних октав,\n" +
            "Коли думи збігалися з мли бездоріжної\n" +
            "І незвіданий смуток за душу смоктав.\n" +
            "\n" +
            "Я від тебе жадав незвичайного й дивного,\n" +
            "Щоб з'явилася маревом, видивом, сном,\n" +
            "Щоби я знемагав од дихання нерівного,\n" +
            "Од заклятої радості під вікном.\n" +
            "\n" +
            "І не міг я спекатися словесної пишності,\n" +
            "Одсахнутись ураз од кокетливих мрій —\n" +
            "Волочив я тебе в ореолі безгрішності\n" +
            "Крізь хитливих ілюзій розкиданий стрій.\n" +
            "\n" +
            "Припливла ти до мене з прибоєм уяви,\n" +
            "Несподівано встала над смутком чекань —\n" +
            "Розцяцькований мрій павіани і пави\n" +
            "Повтікали лякливо під купол світань.\n" +
            "\n" +
            "Розгубили вони свої зваби і почесті...";

    private String message200 = "Ти лежиш іще впоперек ліжка —\n" +
            "Ну до чого мале й чудне!\n" +
            "А до тебе незримі віжки\n" +
            "Прив'язали цупко мене.\n" +
            "\n" +
            "Кажуть, носа ти вкрав у баби,\n" +
            "Губи й ноги забрав мої,\n" +
            "Взяв у матері синю звабу\n" +
            "І в очах своїх затаїв.\n" +
            "\n" +
            "Спи, грабіжнику мій кирпатий.\n" +
            "Сумнів диханням розіграй,\n" +
            "Я тобі стану в голови слати\n" +
            "Найніжніші подушки мрій.\n" +
            "\n" +
            "Розішлю свої думи в дозори,\n" +
            "Щоб у сизому міражі\n" +
            "Не ступило свавільне горе\n" +
            "На кордони твоєї душі.\n" +
            "\n" +
            "Бо не змок ще убивчий порох\n" +
            "Од потоків дитячих сліз —\n" +
            "Через трупи надій бадьорих\n" +
            "Твій одвічний і підлий ворог\n" +
            "До усмішки твоєї ліз.\n" +
            "\n" +
            "Над народами, над віками\n" +
            "Встало горе, мов чорний гном.\n" +
            "Торохтять бойовів тамтами\n" +
            "Над прозорим дитячим сном.\n" +
            "\n" +
            "Відгодована злість, і хитрість,\n" +
            "І закута в броню брехня\n" +
            "Атакують добро і щирість\n" +
            "Серед ночі й білого дня.\n" +
            "\n" +
            "Гуркотять бойові колісниці,\n" +
            "Свищуть ратища і шаблі…\n" +
            "І тривозі моїй не спиться,\n" +
            "Йде вона босоніж по землі.\n" +
            "\n" +
            "І встає проти кривди й злоби\n" +
            "Мій обсмалений сонцем гнів,\n" +
            "Щоби спав ти спокійно, щоби\n" +
            "Ти сміявся і жебонів.\n" +
            "\n" +
            "І ладнає совість гармати\n" +
            "Проти підлості і обмов,\n" +
            "І виводить зневіру на страту\n" +
            "Безпощадна моя любов.\n" +
            "\n" +
            "Наливайся земними силами,\n" +
            "Вдосталь радощів зачерпни —\n" +
            "Над тобою тріпочуть крилами\n" +
            "Тихі-тихі спокійні сни…";

    @BeforeClass
    public static void openWindow() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bbc.com/");
    }

    @AfterClass
    public static void closeWindow() {
        driver.quit();
    }

    @Test
    public void shareBbcFieldEmptySend() {
        WebElement newsButton = driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']/a"));
        newsButton.click();

        WebElement moreDrop = driver.findElement(By.xpath("//div[2]//nav//span/button/span"));
        moreDrop.click();

        WebElement haveYouSay = driver.findElement(By.xpath("//div[7]//ul[4]/li/a/span"));
        haveYouSay.click();

        WebElement toShare = driver.findElement(By.xpath("//div[2]/div[3]/div/div/div/a"));
        toShare.click();

        WebElement sendButton = driver.findElement(By.xpath("//div[@class='contact-form__submit']/input[4]"));

        String expectedResult = driver.getCurrentUrl();
        sendButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), expectedResult, "The page is not the same, the empty form was sent");
    }

    @Test
    public void shareBbcFieldNotEmpty() {
        WebElement newsButton = driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']/a"));
        newsButton.click();

        WebElement moreDrop = driver.findElement(By.xpath("//div[2]//nav//span/button/span"));
        moreDrop.click();

        WebElement haveYouSay = driver.findElement(By.xpath("//div[7]//ul[4]/li/a/span"));
        haveYouSay.click();

        WebElement toShare = driver.findElement(By.xpath("//div[2]/div[3]/div/div/div/a"));
        toShare.click();

        String expectedResult = driver.getCurrentUrl();
        WebElement nameField = driver.findElement(By.id("fullName"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement townField = driver.findElement(By.id("town"));
        WebElement phoneField = driver.findElement(By.id("phone"));
        WebElement messageField = driver.findElement(By.id("message"));

        nameField.click();
        nameField.sendKeys("Nata");

        emailField.click();
        emailField.sendKeys("Nata@gmail.com");

        townField.click();
        townField.sendKeys("California");

        phoneField.click();
        phoneField.sendKeys("3804412345678");

        messageField.click();
        messageField.sendKeys(message100);
        Assert.assertNotEquals(driver.getCurrentUrl(), expectedResult, "The page is the same, you didn't sent your form");
    }

    @Test
    public void shareBbcFieldWith200words() {

        WebElement newsButton = driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']/a"));
        newsButton.click();

        WebElement moreDrop = driver.findElement(By.xpath("//div[2]//nav//span/button/span"));
        moreDrop.click();

        WebElement haveYouSay = driver.findElement(By.xpath("//div[7]//ul[4]/li/a/span"));
        haveYouSay.click();

        WebElement toShare = driver.findElement(By.xpath("//div[2]/div[3]/div/div/div/a"));
        toShare.click();

        String expectedResult = driver.getCurrentUrl();
        WebElement nameField = driver.findElement(By.id("fullName"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement townField = driver.findElement(By.id("town"));
        WebElement phoneField = driver.findElement(By.id("phone"));
        WebElement messageField = driver.findElement(By.id("message"));

        nameField.click();
        nameField.sendKeys("Nata");

        emailField.click();
        emailField.sendKeys("Nata@gmail.com");

        townField.click();
        townField.sendKeys("California");

        phoneField.click();
        phoneField.sendKeys("3804412345678");

        messageField.click();
        messageField.sendKeys(message200);
        Assert.assertNotEquals(driver.getCurrentUrl(), expectedResult, "The page is the same, you didn't sent your form");
    }

    @Test
    public void shareBbcFieldWithOutEmail() {
        WebElement newsButton = driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']/a"));
        newsButton.click();
        WebElement moreDrop = driver.findElement(By.xpath("//div[2]//nav//span/button/span"));
        moreDrop.click();

        WebElement haveYouSay = driver.findElement(By.xpath("//div[7]//ul[4]/li/a/span"));
        haveYouSay.click();

        WebElement toShare = driver.findElement(By.xpath("//div[2]/div[3]/div/div/div/a"));
        toShare.click();

        String expectedResult = driver.getCurrentUrl();
        WebElement nameField = driver.findElement(By.id("fullName"));
        WebElement townField = driver.findElement(By.id("town"));
        WebElement phoneField = driver.findElement(By.id("phone"));
        WebElement messageField = driver.findElement(By.id("message"));

        nameField.click();
        nameField.sendKeys("Nata");

        townField.click();
        townField.sendKeys("California");

        phoneField.click();
        phoneField.sendKeys("3804412345678");

        messageField.click();
        messageField.sendKeys(message100);
        Assert.assertNotEquals(driver.getCurrentUrl(), expectedResult, "The page is the same, you didn't sent your form");
    }

    @Test
    public void shareBbcFieldEmptyMessage() {
        WebElement newsButton = driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']/a"));
        newsButton.click();

        WebElement moreDrop = driver.findElement(By.xpath("//div[2]//nav//span/button/span"));
        moreDrop.click();

        WebElement haveYouSay = driver.findElement(By.xpath("//div[7]//ul[4]/li/a/span"));
        haveYouSay.click();

        WebElement toShare = driver.findElement(By.xpath("//div[2]/div[3]/div/div/div/a"));
        toShare.click();

        String expectedResult = driver.getCurrentUrl();
        WebElement nameField = driver.findElement(By.id("fullName"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement townField = driver.findElement(By.id("town"));
        WebElement phoneField = driver.findElement(By.id("phone"));

        nameField.click();
        nameField.sendKeys("Nata");

        emailField.click();
        emailField.sendKeys("Nata@gmail.com");

        townField.click();
        townField.sendKeys("California");

        phoneField.click();
        phoneField.sendKeys("3804412345678");

        Assert.assertNotEquals(driver.getCurrentUrl(), expectedResult, "The page is the same, you didn't sent your form");
    }
}
