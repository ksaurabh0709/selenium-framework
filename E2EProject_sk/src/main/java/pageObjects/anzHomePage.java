package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class anzHomePage{
	private static Logger log=LogManager.getLogger(anzHomePage.class.getName());
	public WebDriver driver;
	static String page_url="https://www.anz.co.nz/personal/";
	public anzHomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//*[@class='important__notice__message']//b[contains(text(),'COVID')]")
	WebElement covid_level;

	@FindBy(xpath="//*[@class='important__notice__message']/p")
	WebElement covid_message;

	public void goToPage(){
		driver.get(page_url);
	}
	public void verifyCovidText(String text){
		String actual_text=covid_message.getText();
		log.info("Actual text is : "+actual_text);
		log.info("Expected text is : "+text);
		Assert.assertEquals(text,actual_text);
	}
	public void verifyCovidLevelText(String text){
		String actual_text=covid_level.getText();
		log.info("Actual text is : "+actual_text);
		log.info("Expected text is : "+text);
		Assert.assertEquals(text,actual_text);
	}


}
