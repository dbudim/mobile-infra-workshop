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

public class AndroidHub implements WebDriverProvider {

    private static final String HUB_URL = "http://10.100.100.193:8080/wd/hub";
    private static final String APP_URL = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk";

    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        var capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("android");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("version", "10.0");
        capabilities.setCapability("skin", "1080x2280");
        capabilities.setCapability(NEW_COMMAND_TIMEOUT, 90);
        capabilities.setCapability(ORIENTATION, "PORTRAIT");
        capabilities.setCapability(AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability(APP, APP_URL);
        try {
            return new AndroidDriver(new URL(HUB_URL), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
