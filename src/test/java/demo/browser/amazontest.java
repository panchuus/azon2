package demo.browser;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class amazontest extends amazon {
	@Test
	public void basePageNavigation() throws IOException {
		driver = amazonwebsite();
		System.out.println("Opening the browser");
		driver.get("https://www.amazon.in/");
		// Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");

	}

	@Test(dependsOnMethods = { "basePageNavigation" })
	public void amazonSelenium() throws InterruptedException {
		Thread.sleep(2000);
		  Thread.sleep(2000);
		    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Refrigerator");
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);

			Thread.sleep(4000);

			
			int count = driver.findElements(By.cssSelector("span.a-size-base.a-color-base")).size();

		
			//Price
			int c = driver.findElements(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal")).size();
			String price1 = "Hey";
			String link=" ";
			for (int i = 0; i < c; i++) {
				String text = driver.findElements(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal")).get(i)
						.getText();
				if (text.contains("Samsung 198 L 4")) {
					price1 = driver.findElements(By.cssSelector("span.a-price-whole")).get(i).getText();
					break;

				}

			}
			
			//Link
			int cc = driver.findElements(By.cssSelector("a.a-link-normal.a-text-normal")).size();
			for(int i=0;i<cc;i++)
			{
				String text = driver.findElements(By.cssSelector("a.a-link-normal.a-text-normal")).get(i).getText();
				if(text.contains("Samsung 198 L 4"))
				{
					link=driver.findElements(By.cssSelector("a.a-link-normal.a-text-normal")).get(i).getAttribute("href");
					break;
				}
							
			}
			
			Thread.sleep(1000);
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.manage().window().maximize();

			driver.get(link);
			
			
			Thread.sleep(5000);
			
			
			//Compare the price
			String price2   =   driver.findElement(By.cssSelector("span#priceblock_ourprice")).getText();
			
			
			if(price2.contains(price1))
			{
				System.out.println("Matches the price");
			}
			else {
				System.out.println("No Match");
			}
			
			
			//Capacity
			 String cap="";
	         int c2 = driver.findElements(By.cssSelector("th.a-color-secondary.a-size-base.prodDetSectionEntry")).size();
	         for(int i=0;i<c2;i++)
	         {
	         	
	         	String capacity = driver.findElements(By.cssSelector("th.a-color-secondary.a-size-base.prodDetSectionEntry")).get(i).getText();
	         	if(capacity.equalsIgnoreCase("Capacity"))
	         	{
	         		   cap = driver.findElements(By.cssSelector("td.a-size-base.prodDetAttrValue")).get(i).getText();
	         		   System.out.println("The capacity is"+" "+cap);
	         		   break;
	         	}
	         }
	         
	         
	         //Item Weight
	          int c3  = driver.findElements(By.cssSelector("tr.comparison_other_attribute_row   span.a-size-base.a-color-base")).size();
	          for(int i=0;i<c3;i++)
	          {
	         	 String itemweight =  driver.findElements(By.cssSelector("tr.comparison_other_attribute_row   span.a-size-base.a-color-base")).get(i).getText();
	         	 if(itemweight.equalsIgnoreCase("Item Weight"))
	         	 {
	         		  for(int k=i+1;k<i+5;k++)
	         		  {
	         			    String weight =   driver.findElements(By.cssSelector("tr.comparison_other_attribute_row   span.a-size-base.a-color-base")).get(k).getText();
	         			    System.out.println("The item weight is"+" "+weight);
	         		  }
	         			  
	         		  break;
	         	 }
	          }
			
			
		    
			

		}

		//System.out.println(link);
		
		


	

	@AfterTest
	public void success() {
		System.out.println("Amazon  on ChromeBrowser worked sucessfully worked ");
	}

}
