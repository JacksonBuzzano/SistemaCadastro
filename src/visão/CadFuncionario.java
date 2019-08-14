package visão;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controle.ControleFuncionário;
import metodos.TabelaFuncionario;
import modelo.ModeloFuncionario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import conexão.ConexãoBD;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.BevelBorder;

public class CadFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtTelefone_1;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtCpf;
	private JTextField txtCpf_1;
	private JTextField txtPesquisa;
	private JTextField txtFuncao;
	private JTextField txtNascimento;
	private JTextField txtNascimento_1;
	private JTextField txtId;
	public ResultSet rs;
	ConexãoBD conexao = new ConexãoBD();
	private JTable table;
	
	
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadFuncionario frame = new CadFuncionario();
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
	
	public CadFuncionario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jcksb\\Desktop\\jota.jpg"));
		setResizable(false);
		setTitle("Cadastro de Funcion\u00E1rios");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		//contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(SystemColor.controlText);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 60, 38, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o:");
		lblNewLabel_2.setForeground(SystemColor.controlText);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(294, 60, 59, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(SystemColor.controlText);
		lblNewLabel_3.setBounds(135, 12, 56, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("N\u00B0:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(SystemColor.controlText);
		lblNewLabel_4.setBounds(460, 12, 19, 15);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Cidade:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setForeground(SystemColor.controlText);
		lblNewLabel_5.setBounds(245, 110, 46, 15);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Estado:");
		lblNewLabel_6.setForeground(SystemColor.controlText);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(247, 162, 44, 15);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("CPF:");
		lblNewLabel_7.setForeground(SystemColor.controlText);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(10, 162, 27, 15);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Fun\u00E7\u00E3o:");
		lblNewLabel_8.setForeground(SystemColor.controlText);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(592, 60, 47, 15);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Data Nasc:");
		lblNewLabel_9.setForeground(SystemColor.controlText);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(10, 110, 64, 15);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setForeground(SystemColor.controlText);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 12, 19, 15);
		contentPane.add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Dialog", Font.BOLD, 12));
		txtNome.setEnabled(false);
		txtNome.setBounds(58, 58, 190, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Dialog", Font.BOLD, 12));
		txtEndereco.setEnabled(false);
		txtEndereco.setBounds(355, 58, 200, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);

		txtTelefone = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("(##)#####-####");
			txtTelefone_1 = new javax.swing.JFormattedTextField(format_textField4);
			txtTelefone_1.setFont(new Font("Dialog", Font.BOLD, 12));
			txtTelefone_1.setEnabled(false);
		} catch (Exception e) {
		}
		txtTelefone_1.setBounds(201, 10, 109, 20);
		contentPane.add(txtTelefone_1);
		txtTelefone_1.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Dialog", Font.BOLD, 12));
		txtNumero.setEnabled(false);
		txtNumero.setBounds(489, 10, 96, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCidade.setEnabled(false);
		txtCidade.setBounds(294, 108, 162, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Dialog", Font.BOLD, 12));
		txtEstado.setEnabled(false);
		txtEstado.setBounds(294, 160, 96, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);

		// txtCpf = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
			txtCpf_1 = new javax.swing.JFormattedTextField(format_textField4);
			txtCpf_1.setFont(new Font("Dialog", Font.BOLD, 12));
			txtCpf_1.setEnabled(false);
		} catch (Exception e) {
		}
		txtCpf_1.setBounds(47, 160, 149, 20);
		contentPane.add(txtCpf_1);
		txtCpf_1.setColumns(10);

		txtPesquisa = new JTextField();
		txtPesquisa.setFont(new Font("Dialog", Font.BOLD, 12));
		txtPesquisa.setBounds(515, 157, 178, 20);
		contentPane.add(txtPesquisa);
		txtPesquisa.setColumns(10);

		txtFuncao = new JTextField();
		txtFuncao.setFont(new Font("Dialog", Font.BOLD, 12));
		txtFuncao.setEnabled(false);
		txtFuncao.setBounds(642, 58, 96, 20);
		contentPane.add(txtFuncao);
		txtFuncao.setColumns(10);

		txtNascimento = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##/##/####");
			txtNascimento_1 = new javax.swing.JFormattedTextField(format_textField4);
			txtNascimento_1.setFont(new Font("Dialog", Font.BOLD, 12));
			txtNascimento_1.setEnabled(false);
		} catch (Exception e) {
		}
		txtNascimento_1.setBounds(84, 108, 104, 20);
		contentPane.add(txtNascimento_1);
		txtNascimento_1.setColumns(10);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setFont(new Font("Dialog", Font.BOLD, 12));
		txtId.setBounds(39, 9, 38, 21);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Abilita os campos
				txtCidade.setEnabled(true);
				txtCpf_1.setEnabled(true);
				txtEndereco.setEnabled(true);
				txtEstado.setEnabled(true);
				txtFuncao.setEnabled(true);
				txtNascimento_1.setEnabled(true);
				txtNome.setEnabled(true);
				txtNumero.setEnabled(true);
				txtTelefone_1.setEnabled(true);
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNovo.setBounds(81, 212, 77, 25);
		contentPane.add(btnNovo);

		JButton btnExluir = new JButton("Excluir");
		btnExluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Instancia classe Modelo Fornecedor
				ModeloFuncionario mod = new ModeloFuncionario();
				ControleFuncionário control = new ControleFuncionário();

				mod.setId(Integer.parseInt(txtId.getText()));
				control.excluirFuncionário(mod);

				// Limpa os campos e Desabilita
				txtCidade.setEnabled(false);
				txtCpf_1.setEnabled(false);
				txtEndereco.setEnabled(false);
				txtEstado.setEnabled(false);
				txtFuncao.setEnabled(false);
				txtNascimento_1.setEnabled(false);
				txtNome.setEnabled(false);
				txtNumero.setEnabled(false);
				txtTelefone_1.setEnabled(false);
				txtCidade.setText("");
				txtPesquisa.setText("");
				txtCpf_1.setText("");
				txtEndereco.setText("");
				txtEstado.setText("");
				txtFuncao.setText("");
				txtNascimento_1.setText("");
				txtNome.setText("");
				txtNumero.setText("");
				txtTelefone_1.setText("");

				// Atualiza Tabela
				conexao.ConectarBanco();
				try {
					conexao.executaSQL("select *from funcionário order by nomeFun");
					table.setModel(new TabelaFuncionario(conexao.rs));
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Erro ao preencher tabela");
				}
				table.getColumnModel().getColumn(0).setPreferredWidth(30);
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(1).setPreferredWidth(125);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(2).setPreferredWidth(95);
				table.getColumnModel().getColumn(2).setResizable(false);
				table.getColumnModel().getColumn(3).setPreferredWidth(70);
				table.getColumnModel().getColumn(3).setResizable(false);
				table.getColumnModel().getColumn(4).setPreferredWidth(130);
				table.getColumnModel().getColumn(4).setResizable(false);
				table.getColumnModel().getColumn(5).setPreferredWidth(50);
				table.getColumnModel().getColumn(5).setResizable(false);
				table.getColumnModel().getColumn(6).setPreferredWidth(91);
				table.getColumnModel().getColumn(6).setResizable(false);
				table.getColumnModel().getColumn(7).setPreferredWidth(35);
				table.getColumnModel().getColumn(7).setResizable(false);
				table.getColumnModel().getColumn(8).setPreferredWidth(95);
				table.getColumnModel().getColumn(8).setResizable(false);
				table.getColumnModel().getColumn(9).setPreferredWidth(72);
				table.getColumnModel().getColumn(9).setResizable(false);
				table.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha

			}
		});
		btnExluir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExluir.setBounds(212, 212, 90, 25);
		contentPane.add(btnExluir);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Instancia classe Modelo Fornecedor
				ModeloFuncionario mod = new ModeloFuncionario();

				mod.setCidade(txtCidade.getText());
				mod.setCpf(cpfParaMysql(txtCpf_1.getText()));
				mod.setEndereco(txtEndereco.getText());
				mod.setNumero(Integer.parseInt(txtNumero.getText().toString()));
				mod.setEstado(txtEstado.getText());
				mod.setFuncao(txtFuncao.getText());
				mod.setNascimento(dataParaMysql(txtNascimento_1.getText()));
				mod.setNome(txtNome.getText());
				mod.setTelefone(numeroParaMysql(txtTelefone_1.getText()));

				// Instancia classe Controle Fornecedor
				ControleFuncionário control = new ControleFuncionário();
				control.SalvarFuncionario(mod);

				// Limpa e desabilita os campos
				txtCidade.setEnabled(false);
				txtCpf_1.setEnabled(false);
				txtEndereco.setEnabled(false);
				txtEstado.setEnabled(false);
				txtFuncao.setEnabled(false);
				txtNascimento_1.setEnabled(false);
				txtNome.setEnabled(false);
				txtNumero.setEnabled(false);
				txtTelefone_1.setEnabled(false);
				txtCidade.setText("");
				txtCpf_1.setText("");
				txtEndereco.setText("");
				txtPesquisa.setText("");
				txtEstado.setText("");
				txtFuncao.setText("");
				txtNascimento_1.setText("");
				txtNome.setText("");
				txtNumero.setText("");
				txtTelefone_1.setText("");

				// Atualiza Tabela
				conexao.ConectarBanco();
				try {
					conexao.executaSQL("select *from funcionário order by nomeFun");
					table.setModel(new TabelaFuncionario(conexao.rs));
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Erro ao preencher tabela");
				}
				table.getColumnModel().getColumn(0).setPreferredWidth(30);
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(1).setPreferredWidth(125);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(2).setPreferredWidth(95);
				table.getColumnModel().getColumn(2).setResizable(false);
				table.getColumnModel().getColumn(3).setPreferredWidth(70);
				table.getColumnModel().getColumn(3).setResizable(false);
				table.getColumnModel().getColumn(4).setPreferredWidth(130);
				table.getColumnModel().getColumn(4).setResizable(false);
				table.getColumnModel().getColumn(5).setPreferredWidth(50);
				table.getColumnModel().getColumn(5).setResizable(false);
				table.getColumnModel().getColumn(6).setPreferredWidth(91);
				table.getColumnModel().getColumn(6).setResizable(false);
				table.getColumnModel().getColumn(7).setPreferredWidth(35);
				table.getColumnModel().getColumn(7).setResizable(false);
				table.getColumnModel().getColumn(8).setPreferredWidth(95);
				table.getColumnModel().getColumn(8).setResizable(false);
				table.getColumnModel().getColumn(9).setPreferredWidth(72);
				table.getColumnModel().getColumn(9).setResizable(false);
				table.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalvar.setBounds(349, 212, 90, 25);
		contentPane.add(btnSalvar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Instancia classe Modelo Fornecedor e Controle Fornecedor
				ControleFuncionário control = new ControleFuncionário();
				ModeloFuncionario mod = new ModeloFuncionario();

				mod.setId(Integer.parseInt(txtId.getText()));
				mod.setCidade(txtCidade.getText());
				mod.setCpf(cpfParaMysql(txtCpf_1.getText()));
				mod.setEndereco(txtEndereco.getText());
				mod.setNumero(Integer.parseInt(txtNumero.getText().toString()));
				mod.setEstado(txtEstado.getText());
				mod.setFuncao(txtFuncao.getText());
				mod.setNascimento(dataParaMysql(txtNascimento_1.getText()));
				mod.setNome(txtNome.getText());
				mod.setTelefone(numeroParaMysql(txtTelefone_1.getText()));

				control.editaFuncinário(mod);

				// Limoa e desabilita os campos
				txtCidade.setEnabled(false);
				txtCpf_1.setEnabled(false);
				txtEndereco.setEnabled(false);
				txtEstado.setEnabled(false);
				txtFuncao.setEnabled(false);
				txtNascimento_1.setEnabled(false);
				txtNome.setEnabled(false);
				txtNumero.setEnabled(false);
				txtTelefone_1.setEnabled(false);
				txtPesquisa.setText("");
				txtCidade.setText("");
				txtPesquisa.setText("");
				txtCpf_1.setText("");
				txtEndereco.setText("");
				txtEstado.setText("");
				txtFuncao.setText("");
				txtNascimento_1.setText("");
				txtNome.setText("");
				txtNumero.setText("");
				txtTelefone_1.setText("");

				// Atualiza Tabela
				conexao.ConectarBanco();
				try {
					conexao.executaSQL("select *from funcionário order by nomeFun");
					table.setModel(new TabelaFuncionario(conexao.rs));
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Erro ao preencher tabela");
				}
				table.getColumnModel().getColumn(0).setPreferredWidth(30);
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(1).setPreferredWidth(125);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(2).setPreferredWidth(95);
				table.getColumnModel().getColumn(2).setResizable(false);
				table.getColumnModel().getColumn(3).setPreferredWidth(70);
				table.getColumnModel().getColumn(3).setResizable(false);
				table.getColumnModel().getColumn(4).setPreferredWidth(130);
				table.getColumnModel().getColumn(4).setResizable(false);
				table.getColumnModel().getColumn(5).setPreferredWidth(50);
				table.getColumnModel().getColumn(5).setResizable(false);
				table.getColumnModel().getColumn(6).setPreferredWidth(91);
				table.getColumnModel().getColumn(6).setResizable(false);
				table.getColumnModel().getColumn(7).setPreferredWidth(35);
				table.getColumnModel().getColumn(7).setResizable(false);
				table.getColumnModel().getColumn(8).setPreferredWidth(95);
				table.getColumnModel().getColumn(8).setResizable(false);
				table.getColumnModel().getColumn(9).setPreferredWidth(72);
				table.getColumnModel().getColumn(9).setResizable(false);
				table.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditar.setBounds(502, 212, 80, 25);
		contentPane.add(btnEditar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Limpa e desabilita os campos
				txtCidade.setEnabled(false);
				txtCpf_1.setEnabled(false);
				txtEndereco.setEnabled(false);
				txtEstado.setEnabled(false);
				txtFuncao.setEnabled(false);
				txtNascimento_1.setEnabled(false);
				txtNome.setEnabled(false);
				txtNumero.setEnabled(false);
				txtTelefone_1.setEnabled(false);
				txtCidade.setText("");
				txtPesquisa.setText("");
				txtCpf_1.setText("");
				txtEndereco.setText("");
				txtEstado.setText("");
				txtFuncao.setText("");
				txtNascimento_1.setText("");
				txtNome.setText("");
				txtNumero.setText("");
				txtTelefone_1.setText("");
				
				// Atualiza Tabela
				conexao.ConectarBanco();
				try {
					conexao.executaSQL("select *from funcionário order by nomeFun");
					table.setModel(new TabelaFuncionario(conexao.rs));
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Erro ao preencher tabela");
				}
				table.getColumnModel().getColumn(0).setPreferredWidth(30);
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(1).setPreferredWidth(125);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(2).setPreferredWidth(95);
				table.getColumnModel().getColumn(2).setResizable(false);
				table.getColumnModel().getColumn(3).setPreferredWidth(70);
				table.getColumnModel().getColumn(3).setResizable(false);
				table.getColumnModel().getColumn(4).setPreferredWidth(130);
				table.getColumnModel().getColumn(4).setResizable(false);
				table.getColumnModel().getColumn(5).setPreferredWidth(50);
				table.getColumnModel().getColumn(5).setResizable(false);
				table.getColumnModel().getColumn(6).setPreferredWidth(91);
				table.getColumnModel().getColumn(6).setResizable(false);
				table.getColumnModel().getColumn(7).setPreferredWidth(35);
				table.getColumnModel().getColumn(7).setResizable(false);
				table.getColumnModel().getColumn(8).setPreferredWidth(95);
				table.getColumnModel().getColumn(8).setResizable(false);
				table.getColumnModel().getColumn(9).setPreferredWidth(72);
				table.getColumnModel().getColumn(9).setResizable(false);
				table.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(642, 212, 96, 25);
		contentPane.add(btnCancelar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Instancia classe Modelo Fornecedor
				ModeloFuncionario mod = new ModeloFuncionario();
				mod.setPesquisa(txtPesquisa.getText());

				// Instancia classe Controle Fornecedor
				ControleFuncionário control = new ControleFuncionário();
				control.buscaFuncionario(mod);

				// pesquisa pelo nome e mostra na tabela
				conexao.ConectarBanco();
				try {
					conexao.executaSQL("SELECT * FROM funcionário WHERE nomeFun LIKE'"+mod.getPesquisa()+ "%'ORDER BY nomeFun");
					table.setModel(new TabelaFuncionario(conexao.rs));
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Erro ao preencher tabela");
				}
				table.getColumnModel().getColumn(0).setPreferredWidth(30);
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(1).setPreferredWidth(125);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(2).setPreferredWidth(95);
				table.getColumnModel().getColumn(2).setResizable(false);
				table.getColumnModel().getColumn(3).setPreferredWidth(70);
				table.getColumnModel().getColumn(3).setResizable(false);
				table.getColumnModel().getColumn(4).setPreferredWidth(130);
				table.getColumnModel().getColumn(4).setResizable(false);
				table.getColumnModel().getColumn(5).setPreferredWidth(50);
				table.getColumnModel().getColumn(5).setResizable(false);
				table.getColumnModel().getColumn(6).setPreferredWidth(91);
				table.getColumnModel().getColumn(6).setResizable(false);
				table.getColumnModel().getColumn(7).setPreferredWidth(35);
				table.getColumnModel().getColumn(7).setResizable(false);
				table.getColumnModel().getColumn(8).setPreferredWidth(95);
				table.getColumnModel().getColumn(8).setResizable(false);
				table.getColumnModel().getColumn(9).setPreferredWidth(72);
				table.getColumnModel().getColumn(9).setResizable(false);
				table.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
				
				// Abilita os campos
				txtCidade.setEnabled(true);
				txtCpf_1.setEnabled(true);
				txtEndereco.setEnabled(true);
				txtEstado.setEnabled(true);
				txtFuncao.setEnabled(true);
				txtNascimento_1.setEnabled(true);
				txtNome.setEnabled(true);
				txtNumero.setEnabled(true);
				txtTelefone_1.setEnabled(true);
				txtPesquisa.setText("");
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPesquisar.setBounds(703, 154, 97, 25);
		contentPane.add(btnPesquisar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 248, 813, 188);
		contentPane.add(scrollPane);

		//Minha tablela
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBackground(new Color(204, 255, 255));
		
		try {
			conexao.ConectarBanco();
			conexao.executaSQL("select *from funcionário order by nomeFun");
			table.setModel(new TabelaFuncionario(conexao.rs));
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher tabela");
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(130);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(91);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(35);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(8).setPreferredWidth(95);
		table.getColumnModel().getColumn(8).setResizable(false);
		table.getColumnModel().getColumn(9).setPreferredWidth(72);
		table.getColumnModel().getColumn(9).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha

		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// carregar os dados para os campos
				String nomeFun = "" + table.getValueAt(table.getSelectedRow(), 1);
				conexao.ConectarBanco();
				conexao.executaSQL("select * from funcionário where nomeFun='" + nomeFun + "'");
				try {
					conexao.rs.first();
					txtId.setText(String.valueOf(conexao.rs.getInt("idFun")));
					txtCidade.setText(conexao.rs.getString("cidadeFun"));
					txtCpf_1.setText(conexao.rs.getString("cpfFun"));
					txtEndereco.setText(conexao.rs.getString("enderecoFun"));
					txtEstado.setText(conexao.rs.getString("estadoFun"));
					txtFuncao.setText(conexao.rs.getString("funcaoFun"));
					txtNascimento_1.setText(conexao.rs.getString("nascimentoFun"));
					txtNome.setText(conexao.rs.getString("nomeFun"));
					txtNumero.setText(String.valueOf(conexao.rs.getInt("numeroFun")));
					txtTelefone_1.setText(conexao.rs.getString("telefoneFun"));
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao carrega os campos");
				}
				conexao.FecharBanco();
				txtCidade.setEnabled(true);
				txtCpf_1.setEnabled(true);
				txtEndereco.setEnabled(true);
				txtEstado.setEnabled(true);
				txtFuncao.setEnabled(true);
				txtNascimento_1.setEnabled(true);
				txtNome.setEnabled(true);
				txtNumero.setEnabled(true);
				txtTelefone_1.setEnabled(true);
			}
		});

	}

	// Metodos para salvar campo CPF que esta formatado
	public String cpfParaMysql(String cpf) {

		String pri = txtCpf_1.getText().substring(0, 3);
		String seg = txtCpf_1.getText().substring(4, 7);
		String ter = txtCpf_1.getText().substring(8, 11);
		String qua = txtCpf_1.getText().substring(12);
		String cpfParaMysql = pri + "." + seg + "." + ter + "-" + qua;

		return cpfParaMysql;
	}

	// Metodos para salvar campo DATA que esta formatado
	public String dataParaMysql(String data) {

		String dia = txtNascimento_1.getText().substring(0, 2);
		String mes = txtNascimento_1.getText().substring(3, 5);
		String ano = txtNascimento_1.getText().substring(6);

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