package listenerspackage;
import org.testng.*;

public class CustomListeners implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart -> TestName" + iTestResult.getName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("onTestSuccess -> TestName" + iTestResult.getName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("onTestFailure -> TestName" + iTestResult.getName());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped -> TestName" + iTestResult.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("onStart -> TestName" + iTestContext.getName());
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish -> TestName" + iTestContext.getName());
    }
}