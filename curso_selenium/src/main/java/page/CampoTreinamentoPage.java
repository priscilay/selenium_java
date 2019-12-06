package page;

import org.openqa.selenium.By;

import core.BasePage;



public class CampoTreinamentoPage extends BasePage {


	public void setNome(String nome){
		dsl.escrever("elementosForm:nome", nome);
	}
	
	public String getNome(){
		return dsl.obterTexto("elementosForm:nome");
	}
	
	public void setSobrenome(String sobrenome){
		dsl.escrever("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSugestoes(String sugetoes){
		dsl.escrever("elementosForm:sugestoes", sugetoes);
	}
	
	public void generoFeminino(){
		dsl.clicar("elementosForm:sexo:1");
	}
	
	public void generoMasculino(){
		dsl.clicar("elementosForm:sexo:0");
	}
	
	public void comidaVegan(){
		dsl.clicar("elementosForm:comidaFavorita:3");
	}
	
	public void comidaCarne(){
		dsl.clicar("elementosForm:comidaFavorita:0");
	}
	
	public void comidaFrango(){
		dsl.clicar("elementosForm:comidaFavorita:1");
	}
	
	public void comidaPizza(){
		dsl.clicar("elementosForm:comidaFavorita:2");
	}
	public void setEsportes(String...esportes){
		for(String esporte: esportes){
		dsl.selecionarCombo("elementosForm:esportes", esporte);
		}
	}
	
	public void setEscolaridade(String valor){
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
	}
	
	public void cadastrar(){
		dsl.clicar("elementosForm:cadastrar");
	}
	public void botaoSimples(){
		dsl.clicar("buttonSimple");
	}
	
	
	public String obterResultadoCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='resultado']/span"));
	}
	
	public String obterNomeCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descNome']/span"));
	}
	
	public String obterSobrenomeCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descSobrenome']/span"));
	}
	
	public String obterSexoCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descSexo']/span"));
	}
	
	public String obterComidaCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descComida']/span"));
	}
	
	public String obterEscolaridadeCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descEscolaridade']/span"));
	}
	
	public String obterEsportesCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descEsportes']/span"));
	}
}
