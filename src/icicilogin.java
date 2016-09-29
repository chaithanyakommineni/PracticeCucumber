import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class icicilogin {
WebDriver driver;
@Given("^open browser as \"([^\"]*)\" And enter url as \"([^\"]*)\"$")
public void open_browser_as_And_enter_url_as(String browser, String url) throws Throwable {
	if(browser.equals("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(browser.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
    
}

@When("^Enter username \"([^\"]*)\" And password \"([^\"]*)\" And click on sign in$")
public void enter_username_And_password_And_click_on_sign_in(String username, String password, DataTable table) throws Throwable {
	List<List<String>> data=table.raw();
	WebElement el=driver.findElement(By.id("AuthenticationFG.USER_PRINCIPAL"));
	el.clear();
	el.sendKeys(data.get(0).get(0));
	WebElement ele=driver.findElement(By.id("AuthenticationFG.ACCESS_CODE"));
	ele.clear();
	ele.sendKeys(data.get(0).get(1));
	driver.findElement(By.id("VALIDATE_CREDENTIALS1")).click();
	
}

@Then("^successfully login$")
public void successfully_login() throws Throwable {
    System.out.println("login success");
}

@When("^enter username \"([^\"]*)\" And password as \"([^\"]*)\" And click on sign in$")
public void enter_username_And_password_as_And_click_on_sign_in(String username, String password) throws Throwable {
	WebElement el1=driver.findElement(By.id("AuthenticationFG.USER_PRINCIPAL"));
	el1.clear();
	el1.sendKeys(username);
	WebElement el2=driver.findElement(By.id("AuthenticationFG.ACCESS_CODE"));
	el2.clear();
	el2.sendKeys(password);
	driver.findElement(By.id("VALIDATE_CREDENTIALS1")).click();
	
    
}

@Then("^success \"([^\"]*)\"$")
public void success(String arg1) throws Throwable {
    
System.out.println("login success icici");

}
@After
public void close()
{
	driver.quit();
}
}