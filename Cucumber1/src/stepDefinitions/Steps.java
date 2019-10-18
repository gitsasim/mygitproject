package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	WebDriver driver;
	
	@Given("^Open the chrome and start application$")
	public void Open_the_chrome_and_start_application() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\z003tp0r\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://myntra.com/login");		
	}
	
	@When("^Enter valid Username and valid Password$")
	public void Enter_valid_Username_and_valid_Password() throws Throwable
	{
		//System.out.println("This step enters the valid Username and valid Password on the login page.");
		driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div/div/form/fieldset[1]/div[1]/input")).sendKeys("sasim.apiit@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div/div/form/fieldset[1]/div[2]/input")).sendKeys("sasim@myntra");
	}
	
	@Then("^User should be able to login successfully$")
	public void User_should_be_able_to_login_successfully() throws Throwable
	{
		//System.out.println("This step clicks on the Login button.");
		driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div/div/form/fieldset[2]/button")).click();
	}
	
	@Then("^User should be able to Logout$")
	public void User_should_be_able_to_Logout() throws Throwable
	{
		Actions actions = new Actions(driver);
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div/div[1]/span[1]"));
		actions.moveToElement(logout).perform();
		driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div/div")).click();
	}
}
