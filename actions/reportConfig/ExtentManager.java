    package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
import commons.GlobalConstants;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants.RELATIVE_PROJECT_PATH + "/extentReport/HTMLReportVersion5.html");
        reporter.config().setReportName("Orange HRM Report");
        reporter.config().setDocumentTitle("Orange HRM Report");
        reporter.config().setTimelineEnabled(true);
        reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.DARK);

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Company", "Duc Dat");
        extentReports.setSystemInfo("Project", "OrangeHRM");
        extentReports.setSystemInfo("Team", "TNT");
        extentReports.setSystemInfo("JDK version", GlobalConstants.JAVA_VERSION);
        return extentReports;
    }
}