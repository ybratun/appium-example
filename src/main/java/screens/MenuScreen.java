package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MenuScreen extends BaseScreen{

    @AndroidFindBy(accessibility = "side-menu-item-home")
    WebElement homeMenuEntry;

    @AndroidFindBy(accessibility = "side-menu-item-webview")
    WebElement webViewMenuEntry;

    @AndroidFindBy(accessibility = "side-menu-item-login")
    WebElement loginMenuEntry;

    @AndroidFindBy(accessibility = "side-menu-item-forms")
    WebElement formsMenuEntry;

    @AndroidFindBy(accessibility = "side-menu-item-swipe")
    WebElement swipeMenuEntry;

    @AndroidFindBy(accessibility = "side-menu-item-drag")
    WebElement dragMenuEntry;

    @AndroidFindBy(accessibility = "side-menu-item-permissions")
    WebElement permissionsMenuEntry;

    @AndroidFindBy(accessibility = "side-menu-item-data-management")
    WebElement dataMenuEntry;

    public boolean elementIsDisplayed(WebElement element) {
        waitUntilElementIsVisible(element);
        return element.isDisplayed();
    }

    public void assertAllElementsAreShown(WebElement... elements) {

        for (WebElement element : elements) {
            try {
                waitUntilElementIsVisible(element);

                // Extra safety assertion
                elementIsDisplayed(element);
            } catch (Exception e) {
                // Throws a clear assertion failure showing which element failed
                throw new AssertionError("Validation failed! Element is not shown: "
                        + element.toString(), e);
            }
        }
    }

    public void verifyMenuIsComplete() {

        assertAllElementsAreShown(
                homeMenuEntry,
                webViewMenuEntry,
                loginMenuEntry,
                formsMenuEntry,
                swipeMenuEntry,
                dragMenuEntry,
                permissionsMenuEntry,
                dataMenuEntry

        );
    }

}
