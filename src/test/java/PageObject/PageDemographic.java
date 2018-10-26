package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Helpers;

public class PageDemographic {
	
	//Se declaran los objetos de la página
	
	private WebDriver driver;
	private By scenarioField;
	private By homeCountryDrop;
	private By homeStateDrop;
	private By salaryField;
	private By currencyDrop;
	private By dependentsField;
	private By spouseCheck;
	private By hostCountryDrop;
	private By hostStateDrop;
	private By beginDateCalendar;
	private By endDateCalendar;
	private By newButton;
	private By nextButton;
	private By minViewButton;
	private By maxViewButton;
	private By homeCountrySelection;
	private By hostCountrySelection;
	private By homeStateSelection;
	private By hostStateSelection;
	
	//Constructor para inicializar los objetos
	
	public PageDemographic(WebDriver driver)
	{
		this.driver = driver;
		this.scenarioField = By.id("inputScenearioDesc");
		this.homeCountryDrop = By.id("inputHomeCountry");
		this.homeStateDrop = By.id("inputHomeStateProvince");
		this.salaryField = By.id("inputSalary");
		this.currencyDrop = By.id("inputCurrency");
		this.dependentsField = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/accordion/accordion-group[1]/div/div[2]/div/app-assignee/form/div[4]/div[1]/input");
		this.spouseCheck = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/accordion/accordion-group[1]/div/div[2]/div/app-assignee/form/div[4]/div[2]/label[2]");
		this.hostCountryDrop = By.id("inputhostCountry");
		this.hostStateDrop = By.id("inputHostStateProvince");
		this.beginDateCalendar = By.id("inputEstimatedBeginDate");
		this.endDateCalendar = By.id("inputEstimatedEndDate");
		this.newButton = By.xpath("//*[@id=\"aaagnostic\"]/footer/ul/li[2]");
		this.nextButton = By.xpath("//*[@id=\"aaagnostic\"]/footer/ul/li[1]");
		this.minViewButton = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/div/div/button[1]");
		this.maxViewButton = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/div/div/button[2]");
		this.homeCountrySelection = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/accordion/accordion-group[1]/div/div[2]/div/app-assignee/form/div[2]/div[1]/typeahead-container/ul/li/a/span/strong");
		this.hostCountrySelection = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/accordion/accordion-group[2]/div/div[2]/div/app-assignment/form/div[1]/div[1]/typeahead-container/ul/li/a/span/strong");
		this.homeStateSelection = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/accordion/accordion-group[1]/div/div[2]/div/app-assignee/form/div[2]/div[2]/typeahead-container/ul/li/a");
		this.hostStateSelection = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/accordion/accordion-group[2]/div/div[2]/div/app-assignment/form/div[1]/div[2]/typeahead-container/ul/li[1]/a/span/strong");
	}
	
	//Método para llenar los campos mínimos requeridos (País no requiere State/Province)
	
	public void minAssigneeInformationNoState(String scenario, String homeCntry, String hostCntry, double salary, String beginDate, String endDate)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement homeCountry = wait.until(ExpectedConditions.elementToBeClickable(homeCountryDrop));
			driver.findElement(scenarioField).sendKeys(scenario);
			homeCountry.sendKeys(homeCntry);
			driver.findElement(homeCountrySelection).click();
			
			driver.findElement(salaryField).sendKeys(String.valueOf(salary));
			
			driver.findElement(hostCountryDrop).sendKeys(hostCntry);
			driver.findElement(hostCountrySelection).click();	
			
			driver.findElement(beginDateCalendar).sendKeys(beginDate);
			driver.findElement(endDateCalendar).sendKeys(endDate);
		}
		catch(Exception e)
		{	
			Helpers enabled = new Helpers(driver);
			enabled.screenshotcapture("ISSUE_Home Country Field Disabled_");
			try
			{
				Thread.sleep(5000);
			}
			catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
			driver.close();			
		}		
	}
	
	
	//----------------Método para llenar los campos Home y Host State/Province--------------------------
	
	public void minAssigneeInformationState(String homeState, String hostState)
	{
		WebDriverWait waitHomeState = new WebDriverWait(driver, 120);
		WebElement homeSt = waitHomeState.until(ExpectedConditions.elementToBeClickable(homeStateDrop));
		homeSt.sendKeys(homeState);
		driver.findElement(homeStateSelection).click();
		
		WebDriverWait waitHostState = new WebDriverWait(driver, 120);
		WebElement hostSt = waitHostState.until(ExpectedConditions.elementToBeClickable(hostStateDrop));
		hostSt.sendKeys(hostState);
		driver.findElement(hostStateSelection).click();
	}
	
	//-----------------------Método para adicionar dependent y esposa------------------------------------
	
	public void minAssigneeInformationDependents(Double dependents)
	{
		driver.findElement(dependentsField).sendKeys(String.valueOf(dependents));
		driver.findElement(spouseCheck).click();		
	}
	
	//Método para hacer clic en Next
	
	public void demographicNext()
	{
		driver.findElement(nextButton).click();
	}
	
	
}
