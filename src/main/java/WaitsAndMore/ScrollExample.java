package WaitsAndMore;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollExample {
    private WebDriver webDriver;
    public ScrollExample (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private void scrollPx(int pixels) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeAsyncScript("window.scroll(0," + pixels + ")");
    }
}
