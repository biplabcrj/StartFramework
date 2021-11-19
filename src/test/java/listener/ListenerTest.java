package listener;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.generaleUtility;

public class ListenerTest implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("executing onFinish");
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("executing on start");
		
		File file = new File("C:\\Users\\BIPLAB\\eclipse-workspace\\StartFramework\\target\\screenshot.text");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("on test failure");
		System.out.println(arg0.getName() +" is a failed test case");
		//read from properties
		//if(propertiescond.equals("all") || propertiescond.equals("onFailure"))
		generaleUtility.takeScreenshot(arg0.getName());
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("on test start");
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("on test success");
		//read from properties
		//if(propertiescond.equals("all") || propertiescond.equals("onPass"))
		System.out.println(arg0.getName() +" is a pass test case");
	}

}
