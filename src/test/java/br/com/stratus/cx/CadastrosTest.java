package br.com.stratus.cx;

import static br.com.stratus.cx.core.TLDriverFactory.startUrl;

import org.testng.annotations.Test;

import br.com.stratus.cx.page.AlunoPage;
import br.com.stratus.cx.page.CursoPage;
import br.com.stratus.cx.page.DisciplinaPage;
import br.com.stratus.cx.page.FormacaoPage;
import br.com.stratus.cx.page.ProfessorPage;
import br.com.stratus.cx.page.TurmaPage;

public class CadastrosTest {
	
	@Test(priority= 0,description = "Deve realizar cadastro de Professor com Sucesso")
	public void cadastrarProfessor() {
		startUrl("https://academicmanagementapi.herokuapp.com/professor/");
		ProfessorPage page = new ProfessorPage();
		
		page.novoProfessor();
	}
	
	@Test(priority= 1,description = "Deve realizar cadastro de Aluno com Sucesso")
	public void cadastrarAluno() {
		startUrl("https://academicmanagementapi.herokuapp.com/aluno/");
		AlunoPage page = new AlunoPage();
		
		page.novoAluno();
	}
	
	@Test(priority= 2,description = "Deve realizar cadastro de Curso com Sucesso")
	public void cadastrarCurso() {
		startUrl("https://academicmanagementapi.herokuapp.com/curso/");
		CursoPage page = new CursoPage();
		
		page.cadastrarCurso();
	}
	@Test(priority= 3,description = "Deve realizar cadastro de Formacao com Sucesso")
	public void cadastrarFormacao() {
		startUrl("https://academicmanagementapi.herokuapp.com/formacao/");
		FormacaoPage page = new FormacaoPage();
		
		page.novaFormacao();
	}
	@Test(priority= 4,description = "Deve realizar cadastro de Disciplina com Sucesso")
	public void cadastrarDisciplina() {
		startUrl("https://academicmanagementapi.herokuapp.com/disciplina/");
		DisciplinaPage page = new DisciplinaPage();
		
		page.novaDisciplina();
	}
	@Test(priority= 5,description = "Deve realizar cadastro de Turma com Sucesso")
	public void cadastrarTurma() {
		startUrl("https://academicmanagementapi.herokuapp.com/turma/");
		TurmaPage page = new TurmaPage();
		
		page.novaTurma();
	}
	

}
