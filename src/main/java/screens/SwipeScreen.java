package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SwipeScreen extends BaseScreen{
    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id, '__CAROUSEL_ITEM_')]")
    private List<WebElement> carouselItems;

    @AndroidFindBy (xpath = "//android.widget.ImageView[@content-desc='WebdriverIO logo']")
    public WebElement androidLogo;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='You found me!!!']")
    WebElement androidLogoText;

    // returns the resource-id of whichever carousel item is currently visible
    public String getVisibleCarouselItemId() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(d ->
                carouselItems.stream()
                        .filter(el -> { try { return el.isDisplayed(); } catch (Exception e) { return false; } })
                        .map(el -> el.getAttribute("resource-id"))
                        .findFirst()
                        .orElse(null)
        );
    }

    // assert currently visible carousel item is actually displayed
    public boolean isCurrentCarouselItemDisplayed() {
        return carouselItems.stream()
                .anyMatch(el -> { try { return el.isDisplayed(); } catch (Exception e) { return false; } });
    }

    public void swipeRightLeftHorizontal(){
        Dimension size = driver.manage().window().getSize();
        int width = size.getWidth();
        int height = size.getHeight();
        Point start = new Point((int)(width * 0.8), (int)(height * 0.8));
        Point end = new Point((int)(width * 0.2),  (int)(height * 0.8));
        actionSwipe(start, end);
    }

    public void swipeVertical(){
        Dimension size = driver.manage().window().getSize();
        int width = size.getWidth();
        int height = size.getHeight();
        Point start = new Point(width / 2, (int)(height * 0.85));
        Point end = new Point(width / 2, (int)(height * 0.2));
        actionSwipe(start, end);
    }

    public boolean isLogoTextIsNotEmpty(){
        String text = androidLogoText.getText();
        // added validation that empty won't pass
        return (text != null && !text.trim().isEmpty());
    }

    public boolean isAndroidLogoDisplayed(){
        return androidLogo.isDisplayed();
    }
}