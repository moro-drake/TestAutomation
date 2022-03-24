import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

@UtilityClass
public class DriverFactory {

    private WebDriver webDriver = null;

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
        if(Objects.isNull(webDriver)) {
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }
}
