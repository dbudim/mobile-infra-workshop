import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import emulators.IosLocal;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.appium.java_client.MobileBy.AccessibilityId;

/**
 * Created by dbudim on 25.06.2021
 */

public class IosDemoTest {

    @BeforeClass
    public void initDriver() {
        Configuration.browser = IosLocal.class.getName();
        Configuration.browserSize = null;
        open();
    }

    @Test
    public void testSum() {
        $(AccessibilityId("IntegerA")).sendKeys("2");
        $(AccessibilityId("IntegerB")).sendKeys("3");
        $(AccessibilityId("ComputeSumButton")).click();
        $(AccessibilityId("Answer")).should(Condition.text("5"));
    }

}
