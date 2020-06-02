package test_suite;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageobject.*;

public class tc01_hybridapp{
	AndroidDriver<AndroidElement> driver;
	driver_init di;
	store_loginPage store_lp;
	store_shoppingPage store_sp;
	store_kartPage store_kp;
	anz_homePage anz_hp;
	TouchAction touch;

	@BeforeTest
	public void suiteup() throws IOException{
		di=new driver_init();
		driver=di.init_android_driver();
		store_lp=new store_loginPage(driver);
		store_sp=new store_shoppingPage(driver);
		store_kp=new store_kartPage(driver);
		anz_hp=new anz_homePage(driver);
		touch=new TouchAction(driver);
	}

	@AfterTest
	public void teardown(){
		driver.closeApp();
		driver.close();
	}
	@Test
	public void shop_shoes() throws InterruptedException{
		System.out.println("Test starts from here!");;
		store_lp.country_dropdown.click();
		driver.hideKeyboard();
		store_lp.scrollIntoView();
		store_lp.country_name.click();
		store_lp.name.sendKeys("Hi There");
		store_lp.female.click();
		store_lp.shop_button.click();
		Thread.sleep(2000);

		store_sp.scrollIntoView_star();
		store_sp.star_add_to_kart.click();
		store_sp.scrollIntoView_jordan();
		store_sp.jordan_add_to_kart.click();;
		store_sp.kart.click();
		Thread.sleep(3000);

		// Price starts with $100 so this will drop $ and print 100
		System.out.println(store_kp.jordan_kart.getText().substring(1));
		System.out.println(store_kp.star_kart.getText().substring(1));
		double price1=Double.parseDouble(store_kp.jordan_kart.getText().substring(1));
		double price2=Double.parseDouble(store_kp.star_kart.getText().substring(1));
		double total=price1+price2;
		System.out.println("Product sum is $"+total);

		// mobile gesture
		WebElement email_discount_checkbox=driver.findElementByClassName("android.widget.CheckBox");
		touch.tap(tapOptions().withElement(element(email_discount_checkbox))).perform();

		store_kp.complete_order.click();
		Thread.sleep(7000);

		// Context handler to switch between native app and web view
		Set<String> contexts=driver.getContextHandles();
		for(String contextName:contexts){
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		Thread.sleep(2000);

		anz_hp.goto_page();
		Thread.sleep(5000);

		JavascriptExecutor jse=driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",anz_hp.loan_cal);
		Thread.sleep(2000);
		anz_hp.loan_cal.click();
		anz_hp.repay_cal.click();
		anz_hp.loan_amount.sendKeys("600000");
		jse.executeScript("arguments[0].scrollIntoView(true);",anz_hp.calculate);
		anz_hp.calculate.click();
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.context("NATIVE_APP");
	}

}
