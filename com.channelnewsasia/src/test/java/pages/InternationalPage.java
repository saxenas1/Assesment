package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import base.BaseClass;

public class InternationalPage extends BaseClass {

	public String getHeadline() {
		String headLine = driver
				.findElement(By.xpath(OR.getProperty("HeadlineMainPage"))).getText();
		return headLine;
	}

	

	public void scrolltoEnd() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// boolean flag = true;
		int i = 1;
		while (i < 50) {
			js.executeScript("window.scrollBy(0,250)", "");
			i++;
			Thread.sleep(1000);

		}

	}

}
