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

    @AndroidFindBy(id = "com.wdiodemoapp:id/parentPanel")
    WebElement successfulDialogLayout;

    @AndroidFindBy(id = "android:id/button1")
    WebElement okBtnOnSuccessDialog;

    @AndroidFindBy(id = "android:id/message") // Login -> "You are logged in!"     SignUp -> "You successfully signed up!"
    WebElement successfulnMsgText;

    public boolean loginTabShown(){
        waitUntilElementIsVisible(loginTab);
        return  loginTab.isDisplayed();
    }

    public boolean signUpTabShown(){
        waitUntilElementIsVisible(signUpTab);
        return confirmPassword.isDisplayed();
    }

    public boolean repeatPasswordIsShown(){
        waitUntilElementIsVisible(confirmPassword);
        return confirmPassword.isDisplayed();
    }

    public void clickOnLoginTab(){
        loginTab.click();
    }

    public void clickOnSignUpTab(){
        signUpTab.click();
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

    public void setRepeatPassword(){
        confirmPassword.click();
        confirmPassword.clear();
        confirmPassword.sendKeys(passwordValue);
    }

    public void setCustomRepeatPassword(String inputRepeatPassword){
        confirmPassword.click();
        confirmPassword.clear();
        confirmPassword.sendKeys(inputRepeatPassword);
    }

    public void clickLogin(){
        waitUntilElementIsVisible(loginBtn);
        loginBtn.click();
    }
    public void clickSignUp(){
        signUpBtn.click();
    }

    public boolean successMsgIsShown() throws InterruptedException {
        Thread.sleep(3000);
        waitUntilElementIsVisible(successfulDialogLayout);
        return successfulDialogLayout.isDisplayed();
    }

    public boolean emailErrorIsShown(){
        waitUntilElementIsVisible(invalidEmailMsg);
        return invalidEmailMsg.isDisplayed();
    }

    public boolean passwordErrorIsShown(){
        waitUntilElementIsVisible(invalidPasswordMsg);
        return invalidPasswordMsg.isDisplayed();
    }

    public boolean repeatPasswordErrorIsShown(){
        waitUntilElementIsVisible(invalidPasswordRepeat);
        return invalidPasswordRepeat.isDisplayed();
    }

    public void clickOkOnDialog(){
        okBtnOnSuccessDialog.click();
    }

    public String getialogText(){
        String actualText = successfulnMsgText.getText();
        return actualText;
    }


}
