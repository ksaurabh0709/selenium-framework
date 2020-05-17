package suites;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import custom_utils.*;
import pageObjects.*;

public class TC_001_HomePageTest{
	public WebDriver driver;
	driverInit dI;
	driver_utils dUtil;
	anzHomePage anzHP;

	@BeforeTest
	public void tearUp() throws IOException{
		dI=new driverInit();
		driver=dI.startdriver();
		dUtil=new driver_utils(driver);
		anzHP=new anzHomePage(driver);
		anzHP.goToPage();
	}

	@AfterTest
	public void tearDown(){
		dI.stopdriver();
	}


	@Test
	public void VerifyTitle() throws Exception{
		dUtil.verifyTitle("ANZ Bank New Zealand Ltd | Online Banking | ANZ");
	}
	@Test
	public void VerifyCovidText() throws Exception{
		anzHP.verifyCovidText(
				"COVID-19 Alert Level 4: Essential banking services will continue during the lockdown. Find out more.");
	}
	@Test
	public void VerifyCovidLevelText() throws Exception{
		anzHP.verifyCovidLevelText("COVID-19 Alert Level 4:");
	}


}
