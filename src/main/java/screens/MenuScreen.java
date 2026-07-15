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

    @AndroidFindBy(accessibility = "tab-side-menu-panel")
    WebElement tabPanel;

    public boolean elementIsDisplayed(WebElement element) {
        waitUntilElementIsVisible(element);
        return element.isDisplayed();
    }

    public boolean sidePanelIsDisplayed(){
        waitUntilElementIsVisible(tabPanel);
        return elementIsDisplayed(tabPanel);
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

    public void clickwebViewMenuEntry (){
        waitUntilElementIsVisible(webViewMenuEntry);
        webViewMenuEntry.click();
    }
    public void clickloginMenuEntry (){
        waitUntilElementIsVisible(loginMenuEntry);
        loginMenuEntry.click();
    }
    public void clickformsMenuEntry (){
        waitUntilElementIsVisible(formsMenuEntry);
        formsMenuEntry.click();
    }
    public void clickswipeMenuEntry (){
        waitUntilElementIsVisible(swipeMenuEntry);
        swipeMenuEntry.click();
    }
    public void clickdragMenuEntry (){
        waitUntilElementIsVisible(dragMenuEntry);
        dragMenuEntry.click();
    }
    public void clickpermissionsMenuEntry (){
        waitUntilElementIsVisible(permissionsMenuEntry);
        permissionsMenuEntry.click();
    }
    public void clickdataMenuEntry (){
        waitUntilElementIsVisible(dataMenuEntry);
        dataMenuEntry.click();
    }

}
