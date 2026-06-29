package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropSceen extends BaseScreen{

    @AndroidFindBy(accessibility = "Drag-drop-screen")
    WebElement dragNDropScreen;

    @AndroidFindBy(accessibility = "renew")
    WebElement refreshBtn;

    @AndroidFindBy(accessibility = "drop-l1")
    WebElement cell11;

    @AndroidFindBy(accessibility = "drop-c1")
    WebElement cell12;

    @AndroidFindBy(accessibility = "drop-r1")
    WebElement cell13;

    @AndroidFindBy(accessibility = "drop-l2")
    WebElement cell21;

    @AndroidFindBy(accessibility = "drop-c2")
    WebElement cell22;

    @AndroidFindBy(accessibility = "drop-r2")
    WebElement cell23;

    @AndroidFindBy(accessibility = "drop-l3")
    WebElement cell31;

    @AndroidFindBy(accessibility = "drop-c3")
    WebElement cell32;

    @AndroidFindBy(accessibility = "drop-r3")
    WebElement cell33;

    @AndroidFindBy(accessibility = "drag-l1")
    WebElement part11;

    @AndroidFindBy(accessibility = "drag-c1")
    WebElement part12;

    @AndroidFindBy(accessibility = "drag-r1")
    WebElement part13;

    @AndroidFindBy(accessibility = "drag-l2")
    WebElement part21;

    @AndroidFindBy(accessibility = "drag-c2")
    WebElement part22;

    @AndroidFindBy(accessibility = "drag-r2")
    WebElement part23;

    @AndroidFindBy(accessibility = "drag-l3")
    WebElement part31;

    @AndroidFindBy(accessibility = "drag-c3")
    WebElement part32;

    @AndroidFindBy(accessibility = "drag-r3")
    WebElement part33;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Congratulations']")
    WebElement congratsMsg;

    @AndroidFindBy(accessibility = "button-Retry")
    WebElement retryBtn;

    public void dragAndDropElement(WebElement sourceElement, WebElement targetElement) {
        // Instantiate the Actions class
        Actions actions = new Actions(driver);

        // Perform the drag and drop sequence
        //actions.dragAndDrop(sourceElement, targetElement).perform();

        actions.clickAndHold(sourceElement)
                .moveToElement(targetElement)
                .release(targetElement)
                .build()
                .perform();
    }

    public boolean greetingMessageShown(){
        waitUntilElementIsVisible(congratsMsg);
        return congratsMsg.isDisplayed();
    }

    public void tapOnRetry(){
        waitUntilElementIsClickable(retryBtn).click();
    }
}

