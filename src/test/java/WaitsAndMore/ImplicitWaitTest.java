package WaitsAndMore;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ImplicitWaitTest {
    static WebDriver webDriver;
    static int secondsToWait = 10;
    static String webPageUrl = "https://reqres.in/api/users?delay=3";
    static String elementXpath = "/html/body/pre";

    @BeforeAll
    public static void initiate() {
        ChromeOptions chromeOptions = new ChromeOptions().addArguments("Start-Maximized");
        webDriver = new ChromeDriver(chromeOptions);
    }

    @AfterAll
    public static void exit() {
        webDriver.close();
        webDriver.quit();
    }

    //(It) should find an element in the HTML containing some text.
    @Test
    @DisplayName("should find an element in the html")
    public void shouldFindElementText() {
        // setup
        String expectedResult = "charles.morris@reqres.in";
        ImplicitWaitExample implicitWaitExample = new ImplicitWaitExample(webDriver, secondsToWait);
        // act
        String actualResult = implicitWaitExample.getElementText(webPageUrl, elementXpath);
        // assert
        Assertions.assertTrue(actualResult.contains(expectedResult), "The expected emails was not found!");
    }
}
