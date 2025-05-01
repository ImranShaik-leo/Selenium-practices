package SeleniumPracties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicElements {

	@Test
	public void dynamicElement() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	    driver.get("https://obstaclecourse.tricentis.com/Obstacles/64161?retry=1");
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//a[@id='generate']"));
	    
	    //div[contains(@id,'lele')]
	    //div[start-with(@id,'lele')]
	    //div[contains(text(),'lele')]
	    
	
	
	
	}
}
