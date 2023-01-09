package utilities;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent {

    private static ExtentReports extent;
    private static ExtentSparkReporter extentSpark;

    public static void startExtentReport() {

	//extentSpark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extent-report/Extentreport.html");
	extentSpark = new ExtentSparkReporter("test-output/extent-report/Extentreport.html");
	extentSpark.config().setDocumentTitle("Automation Tests");
	extentSpark.config().setReportName("Functional Report");

	extent = new ExtentReports();
	extent.attachReporter(extentSpark);
	extent.setSystemInfo("Hostname", "LocalHost");
	extent.setSystemInfo("OS", "Mac OS");

	//test.log(Status.INFO, "Browser Started...");
    }

    public static void passOrFailTest(ITestResult testResult) {
	String testName = testResult.getName();
	ExtentTest test = extent.createTest(testName);

	if (testResult.getStatus() == ITestResult.SUCCESS) {
	    test.log(Status.PASS, "Test case PASSED: " + testName); //Adding a testName

	} else if (testResult.getStatus() == ITestResult.SKIP) {
	    test.log(Status.SKIP, "Test case SKIPPED: " + testName);

	} else if (testResult.getStatus() == ITestResult.FAILURE) {
	    test.log(Status.FAIL, "Test case FAILED: " + testName);
	    test.log(Status.FAIL, "Test case FAILED: " + testResult.getThrowable());

	    // Adding screenshot to the extent report
	    test.addScreenCaptureFromPath(Screenshot.takeScreenshot(testName));

	    //	    String path = Screenshot.takeScreenshot(testName);
	    //	    test.addScreenCaptureFromPath(path)
	    //		    .pass(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}
	extent.flush();
    }
}
