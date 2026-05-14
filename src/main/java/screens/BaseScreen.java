package screens;

import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Collections;

public abstract class BaseScreen {
    AppiumDriver driver = DriverManager.getDriver();

    public BaseScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void actionSwipe(Point from, Point to){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1); // list of actions performed by finger
        // FROM
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), from));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        // PAUSE
         swipe.addAction(new Pause(finger, Duration.ofMillis(200)));
        // TO
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), to));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public void click(WebElement element) {
        element.click();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    protected WebDriverWait waitTimeout(){
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitUntilElementIsClickable(WebElement element){
        return waitTimeout().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitUntilElementIsVisible(WebElement element){
        return waitTimeout().until(ExpectedConditions.visibilityOf(element));
    }
}
