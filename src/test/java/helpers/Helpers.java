package helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helpers {
	
	private WebDriver driver;
	
	public Helpers(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void screenshotcapture(String prefix)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(src, new File (prefix+System.currentTimeMillis()+".png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean existsElement(String id)
	{
		try
		{
			driver.findElement(By.xpath(id));
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
		return true;
	}
	
	public boolean enabledElement(String id)
	{
		if(driver.findElement(By.id(id)).isEnabled())
			return true;
		else
			return false;
	}

}
