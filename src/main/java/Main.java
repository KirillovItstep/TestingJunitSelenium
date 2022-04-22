
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
        //https://chromedriver.storage.googleapis.com/index.html
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\vadim\\IdeaProjects\\TestingJunitSelenium\\src\\main\\resources\\chromedriver.exe");
                //"d:\\install\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        String proxyadd = "99.1.4844.51:1200";
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyadd);
        proxy.setSslProxy(proxyadd);
        chromeOptions.setCapability("proxy", proxy);
        WebDriver driver  = new ChromeDriver(chromeOptions);

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //driver.close();
    }
}
