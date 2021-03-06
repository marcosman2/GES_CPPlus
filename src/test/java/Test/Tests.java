package Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.PageCompensation;
import PageObject.PageDemographic;
import PageObject.PageDemographicMaxView;
import PageObject.PageLogin;
import PageObject.PagePayPolicyMinView;
import PageObject.PageReport;
import dataDriven.DataDrivenTest;
import helpers.Helpers;

public class Tests {
	private WebDriver driver;
	
	//----------------------Pasos que se ejecutan siempre al inicio----------------------------
	
	@BeforeMethod
	public void setUp()
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://qprt.deloitte.com/IASTCPortal/dko/main.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.login("mamanrique", "Memp*830905");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	
	
	//--------------Test para pa�ses que no requieren el State/Province (Projection)---------------------
	@Test
	public void minAssigneeInfoNoStateProjection()
	{
		PageDemographic pageDemo = new PageDemographic(driver);
		pageDemo.minAssigneeInformationNoState("Test 1", "Argentina", "Australia", 78000, "01/01/2018", "12/30/2018");
		PagePayPolicyMinView pagePay = new PagePayPolicyMinView(driver);
		pageDemo.demographicNext();
		pagePay.selectPayPolicy("PPT 110618");
		pagePay.projectionClick();
		PageCompensation pageComp = new PageCompensation(driver);
		pageComp.calculateProjection();
		PageReport pageRep = new PageReport(driver);
		pageRep.printClick();
	}
	
	
	//--------------Test para pa�ses que no requieren el State/Province (Worksheet)---------------------
		@Test
		public void minAssigneeInfoNoStateWorksheet()
		{
			PageDemographic pageDemo = new PageDemographic(driver);
			pageDemo.minAssigneeInformationNoState("Test 2", "Argentina", "Australia", 78000, "01/01/2018", "06/30/2019");
			PagePayPolicyMinView pagePay = new PagePayPolicyMinView(driver);
			pageDemo.demographicNext();
			pagePay.selectPayPolicy("PPT 110618");
			pagePay.worksheetClick();
			PageCompensation pageComp = new PageCompensation(driver);
			pageComp.calculateWorksheet();
			PageReport pageRep = new PageReport(driver);
			pageRep.printClick();
		}
	
	//--------------Test para pa�ses que requieren el State/Province (Projection)---------------------------
	
	@Test
	public void minAssigneeInfoStateProjection()
	{
		PageDemographic pageDemo = new PageDemographic(driver);
		pageDemo.minAssigneeInformationNoState("Test 3", "Canada", "United States", 78000, "01/01/2018", "12/31/2018");
		pageDemo.minAssigneeInformationState("Alberta", "Alabama");
		pageDemo.demographicNext();
		PagePayPolicyMinView pagePay = new PagePayPolicyMinView(driver);
		pagePay.selectPayPolicy("CP Plus PPT");
		pagePay.projectionClick();
		PageCompensation pageComp = new PageCompensation(driver);
		pageComp.calculateProjection();
		PageReport pageRep = new PageReport(driver);
		pageRep.printClick();
	}
	
	//--------------Test para pa�ses que requieren el State/Province (Worksheet)-------------
	
	@Test
	public void minAssigneeInfoStateWorksheet()
	{
		PageDemographic pageDemo = new PageDemographic(driver);
		pageDemo.minAssigneeInformationNoState("Test 4", "Canada", "United States", 78000, "01/01/2018", "12/31/2018");
		pageDemo.minAssigneeInformationState("Alberta", "Alabama");
		pageDemo.demographicNext();
		PagePayPolicyMinView pagePay = new PagePayPolicyMinView(driver);
		pagePay.selectPayPolicy("CP Plus PPT");
		pagePay.worksheetClick();
		PageCompensation pageComp = new PageCompensation(driver);
		pageComp.calculateWorksheet();
		PageReport pageRep = new PageReport(driver);
		pageRep.printClick();
	}
	
	//--------------Test para Assignee con Dependents y Spouse (Projection)------------------------------------------
	
	@Test
	public void minAssigneeInfoDependentProjection()
	{
		PageDemographic pageDemo = new PageDemographic(driver);
		pageDemo.minAssigneeInformationNoState("Test 5", "Argentina", "Australia", 78000, "01/01/2018", "12/31/2018");
		pageDemo.minAssigneeInformationDependents((double) 2);
		pageDemo.demographicNext();
		PagePayPolicyMinView pagePay = new PagePayPolicyMinView(driver);
		pagePay.selectPayPolicy("CP Plus PPT");
		pagePay.projectionClick();
		PageCompensation pageComp = new PageCompensation(driver);
		pageComp.calculateProjection();
		PageReport pageRep = new PageReport(driver);
		pageRep.printClick();
	}
	
