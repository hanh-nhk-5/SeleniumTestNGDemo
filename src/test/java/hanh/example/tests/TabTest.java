package hanh.example.tests;

import hanh.example.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TabTest extends BaseTest {
    @Test(alwaysRun = true)
    public void verifyTabOpen(){
        String currentWindowUrl = landingPage.getCurrentWindowUrl();
        landingPage.openTab();
        Assert.assertTrue(landingPage.getCurrentWindowUrl().contains("qaclickacademy.com/lander"));
        landingPage.closeTabAndSwitchToWindow(currentWindowUrl);
    }
}
