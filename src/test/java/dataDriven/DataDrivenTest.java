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
	public static String payPolicy;
	
	public static ArrayList<Object[]> dataReader()
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
		int rowCount = reader.getRowCount("Hoja1");
		int colCount = reader.getColumnCount("Hoja1");
		for (int rowNum = 2; rowNum<= rowCount; rowNum++)
		{
			
			scenarioName = reader.getCellData("Hoja1", "Scenario", rowNum);
			homeCountry = reader.getCellData("Hoja1", "Home_Country", rowNum);
			hostCountry = reader.getCellData("Hoja1", "Host_Country", rowNum);
			salary = Double.parseDouble(reader.getCellData("Hoja1", "Salary", rowNum));
			beginDate = reader.getCellData("Hoja1", "Begin_Date", rowNum);
			endDate = reader.getCellData("Hoja1", "End_Date", rowNum);
			payPolicy = reader.getCellData("Hoja1", "Policy", rowNum);
			
			Object ob[] = {scenarioName, homeCountry, hostCountry, salary, beginDate, endDate, payPolicy};
			data.add(ob);
			
		}
		return data;		
		
	}
}
