package StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.Iterator;
import java.util.Set;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LandingPagestepdefinition {
	public WebDriver driver;
	public String offerPageProductName;
	public String landingPageProductName;
	
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
	    
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	
	@When("user searched with shortname {string} and extracted actual name of the product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
		driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys(shortName);
		Thread.sleep(2000);
		landingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(landingPageProductName + "is extraced from home page");
		
	}
	
	
	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
	    // offer page -> enter -> grab text
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> s1= driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		String ParentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys(shortName);
		 offerPageProductName=driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
				
	}
	
	@Then("validate product name in offfers page matches with landing page")
	public void validate_product_name_in_offfers_page_matches_with_landing_page()
	{
		Assert.assertEquals(offerPageProductName, landingPageProductName);
	}
	
	
}
	

