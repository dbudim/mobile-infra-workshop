import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import emulators.AndroidHub;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

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

    @Test
    public void testDemo() {
        $(By.xpath("//*[@content-desc='Search Wikipedia'][1]")).click();
        $(By.xpath("//*[@content-desc='Clear query']")).shouldBe(Condition.visible);
    }

    @AfterMethod
    public void tearDown() {
        getWebDriver().quit();
    }

}
