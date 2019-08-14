package visão;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.ControleUsuario;
import modelo.ModeloUsuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class TelaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passSenha1;
	private JPasswordField passSenha2;

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario frame = new TelaUsuario();
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
	public TelaUsuario() {
		setResizable(false);
		setBackground(new Color(0, 0, 0));
		setTitle("Cadastro de Usu\u00E1rio");
		setForeground(new Color(0, 255, 255));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 659, 319);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(268, 54, 50, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Digite a Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(268, 117, 94, 15);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		txtUsuario.setBounds(348, 48, 213, 25);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passSenha1 = new JPasswordField();
		passSenha1.setFont(new Font("Dialog", Font.BOLD, 14));
		passSenha1.setBounds(372, 173, 189, 25);
		contentPane.add(passSenha1);
		
		passSenha2 = new JPasswordField();
		passSenha2.setFont(new Font("Dialog", Font.BOLD, 14));
		passSenha2.setBounds(376, 111, 185, 25);
		contentPane.add(passSenha2);
		
		JLabel lblSenha2 = new JLabel("Confirma Senha:");
		lblSenha2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha2.setBounds(268, 179, 101, 15);
		contentPane.add(lblSenha2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaUsuario.class.getResource("/imagens/usuario.jpg")));
		label.setBounds(10, 41, 225, 225);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(257, 160, 323, 53);
		contentPane.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 153, 255));
		panel_2.setBounds(257, 93, 323, 56);
		contentPane.add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 153, 255));
		panel_1.setBounds(257, 29, 323, 53);
		contentPane.add(panel_1);
		
		JButton bntSalvar = new JButton("Salvar");
		bntSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModeloUsuario mod = new ModeloUsuario();
				ControleUsuario control = new ControleUsuario();
				if (passSenha1.getText().equals(passSenha2.getText())) {
					mod.setNome(txtUsuario.getText());
					mod.setSenha1(Integer.parseInt(passSenha1.getText()));
					control.salvar(mod);
				}else{
				JOptionPane.showMessageDialog(null, "As senhas não correspondem!");
				}
				txtUsuario.setText("");
				passSenha1.setText("");
				passSenha2.setText("");
			}
		});
		bntSalvar.setFont(new Font("Tahoma", Font.BOLD, 13));
		bntSalvar.setBounds(299, 223, 86, 25);
		contentPane.add(bntSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtUsuario.setText("");
				passSenha1.setText("");
				passSenha2.setText("");
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(440, 223, 101, 25);
		contentPane.add(btnCancelar);
	}
}
