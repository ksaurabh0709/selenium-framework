package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
public class store_shoppingPage{
	AndroidDriver<AndroidElement> driver;
	public store_shoppingPage(AndroidDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//android.widget.TextView[@text='Converse All Star']/parent::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']")
	public WebElement star_add_to_kart;

	@FindBy(xpath="//android.widget.TextView[@text='Jordan 6 Rings']/parent::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']")
	public WebElement jordan_add_to_kart;

	@FindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement kart;

	public void scrollIntoView_star(){
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"));");
	}
	public void scrollIntoView_jordan(){
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));");
	}
}