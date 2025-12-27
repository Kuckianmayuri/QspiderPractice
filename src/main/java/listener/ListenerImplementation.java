package listener;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import config.baseClass;

public class ListenerImplementation implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		Date d = new Date();
		String newdata = d.toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_" + newdata + ".html");
		spark.config().setDocumentTitle("NinzaCRMReports");
		spark.config().setReportName("CRM Reports");
		spark.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window 11");
		report.setSystemInfo("Browser", "edge");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "====" + result.getMethod().getMethodName() + " Exceution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "====" + result.getMethod().getMethodName() + " Exceution Successfully done");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Date d = new Date();
		String newdata = d.toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot) baseClass.sdriver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp, testname + newdata);
		test.log(Status.FAIL, "====" + result.getMethod().getMethodName() + " Exceution failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "====" + result.getMethod().getMethodName() + " Exceution skipped");
	}
}
