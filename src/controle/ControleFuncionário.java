package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import conex�o.Conex�oBD;
import modelo.ModeloFuncionario;

public class ControleFuncion�rio {

	Conex�oBD conecta = new Conex�oBD();

	public void SalvarFuncionario(ModeloFuncionario modFun) {
		conecta.ConectarBanco();

		try {
			PreparedStatement pst = conecta.conn.prepareStatement(
					"INSERT INTO funcion�rio(nomeFun, cpfFun, nascimentoFun, enderecoFun, numeroFun, cidadeFun, estadoFun, telefoneFun, funcaoFun) values (?,?,?,?,?,?,?,?,?)");
			pst.setString(1, modFun.getNome());
			pst.setString(2, modFun.getCpf());
			pst.setString(3, modFun.getNascimento());
			pst.setString(4, modFun.getEndereco());
			pst.setInt(5, modFun.getNumero());
			pst.setString(6, modFun.getCidade());
			pst.setString(7, modFun.getEstado());
			pst.setString(8, modFun.getTelefone());
			pst.setString(9, modFun.getFuncao());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Funcion�rio cadastrado com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel Salvar\n Tente novamente");
		}
		conecta.FecharBanco();

	}

	public ModeloFuncionario buscaFuncionario(ModeloFuncionario modfun) {
		conecta.ConectarBanco();

		conecta.executaSQL("select * from funcion�rio where nomeFun like '%" + modfun.getPesquisa() + "%'");
		try {
			conecta.rs.first();
			modfun.setCidade(conecta.rs.getString("cidadeFun"));
			modfun.setCpf(conecta.rs.getString("cpfFun"));
			modfun.setEndereco(conecta.rs.getString("enderecoFun"));
			modfun.setEstado(conecta.rs.getString("estadoFun"));
			modfun.setFuncao(conecta.rs.getString("funcaoFun"));
			modfun.setId(conecta.rs.getInt("idFun"));
			modfun.setNascimento(conecta.rs.getString("nascimentoFun"));
			modfun.setNome(conecta.rs.getString("nomeFun"));
			modfun.setNumero(conecta.rs.getInt("numeroFun"));
			modfun.setTelefone(conecta.rs.getString("telefoneFun"));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao pesquisar\nFuncion�rio n�o cadastrado" );
		}
		conecta.FecharBanco();
		return modfun;
	}

	public void editaFuncin�rio(ModeloFuncionario modFun) {
		conecta.ConectarBanco();
		try {
			PreparedStatement pst = conecta.conn.prepareStatement(
					"update funcion�rio set nomeFun=?, cpfFun=?, nascimentoFun=?, enderecoFun=?, numeroFun=?, cidadeFun=?, estadoFun=?, telefoneFun=?, funcaoFun=? where idFun=?");
			pst.setString(1, modFun.getNome());
			pst.setString(2, modFun.getCpf());
			pst.setString(3, modFun.getNascimento());
			pst.setString(4, modFun.getEndereco());
			pst.setInt(5, modFun.getNumero());
			pst.setString(6, modFun.getCidade());
			pst.setString(7, modFun.getEstado());
			pst.setString(8, modFun.getTelefone());
			pst.setString(9, modFun.getFuncao());
			pst.setInt(10, modFun.getId());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Editado com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar\n" );
		}
	}

	public void excluirFuncion�rio(ModeloFuncionario modFun) {
		conecta.ConectarBanco();
		try {
			PreparedStatement pst = conecta.conn.prepareStatement("delete  from funcion�rio where idFun=?");
			pst.setInt(1, modFun.getId());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir\n");
		}
	}

	
}
