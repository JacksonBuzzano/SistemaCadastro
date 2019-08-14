package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import conex�o.Conex�oBD;
import modelo.ModeloVendas;

public class ControleVendas {
	Conex�oBD conecta = new Conex�oBD();

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
			//JOptionPane.showMessageDialog(null, "N�o foi poss�vel Salvar Produto \n" );

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
			JOptionPane.showMessageDialog(null, "Produto n�o cadastrado!!");
		}
		conecta.FecharBanco();

	}

	// Pegar c�digo do Fornecedor
	public int fornecedorCodigo(String nomeFor) {
		conecta.ConectarBanco();
		conecta.executaSQL("select *  from funcion�rio where nomeFun='" +nomeFor+ "'");
		int codigo =0;
		try {
			conecta.rs.first();
			codigo = conecta.rs.getInt("idFun");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel buscar o c�digo fornecedor\n");
		}
		conecta.FecharBanco();
		return codigo;
	}
	
	// Pegar c�digo do Produto
	public int produtoCodigo(String nomePro) {
		conecta.ConectarBanco();
		conecta.executaSQL("select *from produtos where nomePro='" +nomePro+ "'");
		
		int codigo = 0;
		try {
			conecta.rs.first();
			codigo = conecta.rs.getInt("idPro");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel buscar o c�digo produto\n");
			JOptionPane.showMessageDialog(null, codPro);
		}
		conecta.FecharBanco();
		
		return codigo;

	}

}
