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

    // validation that in email password and repeat password set stub text value
    //Login
    // enter invalid password
    // enter invalid values into login
    // enter expected format value into login and validate successful message

    // Sign up
    // when email format is incorrect
    // when password value incorrect
    // message when repeated password is invalid
    // successful sign up


    @Feature("LoginTab")
    @Story("LoginTab Interaction")
    @Test(description = "Test to validate login Tab contains expected elements")
    @Description("Validates login Tab contains expected elements")
    public void dragAndDropOnIncorrectSquare() throws InterruptedException {
        LoginScreen loginScreen = new LoginScreen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();


    }
}
