package dataDriven;


import excelReader.Xls_Reader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DataDrivenTest {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\mamanrique\\eclipse-workspace\\CPPlus\\src\\test\\java\\helpers\\Automation_Data.xls");
		String test2 = reader.getCellData("Hoja1", "Assignee_Min_NoState", 2);
		System.out.println(test2);
	
	}

}
