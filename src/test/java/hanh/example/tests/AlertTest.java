package hanh.example.tests;

import hanh.example.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {
    @Test
    public void verifyAlertText(){
        String name = "Hanh hsl";
        landingPage.triggerAlert(name);
        String message = landingPage.getAlertMessage();
        Assert.assertEquals(message, buildAlertMessage(name));
        landingPage.acceptAlert();

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
