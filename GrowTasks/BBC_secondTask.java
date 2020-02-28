package GrowTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BBC_secondTask {
    private final String EXE_PATH = "C:\\webdrivers\\chromedriver.exe";
    String message100 = "Я чекав тебе з хмари рожево-ніжної,\n" +
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

    String message200 = "Ти лежиш іще впоперек ліжка —\n" +
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

    @Test
    public void shareBbcFieldEmptySend() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bbc.com/");
        Actions action = new Actions(driver);
        WebElement newsButton = driver.findElement(By.xpath("/html/body/header/div/div[1]/nav/div/ul/li[2]/a"));
        action.moveToElement(newsButton);
        newsButton.click();
        System.out.println(driver.getTitle());
        WebElement moreDrop = driver.findElement(By.xpath("//div[2]//nav//span/button/span"));
        moreDrop.click();
        WebElement haveYouSay = driver.findElement(By.xpath("//div[7]//ul[4]/li/a/span"));
        haveYouSay.click();
        WebElement toShare = driver.findElement(By.xpath("/html/body/div[7]/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/a"));
        toShare.click();
        String expectedResult = driver.getCurrentUrl();
        WebElement sendButton = driver.findElement(By.xpath("//div[@class=\"contact-form__submit\"]/input[4]"));
        sendButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), expectedResult, "The page is not the same, you send the empty form");
    }

    @Test
    public void shareBbcFieldNotEmpty() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bbc.com/");
        Actions action = new Actions(driver);
        WebElement newsButton = driver.findElement(By.xpath("/html/body/header/div/div[1]/nav/div/ul/li[2]/a"));
        action.moveToElement(newsButton);
        newsButton.click();
        System.out.println(driver.getTitle());
        WebElement moreDrop = driver.findElement(By.xpath("//div[2]//nav//span/button/span"));
        moreDrop.click();
        WebElement haveYouSay = driver.findElement(By.xpath("//div[7]//ul[4]/li/a/span"));
        haveYouSay.click();
        WebElement toShare = driver.findElement(By.xpath("/html/body/div[7]/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/a"));
        toShare.click();
        String expectedResult = driver.getCurrentUrl();
        WebElement nameField = driver.findElement(By.xpath("//*[@id=\"fullName\"]"));
        nameField.click();
        nameField.sendKeys("Nata");
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailField.click();
        emailField.sendKeys("Nata@gmail.com");
        WebElement townField = driver.findElement(By.xpath("//*[@id=\"town\"]"));
        townField.click();
        townField.sendKeys("California");
        WebElement phoneField = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        phoneField.click();
        phoneField.sendKeys("3804412345678");
        WebElement messageField = driver.findElement(By.xpath("//*[@id=\"message\"]"));
        messageField.click();
        messageField.sendKeys(message100);
        Assert.assertNotEquals(driver.getCurrentUrl(), expectedResult, "The page is the same, you didn't sent your form");
    }

    @Test
    public void shareBbcFieldWith200words() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bbc.com/");
        Actions action = new Actions(driver);
        WebElement newsButton = driver.findElement(By.xpath("/html/body/header/div/div[1]/nav/div/ul/li[2]/a"));
        action.moveToElement(newsButton);
        newsButton.click();
        System.out.println(driver.getTitle());
        WebElement moreDrop = driver.findElement(By.xpath("//div[2]//nav//span/button/span"));
        moreDrop.click();
        WebElement haveYouSay = driver.findElement(By.xpath("//div[7]//ul[4]/li/a/span"));
        haveYouSay.click();
        WebElement toShare = driver.findElement(By.xpath("/html/body/div[7]/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/a"));
        toShare.click();
        String expectedResult = driver.getCurrentUrl();
        WebElement nameField = driver.findElement(By.xpath("//*[@id=\"fullName\"]"));
        nameField.click();
        nameField.sendKeys("Nata");
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailField.click();
        emailField.sendKeys("Nata@gmail.com");
        WebElement townField = driver.findElement(By.xpath("//*[@id=\"town\"]"));
        townField.click();
        townField.sendKeys("California");
        WebElement phoneField = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        phoneField.click();
        phoneField.sendKeys("3804412345678");
        WebElement messageField = driver.findElement(By.xpath("//*[@id=\"message\"]"));
        messageField.click();
        messageField.sendKeys(message200);
        Assert.assertNotEquals(driver.getCurrentUrl(), expectedResult, "The page is the same, you didn't sent your form");
    }

    @Test
    public void shareBbcFieldWithOutEmail() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bbc.com/");
        Actions action = new Actions(driver);
        WebElement newsButton = driver.findElement(By.xpath("/html/body/header/div/div[1]/nav/div/ul/li[2]/a"));
        action.moveToElement(newsButton);
        newsButton.click();
        System.out.println(driver.getTitle());
        WebElement moreDrop = driver.findElement(By.xpath("//div[2]//nav//span/button/span"));
        moreDrop.click();
        WebElement haveYouSay = driver.findElement(By.xpath("//div[7]//ul[4]/li/a/span"));
        haveYouSay.click();
        WebElement toShare = driver.findElement(By.xpath("/html/body/div[7]/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/a"));
        toShare.click();
        String expectedResult = driver.getCurrentUrl();
        WebElement nameField = driver.findElement(By.xpath("//*[@id=\"fullName\"]"));
        nameField.click();
        nameField.sendKeys("Nata");
        WebElement townField = driver.findElement(By.xpath("//*[@id=\"town\"]"));
        townField.click();
        townField.sendKeys("California");
        WebElement phoneField = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        phoneField.click();
        phoneField.sendKeys("3804412345678");
        WebElement messageField = driver.findElement(By.xpath("//*[@id=\"message\"]"));
        messageField.click();
        messageField.sendKeys(message100);
        Assert.assertNotEquals(driver.getCurrentUrl(), expectedResult, "The page is the same, you didn't sent your form");
    }

    @Test
    public void shareBbcFieldEmptyMessage() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bbc.com/");
        Actions action = new Actions(driver);
        WebElement newsButton = driver.findElement(By.xpath("/html/body/header/div/div[1]/nav/div/ul/li[2]/a"));
        action.moveToElement(newsButton);
        newsButton.click();
        System.out.println(driver.getTitle());
        WebElement moreDrop = driver.findElement(By.xpath("//div[2]//nav//span/button/span"));
        moreDrop.click();
        WebElement haveYouSay = driver.findElement(By.xpath("//div[7]//ul[4]/li/a/span"));
        haveYouSay.click();
        WebElement toShare = driver.findElement(By.xpath("/html/body/div[7]/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/a"));
        toShare.click();
        String expectedResult = driver.getCurrentUrl();
        WebElement nameField = driver.findElement(By.xpath("//*[@id=\"fullName\"]"));
        nameField.click();
        nameField.sendKeys("Nata");
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailField.click();
        emailField.sendKeys("Nata@gmail.com");
        WebElement townField = driver.findElement(By.xpath("//*[@id=\"town\"]"));
        townField.click();
        townField.sendKeys("California");
        WebElement phoneField = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        phoneField.click();
        phoneField.sendKeys("3804412345678");

        Assert.assertNotEquals(driver.getCurrentUrl(), expectedResult, "The page is the same, you didn't sent your form");
    }
}
