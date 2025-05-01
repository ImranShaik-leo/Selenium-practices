package Handson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableOpertion {
	
	 static ExtentReports extent;
	 ExtentTest test;
	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Spark.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		
		//1)How many rows are there in a table 
		
	int Rowcount =driver.findElements(By.xpath("//table[@id='countries']/tbody/tr")).size();
	System.out.println("Total number of rows"+ Rowcount);//197
	
		//2)How many columns are there in table 
	
	int columns =driver.findElements(By.xpath("//table[@id='countries']/tbody/tr[1]/td")).size();
	System.out.println("Total number of columns"+ columns);//5
	
		//3)Retrieve the specific row/columns data
	 String value = driver.findElement(By.xpath("//table[@id='countries']/tbody/tr[4]/td[2]")).getText();
	 System.out.println("The value is "+ value);
	 
	 	//4)retriever all the data from the table
	 	
	/* System.out.println("Printing table ");
	 	for(int r=1;r<=Rowcount;r++)  //Rows
	 	{
	 		for(int c=1;c<=columns;c++) //columns
	 		{
	 			 String data = driver.findElement(By.xpath("//table[@id='countries']/tbody/tr["+r+"]/td["+c+"]")).getText();
	 			 System.out.println(data+"      ");
	 		}
	 		System.out.println();	 		
	 	}*/
	 // 5)fetch values from the table for particluer data 
	 
	 	for(int r=1;r<=Rowcount;r++) {
	 		 String Counter = driver.findElement(By.xpath("//table[@id='countries']/tbody/tr["+r+"]/td[2]")).getText();
	 		 if(Counter.equals("India")) {
	 			String capital = driver.findElement(By.xpath("//table[@id='countries']/tbody/tr["+r+"]/td[3]")).getText(); 
	 			String currency = driver.findElement(By.xpath("//table[@id='countries']/tbody/tr["+r+"]/td[4]")).getText();
	 			System.out.println(Counter+"   "+capital+"    "+currency);
	 			driver.findElement(By.xpath("//table[@id='countries']/tbody/tr["+r+"]/td[1]")).click();
	 		 }
	 	}
	 	
	driver.quit();
	
	}

}
