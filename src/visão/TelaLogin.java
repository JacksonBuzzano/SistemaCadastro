package visão;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import conexão.ConexãoBD;
import modelo.ModeloLogin;
import modelo.ModeloUsuario;

import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordSenha;
	ConexãoBD conexao = new ConexãoBD();
	
	/**
	 * Launch the application.
	 */

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jcksb\\Desktop\\jota.jpg"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 321);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 255));
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		//contentPane.setLayout(null);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModeloUsuario mod = new ModeloUsuario();
				ModeloLogin m = new ModeloLogin();
				conexao.ConectarBanco();
				String usuario ;
				int s = 0;
				
				try {
					conexao.executaSQL ("SELECT nomeUsuario FROM usuários WHERE nomeUsuario='" + txtUsuario.getText()+ "'"); 
					conexao.rs.first();
					usuario = conexao.rs.getString("nomeUsuario");
					conexao.executaSQL ("SELECT senhaUsuario FROM usuários WHERE senhaUsuario='" + passwordSenha.getText()+ "'"); 
					conexao.rs.first();
		            s = conexao.rs.getInt("senhaUsuario");
					if(txtUsuario.getText().equals(usuario) && passwordSenha.getText().equals(s));{
						Principal telaPrincipal = new Principal();
						telaPrincipal.setVisible(true);
						dispose();
					}
				} catch (HeadlessException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Usuário ou senha Incorreto!!");
				}
				conexao.FecharBanco();
			}
		});
				contentPane.setLayout(null);
				
						JLabel lblSenha = new JLabel("Senha:");
						lblSenha.setBounds(234, 120, 48, 14);
						contentPane.add(lblSenha);
						lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/cadeado.jpg")));
				lblNewLabel.setBounds(36, 54, 150, 150);
				contentPane.add(lblNewLabel);
		
				JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
				lblUsuario.setBounds(234, 68, 60, 14);
				contentPane.add(lblUsuario);
				lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		
				txtUsuario = new JTextField();
				txtUsuario.setBounds(295, 62, 150, 20);
				contentPane.add(txtUsuario);
				txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtUsuario.setColumns(10);
				
						passwordSenha = new JPasswordField();
						passwordSenha.setBounds(293, 118, 156, 20);
						contentPane.add(passwordSenha);
						passwordSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setBounds(234, 216, 88, 25);
		contentPane.add(btnEntrar);

		getRootPane().setDefaultButton(btnEntrar);

		JButton btnCancela = new JButton("Cancelar");
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuario.setText("");
				passwordSenha.setText("");
			}
		});
		btnCancela.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancela.setBounds(347, 216, 98, 25);
		contentPane.add(btnCancela);
	}
}
