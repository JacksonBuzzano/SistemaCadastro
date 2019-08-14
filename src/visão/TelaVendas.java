package visão;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import conexão.ConexãoBD;
import controle.ControleVendas;
import metodos.TabelaProduto;
import modelo.ModeloVendas;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JFormattedTextField;

public class TelaVendas extends JFrame {

	private JPanel contentPane;
	private JTextField txtProduto;
	private JTextField txtValor;
	private JTextField txtQuantidade;
	private JTextField txtTotal;
	ConexãoBD conexao = new ConexãoBD();
	private JTextField txtxP;
	DefaultTableModel dtm = new DefaultTableModel();
	DefaultTableModel lista = new DefaultTableModel();
	private JTable tabelaLista;
	private JTextField textFieldTotal;
	private JTextField txtData;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVendas frame = new TelaVendas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	  
	  /** Create the frame.
	 */
	public TelaVendas() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jcksb\\Desktop\\jota.jpg"));
		setTitle("Vendas");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 255));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		//contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Produto:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 78, 52, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Valor R$");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 171, 52, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Quantidade:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 120, 75, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Total R$");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_4.setBounds(586, 400, 114, 33);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Forma Pagamento:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 326, 113, 15);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel("Operador:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(10, 27, 60, 15);
		contentPane.add(lblNewLabel_7);

		JComboBox<String> cbPagamento = new JComboBox<String>();
		cbPagamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		ModeloVendas mod = new ModeloVendas();

		cbPagamento.addItem(String.valueOf(mod.getN1()));
		cbPagamento.addItem(String.valueOf(mod.getN2()));
		cbPagamento.addItem(String.valueOf(mod.getN3()));
		cbPagamento.addItem(String.valueOf(mod.getN4()));

		cbPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obter a forma de pagamento
				String pagamento = cbPagamento.getSelectedItem().toString();
			}
		});

		JLabel lblListaDeProdutos = new JLabel(" Itens da Compra");
		lblListaDeProdutos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblListaDeProdutos.setBounds(656, 14, 216, 31);
		contentPane.add(lblListaDeProdutos);

		JLabel lblListaDeProdutos_1 = new JLabel("Lista de Produtos");
		lblListaDeProdutos_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblListaDeProdutos_1.setBounds(309, 14, 217, 31);
		contentPane.add(lblListaDeProdutos_1);
		cbPagamento.setBounds(133, 322, 91, 23);
		contentPane.add(cbPagamento);

		JComboBox<String> cbOperador = new JComboBox<String>();
		cbOperador.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbOperador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		cbOperador.addMouseListener(new MouseAdapter() {
			{
				conexao.ConectarBanco();
				// Seleciona na minha tabela funcionário fazendo o filtro pela Função
				conexao.executaSQL(
						"SELECT nomeFun,funcaoFun FROM funcionário WHERE funcaoFun='caixa' order by nomeFun");

				try {
					conexao.rs.first();
					cbOperador.removeAllItems();
					do {
						cbOperador.addItem(conexao.rs.getString("nomeFun"));
						cbOperador.setSelectedItem(cbOperador);

					} while (conexao.rs.next());
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "erro\n" + e.getMessage());
				}

				conexao.FecharBanco();
			}

		});
		cbOperador.setBounds(80, 23, 146, 23);
		contentPane.add(cbOperador);

		JButton btnNova = new JButton("Nova");
		btnNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Limpa os campos da tabela
				dtm.setRowCount(0);
				txtProduto.setText("");
				txtQuantidade.setText("");
				txtTotal.setText("");
				txtValor.setText("");

			}
		});
		btnNova.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNova.setBounds(34, 408, 89, 28);
		contentPane.add(btnNova);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(242, 410, 96, 25);
		contentPane.add(btnCancelar);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int registros = dtm.getRowCount();

				for (int indice = 0; indice < registros; indice++) {
					// Obter o nome do fornecedor
					String nomeFornecedor = dtm.getValueAt(indice, 0).toString();

					// Obter o nome do produto
					String nomeProduto = dtm.getValueAt(indice, 1).toString();

					// Obter a quantidade e o valor do produto
					int quantidadeProduto = Integer.parseInt(dtm.getValueAt(indice, 2).toString());
					double valorProduto = Double.parseDouble(dtm.getValueAt(indice, 3).toString());
					double total = quantidadeProduto * valorProduto;

					// Instância da classe ModeloVEndas e Controle Vendas
					ModeloVendas m = new ModeloVendas();
					m.setData(txtData.getText());
					// Instância da classe ControleVendas
					ControleVendas cv = new ControleVendas();
					int codigoFornecedor = cv.fornecedorCodigo(nomeFornecedor);
					int codigoProduto = cv.produtoCodigo(nomeProduto);

					// Executar a inserção
					try {
						ConexãoBD c = new ConexãoBD();
						c.ConectarBanco();
						String sql = "INSERT INTO vendas (produtoVenda, valorVenda, operadorVenda, dataVenda) VALUES (?,?,?,?)";
						PreparedStatement pstmt = c.conn.prepareStatement(sql);
						pstmt.setInt(1, codigoProduto);
						pstmt.setDouble(2, total);
						pstmt.setInt(3, codigoFornecedor);
						pstmt.setString(4, m.getData());
						pstmt.execute();
					} catch (Exception ritaCadilac) {
						JOptionPane.showMessageDialog(null, "nada\n" + ritaCadilac);
					}
				}
				// limpa os campos de toda a tabela
				dtm.setRowCount(0);

				conexao.FecharBanco();

				// Dividi a conta total
				ModeloVendas vendas = new ModeloVendas();
				vendas.setTotal(Double.parseDouble(textFieldTotal.getText()));
				vendas.setPagt(Integer.parseInt((String) cbPagamento.getSelectedItem()));

				textFieldTotal.setText(String.valueOf(vendas.calcula()));
				JOptionPane.showMessageDialog(null, "Valor total é R$" + textFieldTotal.getText() + " em "
						+ cbPagamento.getSelectedItem() + " vezes");

				// Limpa os campos
				txtProduto.setText("");
				txtQuantidade.setText("");
				textFieldTotal.setText("");
				txtValor.setText("");

			}

		});
		btnFinalizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFinalizar.setBounds(393, 410, 96, 25);
		contentPane.add(btnFinalizar);

		JButton btnAdd = new JButton("Adiciona");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ModeloVendas mod = new ModeloVendas();
				int q = 0, resul = 0, qn = 0;
				conexao.ConectarBanco();
				// Procura produto no banco para ver se tem quantidade sufuciente no estoque
				try {
					conexao.executaSQL("select * from produtos where nomePro='" + txtProduto.getText() + "'");
					conexao.rs.first();
					q = conexao.rs.getInt("qntPro");
					if (q >= Integer.parseInt(txtQuantidade.getText())) {
						mod.setProduto(txtProduto.getText());
						mod.setValor(Double.parseDouble(txtValor.getText()));
						mod.setOp((String) cbOperador.getSelectedItem());
						mod.setQnt(Integer.parseInt(txtQuantidade.getText()));
						dtm.addRow(new Object[] { cbOperador.getSelectedItem(), txtProduto.getText(),
								txtQuantidade.getText(), txtValor.getText() });

						// Faz a baixa no estoque na tabela de produtos
						qn = conexao.rs.getInt("qntPro");
						resul = qn - mod.getQnt();
						String sql = "update produtos set qntPro=? where nomePro=?";
						PreparedStatement pst = conexao.conn.prepareStatement(sql);
						pst.setInt(1, resul);
						pst.setString(2, mod.getProduto());
						pst.execute();
					} else {
						JOptionPane.showMessageDialog(null, "Produto insuficiente no estoque!!");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro na pesquisa na qnt de produto!!");
				}

				// Multiplica as colunas na tabela
				double parcial = 0;
				double total = 0;
				for (int i = 0; i < dtm.getRowCount(); i++) {
					parcial += Double.parseDouble(dtm.getValueAt(i, 3).toString())
							* Double.parseDouble(dtm.getValueAt(i, 2).toString());
				}
				total = parcial;

				textFieldTotal.setText(String.valueOf(total));
				txtProduto.setText("");
				txtQuantidade.setText("");
				txtValor.setText("");
				txtxP.setText("");
				conexao.FecharBanco();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBounds(136, 410, 96, 25);
		contentPane.add(btnAdd);

		JButton btnPes = new JButton("Pesquisa Produto");
		btnPes.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ModeloVendas mod = new ModeloVendas();

				mod.setPesquisa(txtxP.getText());
				ControleVendas control = new ControleVendas();
				control.buscaPro(mod);
				// txtProduto.setText(mod.getProduto());
				// txtValor.setText(String.valueOf(mod.getValor()));
				conexao.ConectarBanco();
				try {
					conexao.executaSQL("SELECT nomePro, vendaPro, qntPro, marcaPro FROM produtos WHERE nomePro LIKE'"
							+ mod.getPesquisa() + "%'");
					conexao.rs.first();
					tabelaLista.setModel(new TabelaProduto(conexao.rs));
					tabelaLista.getColumnModel().getColumn(0).setPreferredWidth(116); // Comprimento da coluna
					tabelaLista.getColumnModel().getColumn(0).setResizable(false); // Não pode dimensionar a coluna com
																					// o mause
					tabelaLista.getColumnModel().getColumn(1).setPreferredWidth(85);
					tabelaLista.getColumnModel().getColumn(1).setResizable(false);
					tabelaLista.getColumnModel().getColumn(2).setPreferredWidth(65);
					tabelaLista.getColumnModel().getColumn(2).setResizable(false);
					tabelaLista.getColumnModel().getColumn(3).setPreferredWidth(73);
					tabelaLista.getColumnModel().getColumn(3).setResizable(false);
					tabelaLista.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
					tabelaLista.setAutoResizeMode(tabelaLista.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
					tabelaLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma
																						// linha
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Erro na pesquisa na tebela");
				}
			}

		});
		btnPes.setBounds(10, 237, 157, 33);
		contentPane.add(btnPes);

		textFieldTotal = new JTextField();
		textFieldTotal.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldTotal.setBounds(700, 399, 214, 37);
		contentPane.add(textFieldTotal);
		textFieldTotal.setColumns(10);

		txtProduto = new JTextField();
		txtProduto.setFont(new Font("Dialog", Font.BOLD, 14));
		txtProduto.setBounds(72, 73, 120, 23);
		contentPane.add(txtProduto);
		txtProduto.setColumns(10);

		txtValor = new JTextField();
		txtValor.setFont(new Font("Dialog", Font.BOLD, 14));
		txtValor.setBounds(61, 168, 106, 21);
		contentPane.add(txtValor);
		txtValor.setColumns(10);

		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Dialog", Font.BOLD, 14));
		txtQuantidade.setBounds(86, 117, 75, 21);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);

		txtxP = new JTextField();
		txtxP.setFont(new Font("Dialog", Font.BOLD, 14));
		txtxP.setBounds(169, 238, 77, 31);
		contentPane.add(txtxP);
		txtxP.setColumns(10);

		// Tabela
		JTable tabela = new JTable(dtm);
		tabela.setFont(new Font("Tahoma", Font.PLAIN, 12));

		dtm.addColumn(" Operador ");
		dtm.addColumn("Produto ");
		dtm.addColumn(" Qnt ");
		dtm.addColumn(" Valor ");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(85); // Comprimento da coluna
		tabela.getColumnModel().getColumn(0).setResizable(false); // Não pode dimensionar a coluna com o mause
		tabela.getColumnModel().getColumn(1).setPreferredWidth(86);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(32);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(58);
		tabela.getColumnModel().getColumn(3).setResizable(false);
		tabela.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
		tabela.setAutoResizeMode(tabela.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha

		JScrollPane scrollPaneVenda = new JScrollPane(tabela);
		scrollPaneVenda.setBounds(635, 56, 264, 334);
		contentPane.add(scrollPaneVenda);

		JScrollPane scrollPaneLista = new JScrollPane();
		scrollPaneLista.setBounds(256, 55, 342, 334);
		contentPane.add(scrollPaneLista);

		// tabela com itens em estoque
		tabelaLista = new JTable();
		tabelaLista.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabelaLista.setBackground(new Color(204, 255, 255));

		tabelaLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// carregar os dados para os campos
				String nomePro = "" + tabelaLista.getValueAt(tabelaLista.getSelectedRow(), 0);
				conexao.ConectarBanco();
				try {
					conexao.executaSQL(
							"SELECT nomePro, vendaPro, qntPro FROM produtos WHERE nomePro='" + nomePro + "'");
					conexao.rs.first();
					txtProduto.setText(conexao.rs.getString("nomePro"));
					txtValor.setText(conexao.rs.getString("vendaPro"));
					// txtQuantidade.setText(conexao.rs.getString("qntPro"));
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao carrega as lebel " + e1.getMessage());
					JOptionPane.showMessageDialog(null, nomePro);
				}
				conexao.FecharBanco();
			}
		});
		tabelaLista.setFont(new Font("Tahoma", Font.PLAIN, 12));
		// lista.addColumn("Produto");
		// lista.addColumn("Valor");
		// lista.addColumn("Quantidade");
		// lista.addColumn("Marca");
		scrollPaneLista.setViewportView(tabelaLista);

		txtData = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##/####");
			JFormattedTextField txtData_1 = new javax.swing.JFormattedTextField(format_textField4);
			txtData_1.setEnabled(false);
		} catch (Exception e) {
		}
		txtData.setBounds(10, 458, 60, 15);
		contentPane.add(txtData);
		txtData.setColumns(10);

		
		//Pegar data do Sitema
		Date data = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("MM/YYYY");
		txtData.setText(formatar.format(data));
		
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##/####");
			JFormattedTextField JFormattedTextField = new javax.swing.JFormattedTextField(format_textField4);
			JFormattedTextField.setEnabled(false);
		} catch (Exception e) {
		}
		
		
		
	}
	// Metodos para salvar campo DATA que esta formatado
			public String dataParaMysql(String data) {

				String mes = txtData.getText().substring(0, 2);
				String ano = txtData.getText().substring(3, 5);
				//String ano = txtData.getText().substring(6);

				String dataParaMysql = mes + "/" + ano;

				return dataParaMysql;
			}
}
