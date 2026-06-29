package hanh.example.tests;

import hanh.example.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TableTest extends BaseTest {
    @Test
    public void verifyInstructors(){
        Assert.assertTrue(landingPage.isInstructor("Rahul Shetty"));
        Assert.assertFalse(landingPage.isInstructor("Hanh Nguyen"));
    }
}
