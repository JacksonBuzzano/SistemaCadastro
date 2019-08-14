package visão;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import conexão.ConexãoBD;
import controle.ControleProdutos;
import metodos.TabelaProduto;
import modelo.ModeloProduto;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.BevelBorder;

public class cadProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtMarca;
	private JTextField txtVenda;
	private JTextField txtQuantidade;
	private JTextField txtPesquisa;
	private JTextField txtCompra;
	private JTable tableProdutos;
	ConexãoBD conexao = new ConexãoBD();

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadProdutos frame = new cadProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */

	public cadProdutos() {
		setResizable(false);
		setTitle("Cadastro de Produtos");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jcksb\\Desktop\\jota.jpg"));

		conexao.ConectarBanco();
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 255));
		contentPane.setForeground(SystemColor.controlText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(SystemColor.controlText);
		lblNewLabel.setBounds(16, 13, 19, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(SystemColor.controlText);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(16, 57, 38, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Marca:");
		lblNewLabel_2.setForeground(SystemColor.controlText);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(16, 101, 40, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Valor Da Venda:");
		lblNewLabel_3.setForeground(SystemColor.controlText);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(337, 101, 97, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Quantidade:");
		lblNewLabel_4.setForeground(SystemColor.controlText);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(16, 151, 75, 15);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("Valor Compra:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(337, 57, 85, 15);
		contentPane.add(lblNewLabel_6);

		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtId.setEnabled(false);
		txtId.setBounds(45, 10, 85, 21);
		contentPane.add(txtId);
		txtId.setColumns(10);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNome.setEnabled(false);
		txtNome.setBounds(64, 54, 159, 21);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtMarca.setEnabled(false);
		txtMarca.setBounds(66, 98, 157, 21);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);

		txtVenda = new JTextField();
		txtVenda.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtVenda.setEnabled(false);
		txtVenda.setBounds(444, 98, 102, 21);
		contentPane.add(txtVenda);
		txtVenda.setColumns(10);

		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtQuantidade.setEnabled(false);
		txtQuantidade.setBounds(101, 148, 85, 21);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);

		txtPesquisa = new JTextField();
		txtPesquisa.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtPesquisa.setBounds(500, 171, 189, 21);
		contentPane.add(txtPesquisa);
		txtPesquisa.setColumns(10);

		txtCompra = new JTextField();
		txtCompra.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCompra.setEnabled(false);
		txtCompra.setBounds(432, 54, 97, 21);
		contentPane.add(txtCompra);
		txtCompra.setColumns(10);

		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instância classe Modelo Produto
				ModeloProduto mod = new ModeloProduto();
				
				mod.setPesquisar(txtPesquisa.getText());
				ControleProdutos control = new ControleProdutos();
				control.buscaProduto(mod);
				
				//Atualiza a tabela após Editar
				try {
					conexao.ConectarBanco();
					conexao.executaSQL("SELECT *FROM produtos WHERE nomePro LIKE'"+mod.getPesquisar()+"%'ORDER BY nomePro");
					tableProdutos.setModel(new TabelaProduto(conexao.rs));
					tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
					tableProdutos.getColumnModel().getColumn(0).setResizable(false);
					tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(175);
					tableProdutos.getColumnModel().getColumn(1).setResizable(false);
					tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(114);
					tableProdutos.getColumnModel().getColumn(2).setResizable(false);
					tableProdutos.getColumnModel().getColumn(3).setPreferredWidth(114);
					tableProdutos.getColumnModel().getColumn(3).setResizable(false);
					tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(164);
					tableProdutos.getColumnModel().getColumn(4).setResizable(false);
					tableProdutos.getColumnModel().getColumn(5).setPreferredWidth(175);
					tableProdutos.getColumnModel().getColumn(5).setResizable(false);
					tableProdutos.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
					tableProdutos.setAutoResizeMode(tableProdutos.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
					tableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "tabela nao atualizou");
					e1.printStackTrace();
				}
				
				txtPesquisa.setText("");
				txtCompra.setEnabled(true);
				txtMarca.setEnabled(true);
				txtNome.setEnabled(true);
				txtQuantidade.setEnabled(true);
				txtVenda.setEnabled(true);
			}

		});
		btnPesquisa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPesquisa.setBounds(699, 169, 97, 25);
		contentPane.add(btnPesquisa);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Abilita os campos
				txtCompra.setEnabled(true);
				txtMarca.setEnabled(true);
				txtNome.setEnabled(true);
				txtQuantidade.setEnabled(true);
				txtVenda.setEnabled(true);
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNovo.setBounds(93, 203, 75, 25);
		contentPane.add(btnNovo);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Instância classe Modelo Produto
				ModeloProduto mod = new ModeloProduto();

				mod.setCompra(Double.parseDouble(txtCompra.getText().toString()));
				mod.setMarca(txtMarca.getText());
				mod.setNome(txtNome.getText());
				mod.setQuantidade(Integer.parseInt(txtQuantidade.getText().toString()));
				mod.setVenda(Double.parseDouble(txtVenda.getText()));
				ControleProdutos control = new ControleProdutos();
				control.SalvarProduto(mod);
				
				//Abilita os campos e limpa os campos
				txtCompra.setEnabled(false);
				txtMarca.setEnabled(false);
				txtNome.setEnabled(false);
				txtQuantidade.setEnabled(false);
				txtVenda.setEnabled(false);
				txtCompra.setText("");
				txtId.setText("");
				txtMarca.setText("");
				txtNome.setText("");
				txtQuantidade.setText("");
				txtVenda.setText("");
					
				//Atualiza a tabela após Editar
				try {
					conexao.ConectarBanco();
					conexao.executaSQL("select *from produtos order by nomePro");
					tableProdutos.setModel(new TabelaProduto(conexao.rs));
					tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
					tableProdutos.getColumnModel().getColumn(0).setResizable(false);
					tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(175);
					tableProdutos.getColumnModel().getColumn(1).setResizable(false);
					tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(114);
					tableProdutos.getColumnModel().getColumn(2).setResizable(false);
					tableProdutos.getColumnModel().getColumn(3).setPreferredWidth(114);
					tableProdutos.getColumnModel().getColumn(3).setResizable(false);
					tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(164);
					tableProdutos.getColumnModel().getColumn(4).setResizable(false);
					tableProdutos.getColumnModel().getColumn(5).setPreferredWidth(175);
					tableProdutos.getColumnModel().getColumn(5).setResizable(false);
					tableProdutos.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
					tableProdutos.setAutoResizeMode(tableProdutos.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
					tableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "tabela nao atualizou");
					e1.printStackTrace();
				}
			}	
					
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalvar.setBounds(219, 203, 85, 25);
		contentPane.add(btnSalvar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Instância classe Modelo Produto
				ModeloProduto mod = new ModeloProduto();

				mod.setCompra(Double.valueOf(txtCompra.getText().toString()));
				mod.setId(Integer.parseInt(txtId.getText().toString()));
				mod.setMarca(txtMarca.getText());
				mod.setNome(txtNome.getText());
				mod.setQuantidade(Integer.parseInt(txtQuantidade.getText().toString()));
				mod.setVenda(Double.valueOf(txtVenda.getText().toString()));

				ControleProdutos control = new ControleProdutos();
				control.editarProduto(mod);

				//Abilita e limpa os campos
				txtCompra.setEnabled(false);
				txtMarca.setEnabled(false);
				txtNome.setEnabled(false);
				txtQuantidade.setEnabled(false);
				txtVenda.setEnabled(false);
				txtCompra.setText("");
				txtPesquisa.setText("");
				txtId.setText("");
				txtMarca.setText("");
				txtNome.setText("");
				txtQuantidade.setText("");
				txtVenda.setText("");

				//Atualiza a tabela após Editar
				try {
					conexao.ConectarBanco();
					conexao.executaSQL("select *from produtos order by nomePro");
					tableProdutos.setModel(new TabelaProduto(conexao.rs));
					tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
					tableProdutos.getColumnModel().getColumn(0).setResizable(false);
					tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(175);
					tableProdutos.getColumnModel().getColumn(1).setResizable(false);
					tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(114);
					tableProdutos.getColumnModel().getColumn(2).setResizable(false);
					tableProdutos.getColumnModel().getColumn(3).setPreferredWidth(114);
					tableProdutos.getColumnModel().getColumn(3).setResizable(false);
					tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(164);
					tableProdutos.getColumnModel().getColumn(4).setResizable(false);
					tableProdutos.getColumnModel().getColumn(5).setPreferredWidth(175);
					tableProdutos.getColumnModel().getColumn(5).setResizable(false);
					tableProdutos.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
					tableProdutos.setAutoResizeMode(tableProdutos.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
					tableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "tabela nao atualizou");
				}
			}

		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditar.setBounds(359, 203, 75, 25);
		contentPane.add(btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Instância classe Modelo Produto e Controle Produto
				ModeloProduto mod = new ModeloProduto();
				ControleProdutos control = new ControleProdutos();

				mod.setId(Integer.parseInt(txtId.getText()));
				control.excluirProduto(mod);
				
				//Limpa e desabilita os campos
				txtCompra.setEnabled(false);
				txtMarca.setEnabled(false);
				txtNome.setEnabled(false);
				txtQuantidade.setEnabled(false);
				txtVenda.setEnabled(false);
				txtCompra.setText("");
				txtPesquisa.setText("");
				txtMarca.setText("");
				txtId.setText("");
				txtNome.setText("");
				txtQuantidade.setText("");
				txtVenda.setText("");
				
				//Atualiza a tabela após Editar
				try {
					conexao.ConectarBanco();
					conexao.executaSQL("select *from produtos order by nomePro");
					tableProdutos.setModel(new TabelaProduto(conexao.rs));
					tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
					tableProdutos.getColumnModel().getColumn(0).setResizable(false);
					tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(175);
					tableProdutos.getColumnModel().getColumn(1).setResizable(false);
					tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(114);
					tableProdutos.getColumnModel().getColumn(2).setResizable(false);
					tableProdutos.getColumnModel().getColumn(3).setPreferredWidth(114);
					tableProdutos.getColumnModel().getColumn(3).setResizable(false);
					tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(164);
					tableProdutos.getColumnModel().getColumn(4).setResizable(false);
					tableProdutos.getColumnModel().getColumn(5).setPreferredWidth(175);
					tableProdutos.getColumnModel().getColumn(5).setResizable(false);
					tableProdutos.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
					tableProdutos.setAutoResizeMode(tableProdutos.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
					tableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "tabela nao atualizou");
				}
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExcluir.setBounds(500, 203, 85, 25);
		contentPane.add(btnExcluir);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Limpa e desabila os campos
				txtCompra.setEnabled(false);
				txtMarca.setEnabled(false);
				txtNome.setEnabled(false);
				txtQuantidade.setEnabled(false);
				txtVenda.setEnabled(false);
				txtCompra.setText("");
				txtMarca.setText("");
				txtNome.setText("");
				txtPesquisa.setText("");
				txtId.setText("");
				txtQuantidade.setText("");
				txtVenda.setText("");
				//Atualiza a tabela
				try {
					conexao.ConectarBanco();
					conexao.executaSQL("select *from produtos order by nomePro");
					tableProdutos.setModel(new TabelaProduto(conexao.rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Nao funcionaou");
				}
				tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
				tableProdutos.getColumnModel().getColumn(0).setResizable(false);
				tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(175);
				tableProdutos.getColumnModel().getColumn(1).setResizable(false);
				tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(114);
				tableProdutos.getColumnModel().getColumn(2).setResizable(false);
				tableProdutos.getColumnModel().getColumn(3).setPreferredWidth(114);
				tableProdutos.getColumnModel().getColumn(3).setResizable(false);
				tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(164);
				tableProdutos.getColumnModel().getColumn(4).setResizable(false);
				tableProdutos.getColumnModel().getColumn(5).setPreferredWidth(175);
				tableProdutos.getColumnModel().getColumn(5).setResizable(false);
				tableProdutos.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
				tableProdutos.setAutoResizeMode(tableProdutos.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
				tableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(631, 203, 97, 25);
		contentPane.add(btnCancelar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 239, 751, 180);
		contentPane.add(scrollPane);

		tableProdutos = new JTable();
		tableProdutos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableProdutos.setBackground(new Color(204, 255, 255));
		try {
			conexao.ConectarBanco();
			conexao.executaSQL("select *from produtos order by nomePro");
			tableProdutos.setModel(new TabelaProduto(conexao.rs));
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nao funcionaou");
		}
		tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableProdutos.getColumnModel().getColumn(0).setResizable(false);
		tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(175);
		tableProdutos.getColumnModel().getColumn(1).setResizable(false);
		tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(90);
		tableProdutos.getColumnModel().getColumn(2).setResizable(false);
		tableProdutos.getColumnModel().getColumn(3).setPreferredWidth(90);
		tableProdutos.getColumnModel().getColumn(3).setResizable(false);
		tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(164);
		tableProdutos.getColumnModel().getColumn(4).setResizable(false);
		tableProdutos.getColumnModel().getColumn(5).setPreferredWidth(162);
		tableProdutos.getColumnModel().getColumn(5).setResizable(false);
		tableProdutos.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
		tableProdutos.setAutoResizeMode(tableProdutos.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
		tableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha

		scrollPane.setViewportView(tableProdutos);

		tableProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// carregar os dados para os campos
				String nomePro = "" + tableProdutos.getValueAt(tableProdutos.getSelectedRow(), 1);
				conexao.ConectarBanco();
				conexao.executaSQL("select * from produtos where nomePro='" + nomePro + "'");
				try {
					conexao.rs.first();
					txtId.setText(String.valueOf(conexao.rs.getInt("idPro")));
					txtCompra.setText(conexao.rs.getString("compraPro"));
					txtMarca.setText(conexao.rs.getString("marcaPro"));
					txtNome.setText(conexao.rs.getString("nomePro"));
					txtQuantidade.setText(conexao.rs.getString("qntPro"));
					txtVenda.setText(conexao.rs.getString("vendaPro"));
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao carrega os campos");
				}
				conexao.FecharBanco();
				txtCompra.setEnabled(true);
				txtMarca.setEnabled(true);
				txtNome.setEnabled(true);
				txtQuantidade.setEnabled(true);
				txtVenda.setEnabled(true);
			}
		});

	}

}
