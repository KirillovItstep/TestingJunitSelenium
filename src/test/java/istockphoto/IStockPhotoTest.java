package istockphoto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IStockPhotoTest {
    private static WebDriver driver = null;
    private static final String baseUrl = "https://www.istockphoto.com/ru/";

    @Test
    @Order(1)
    //Открыть стартовую страницу и проверить ее заголовок
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\vadim\\IdeaProjects\\TestingJunitSelenium\\src\\main\\resources\\chromedriver.exe");
        /*
        ChromeOptions chromeOptions = new ChromeOptions();
        String proxyadd = "99.0.4844.51:1200";
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyadd);
        proxy.setSslProxy(proxyadd);
        chromeOptions.setCapability("proxy", proxy);
         driver = new ChromeDriver(chromeOptions);
         */
        driver = new ChromeDriver();
        long start = System.currentTimeMillis();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Стоковые фотографии".toUpperCase()));
    }

    @Test
    @Order(2)
    //Выбрать в top navigation пункт "Архитектура"
    public void getArchitecture() {
        //driver.get(baseUrl+"стоковое-видео/архитектура");
        //List<WebElement> links = driver.findElements(By.xpath("//ul[@id='popular_categories']/li[1]/a[contains(string(),'Архитектура')]"));
        //links.get(0).click();
    }

    @Test
    @Order(3)
    @Disabled
    //Нажать на ссылку "Присоединиться"
    public void join() {
        driver.get(baseUrl+"join");
    }

    @Test
    @Order(4)
    @Disabled
    //Ввести учетные данные
    public void register() {
        WebElement email = driver.findElement(By.xpath("//*[@id='register_email']"));
        email.sendKeys("kirillov203509@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@id='register_password']"));
        password.sendKeys("Hst121121");
        WebElement password_confirmation = driver.findElement(By.xpath("//*[@id='register_password_confirmation']"));
        password_confirmation.sendKeys("Hst121121");
        WebElement checkbox = driver.findElement(By.xpath("//*[@id='checkbox']"));
        checkbox.click();
        Select countries = new Select(driver.findElement(By.xpath("//*[@id='register_country_code']")));
        countries.selectByVisibleText("Российская Федерация");
        WebElement button = driver.findElement(By.xpath("//*[@id='register-button']"));
        button.click();
    }

    @Test
    @Order(5)
    @Disabled
    //Выйти
    public void signout() {
        driver.get(baseUrl+"sign-out");
    }

    @Test
    @Order(6)
    //Войти заново
    public void signin() {
        driver.get(baseUrl+"sign-in");
    }

    @Test
    @Order(7)
    //Ввести данные
    public void input() {
        WebElement email = driver.findElement(By.xpath("//*[@id='new_session_username']"));
        email.sendKeys("kirillov203509@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@id='new_session_password']"));
        password.sendKeys("Hst121121");
        WebElement button = driver.findElement(By.xpath("//*[@id='sign_in']"));
        button.click();
    }
}
