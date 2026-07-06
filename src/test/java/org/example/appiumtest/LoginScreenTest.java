package org.example.appiumtest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import screens.DragAndDropSceen;
import screens.LoginScreen;
import screens.NavigationBarScreen;

import static org.testng.Assert.assertTrue;

public class LoginScreenTest extends BaseTest{

    @Feature("LoginTab")
    @Story("LoginTab Interaction")
    @Test(description = "Test to validate login Tab contains expected elements")
    @Description("Validates login Tab contains expected elements")
    public void dragAndDropOnIncorrectSquare() throws InterruptedException {
        LoginScreen loginScreen = new LoginScreen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();


    }
}
