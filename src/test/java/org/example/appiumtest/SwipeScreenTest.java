package org.example.appiumtest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import screens.NavigationBarScreen;
import screens.SwipeScreen;
import static org.testng.Assert.assertTrue;

public class SwipeScreenTest extends BaseTest{

    @Feature("Swipe")
    @Story("Swipe Tab Interaction")
    @Test(description = "Test to validate Swipe tab elements functionality")
    @Description("Validates horizontal swipe through carousel items and vertical swipe to reveal hidden elements in Swipe tab")
    public void swipeTabTest() {
        SwipeScreen swipeScreen = new SwipeScreen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();
        navigationBarScreen.openSwipeScreen();

        // swipe until the carousel stops
        String previousItemId = null;
        String currentItemId  = swipeScreen.getVisibleCarouselItemId();

        do {
            assertTrue(swipeScreen.isCurrentCarouselItemDisplayed(),
                    "Carousel item [" + currentItemId + "] should be visible");

            swipeScreen.swipeRightLeftHorizontal();

            previousItemId = currentItemId;
            currentItemId  = swipeScreen.getVisibleCarouselItemId();

        } while (!currentItemId.equals(previousItemId)); // end of carousel when same elementId shown

        swipeScreen.swipeVertical();
        assertTrue(swipeScreen.isAndroidLogoDisplayed(), "Android logo is not displayed");
        assertTrue(swipeScreen.isLogoTextIsNotEmpty(),  "Logo text is empty");
    }
}
