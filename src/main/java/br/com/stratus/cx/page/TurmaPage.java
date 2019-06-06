package br.com.stratus.cx.page;

import static br.com.stratus.cx.core.TLDriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import br.com.stratus.cx.core.DSL;

public class TurmaPage  {
	
	public TurmaPage() {
		PageFactory.initElements(getDriver(), this);
	}

	Faker faker = new Faker();
	private DSL dsl = new DSL();
	
	
	@FindBy(name = "nomeTurma")
	private WebElement nomeTurma;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary js-tooltip'])[2]")
	private WebElement buttonPost;

	public void setNomeTurma(String value) {
		dsl.preencherCampo(nomeTurma, value);
	}
	public void clickPost() {
		dsl.clickButton(buttonPost);
	}
	public void novaTurma() {
		setNomeTurma(faker.gameOfThrones().house());
		clickPost();
	}

}
