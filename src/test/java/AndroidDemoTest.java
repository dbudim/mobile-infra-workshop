import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.util.concurrent.Uninterruptibles;
import emulators.AndroidHub;
import emulators.AndroidLocal;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.appium.java_client.MobileBy.AccessibilityId;

/**
 * Created by dbudim on 25.06.2021
 */

public class AndroidDemoTest {

    @BeforeMethod
    public void initDriver() {
        Configuration.browser = AndroidHub.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        open();
    }

    @Test(invocationCount = 1)
    public void testEchoMessage() {
        var message = "Hello Test Busters";
        $(AccessibilityId("Echo Box")).click();
        $(AccessibilityId("messageInput")).sendKeys(message);
        $(AccessibilityId("messageSaveBtn")).click();
        $(AccessibilityId(message)).shouldBe(Condition.visible);
    }

    @AfterMethod
    public void quite(){
        WebDriverRunner.getWebDriver().quit();
    }

}
