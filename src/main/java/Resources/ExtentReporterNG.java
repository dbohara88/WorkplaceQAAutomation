package Resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	public static ExtentReports getReportObject() {
		String filePath = System.getProperty("user.dir") + File.separator+"reports"+File.separator+"index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Workplace Automation Result");
		reporter.config().setDocumentTitle("Test Results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Deepak Bohara");
		return extent;
	}
}
