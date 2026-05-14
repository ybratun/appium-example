package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationBarScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Forms']")
    WebElement formsTab;

    @AndroidFindBy (xpath = "//android.view.View[@content-desc='Swipe']")
    WebElement swipeTab;

    @AndroidFindBy (xpath = "//android.view.View[@content-desc='Drag']")
    WebElement dragTab;

    public void openFormsScreen()  {
        waitUntilElementIsClickable(formsTab);
        click(formsTab);
    }

    public boolean isFormsTabSelected(){
        return formsTab.isSelected();
    }
    public void openSwipeScreen()  {
        waitUntilElementIsClickable(swipeTab);
        click(swipeTab);
    }

    public void openDragScreen()  {
        waitUntilElementIsClickable(dragTab);
        click(dragTab);
    }
}
