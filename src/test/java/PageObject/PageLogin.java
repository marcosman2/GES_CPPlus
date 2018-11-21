package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		this.cpPlus = By.xpath("//*[@id=\"toolgroup\"]/div/div[1]/div[1]");
	}
	
	public void login(String user, String password)
	{
		driver.findElement(loginUser).sendKeys(user);
		driver.findElement(loginPassword).sendKeys(password);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		login.click();
		WebElement qualityAssurance = wait.until(ExpectedConditions.presenceOfElementLocated(qaLink));
		qualityAssurance.click();
		driver.findElement(cpPlus).click();
	}
}
