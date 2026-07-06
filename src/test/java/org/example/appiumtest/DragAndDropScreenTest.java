package org.example.appiumtest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import screens.DragAndDropSceen;
import screens.NavigationBarScreen;
import static org.testng.Assert.assertTrue;

public class DragAndDropScreenTest extends BaseTest {

    @Feature("DragAndDrop")
    @Story("DragAndDrop Interaction")
    @Test(description = "Test to validate drag and drop on incorrect square on screen")
    @Description("Validates drag and drop on incorrect square on screen")
    public void dragAndDropOnIncorrectSquare() throws InterruptedException {
        DragAndDropSceen dragAndDropScreen = new DragAndDropSceen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();
        navigationBarScreen.openDragScreen();

        // validate tab is selected
        navigationBarScreen.isDragAndDropTabSelected();
        dragAndDropScreen.collectPuzzle();
        assertTrue(dragAndDropScreen.greetingMessageShown());

    }

    @Test(description = "Test to validate congratulation view is shown when puzzled correctly")
    @Description("Validates congratulation view is shown when puzzled correctly")
    public void congratulationViewIsShownWhenPuzzledCorrectly() throws InterruptedException {
        DragAndDropSceen dragAndDropScreen = new DragAndDropSceen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();
        navigationBarScreen.openDragScreen();

        // validate tab is selected
        navigationBarScreen.isDragAndDropTabSelected();
        dragAndDropScreen.collectPuzzle();
        assertTrue(dragAndDropScreen.greetingMessageShown());

    }

    @Test(description = "Test to validate possibility to reset puzzle when not fully collected")
    @Description("Validates possibility to reset puzzle when not fully collected")
    public void resetWhenNotFullyCollected() throws InterruptedException {
        DragAndDropSceen dragAndDropScreen = new DragAndDropSceen();
        NavigationBarScreen navigationBarScreen = new NavigationBarScreen();
        navigationBarScreen.openDragScreen();

        // validate tab is selected
        navigationBarScreen.isDragAndDropTabSelected();
        dragAndDropScreen.collectPuzzle();
        dragAndDropScreen.tapOnRetry();
        assertTrue(dragAndDropScreen.titleIsVisible());

    }
}
