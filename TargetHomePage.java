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

public class TargetHomePage {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/mrnuri/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.target.com/");
		driver.findElement(By.cssSelector("#search")).click();
		driver.get("https://www.target.com/");
		driver.findElement(By.cssSelector("#search")).sendKeys("iphone");
		driver.findElement(By.cssSelector("button[aria-label='go']")).click();
	List<WebElement> noOfProducts=driver.findElements(By.cssSelector("a[data-test$='product-title']"));
	List<WebElement> ProductTitle=driver.findElements(By.cssSelector("a[data-test$='product-title']"));
	List<WebElement> ProductPrice=driver.findElements(By.cssSelector("div[data-test*='current-price']"));
	File file = new File("/Users/mrnuri/Target.txt");
	PrintStream stream = new PrintStream(file);

	for (int i = 1; i <noOfProducts.size(); i++) {
		System.setOut(stream);
		System.out.println(i + ".Product title: " + ProductTitle.get(i).getText() + "Product Price: \n"
				+ ProductPrice.get(i).getText());

	}

driver.close();
	
	}

}
