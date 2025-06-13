package NaveenAutomationLabs.NaveenAutomationSite;
import java.time.Duration;
import java.util.ArrayList;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class saucedemo_old {

	public static void main(String[] args) throws InterruptedException {		
		
		
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		 
		 JavascriptExecutor js = (JavascriptExecutor)driver;		 
		 driver.get("https://www.saucedemo.com/");
		 String pageTitle = driver.getTitle();
		 
		 Assert.assertEquals(pageTitle, "Swag Labs" , "Page title is incorrect");
						
		 String btnText = driver.findElement(By.id("login-button")).getDomAttribute("value");
		 
		 //if((btnText.substring(0,1).toUpperCase()+btnText.substring(1)).equals(btnText)) {
		 		 
		 if(btnText.equals(btnText.toUpperCase())) {
			 System.out.println("Button is capitalized!");
		 } else {		 
			 System.out.println("Button is not capitalized!");
		 }
				 
		 driver.findElement(By.id("user-name")).sendKeys("standard_user");
		 driver.findElement(By.id("password")).sendKeys("secret_sauce");
		 driver.findElement(By.id("login-button")).click();
		
		 WebElement selFil = driver.findElement(By.className("product_sort_container"));
		 
		 Select selFilter = new Select(selFil);
		 
		 
		 WebElement firstOption = selFilter.getFirstSelectedOption();	 
		 Assert.assertEquals(firstOption.getText(), "Name (A to Z)" , "The option A to Z is not selected");
		 
		/* if(firstOption.getText().equals("Name (A to Z)")) {
			 System.out.println("az is selected");
		 }
		 else {
			 System.out.println("az is not selected");
			 
		 }*/
		 
		 driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		 String cartNumber1 = driver.findElement(By.className("shopping_cart_badge")).getText();		 
		 Assert.assertEquals(cartNumber1, "1" , "items in cart doesn't equals 1");
		 
		 js.executeScript("window.scrollBy(0,400)");
		 driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();	 
		 js.executeScript("window.scrollBy(0,-600)");
		 		 
		 String increasedcartNumber = driver.findElement(By.className("shopping_cart_badge")).getText();			 
		 Assert.assertEquals(increasedcartNumber, "2" , "items in cart is not increased");
		 
		 driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		 
		 String updatedcartNumber = driver.findElement(By.className("shopping_cart_badge")).getText();
		 Assert.assertEquals(updatedcartNumber, "1" , "items in cart is not updated");
		
		 driver.findElement(By.className("shopping_cart_badge")).click();
		 
	     String selectedItemText = driver.findElement(By.cssSelector("a[id='item_3_title_link']>div")).getText();
	     	     
	     String cartItemslist = driver.findElement(By.cssSelector("a[id='item_3_title_link']>div")).getText();
	     
	     Assert.assertEquals(selectedItemText, cartItemslist , "items are in not in cart");
	     driver.findElement(By.id("continue-shopping")).click();
	     	     
	     WebElement sortFilter = driver.findElement(By.className("product_sort_container"));		 
		 Select sortFiltersel = new Select(sortFilter);
		 sortFiltersel.selectByValue("lohi");
		 
		////select[@class='product_sort_container']//option[@value='lohi']
	    
	     List<WebElement> itemsPrice = driver.findElements(By.className("inventory_item_price"));
	     
	     ArrayList<Double> priceList = new ArrayList();
	     	    
	     for (int i = 0 ; i < itemsPrice.size() ; i ++ ) {
	    	 
	    	 double individualPrice = Double.parseDouble( itemsPrice.get(i).getText().substring(1));	    			
	    	 priceList.add(individualPrice);
	    	     	
	     }  
	     
	     
	     //[4,5,6,45]
	    		 
	    		 
	     boolean isSorted = true;
	     for(int j = 0 ; j < priceList.size()-1 ; j ++) {
	    	 if(priceList.get(j) > priceList.get(j + 1)) {
	    		 isSorted = false;
	    		 break;	 
	    	 }
	    	 
	     }
	      
	     if(isSorted) {
	    	 System.out.println("items are sorted");
	     }else {
	    	 System.out.println("items are not sorted");
	     }
	     driver.close();
	}

	
}