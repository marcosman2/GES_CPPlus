package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Helpers;

public class PageReport {

	private WebDriver driver;
	private By printButton;
	private By reportTitle;
	
	public PageReport(WebDriver driver)
	{
		this.driver = driver;
		this.reportTitle = By.xpath("//*[@id=\"nav-site-pane\"]/div/div/div[1]/div");
		this.printButton = By.xpath("//*[@id=\"aaagnostic\"]/footer/ul/li[3]");
	}
	
	
	//Método para hacer clic en el botón Print de la página Report
	
	public void printClick()
	{
		WebDriverWait wait = new WebDriverWait(driver, 180);
		WebElement print = wait.until(ExpectedConditions.presenceOfElementLocated(reportTitle));
		print.findElement(printButton).click();
		Helpers capture = new Helpers(driver);
		capture.screenshotcapture("PRINT_");
	}
}
