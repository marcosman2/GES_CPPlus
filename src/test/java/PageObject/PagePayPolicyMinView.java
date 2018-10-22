package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Helpers;

public class PagePayPolicyMinView {
	
	private WebDriver driver;
	private By payPolicyDrop;
	private By PayPolicySelection;
	private By homeActualTemplateDrop;
	private By projectionButton;
	private By worksheetButton;	
	
	public PagePayPolicyMinView (WebDriver driver)
	{
		this.driver = driver;
		this.payPolicyDrop = By.id("inputPayPolicyTemplates");
		this.PayPolicySelection = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[2]/app-paypolicy/form/div[1]/div/typeahead-container/ul/li/a");
		this.homeActualTemplateDrop = By.id("inputHomeActualTemplate");
		this.projectionButton = By.xpath("//*[@id=\"aaagnostic\"]/footer/ul/li[2]");
		this.worksheetButton = By.xpath("//*[@id=\"aaagnostic\"]/footer/ul/li[1]");
	}

	//-------------------Método para seleccionar un Pay Policy-----------------------------------------
	
	public void selectPayPolicy (String payPolicy)
	{		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement policy = wait.until(ExpectedConditions.elementToBeClickable(payPolicyDrop));
		policy.sendKeys(payPolicy);
		driver.findElement(PayPolicySelection).click();		
	}
	
	//-------------------Método para hacer clic en Projection-----------------------------------------
	
	public void projectionClick()
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement projection = wait.until(ExpectedConditions.elementToBeClickable(homeActualTemplateDrop));
		projection.findElement(projectionButton).click();		
	}
	
	//-------------------Método para hacer clic en Worksheet-----------------------------------------
	
	public void worksheetClick()
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement worksheet = wait.until(ExpectedConditions.elementToBeClickable(homeActualTemplateDrop));
		worksheet.findElement(worksheetButton).click();		
	}
	
	
}
