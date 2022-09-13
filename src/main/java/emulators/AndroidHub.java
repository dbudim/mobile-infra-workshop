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

    private static final String SELENOID_URL = "http://192.168.0.111:4444/wd/hub";
    private static final String GGR_URL = "http://aqa:123456@192.168.0.111:4445/wd/hub";
    private static final String APP_URL = "https://github.com/wikipedia-qa/wikipedia-selenide/raw/master/mobile/src/test/resources/apks/org.wikipedia.apk";

    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        var capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("Android");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("version", "10.0");
        capabilities.setCapability(NEW_COMMAND_TIMEOUT, 90);
        capabilities.setCapability("uiautomator2ServerInstallTimeout", 90000);
        capabilities.setCapability(ORIENTATION, "PORTRAIT");
        capabilities.setCapability(AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", APP_URL);
        try {
            return new AndroidDriver(new URL(SELENOID_URL), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
