package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import conexão.ConexãoBD;
import modelo.ModeloFornecedor;

public class ControleFornecedor {

	ConexãoBD conecta = new ConexãoBD();

	public void salvarFornecedor(ModeloFornecedor modfor) {

		conecta.ConectarBanco();
		try {
			PreparedStatement pst = conecta.conn.prepareStatement(
					"INSERT INTO fornecedor(nomeFor, nascimentoFor, cnpjFor, telefoneFor, enderecoFor, cidadeFor, estadoFor, emailFor) values (?,?,?,?,?,?,?,?)");
			pst.setString(1, modfor.getNome());
			pst.setString(2, modfor.getNascimento());
			pst.setString(3, modfor.getCnpj());
			pst.setString(4, modfor.getTelefone());
			pst.setString(5, modfor.getEndereco());
			pst.setString(6, modfor.getCidade());
			pst.setString(7, modfor.getEstado());
			pst.setString(8, modfor.getEmail());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível salvar \n Tente novamente ");

		}
		conecta.FecharBanco();
	}

	public ModeloFornecedor buscaFornecedor(ModeloFornecedor modFor) {

		conecta.ConectarBanco();
		conecta.executaSQL("select * from fornecedor where nomeFor like '%" + modFor.getPesquisa() + "%'");
		try {
			conecta.rs.first();
			modFor.setCidade(conecta.rs.getString("cidadeFor"));
			modFor.setCnpj(conecta.rs.getString("cnpjFor"));
			modFor.setEndereco(conecta.rs.getString("enderecoFor"));
			modFor.setEstado(conecta.rs.getString("estadoFor"));
			modFor.setId(conecta.rs.getInt("idFor"));
			modFor.setNascimento(conecta.rs.getString("nascimentoFor"));
			modFor.setNome(conecta.rs.getString("nomeFor"));
			modFor.setTelefone(conecta.rs.getString("telefoneFor"));
			modFor.setEmail(conecta.rs.getString("emailFor"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao pesquisar \n Fornecedor não cadastrado");

		}
		conecta.FecharBanco();
		return modFor;

	}

	public void excluirFornecedor(ModeloFornecedor modFor) {

		conecta.ConectarBanco();
		try {
			PreparedStatement pst = conecta.conn.prepareStatement("delete from fornecedor where idFor=?");
			pst.setInt(1, modFor.getId());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Excluido com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível excluir \n");

		}
		conecta.FecharBanco();

	}

	public void editaFornecedor(ModeloFornecedor modFor) {

		conecta.ConectarBanco();
		try {
			PreparedStatement pst = conecta.conn.prepareStatement(
					"update fornecedor set nomeFor=?, nascimentoFor=?, cnpjFor=?, telefoneFor=?, enderecoFor=?, cidadeFor=?, estadoFor=?, emailFor=? where idFor=?");
			pst.setString(1, modFor.getNome());
			pst.setString(2, modFor.getNascimento());
			pst.setString(3, modFor.getCnpj());
			pst.setString(4, modFor.getTelefone());
			pst.setString(5, modFor.getEndereco());
			pst.setString(6, modFor.getCidade());
			pst.setString(7, modFor.getEstado());
			pst.setString(8, modFor.getEmail());
			pst.setInt(9, modFor.getId());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Editado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar \n");

		}

	}

}
