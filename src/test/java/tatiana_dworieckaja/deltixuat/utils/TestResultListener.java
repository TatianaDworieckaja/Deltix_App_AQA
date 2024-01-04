package tatiana_dworieckaja.deltixuat.utils;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestResultListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            try {
                Browser.saveScreenShot();
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
}
