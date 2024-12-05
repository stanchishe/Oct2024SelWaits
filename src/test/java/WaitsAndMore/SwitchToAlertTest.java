package WaitsAndMore;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SwitchToAlertTest {
    static WebDriver webDriver;

    @BeforeAll
    public static void initiate() {
        ChromeOptions chromeOptions = new ChromeOptions().addArguments("Start-Maximized");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    public static void cleanup() {
        webDriver.close();
        webDriver.quit();
    }

    @Test
    @DisplayName("should handle an Alert and retrieve its text!")
    public void shouldHandleAlertMessage() {
        // setup
        SwitchToAlert switchToAlert = new SwitchToAlert(webDriver);
        final String expectedAlertText = "Hello! I am an alert box!";
        // act
        String actualAlertText = switchToAlert.createAlert();
        // assert
        Assertions.assertEquals(expectedAlertText, actualAlertText, "The alert was not what we expected!");
    }
}
