package SeleniumPracties;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class RowCount{
	
	@Test
	public void rowcount() {
	 WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
		driver.get("https://obstaclecourse.tricentis.com/Obstacles/41032/retry");
		List<WebElement> Rowcount = driver.findElements(By.xpath("//table[@id='rowCountTable']//tr"));
		System.out.println(Rowcount.size());
	}

}
