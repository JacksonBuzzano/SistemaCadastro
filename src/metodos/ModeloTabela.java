package metodos;


	
	
	import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

	
	public class ModeloTabela extends AbstractTableModel {
		
		private ArrayList<?> linhas = null;
		private String[] colunas = null;

		public ModeloTabela(ArrayList<?> lin, String[] col) {
			setLinhas(lin);
			setColunas(col);
		}

		public ArrayList<?> getLinhas() {
			return linhas;
		}

		public void setLinhas(ArrayList<?> dados) {
			linhas = dados;
		}

		public String[] getColinas() {
			return colunas;
		}

		public void setColunas(String[] nomes) {
			colunas = nomes;
		}

		public int getColumnCount() {
			return colunas.length;
		}

		public int getRowCount() {
			return linhas.size();
		}

		public String getColumnName(int numCol) {
			return colunas[numCol];
		}

		public Object getValueAt(int numlin, int numCol) {
			Object[] linha = (Object[]) getLinhas().get(numlin);
			return linha[numCol];
		}

	}
