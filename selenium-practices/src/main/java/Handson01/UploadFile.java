package Handson01;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.foundit.in/upload");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[contains(text(),'Upload Resume')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1)Upload file with sendKeys() Method we are just bypassing the process with out handling elements
		//driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\SHAIKJ\\Desktop\\my work\\selenium testing\\fileuploading.txt");
		
		//2) Using Robot class 
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@id='file-upload']")));
		
		//2.1) Copy the file path into click board (Ctrl+c)
			StringSelection filePathSelection = new StringSelection("C:\\Users\\SHAIKJ\\Desktop\\my work\\selenium testing\\fileuploading.txt");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);
		    
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		// 2.2) Ctrl + V
		    
		    Robot rb=new Robot();
		    
		    rb.keyPress(KeyEvent.VK_CONTROL);
		    rb.keyPress(KeyEvent.VK_V);
		    rb.keyRelease(KeyEvent.VK_V);
		    rb.keyRelease(KeyEvent.VK_CONTROL);
		    
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		
		//2.3) Click on return/enter Key 
		    rb.keyPress(KeyEvent.VK_ENTER);
		    rb.keyRelease(KeyEvent.VK_ENTER);
	}

}
