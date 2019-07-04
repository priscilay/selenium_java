package curso_selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	private WebDriver driver;
	
	public DSL(WebDriver driver){
		this.driver = driver;
	}
	
	public void escrever(String id_campo, String texto){
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public void obterValor(String id_campo){
		driver.findElement(By.id(id_campo)).getAttribute("Value");
	}
	
	public void clicar(String id){
		driver.findElement(By.id(id)).click();
	}
	
	public boolean radioMarcado (String id){
		return driver.findElement(By.id("id")).isSelected();
	}
	
	public void selecionarCombo(String id, String valor){
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public String msgAlert(){
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		return texto;
	}
	
	public void okAlert(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void clicarLink(String linkText){
		driver.findElement(By.linkText(linkText)).click();
	}
	
	public String obterTexto(By by){
		return driver.findElement(by).getText();
	}
	
	public String obterTexto(String id){
		return obterTexto(By.id(id));
	}

}
