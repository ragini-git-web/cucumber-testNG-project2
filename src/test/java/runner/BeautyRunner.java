package runner;




import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions
(features = "C:\\Users\\DELL\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\Cucumber-testNG-project2\\src\\test\\resources\\FeatureFile\\Beauty.feature",
glue = "Steps")

public class BeautyRunner extends AbstractTestNGCucumberTests {

}
