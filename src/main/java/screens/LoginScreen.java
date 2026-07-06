package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen{

    @AndroidFindBy(accessibility = "button-login-container")
    WebElement loginTab;

    @AndroidFindBy(accessibility = "button-sign-up-container")
    WebElement signUpTab;

    @AndroidFindBy(accessibility = "input-email")
    WebElement email;

    @AndroidFindBy(accessibility = "input-password")
    WebElement password;

    @AndroidFindBy(accessibility = "input-repeat-password")
    WebElement confirmPassword;

    @AndroidFindBy(accessibility = "button-LOGIN")
    WebElement loginBtn;

    @AndroidFindBy(accessibility = "button-SIGN UP")
    WebElement signUpBtn;

    public boolean loginTabShown(){
        waitUntilElementIsVisible(loginTab);
        return loginTab.isDisplayed();
    }

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

}
