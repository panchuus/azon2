package demo.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon {
	
	public WebDriver driver;
	public WebDriver amazonwebsite()
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Panchami S Kamath\\Downloads\\chromedriver.exe");
	    driver = new ChromeDriver(); 
	    return driver;
	}


}
