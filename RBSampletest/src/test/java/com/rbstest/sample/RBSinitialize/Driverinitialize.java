package com.rbstest.sample.RBSinitialize;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driverinitialize {

public static WebDriver driver;
public static void initialize(String browser)
{
	if(browser.equalsIgnoreCase("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+File.separator+"Browserdrivers"+File.separator+"geckodriver.exe");
		driver=new FirefoxDriver();
		
	}else if (browser.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"Browserdrivers"+File.separator+"chromedriver.exe");
		driver=new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(18, TimeUnit.SECONDS);
}
}
