package org.example.appiumtest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MenuScreen;
import screens.NavigationBarScreen;

import static org.testng.Assert.assertTrue;

public class MenuScreenTest extends BaseTest{
    @Feature("MenuPanel")
    @Story("MenuPanel Interaction")
    @Test(description = "Test to validate Menu Panel contains expected elements")
    @Description("Validates Menu Panel contains expected elements")
    public void possibleToOpenMenuTabAndValidateAllEntriesAreShown() throws InterruptedException {
        MenuScreen menuScreen = new MenuScreen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();

        navigationBarScreen.openMenuTab();
        menuScreen.verifyMenuIsComplete();


    }

    // validate menu can be opened from other screens
    // validate menu entries can be highlighted with stars
    // validate permissions -> separate screen?
    // validate data menu Entry -> separate screen?
}
