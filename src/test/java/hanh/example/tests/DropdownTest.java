package hanh.example.tests;

import hanh.example.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {

    @Test
    public void verifyAnyDropdownOptionCanBeSelected() {
        landingPage.selectIndexFromDropdown(2);
        Assert.assertEquals(landingPage.getSelectedIndexFromDropdown(), 2);
    }
}
