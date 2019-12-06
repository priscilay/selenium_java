package test;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import core.DSL;

public class TestePrimeFaces {
	private DSL dsl;
	
	@Before
	public void init(){
		dsl = new DSL();
		}
	
	@After
	public void fim() {
		killDriver();
	}
	
	@Test
	public void radioPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicarRadio(By.xpath("//input[@id='j_idt701:console:0']/../..//span"));
		Assert.assertTrue(dsl.radioMarcado("j_idt701:console:0"));
		dsl.clicarRadio(By.xpath(".//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.radioMarcado("j_idt701:console:1"));
	}
	
	@Test
	public void selectPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt701:console", "PS4");
		String text = dsl.obterTexto("j_idt701:console_label");
		Assert.assertEquals("PS4", text);
	}
	
	@Test
	public void testeXpath() {
		//site teste http://www.juliodelima.com.br/taskit/
		dsl.clicarRadio(By.xpath(".//div/div/ul/li/a[@class='modal-trigger'][1][contains(text(),'Sign in')]['2']"));
		dsl.clicarRadio(By.xpath(".//div/a[@class='modal-action waves-effect waves-green btn-flat'][contains(text(),'Sign in')]"));
	}
}
