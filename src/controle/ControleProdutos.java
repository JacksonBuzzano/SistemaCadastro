package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import conexão.ConexãoBD;
import modelo.ModeloProduto;

public class ControleProdutos {

	ConexãoBD conecta = new ConexãoBD();

	public void SalvarProduto(ModeloProduto modPro) {
		conecta.ConectarBanco();

		try {
			PreparedStatement pst = conecta.conn.prepareStatement(
					"insert into produtos (nomePro, qntPro, compraPro,vendaPro, marcaPro) values (?,?,?,?,?)");
			pst.setString(1, modPro.getNome());
			pst.setInt(2, modPro.getQuantidade());
			pst.setDouble(3, modPro.getCompra());
			pst.setDouble(4, modPro.getVenda());
			pst.setString(5, modPro.getMarca());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Produto cadastrado com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar Produto" );
		}
		conecta.FecharBanco();
	}

	public ModeloProduto buscaProduto(ModeloProduto modPro) {
		conecta.ConectarBanco();
		conecta.executaSQL("select * from produtos where nomePro like '%" + modPro.getPesquisar() + "%'");
		try {
			conecta.rs.first();
			modPro.setCompra((conecta.rs.getDouble("compraPro")));
			modPro.setId(conecta.rs.getInt("idPro"));
			modPro.setMarca(conecta.rs.getString("marcaPro"));
			modPro.setNome(conecta.rs.getString("nomePro"));
			modPro.setQuantidade(conecta.rs.getInt("qntPro"));
			modPro.setVenda(conecta.rs.getDouble("vendaPro"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Produto não existe ou nome incorreto\n Tente novamente " );
		}
		conecta.FecharBanco();
		return modPro;
	}

	public void excluirProduto(ModeloProduto modPro) {
		conecta.ConectarBanco();

		try {
			PreparedStatement pst = conecta.conn.prepareStatement("delete from produtos where idPro=?");
			pst.setInt(1, modPro.getId());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir\n" );
		}
		conecta.FecharBanco();
	}

	public void editarProduto(ModeloProduto modPro) {

		conecta.ConectarBanco();

		try {
			PreparedStatement pst = conecta.conn
					.prepareStatement("update produtos set nomePro=?, qntPro=?, compraPro=?, vendaPro=?, marcaPro=? where idPro=?");
			pst.setString(1, modPro.getNome());
			pst.setInt(2, modPro.getQuantidade());
			pst.setDouble(3, modPro.getCompra());
			pst.setDouble(4, modPro.getVenda());
			pst.setString(5, modPro.getMarca());
			pst.setInt(6, modPro.getId());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Editado com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar\n");
		}

	}

}
