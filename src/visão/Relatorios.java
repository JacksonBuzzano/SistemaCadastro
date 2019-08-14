package visão;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import conexão.ConexãoBD;
import grafico.PieChart;
import metodos.TabelaLista;
import modelo.ModeloRelatorio;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Dimension;




public class Relatorios extends JFrame {

	private JPanel contentPane;
	private JTable tabelaRelatório;
	private JTextField txtPesquisa;
	private JTextField txtLucro_1;
	private JTextField txtFinal;
	double lucroTotal = 0;
	
	
	ConexãoBD conexao = new ConexãoBD();
	ModeloRelatorio mod = new ModeloRelatorio();
	private JTextField txtLucroFinal;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios frame = new Relatorios();
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
	public Relatorios() {
		setResizable(false);
		setTitle("Relat\u00F3rio de Vendas");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 496);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setPreferredSize(new Dimension(500, 280));
        this.setLocationRelativeTo(null);

		
		
	
		
		JButton btnListar = new JButton("LUCRO TOTAL");
		btnListar.setBounds(23, 44, 142, 35);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModeloRelatorio mod = new ModeloRelatorio();
				mod.setData(txtPesquisa.getText());

				// PESQUISA OS PRODUTOS
				try {
					conexao.ConectarBanco();
					conexao.executaSQL(
							"SELECT produtos.nomePro, produtos.compraPro,produtos.vendaPro, vendas.valorVenda, vendas.dataVenda"
									+ " FROM produtos, vendas WHERE  produtos.idPro = vendas.produtoVenda");
					tabelaRelatório.setModel(new TabelaLista(conexao.rs));
				} catch (SQLException e1) {
				}

				// LUCRO DO TOTAL
				int conta = tabelaRelatório.getRowCount();
				for (int i = 0; i < conta; i++) {
					lucroTotal += (Double.parseDouble(tabelaRelatório.getValueAt(i, 3).toString())
							/ Double.parseDouble(tabelaRelatório.getValueAt(i, 2).toString()))
							* (Double.parseDouble(tabelaRelatório.getValueAt(i, 2).toString())
									- Double.parseDouble(tabelaRelatório.getValueAt(i, 1).toString()));
				}
				txtLucroFinal.setText(String.valueOf(lucroTotal));
			}
			
		});
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
		

		JButton btnNewButton = new JButton("LUCRO PRO MÊS");
		btnNewButton.setBounds(175, 44, 141, 35);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double lucroMes = 0;
				conexao.ConectarBanco();
				// LISTAR VENDAS POR MÊS
				try {
					conexao.executaSQL(
							"SELECT produtos.nomePro, produtos.compraPro,produtos.vendaPro, vendas.valorVenda, vendas.dataVenda "
									+ "FROM produtos, vendas WHERE  produtos.idPro = vendas.produtoVenda  AND dataVenda LIKE '"
									+ txtPesquisa.getText() + "%'");
					tabelaRelatório.setModel(new TabelaLista(conexao.rs));
				} catch (SQLException e1) {

				}
				// REALIZAR O LUCRO DO MÊS
				int c = tabelaRelatório.getRowCount();
				for (int i = 0; i < c; i++) {
					lucroMes += (Double.parseDouble(tabelaRelatório.getValueAt(i, 3).toString())
							/ Double.parseDouble(tabelaRelatório.getValueAt(i, 2).toString()))
							* (Double.parseDouble(tabelaRelatório.getValueAt(i, 2).toString())
									- Double.parseDouble(tabelaRelatório.getValueAt(i, 1).toString()));
				}
				txtLucroFinal.setText(String.valueOf(lucroMes));
			}
		});

		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(326, 44, 108, 35);
		txtPesquisa.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtPesquisa.setColumns(10);

		JLabel lblLucro = new JLabel("Lucro Total R$");
		lblLucro.setBounds(96, 115, 192, 32);
		lblLucro.setFont(new Font("Tahoma", Font.BOLD, 26));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 229, 768, 217);

		tabelaRelatório = new JTable();
		scrollPane.setViewportView(tabelaRelatório);

		Date data = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("MM/YYYY");
		 txtPesquisa.setText(formatar.format(data));
/*
		new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("#####,##");
			txtLucro_1 = new javax.swing.JFormattedTextField(format_textField4);
			txtLucro_1.setBounds(286, 114, 236, 35);
			txtLucro_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		} catch (Exception e) {
		}
		txtLucro_1.setColumns(10);
		*/
		JButton btnGrafico = new JButton("Mostar Gr\u00E1fico");
		btnGrafico.setBounds(311, 186, 147, 32);
		btnGrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  PieChart demo = new PieChart("Comparação", "Grafico ");
		          demo.pack();
		          demo.setVisible(true);
		         
				
			}
		});
		btnGrafico.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.setLayout(null);
		contentPane.add(btnListar);
		contentPane.add(btnNewButton);
		contentPane.add(txtPesquisa);
		contentPane.add(lblLucro);
		contentPane.add(scrollPane);
		//contentPane.add(txtLucro_1);
		contentPane.add(btnGrafico);
		
		txtLucroFinal = new JTextField();
		txtLucroFinal.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtLucroFinal.setBounds(289, 115, 217, 32);
		contentPane.add(txtLucroFinal);
		txtLucroFinal.setColumns(10);

		txtFinal = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("#.##");
		} catch (Exception e) {
		}
	}
}
