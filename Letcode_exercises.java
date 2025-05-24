package NaveenAutomationLabs.NaveenAutomationSite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Letcode_exercises {

	public static void main(String[] args) {
		
		
		//sum all the item prices in a table 
		
		WebDriver driver = new ChromeDriver();	
		driver.get("https://letcode.in/table");
		int itemsSum = 0;
		List<WebElement> prices = driver.findElements(By.xpath("//table[@id='shopping']//tbody//td[2]"));
		for (WebElement itemPrice  : prices) {
			
			itemsSum += Integer.parseInt(itemPrice.getText());
	
		}
		
		
		 int itemsSubtotal = Integer.parseInt(driver.findElement(By.xpath("//table[@id='shopping']//tfoot//td[2]")).getText());
		// System.out.println(itemsSubtotal);
		 if(itemsSum == itemsSubtotal) {
			 System.out.println("true");
		 }
	
	}

}
