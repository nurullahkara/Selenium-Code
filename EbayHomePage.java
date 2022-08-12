package seleniumTraining;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayHomePage {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/mrnuri/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.ebay.com/");
		driver.findElement(By.xpath("//input[@id='gh-ac']")).click();
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		List<WebElement> numberOfIphones = driver.findElements(By.cssSelector("h3[class='s-item__title']"));
		System.out.println(numberOfIphones.size());

		List<WebElement> productTitle = driver.findElements(By.cssSelector("h3[class='s-item__title']"));
		List<WebElement> productPrice = driver.findElements(By.cssSelector("span[class$='s-item__price']"));
		File file = new File("/Users/mrnuri/NuriEbay.txt");
		PrintStream stream = new PrintStream(file);
		for (int i = 1; i < numberOfIphones.size(); i++) {
			System.setOut(stream);
			System.out.println(i + ".Product title: " + productTitle.get(i).getText() + "Product Price: \n"
					+ productPrice.get(i).getText());

		}

		System.out.println("Succesfully printed");
		driver.close();

	}

}
