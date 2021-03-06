package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    int counter = 0;
    int retryLimit = 5;

    /** @param result -> result of the test
     * @return true of the test method has to be retried, false otherwiser.
     */

    @Override
    public boolean retry(ITestResult result){
        if (counter < retryLimit){
            counter++;
            return true;
        }
        return false;
    }
}
