package curso_selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrimeFaces {
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void init(){
		System.setProperty("webdriver.chrome.driver", "\\Users\\priscila.franca\\Downloads\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		System.getProperty("user.dir");
		dsl = new DSL(driver);
		}
	
	@After
	public void fim() {
		//driver.quit();
	}
	
	
	@Test
	public void radioPrime() {
		dsl.clicarRadio(By.xpath("//input[@id='j_idt86:console:0']/../..//span"));
		//dsl.clicar("j_idt701:console:0");
	}

}
