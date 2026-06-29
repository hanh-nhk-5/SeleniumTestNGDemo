package hanh.example.tests;

import hanh.example.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TabTest extends BaseTest {
    @Test
    public void verifyTabOpen(){
        String currentWindowUrl = landingPage.getCurrentWindowUrl();
        landingPage.openTab();
        Assert.assertTrue(landingPage.getCurrentWindowUrl().contains("www.qaclickacademy.com"));
        landingPage.closeTabAndSwitchToWindow(currentWindowUrl);
    }
}
