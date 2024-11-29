package WaitsAndMore;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExplicitWaitTest {
    static WebDriver webDriver;
    static int secondsToWait = 2;

    @BeforeAll
    public static void initiate() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("Start-Maximized");
        webDriver = new ChromeDriver(chromeOptions);
    }

    @AfterAll
    public static void closeAndQuit() {
        webDriver.close();
        webDriver.quit();
    }

    @Test
    @DisplayName("should get the text from the first found search result")
    public void shouldGetFirstResult() {
        // setup
        String expectedPartialResult = "Yahoo";
        String expectedFullResult = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports ..." +
                "\nYahoo" +
                "\nhttps://www.yahoo.com";
        ExplicitWaitExample explicitWaitExample = new ExplicitWaitExample(webDriver, secondsToWait);
        // act
        String actualResult = explicitWaitExample.getButtonText();
        // assert
        Assertions.assertTrue(actualResult.contains(expectedPartialResult), "The found element did not contain the right substring");
        Assertions.assertEquals(expectedFullResult, actualResult, "The found element was not correct!");
    }
}
