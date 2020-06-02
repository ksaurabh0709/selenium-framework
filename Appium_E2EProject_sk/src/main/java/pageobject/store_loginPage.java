package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
public class store_loginPage{
	AndroidDriver<AndroidElement> driver;

	public store_loginPage(AndroidDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="android:id/text1")
	public WebElement country_dropdown;

	@FindBy(xpath="//*[@text='Australia']")
	public WebElement country_name;

	@FindBy(xpath="//*[@text='Enter name here']")
	public WebElement name;

	@FindBy(xpath="//*[@text='Male']")
	public WebElement male;

	@FindBy(xpath="//*[@text='Female']")
	public WebElement female;

	@FindBy(className="android.widget.Button")
	public WebElement shop_button;

	public void scrollIntoView(){
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");
	}
}
