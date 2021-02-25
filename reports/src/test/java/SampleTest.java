import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Function;
import java.util.function.IntFunction;

import static org.testng.Assert.fail;

public class SampleTest {
    private static final Logger logger = LogManager.getLogger(SampleTest.class);

    @DataProvider(parallel = true)
    public static Object[][] dataLogMsg() {
        return new Object[][]{
                {"first msg", true},
                {"second msg", false},
                {"third msg", true},
                {"4 msg", false},
                {"5 msg", false},
                {"6 msg", false},
                {"7 msg", false},
                {"8 msg", false},
                {"9 msg", false},
                {"10 msg", false},
                {"11 msg", false},
                {"1third msg", true},
                {"2third msg", true},
                {"3third msg", true},
                {"4third msg", true},
                {"5third msg", true},
                {"6second msg", false},
                {"7second msg", false},
                {"8second msg", false},
                {"9third msg", true},
                {"10third msg", true},
                {"11third msg", true},

        };
    }

    @Test(dataProvider = "dataLogMsg")
    public void testCase(String logMsg, boolean shouldPass) {
        logger.info("running test case with dataLogMsg provider");
        logger.info(logMsg);
        Assert.assertTrue(shouldPass);

    }

    @Test(dataProvider = "dataLogMsg")
    public void secondCase(String msg, boolean shouldPass) {
        logger.warn("running test case with dataLogMsg provider");
        logger.warn(msg);
        Assert.assertTrue(shouldPass);
    }

    @Test(dataProvider = "dataLogMsg")
    public void thirdCase(String msg, boolean shouldPass) {
        logger.warn("running test case with !dataLogMsg provider");
        logger.warn(spam.apply(msg));
        Assert.assertTrue(!shouldPass);
    }

    Function<String, String> spam = (x) -> x + "asd";

    IntFunction<Integer> doubleIt = x -> x * 2;


    @Test
    public void testCaseFail() {
        var a = 9;
        Long b = Long.valueOf(4);
        System.out.println(a);
        System.out.println(b.getClass());
        logger.info("testCaseFail test info log");
        logger.error("testCaseFail test error log");
        logger.warn("testCaseFail test warn log");
        fail("testCaseFail failed");
    }
}
