package java_test_pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTestClass {

	public static WebDriver driver;

	public void invokeBrowser(String url) {
		try {
			System.setProperty("webdriver.firfox.driver",
					"E:\\ProgramsWindows\\SeleniumTools\\geckodriver-v0.32.0-win32\\geckodriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JavascriptExecutor jse;
		try {
			JavaTestClass ins = new JavaTestClass();
			ins.invokeBrowser("https://www.amazon.eg/");
			Thread.sleep(2000);
			//input data into Text field
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("cosmotics");
			Thread.sleep(1000);
			//click button
			driver.findElement(By.id("nav-search-submit-button")).click();
			Thread.sleep(1000);
			//click Check box
			driver.findElement(By.id("p_n_free_shipping_eligible/21909080031")).click();
			Thread.sleep(1000);
			//Execute JavaScript command scroll 
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0,3000)");
			Thread.sleep(1000);
			//Navigate to the previous page
			driver.navigate().back();
			Thread.sleep(3500);
			//Click an Image
			driver.findElement(By.id("nav-logo-sprites")).click();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
