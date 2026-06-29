package hanh.example.tests;

import hanh.example.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameTest extends BaseTest {

    @Test (groups={"smoke"})
    public void verifyUserCanSwitchToIframeAndBack() {
        landingPage.switchToCoursesIframe();
        Assert.assertTrue(landingPage.isHomeMenuDisplayedInIframe());

        landingPage.switchToDefaultContent();
        Assert.assertTrue(landingPage.isAlertInputDisplayed());
    }
}
