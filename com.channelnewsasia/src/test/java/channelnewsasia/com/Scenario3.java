package channelnewsasia.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scenario3 {

	@Test
	public static void fetchWeather()
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saxenas\\eclipse-workspace\\com.channelnewsasia\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
		driver.get("https://www.channelnewsasia.com/international");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//span[text()='+ All Sections']")).click();
		 driver.findElements(By.xpath("//*[@id='all-section-menu-modal']//a[text()='Weather']")).get(1).click();
		 String Condition=driver.findElement(By.xpath("//div[text()='singapore']//following-sibling::div[@class='tabular-list__view--condition']")).getText();
		 String Weather=driver.findElement(By.xpath("//div[text()='singapore']//following::div[2]/span[@class='tabular-list__view--temp--max']")).getText();

System.out.println("weather of singapore is "+Weather);

System.out.println("condition  of singapore is "+Condition);
		 
		
		 
	}

}
