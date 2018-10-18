package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin {
	
	private WebDriver driver;
	private By loginUser;
	private By loginPassword;
	private By loginButton;
	private By qaLink;
	private By cpPlus;
	
	public PageLogin(WebDriver driver)
	{
		this.driver = driver;
		this.loginUser = By.name("userid");
		this.loginPassword = By.name("password");
		this.loginButton = By.xpath("//*[@id=\"loginform\"]/fieldset/button");
		this.qaLink = By.xpath("//*[@id=\"t_b1dd86ab-4e96-4648-afb7-d9e3cc95bc66nav\"]/div/span[2]");
		this.cpPlus = By.xpath("//*[@id=\"toolgroup\"]/div/div[3]/div[1]");
	}
	
	public void login(String user, String password)
	{
		driver.findElement(loginUser).sendKeys(user);
		driver.findElement(loginPassword).sendKeys(password);
		driver.findElement(loginButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(qaLink).click();
		driver.findElement(cpPlus).click();
	}
}
