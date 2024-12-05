package WaitsAndMore;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchToAlert {
    private WebDriver webDriver;
    private final String testBasePage = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert";
    private final String acceptChoicesId = "accept-choices";
    private final String iFrameId = "iframeResult";
    private final String xPathToButton = "/html/body/button";

    public SwitchToAlert (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String createAlert () {
        // Open the test page and accept the choices offered.
        webDriver.get(testBasePage);
        webDriver.findElement(By.id(acceptChoicesId)).click();

        // Switch to the iFrame HTML capable of generating an alert.
        WebElement iFrameHTML = webDriver.findElement(By.id(iFrameId));
        webDriver.switchTo().frame(iFrameHTML);

        // Use the button to create an alert.
        webDriver.findElement(By.xpath(xPathToButton)).click();

        // Handle the alert pop-up
        Alert alert = webDriver.switchTo().alert();
        String alertSting = alert.getText();

        // Accept the alert
        alert.accept();

        // Return to the base HTML page.
        webDriver.switchTo().parentFrame();

        return alertSting;
    }
 }
