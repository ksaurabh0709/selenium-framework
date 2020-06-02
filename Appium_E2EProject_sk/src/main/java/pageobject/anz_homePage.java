package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class anz_homePage{
	AndroidDriver<AndroidElement> driver;

	String url="https://www.anz.co.nz/personal";

	public anz_homePage(AndroidDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void goto_page(){
		driver.get(url);
	}

	@FindBy(xpath="//a[contains(text(),'Calculators and tools')]")
	public WebElement loan_cal;

	@FindBy(linkText="Home loan repayment calculator")
	public WebElement repay_cal;

	@FindBy(xpath="//*[@id='Scenario1']//input[@name='LoanAmount']")
	public WebElement loan_amount;

	@FindBy(xpath="//*[@id='Scenario1']//input[@type='submit']")
	public WebElement calculate;

}
