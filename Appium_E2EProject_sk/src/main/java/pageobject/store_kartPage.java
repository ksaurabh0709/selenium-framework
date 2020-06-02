package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class store_kartPage{
	AndroidDriver<AndroidElement> driver;
	public store_kartPage(AndroidDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//android.widget.TextView[@text='Jordan 6 Rings']/parent::android.widget.LinearLayout//android.widget.TextView[contains(@text,'$')]")
	public WebElement jordan_kart;

	@FindBy(xpath="//android.widget.TextView[@text='Converse All Star']/parent::android.widget.LinearLayout//android.widget.TextView[contains(@text,'$')]")
	public WebElement star_kart;

	@FindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement complete_order;
}
