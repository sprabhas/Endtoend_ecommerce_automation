package NaveenAutomationLabs.NaveenAutomationSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Register_page {

	public static void main(String[] args) throws InterruptedException {
		
		//navigating to the web browser
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php");
		
		driver.findElement(By.cssSelector("a[title='My Account']")).click();
		
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")).click();
			
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']
		
		//entering the values for user registration
		driver.findElement(By.id("input-firstname")).sendKeys("Muthu Prabha");
		driver.findElement(By.id("input-lastname")).sendKeys("S");
		driver.findElement(By.id("input-email")).sendKeys("sprabhashankar2429@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("63808 67604");
		driver.findElement(By.id("input-password")).sendKeys("prabha123");
		driver.findElement(By.id("input-confirm")).sendKeys("prabha123");
		
		//locating the radio button
		driver.findElement(By.xpath("//label[@class='radio-inline']//input[@value='1']")).click();
		//locating the checkbox
		driver.findElement(By.name("agree")).click();
		
		driver.findElement(By.cssSelector("input[value='Continue']")).click();
		//driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();
		
		WebElement emailExists = driver.findElement(By.cssSelector("div[class='alert alert-danger alert-dismissible']"));
		boolean flag = emailExists.isDisplayed();
		
		if(flag == true) {
			//login flow
			driver.findElement(By.xpath("//a[text()='login page']")).click();
		}		
		
		
		driver.findElement(By.id("input-email")).sendKeys("sprabhashankar2429@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("prabha123");
		driver.findElement(By.cssSelector("input[value='Login'")).click();
		
		//searching elements on the search box
		driver.findElement(By.cssSelector("input[name='search']")).sendKeys("Sony VAIO");
		
		//driver.findElement(By.className(".btn btn-default btn-lg")).click();
		driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']")).click();
		
		driver.findElement(By.xpath("//button//span[text()='Add to Cart']")).click();
				
		driver.findElement(By.cssSelector("a[href*='/cart']")).click();
		
		driver.findElement(By.cssSelector("a[href*='/checkout']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("input-payment-firstname")).sendKeys("Muthu Prabha");
		
		
		driver.findElement(By.id("input-payment-lastname")).sendKeys("S");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("Purasaiwalkam high road , kellys");
		driver.findElement(By.id("input-payment-city")).sendKeys("chennai");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("600010");
		
		Select country = new Select (driver.findElement(By.id("input-payment-country")));
		country.selectByVisibleText("Mauritius");
		
		Thread.sleep(1000);
		Select zone = new Select (driver.findElement(By.id("input-payment-zone")));
		zone.selectByVisibleText("Black River");
		
		//driver.findElement(By.id("button-payment-address")).click();
	
		Select selele = new Select (driver.findElement(By.name("address_id")));
		selele.selectByValue("9769");
		
		driver.findElement(By.id("button-payment-address")).click();

		
		
		
	}

}
