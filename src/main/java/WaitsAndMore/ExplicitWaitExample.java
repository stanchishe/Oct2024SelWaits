package WaitsAndMore;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitExample {
    private final String urlPage = "https://google.com";
    private final String agreeButton = "L2AGLb";
    private final String searchBox = "q";
    private final String firstResult = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a";
    private WebDriver webDriver;
    private int secondsToWait;

    public ExplicitWaitExample(WebDriver webDriver, int secondsToWait) {
        this.webDriver = webDriver;
        this.secondsToWait = secondsToWait;
    }

    public String getButtonText() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(secondsToWait));

        webDriver.get(urlPage);
        webDriver.findElement(By.id(agreeButton)).click();

        webDriver.findElement(By.name(searchBox)).sendKeys("Yahoo", Keys.ENTER);
        // TODO: add real fluent wait example later on
        // Fluent wait (not exactly working) example (when element is not found a TimeoutException is thrown, not ignored!)
        try {
            FluentWait<WebDriver> waitFluent = new FluentWait<>(webDriver)
                    .withTimeout(Duration.ofSeconds(secondsToWait)).ignoring(NoSuchElementException.class);
            waitFluent.until(ExpectedConditions.elementToBeClickable(By.xpath(firstResult)));
        } catch (TimeoutException e) {
            System.out.println("Timeout exception when looking for results");
        }
        WebElement firstSearchResult = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(firstResult))
        );

        return firstSearchResult.getText();
    }

}
