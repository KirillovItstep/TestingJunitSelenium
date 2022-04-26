
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GithubTest {
    private static WebDriver driver = null;
    private static final String baseUrl = "https://www.github.com/";

    @Test
    @Order(1) //Проблема была в том, что аннотация @Test была импортирована для Junit 4
    public void openBrowser() {
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
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @Test
    @Order(2)
    public void getTitle() {
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Github".toUpperCase()));
    }

    @Test
    @Order(3)
    //Переход по ссылке
    public void gotoLink() {
        driver.get(baseUrl+"login");
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("sign in".toUpperCase()));
    }

    @Test
    @Order(4)
    //Ввести имя пользователя и пароль, нажать кнопку "Sign in"
    public void signIn() {
        WebElement input = driver.findElement(By.id("login_field"));
        input.sendKeys("KirillovItStep");
        input = driver.findElement(By.id("password"));
        input.sendKeys("Hft64627");
        WebElement button = driver.findElement(By.xpath("//input[@name='commit']"));
        button.click();
        //Найти элемент
        boolean exists;
        try {
            driver.findElement(By.xpath("//img[@alt='@KirillovItstep']"));
            exists = true;
        } catch (NoSuchElementException e) {
            exists = false;
        }
        Assertions.assertTrue(exists);
    }

    @Test
    @Order(5)
    //Sign out
    public void signOut() {
        driver.get(baseUrl+"logout");
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("sign out".toUpperCase()));
        WebElement button = driver.findElement(By.xpath("//input[@value='Sign out']"));
        button.click();
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("GitHub".toUpperCase()));
    }

    @Test
    @Order(6)
    //Close browser
    public  void closeBrowser() {
        driver.close();
    }
}
