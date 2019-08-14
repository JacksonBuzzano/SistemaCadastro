package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import conexão.ConexãoBD;
import modelo.ModeloVendas;

public class ControleVendas {
	ConexãoBD conecta = new ConexãoBD();

	int codFor, codPro;

	public void salvarVenda(ModeloVendas modVen) {

		fornecedorCodigo(modVen.getOp());
		produtoCodigo(modVen.getProduto());
		
		/*conecta.ConectarBanco();
		try {
			PreparedStatement pst = conecta.conn
					.prepareStatement("insert into vendas (produtoVenda, valorVenda, operadorVenda) values (?,?,?)");
			pst.setInt(1, codPro);
			pst.setDouble(2, modVen.getValor());
			pst.setInt(3, codFor);
			pst.execute();
			JOptionPane.showMessageDialog(null, "Venda Realizada com Sucesso");
		*
			//Baixa do estoque
			int qn= 0, resul= 0;
			conecta.executaSQL("select * from produtos where nomePro='"+modVen.getProduto()+"'");
			conecta.rs.first();
			qn = conecta.rs.getInt("qntPro");
			resul = qn - modVen.getQnt();
			pst = conecta.conn.prepareStatement("update produtos set qntPro=? where nomePro=? ");
			pst.setInt(1, resul);
			pst.setString(2, modVen.getProduto());
			pst.execute();
			JOptionPane.showMessageDialog(null, "salvo ok");
			conecta.FecharBanco();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "Não foi possível Salvar Produto \n" );

		}
		
		conecta.FecharBanco();
		*/
	}
	
	
	

	public void buscaPro(ModeloVendas m) {

		conecta.ConectarBanco();
		conecta.executaSQL("select *from produtos where nomePro like '" + m.getPesquisa() + "%'");
		try {
			conecta.rs.first();
			m.setValor(conecta.rs.getDouble("vendaPro"));
			m.setProduto(conecta.rs.getString("nomePro"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Produto não cadastrado!!");
		}
		conecta.FecharBanco();

	}

	// Pegar código do Fornecedor
	public int fornecedorCodigo(String nomeFor) {
		conecta.ConectarBanco();
		conecta.executaSQL("select *  from funcionário where nomeFun='" +nomeFor+ "'");
		int codigo =0;
		try {
			conecta.rs.first();
			codigo = conecta.rs.getInt("idFun");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível buscar o código fornecedor\n");
		}
		conecta.FecharBanco();
		return codigo;
	}
	
	// Pegar código do Produto
	public int produtoCodigo(String nomePro) {
		conecta.ConectarBanco();
		conecta.executaSQL("select *from produtos where nomePro='" +nomePro+ "'");
		
		int codigo = 0;
		try {
			conecta.rs.first();
			codigo = conecta.rs.getInt("idPro");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível buscar o código produto\n");
			JOptionPane.showMessageDialog(null, codPro);
		}
		conecta.FecharBanco();
		
		return codigo;

	}

}
