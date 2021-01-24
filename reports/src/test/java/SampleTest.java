import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class SampleTest {
    private static final Logger logger = LogManager.getLogger(SampleTest.class);

    @DataProvider(parallel = true)
    public static Object[][] dataLogMsg() {
        return new Object[][]{
                {"first msg"},
                {"second msg"},
                {"third msg"},
        };
    }

    @Test(dataProvider = "dataLogMsg")
    public void testCase(String logMsg) {
        logger.info("running test case with dataLogMsg provider");
        logger.info(logMsg);
    }

    @Test
    public void testCaseFail() {
        logger.info("testCaseFail test info log");
        logger.error("testCaseFail test error log");
        logger.warn("testCaseFail test warn log");
        fail("testCaseFail failed");
    }
}
