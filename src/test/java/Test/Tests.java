package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.PageDemographic;
import PageObject.PageDemographicMaxView;
import PageObject.PageLogin;

public class Tests {
	private WebDriver driver;
	
	//----------------------Pasos que se ejecutan siempre al inicio----------------------------
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://qprt.deloitte.com/IASTCPortal/dko/main.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.login("mamanrique", "Memp*830905");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	
	//--------------------------------CASOS DE PRUEBA EXITOSOS-----------------------------------------------------
	
	
	//--------------Test de pruebas para países que no requieren el State/Province---------------------
	/*@Test
	public void minAssigneeInfoNoState()
	{
		PageDemographic pageDemo = new PageDemographic(driver);
		pageDemo.minAssigneeInformationNoState("Test Marcos", "Argentina", "Australia", 78000, "01/01/2018", "12/31/2018");
	}
	
	//--------------Test de prueba para países que requieren el State/Province---------------------------
	
	@Test
	public void minAssigneeInfoState()
	{
		PageDemographic pageDemo = new PageDemographic(driver);
		pageDemo.minAssigneeInformationNoState("Test Marcos", "Canada", "United States", 78000, "01/01/2018", "12/31/2018");
		pageDemo.minAssigneeInformationState("Alberta", "Alabama");
	}
	
	//--------------Test de prueba Assignee con Dependents y Spouse------------------------------------------
	
	@Test
	public void minAssigneeInfoDependent()
	{
		PageDemographic pageDemo = new PageDemographic(driver);
		pageDemo.minAssigneeInformationNoState("Test Marcos", "Argentina", "Australia", 78000, "01/01/2018", "12/31/2018");
		pageDemo.minAssigneeInformationDependents(2);
	}
	
	@Test
	public void maxAssigneeInfoNoState()
	{
		PageDemographicMaxView pageDemo = new PageDemographicMaxView(driver);
		pageDemo.maxAssigneeInformationNoState("Test Max View", "09/24/1983", "Marcos", "Manrique", "Argentina", 89000, 3, "Australia", "01/01/2018", "12/31/2020");
	}*/
	
	@Test
	public void maxAssigneeInfoState()
	{
		PageDemographicMaxView pageDemo = new PageDemographicMaxView(driver);
		pageDemo.maxAssigneeInformationNoState("Test Max View", "09/24/1983", "Marcos", "Manrique", "Canada", 89000, 3, "United States", "01/01/2018", "12/31/2020");
		pageDemo.maxAssigneeInformationState("Alberta", "Alabama");
	}
	
	
	//----------------------Pasos que se ejecutan siempre al final----------------------------
	
	/*@AfterMethod
	public void tearDown()
	{
		driver.close();
	}*/
}
