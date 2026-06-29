package hanh.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver){
        super(driver);
    }

    By checkboxLocators = By.xpath("//div[@id='checkbox-example']//input[@type='checkbox']");
    By dropdownLocator = By.id("dropdown-class-example");
    By alertInputLocator = By.id("name");
    By alertButtonLocator = By.id("alertbtn");
    By confirmButtonLocator = By.id("confirmbtn");
    By iframeLocator = By.id("courses-iframe");
    By iframeHomeMenuLocator = By.xpath("//a[normalize-space()='Home']");

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    public void selectAllCheckboxes(){
        List<WebElement> checkboxes = driver.findElements(checkboxLocators);
        checkboxes.forEach(checkbox ->{
            if(!checkbox.isSelected())
                checkbox.click();
        });
    }

    public boolean isAllCheckboxesSelected(){
        List<WebElement> checkboxes = driver.findElements(checkboxLocators);
        for (WebElement checkbox: checkboxes){
            if(!checkbox.isSelected())
                return false;
        }
        return true;
    }

    public void selectIndexFromDropdown(int index){
        WebElement dropdown = driver.findElement(dropdownLocator);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    public int getSelectedIndexFromDropdown(){
        WebElement dropdown = driver.findElement(dropdownLocator);
        Select select = new Select(dropdown);
        WebElement selectedOption = select.getFirstSelectedOption();
        return select.getOptions().indexOf(selectedOption);
    }

    public void triggerAlert(String name){
        WebElement alertInput = driver.findElement(alertInputLocator);
        alertInput.sendKeys(name);
        WebElement alertButton = driver.findElement(alertButtonLocator);
        alertButton.click();
    }

    public void triggerConfirmAlert(String name){
        WebElement alertInput = driver.findElement(alertInputLocator);
        alertInput.sendKeys(name);
        WebElement confirmButton = driver.findElement(confirmButtonLocator);
        confirmButton.click();
    }

    public String getAlertMessage(){
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void switchToCoursesIframe(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
    }

    public boolean isHomeMenuDisplayedInIframe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(iframeHomeMenuLocator)).isDisplayed();
    }


    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public boolean isAlertInputDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(alertInputLocator)).isDisplayed();
    }

}

