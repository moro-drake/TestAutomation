import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.util.Iterator;
import java.util.List;

public class AttachFailureLogsToAllure implements IInvokedMethodListener {
    private static final Logger logger = LogManager.getLogger(AttachFailureLogsToAllure.class);


    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!testResult.isSuccess()) {
            byte[] attachment = addLogsToReport(Reporter.getOutput(testResult));
            logger.info("attaching logs to test case");
            AllureLifecycle lc = Allure.getLifecycle();
            lc.addAttachment("log4j2-logs", "text/plain", "log", attachment);
        }
    }


    public static synchronized byte[] addLogsToReport(List<String> logs) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> logIterator = logs.stream().iterator();
        while (logIterator.hasNext()) {
            stringBuilder.append(logIterator.next());
        }
        return stringBuilder.toString().getBytes();
    }
}