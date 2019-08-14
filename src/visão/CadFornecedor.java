package visão;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import conexão.ConexãoBD;
import controle.ControleFornecedor;
import metodos.TabelaFornecedor;
import modelo.ModeloFornecedor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class CadFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtTelefone_1;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtCnpj_1;
	private JTextField txtNasci_1;
	private JTextField txtEmail;
	private JTextField txtPesquisar;
	private JTextField txtId;
	private JTable tableFornecedor;
	ConexãoBD conexao = new ConexãoBD();

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadFornecedor frame = new CadFornecedor();
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
	public CadFornecedor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jcksb\\Desktop\\jota.jpg"));
		setTitle("Cadastro de Fornecedor");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		//contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cidade:");
		lblNewLabel.setBounds(224, 101, 46, 15);
		lblNewLabel.setForeground(SystemColor.controlText);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(11, 56, 38, 15);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(SystemColor.controlText);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o:");
		lblNewLabel_2.setBounds(11, 146, 59, 15);
		lblNewLabel_2.setForeground(SystemColor.controlText);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setBounds(198, 12, 56, 15);
		lblNewLabel_3.setForeground(SystemColor.controlText);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Estado:");
		lblNewLabel_4.setBounds(488, 101, 44, 15);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(SystemColor.controlText);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Cnpj:");
		lblNewLabel_5.setBounds(516, 12, 32, 15);
		lblNewLabel_5.setForeground(SystemColor.controlText);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Data Nasc:");
		lblNewLabel_6.setBounds(11, 101, 64, 15);
		lblNewLabel_6.setForeground(SystemColor.controlText);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("E-Mail:");
		lblNewLabel_7.setBounds(309, 56, 42, 15);
		lblNewLabel_7.setForeground(SystemColor.controlText);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_7);

		new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("(##)#####-####");
			txtTelefone_1 = new javax.swing.JFormattedTextField(format_textField4);
			txtTelefone_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtTelefone_1.setBounds(255, 10, 108, 20);
			txtTelefone_1.setEnabled(false);
		} catch (Exception e) {
		}

		JLabel lblNewLabel_8 = new JLabel("ID:");
		lblNewLabel_8.setBounds(11, 12, 19, 15);
		lblNewLabel_8.setForeground(SystemColor.controlText);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_8);
		contentPane.add(txtTelefone_1);
		txtTelefone_1.setColumns(10);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNome.setBounds(59, 54, 224, 20);
		txtNome.setEnabled(false);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtEndereco.setBounds(80, 144, 210, 20);
		txtEndereco.setEnabled(false);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCidade.setBounds(272, 99, 156, 20);
		txtCidade.setEnabled(false);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtEstado.setBounds(542, 99, 46, 20);
		txtEstado.setEnabled(false);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);

		new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##.###.###/####-##");
			txtCnpj_1 = new javax.swing.JFormattedTextField(format_textField4);
			txtCnpj_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtCnpj_1.setBounds(551, 10, 156, 20);
			txtCnpj_1.setEnabled(false);
		} catch (Exception e) {
		}
		contentPane.add(txtCnpj_1);
		txtCnpj_1.setColumns(10);

		new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##/##/####");
			txtNasci_1 = new javax.swing.JFormattedTextField(format_textField4);
			txtNasci_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtNasci_1.setBounds(78, 96, 91, 20);
			txtNasci_1.setEnabled(false);
		} catch (Exception e) {
		}
		contentPane.add(txtNasci_1);
		txtNasci_1.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtEmail.setBounds(354, 54, 191, 20);
		txtEmail.setEnabled(false);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtPesquisar = new JTextField();
		txtPesquisar.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPesquisar.setBounds(423, 144, 183, 20);
		contentPane.add(txtPesquisar);
		txtPesquisar.setColumns(10);

		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtId.setBounds(40, 10, 38, 20);
		txtId.setEnabled(false);
		txtId.setForeground(SystemColor.textHighlight);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(616, 141, 108, 25);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModeloFornecedor mod = new ModeloFornecedor();
				mod.setPesquisa(txtPesquisar.getText());
				
				ControleFornecedor control = new ControleFornecedor();
				control.buscaFornecedor(mod);
				
				//Atualizar tabela depois de salvar
				try {
					conexao.ConectarBanco();
					conexao.executaSQL(
							"SELECT idFor,nomeFor,cnpjFor,telefoneFor,emailFor,enderecoFor,cidadeFor,estadoFor,nascimentoFor"
							+ " FROM fornecedor WHERE nomeFor LIKE'"+mod.getPesquisa()+"%'order by nomeFor");
					tableFornecedor.setModel(new TabelaFornecedor(conexao.rs));
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Fornecedor não  encontrado/n Tente novamente");
				}
				tableFornecedor.getColumnModel().getColumn(0).setPreferredWidth(25); // Comprimento da coluna
				tableFornecedor.getColumnModel().getColumn(0).setResizable(false); // Não pode dimensionar a coluna com o mause
				tableFornecedor.getColumnModel().getColumn(1).setPreferredWidth(125);
				tableFornecedor.getColumnModel().getColumn(1).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(2).setPreferredWidth(118);
				tableFornecedor.getColumnModel().getColumn(2).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(3).setPreferredWidth(100);
				tableFornecedor.getColumnModel().getColumn(3).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(4).setPreferredWidth(125);
				tableFornecedor.getColumnModel().getColumn(4).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(5).setPreferredWidth(100);
				tableFornecedor.getColumnModel().getColumn(5).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(6).setPreferredWidth(48);
				tableFornecedor.getColumnModel().getColumn(5).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(7).setPreferredWidth(40);
				tableFornecedor.getColumnModel().getColumn(7).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(8).setPreferredWidth(73);
				tableFornecedor.getColumnModel().getColumn(8).setResizable(false);
				tableFornecedor.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
				tableFornecedor.setAutoResizeMode(tableFornecedor.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
				tableFornecedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
				
				txtCidade.setEnabled(true);
				txtCnpj_1.setEnabled(true);
				txtEmail.setEnabled(true);
				txtEndereco.setEnabled(true);
				txtEstado.setEnabled(true);
				txtNasci_1.setEnabled(true);
				txtNome.setEnabled(true);
				txtTelefone_1.setEnabled(true);
				txtPesquisar.setText("");
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnPesquisar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(80, 199, 79, 25);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCidade.setEnabled(true);
				txtCnpj_1.setEnabled(true);
				txtEmail.setEnabled(true);
				txtEndereco.setEnabled(true);
				txtEstado.setEnabled(true);
				txtNasci_1.setEnabled(true);
				txtNome.setEnabled(true);
				txtTelefone_1.setEnabled(true);
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnNovo);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(211, 199, 79, 25);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ModeloFornecedor mod = new ModeloFornecedor();

				mod.setCidade(txtCidade.getText());
				mod.setCnpj(cpfParaMysql(txtCnpj_1.getText()));
				mod.setEndereco(txtEndereco.getText());
				mod.setEstado(txtEstado.getText());
				mod.setNascimento(dataParaMysql(txtNasci_1.getText()));
				mod.setNome(txtNome.getText());
				mod.setTelefone(numeroParaMysql(txtTelefone_1.getText()));
				mod.setEmail(txtEmail.getText());

				ControleFornecedor control = new ControleFornecedor();
				control.salvarFornecedor(mod);

				txtCidade.setEnabled(false);
				txtCnpj_1.setEnabled(false);
				txtEmail.setEnabled(false);
				txtEndereco.setEnabled(false);
				txtEstado.setEnabled(false);
				txtNasci_1.setEnabled(false);
				txtNome.setEnabled(false);
				txtTelefone_1.setEnabled(false);
				txtCidade.setText("");
				txtCnpj_1.setText("");
				txtEmail.setText("");
				txtPesquisar.setText("");
				txtEndereco.setText("");
				txtEstado.setText("");
				txtNasci_1.setText("");
				txtId.setText("");
				txtNome.setText("");
				txtTelefone_1.setText("");
				
				//Atualizar tabela depois de salvar
				try {
					conexao.ConectarBanco();
					conexao.executaSQL(
							"select idFor,nomeFor,cnpjFor,telefoneFor,emailFor,enderecoFor,cidadeFor,estadoFor,nascimentoFor from fornecedor order by nomeFor");
					tableFornecedor.setModel(new TabelaFornecedor(conexao.rs));
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Cadastro não realizado/n Tente novamente");
				}
				tableFornecedor.getColumnModel().getColumn(0).setPreferredWidth(25); // Comprimento da coluna
				tableFornecedor.getColumnModel().getColumn(0).setResizable(false); // Não pode dimensionar a coluna com o mause
				tableFornecedor.getColumnModel().getColumn(1).setPreferredWidth(125);
				tableFornecedor.getColumnModel().getColumn(1).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(2).setPreferredWidth(118);
				tableFornecedor.getColumnModel().getColumn(2).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(3).setPreferredWidth(100);
				tableFornecedor.getColumnModel().getColumn(3).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(4).setPreferredWidth(125);
				tableFornecedor.getColumnModel().getColumn(4).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(5).setPreferredWidth(100);
				tableFornecedor.getColumnModel().getColumn(5).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(6).setPreferredWidth(48);
				tableFornecedor.getColumnModel().getColumn(5).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(7).setPreferredWidth(40);
				tableFornecedor.getColumnModel().getColumn(7).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(8).setPreferredWidth(73);
				tableFornecedor.getColumnModel().getColumn(8).setResizable(false);
				tableFornecedor.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
				tableFornecedor.setAutoResizeMode(tableFornecedor.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
				tableFornecedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnSalvar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(346, 199, 82, 25);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ModeloFornecedor mod = new ModeloFornecedor();

				mod.setCidade(txtCidade.getText());
				mod.setCnpj(cpfParaMysql(txtCnpj_1.getText()));
				mod.setEndereco(txtEndereco.getText());
				mod.setEstado(txtEstado.getText());
				mod.setNascimento(dataParaMysql(txtNasci_1.getText()));
				mod.setNome(txtNome.getText());
				mod.setTelefone(numeroParaMysql(txtTelefone_1.getText()));
				mod.setEmail(txtEmail.getText());
				mod.setId(Integer.parseInt(txtId.getText()));
				ControleFornecedor control = new ControleFornecedor();
				control.editaFornecedor(mod);

				txtCidade.setEnabled(false);
				txtCnpj_1.setEnabled(false);
				txtEmail.setEnabled(false);
				txtEndereco.setEnabled(false);
				txtEstado.setEnabled(false);
				txtNasci_1.setEnabled(false);
				txtNome.setEnabled(false);
				txtTelefone_1.setEnabled(false);
				txtCidade.setText("");
				txtPesquisar.setText("");
				txtCnpj_1.setText("");
				txtEmail.setText("");
				txtEndereco.setText("");
				txtEstado.setText("");
				txtNasci_1.setText("");
				txtId.setText("");
				txtNome.setText("");
				txtTelefone_1.setText("");
				
				//Atualizar tabela depois de editar
				try {
					conexao.ConectarBanco();
					conexao.executaSQL(
							"select idFor,nomeFor,cnpjFor,telefoneFor,emailFor,enderecoFor,cidadeFor,estadoFor,nascimentoFor from fornecedor order by nomeFor");
					tableFornecedor.setModel(new TabelaFornecedor(conexao.rs));
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Não foi possivel editar/n Tente novamente");
				}
				tableFornecedor.getColumnModel().getColumn(0).setPreferredWidth(25); // Comprimento da coluna
				tableFornecedor.getColumnModel().getColumn(0).setResizable(false); // Não pode dimensionar a coluna com o mause
				tableFornecedor.getColumnModel().getColumn(1).setPreferredWidth(125);
				tableFornecedor.getColumnModel().getColumn(1).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(2).setPreferredWidth(118);
				tableFornecedor.getColumnModel().getColumn(2).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(3).setPreferredWidth(100);
				tableFornecedor.getColumnModel().getColumn(3).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(4).setPreferredWidth(125);
				tableFornecedor.getColumnModel().getColumn(4).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(5).setPreferredWidth(100);
				tableFornecedor.getColumnModel().getColumn(5).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(6).setPreferredWidth(48);
				tableFornecedor.getColumnModel().getColumn(5).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(7).setPreferredWidth(40);
				tableFornecedor.getColumnModel().getColumn(7).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(8).setPreferredWidth(73);
				tableFornecedor.getColumnModel().getColumn(8).setResizable(false);
				tableFornecedor.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
				tableFornecedor.setAutoResizeMode(tableFornecedor.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
				tableFornecedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(486, 199, 82, 25);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModeloFornecedor mod = new ModeloFornecedor();
				ControleFornecedor control = new ControleFornecedor();

				mod.setId(Integer.parseInt(txtId.getText()));
				control.excluirFornecedor(mod);

				txtCidade.setEnabled(false);
				txtCnpj_1.setEnabled(false);
				txtEmail.setEnabled(false);
				txtEndereco.setEnabled(false);
				txtEstado.setEnabled(false);
				txtNasci_1.setEnabled(false);
				txtNome.setEnabled(false);
				txtTelefone_1.setEnabled(false);
				txtCidade.setText("");
				txtPesquisar.setText("");
				txtCnpj_1.setText("");
				txtEmail.setText("");
				txtEndereco.setText("");
				txtEstado.setText("");
				txtNasci_1.setText("");
				txtId.setText("");
				txtNome.setText("");
				txtTelefone_1.setText("");
				
				//Atualizar tabela depois de excluir
				try {
					conexao.ConectarBanco();
					conexao.executaSQL(
							"select idFor,nomeFor,cnpjFor,telefoneFor,emailFor,enderecoFor,cidadeFor,estadoFor,nascimentoFor from fornecedor order by nomeFor");
					tableFornecedor.setModel(new TabelaFornecedor(conexao.rs));
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Fornecedor não excluido");
				}
				tableFornecedor.getColumnModel().getColumn(0).setPreferredWidth(25); // Comprimento da coluna
				tableFornecedor.getColumnModel().getColumn(0).setResizable(false); // Não pode dimensionar a coluna com o mause
				tableFornecedor.getColumnModel().getColumn(1).setPreferredWidth(125);
				tableFornecedor.getColumnModel().getColumn(1).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(2).setPreferredWidth(118);
				tableFornecedor.getColumnModel().getColumn(2).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(3).setPreferredWidth(100);
				tableFornecedor.getColumnModel().getColumn(3).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(4).setPreferredWidth(125);
				tableFornecedor.getColumnModel().getColumn(4).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(5).setPreferredWidth(100);
				tableFornecedor.getColumnModel().getColumn(5).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(6).setPreferredWidth(48);
				tableFornecedor.getColumnModel().getColumn(5).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(7).setPreferredWidth(40);
				tableFornecedor.getColumnModel().getColumn(7).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(8).setPreferredWidth(73);
				tableFornecedor.getColumnModel().getColumn(8).setResizable(false);
				tableFornecedor.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
				tableFornecedor.setAutoResizeMode(tableFornecedor.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
				tableFornecedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnExcluir);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(617, 199, 96, 25);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCidade.setEnabled(false);
				txtCnpj_1.setEnabled(false);
				txtEmail.setEnabled(false);
				txtEndereco.setEnabled(false);
				txtEstado.setEnabled(false);
				txtNasci_1.setEnabled(false);
				txtNome.setEnabled(false);
				txtTelefone_1.setEnabled(false);
				txtCidade.setText("");
				txtCnpj_1.setText("");
				txtEmail.setText("");
				txtPesquisar.setText("");
				txtEndereco.setText("");
				txtEstado.setText("");
				txtNasci_1.setText("");
				txtId.setText("");
				txtNome.setText("");
				txtTelefone_1.setText("");
				//Atualizar tabela depois de salvar
				try {
					conexao.ConectarBanco();
					conexao.executaSQL(
							"select idFor,nomeFor,cnpjFor,telefoneFor,emailFor,enderecoFor,cidadeFor,estadoFor,nascimentoFor from fornecedor order by nomeFor");
					tableFornecedor.setModel(new TabelaFornecedor(conexao.rs));
				} catch (SQLException e2) {
					//JOptionPane.showMessageDialog(null, "Nao funcionaou");
				}
				tableFornecedor.getColumnModel().getColumn(0).setPreferredWidth(25); // Comprimento da coluna
				tableFornecedor.getColumnModel().getColumn(0).setResizable(false); // Não pode dimensionar a coluna com o mause
				tableFornecedor.getColumnModel().getColumn(1).setPreferredWidth(125);
				tableFornecedor.getColumnModel().getColumn(1).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(2).setPreferredWidth(118);
				tableFornecedor.getColumnModel().getColumn(2).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(3).setPreferredWidth(100);
				tableFornecedor.getColumnModel().getColumn(3).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(4).setPreferredWidth(125);
				tableFornecedor.getColumnModel().getColumn(4).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(5).setPreferredWidth(100);
				tableFornecedor.getColumnModel().getColumn(5).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(6).setPreferredWidth(48);
				tableFornecedor.getColumnModel().getColumn(5).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(7).setPreferredWidth(40);
				tableFornecedor.getColumnModel().getColumn(7).setResizable(false);
				tableFornecedor.getColumnModel().getColumn(8).setPreferredWidth(73);
				tableFornecedor.getColumnModel().getColumn(8).setResizable(false);
				tableFornecedor.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
				tableFornecedor.setAutoResizeMode(tableFornecedor.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
				tableFornecedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 235, 760, 201);
		contentPane.add(scrollPane);

		tableFornecedor = new JTable();
		tableFornecedor.setBackground(new Color(204, 255, 255));
		tableFornecedor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		try {
			conexao.ConectarBanco();
			conexao.executaSQL(
					"select idFor,nomeFor,cnpjFor,telefoneFor,emailFor,enderecoFor,cidadeFor,estadoFor,nascimentoFor from fornecedor order by nomeFor");
			tableFornecedor.setModel(new TabelaFornecedor(conexao.rs));
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "Não foi possivel/n Preencher a tabela");
		}
		tableFornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// carregar os dados para os campos
				String nomeFor = "" + tableFornecedor.getValueAt(tableFornecedor.getSelectedRow(), 1);
				conexao.ConectarBanco();
				conexao.executaSQL("select * from fornecedor where nomeFor='" + nomeFor + "'");
				try {
					conexao.rs.first();
					// txtId.setText(String.valueOf(conexao.rs.getInt("idFor")));
					txtCidade.setText(conexao.rs.getString("cidadeFor"));
					txtCnpj_1.setText(conexao.rs.getString("cnpjFor"));
					txtNome.setText(conexao.rs.getString("nomeFor"));
					txtTelefone_1.setText(conexao.rs.getString("telefoneFor"));
					txtEmail.setText(conexao.rs.getString("emailFor"));
					txtEndereco.setText(conexao.rs.getString("enderecoFor"));
					txtEstado.setText(conexao.rs.getString("estadoFor"));
					txtNasci_1.setText(conexao.rs.getString("nascimentoFor"));
					txtId.setText(String.valueOf(conexao.rs.getInt("idFor")));
					txtCidade.setEnabled(true);
					txtCnpj_1.setEnabled(true);
					txtEmail.setEnabled(true);
					txtEndereco.setEnabled(true);
					txtEstado.setEnabled(true);
					txtNasci_1.setEnabled(true);
					txtNome.setEnabled(true);
					txtTelefone_1.setEnabled(true);

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao carrega os campos");
				}
				conexao.FecharBanco();
				
			}
		});

		tableFornecedor.getColumnModel().getColumn(0).setPreferredWidth(25); // Comprimento da coluna
		tableFornecedor.getColumnModel().getColumn(0).setResizable(false); // Não pode dimensionar a coluna com o mause
		tableFornecedor.getColumnModel().getColumn(1).setPreferredWidth(125);
		tableFornecedor.getColumnModel().getColumn(1).setResizable(false);
		tableFornecedor.getColumnModel().getColumn(2).setPreferredWidth(118);
		tableFornecedor.getColumnModel().getColumn(2).setResizable(false);
		tableFornecedor.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableFornecedor.getColumnModel().getColumn(3).setResizable(false);
		tableFornecedor.getColumnModel().getColumn(4).setPreferredWidth(125);
		tableFornecedor.getColumnModel().getColumn(4).setResizable(false);
		tableFornecedor.getColumnModel().getColumn(5).setPreferredWidth(100);
		tableFornecedor.getColumnModel().getColumn(5).setResizable(false);
		tableFornecedor.getColumnModel().getColumn(6).setPreferredWidth(48);
		tableFornecedor.getColumnModel().getColumn(5).setResizable(false);
		tableFornecedor.getColumnModel().getColumn(7).setPreferredWidth(40);
		tableFornecedor.getColumnModel().getColumn(7).setResizable(false);
		tableFornecedor.getColumnModel().getColumn(8).setPreferredWidth(73);
		tableFornecedor.getColumnModel().getColumn(8).setResizable(false);
		tableFornecedor.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
		tableFornecedor.setAutoResizeMode(tableFornecedor.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
		tableFornecedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
		scrollPane.setViewportView(tableFornecedor);

	}

	// Metodos para salvar campo CNPJ que esta formatado
	public String cpfParaMysql(String cpf) {

		String pri = txtCnpj_1.getText().substring(0, 2);
		String seg = txtCnpj_1.getText().substring(3, 6);
		String ter = txtCnpj_1.getText().substring(7, 10);
		String qua = txtCnpj_1.getText().substring(11, 15);
		String qui = txtCnpj_1.getText().substring(16);
		String cpfParaMysql = pri + "." + seg + "." + ter + "/" + qua + "-" + qui;

		return cpfParaMysql;
	}

	// Metodos para salvar campo DATA que esta formatado
	public String dataParaMysql(String data) {

		String dia = txtNasci_1.getText().substring(0, 2);
		String mes = txtNasci_1.getText().substring(3, 5);
		String ano = txtNasci_1.getText().substring(6);

		String dataParaMysql = dia + "/" + mes + "/" + ano;

		return dataParaMysql;
	}

	// Metodos para salvar campo NÚMERO que esta formatado
	public String numeroParaMysql(String numero) {

		String pri = txtTelefone_1.getText().substring(0, 3);
		String seg = txtTelefone_1.getText().substring(4, 9);
		String ter = txtTelefone_1.getText().substring(10);

		String numeroParaMysql = pri + ")" + seg + "-" + ter;

		return numeroParaMysql;
	}

}
