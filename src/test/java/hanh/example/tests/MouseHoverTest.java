package hanh.example.tests;

import hanh.example.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseHoverTest extends BaseTest{
    @Test (groups="regression")
    public void verifyMouseHoverMenuDisplayed(){
        landingPage.hoverOnMouseHoverButton();
        Assert.assertTrue(landingPage.isMouseHoverMenuDisplayed());
    }

    @Test(description = "MH-04: Reload option action", retryAnalyzer =  hanh.example.utils.Retry.class, groups = {"smoke"})
    public void verifyReloadOptionReloadsPage(){
        landingPage.clickReloadOptionOfMouseHoverButton();
        Assert.assertFalse(landingPage.isPageReloaded()); //force to fail to retry
    }

}
