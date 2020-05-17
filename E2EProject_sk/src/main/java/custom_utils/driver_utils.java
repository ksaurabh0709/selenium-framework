package custom_utils;

import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class driver_utils{
	public WebDriver driver;

	public driver_utils(WebDriver driver){
		this.driver=driver;
	}

	public void verifyTitle(String title){
		String actual_title=driver.getTitle();
		System.out.println("Actual title is : "+actual_title);
		System.out.println("Expected title is : "+title);
		Assert.assertEquals(title,actual_title);
	}

}
