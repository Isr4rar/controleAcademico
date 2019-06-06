package br.com.stratus.cx.page;

import static br.com.stratus.cx.core.TLDriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import br.com.stratus.cx.core.DSL;

public class CursoPage {
	
	public CursoPage() {
		PageFactory.initElements(getDriver(), this);
	}

	Faker faker = new Faker();
	private DSL dsl = new DSL();
	
	@FindBy(name = "nomeCurso")
	private WebElement nomeCurso;
	
	@FindBy(xpath = "//option[contains(text(),'Banco de Dados')]")
	private WebElement nomeDisciplina;
	
	@FindBy(xpath = "//option[contains(text(), '')]")
	private List<WebElement> AlunosETurmas;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary js-tooltip'])[2]")
	private WebElement buttonPost;
	
	public void setNomeCurso(String value) {
		dsl.preencherCampo(nomeCurso, value);
	}
	public void setNomeDisciplina() {
		dsl.clickButton(nomeDisciplina);
	}
	public void selecionarAlunosETurnos() {
		dsl.clickButton(AlunosETurmas.get(3));
		dsl.clickButton(AlunosETurmas.get(4));
		dsl.clickButton(AlunosETurmas.get(5));
		dsl.clickButton(AlunosETurmas.get(6));
		dsl.clickButton(AlunosETurmas.get(7));
		dsl.clickButton(AlunosETurmas.get(8));
		dsl.clickButton(AlunosETurmas.get(9));
	}
	public void clickPost() {
		dsl.clickButton(buttonPost);
	}
	public void cadastrarCurso() {
		setNomeCurso(faker.educator().course());
		setNomeDisciplina();
		selecionarAlunosETurnos();
		clickPost();
	}
}
