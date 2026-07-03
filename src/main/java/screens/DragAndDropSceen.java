package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DragAndDropSceen extends BaseScreen{

    @AndroidFindBy(accessibility = "Drag-drop-screen")
    WebElement dragNDropScreen;

    @AndroidFindBy(accessibility = "renew")
    WebElement refreshBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Congratulations']")
    WebElement congratsMsg;

    @AndroidFindBy(accessibility = "button-Retry")
    WebElement retryBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Drag and Drop']")
    WebElement dragAndDropTitle;

    public boolean greetingMessageShown(){
        waitUntilElementIsVisible(congratsMsg);
        return congratsMsg.isDisplayed();
    }

    public void tapOnRetry(){
        waitUntilElementIsClickable(retryBtn).click();
    }

    public boolean titleIsVisible(){
        waitUntilElementIsVisible(dragAndDropTitle);
      return dragAndDropTitle.isDisplayed();
    }

    List<WebElement> dragList = new ArrayList<>();
    List<WebElement> dropList = new ArrayList<>();

    public void runDragAndDropL(AppiumDriver driver, String sideChar) {
        // System.out.println(driver.getPageSource());
        int totalCount = 3; // l1, l2, l3
        // Clear lists first to prevent duplicating elements if the method is called multiple times
        dragList.clear();
        dropList.clear();

        // Use a 5-second explicit wait to prevent the NoSuchElementException
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Populate the lists based on Accessibility ID patterns
        for (int i = 1; i <= totalCount; i++) {
            dragList.add(driver.findElement(AppiumBy.accessibilityId("drag-" + sideChar + i)));
            dropList.add(driver.findElement(AppiumBy.accessibilityId("drop-" + sideChar + i)));
        }

        // Loop through the lists simultaneously by index to perform the action
        Actions actions = new Actions(driver);
        for (int i = 0; i < dragList.size(); i++) {
            // Use a 5-second explicit wait to prevent the NoSuchElementException
            new WebDriverWait(driver, Duration.ofSeconds(5));

            // 1. Get the boundary rectangles instead of raw locations
            Rectangle sourceRect = dragList.get(i).getRect();
            Rectangle targetRect = dropList.get(i).getRect();

            // 2. Calculate the exact center point (X + width/2, Y + height/2)
            int sourceCenterX = sourceRect.getX() + (sourceRect.getWidth() / 2);
            int sourceCenterY = sourceRect.getY() + (sourceRect.getHeight() / 2);

            int targetCenterX = targetRect.getX() + (targetRect.getWidth() / 2);
            int targetCenterY = targetRect.getY() + (targetRect.getHeight() / 2);

            // 3. Define the precise touch sequence
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence dragAndDrop = new Sequence(finger, 1);

            // Move to the exact center of the puzzle piece
            dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), sourceCenterX, sourceCenterY));

            // Press down firmly
            dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

            // Hold for 1 second so the app recognizes the pick-up state
            dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), sourceCenterX, sourceCenterY));

            // Glide smoothly and slowly to the exact center of the target square
            dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), targetCenterX, targetCenterY));

            // Hover over the target square for half a second to let the layout engine catch up
            dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), targetCenterX, targetCenterY));

            // Release the finger to drop the square
            dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            // Run the sequence
            driver.perform(Collections.singletonList(dragAndDrop));
            }
    }

    public void collectPuzzle() throws InterruptedException {
        runDragAndDropL(driver, "l");
        runDragAndDropL(driver, "c");
        runDragAndDropL(driver, "r");
    }
}

