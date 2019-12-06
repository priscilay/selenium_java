package test;
import static core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BaseTest;
import core.DSL;
import page.CampoTreinamentoPage;

public class TesteCampoTreinamento extends BaseTest {
	
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Before
	public void init(){
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new CampoTreinamentoPage();
		}


	@Test
	public void testeTextField(){
		getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Priscila");
		Assert.assertEquals("Priscila", getDriver().findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}
	
	@Test
	public void testeTexFieldDuplo() {
		page.setNome("Pri");
		Assert.assertEquals("Pri", dsl.obterValorTexto("elementosForm:nome"));
		dsl.escrever("elementosForm:nome", "Jao");
		Assert.assertEquals("Jao", dsl.obterValorTexto("elementosForm:nome"));
	}
	
	@Test
	public void testeTextArea() {
		page.setSugestoes("Namaste");
		String esperado = dsl.obterValorTexto("elementosForm:sugestoes");
		Assert.assertEquals("Namaste", esperado);
	}
	
	@Test
	public void testeRadio() {
		dsl.clicar("elementosForm:comidaFavorita:1");
		Assert.assertTrue(dsl.radioMarcado("elementosForm:comidaFavorita:1"));
	}
	
	@Test
	public void testeCombo() {
		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
		Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));
	}

	@Test
	public void testeComboValores() {
		Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
	}
	
	@Test
	public void testeComboValoresMultiplaEscolha() {
		page.setEsportes("Karate", "Futebol");
		
		List<String> opcaoMarcada = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(2, opcaoMarcada.size());

		dsl.deselecionarCombo("elementosForm:esportes", "Futebol");
		opcaoMarcada = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(1, opcaoMarcada.size());
		Assert.assertTrue(opcaoMarcada.containsAll(Arrays.asList("Karate")));
	}
	
	
	@Test
	public void testeBotoes() {
		page.botaoSimples();
		Assert.assertEquals("Obrigado!", dsl.obterValorTexto("buttonSimple"));
	}
	
	
	@Test
	public void testeLinks() {
		WebElement link = getDriver().findElement(By.linkText("Voltar"));
		link.click();
		Assert.assertEquals("Voltou!", getDriver().findElement(By.id("Resultado")).getText());
	}
	
	
	@Test
	public void testeTextoPage() {
		String textoPage = dsl.obterTexto(By.tagName("h3"));
		Assert.assertEquals("Campo de Treinamento", textoPage);
		String textoPage2 = dsl.obterTexto(By.className("facilAchar"));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", textoPage2);
	}
	
//	@Test
//	public void testJavascript(){
//		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		//js.executeScript("alert('Testando js via selenium')");
//		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
//		js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
//		
//		WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
//		js.executeScript("arguments[0].style.border = arqguments[1]", element, "solid 4px red");
//	}
	
	@Test
	public void deveClicarBotaoTabela(){
		dsl.clicarBotaoTabela("Escolaridade", "Mestrado", "Radio", "elementosForm:tableUsuarios");
	}
}
