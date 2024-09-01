package Steps;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HealthCare {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait ;
	
	
	//public class Screenshot {
	
			private void capture(WebDriver driver) throws IOException {
				//take screenshot interface and casting it to driver
				TakesScreenshot ts = (TakesScreenshot)driver;
				
				//using getScreenshotAs() for taking the SS
				File image = ts.getScreenshotAs(OutputType.FILE);
				
				//create a new file for saving the SS and paste path over here
				File img = new File("C:\\Users\\DELL\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\Cucumber-testNG-project2\\Screenshots\\ss"+".png");
				
				//copying from my temporary variable to a file in local machine
				
				FileUtils.copyFile(image, img);
		
				
			}
			
	

@Given("Open the browser enter the url")
public void open_the_browser_enter_the_url() {
  
	
	driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit wait declairation
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 js = (JavascriptExecutor) driver;
	 driver.get("https://www.naaptol.com/shop-online/health-beauty.html");
	
	
	
}


	@Given("Click on the Health option to open healthcare tab")
	public void click_on_the_health_option_to_open_healthcare_tab() {
		
		driver.findElement(By.xpath("//a[@title=\"Health\"]")).click();
		driver.findElement(By.linkText("Health Care")).click();
	 
	}

     @When("Click on Search box and search for  Juicer check result displayed")
     public void click_on_search_box_and_search_for_juicer_check_result_displayed() {
    	 
    	 
    	 driver.findElement(By.id("header_search_text")).sendKeys("juicer");
    	 driver.findElement(By.xpath("(//div[@class=\"search\"])[2]")).click();
  
     }

	@When("Click on some of the checkboxes present in Narrow result")
	public void click_on_some_of_the_checkboxes_present_in_narrow_result() {
		
		
	
		driver.findElement(By.id("iscod")).click(); //click on cash on delivery
		
		driver.findElement(By.className("button_1")).click(); // click on set button
		
		
	   WebElement branded = driver.findElement(By.xpath("//input[@name=\"Branded\"]"));
	   js.executeScript("arguments[0].click()",branded );
	   
		

	}

	@When("Comapare two products")
	public void comapare_two_products() throws IOException {
		
		// click on the Perfect Portable Electric Grinder For All Spices & Masala 
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//input[@pimage=\"Powerful-Electric-Grinder-(EG7)-1.jpg\"]"))));
	    driver.findElement(By.xpath("//input[@pimage=\"Powerful-Electric-Grinder-(EG7)-1.jpg\"]")).click();
		
		
	    
	    //click on the Rechargeable Quick & Easy 5 Secs Vegetable Chopper (EC4)
	 
	    WebElement compare = driver.findElement(By.cssSelector("[pimage=\"Rechargeable-Quick-Fast-&-Easy-Vegetable-Chopper-(EC4)-1.jpg\"]"));
	    js.executeScript("arguments[0].click()", compare);
	    
	    capture(driver);
	    
	    
	    
	}

	@Then("Select Brand from dropdown")
	public void select_brand_from_dropdown() throws IOException {
		
		
		// clicking the compare now button by using java script executo
	    WebElement comaprebtn = driver.findElement(By.id("compareButton"));
	    js.executeScript("arguments[0].click()",comaprebtn );
	    
	    
		
		//click on select brand drop down for product 1	
	    WebElement Brand = driver.findElement(By.xpath("(//select[@class=\"dropDownCompare\"])[1]"));
		Select selectBrand = new Select(Brand);
		selectBrand.selectByVisibleText("Royal Chef");
		
		
		//click on the product for product 1
		
		driver.findElement(By.xpath("(//li[@pname=\"Rechargeable Blender with Power Bank\"])")).click();
		
		
		capture(driver);
	
	 
	}

	@Then("select product from dropdown")
	public void select_product_from_dropdown() throws IOException {
		

		//click on select brand drop down for product 2	
	    WebElement Brand2 = driver.findElement(By.cssSelector("[class=\"dropDownCompare\"]"));
		Select selectBrand2 = new Select(Brand2);
		selectBrand2.selectByVisibleText("Royal Chef");
		
		
		//click on the product for product 2
		
		driver.findElement(By.xpath("(//li[@pname=\"Royal Chef Cold Press Juicer\"])")).click();
		
		capture(driver);
		
  
	}

	@Then("Close the POPup window")
	public void close_the_po_pup_window() throws IOException {
		
		driver.findElement(By.cssSelector("[title=\"Close\"]")).click();
		
		capture(driver);
		
		driver.quit();
	
	}

	
	
	
	
	
	
	
	
	

}
