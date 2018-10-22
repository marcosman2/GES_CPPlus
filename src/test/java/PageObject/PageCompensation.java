package PageObject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.*;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import helpers.Helpers;

public class PageCompensation {
	
	private WebDriver driver;
	private By calculateButton;	
	
	public PageCompensation(WebDriver driver)
	{
		this.driver = driver;
		this.calculateButton = By.xpath("//*[@id=\"aaagnostic\"]/footer/ul/li[1]");
	}
	

	//---------------------Método para hacer clic en Calculate del Projection----------------------------
	
	public void calculateProjection()
	{
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Helpers exists = new Helpers(driver);
		boolean existsField = exists.existsElement("//*[@id=\"aaagnostic\"]/tabset/div/tab[3]/app-projection/form/div[1]/div/label[2]");
		if (existsField == true)
		{			
			driver.findElement(calculateButton).click();
		}
		else
		{
			Helpers capture = new Helpers(driver);
			capture.screenshotcapture("ISSUE_");
			driver.close();
		}			
	}
	
	//-----------------Método para hacer clic en Calculate del Worksheet-----------------------------------
	
	public void calculateWorksheet()
	{
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Helpers exists = new Helpers(driver);
		boolean existsField = exists.existsElement("//*[@id=\"aaagnostic\"]/tabset/div/tab[3]/app-worksheet/form/div/div[1]/div/label[2]");
		if (existsField == true)
		{			
			driver.findElement(calculateButton).click();
		}
		else
		{
			Helpers capture = new Helpers(driver);
			capture.screenshotcapture("ISSUE");
			driver.close();
		}
					
	}
}
