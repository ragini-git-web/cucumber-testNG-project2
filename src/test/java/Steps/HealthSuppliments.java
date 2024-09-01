package Steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HealthSuppliments {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	

@Given("Open url for naptol")
public void open_url_for_naptol() {
	
	driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit wait declairation
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://www.naaptol.com/shop-online/health-beauty.html");
   
}
	

	
@And("Open the Health section by clicking in health and click on the Health Suppliments")
public void open_the_health_section_by_clicking_in_health_and_click_on_the_health_suppliments() {
	
	driver.findElement(By.cssSelector("[title=\"Health\"]")).click();
	driver.findElement(By.cssSelector("[title=\"Health Supplements\"]")).click();
    
}

@When("Perform click actions on checkboxes avaliable for narrow result")
public void perform_click_actions_on_checkboxes_avaliable_for_narrow_result() {
	
	driver.findElement(By.id("iscod")).click();
	driver.findElement(By.id("isexoutStock")).click();
	driver.findElement(By.id("isfreeship")).click();
	driver.findElement(By.id("pincode")).sendKeys("413304");
	driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();
	
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"Nutrigain Plus\"]")));
	

	driver.findElement(By.id("fromPriceRange")).sendKeys("500");
	driver.findElement(By.id("toPriceRange")).sendKeys("1000");
	driver.findElement(By.xpath("(//a[@class=\"button_1\"])[2]")).click();
	
	
    
}

@When("Click on the product displayed perform some actions on that page")
public void click_on_the_product_displayed_perform_some_actions_on_that_page() throws InterruptedException {
	

	//driver.findElement(By.cssSelector("[class=\"square\"]")).click();
	
//	Actions actions = new Actions(driver);
//	
//	            
//	WebElement clickproduxt = driver.findElement(By.xpath("//a[normalize-space()='Nutrigain Plus Powder & Nutrigain Plus Capsule']"));
//	WebElement quickview = driver.findElement(By.id("quickViewId1"));
//	
//	actions.moveToElement(clickproduxt).moveToElement(quickview).click().build().perform();

	//wait.until(ExpectedConditions.elementToBeSelected(By.id("quickViewId1")));

	driver.findElement(By.xpath("//a[normalize-space()='Nutrigain Plus Powder & Nutrigain Plus Capsule']"));
	
	

  
}

@When("Add product to the cart and proceed to checkout")
public void add_product_to_the_cart_and_proceed_to_checkout() {
	
	
	driver.findElement(By.xpath("(//a[@title=\"Buy online\"])")).click();
    
}

@Then("close the browser")
public void close_the_browser() {
	
	driver.quit();
   
}


	

 

}
