package br.com.stratus.cx.page;

import static br.com.stratus.cx.core.TLDriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import br.com.stratus.cx.core.DSL;

public class DisciplinaPage {
	
	public DisciplinaPage() {
		PageFactory.initElements(getDriver(), this);
	}

	Faker faker = new Faker();
	private DSL dsl = new DSL();
	
	@FindBy(name = "nomeDisciplina")
	private WebElement nomeDisciplica;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary js-tooltip'])[2]")
	private WebElement buttonPost;

	public void setNomeDisciplina(String value) {
		dsl.preencherCampo(nomeDisciplica, value);
	}
	public void clickPost() {
		dsl.clickButton(buttonPost);
	}
	public void novaDisciplina() {
		setNomeDisciplina(faker.educator().course());
		clickPost();
	}
}
