package org.example.appiumtest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.NavigationBarScreen;

import static org.testng.Assert.assertTrue;

public class LoginScreenTest extends BaseTest{

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
    public void successMsgOnCorrectLoginValues() throws InterruptedException {
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
    public void successMsgOnCorrectSignUpValues() throws InterruptedException {
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

    // defined collection of invalid emails here, TestNG DataPRovide pattern
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
    @Test(description = "Test to validate error on incorrect email during login",
    dataProvider = "invalidEmails")
    @Description("Validates error on incorrect email during login")
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

    @DataProvider(name = "invalidPasswords")
    public Object[][] invalidPasswordProvider() {
        return new Object[][] {
                { "1234567" },       // less than eight
                { "     " }      // empty spaces
        };
    }

    @Feature("LoginTab")
    @Story("LoginTab Interaction")
    @Test(description = "Test to validate error on incorrect password during login",
            dataProvider = "invalidPasswords")
    @Description("Validates error on incorrect password during login")
    public void errorOnIncorrectPasswordLogin(String invalidPassword) throws InterruptedException {
        LoginScreen loginScreen = new LoginScreen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();

        navigationBarScreen.openLoginScreen();
        loginScreen.setEmail("test@test.com");
        loginScreen.setPassword(invalidPassword);
        loginScreen.clickLogin();
        assertTrue(loginScreen.passwordErrorIsShown(),
                "Expected an error message to be visible for password: " + invalidPassword);
    }

    // SignUp tests

    @Feature("SignUpTab")
    @Story("SignUpTab Interaction")
    @Test(description = "Test to validate error on incorrect email during signUp",
            dataProvider = "invalidEmails")
    @Description("Validates error on incorrect email during signUp")
    public void errorOnIncorrectEmailSignUp(String invalidEmail) throws InterruptedException {
        LoginScreen loginScreen = new LoginScreen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();

        navigationBarScreen.openLoginScreen();
        loginScreen.clickOnSignUpTab();

        loginScreen.setEmail(invalidEmail);
        loginScreen.setPassword("12345678");
        loginScreen.setRepeatPassword();
        loginScreen.clickSignUp();
        assertTrue(loginScreen.emailErrorIsShown(),
                "Expected an error message to be visible for email: " + invalidEmail);
    }

    @Feature("SignUpTab")
    @Story("SignUpTab Interaction")
    @Test(description = "Test to validate error on incorrect password during sign up",
            dataProvider = "invalidPasswords")
    @Description("Validates error on incorrect password during sign up")
    public void errorOnIncorrectPasswordSignUp(String invalidPassword) throws InterruptedException {
        LoginScreen loginScreen = new LoginScreen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();

        navigationBarScreen.openLoginScreen();
        loginScreen.clickOnSignUpTab();

        loginScreen.setEmail("test@test.com");
        loginScreen.setPassword(invalidPassword);
        loginScreen.setRepeatPassword();
        loginScreen.clickSignUp();
        assertTrue(loginScreen.passwordErrorIsShown(),
                "Expected an error message to be visible for password: " + invalidPassword);
    }

    @Feature("SignUpTab")
    @Story("SignUpTab Interaction")
    @Test(description = "Test to validate error on incorrect repeated password during sign up",
            dataProvider = "invalidPasswords")
    @Description("Validates error on incorrect password during sign up")
    public void errorOnIncorrectRepeatPasswordSignUp(String invalidPassword) throws InterruptedException {
        LoginScreen loginScreen = new LoginScreen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();

        navigationBarScreen.openLoginScreen();
        loginScreen.clickOnSignUpTab();

        loginScreen.setEmail("test@test.com");
        loginScreen.setPassword("12345678");
        loginScreen.setCustomRepeatPassword(invalidPassword);
        loginScreen.clickSignUp();
        assertTrue(loginScreen.repeatPasswordErrorIsShown());
    }
}
