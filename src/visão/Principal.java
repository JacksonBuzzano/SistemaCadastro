package visão;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;


public class Principal extends JFrame {

	private JPanel contentPane;
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jcksb\\Desktop\\jota.jpg"));
		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(SystemColor.desktop);
		setForeground(SystemColor.inactiveCaptionText);
		setTitle("Bem Vindo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 476);
		this.setLocationRelativeTo(null);

		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastros");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmFuncionario = new JMenuItem("Funcion\u00E1rios");
		mntmFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadFuncionario funcionario = new CadFuncionario();
				funcionario.setVisible(true);
			}
		});
		
		JMenuItem mntmUsuarios = new JMenuItem("Usu\u00E1rios");
		mntmUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaUsuario usuario = new TelaUsuario();
				usuario.setVisible(true);
			}
		});
	
		mnNewMenu.add(mntmUsuarios);
		mnNewMenu.add(mntmFuncionario);
		
		JMenuItem mntmProduto = new JMenuItem("Produtos");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadProdutos produtos = new cadProdutos();
				produtos.setVisible(true);
			}
		});
		mnNewMenu.add(mntmProduto);
		
		JMenuItem mntmFornecedor = new JMenuItem("Fornecedores");
		mntmFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadFornecedor fornecedor = new CadFornecedor();
				fornecedor.setVisible(true);
			}
		});
		mnNewMenu.add(mntmFornecedor);
		
		JMenu mnNewMenu_3 = new JMenu("Usu\u00E1rios");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Lista de Usu\u00E1rios");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaUsuarios listaUsuario = new ListaUsuarios();
				listaUsuario.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_4 = new JMenu("Relat\u00F3rios");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmRelatrioDeVendas = new JMenuItem("Relat\u00F3rio de Vendas");
		mntmRelatrioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios relatorio = new Relatorios();
				relatorio.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmRelatrioDeVendas);
		
		JMenu mnNewMenu_2 = new JMenu("Vendas");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mntmVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVendas vendas = new TelaVendas();
				vendas.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmVendas);
		
		JMenu mnNewMenu_1 = new JMenu("Sair");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Sair");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair", "Sim ou não?", JOptionPane.YES_NO_OPTION);
			if(opcao == JOptionPane.YES_NO_OPTION){
				dispose();
			}else {
				
			}
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/bem vindo.png")));
		lblNewLabel.setBackground(new Color(51, 255, 255));
		lblNewLabel.setBounds(0, 0, 833, 425);
		contentPane.add(lblNewLabel);
	}
}
