package br.com.fiap.app;

import java.util.ArrayList;
import java.util.List;

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
import br.com.fiap.helper.EscolaHelper;
import br.com.fiap.jdbc.JdbcAluno;
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

		String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma op��o", "Op��es",
				JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Op��es");

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
			e.getMessage();
		}
		
		return cursos;
	}

	private static void listarCursos(Escola escola) {
		try {
			List<EscolaCursoViewModel> cursos = processoListagemCurso(escola);
			Icon icon = UIManager.getIcon("OptionPane.alertIcon");
			EscolaCursoViewModel opcao = (EscolaCursoViewModel) JOptionPane.showInputDialog(null,  
	                "Escolha uma op��o", "Op��es",  
	                JOptionPane.PLAIN_MESSAGE, icon, cursos.toArray(), "Op��es");
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
				"Listar Alunos"
			};

		String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma op��o", "Op��es",
				JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Op��es");

		rotas(opcao, escola);
	}

	public static void cadastraEscola() {
		EscolaHelper helper = new EscolaHelper(setEm());
		Escola escola = new Escola();

		String nome = JOptionPane.showInputDialog("Digite o nome da escola.");
		String endereco = JOptionPane.showInputDialog("Digite o endere�o da escola.");

		escola.setNome(nome);
		escola.setEndereco(endereco);
		helper.salvar(escola);

		JOptionPane.showMessageDialog(null, "Escola cadastrada com sucesso!");
		rotas("inicio", null);
	}

	private static void listarEscolas() {
		EscolaHelper helper = new EscolaHelper(setEm());
		List<Escola> escolas = helper.listarEscolas();

		Icon icon = UIManager.getIcon("OptionPane.alertIcon");
		Escola opcao = (Escola) JOptionPane.showInputDialog(null, "Escolha uma op��o", "Op��es",
				JOptionPane.PLAIN_MESSAGE, icon, escolas.toArray(), "Op��es");

		viewEscola(opcao);
	}

	/**
	 * 
	 * ALUNOS
	 */

	public static void cadastraAluno(Escola escola) {
		AlunoHelper helper = new AlunoHelper(setEm());
		Aluno aluno = new Aluno();
		
		String nome = JOptionPane.showInputDialog("Digite o nome do aluno.");
		String idade = JOptionPane.showInputDialog("Digite a idade do aluno.");
		String endereco = JOptionPane.showInputDialog("Digite o endere�o do aluno.");
		
		List<EscolaCursoViewModel> cursos = processoListagemCurso(escola);
		Icon icon = UIManager.getIcon("OptionPane.alertIcon");
		EscolaCursoViewModel opcao = (EscolaCursoViewModel) JOptionPane.showInputDialog(null,  
                "Escolha uma op��o", "Op��es",  
                JOptionPane.PLAIN_MESSAGE, icon, cursos.toArray(), "Op��es");
		
		Curso curso = new Curso();
		curso.setId(opcao.getCursoId());
		curso.setNome(opcao.getNome());
		curso.setEscola(escola);
		
		aluno.setNome(nome);
		aluno.setIdade(Integer.parseInt(idade));
		aluno.setEndereco(endereco);

		aluno.getCurso().add(curso);
		JOptionPane.showMessageDialog(null, helper.salvar(aluno));
		
		viewEscola(escola);
	}
	
	private static void listaAlunos(Escola escola) {
		try {
			List<CursoAlunoViewModel> alunos = processoListagemAluno(escola);
			Icon icon = UIManager.getIcon("OptionPane.alertIcon");
			CursoAlunoViewModel opcao = (CursoAlunoViewModel) JOptionPane.showInputDialog(null,  
	                "Escolha uma aluno para dar uma nota.", "Alunos",  
	                JOptionPane.PLAIN_MESSAGE, icon, alunos.toArray(), "Op��es");
			aplicarNota(opcao, escola);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public static void aplicarNota(CursoAlunoViewModel aluno, Escola escola) {
		String nota = JOptionPane.showInputDialog("Digite a nota do aluno");
		
		try {
			AlunoHelper helper = new AlunoHelper(setEm());
			JOptionPane.showMessageDialog(null, helper.nota(Float.parseFloat(nota), aluno.getId()));
			viewEscola(escola);
		} catch (Exception e) {
			e.printStackTrace();
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
	 * Rotas da aplica��o
	 * 
	 * @param String
	 *            opt
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
		default:
			startApp();
			break;
		}
	}
}
