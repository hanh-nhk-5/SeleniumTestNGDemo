package hanh.example.tests;

import hanh.example.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {
    @Test(groups = {"smoke", "regression"})
    public void verifyAlertText(){
        String name = "Hanh hsl";
        landingPage.triggerAlert(name);
        String message = landingPage.getAlertMessage();
        Assert.assertEquals(message, buildAlertMessage(name));
        landingPage.acceptAlert();

        //just a demonstration how ExtentReports displays skipped tests.
        throw new SkipException("Skipped");

    }

    @Test void verifyConfirmMessage(){
        String name = "Hanh hsl";
        landingPage.triggerConfirmAlert(name);
        String message = landingPage.getAlertMessage();
        Assert.assertEquals(message, buildConfirmMessage(name));
        landingPage.acceptAlert();
    }

    String buildAlertMessage (String name){
        return "Hello " + name + ", share this practice page and share your knowledge";
    }

    String buildConfirmMessage (String name){
        return "Hello "+ name +", Are you sure you want to confirm?";
    }
}
