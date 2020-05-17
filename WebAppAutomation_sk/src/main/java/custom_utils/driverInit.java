package custom_utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

import com.google.common.io.Files;


public class driverInit{
	private static Logger log=LogManager.getLogger(driverInit.class.getName());
	public WebDriver driver;
	private static String propfilepath;

	public WebDriver startdriver() throws IOException{
		propfilepath="C:\\Users\\saura\\eclipse-workspace\\E2EProject_sk\\resources\\driverinit.properties";
		String chromepath="C:\\Users\\saura\\Desktop\\Learning\\resources\\chromedriver.exe";
		String firefoxpath="C:\\Users\\saura\\Desktop\\Learning\\resources\\geckodriver.exe";
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(propfilepath);
		prop.load(fis);

		if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",chromepath);
			ChromeOptions options=new ChromeOptions();
			if(prop.getProperty("headless").equalsIgnoreCase("true")){
				options.addArguments("--headless");
			}
			if(prop.getProperty("ignore_ssl_error").equalsIgnoreCase("true")){
				options.addArguments("--ignore-certificate-errors");
			}
			if(prop.getProperty("accept_ssl").equalsIgnoreCase("true")){
				options.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
			}
			driver=new ChromeDriver(options);
			if(!prop.getProperty("driverwait").isEmpty()){
				int driverwait=Integer.parseInt(prop.getProperty("driverwait"));
				driver.manage().timeouts().implicitlyWait(driverwait,TimeUnit.SECONDS);
			}
		}else if(prop.getProperty("browser").equals("firefox")){
			System.setProperty("webdriver.gecko.driver",firefoxpath);
			driver=new FirefoxDriver();

		}else{
			log.info("Please mention browser value in properties file : chrome/headlesschrome/firefox");
		}
		log.info("Browser : "+prop.getProperty("browser"));
		// log.info("headless : "+prop.getProperty("headless"));
		// log.info("driverwait : "+prop.getProperty("driverwait"));
		// log.info("ignore_ssl_error : "+prop.getProperty("ignore_ssl_error"));
		// log.info("accept_ssl : "+prop.getProperty("accept_ssl"));

		return driver;
	}

	public void stopdriver(){
		driver.close();
		driver=null;
	}

	public void getScreenshot(String result) throws IOException{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src,
				new File("C:\\Users\\saura\\eclipse-workspace\\E2EProject_sk\\screenshots\\"+result+"screenshot.png"));
	}
}
