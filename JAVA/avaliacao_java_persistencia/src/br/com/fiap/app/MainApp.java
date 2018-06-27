package br.com.fiap.app;

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
import br.com.fiap.jdbc.JdbcCurso;
import br.com.fiap.jdbc.JdbcEscolaCurso;
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

	private static void listarCursos(Escola escola) {
		try {
			
			ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
			List<EscolaCursoViewModel> cursos = ((JdbcEscolaCurso) context.getBean("AppEscolaCursosDao")).lista();
			
			Icon icon = UIManager.getIcon("OptionPane.alertIcon");
			EscolaCursoViewModel opcao = (EscolaCursoViewModel) JOptionPane.showInputDialog(null,  
	                "Escolha uma opção", "Opções",  
	                JOptionPane.PLAIN_MESSAGE, icon, cursos.toArray(), "Opções");
			System.out.println(opcao.getCursoNome());
			
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
		String[] possibilities = { "Cadastrar curso", "Listar Cursos", "Cadastrar Aluno", "Listar Alunos",
				"Remover Escola" };

		String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opção", "Opções",
				JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Opções");

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

		Icon icon = UIManager.getIcon("OptionPane.alertIcon");
		Escola opcao = (Escola) JOptionPane.showInputDialog(null, "Escolha uma opção", "Opções",
				JOptionPane.PLAIN_MESSAGE, icon, escolas.toArray(), "Opções");

		viewEscola(opcao);
	}

	/**
	 * 
	 * ALUNOS
	 */

	public static void bootstrapAluno(Curso curso) {
		AlunoHelper helper = new AlunoHelper(setEm());

		Aluno aluno = new Aluno();
		aluno.setNome("Cazalbe");
		aluno.setIdade(45);
		aluno.setEndereco("Rua: Praça nossa");

		aluno.getCurso().add(curso);

		System.out.println(helper.salvar(aluno));
	}

	private static void listarAlunos() {
		AlunoHelper helper = new AlunoHelper(setEm());

		for (Aluno aluno : helper.listarAlunos()) {
			System.out.println("Id do aluno: " + aluno.getId());
			System.out.println("Nome do aluno: " + aluno.getNome());
			System.out.println("Idade do aluno: " + aluno.getIdade());
			System.out.println("Endereço: " + aluno.getEndereco());
			System.out.println("====");
		}
	}

	/**
	 * SetEm
	 * 
	 * @return EntityManager
	 */
	public static EntityManager setEm() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("avaliacao_java_persistencia");
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
		default:
			startApp();
			break;
		}
	}
}
