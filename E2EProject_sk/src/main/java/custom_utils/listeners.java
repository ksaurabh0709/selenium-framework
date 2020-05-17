package custom_utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener{
	driverInit dI=new driverInit();
	public void onTestFailure(ITestResult result){
		try{
			dI.getScreenshot(result.getName());
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void onStart(ITestContext context){
	}

	public void onFinish(ITestContext context){
	}

}
