package br.com.stratus.cx.page;



import static br.com.stratus.cx.core.TLDriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import br.com.stratus.cx.core.DSL;



public class ProfessorPage {
	
	public ProfessorPage() {
		PageFactory.initElements(getDriver(), this);
	}

	Faker faker = new Faker();
	private DSL dsl = new DSL();
	
	@FindBy(name = "nomeProfessor")
	private WebElement nameProfessor;
	
	@FindBy(name = "telefoneProfessor")
	private WebElement telefoneProfessor;
	
	@FindBy(name = "enderecoProfessor")
	private WebElement enderecoProfessor;
	
	@FindBy(name = "complemento")
	private WebElement complementoProfessor;
	
	@FindBy(name = "bairro")
	private WebElement bairroProfessor;
	
	@FindBy(name = "cidade")
	private WebElement cidadeProfessor;
	
	@FindBy(name = "uf")
	private WebElement ufProfessor;
	
	@FindBy(name = "cpfProfessor")
	private WebElement cpfProfessor;
	
	@FindBy(name = "rgProfessor")
	private WebElement rgProfessor;
	
	@FindBy(xpath = "//option[contains(text(),'Formação 003')]")
	private WebElement formacaoProfessor;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary js-tooltip'])[2]")
	private WebElement buttonPost;
	
	public void setNomeProfessor(String value) {
		dsl.preencherCampo(nameProfessor, value);
	}
	public void setTelefone(String value) {
		dsl.preencherCampo(telefoneProfessor, value);
	}
	public void setEnderecoProfessor(String value) {
		dsl.preencherCampo(enderecoProfessor, value);
	}
	public void setComplementoProfessor(String value) {
		dsl.preencherCampo(complementoProfessor, value);
	}
	public void setBairroProfessor(String value) {
		dsl.preencherCampo(bairroProfessor, value);
	}
	public void setCidadeProfessor(String value) {
		dsl.preencherCampo(cidadeProfessor, value);
	}
	public void setUfProfessor(String value) {
		dsl.preencherCampo(ufProfessor, value);
	}
	public void setCPFProfessor(String value) {
		dsl.preencherCampo(cpfProfessor, value);
	}
	public void setRgProfessor(String value) {
		dsl.preencherCampo(rgProfessor, value);
	}
	public void setFormacoes() {
		dsl.clickButton(formacaoProfessor);
	}
	public void clickPost() {
		dsl.clickButton(buttonPost);
	}
	
	public void novoProfessor() {
		setNomeProfessor(faker.gameOfThrones().character());
		setTelefone(faker.phoneNumber().cellPhone());
		setEnderecoProfessor(faker.address().fullAddress());
		setComplementoProfessor(faker.address().buildingNumber());
		setBairroProfessor(faker.address().country());
		setCidadeProfessor(faker.address().cityName());
		setUfProfessor("PB");
		setCPFProfessor(faker.code().isbn10());
		setRgProfessor(faker.code().ean8());
		setFormacoes();
		clickPost();
	}
	
}
