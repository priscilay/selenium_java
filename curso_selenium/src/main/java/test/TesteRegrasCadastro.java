package test;
import static core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import core.BaseTest;
import core.DSL;
import page.CampoTreinamentoPage;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro extends BaseTest {

	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String msg;
	

	@Before
	public void init(){
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new CampoTreinamentoPage();	
	}

	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
			{"Pris", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
			{"Pri", "Rib", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
			{"Pri", "Rib", "Feminino", Arrays.asList("Vegetariano", "Carne"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"Pri", "Rib", "Feminino", Arrays.asList("Pizza"), new String[]{"Corrida", "O que eh esporte?"}, "Voce faz esporte ou nao?"}
		});
	}
	
	@Test
	public void validarRegras(){
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		if(sexo.equals("Feminino")) {
			page.generoFeminino();
		} 
		if(sexo.equals("Masculino")) {
			page.generoMasculino();
		}
		if(comidas.contains("Carne")) page.comidaCarne();; 
		if(comidas.contains("Pizza")) page.comidaPizza();
		if(comidas.contains("Vegetariano")) page.comidaVegan();
		page.setEsportes(esportes);
		page.cadastrar();
		System.out.println(msg);
		Assert.assertEquals(msg, dsl.msgAlertAcept());
	}
}
