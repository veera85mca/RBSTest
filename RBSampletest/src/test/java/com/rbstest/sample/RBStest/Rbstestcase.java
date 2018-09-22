package com.rbstest.sample.RBStest;

import java.io.IOException;

import com.rbstest.sample.RBSinitialize.Driverinitialize;
import com.rbstest.sample.RBSpom.Rbspageobject;
import com.rbstest.sample.RBSreports.Screenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Rbstestcase extends Driverinitialize{
	
	@Given ("^Select the browsers as (.*)$")
	public void browser(String Browser)
	{
		initialize(Browser);
	}
	@When ("^Enter the urls as (.*)$")
	public void URL(String Url) throws IOException
	{
		Rbspageobject.geturl(Url);
	}
	@But ("^Click to signin link$")
	public void signinlink()
	{
		Rbspageobject.page_signinlink();
	}
	@And ("^Enter the usernames as (.*)$")
	public void username(String Username)
	{
		Rbspageobject.page_emailid(Username);
	}
	@But ("^Enter the passwords as (.*)$")
	public void password(String Password)
	{
		Rbspageobject.page_password(Password);
	}
	@Then ("^Click to login button$")
	public void login()
	{
		Rbspageobject.page_loginbutton();
	}
	@And ("^Click the T-shirt link in Title menu and select the Tshirt as (.*) to order$")
	public void Selecttshirt(String Tshirtname)
	{
		Rbspageobject.page_selecttshirt(Tshirtname);
	}
	@When ("^Select the quantity as (.*), Size as (.*) and color as (.*)$")
	public void quanity(Integer itemcount, String size, String color)
	{
		Rbspageobject.page_quantity(itemcount, size, color);
	}
	@Then ("^Click add to cart as selected the product$")
	public void addtocart()
	{
		Rbspageobject.page_addtocart();
	}
	@But ("^Click to proceed to summary$")
	public void proceedtosummary()
	{
		Rbspageobject.shopping_proceedsummary();
	}
	@And ("^Click to proceed to address$")
	public void proceedaddress()
	{
		Rbspageobject.shopping_proceedaddress();
	}
	@When ("^Validate the delivery option and check the terms of service in shipping$")
	public void shippingproceed()
	{
		Rbspageobject.Shopping_proceedshipping();
	}
	@But ("^Whether would you like do payment via bank or check as (.*) and order the product$")
	public void payment(String Bankcheck)
	{
		Rbspageobject.shopping_payment(Bankcheck);
	}
	@Then ("^Verify the product order in store order list$")
	public void verifyorderlist()
	{
		Rbspageobject.Verify_orderlist();
		driver.close();
	}

	//Update the account information
	@Given ("^Select the browsers for personal as (.*)$")
	public void perbrowser(String Browser)
	{
		initialize(Browser);
	}
	@When ("^Enter the urls for personal as (.*)$")
	public void perURL(String Url) throws IOException
	{
		Rbspageobject.geturl(Url);
	}
	@But ("^Click to signin link for personal$")
	public void persigninlink()
	{
		//Rbspageobject.signout();
		Rbspageobject.page_signinlink();
	}
	@And ("^Enter the usernames for personal as (.*)$")
	public void perusername(String Username)
	{
		Rbspageobject.page_emailid(Username);
	}
	@But ("^Enter the passwords for personal as (.*)$")
	public void perpassword(String Password)
	{
		Rbspageobject.page_password(Password);
	}
	@Then ("^Click to login button for personal$")
	public void perlogin()
	{
		Rbspageobject.page_loginbutton();
	}
	@When ("^Click to account personal info link$")
	public void accpersonalinfo()
	{
		Rbspageobject.account_personalinfo();
	}
	@And ("^Give the first name as (.*) and save$")
	public void accfirstname(String firstname)
	{
		Rbspageobject.account_updatefirstname(firstname);
	}
	
	
	
	@After
	public void teardown(Scenario s) throws IOException, InterruptedException
	{
		if(s.isFailed())
		{
			Screenshot.getscreenshot(s);
			driver.close();
			
		}
	}
}
