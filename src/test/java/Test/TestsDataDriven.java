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

	
public class TestsDataDriven {
	
private WebDriver driver;
	
	//----------------------Pasos que se ejecutan siempre al inicio----------------------------
	
	@BeforeMethod
	public void setUp()
	{
		//DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://qprt.deloitte.com/IASTCPortal/dko/main.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.login("mamanrique", "Memp*830905");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	
	//********************************DATA DRIVEN TEST CASES*********************************************
	
		//----------Test para países que no requieren el State/Province (Projection) (Data Driven)------------
		
		@DataProvider
		public Iterator<Object[]> getDataMinInfoNoState()
		{
			ArrayList<Object[]> testData = DataDrivenTest.dataReaderMinInfoNoState();
			return testData.iterator();
		}
		
		@Test(dataProvider="getDataMinInfoNoState")
		public void dataDrivenMinAssigneeInfoNoStateProjection(String scenario, String homeCountry, String hostCountry, Double salary, String beginDate, String endDate, String policy)
		{
			PageDemographic pageDemo = new PageDemographic(driver);
			DataDrivenTest.dataReaderMinInfoNoState();
			pageDemo.minAssigneeInformationNoState(scenario, homeCountry, hostCountry, salary, beginDate, endDate);
			pageDemo.demographicNext();
			PagePayPolicyMinView pagePay = new PagePayPolicyMinView(driver);
			pagePay.selectPayPolicy(policy);
			pagePay.projectionClick();
			PageCompensation pageComp = new PageCompensation(driver);
			pageComp.calculateProjection();
			PageReport pageRep = new PageReport(driver);
			pageRep.printClick();
		}
		
		@DataProvider
		public Iterator<Object[]> getDataMinInfoState()
		{
			ArrayList<Object[]> testData = DataDrivenTest.dataReaderMinInfoState();
			return testData.iterator();
		}
		
		@Test(dataProvider="getDataMinInfoState")
		public void dataDrivenMinAssigneeInfoStateProjection(String scenario, String homeCountry, String hostCountry, Double salary, String beginDate, String endDate, String homeState, String hostState, String policy)
		{
			PageDemographic pageDemo = new PageDemographic(driver);
			DataDrivenTest.dataReaderMinInfoState();
			pageDemo.minAssigneeInformationNoState(scenario, homeCountry, hostCountry, salary, beginDate, endDate);
			pageDemo.minAssigneeInformationState(homeState, hostState);
			pageDemo.demographicNext();
			PagePayPolicyMinView pagePay = new PagePayPolicyMinView(driver);
			pagePay.selectPayPolicy(policy);
			pagePay.projectionClick();
			PageCompensation pageComp = new PageCompensation(driver);
			pageComp.calculateProjection();
			PageReport pageRep = new PageReport(driver);
			pageRep.printClick();
		}
		
		@DataProvider
		public Iterator<Object[]> getDataMinInfoDependents()
		{
			ArrayList<Object[]> testData = DataDrivenTest.dataReaderMinInfoDependents();
			return testData.iterator();
		}
		
		@Test(dataProvider="getDataMinInfoDependents")
		public void minAssigneeInfoDependentProjection(String scenario, String homeCountry, String hostCountry, Double salary, String beginDate, String endDate, Double dependents, String policy)
		{
			PageDemographic pageDemo = new PageDemographic(driver);
			DataDrivenTest.dataReaderMinInfoDependents();
			pageDemo.minAssigneeInformationNoState(scenario, homeCountry, hostCountry, salary, beginDate, endDate);
			pageDemo.minAssigneeInformationDependents(dependents);
			pageDemo.demographicNext();
			PagePayPolicyMinView pagePay = new PagePayPolicyMinView(driver);
			pagePay.selectPayPolicy("CP Plus PPT");
			pagePay.projectionClick();
			PageCompensation pageComp = new PageCompensation(driver);
			pageComp.calculateProjection();
			PageReport pageRep = new PageReport(driver);
			pageRep.printClick();
		}
		
		//----------------------Pasos que se ejecutan siempre al final----------------------------
		
		@AfterMethod
		public void tearDown()
		{
			driver.close();
		}
}


