package emulators;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

/**
 * Created by dbudim on 25.06.2021
 */

public class IosHub implements WebDriverProvider {

    private static final String HUB_URL = "http://0.0.0.0:4723/wd/hub";
    private static final String APP_URL = "https://github.com/appium/appium/raw/master/sample-code/apps/TestApp.app.zip";

    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, "iOS");
        capabilities.setCapability(PLATFORM_VERSION, "14.5");
        capabilities.setCapability(DEVICE_NAME, "iPhone 12 Pro Max");
        capabilities.setCapability(NO_RESET, false);
        capabilities.setCapability(FULL_RESET, false);
        capabilities.setCapability(AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(CLEAR_SYSTEM_FILES, true);
        capabilities.setCapability(NEW_COMMAND_TIMEOUT, 90);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("keepKeyChains", false);
        capabilities.setCapability("sendKeyStrategy", "grouped");
        capabilities.setCapability(APP, APP_URL);
        try {
            return new IOSDriver<>(new URL(HUB_URL), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
