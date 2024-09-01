package Steps;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class OralCare {
	
	WebDriver driver;
	WebDriverWait wait ;
	JavascriptExecutor js;
	Actions actions;
	
	//public class Screenshot {
		
//		private void capture(WebDriver driver) throws IOException {
//			//take screenshot interface and casting it to driver
//			TakesScreenshot ts = (TakesScreenshot)driver;
//			
//			//using getScreenshotAs() for taking the SS
//			File image = ts.getScreenshotAs(OutputType.FILE);
//			
//			//create a new file for saving the SS and paste path over here
//			File img = new File("C:\\Users\\DELL\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\Cucumber-testNG-project2\\Screenshots\\ss"+".png");
//			
//			//copying from my temporary variable to a file in local machine
//			
//			FileUtils.copyFile(image, img);
//	
//			
//		}
		
		
		@Given("Open the given applications url and open the oral care feature")
		public void open_the_given_applications_url_and_open_the_oral_care_feature()  {
		   
			
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit wait declairation
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 js = (JavascriptExecutor) driver;
			 actions = new Actions(driver);
		
		      driver.get("https://www.naaptol.com/shop-online/health-beauty.html"); 
			 
			 
			 driver.findElement(By.xpath("(//a[@title=\"Beauty\"])[1]")).click();
			 
			 driver.findElement(By.xpath("//a[@title='Oral Care']")).click();
			
			
			
			
		}

		@And("Click on all the checkboxes and clear all the filters")
		public void click_on_all_the_checkboxes_and_clear_all_the_filters() throws IOException {
			
			
			driver.findElement(By.id("iscod")).click(); // click on cod
			driver.findElement(By.id("isexoutStock")).click(); // click  on the exclude out of stock
			driver.findElement(By.id("isfreeship")).click();// click on the product with free shipping
			driver.findElement(By.id("pincode")).sendKeys("413304"); // enter the pin code
			driver.findElement(By.xpath("(//a[@href=\"javascript:void(0);\"])[1]")).click();//click on the set
			driver.findElement(By.id("isfreeship")).click();// Un click on the product with free shipping
			driver.findElement(By.xpath("(//a[@href=\"javascript:void(0);\"])[1]")).click();//click on the set
			
			driver.findElement(By.id("brandFilterBox38949")).click(); // click on the panchvati herbals
			
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.name("Greyson"))));
			driver.findElement(By.name("Greyson")).click();//click on the greysons
			
			 WebElement priceby = driver.findElement(By.name("299 - 499"));// click on 299-499
			 js.executeScript("arguments[0].click()",priceby );
			 
			// capture(driver);
			
		     WebElement clearall = driver.findElement(By.xpath("(//a[@class=\"sml_link\"])[2]"));//clear the search
		     js.executeScript("arguments[0].click()",clearall );
			
		    
			
		    
		}

		@When("Sort product by Most Expensive")
		public void sort_product_by_most_expensive() throws IOException {
			
			// handle the sort by dropdown 
			
			WebElement dropdowm = driver.findElement(By.id("sortByFilter"));
			Select s = new Select(dropdowm);
			s.selectByVisibleText("Most Expensive");
			
			// add the  first product to the card
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.linkText("Teeth Whitening & Stain Remover Pen"))));
			driver.findElement(By.linkText("Teeth Whitening & Stain Remover Pen")).click();
			
			//capture(driver);
			
		    
		}


		@And("close the Window")
		public void close_the_window() throws IOException {
			
			driver.navigate().to("https://www.naaptol.com/");
			
			//capture(driver);
			
			
			driver.quit();
		
		}	
		
		
		
		
		
		
	
	
	
	

}
