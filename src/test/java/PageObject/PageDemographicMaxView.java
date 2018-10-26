package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Helpers;

public class PageDemographicMaxView {
	
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
	private By dobCalendar;
	private By firstNameField;
	private By surnameField;
	private By homeFilingDrop;
	private By maritalDrop;
	private By homeFamilySizeField;
	private By hostFilingDrop;
	private By hostFamilySizeField;
	private By newButton;
	private By nextButton;
	private By minViewButton;
	private By maxViewButton;
	private By homeCountrySelection;
	private By hostCountrySelection;
	private By homeStateSelection;
	private By hostStateSelection;
	
	public PageDemographicMaxView(WebDriver driver)
	{
		this.driver = driver;
		this.scenarioField = By.id("inputScenearioDesc");
		this.dobCalendar = By.id("inputBirthDate");
		this.firstNameField = By.id("inputFirsName");
		this.surnameField = By.id("inputSurname");
		this.homeCountryDrop = By.id("inputHomeCountry");
		this.homeStateDrop = By.id("inputHomeStateProvince");
		this.salaryField = By.id("inputSalary");
		this.currencyDrop = By.id("inputCurrency");
		this.dependentsField = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/accordion/accordion-group[1]/div/div[2]/div/app-assignee/form/div[6]/div[1]/input");
		this.spouseCheck = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/accordion/accordion-group[1]/div/div[2]/div/app-assignee/form/div[6]/div[2]/label[2]");
		this.homeFilingDrop = By.id("inputHomeFilingStatus");
		this.maritalDrop = By.id("inputMaritalStatus");
		this.homeFamilySizeField = 
		this.hostCountryDrop = By.id("inputhostCountry");
		this.hostStateDrop = By.id("inputHostStateProvince");
		this.beginDateCalendar = By.id("inputEstimatedBeginDate");
		this.endDateCalendar = By.id("inputEstimatedEndDate");
		this.hostFilingDrop = By.id("inputHostFilingStatus");
		this.homeFamilySizeField = By.xpath("//*[@id=\"inputFamilySize\"]");
		this.newButton = By.xpath("//*[@id=\"aaagnostic\"]/footer/ul/li[2]");
		this.nextButton = By.xpath("//*[@id=\"aaagnostic\"]/footer/ul/li[1]");
		this.minViewButton = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/div/div/button[1]");
		this.maxViewButton = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/div/div/button[2]");
		this.homeCountrySelection = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/accordion/accordion-group[1]/div/div[2]/div/app-assignee/form/div[4]/div[1]/typeahead-container/ul/li/a");
		this.hostCountrySelection = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/accordion/accordion-group[2]/div/div[2]/div/app-assignment/form/div[1]/div[1]/div[1]/typeahead-container/ul/li/a"); 
		this.homeStateSelection = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/accordion/accordion-group[1]/div/div[2]/div/app-assignee/form/div[4]/div[2]/typeahead-container/ul/li[1]/a"); 
		this.hostStateSelection = By.xpath("//*[@id=\"aaagnostic\"]/tabset/div/tab[1]/accordion/accordion-group[2]/div/div[2]/div/app-assignment/form/div[1]/div[1]/div[2]/typeahead-container/ul/li[1]/a"); 
	}
	
	
	//Método para llenar los datos máximos en Assignee Demographic (País no requiere State/Province)
	
	public void maxAssigneeInformationNoState(String scenario, String doB, String firstName, String surname, String homeCntry, double salary, int dependents, String hostCntry, String beginDate, String endDate)
	{
		try
		{
		
			WebDriverWait wait = new WebDriverWait(driver, 120);
			WebElement homeCountry = wait.until(ExpectedConditions.elementToBeClickable(homeCountryDrop));
			driver.findElement(maxViewButton).click();
			driver.findElement(scenarioField).sendKeys(scenario);
			driver.findElement(dobCalendar).clear();
			driver.findElement(dobCalendar).sendKeys(doB);
			driver.findElement(firstNameField).clear();
			driver.findElement(firstNameField).sendKeys(firstName);
			driver.findElement(surnameField).clear();
			driver.findElement(surnameField).sendKeys(surname);
			homeCountry.sendKeys(homeCntry);
			driver.findElement(homeCountrySelection).click();
			driver.findElement(salaryField).sendKeys(String.valueOf(salary));
			driver.findElement(dependentsField).sendKeys(String.valueOf(dependents));
			driver.findElement(spouseCheck).click();
			driver.findElement(hostCountryDrop).sendKeys(hostCntry);
			driver.findElement(hostCountrySelection).click();	
			driver.findElement(beginDateCalendar).sendKeys(beginDate);
			driver.findElement(endDateCalendar).sendKeys(endDate);		
			driver.findElement(nextButton).click();
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
	
	//Método para llenar los datos máximos en Assignee Demographic (País requiere State/Province)
	
	public void maxAssigneeInformationState(String homeState, String hostState)
	{
		
			WebDriverWait waitHomeState = new WebDriverWait(driver, 120);
			WebElement homeSt = waitHomeState.until(ExpectedConditions.elementToBeClickable(homeStateDrop));
			homeSt.sendKeys(homeState);
			driver.findElement(homeStateSelection).click();
			WebDriverWait waitHostState = new WebDriverWait(driver, 120);
			WebElement hostSt = waitHostState.until(ExpectedConditions.elementToBeClickable(hostStateDrop));
			hostSt.sendKeys(hostState);
			driver.findElement(hostStateSelection).click();
			driver.findElement(nextButton).click();
		
	}

}
