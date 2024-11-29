package WaitsAndMore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ImplicitWaitExample {
    private WebDriver webDriver;
    private int secondsToWait;

    public ImplicitWaitExample(WebDriver webDriver, int secondsToWait) {
        this.webDriver = webDriver;
        this.secondsToWait = secondsToWait;
    }

    public String getElementText(String webPageUrl, String elementXpath) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secondsToWait));
        webDriver.get(webPageUrl);
        WebElement htmlElement = webDriver.findElement(By.xpath(elementXpath));
        String htmlElementText = htmlElement.getText();
        if(htmlElementText.equals("Some text")) {
            // do something
        }
        return htmlElementText;
    }
}
