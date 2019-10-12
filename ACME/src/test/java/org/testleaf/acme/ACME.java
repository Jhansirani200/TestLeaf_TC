package org.testleaf.acme;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ACME {
	@Test
	public void acme(){
		
	//To set the driver
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			//To launch Chrome
			ChromeDriver driver = new ChromeDriver();
			//To maximize the browser
			driver.manage().window().maximize();
			//To load the URL
	        driver.get("https://acme-test.uipath.com/account/login");
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.findElementByName("email").sendKeys("kumar.testleaf@gmail.com");
	        driver.findElementByName("password").sendKeys("leaf@12");
	        driver.findElementById("buttonLogin").click();
	        WebElement findElementByXPath = driver.findElementByXPath("//div[@class= 'dropdown'][5]");
	        Actions builder = new Actions(driver);
	       builder.moveToElement(findElementByXPath).perform();
	        driver.findElementByLinkText("Search for Vendor").click();
	        driver.findElementByName("vendorName").sendKeys("Blue Lagoon");
	        driver.findElementById("buttonSearch").click();
	        String text = driver.findElementByXPath("//tr[2]/td[5]").getText();
	        System.out.println(text);
	        driver.findElementByLinkText("Log Out").click();
	        driver.close();
	        

	}
}