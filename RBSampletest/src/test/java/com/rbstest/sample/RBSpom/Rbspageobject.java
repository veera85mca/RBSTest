package com.rbstest.sample.RBSpom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.bcel.generic.GETFIELD;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rbstest.sample.RBSinitialize.Driverinitialize;

public class Rbspageobject extends Driverinitialize{

public static FileInputStream file;
public static Properties prob;
public static String tshirt;
public static String tshirtsize;
public static String tshirtcolor;
public static int itemnumbers;

public static void geturl(String url) throws IOException
{
	driver.get(url);
	file=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Alllocators"+File.separator+"Shoppinglocators.properties"));
	prob=new Properties();
	prob.load(file);
}
public static void page_signinlink()
{
	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.elementToBeClickable(getmyxpath("Homepage_Signin_link"))).click();
}
public static void page_emailid(String user)
{
	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(getmyxpath("Homepage_Singin_emailid"))).sendKeys(user);
}
public static void page_password(String pass)
{
	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(getmyxpath("Homepage_Singin_password"))).sendKeys(pass);
}
public static void page_loginbutton()
{
	getmyxpath("Homepage_Singin_loginbutton").click();
}
public static void page_selecttshirt(String tshirtname)
{
	tshirt=tshirtname;
	WebDriverWait wait2=new WebDriverWait(driver, 15);
	wait2.until(ExpectedConditions.elementToBeClickable(getmyxpath("Puchase_women_link"))).click();
	String xpath="//a[@class='product-name'][@title='";
	String xpath1="']";
	String fullpath=xpath+tshirtname+xpath1;
	WebElement Tshirtlink=driver.findElement(By.xpath(fullpath));
	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(Tshirtlink));
	scrollele(Tshirtlink);
	Tshirtlink.click();
}
public static void page_quantity(Integer itemcount, String size, String Color)
{
	itemnumbers=itemcount;
	tshirtsize=size;
	tshirtcolor=Color;
	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(getmyxpath("Purchase_Tshirt_nameheader")));	
	if(!getmyxpath("Purchase_Tshirt_nameheader").getText().equalsIgnoreCase(tshirt))
	{
		Assert.fail("Tshirt name is not matched");
	}
	getmyxpath("Purchase_Tshirt_quantity").clear();
	getmyxpath("Purchase_Tshirt_quantity").sendKeys(String.valueOf(itemcount));
	dropdown(getmyxpath("Purchase_Tshirt_size"), size);
	if(Color.equalsIgnoreCase("Blue"))
	{
		getmyxpath("Purchase_Tshirt_Color_blue").click();
	}else if (Color.equalsIgnoreCase("Orange")) {
		getmyxpath("Purchase_Tshirt_Color_orange").click();
	}
}
public static void page_addtocart()
{
	getmyxpath("Purchase_Tshirt_addtocart_button").click();
	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(getmyxpath("Purchase_Tshirt_proceedtocheckout"))).click();
}
public static void shopping_proceedsummary()
{
	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(getmyxpath("Shopping_cart_summary_header")));	
	scrollele(getmyxpath("Shopping_cart_summary_proceedtocheckout"));
	getmyxpath("Shopping_cart_summary_proceedtocheckout").click();
}
public static void shopping_proceedaddress()
{
	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(getmyxpath("Shopping_cart_address_header")));
	scrollele(getmyxpath("Shopping_cart_address_proceedtocheckout"));
	getmyxpath("Shopping_cart_address_proceedtocheckout").click();
}
public static void Shopping_proceedshipping()
{
	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(getmyxpath("Shopping_cart_address_header")));
	scrollele(getmyxpath("Shipping_cart_termsservice"));
	if(!getmyxpath("Shipping_cart_deliveryoption").isSelected())
	{
		getmyxpath("Shipping_cart_deliveryoption").click();
	}
	getmyxpath("Shipping_cart_termsservice").click();
	getmyxpath("Shipping_cart_proceed").click();	
}
public static void shopping_payment(String bankcheck)
{
	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(getmyxpath("Shopping_cart_address_header")));
	scrollele(getmyxpath("Payment_check_link"));
	if(bankcheck.equalsIgnoreCase("bank wire"))
	{
		getmyxpath("Payment_bank_link").click();
	}else if (bankcheck.equalsIgnoreCase("check")) {
		getmyxpath("Payment_check_link").click();
	}
	scrollele(getmyxpath("Payment_confirm_order"));
	getmyxpath("Payment_confirm_order").click();
}
public static void Verify_orderlist()
{
	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(getmyxpath("Shopping_cart_address_header")));
	scrollele(getmyxpath("Payment_backtoorders_link"));
	getmyxpath("Payment_backtoorders_link").click();
	WebDriverWait wait1=new WebDriverWait(driver, 150);
	wait1.until(ExpectedConditions.visibilityOf(getmyxpath("Order_history_header")));
}


//Update the account personal information
public static void account_personalinfo()
{
	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(getmyxpath("Shopping_cart_address_header")));
	scrollele(getmyxpath("Account_personalinformation_link"));
	getmyxpath("Account_personalinformation_link").click();
}
public static void account_updatefirstname(String firstname)
{
	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(getmyxpath("Account_personal_firstname")));
	getmyxpath("Account_personal_firstname").clear();
	getmyxpath("Account_personal_firstname").sendKeys(firstname);
	scrollele(getmyxpath("Account_personal_save"));
	getmyxpath("Account_personal_save").click();
}

public static void signout()
{
	getmyxpath("Homepage_Signout").click();
}

//Common Functions
public static WebElement getmyxpath(String xpath)
{
	return driver.findElement(By.xpath(prob.getProperty(xpath)));
}
public static void scrollele(WebElement ele)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele);
}
public static void dropdown(WebElement drop, String size)
{
	Select s=new Select(drop);
	s.selectByVisibleText(size);
}
}
