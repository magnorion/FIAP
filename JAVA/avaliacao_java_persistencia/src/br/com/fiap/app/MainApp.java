package br.com.fiap.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Escola;
import br.com.fiap.helper.AlunoHelper;
import br.com.fiap.helper.AlunosCursosHelper;
import br.com.fiap.helper.EscolaHelper;
import br.com.fiap.jdbc.JdbcAluno;
import br.com.fiap.jdbc.JdbcAlunoCursos;
import br.com.fiap.jdbc.JdbcCurso;
import br.com.fiap.jdbc.JdbcEscolaCurso;
import br.com.fiap.viewmodel.CursoAlunoViewModel;
import br.com.fiap.viewmodel.EscolaCursoViewModel;

public class MainApp {

	public static void main(String[] args) {
		startApp();
	}

	// VIEW INICIAL DO APP
	public static void startApp() {
		Icon icon = UIManager.getIcon("OptionPane.alertIcon");
		String[] possibilities = { "Cadastrar uma escola", "Escolher uma escola" };

		String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opção", "Opções",
				JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Opções");

		rotas(opcao, null);
	}

	/**
	 * 
	 * CURSOS
	 */

	public static void cadastrarCurso(Escola escola) {
		Curso curso = new Curso();

		String nome = JOptionPane.showInputDialog("Digite o nome do curso.");

		try {
			curso.setNome(nome);
			curso.setEscola(escola);

			JdbcCurso dao = dao();
			dao.incluirCurso(curso);

			JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");
			viewEscola(escola);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static List<EscolaCursoViewModel> processoListagemCurso(Escola escola) {
		List<EscolaCursoViewModel> cursos = new ArrayList<>();
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
			cursos = ((JdbcEscolaCurso) 
					context.getBean("AppEscolaCursosDao")).lista(escola.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cursos;
	}
	
	private static List<CursoAlunoViewModel> processoListagemCursoAluno(Aluno aluno) {
		List<CursoAlunoViewModel> cursos = new ArrayList<>();
		
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
			cursos = ((JdbcAlunoCursos) 
					context.getBean("AppAlunosCursosDao")).lista(aluno.getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return cursos;
	}

	private static void listarCursos(Escola escola) {
		try {
			List<EscolaCursoViewModel> cursos = processoListagemCurso(escola);
			
			if (cursos.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não existem cursos cadastrados!\nPor favor, cadastre um curso!");
				viewEscola(escola);
			} else {
				Icon icon = UIManager.getIcon("OptionPane.alertIcon");
				EscolaCursoViewModel opcao = (EscolaCursoViewModel) JOptionPane.showInputDialog(null,  
		                "Escolha uma opção", "Opções",  
		                JOptionPane.PLAIN_MESSAGE, icon, cursos.toArray(), "Opções");
				
				viewEscola(escola);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * ESCOLA
	 */

	// VIEW ESCOLA
	public static void viewEscola(Escola escola) {
		Icon icon = UIManager.getIcon("OptionPane.alertIcon");
		String[] possibilities = { 
				"Cadastrar curso", 
				"Listar Cursos", 
				"Cadastrar Aluno", 
				"Listar Alunos",
				"Menu principal"
			};

		String opcao = (String) JOptionPane.showInputDialog(null, "Escola: " + escola.getNome(), "Opções",
				JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Menu Escola");

		rotas(opcao, escola);
	}

	public static void cadastraEscola() {
		EscolaHelper helper = new EscolaHelper(setEm());
		Escola escola = new Escola();

		String nome = JOptionPane.showInputDialog("Digite o nome da escola.");
		String endereco = JOptionPane.showInputDialog("Digite o endereço da escola.");

		escola.setNome(nome);
		escola.setEndereco(endereco);
		helper.salvar(escola);

		JOptionPane.showMessageDialog(null, "Escola cadastrada com sucesso!");
		rotas("inicio", null);
	}

	private static void listarEscolas() {
		EscolaHelper helper = new EscolaHelper(setEm());
		List<Escola> escolas = helper.listarEscolas();
		
		if (escolas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não existe escolas cadastradas!\nPor favor, cadastre uma escola!");
			rotas("inicio", null);
		} else {
			Icon icon = UIManager.getIcon("OptionPane.alertIcon");
			Escola opcao = (Escola) JOptionPane.showInputDialog(null, "Escolha uma opção", "Opções",
					JOptionPane.PLAIN_MESSAGE, icon, escolas.toArray(), "Opções");

			viewEscola(opcao);
		}
	}

	/**
	 * 
	 * ALUNOS
	 */
	
	// VIEW ALUNOS
	public static void viewAluno(Aluno aluno) {
		Icon icon = UIManager.getIcon("OptionPane.alertIcon");
		String[] possibilities = { 
				"Cadastrar aluno em um curso",
				"Avaliação de nota",
				"Cursos do aluno",
				"Voltar para menu escola"
			};

		String opcao = (String) JOptionPane.showInputDialog(null, "Aluno: " + aluno.getNome(), "Opções",
				JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Opções");

		if (opcao.equals("Avaliação de nota")) {
			aplicarNota(aluno, aluno.getEscola());
		} else if (opcao.equals("Voltar para menu escola")) {
			viewEscola(aluno.getEscola());
		} else {
			rotas(opcao, aluno);
		}
	}

	public static void cadastraAluno(Escola escola) {
		AlunoHelper helper = new AlunoHelper(setEm());
		Aluno aluno = new Aluno();
		
		String nome = JOptionPane.showInputDialog("Digite o nome do aluno.");
		String idade = JOptionPane.showInputDialog("Digite a idade do aluno.");
		String endereco = JOptionPane.showInputDialog("Digite o endereço do aluno.");
		
		aluno.setNome(nome);
		aluno.setIdade(Integer.parseInt(idade));
		aluno.setEndereco(endereco);
		aluno.setEscola(escola);
		
		JOptionPane.showMessageDialog(null, helper.salvar(aluno));
		
		viewEscola(escola);
	}
	
	public static void cadastraAlunoNoCurso(Aluno aluno) {
		AlunoHelper helper = new AlunoHelper(setEm());
		
		List<EscolaCursoViewModel> cursos = processoListagemCurso(aluno.getEscola());
		
		if (cursos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não existem cursos cadastrados!\nPor favor, cadastre um curso!");
			viewAluno(aluno);
		} else {
			Icon icon = UIManager.getIcon("OptionPane.alertIcon");
			EscolaCursoViewModel opcao = (EscolaCursoViewModel) JOptionPane.showInputDialog(null,  
	                "Escolha um curso para o cadastro", "Opções",  
	                JOptionPane.PLAIN_MESSAGE, icon, cursos.toArray(), "Opções");
			
			JOptionPane.showMessageDialog(null, helper.cadastraCurso(aluno, opcao.getCursoId()));
			viewAluno(aluno);
		}
	}
	
	private static void listaAlunos(Escola escola) {
		try {
			List<CursoAlunoViewModel> alunos = processoListagemAluno(escola);
			
			if (alunos.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não existem alunos cadastrados!\nPor favor, cadastre um aluno!");
				viewEscola(escola);
			} else {
				Icon icon = UIManager.getIcon("OptionPane.alertIcon");
				CursoAlunoViewModel opcao = (CursoAlunoViewModel) JOptionPane.showInputDialog(null,  
		                "Escolha uma aluno para dar uma nota.", "Alunos",  
		                JOptionPane.PLAIN_MESSAGE, icon, alunos.toArray(), "Opções");
				
				Aluno aluno = pegarAluno(opcao.getId());
				
				viewAluno(aluno);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Aluno pegarAluno(int id) {
		AlunoHelper helper = new AlunoHelper(setEm());
		return helper.retornaAluno(id);
	}
	
	private static List<CursoAlunoViewModel> processoListagemAluno(Escola escola) {
		List<CursoAlunoViewModel> alunos = new ArrayList<>();
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
			alunos = ((JdbcAluno) 
					context.getBean("AppAlunosDao")).lista(escola.getId());
		} catch (Exception e) {
			e.getMessage();
		}
		
		return alunos;
	}
	
	public static void aplicarNota(Aluno aluno, Escola escola) {
		Set<Curso> cursos = aluno.getCursos();
		
		if (cursos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Este aluno não esta cadastrado em um curso!");
			viewAluno(aluno);
		} else { 
			Icon icon = UIManager.getIcon("OptionPane.alertIcon");
			Curso curso = (Curso) JOptionPane.showInputDialog(null,  
	                "Escolha um curso", "Opções",  
	                JOptionPane.PLAIN_MESSAGE, icon, cursos.toArray(), "Opções");
			
			Boolean flag = true;
			String nota;
			Float notaFinal = new Float(0);
			
			while (flag) {
				nota = JOptionPane.showInputDialog("Digite a nota do aluno");
				notaFinal = Float.parseFloat(nota);
				
				if (notaFinal > 10 || notaFinal < 0) {
					JOptionPane.showMessageDialog(null, "Nota incorreta!\nA nota deve ser de 0 a 10");
				} else {
					flag = false;
				}
			}
			
			try {
				AlunosCursosHelper helper = new AlunosCursosHelper(setEm());
				JOptionPane.showMessageDialog(null, helper.nota(aluno.getId(), curso.getId(), notaFinal));
				
				viewAluno(aluno);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void cursosDoAluno(Aluno aluno) {
		Set<Curso> cursos = aluno.getCursos();
		
		if (cursos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Este aluno não esta cadastrado em um curso!");
			viewAluno(aluno);
		} else {
			Icon icon = UIManager.getIcon("OptionPane.alertIcon");
			Curso curso = (Curso) JOptionPane.showInputDialog(null,  
	                "Escolha um curso", "Opções",  
	                JOptionPane.PLAIN_MESSAGE, icon, cursos.toArray(), "Opções");
		
			try {
				AlunosCursosHelper helper = new AlunosCursosHelper(setEm());
				Float nota = helper.mostraCursoNota(aluno, curso);
				if (nota > 0) {
					JOptionPane.showMessageDialog(null, "Neste curso, a nota do aluno é " + nota);
				} else {
					JOptionPane.showMessageDialog(null, "Neste curso, o aluno foi reporvado ou ainda não teve nota!");
				}
				
				viewAluno(aluno);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * SetEm
	 * 
	 * @return EntityManager
	 */
	public static EntityManager setEm() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("avaliacaojavapersistencia");
		EntityManager em = emf.createEntityManager();

		return em;
	}

	/**
	 * dao
	 * 
	 * @return JdbcCurso
	 */
	public static JdbcCurso dao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
		JdbcCurso dao = (JdbcCurso) context.getBean("AppEscolaCursos");

		return dao;
	}

	/**
	 * Rotas da aplicação
	 * 
	 * @param String
	 * opt
	 */
	public static void rotas(String opt, Object entity) {
		switch (opt) {
		case "Cadastrar uma escola":
			cadastraEscola();
			break;
		case "Escolher uma escola":
			listarEscolas();
			break;
		case "Cadastrar curso":
			cadastrarCurso((Escola) entity);
			break;
		case "Listar Cursos":
			listarCursos((Escola) entity);
			break;
		case "Cadastrar Aluno":
			cadastraAluno((Escola) entity);
			break;
		case "Listar Alunos":
			listaAlunos((Escola) entity);
			break;
		case "Cadastrar aluno em um curso":
			cadastraAlunoNoCurso((Aluno) entity);
			break;
		case "Cursos do aluno":
			cursosDoAluno((Aluno) entity);
			break;
		default:
			startApp();
			break;
		}
	}
}
