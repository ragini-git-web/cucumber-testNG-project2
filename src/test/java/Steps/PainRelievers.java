
package Steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PainRelievers {
	
	WebDriver driver;
	WebDriverWait wait ;
	JavascriptExecutor jsExecutor;
	
	

    @Given("Open the url in the browser")
    public void open_the_url_in_the_browser() {
 
    	 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit wait declairation
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://www.naaptol.com/shop-online/health-beauty.html");  
	
	
	
    }
    @And("Click on the Health and click on the painrelievers")
    public void click_on_the_health_and_click_on_the_painrelievers() {
        
    driver.findElement(By.cssSelector("[title=\"Health\"]")).click();
    driver.findElement(By.cssSelector("[title=\"Pain Relievers\"]")).click();
    	
    	
    }


	@And("Click on all the checkboxes present on the page and  enter the pincode")
	public void click_on_all_the_checkboxes_present_on_the_page_and_enter_the_pincode() {
		
		driver.findElement(By.id("iscod")).click();
		driver.findElement(By.name("isfreeship")).click();
		driver.findElement(By.xpath("//input[@id=\"pincode\"]")).sendKeys("413304");
		driver.findElement(By.xpath("//span[text()=\" Set \"]")).click();
	  
	}

	@Then("check the result and assert the message displayed")
	public void check_the_result_and_assert_the_message_displayed() {
		
		String actualmsg = driver.findElement(By.xpath("//div[contains(text(),'No product found for this filter combination, remove some of the filters to see products')]")).getText();
	    Assert.assertEquals(actualmsg,"No product found for this filter combination, remove some of the filters to see products");
	    
	}

	@When("click on the search bar and search pain relievers and assert the message displayed")
	public void click_on_the_search_bar_and_search_pain_relievers_and_assert_the_message_displayed() {
		
		
		driver.findElement(By.xpath("//input[@name=\"header_search_text\"]")).sendKeys("pain relievers");
		driver.findElement(By.xpath("(//div[@class=\"search\"])[2]")).click();
		
		String actualmsg = driver.findElement(By.xpath("//div[@class=\"errorMsg\"]")).getText();
	    Assert.assertEquals(actualmsg,"Either no product matches the word entered by you or please remove some of filter options selected to see products.");
		

	}

	@When("close the page")
	public void close_the_page() {
		
		driver.quit();
	
	}

}
