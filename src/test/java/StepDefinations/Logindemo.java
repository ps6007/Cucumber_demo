package StepDefinations;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.Login_page;

public class Logindemo

{
	WebDriver driver = null;
	Login_page ob;
	
	

	@Given("Browser is opening")
	public void browser_is_opening() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/Drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("user is on login  page")
	public void user_is_on_login_page() {

		driver.navigate().to("https://www.flipkart.com/");

	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password (String username, String password) throws InterruptedException {
		ob = new Login_page(driver);
	    ob.gen(username, password);

	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		
		driver.getPageSource().contains("shivam dubey");
		String title = driver.getTitle();
		System.out.println(title);
		
	}
	
	@Then("^user enters (.*) name$")
	public void user_enters_shoes_name(String product) throws InterruptedException 
	{
			
			ob.search(product);
			driver.quit();
	}

}
