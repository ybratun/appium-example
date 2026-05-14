package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.SequencedCollection;
import java.util.stream.Collectors;

public class FormsTabScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='text-input']")
    WebElement formsInputField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='input-text-result']")
    WebElement formsTypedValue;

    @AndroidFindBy(accessibility = "switch")
    WebElement formsToggle;

    // by text "Click to turn the switch OFF" or ON
    @AndroidFindBy(accessibility = "switch-text")
    WebElement formsToggleStatusString;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='text_input']")
    WebElement formsDropDownField;

    @AndroidFindBy(xpath = "//android.widget.ListView[@resource-id='com.wdiodemoapp:id/select_dialog_listview']")
    WebElement formsDropDown;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1']")
    private List<WebElement> formsDropDownValues;

    public String getTypedValueText() {
        return getText(formsTypedValue);
    }

    public void typeFormFieldValue(String inputTextValue){
        waitUntilElementIsClickable(formsInputField).click();
        formsInputField.sendKeys(inputTextValue);
        formsTypedValue.click();
    }

    public void tapOnToggle() {
        waitUntilElementIsClickable(formsToggle).click();
    }

    public String getToggleStatusText() {
        return getText(formsToggleStatusString);
    }

    public List<String> getActualDropDownValues() {
        waitUntilElementIsVisible(formsDropDownField).click();
        waitUntilElementIsVisible(formsDropDown);
        List<String> actualValues = formsDropDownValues.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return actualValues;
    }
}
