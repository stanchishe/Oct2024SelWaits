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
        // Fluent wait (not exactly working) example
        // FluentWait<WebDriver> wait = new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds(secondsToWait)).ignoring(NoSuchElementException.class);
        // TODO: add real fluent wait example later on
        WebElement firstSearchResult = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(firstResult))
        );

        return firstSearchResult.getText();
    }

}
