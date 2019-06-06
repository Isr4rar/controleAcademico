package br.com.stratus.cx;

import static br.com.stratus.cx.core.TLDriverFactory.startUrl;

import org.testng.annotations.Test;

import br.com.stratus.cx.page.ProfessorPage;


public class ProfessorTest {
	

	@Test(description = "Deve realizar cadastro de Professor com Sucesso")
	public void cadastrarProfessor() {
		startUrl("https://academicmanagementapi.herokuapp.com/professor/");
		ProfessorPage page = new ProfessorPage();
		
		page.novoProfessor();
	}
	
}
