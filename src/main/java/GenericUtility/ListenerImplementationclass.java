package GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationclass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
		report.createTest(methodName);
		Reporter.log("Execution start", true);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName);
		Reporter.log(methodName+"Execution success");
		
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		try
		{
			String scrShotName = WebDriverUtility.getScreenshot(BaseclassForFlipkart.sdriver, methodName);
			test.log(Status.FAIL, methodName+"--Failed");
			test.log(Status.FAIL,result.getThrowable());
			test.addScreenCaptureFromPath(scrShotName);
			Reporter.log(methodName+"Execution Failed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, methodname+" Skipped ");
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/Report.html");
		htmlreport.config().setDocumentTitle("Flipkart ");
		htmlreport.config().setReportName("Iphne 15");
		htmlreport.config().setTheme(Theme.STANDARD);
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Platform","Windows");
		report.setSystemInfo("Base-Browser","Chrome");
		report.setSystemInfo("Base-URL","https://www.flipkart.com");
		report.setSystemInfo("ReporterName","Soumya");
		
		
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	
	

}
