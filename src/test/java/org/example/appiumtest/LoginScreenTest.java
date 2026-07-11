package org.example.appiumtest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import screens.DragAndDropSceen;
import screens.LoginScreen;
import screens.NavigationBarScreen;

import static org.testng.Assert.assertFalse;
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
    public void possibleToMoveBetweenLoginSignUpTabs() throws InterruptedException {
        LoginScreen loginScreen = new LoginScreen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();

        navigationBarScreen.openLoginScreen();
        assertTrue(loginScreen.loginTabShown());
        loginScreen.clickOnSignUpTab();
        assertTrue(loginScreen.signUpTabShown());
        loginScreen.clickOnLoginTab();
        assertTrue(loginScreen.loginTabShown());

    }

    @Feature("LoginTab")
    @Story("LoginTab Interaction")
    @Test(description = "Test to validate login Tab contains expected elements")
    @Description("Validates login Tab contains expected elements")
    public void suceessMsgOnCorrectLoginValues() throws InterruptedException {
        LoginScreen loginScreen = new LoginScreen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();

        navigationBarScreen.openLoginScreen();
        loginScreen.setEmail("test@test.com");
        loginScreen.setPassword("12345678");
        loginScreen.clickLogin();
        assertTrue(loginScreen.successMsgIsShown());
    }

    @Feature("LoginTab")
    @Story("LoginTab Interaction")
    @Test(description = "Test to validate login Tab contains expected elements")
    @Description("Validates login Tab contains expected elements")
    public void sucessMsgOnCorrectSignUpalues() throws InterruptedException {
        LoginScreen loginScreen = new LoginScreen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();

        navigationBarScreen.openLoginScreen();
        loginScreen.clickOnSignUpTab();
        loginScreen.setEmail("test@test.com");
        loginScreen.setPassword("12345678");
        loginScreen.setRepeatPassword();
        loginScreen.clickSignUp();
        assertTrue(loginScreen.successMsgIsShown());
    }

    // defined collection of invalid emails here
    @DataProvider(name = "invalidEmails")
    public Object[][] invalidEmailProvider() {
        return new Object[][] {
                { "test@test." },       // Missing top-level domain
                { "plainaddress" },     // Missing @ and domain
                { "@missinguser.com" }, // Missing username
                { "test@test@test.com" },// Multiple @ signs
                { "test space@test.com" }// Contains invalid characters/spaces
        };
    }

    @Feature("LoginTab")
    @Story("LoginTab Interaction")
    @Test(description = "Test to validate login Tab contains expected elements",
    dataProvider = "invalidEmails")
    @Description("Validates login Tab contains expected elements")
    public void errorOnIncorrectEmailLogin(String invalidEmail) throws InterruptedException {
        LoginScreen loginScreen = new LoginScreen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();

        navigationBarScreen.openLoginScreen();
        loginScreen.setEmail(invalidEmail);
        loginScreen.setPassword("12345678");
        loginScreen.clickLogin();
        assertTrue(loginScreen.emailErrorIsShown(),
                "Expected an error message to be visible for email: " + invalidEmail);
    }
}
