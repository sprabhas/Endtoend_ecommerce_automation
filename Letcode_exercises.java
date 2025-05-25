package NaveenAutomationLabs.NaveenAutomationSite;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class Letcode_exercises {

	public static void main(String[] args) {
		
		//Ex - 1
		//sum all the item prices in a table 
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		/*driver.get("https://letcode.in/table");
		int itemsSum = 0;
		List<WebElement> prices = driver.findElements(By.xpath("//table[@id='shopping']//tbody//td[2]"));
		for (WebElement itemPrice  : prices) {
			
			itemsSum += Integer.parseInt(itemPrice.getText());
	
		}
		
		 int itemsSubtotal = Integer.parseInt(driver.findElement(By.xpath("//table[@id='shopping']//tfoot//td[2]")).getText());
		// System.out.println(itemsSubtotal);
		 if(itemsSum == itemsSubtotal) {
			 System.out.println("true");
		 }*/
		 
		 //Ex - 2
		 // Click on an element having property like name and title	 
		 //input[@value='I am good' and @placeholder='Enter ']
	
		//Ex - 3
		// switch between windows
		
		driver.get("https://letcode.in/test");
		
		js.executeScript("window.scrollBy(0, 500)");
		
		//selecting by link text
		driver.findElement(By.linkText("Tabs")).click();
		driver.findElement(By.id("home")).click();
		
		driver.findElement(By.id("multi")).click();
		//System.out.println(driver.getTitle());
				
		String parentWindow = driver.getWindowHandle();
		
		Set<String> windowsList = driver.getWindowHandles();
		
		for (String individualWindows : windowsList) {
			if(!parentWindow.equals(individualWindows)) {
				
				driver.switchTo().window(individualWindows);
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				driver.close();
				
			}
			
		}		
	}

}


