package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.lang.ThreadLocal;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static void initDriver() throws MalformedURLException {
        String appPath = Paths.get(System.getProperty("user.dir"),"src","test","resources","android.wdio.native.app.v2.0.0.apk").toString();

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:appPackage", "com.wdiodemoapp");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:app", appPath);
        caps.setCapability("appium:fullReset", true);

        AppiumDriver drv = new AndroidDriver( new URL("http://127.0.0.1:4723"), caps);
        driver.set(drv);
    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get()!=null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
