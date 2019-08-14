package metodos;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class TabelaLista extends AbstractTableModel {

	private int colunas, linhas;
	private ResultSet resultset;
	private ResultSetMetaData rsMetaData;

	public TabelaLista(ResultSet resultset) throws SQLException {
		rsMetaData = resultset.getMetaData();
		this.resultset = resultset;
		// select * from produtos
		resultset.last();
		linhas = resultset.getRow();
		fireTableStructureChanged();

	}

	public String getColumnName(int column) {
		try {
			return rsMetaData.getColumnName(column + 1);
		} catch (Exception e) {

		}

		return "";

	}

	public int getRowCount() {
		return linhas;
	}

	public int getColumnCount() {
		colunas = 0;
		try {
			colunas = rsMetaData.getColumnCount();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao ler quantas colunas \n" + e.getMessage());
		}
		return colunas;

	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			resultset.absolute(rowIndex + 1);
			return resultset.getObject(columnIndex + 1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
			return "";
		}
	}

}
