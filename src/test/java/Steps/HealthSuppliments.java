package Steps;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HealthSuppliments {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	
	//public class Screenshot {
		
		private void capture(WebDriver driver, int n) throws IOException {
			//take screenshot interface and casting it to driver
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			//using getScreenshotAs() for taking the SS
			File image = ts.getScreenshotAs(OutputType.FILE);
			
			//create a new file for saving the SS and paste path over here
			File img = new File("C:\\Users\\DELL\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\Cucumber-testNG-project2\\Screenshots\\ss"+n+".png");
			
			//copying from my temporary variable to a file in local machine
			
			FileUtils.copyFile(image, img);
	
			
		}
	
	
	

@Given("Open url for naptol")
public void open_url_for_naptol() throws IOException {
	
	driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit wait declairation
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 actions = new Actions(driver);
	 driver.get("https://www.naaptol.com/shop-online/health-beauty.html");
	 capture(driver, 7);
   
}
	

	
@And("Open the Health section by clicking in health and click on the Health Suppliments")
public void open_the_health_section_by_clicking_in_health_and_click_on_the_health_suppliments() {
	
	driver.findElement(By.cssSelector("[title=\"Health\"]")).click();
	driver.findElement(By.cssSelector("[title=\"Health Supplements\"]")).click();
    
}

@When("Perform click actions on checkboxes avaliable for narrow result")
public void perform_click_actions_on_checkboxes_avaliable_for_narrow_result() throws IOException {
	
	driver.findElement(By.id("iscod")).click();
	driver.findElement(By.id("isexoutStock")).click();
	driver.findElement(By.id("isfreeship")).click();
	driver.findElement(By.id("pincode")).sendKeys("413304");
	driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();
	
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"Nutrigain Plus\"]")));
	

	driver.findElement(By.id("fromPriceRange")).sendKeys("500");
	driver.findElement(By.id("toPriceRange")).sendKeys("1000");
	driver.findElement(By.xpath("(//a[@class=\"button_1\"])[2]")).click();
	
	capture(driver, 8);
	
    
}

@When("Click on the product displayed perform some actions on that page")
public void click_on_the_product_displayed_perform_some_actions_on_that_page() throws InterruptedException {

	driver.findElement(By.xpath("//div[@class='item_image']//a")).click();
	  
}

@When("Add product to the cart and proceed to checkout")
public void add_product_to_the_cart_and_proceed_to_checkout() throws IOException {
	
	driver.findElement(By.xpath("//span[@id='header_search_shopping_cart_count']")).click();
	driver.findElement(By.xpath("//span[contains(text(),\"You have No Items in Cart !!! \")]"));
	Assert.assertEquals("No product found for this filter combination, remove some of the filters to see products",
			"No product found for this filter combination, remove some of the filters to see products");
	driver.findElement(By.xpath("//a[@title='Close']")).click();
	capture(driver, 9);
    
}

@Then("close the browser")
public void close_the_browser() {
	driver.navigate().to("https://www.naaptol.com/shop-online/health-beauty.html");
	driver.quit();
   
}


	

 

}
