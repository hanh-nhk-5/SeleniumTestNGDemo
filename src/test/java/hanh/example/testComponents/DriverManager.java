package hanh.example.testComponents;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver webdriver){
        driver.set(webdriver);
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }
}
