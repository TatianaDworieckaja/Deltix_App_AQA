package org.deltixuat.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int counter = 0;
    private static final int retryLimit = 3;
    private static final Logger LOG = LogManager.getLogger("RetryAnalyzer.class");

    @Override
    public boolean retry(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            if (counter < retryLimit) {
                LOG.info("Retrying test " + testResult.getName() + " with status " + getResultStatusName(
                        testResult.getStatus()) + " for the " + (this.counter + 1) + " time(s).");
                this.counter++;
                return true;
            }
        }
        return false;
    }

    public String getResultStatusName(final int status) {
        String resultName = null;
        if (status == 1) {
            resultName = "SUCCESS";
        }
        if (status == 2) {
            resultName = "FAILURE";
        }
        if (status == 3) {
            resultName = "SKIP";
        }
        return resultName;
    }
}
