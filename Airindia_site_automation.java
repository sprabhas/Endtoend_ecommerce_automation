package NaveenAutomationLabs.NaveenAutomationSite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Airindia_site_automation {

	public static void main(String[] args) throws InterruptedException {
		
		int i = 3;		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='dropdownGroup1']//div[@class='dropdownDiv']//a[@value='IXB']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='dropdownGroup1']//div[@class='dropdownDiv']//a[@value='DED']")).click();
		
		driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//a[text()='14']")).click();
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//a[text()='15']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> suggItems = driver.findElements(By.cssSelector("a[class='ui-corner-all'"));
		
		for (WebElement option : suggItems ) {
			//option contains the individual elements
			if(option.getText().equalsIgnoreCase("India")) {
				//System.out.println(option.getText());
				option.click();
				break;	
			}
		}
		
		driver.findElement(By.id("divpaxinfo")).click();		
			while (i >= 0) {
				driver.findElement(By.id("hrefIncAdt")).click();
				i--;			
			}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
	}

}
