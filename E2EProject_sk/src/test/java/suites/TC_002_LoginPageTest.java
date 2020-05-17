package suites;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import custom_utils.*;
import pageObjects.*;
public class TC_002_LoginPageTest{
	public WebDriver driver;
	driverInit dI;
	anzLoginPage anzLP;

	@BeforeTest
	public void tearUp() throws IOException{
		dI=new driverInit();
		driver=dI.startdriver();
		anzLP=new anzLoginPage(driver);
		anzLP.goToPage();
	}
	@AfterTest
	public void tearDown(){
		dI.stopdriver();
	}

	@Test(dataProvider="getData")
	public void LoginTest(String cust_num,String password) throws Exception{
		anzLP.verifyLogin(cust_num,password);
	}

	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[3][2];
		data[0][0]="00";
		data[0][1]="pass00";
		data[1][0]="11";
		data[1][1]="pass11";
		data[2][0]="22";
		data[2][1]="pass22";
		return data;
	}


}
