import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.util.Iterator;
import java.util.List;

public class AttachFailureLogsToAllure implements ITestListener {

    @Override
    public void onTestFailure(ITestResult tr) {
        Allure.addAttachment("log4j2-logs", addLogsToReport(Reporter.getOutput(tr)));
    }

    public static String addLogsToReport(List<String> logs) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> logIterator = logs.stream().iterator();
        while (logIterator.hasNext()) {
            stringBuilder.append(logIterator.next());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}