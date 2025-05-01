package SeleniumPracties;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {
	
	
	
	@Test

	public void DragandDrop() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://obstaclecourse.tricentis.com/Obstacles/23292/retry");
		driver.manage().window().maximize();
		
		Actions a= new Actions(driver);
			
			a.dragAndDrop(driver.findElement(By.xpath("//table[@class=\"tasks\"]/tbody[1]/tr[3]/td[1]")), 
					driver.findElement(By.xpath("//table[@id='completed-tasks']/tbody/tr[2]/td"))).build().perform();
			
		
	}

}