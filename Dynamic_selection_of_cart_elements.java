package NaveenAutomationLabs.NaveenAutomationSite;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_selection_of_cart_elements {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		String[] selectedProd = {"MacBook" ,"iPhone"};
		List<String> selectedProdList = Arrays.asList(selectedProd);
		int j = 0;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://naveenautomationlabs.com/opencart/index.php");
		
		List<WebElement> prodList = driver.findElements(By.xpath("//h4//a"));
		//System.out.println(prodList);
		
		for(int i = 0 ; i<prodList.size(); i ++) {
			j++;
			
			String individualProd = prodList.get(i).getText();
			//System.out.println(individualProd);
			if(selectedProdList.contains(individualProd)) {
				
				driver.findElements(By.xpath("//div[@class='caption']//following-sibling::div//button[@type='button']//i[@class='fa fa-shopping-cart']")).get(i).click();
				//System.out.println(selectedProdList.size());
				if (j == selectedProdList.size() ) {
					break;	
				}
			}
		}
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div[id='cart']>button[type='button']")).click();
		//Thread.sleep(1000);
		driver.findElement(By.cssSelector("p[class='text-right']>a[href*='/cart']")).click();
		
		driver.findElement(By.cssSelector("div[class='pull-right']>a[href*='/checkout']")).click();
		
		List<WebElement> checkoutProd = driver.findElements(By.xpath("//td[@class='text-left']//span[@class='text-danger']"));
		
		WebElement errMsg = driver.findElement(By.cssSelector("div[class='alert alert-danger alert-dismissible']"));
		boolean flag = errMsg.isDisplayed();
		
		if(flag == true) {
		
			for (int i = 0 ; i < checkoutProd.size() ; i ++) {
				
				//System.out.println(checkoutProd.size());
				if(checkoutProd.get(i).isDisplayed() == true ) {
					//System.out.println("aa");
					driver.findElements(By.cssSelector("button[data-original-title='Remove']")).get(i).click();
					break;
				}
				
			}
		} 
			
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href*='/checkout']")).click();
		
		
		
	}

}
