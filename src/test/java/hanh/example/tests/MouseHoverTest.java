package hanh.example.tests;

import hanh.example.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseHoverTest extends BaseTest{
    @Test
    public void verifyMouseHoverMenuDisplayed(){
        landingPage.hoverOnMouseHoverButton();
        Assert.assertTrue(landingPage.isMouseHoverMenuDisplayed());
    }

    @Test(description = "MH-04: Reload option action")
    public void verifyReloadOptionReloadsPage(){
        landingPage.clickReloadOptionOfMouseHoverButton();
        Assert.assertTrue(landingPage.isPageReloaded());
    }

}
