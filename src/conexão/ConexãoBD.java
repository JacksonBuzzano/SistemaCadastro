package conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConexãoBD {

	public Statement stm;// responsável por realizar pesquisa com o banco de dados
	public ResultSet rs;// responsável por armazenar o resultado de uma pesquisa
	private String driver = "com.mysql.cj.jdcb.Driver";// responsável por identificar o caminho do banco
	private String caminho = "jdbc:mysql://localhost:3306/trabalho?useTimezone=true&serverTimezone=UTC";
	private String usuario = "root";
	private String senha = "";
	public Connection conn;

	public void ConectarBanco() {// Responsável por conectar ao Banco

		System.setProperty("jdbc.Drivers", driver);// seta a propriedade do conecxao
		try {
			conn = DriverManager.getConnection(caminho, usuario, senha);// realiza a conexão com o banco de dados
			 //JOptionPane.showMessageDialog(null, "Conectado com Sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao se Conectar!! \n Não foi possível se conectar com o banco de dados!!" );
		}
	}

	public void executaSQL(String sql) {
		try {
			stm = conn.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao executar SQL!! \n ");
		}

	}

	public void FecharBanco() {// reponsável por sair do Banco
		try {
			conn.close();// fecha a Conecxão
			// JOptionPane.showMessageDialog(null, "Conecxão fechada com Sucesso");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Conecxão fechada com Sucesso");
		}

	}

}
