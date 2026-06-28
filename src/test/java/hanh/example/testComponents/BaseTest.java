package hanh.example.testComponents;

import hanh.example.pages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    WebDriver driver;
    protected LandingPage landingPage;

    @BeforeClass(alwaysRun = true)
    public void launchTheWebApp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        landingPage = new LandingPage(this.driver);
        landingPage.goTo();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
