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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Beauty {
	
	WebDriver driver;
	WebDriverWait wait ;
	JavascriptExecutor js;
	Actions actions;
	
//	
//	//public class Screenshot {
//		
//		private void capture(WebDriver driver, int n) throws IOException {
//			//take screenshot interface and casting it to driver
//			TakesScreenshot ts = (TakesScreenshot)driver;
//			
//			//using getScreenshotAs() for taking the SS
//			File image = ts.getScreenshotAs(OutputType.FILE);
//			
//			//create a new file for saving the SS and paste path over here
//			File img = new File("C:\\Users\\DELL\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\Cucumber-testNG-project2\\Screenshots\\ss"+n+".png");
//			
//			//copying from my temporary variable to a file in local machine
//			
//			FileUtils.copyFile(image, img);
//	
//			
//		}
//		

		

@Given("Open Url in the browser and click on the Beauty and open Beauty tab")
public void open_url_in_the_browser_and_click_on_the_beauty_and_open_beauty_tab1() throws IOException {
	
	 driver = new ChromeDriver();
	
	 
	 driver.manage().window().maximize();
	 
	 wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit wait declairation
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	 js = (JavascriptExecutor) driver;
	 
	 driver.get("https://www.naaptol.com/shop-online/health-beauty.html"); 
 
	 
	 
	 driver.findElement(By.xpath("(//a[@title=\"Beauty\"])[1]")).click();
	 driver.findElement(By.xpath("(//a[@title=\"Beauty\"])")).click();
	
	// capture(driver , 1);
	 
}
@And ("Click on the checkboxes in beauty")
public void click_on_the_checkboxes_in_beauty1() throws IOException {
	

	driver.findElement(By.id("iscod")).click();//click on check box With Cash On Delivery
//	test.log(LogStatus.PASS, "Click On the Cash on delivery checkBox");
	
	driver.findElement(By.id("isexoutStock")).click(); // click on Exclude out of stock
//	test.log(LogStatus.PASS, " click on Exclude out of stock");
	
	driver.findElement(By.id("isfreeship")).click(); // click on product with free shipping
//	test.log(LogStatus.PASS, "click on product with free shipping");
	
	driver.findElement(By.cssSelector("[onclick=\"productSearch.setPersonalisedFilter(false);\"]")).click();// click on set
//	test.log(LogStatus.PASS, "click on set button");
	
	driver.findElement(By.id("isfreeship")).click();// Un-click on product with free shipping
//	test.log(LogStatus.PASS, "");
	
	driver.findElement(By.cssSelector("[onclick=\"productSearch.setPersonalisedFilter(false);\"]")).click();// click on set
	//test.log(LogStatus.PASS, "Un-click on product with free shipping");
	
	driver.findElement(By.id("brandFilterBox8313")).click(); // click on branded[3]
//	test.log(LogStatus.PASS, "");
	
	wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("brandFilterBox38949"))));
	driver.findElement(By.id("brandFilterBox38949")).click();// click on Panchvati herbals
//	test.log(LogStatus.PASS, " click on branded[3]");
	
	wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("brandFilterBox38964"))));
	driver.findElement(By.id("brandFilterBox38964")).click();//click on the ayurjeet
//	test.log(LogStatus.PASS, "click on the ayurjeet");
	
	wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("brandFilterBox39057"))));
	driver.findElement(By.id("brandFilterBox39057")).click();//click on the seer secrets
//	test.log(LogStatus.PASS, "click on the seer secrets");
	
	wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("brandFilterBox39073"))));
	driver.findElement(By.id("brandFilterBox39073")).click();//click on dr ortho
//	test.log(LogStatus.PASS, "click on dr ortho");
	
	wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.name("299 - 499"))));
	driver.findElement(By.name("299 - 499")).click();//click on the search by price 299-399
//	test.log(LogStatus.PASS, "click on the search by price 299-399");
	
	wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("discountFilterBox2"))));
	driver.findElement(By.id("discountFilterBox2")).click();//click on the search by discount 30%-40%
	//test.log(LogStatus.PASS, "click on the search by discount 30%-40%");
	
	wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("discountFilterBox3"))));
    driver.findElement(By.id("discountFilterBox3")).click();//click on the search by discount 40%-0%
//    test.log(LogStatus.PASS, "click on the search by discount 40%-0%");
    
	//capture(driver, 2);
		
	

	
   
}
@When("Scroll down to the page and close the window")
public void scroll_down_to_the_page_and_close_the_window1() throws IOException {
	
	
	
	// scroll the page till element is visible
	WebElement ele = driver.findElement(By.xpath("//h3[contains(text(),\"Buy Beauty\")]"));
	js.executeScript("arguments[0].scrollIntoView()",ele);
//	test.log(LogStatus.PASS, "Scrolling the Page Till the Buy Beauty Element Found ");
	
	
	System.out.println(js.executeScript("return window.pageYOffset;"));


   
	 //   capture(driver, 3);
	    
	    driver.quit();
	    
	 
   
}	


}
