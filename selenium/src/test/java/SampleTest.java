import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Log4j2
public class SampleTest {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverFactory.getDriver();
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    void doStuff() {
        driver.get("http://www.google.com");
        log.info("I am at {}", driver.getTitle());
    }
}
