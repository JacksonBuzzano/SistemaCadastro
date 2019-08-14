package visão;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import conexão.ConexãoBD;
import controle.ControleUsuario;
import metodos.TabelaUsuario;
import modelo.ModeloUsuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListaUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtUsuario;
	private JTextField txtPesquisa;
	private JTable tabelaUsuaio;
	private JPasswordField passSenha;
	private JPasswordField passSenha1;

	ConexãoBD conexao = new ConexãoBD();
	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaUsuarios frame = new ListaUsuarios();
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
	public ListaUsuarios() {
		setTitle("Usu\u00E1rios");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		//contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(18, 13, 19, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(179, 13, 50, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(179, 39, 42, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Confirma Senha:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(128, 73, 101, 15);
		contentPane.add(lblNewLabel_3);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtId.setBounds(47, 10, 42, 21);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		txtUsuario.setBounds(239, 10, 164, 21);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModeloUsuario mod = new ModeloUsuario();
				mod.setPesquisa(txtPesquisa.getText());
				txtPesquisa.setText("");
				ControleUsuario control = new ControleUsuario();
				control.pesquisa(mod);
				
				//pesquisa os usuários pra preencher a tabela
				conexao.ConectarBanco();
				try {
					conexao.executaSQL("SELECT idUsuario, nomeUsuario FROM usuários WHERE nomeUsuario LIKE'" +mod.getPesquisa()+ "%' order by nomeUsuario");
					tabelaUsuaio.setModel(new TabelaUsuario(conexao.rs));
					tabelaUsuaio.getColumnModel().getColumn(0).setPreferredWidth(75); // Comprimento da coluna
					tabelaUsuaio.getColumnModel().getColumn(0).setResizable(false); // Não pode dimensionar a coluna com o mause
					tabelaUsuaio.getColumnModel().getColumn(1).setPreferredWidth(297);
					tabelaUsuaio.getColumnModel().getColumn(1).setResizable(false);
					tabelaUsuaio.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
					tabelaUsuaio.setAutoResizeMode(tabelaUsuaio.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
					tabelaUsuaio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela");
				}
				
			}
		});
		
		txtPesquisa = new JTextField();
		txtPesquisa.setFont(new Font("Dialog", Font.BOLD, 14));
		txtPesquisa.setBounds(257, 100, 225, 21);
		contentPane.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		btnPesquisa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPesquisa.setBounds(156, 99, 91, 23);
		contentPane.add(btnPesquisa);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModeloUsuario mod = new ModeloUsuario();
				ControleUsuario control = new ControleUsuario();
				
				if (passSenha.getText().equals(passSenha1.getText())) {	
				mod.setNome(txtUsuario.getText());
				mod.setSenha1(Integer.parseInt(passSenha.getText()));
				mod.setId(Integer.parseInt(txtId.getText()));
				control.editar(mod);
				txtId.setText("");
				passSenha.setText("");
				passSenha1.setText("");
				txtUsuario.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "Usuário não Editado \n Senhas não correspondem");
			}
				//Atualiza a tabela
				try {
					conexao.executaSQL("SELECT idUsuario,nomeUsuario FROM usuários order by nomeUsuario");
					tabelaUsuaio.setModel(new TabelaUsuario(conexao.rs));
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela");
				}
				tabelaUsuaio.getColumnModel().getColumn(0).setPreferredWidth(75); // Comprimento da coluna
				tabelaUsuaio.getColumnModel().getColumn(0).setResizable(false); // Não pode dimensionar a coluna com o mause
				tabelaUsuaio.getColumnModel().getColumn(1).setPreferredWidth(297);
				tabelaUsuaio.getColumnModel().getColumn(1).setResizable(false);
				tabelaUsuaio.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
				tabelaUsuaio.setAutoResizeMode(tabelaUsuaio.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
				tabelaUsuaio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEditar.setBounds(102, 153, 85, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModeloUsuario mod = new ModeloUsuario();
				ControleUsuario control = new ControleUsuario();
				
				mod.setId(Integer.parseInt(txtId.getText()));
				control.excluir(mod);
				
				txtId.setText("");
				passSenha.setText("");
				passSenha1.setText("");
				txtUsuario.setText("");
				
				//Atualiza a tabela
				try {
					conexao.executaSQL("SELECT idUsuario,nomeUsuario FROM usuários order by nomeUsuario");
					tabelaUsuaio.setModel(new TabelaUsuario(conexao.rs));
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela");
				}
				tabelaUsuaio.getColumnModel().getColumn(0).setPreferredWidth(75); // Comprimento da coluna
				tabelaUsuaio.getColumnModel().getColumn(0).setResizable(false); // Não pode dimensionar a coluna com o mause
				tabelaUsuaio.getColumnModel().getColumn(1).setPreferredWidth(297);
				tabelaUsuaio.getColumnModel().getColumn(1).setResizable(false);
				tabelaUsuaio.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
				tabelaUsuaio.setAutoResizeMode(tabelaUsuaio.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
				tabelaUsuaio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExcluir.setBounds(254, 153, 85, 23);
		contentPane.add(btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtUsuario.setText("");
				passSenha.setText("");
				passSenha1.setText("");
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(391, 153, 91, 23);
		contentPane.add(btnCancelar);
		
		passSenha1 = new JPasswordField();
		passSenha1.setFont(new Font("Dialog", Font.BOLD, 14));
		passSenha1.setBounds(239, 68, 164, 20);
		contentPane.add(passSenha1);
		
		passSenha = new JPasswordField();
		passSenha.setFont(new Font("Dialog", Font.BOLD, 14));
		passSenha.setBounds(239, 37, 164, 20);
		contentPane.add(passSenha);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 187, 375, 157);
		contentPane.add(scrollPane);
		
		tabelaUsuaio = new JTable();
		tabelaUsuaio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// carregar os dados para os campos
				String nomeUsu= "" + tabelaUsuaio.getValueAt(tabelaUsuaio.getSelectedRow(), 1);
				conexao.ConectarBanco();
				conexao.executaSQL("select * from usuários where nomeUsuario='" + nomeUsu + "'");
				try {
					conexao.rs.first();
					txtId.setText(String.valueOf(conexao.rs.getInt("idUsuario")));
					txtUsuario.setText(conexao.rs.getString("nomeUsuario"));
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao preencher os campos");
					
				}
			}
			
		});
		tabelaUsuaio.setBackground(new Color(204, 255, 255));
		tabelaUsuaio.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		//Preencher a tabela
		conexao.ConectarBanco();
		try {
			conexao.executaSQL("SELECT idUsuario,nomeUsuario FROM usuários order by nomeUsuario");
			tabelaUsuaio.setModel(new TabelaUsuario(conexao.rs));
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela");
		}
		tabelaUsuaio.getColumnModel().getColumn(0).setPreferredWidth(75); // Comprimento da coluna
		tabelaUsuaio.getColumnModel().getColumn(0).setResizable(false); // Não pode dimensionar a coluna com o mause
		tabelaUsuaio.getColumnModel().getColumn(1).setPreferredWidth(297);
		tabelaUsuaio.getColumnModel().getColumn(1).setResizable(false);
		tabelaUsuaio.getTableHeader().setReorderingAllowed(false);// reordenar a locação da tabela
		tabelaUsuaio.setAutoResizeMode(tabelaUsuaio.AUTO_RESIZE_OFF);// Tabela não pode ser redimensionada
		tabelaUsuaio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Pode apenas selicionar uma linha
		scrollPane.setViewportView(tabelaUsuaio);
		
	}

}
