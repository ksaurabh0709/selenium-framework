package pageObjects;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import junit.framework.Assert;
public class anzLoginPage{
	private static Logger log=LogManager.getLogger(anzLoginPage.class.getName());
	WebDriver driver;
	static String page_url="https://digital.anz.co.nz/preauth/web/service/login";
	public anzLoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="user-id")
	WebElement e_custnum;

	@FindBy(id="password")
	WebElement e_password;

	@FindBy(id="submit")
	WebElement e_submit;

	@FindBy(id="login-error-text")
	WebElement e_login_error;

	public void goToPage(){
		driver.get(page_url);
	}

	public void verifyLogin(String cust_num1,String password1){
		e_custnum.sendKeys(cust_num1);
		e_password.sendKeys(password1);
		e_submit.click();
		String login_error_msg=e_login_error.getText();
		String expected_msg="Your log on attempt was unsuccessful. Your password is case sensitive, please check your Caps Lock and try again.";
		log.info("Verifying Login error message");
		Assert.assertEquals(expected_msg,login_error_msg);
		driver.navigate().refresh();
	}

}
