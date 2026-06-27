package hanh.example.tests;

import hanh.example.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {

    @Test
    public void verifyAllCheckBoxesCanBeSelected(){
        landingPage.selectAllCheckboxes();
        boolean isSelected = landingPage.isAllCheckboxesSelected();
        Assert.assertTrue(isSelected);

    }
}
