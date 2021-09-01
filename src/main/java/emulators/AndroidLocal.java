package emulators;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.*;

/**
 * Created by dbudim on 25.06.2021
 */

public class AndroidLocal implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("android");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("version", "10.0");
        capabilities.setCapability("skin", "1080x2280");
        capabilities.setCapability("uiautomator2ServerInstallTimeout", 90000);
        capabilities.setCapability(NEW_COMMAND_TIMEOUT, 90);
        capabilities.setCapability(NO_RESET, false);
        capabilities.setCapability(FULL_RESET, false);
        capabilities.setCapability(ORIENTATION, "PORTRAIT");
        capabilities.setCapability(AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability(APP, "https://github.com/cloudgrey-io/the-app/releases/download/v1.10.0/TheApp-v1.10.0.apk");
        try {
            return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
