package visão;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import conexão.ConexãoBD;
import java.awt.SystemColor;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelaEspera<E> extends JFrame {

	private JPanel contentPane;
	private JProgressBar Barra = new JProgressBar();
	ConexãoBD conecxao = new ConexãoBD();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEspera frame = new TelaEspera();
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
	public TelaEspera() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jcksb\\Desktop\\jota.jpg"));
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 118);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		//contentPane.setLayout(null);
		//contentPane.setLayout(null);
		
		Barra = new JProgressBar();
		Barra.setIndeterminate(true);
		Barra.setEnabled(false);
		Barra.setMaximum(1000);
		Barra.setMinimum(50);
		Barra.setForeground(new Color(50, 205, 50));
		Barra.setBounds(24, 10, 329, 17);
		Barra.setStringPainted(true);
		contentPane.add(Barra);
		new tempo().start();
		
		JLabel lblNewLabel = new JLabel("Aguarde carregando dados");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(67, 32, 249, 26);
		contentPane.add(lblNewLabel);
	}

	//Realiza o tempo da barra de pogresso
	public class tempo extends Thread{
		public void run () {
			
			while(Barra.getValue()<1000) {
				try {
					sleep(10);
					Barra.setValue(Barra.getValue()+1);
				} catch (InterruptedException e) {
					
				}
				
			}
			TelaLogin tela = new TelaLogin();
			tela.setVisible(true);
			dispose();
		}
	}
	
	
	
	
	
}