	//--------------Test para Assignee con Dependents y Spouse (Worksheet)------------------------------------------
	
	@Test
	public void minAssigneeInfoDependentWorksheet()
	{
		PageDemographic pageDemo = new PageDemographic(driver);
		pageDemo.minAssigneeInformationNoState("Test 6", "Argentina", "Australia", 78000, "01/01/2018", "12/31/2018");
		pageDemo.minAssigneeInformationDependents((double) 2);
		pageDemo.demographicNext();
		PagePayPolicyMinView pagePay = new PagePayPolicyMinView(driver);
		pagePay.selectPayPolicy("CP Plus PPT");
		pagePay.worksheetClick();
		PageCompensation pageComp = new PageCompensation(driver);
		pageComp.calculateWorksheet();
		PageReport pageRep = new PageReport(driver);
		pageRep.printClick();
	}
	
	//--------Test para Assignee Max View que no requieren State/Province(Projection)--------------------
	
	@Test
	public void maxAssigneeInfoNoStateProjection()
	{
		PageDemographicMaxView pageDemo = new PageDemographicMaxView(driver);
		pageDemo.maxAssigneeInformationNoState("Test 7", "09/24/1983", "Marcos", "Manrique", "Argentina", 89000, 3, "Australia", "01/01/2018", "12/31/2018");
		//pageDemo.demographicNext();
		PagePayPolicyMinView pagePay = new PagePayPolicyMinView(driver);
		pagePay.selectPayPolicy("CP Plus PPT");
		pagePay.projectionClick();
		PageCompensation pageComp = new PageCompensation(driver);
		pageComp.calculateProjection();
		PageReport pageRep = new PageReport(driver);
		pageRep.printClick();
	}
	
	//--------Test para Assignee Max View que no requieren State/Province(Worksheet)--------------------
	
	@Test
	public void maxAssigneeInfoNoStateWorksheet()
	{
		PageDemographicMaxView pageDemo = new PageDemographicMaxView(driver);
		pageDemo.maxAssigneeInformationNoState("Test 8", "09/24/1983", "Marcos", "Manrique", "Argentina", 89000, 3, "Australia", "01/01/2018", "12/31/2018");
		//pageDemo.demographicNext();
		PagePayPolicyMinView pagePay = new PagePayPolicyMinView(driver);
		pagePay.selectPayPolicy("CP Plus PPT");
		pagePay.worksheetClick();
		PageCompensation pageComp = new PageCompensation(driver);
		pageComp.calculateWorksheet();
		PageReport pageRep = new PageReport(driver);
		pageRep.printClick();
	}
	
	//--------Test para Assignee Max View que requieren State/Province(Projection)--------------------
	
	@Test
	public void maxAssigneeInfoStateProjection()
	{
		PageDemographicMaxView pageDemo = new PageDemographicMaxView(driver);
		pageDemo.maxAssigneeInformationNoState("Test 9", "09/24/1983", "Marcos", "Manrique", "Canada", 89000, 3, "United States", "01/01/2018", "12/31/2018");
		pageDemo.maxAssigneeInformationState("Alberta", "Alabama");
		//pageDemo.demographicNext();
		PagePayPolicyMinView pagePay = new PagePayPolicyMinView(driver);
		pagePay.selectPayPolicy("CP Plus PPT");
		pagePay.projectionClick();
		PageCompensation pageComp = new PageCompensation(driver);
		pageComp.calculateProjection();
		PageReport pageRep = new PageReport(driver);
		pageRep.printClick();
	}
	
	//--------Test para Assignee Max View que requieren State/Province(Worksheet)--------------------
	
	@Test
	public void maxAssigneeInfoStateWorksheet()
	{
		PageDemographicMaxView pageDemo = new PageDemographicMaxView(driver);
		pageDemo.maxAssigneeInformationNoState("Test 10", "09/24/1983", "Marcos", "Manrique", "Canada", 89000, 3, "United States", "01/01/2018", "12/31/2018");
		pageDemo.maxAssigneeInformationState("Alberta", "Alabama");
		//pageDemo.demographicNext();
		PagePayPolicyMinView pagePay = new PagePayPolicyMinView(driver);
		pagePay.selectPayPolicy("CP Plus PPT");
		pagePay.worksheetClick();
		PageCompensation pageComp = new PageCompensation(driver);
		pageComp.calculateWorksheet();
		PageReport pageRep = new PageReport(driver);
		pageRep.printClick();
	}
	
	
	
	//----------------------Pasos que se ejecutan siempre al final----------------------------
	
	/*@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}*/
}
