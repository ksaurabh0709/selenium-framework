package pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class driver_init{
	private static String app_path;
	private static String prop_path;

	public AndroidDriver<AndroidElement> init_android_driver() throws IOException{
		app_path="C:\\Users\\saura\\Desktop\\Learning\\resources\\hybrid-app.apk";
		prop_path="src\\main\\java\\pageobject\\android_driver.properties";

		FileInputStream fis=new FileInputStream(prop_path);
		Properties prop=new Properties();
		prop.load(fis);
		DesiredCapabilities cap=new DesiredCapabilities();

		if(System.getProperty("platform")==null){
			System.out.println("print me I am null");
		}

		System.out.println("maven input platform="+System.getProperty("platform"));


		if(prop.getProperty("platform").equalsIgnoreCase("android")){
			if(prop.getProperty("real_device").equalsIgnoreCase("true")){
				cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
			}else{
				cap.setCapability(MobileCapabilityType.DEVICE_NAME,prop.getProperty("emulator_name"));
			}
		}

		/*
		 * if(System.getProperty("platform").equalsIgnoreCase("android")){
		 * if(System.getProperty("real_device").equalsIgnoreCase("true")){
		 * cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device"); }else{
		 * cap.setCapability(MobileCapabilityType.DEVICE_NAME,System.getProperty("emulator_name")); } }
		 */

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"15");

		if(prop.getProperty("app").equalsIgnoreCase("true")){
			cap.setCapability(MobileCapabilityType.APP,app_path);
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		}
		if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
			cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Firefox");
		}
		if(prop.getProperty("browser").equalsIgnoreCase("safari")){
			cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Safari");
		}

		AndroidDriver<AndroidElement> driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
	}
}
