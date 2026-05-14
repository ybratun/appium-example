package org.example.appiumtest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import screens.FormsTabScreen;
import org.testng.annotations.Test;
import screens.NavigationBarScreen;
import java.util.Arrays;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FormsTabScreenTest extends BaseTest {

    @Feature("Forms")
    @Story("Forms Tab Interaction")
    @Test (description = "Test to validate Forms tab elements functionality")
    @Description("Validates input field, toggle, and dropdown in Forms tab")
    public void formsTabSelectionTest() {
        FormsTabScreen formsTabScreen = new FormsTabScreen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();

        navigationBarScreen.openFormsScreen();

        // validate tab is selected
        assertTrue(navigationBarScreen.isFormsTabSelected());

        // validate input field can be prepopulated and value set is shown at the label below
        formsTabScreen.typeFormFieldValue("Hello Appium Test!!!");
        assertEquals(formsTabScreen.getTypedValueText(), "Hello Appium Test!!!");

        // validate toggle can be turned on/off and label below changes its status
        assertEquals(formsTabScreen.getToggleStatusText(),"Click to turn the switch ON");
        formsTabScreen.tapOnToggle(); // turn toggle ON
        assertEquals(formsTabScreen.getToggleStatusText(),"Click to turn the switch OFF");
        formsTabScreen.tapOnToggle(); // turn toggle OFF
        assertEquals(formsTabScreen.getToggleStatusText(),"Click to turn the switch ON");

        // validate drop down value selection
        List<String> expectedValues = Arrays.asList("Select an item...",
                "webdriver.io is awesome",
                "Appium is awesome",
                "This app is awesome");
        assertEquals(expectedValues, formsTabScreen.getActualDropDownValues());
    }
}
