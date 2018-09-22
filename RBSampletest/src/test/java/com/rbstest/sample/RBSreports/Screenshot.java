package com.rbstest.sample.RBSreports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.rbstest.sample.RBSinitialize.Driverinitialize;

import cucumber.api.Scenario;

public class Screenshot extends Driverinitialize{

	public static void getscreenshot(Scenario s) throws IOException
	{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileInputStream f = new FileInputStream(src);
	s.embed(IOUtils.toByteArray(f), "image/jpeg");
	}

}
