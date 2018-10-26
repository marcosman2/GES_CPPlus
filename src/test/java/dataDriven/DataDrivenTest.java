package dataDriven;


import excelReader.Xls_Reader;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;


public class DataDrivenTest {
	
	static Xls_Reader reader;
	public static String scenarioName;
	public static String homeCountry;
	public static String hostCountry;
	public static Double salary;
	public static String beginDate;
	public static String endDate;
	public static String homeState;
	public static String hostState;
	public static Double dependents;
	public static String payPolicy;
	
	public static ArrayList<Object[]> dataReaderMinInfoNoState()
	{
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		try
		{
		reader = new Xls_Reader("C:\\Users\\mamanrique\\eclipse-workspace\\CPPlus\\src\\test\\java\\helpers\\Assignee_Data.xlsx");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		int rowCount = reader.getRowCount("NoState");
		//int colCount = reader.getColumnCount("NoState");
		for (int rowNum = 2; rowNum<= rowCount; rowNum++)
		{
			
			scenarioName = reader.getCellData("NoState", "Scenario", rowNum);
			homeCountry = reader.getCellData("NoState", "Home_Country", rowNum);
			hostCountry = reader.getCellData("NoState", "Host_Country", rowNum);
			salary = Double.parseDouble(reader.getCellData("NoState", "Salary", rowNum));
			beginDate = reader.getCellData("NoState", "Begin_Date", rowNum);
			endDate = reader.getCellData("NoState", "End_Date", rowNum);
			payPolicy = reader.getCellData("NoState", "Policy", rowNum);
			
			Object ob[] = {scenarioName, homeCountry, hostCountry, salary, beginDate, endDate, payPolicy};
			data.add(ob);
			
		}
		return data;		
		
	}
	
	public static ArrayList<Object[]> dataReaderMinInfoState()
	{
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		try
		{
		reader = new Xls_Reader("C:\\Users\\mamanrique\\eclipse-workspace\\CPPlus\\src\\test\\java\\helpers\\Assignee_Data.xlsx");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		int rowCount = reader.getRowCount("State");
		//int colCount = reader.getColumnCount("State");
		for (int rowNum = 2; rowNum<= rowCount; rowNum++)
		{
			
			scenarioName = reader.getCellData("State", "Scenario", rowNum);
			homeCountry = reader.getCellData("State", "Home_Country", rowNum);
			hostCountry = reader.getCellData("State", "Host_Country", rowNum);
			salary = Double.parseDouble(reader.getCellData("State", "Salary", rowNum));
			beginDate = reader.getCellData("State", "Begin_Date", rowNum);
			endDate = reader.getCellData("State", "End_Date", rowNum);
			homeState = reader.getCellData("State", "Home_State", rowNum);
			hostState = reader.getCellData("State", "Host_State", rowNum);
			payPolicy = reader.getCellData("State", "Policy", rowNum);
			
			Object ob[] = {scenarioName, homeCountry, hostCountry, salary, beginDate, endDate, homeState, hostState, payPolicy};
			data.add(ob);
			
		}
		return data;		
		
	}
	
	public static ArrayList<Object[]> dataReaderMinInfoDependents()
	{
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		try
		{
		reader = new Xls_Reader("C:\\Users\\mamanrique\\eclipse-workspace\\CPPlus\\src\\test\\java\\helpers\\Assignee_Data.xlsx");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		int rowCount = reader.getRowCount("Dependents");
		for (int rowNum = 2; rowNum<= rowCount; rowNum++)
		{
			
			scenarioName = reader.getCellData("Dependents", "Scenario", rowNum);
			homeCountry = reader.getCellData("Dependents", "Home_Country", rowNum);
			hostCountry = reader.getCellData("Dependents", "Host_Country", rowNum);
			salary = Double.parseDouble(reader.getCellData("Dependents", "Salary", rowNum));
			beginDate = reader.getCellData("Dependents", "Begin_Date", rowNum);
			endDate = reader.getCellData("Dependents", "End_Date", rowNum);
			dependents = Double.parseDouble(reader.getCellData("Dependents", "Dependents", rowNum));
			payPolicy = reader.getCellData("Dependents", "Policy", rowNum);
			
			Object ob[] = {scenarioName, homeCountry, hostCountry, salary, beginDate, endDate, dependents, payPolicy};
			data.add(ob);
			
		}
		return data;		
		
	}
}
