import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import emulators.IosHub;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.By.xpath;

/**
 * Created by dbudim on 25.06.2021
 */

public class IosDemoTest {

    @BeforeMethod
    public void initDriver() {
        Configuration.browser = IosHub.class.getName();
        Configuration.browserSize = null;
        open();
    }

    @Test
    public void testSum() {
        $(xpath("//*[@name='IntegerA']")).sendKeys("2");
        $(xpath("//*[@name='IntegerB']")).sendKeys("3");
        $(xpath("//*[@name='ComputeSumButton']")).click();
        $(xpath("//*[@name='Answer']")).should(Condition.text("5"));
    }

    @AfterMethod
    public void tearDown() {
        getWebDriver().quit();
    }

}
