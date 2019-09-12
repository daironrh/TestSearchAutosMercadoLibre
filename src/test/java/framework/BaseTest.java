package framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import po.PaginaInicioMercadoLibre;

public class BaseTest {

    protected WebDriver driver;
    protected String baseUrl = "https://www.mercadolibre.com.uy/";
    protected PaginaInicioMercadoLibre inicio;

    @BeforeTest
    public void setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        inicio = new PaginaInicioMercadoLibre(driver);
    }

    @AfterTest
    public void tearDown(){
        if (driver != null)
            driver.quit();
    }
}
