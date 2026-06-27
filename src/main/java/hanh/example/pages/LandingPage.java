package hanh.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='checkbox-example']//input[@type='checkbox']")
    List<WebElement> checkboxes;

    @FindBy(xpath= "//select[@id='dropdown-class-example']")
    WebElement dropdown;

    @FindBy(id = "name")
    WebElement alertInput;

    @FindBy(id = "alertbtn")
    WebElement alertButton;

    @FindBy(id = "confirmbtn")
    WebElement confirmButton;

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    public void selectAllCheckboxes(){
        checkboxes.forEach(checkbox ->{
            if(!checkbox.isSelected())
                checkbox.click();
        });
    }

    public boolean isAllCheckboxesSelected(){
        for (WebElement checkbox: checkboxes){
            if(!checkbox.isSelected())
                return false;
        }
        return true;
    }

    public void selectIndexFromDropdown(int index){
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    public int getSelectedIndexFromDropdown(){
        Select select = new Select(dropdown);
        WebElement selectedOption = select.getFirstSelectedOption();
        return select.getOptions().indexOf(selectedOption);
    }

    public void triggerAlert(String name){
        alertInput.sendKeys(name);
        alertButton.click();
    }

    public void triggerConfirmAlert(String name){
        alertInput.sendKeys(name);
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

}


