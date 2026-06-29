package hanh.example.testComponents;

import hanh.example.pages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected LandingPage landingPage;

    @BeforeClass(alwaysRun = true)
    public void launchTheWebApp(){
        //Download the correct browser driver
        WebDriverManager.chromedriver().setup();

        DriverManager.setDriver(new ChromeDriver());
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();

        landingPage = new LandingPage(driver);
        landingPage.goTo();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
