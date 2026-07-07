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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please enter a valid email address']")
    WebElement invalidEmailMsg;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please enter at least 8 characters']")
    WebElement invalidPasswordMsg;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please enter the same password']")
    WebElement invalidPasswordRepeat;

    @AndroidFindBy(accessibility = "button-SIGN UP")
    WebElement successfulDialogLayout;

    @AndroidFindBy(id = "android:id/button1")
    WebElement okBtnOnSuccessMsg;

    @AndroidFindBy(id = "android:id/message") // Login -> "You are logged in!"     SignUp -> "You successfully signed up!"
    WebElement successfulnMsgText;

    public boolean loginTabShown(){
        waitUntilElementIsVisible(loginTab);
        return loginTab.isDisplayed();
    }

    public boolean signUpTabShown(){
        waitUntilElementIsVisible(signUpTab);
        return signUpTab.isDisplayed();
    }

    public void setEmail(String inputEmail) {
        email.click();
        email.clear();  // if won't work try: element.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.BACK_SPACE);
        email.sendKeys(inputEmail);
    }

    String passwordValue;
    public void setPassword(String inputPassword) {
        password.click();
        password.clear();
        passwordValue = inputPassword;
        password.sendKeys(inputPassword);
    }

    public void repeatPassword(){
        confirmPassword.click();
        password.clear();
        confirmPassword.sendKeys(passwordValue);
    }

    public void clickLogin(){
        loginBtn.click();
    }
    public void clickSignUp(){
        signUpBtn.click();
    }


}
