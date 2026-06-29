package hanh.example.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

    @Override
    public boolean retry(ITestResult result) {
        int maxRetryCount = 2;
        int retryCount = result.getMethod().getCurrentInvocationCount();
        if(retryCount < maxRetryCount){
            return true;
        }
        return false;
    }
}
