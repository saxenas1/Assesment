package channelnewsasia.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pages.InternationalPage;
import pages.LandingPage;
import pages.WeatherPage;

public class Scenario1 extends BaseClass {
	@Test(enabled=false)
	public void Scenario1method() throws InterruptedException {
		// Navigate to https://www.channelnewsasia.com/
		driver.get("https://www.channelnewsasia.com/");
		InternationalPage ip = new InternationalPage();
		String headline = ip.getHeadline();

		SoftAssert softAssertion = new SoftAssert();

		// Validate the headline new item Title

		softAssertion.assertEquals(headline,
				"US stands with allies, partners in face of China's 'threats', says Harris");

		// Click on the Headline Item title and navigate to the actual story.
		LandingPage lp= new LandingPage();
		lp.navigateToHeadline();

		// System.out.println(driver.getTitle());
		String expectedTitle = headline + " - CNA";

		// Once in the Headline full news item detail page, verify if we are on the
		// expected news item.
		softAssertion.assertEquals(driver.getTitle(), expectedTitle);

		// Scroll to the bottom of the screen and wait for AJAX to load more news items.
		ip.scrolltoEnd();

		List<WebElement> newsItem = driver.findElements(By.xpath("//h1[@class='h1 h1--page-title']"));

		System.out.println(newsItem.get(2).getText());
		headline = newsItem.get(2).getText();

		// Click on “Read Full Story” of the second news item and verify that the Title
		// matches the same Title
		softAssertion.assertEquals(driver.getTitle(), headline);
		softAssertion.assertAll();
		System.out.println("Done");

	}

	@Test(enabled=true)
	public void Scenario2method() throws InterruptedException {

		driver.get("https://www.channelnewsasia.com/international");
		LandingPage lp1 = new LandingPage();
		InternationalPage Ip= new InternationalPage();
		String Headline = lp1.navigateToSingapore();
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(Headline,
				"111 new locally transmitted COVID-19 cases in Singapore, including 24 linked to dormitory in Woodlands",
				"Ensure headlines are expected");
		softAssertion.assertAll();
		driver.findElement(By.xpath(OR.getProperty("Headline"))).click();
		Ip.scrolltoEnd();
		List<WebElement> newsItem = driver.findElements(By.xpath("//h1[@class='h1 h1--page-title']"));

		System.out.println(newsItem.get(2).getText());
		Headline = newsItem.get(2).getText();

		// Click on “Read Full Story” of the second news item and verify that the Title
		// matches the same Title
		softAssertion.assertEquals(driver.getTitle(), Headline);
		softAssertion.assertAll();
		System.out.println("Done");
	}

	@Test(enabled = false)
	public void fetchWeather() {

		driver.get("https://www.channelnewsasia.com/international");
		System.out.println("S1");
		LandingPage lp = new LandingPage();
		lp.navigateToWeather();
		WeatherPage wp = new WeatherPage();
		String Weather = wp.getCondition();
		String Condition = wp.getWeather();
		System.out.println("weather of singapore is " + Weather);
		System.out.println("condition  of singapore is " + Condition);

	}

}
