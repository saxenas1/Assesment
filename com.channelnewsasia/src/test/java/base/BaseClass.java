package base;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
		try // FilenotException
		{
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\OR.properties");
			OR.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
