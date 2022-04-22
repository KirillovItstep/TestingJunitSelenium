import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleTest {
    private static WebDriver driver = null;
    private static long totalTime = 0;

    @BeforeClass
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\vadim\\IdeaProjects\\TestingJunitSelenium\\src\\main\\resources\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        String proxyadd = "99.0.4844.51:1200";
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyadd);
        proxy.setSslProxy(proxyadd);
        chromeOptions.setCapability("proxy", proxy);
        driver = new ChromeDriver(chromeOptions);
        long start = System.currentTimeMillis();
        driver.get("https://www.google.com/");
        long finish = System.currentTimeMillis();
        totalTime = finish - start;
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void closeBrowser() {
        //driver.close();
    }

    @Test
    public void pageLoad() {
        //System.out.println(totalTime);
        Assertions.assertTrue(totalTime < 5000, "Total time is " + totalTime + "ms should be less than 5 s");
    }

    @Test
    public void getTitle() {
        Assertions.assertEquals("Google", driver.getTitle());
    }

    @Test
    //Ввести текст в поле ввода и нажать кнопку "Поиск в Google";
    public void setText() {
        String code = "Text";
        WebElement input = driver.findElement(By.xpath("//input[@title='Поиск']"));
        input.sendKeys(code);
        input.sendKeys(Keys.ESCAPE);
        input.sendKeys(Keys.ENTER);
        //Проверить, произошел ли поиск
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.google.com/search?q="));
    }
}
