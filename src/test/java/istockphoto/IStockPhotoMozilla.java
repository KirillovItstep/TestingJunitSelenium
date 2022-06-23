package istockphoto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IStockPhotoMozilla extends IStockPhotoChrome{
    @Test
    @Order(1)
    //Открыть стартовую страницу и проверить ее заголовок
    public void openBrowser() {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\vadim\\IdeaProjects\\TestingJunitSelenium\\src\\main\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        long start = System.currentTimeMillis();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Стоковые фотографии".toUpperCase()));
    }
}
