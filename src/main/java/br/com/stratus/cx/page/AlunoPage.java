package br.com.stratus.cx.page;

import static br.com.stratus.cx.core.TLDriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import br.com.stratus.cx.core.DSL;

public class AlunoPage {
	
	public AlunoPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	private DSL dsl = new DSL();
	Faker faker = new Faker();
	
	@FindBy(name = "nomeAluno")
	private WebElement nomeAluno;
	
	@FindBy(name = "telefoneAluno")
	private WebElement telefoneAluno;
	
	@FindBy(name = "enderecoAluno")
	private WebElement enderecoAluno;
	
	@FindBy(name = "complemento")
	private WebElement complementoAluno;
	
	@FindBy(name = "bairro")
	private WebElement bairroAluno;
	
	@FindBy(name = "cidade")
	private WebElement cidadeAluno;
	
	@FindBy(name = "uf")
	private WebElement ufAluno;
	
	@FindBy(name = "cpfAluno")
	private WebElement cpfAluno;
	
	@FindBy(name = "rgAluno")
	private WebElement rgAluno;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary js-tooltip'])[2]")
	private WebElement buttonPost;
	
	public void setNomeAluno(String value) {
		dsl.preencherCampo(nomeAluno, value);
	}
	public void setTelefone(String value) {
		dsl.preencherCampo(telefoneAluno, value);
	}
	public void setEnderecoAluno(String value) {
		dsl.preencherCampo(enderecoAluno, value);
	}
	public void setComplementoAluno(String value) {
		dsl.preencherCampo(complementoAluno, value);
	}
	public void setBairroAluno(String value) {
		dsl.preencherCampo(bairroAluno, value);
	}
	public void setCidadeAluno(String value) {
		dsl.preencherCampo(cidadeAluno, value);
	}
	public void setUfAluno(String value) {
		dsl.preencherCampo(ufAluno, value);
	}
	public void setCPFAluno(String value) {
		dsl.preencherCampo(cpfAluno, value);
	}
	public void setRgAluno(String value) {
		dsl.preencherCampo(rgAluno, value);
	}
	public void clickPost() {
		dsl.clickButton(buttonPost);
	}
	public void novoAluno() {
		setNomeAluno(faker.gameOfThrones().character());
		setTelefone(faker.phoneNumber().cellPhone());
		setEnderecoAluno(faker.address().fullAddress());
		setComplementoAluno(faker.address().buildingNumber());
		setBairroAluno(faker.address().country());
		setCidadeAluno(faker.address().cityName());
		setUfAluno("PB");
		setCPFAluno(faker.code().isbn10());
		setRgAluno(faker.code().ean8());
		clickPost();
	}
}
