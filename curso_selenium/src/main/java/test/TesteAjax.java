package test;
import static core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DSL;

public class TesteAjax {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void init(){
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		}
	
	@After
	public void fim() {
		driver.quit();
	}
	
	@Test
	public void testeEsperaAjax() {
		dsl.escrever("j_idt709:name", "hello");
		dsl.clicar("j_idt709:j_idt712");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt709:display"), "hello"));
		Assert.assertEquals("hello", dsl.obterTexto("j_idt709:display"));
	}
}
