package day39;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener
{
	public void onStart(ITestContext context) 
	{
		System.out.println("On Start");
	}

	public void onTestStart(ITestResult result) 
	{
		System.out.println("On Test Start");
	}
	
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("On Test Failure");
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("On Test Skipped");
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("On Test Success");
	}
	
	public void onFinish() 
	{
		System.out.println("On Finished");
	}
}
