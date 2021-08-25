package channelnewsasia.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Scenario2 {

	@Test
	public void Scenario2method()
	{

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\saxenas\\eclipse-workspace\\com.channelnewsasia\\src\\test\\resources\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
			driver.get("https://www.channelnewsasia.com/international");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//ul[@class='main-menu']//a[text()='Singapore']")).click();
			String Headline = driver
					.findElement(By.xpath("//a[@class='h3__link h3__link-- list-object__heading-link']")).getText();

			SoftAssert softAssertion = new SoftAssert();
			softAssertion.assertEquals(Headline,
					"111 new locally transmitted COVID-19 cases in Singapore, including 24 linked to dormitory in Woodlands",
					"Ensure headlines are expected");

			softAssertion.assertAll();

		}
	}

