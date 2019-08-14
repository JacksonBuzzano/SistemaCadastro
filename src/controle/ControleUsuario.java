package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexão.ConexãoBD;
import modelo.ModeloUsuario;

public class ControleUsuario {

	ConexãoBD conexao = new ConexãoBD();

	public void salvar(ModeloUsuario mod) {
		conexao.ConectarBanco();
		try {
			String sql = "INSERT INTO usuários (nomeUsuario, senhaUsuario) VALUES(?,?)";
			PreparedStatement pst = conexao.conn.prepareStatement(sql);
			pst.setString(1, mod.getNome());
			pst.setInt(2, mod.getSenha1());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com Sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
		}
		conexao.FecharBanco();
	}

	public void editar(ModeloUsuario mod) {
		conexao.ConectarBanco();
		try {
			String sql = "UPDATE usuários SET nomeUsuario=?, senhaUsuario=? WHERE idUsuario=?";
			PreparedStatement pst = conexao.conn.prepareStatement(sql);
			pst.setString(1, mod.getNome());
			pst.setInt(2, mod.getSenha1());
			pst.setInt(3, mod.getId());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Editado com Sucesso!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Editar!! ");
		}
		conexao.FecharBanco();
	}

	public void pesquisa(ModeloUsuario mod) {
		conexao.ConectarBanco();

		conexao.executaSQL("SELECT * FROM usuários WHERE nomeUsuario LIKE '%" + mod.getPesquisa() + "%'");
		try {
			conexao.rs.first();
			mod.setNome(conexao.rs.getString("nomeUsuario"));
			mod.setSenha1(conexao.rs.getInt("senhaUsuario"));
			mod.setId(conexao.rs.getInt("idUsuario"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Pesquisar!! " );
		}
		conexao.FecharBanco();
	}

	public void excluir(ModeloUsuario mod) {
		conexao.ConectarBanco();

		try {
			PreparedStatement pst = conexao.conn.prepareStatement("DELETE FROM usuários WHERE idUsuario=?");
			pst.setInt(1, mod.getId());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Excluir!! ");
		}
		conexao.FecharBanco();
	}

}
