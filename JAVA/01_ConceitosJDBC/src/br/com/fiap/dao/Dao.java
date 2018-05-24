package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;

public abstract class Dao<T> {
	
	// Mantem a conexão
	protected Connection cn;
	
	// Manipula os dados com base na conexão (Permite operações no BD)
	protected PreparedStatement stmt;
	
	// Referencia a consulta
	protected ResultSet rs;
	
	// String de conexão ao banco
	private String conexao = "jdbc:mysql://localhost:3306/dbeventos";
	
	public void abrirConexao() throws Exception {
		// Especificar o driver de acesso
		Class.forName("com.mysql.jdbc.Driver");
		
		// Resposavel por estabelecer a conexão com o BD
		this.cn = DriverManager.getConnection(this.conexao, "root", "fiap");
	}
	
	public void fecharConexao() throws Exception {
		if (this.cn != null && !this.cn.isClosed()) {
			this.cn.close();
		}
	}
	
	public abstract void incluir(T elemento) throws Exception;
	public abstract T buscar(int id) throws Exception;
	public abstract Set<T> listar(int... param) throws Exception;
}
