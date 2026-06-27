package hanh.example.testComponents;

import hanh.example.pages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    WebDriver driver;
    protected LandingPage landingPage;

    @BeforeTest(alwaysRun = true)
    public void launchTheWebApp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        landingPage = new LandingPage(this.driver);
        landingPage.goTo();
    }
}
